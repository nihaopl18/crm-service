package cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.service.impl;

import cn.com.yusys.yusp.admin.service.SystemUtilService;
import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.ObjBean;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;
import cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.domain.dto.PmaFSchemeIndexScoreSumMgr;
import cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.domain.form.ManagerAssessForm;
import cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.domain.form.QueryConditionForm;
import cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.domain.form.QueryScoreInfoForm;
import cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.domain.form.MgrExcleData;
import cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.domain.vo.PmaFSchemeIndexScoreMgrVo;
import cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.domain.vo.SchemeScoreInfoVo;
import cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.repository.mapper.PmaFSchemeIndexScoreMgrMapper;
import cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.service.PmaFSchemeIndexScoreMgrService;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.grapecity.documents.excel.S;
import org.apache.commons.lang.time.FastDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author sandMan
 * @date 2022/5/9 - 17:18
 */
@Service("PmaFSchemeIndexScoreMgrService")
public class PmaFSchemeIndexScoreMgrServiceImpl implements PmaFSchemeIndexScoreMgrService {
    @Value("${info.excel.temp-file-dir}")
    private String excelTempFileDir;
    @Autowired
    private UaaClient uaaClient;
    @Autowired
    private SystemUtilService service;
    private final static String CUST_MGR_ROLE="15";
    private final PmaFSchemeIndexScoreMgrMapper mapper;

    public PmaFSchemeIndexScoreMgrServiceImpl(PmaFSchemeIndexScoreMgrMapper pmaFSchemeIndexScoreMgrMapper) {
        this.mapper = pmaFSchemeIndexScoreMgrMapper;
    }
    @Override
    public List<PmaFSchemeIndexScoreMgrVo> mgrAssessSelf(QueryConditionForm queryConditionForm) {
        String condition = queryConditionForm.getCondition();
        UserInfoDTO userInfoDTO =getUserInfoDTO();
        String code = userInfoDTO.getOrg().getId();
        ManagerAssessForm managerAssessForm =null;
        if (condition != null) {
            managerAssessForm = JSONObject.parseObject(condition, ManagerAssessForm.class);
        }

        List<String> managerIdString=new ArrayList<>();
        //不是客户经理,查出所辖的客户经理
        if (!isCustMgr(userInfoDTO)){
            managerIdString=getManagerIdList(code);
        }else {//是客户经理，只查询自己的数据
            //不能查询其他人的数据
            if(!StringUtils.isEmpty(managerAssessForm.getManagerId()) && !userInfoDTO.getUserId().equals(managerAssessForm.getManagerId())){
                return null;
            }
            managerIdString.add(userInfoDTO.getUserId());
        }
        managerAssessForm.setManagerIdList(managerIdString);
        List<PmaFSchemeIndexScoreMgrVo> pmaFSchemeIndexScoreMgrVos;
        //按排名递减查
        if (StringUtils.isEmpty(managerAssessForm.getRankMethod())|| managerAssessForm.getRankMethod().equals("desc")  ){
            PageHelper.startPage(queryConditionForm.getPage(), queryConditionForm.getSize());
            pmaFSchemeIndexScoreMgrVos = mapper.mgrAssessSelfDesc(managerAssessForm);
            PageHelper.clearPage();
        }else {
            //按排名递增查
            PageHelper.startPage(managerAssessForm.getPage(), managerAssessForm.getSize());
            pmaFSchemeIndexScoreMgrVos = mapper.mgrAssessSelfAsc(managerAssessForm);
            PageHelper.clearPage();
        }
        return pmaFSchemeIndexScoreMgrVos;
    }
    @Override
    public List<String> getManagerIdList(String code){
        //查询出客户经理roleId
        String roleId=mapper.selectRoleId(CUST_MGR_ROLE);
        //查询出所有的客户经理UserId
        List<String> managerList=mapper.selectAllManager(roleId);
        //查询出该机构下的客户经理
        List<String> custManagerList=mapper.selectManagerList(code,managerList);


        return custManagerList;
    }
    @Override
    public List<SchemeScoreInfoVo> mgrAssessIndexInfo(QueryConditionForm queryConditionForm) {
        String condition = queryConditionForm.getCondition();
        QueryScoreInfoForm queryScoreInfoForm=null;
        if (condition != null) {
            queryScoreInfoForm = JSONObject.parseObject(condition, QueryScoreInfoForm.class);
        }
        PmaFSchemeIndexScoreSumMgr pmaFSchemeIndexScoreSumMgr=mapper.selectScheme(queryScoreInfoForm);
        String id=pmaFSchemeIndexScoreSumMgr.getId();
        String scoreRankMethod = queryScoreInfoForm.getScoreRankMethod();
        String compRateRankMethod = queryScoreInfoForm.getCompRateRankMethod();
        String indexId=queryScoreInfoForm.getIndexId();
        List<SchemeScoreInfoVo> schemeScoreInfoVo=null;
        if("asc".equals(scoreRankMethod) && "asc".equals(compRateRankMethod)){
            PageHelper.startPage(queryConditionForm.getPage(), queryConditionForm.getSize());
            schemeScoreInfoVo= mapper.mgrAssessIndexInfoAscAndAsc(id,indexId);
            PageHelper.clearPage();
        }else if ("asc".equals(scoreRankMethod) && "desc".equals(compRateRankMethod)){
            PageHelper.startPage(queryConditionForm.getPage(), queryConditionForm.getSize());
            schemeScoreInfoVo= mapper.mgrAssessIndexInfoAscAndDesc(id,indexId);
            PageHelper.clearPage();
        }else if("desc".equals(scoreRankMethod) && "asc".equals(compRateRankMethod)){
            PageHelper.startPage(queryConditionForm.getPage(), queryConditionForm.getSize());
            schemeScoreInfoVo= mapper.mgrAssessIndexInfoDescAndAsc(id,indexId);
            PageHelper.clearPage();
        }else if("desc".equals(scoreRankMethod) && "desc".equals(compRateRankMethod)) {
            PageHelper.startPage(queryConditionForm.getPage(), queryConditionForm.getSize());
            schemeScoreInfoVo = mapper.mgrAssessIndexInfoDescAndDesc(id,indexId);
            PageHelper.clearPage();
        }
        return schemeScoreInfoVo;
    }

