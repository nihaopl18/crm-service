package cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.service.impl;

import cn.com.yusys.yusp.admin.service.SystemUtilService;
import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;
import cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.domain.dto.PmaFSchemeIndexScoreSumOrg;
import cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.domain.form.*;
import cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.domain.vo.PmaFSchemeIndexScoreOrgVo;
import cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.domain.vo.SchemeScoreInfoVo;
import cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.repository.mapper.PmaFSchemeIndexScoreOrgMapper;
import cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.service.PmaFSchemeIndexScoreOrgService;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang.time.FastDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author sandMan
 * @date 2022/5/15 - 15:03
 */
@Service("PmaFSchemeIndexScoreOrgService")
public class PmaFSchemeIndexScoreOrgServiceImpl implements PmaFSchemeIndexScoreOrgService {
    @Autowired
    private UaaClient uaaClient;
    @Autowired
    private SystemUtilService service;

    private final PmaFSchemeIndexScoreOrgMapper mapper;

    public PmaFSchemeIndexScoreOrgServiceImpl(PmaFSchemeIndexScoreOrgMapper mapper) {
        this.mapper = mapper;
    }


    @Override
    public List<PmaFSchemeIndexScoreOrgVo> orgAssessSelf(QueryConditionForm queryConditionForm) {
        String condition = queryConditionForm.getCondition();
        UserInfoDTO userInfoDTO = getUserInfoDTO();
        String code = userInfoDTO.getOrg().getId();
        List<Map<String, Object>> orgList = service.getOrgByParam(code, "", false);
        List<String> orgCodeList = new ArrayList<>();
        for (Map<String, Object> stringObjectMap : orgList) {
            orgCodeList.add((String) stringObjectMap.get("orgCode"));
        }
//        String role = getRoles();
        OrgAssessForm orgAssessForm = null;
        if (condition != null) {
            orgAssessForm = JSONObject.parseObject(condition, OrgAssessForm.class);
        }

        List<PmaFSchemeIndexScoreOrgVo> pmaFSchemeIndexScoreOrgVo = null;
        if (StringUtils.isEmpty(orgAssessForm.getOrgId())) {
            orgAssessForm.setOrgIdList(orgCodeList);
        } else {
            List<String> orgId = new ArrayList<>();
            orgId.add(orgAssessForm.getOrgId());
            orgAssessForm.setOrgIdList(orgId);
        }

        //按排名递减查
        if (StringUtils.isEmpty(orgAssessForm.getRankMethod()) || orgAssessForm.getRankMethod().equals("desc")) {
            PageHelper.startPage(queryConditionForm.getPage(), queryConditionForm.getSize());
            pmaFSchemeIndexScoreOrgVo = mapper.orgAssessSelfDesc(orgAssessForm);
            PageHelper.clearPage();
        } else {
            //按排名递增查
            PageHelper.startPage(queryConditionForm.getPage(), queryConditionForm.getSize());
            pmaFSchemeIndexScoreOrgVo = mapper.orgAssessSelfAsc(orgAssessForm);
            PageHelper.clearPage();
        }
        return pmaFSchemeIndexScoreOrgVo;
    }

    @Override
    public List<SchemeScoreInfoVo> orgAssessIndexInfo(QueryConditionForm queryConditionForm) {
        String condition = queryConditionForm.getCondition();
        QueryOrgScoreInfoForm queryOrgScoreInfoForm = null;
        if (condition != null) {
            queryOrgScoreInfoForm = JSONObject.parseObject(condition, QueryOrgScoreInfoForm.class);
        }
        PmaFSchemeIndexScoreSumOrg pmaFSchemeIndexScoreSumOrg = mapper.selectScheme(queryOrgScoreInfoForm);
        String id = pmaFSchemeIndexScoreSumOrg.getId();
        String scoreRankMethod = queryOrgScoreInfoForm.getScoreRankMethod();
        String compRateRankMethod = queryOrgScoreInfoForm.getCompRateRankMethod();
        String indexId = queryOrgScoreInfoForm.getIndexId();
        List<SchemeScoreInfoVo> schemeScoreInfoVo = null;
        if (scoreRankMethod.equals("asc") && compRateRankMethod.equals("asc")) {
            PageHelper.startPage(queryConditionForm.getPage(), queryConditionForm.getSize());
            schemeScoreInfoVo = mapper.orgAssessIndexInfoAscAndAsc(id, indexId);
            PageHelper.clearPage();
        } else if (scoreRankMethod.equals("asc") && compRateRankMethod.equals("desc")) {
            PageHelper.startPage(queryConditionForm.getPage(), queryConditionForm.getSize());
            schemeScoreInfoVo = mapper.orgAssessIndexInfoAscAndDesc(id, indexId);
            PageHelper.clearPage();
        } else if (scoreRankMethod.equals("desc") && compRateRankMethod.equals("asc")) {
            PageHelper.startPage(queryConditionForm.getPage(), queryConditionForm.getSize());
            schemeScoreInfoVo = mapper.orgAssessIndexInfoDescAndAsc(id, indexId);
            PageHelper.clearPage();
        } else if (scoreRankMethod.equals("desc") && compRateRankMethod.equals("desc")) {
            PageHelper.startPage(queryConditionForm.getPage(), queryConditionForm.getSize());
            schemeScoreInfoVo = mapper.orgAssessIndexInfoDescAndDesc(id, indexId);
            PageHelper.clearPage();
        }
        return schemeScoreInfoVo;
    }

    @Override
    public void orgAssessExportExcelAll(OrgAssessForm orgAssessForm, HttpServletRequest request, HttpServletResponse response) {
        UserInfoDTO userInfoDTO = getUserInfoDTO();
        String orgId = userInfoDTO.getOrg().getId();
        String fileName = "机构考核评分" + "_" + FastDateFormat.getInstance("yyyyMMddHHmmssSSS").format(new Date());
        String sheetName = "机构考核评分";
        List<OrgExcleData> orgExcleData = new ArrayList<>();
        //查询出下属所有机构
        if (orgAssessForm.getDataIds() == null && StringUtils.isEmpty(orgAssessForm.getOrgId())) {
            //团队长
            List<Map<String, Object>> orgList = service.getOrgByParam(orgId, "", false);
            List<String> orgCodeList = new ArrayList<>();
            for (Map<String, Object> stringObjectMap : orgList) {
                orgCodeList.add((String) stringObjectMap.get("orgCode"));
            }
            if (orgCodeList != null && !orgCodeList.isEmpty()) {
                orgAssessForm.setOrgIdList(orgCodeList);
            }
        }
        orgExcleData = mapper.selectAllToExcel(orgAssessForm);
        writeExcel(response, orgExcleData, fileName, sheetName, new OrgExcleData());
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
}