    @Override
    public List<MgrExcleData> selectAll(List<String> managerIdList) {
        return mapper.selectAll(managerIdList);
    }
    @Override
    public List<MgrExcleData> selectSelf(String userId) {
        return mapper.selectSelf(userId);
    }

    @Override
    public void teamAssessExportExcelAll(ManagerAssessForm model, HttpServletRequest request, HttpServletResponse response) {
        UserInfoDTO userInfoDTO =getUserInfoDTO();
        String code = userInfoDTO.getOrg().getId();
        String fileName ="客户经理考核评分" + "_"  + FastDateFormat.getInstance("yyyyMMddHHmmssSSS").format(new Date());
        String sheetName = "客户经理考核评分";
        List<MgrExcleData> mgrExcleData =new ArrayList<>();
        List<String> managerIdString=new ArrayList<>();
        //查询所有的数据

        if (model.getDataIds() == null) {
            if (!isCustMgr(userInfoDTO) && StringUtils.isEmpty(model.getManagerId())){
                managerIdString=getManagerIdList(code);
            }else {
                managerIdString.add(userInfoDTO.getUserId());
            }
        }

        model.setManagerIdList(managerIdString);
        mgrExcleData = mapper.selectAllExcelData(model);
        writeExcel(response, mgrExcleData, fileName, sheetName, new MgrExcleData());
    }

    public static void writeExcel(HttpServletResponse response, List<? extends BaseRowModel> list,
                                  String fileName, String sheetName, BaseRowModel object) {
        ExcelWriter writer = new ExcelWriter(getOutputStream(fileName, response), ExcelTypeEnum.XLSX);
        Sheet sheet = new Sheet(1, 0, object.getClass());
        sheet.setSheetName(sheetName);
        writer.write(list, sheet);
        writer.finish();
    }
    /**
     * 导出文件时为Writer生成OutputStream
     */
    private static OutputStream getOutputStream(String fileName, HttpServletResponse response) {
        //创建本地文件
        String filePath = fileName + ".xlsx";
        File dbfFile = new File(filePath);
        try {
            if (!dbfFile.exists() || dbfFile.isDirectory()) {
                dbfFile.createNewFile();
            }
            fileName = new String(filePath.getBytes(), "ISO-8859-1");
            response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
            return response.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public UserInfoDTO getUserInfoDTO() {
        ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
        UserInfoDTO user = dto.getBody();
        return user;
    }
    // 仅为客户经理
    private boolean isCustMgr(UserInfoDTO userInfo){
        List<ObjBean> roles = userInfo.getRoles();

        if(CollectionUtils.isEmpty(roles)){
            throw new RuntimeException("用户角色信息不存在");
        }
        return roles.size() == 1 && roles.get(0).getCode().equals(CUST_MGR_ROLE);
    };
}
