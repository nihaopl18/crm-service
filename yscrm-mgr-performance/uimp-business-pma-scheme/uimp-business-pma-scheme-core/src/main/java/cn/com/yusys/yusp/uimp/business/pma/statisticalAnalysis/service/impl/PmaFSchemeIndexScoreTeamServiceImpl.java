package cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.service.impl;

import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.ObjBean;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;
import cn.com.yusys.yusp.uimp.base.service.UserInfoService;
import cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.domain.dto.PmaFSchemeIndexScoreSumTeam;
import cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.domain.form.*;
import cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.domain.vo.PmaFSchemeIndexScoreTeamVo;
import cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.domain.vo.SchemeScoreInfoVo;
import cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.repository.mapper.PmaFSchemeIndexScoreTeamMapper;
import cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.service.PmaFSchemeIndexScoreTeamService;
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
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;

/**
 * @author sandMan
 * @date 2022/5/13 - 16:52
 */
@Service("PmaFSchemeIndexScoreTeamService")
public class PmaFSchemeIndexScoreTeamServiceImpl implements PmaFSchemeIndexScoreTeamService {
    @Autowired
    private UaaClient uaaClient;
    @Autowired
    private UserInfoService userInfoService;
    private String Role;
    //总行授权主管，总行综合管理用户，总行业务管理用户，总行销售推动用户，分行综合管理岗，分行副行长，系统管理员
    public static final String MGR_ROLE_1 = "R006,R008,R009,R010,RO13,R005,R001,R022";
    //分行个贷主管
    public static final String MGR_ROLE_2 = "R016";
    //分行理财主管
    public static final String MGR_ROLE_3 = "R015";
    //团队长
    public static final String MGR_ROLE_4 = "R018,R019,R004,115";
    //支行行长(理财)
    public static final String MGR_ROLE_5 = "R017";
    //总行
    public static final String MGR_ROLE_6 = "R006,R008,R009,R010,R001";
    //分行
    public static final String MGR_ROLE_7 = "R013,R005,R016,R015";
    //客户经理
    public static final String MGR_ROLE_8 = "R002,R003";
    //机构管理员R010 业绩管理员R011
    public static final String MGR_ROLE_9 = "R010,R011";
    private static final String MGR_TEAM_LEADER = "115";

    private final PmaFSchemeIndexScoreTeamMapper mapper;

    public PmaFSchemeIndexScoreTeamServiceImpl(PmaFSchemeIndexScoreTeamMapper pmaFSchemeIndexScoreTeamMapper) {
        this.mapper = pmaFSchemeIndexScoreTeamMapper;
    }

    @Override
    public List<PmaFSchemeIndexScoreTeamVo> teamAssessSelf(QueryConditionForm queryConditionForm) {
        String condition = queryConditionForm.getCondition();
        UserInfoDTO userInfoDTO = getUserInfoDTO();
        String role = getRoles();
        TeamAssessForm teamAssessForm = null;
        if (condition != null) {
            teamAssessForm = JSONObject.parseObject(condition, TeamAssessForm.class);
        }
        List<PmaFSchemeIndexScoreTeamVo> pmaFSchemeIndexScoreTeamVo = null;

        if (MGR_ROLE_1.contains(role) || MGR_ROLE_9.contains(role)) {
            //查询当前登陆角色的org_id
            String orgId = userInfoDTO.getOrg().getId();
            //查询下属客户经理团队
            List<String> managerTeamList = mapper.selectManagerTeam(orgId);

            if (StringUtils.isEmpty(teamAssessForm.getTeamId())) {
                teamAssessForm.setTeamIdList(managerTeamList);
            } else {
                List<String> teamId = new ArrayList<>();
                teamId.add(teamAssessForm.getTeamId());
                teamAssessForm.setTeamIdList(teamId);
            }

            if (teamAssessForm.getTeamIdList() == null || teamAssessForm.getTeamIdList().size() <= 0) {
                return null;
            } else {
                //按排名递减查
                if (StringUtils.isEmpty(teamAssessForm.getRankMethod()) || teamAssessForm.getRankMethod().equals("desc")) {
                    PageHelper.startPage(queryConditionForm.getPage(), queryConditionForm.getSize());
                    pmaFSchemeIndexScoreTeamVo = mapper.teamAssessSelfDesc(teamAssessForm);
                    PageHelper.clearPage();
                } else {
                    //按排名递增查
                    PageHelper.startPage(queryConditionForm.getPage(), queryConditionForm.getSize());
                    pmaFSchemeIndexScoreTeamVo = mapper.teamAssessSelfAsc(teamAssessForm);
                    PageHelper.clearPage();
                }
            }

        } else if (MGR_ROLE_4.contains(role)) {//团队长
            String userId = userInfoDTO.getUserId();
            //查询该用户下属团队
            List<String> managerTeamList = mapper.selectManagerTeamList(userId);

            if (StringUtils.isEmpty(teamAssessForm.getTeamId())) {
                teamAssessForm.setTeamIdList(managerTeamList);
            } else {
                List<String> teamId = new ArrayList<>();
                teamId.add(teamAssessForm.getTeamId());
                teamAssessForm.setTeamIdList(teamId);
            }

            if (teamAssessForm.getTeamIdList() == null || teamAssessForm.getTeamIdList().size() <= 0) {
                return null;
            } else {
                //按排名递减查
                if (StringUtils.isEmpty(teamAssessForm.getRankMethod()) || teamAssessForm.getRankMethod().equals("desc")) {
                    PageHelper.startPage(queryConditionForm.getPage(), queryConditionForm.getSize());
                    pmaFSchemeIndexScoreTeamVo = mapper.teamAssessSelfDesc(teamAssessForm);
                    PageHelper.clearPage();
                } else {
                    //按排名递增查
                    PageHelper.startPage(queryConditionForm.getPage(), queryConditionForm.getSize());
                    pmaFSchemeIndexScoreTeamVo = mapper.teamAssessSelfAsc(teamAssessForm);
                    PageHelper.clearPage();
                }
            }
        }
        return pmaFSchemeIndexScoreTeamVo;
    }

    @Override
    public List<SchemeScoreInfoVo> teamAssessIndexInfo(QueryConditionForm queryConditionForm) {
        String condition = queryConditionForm.getCondition();
        QueryTeamScoreInfoForm queryTeamScoreInfoForm = null;
        if (condition != null) {
            queryTeamScoreInfoForm = JSONObject.parseObject(condition, QueryTeamScoreInfoForm.class);
        }
        PmaFSchemeIndexScoreSumTeam pmaFSchemeIndexScoreSumTeam = mapper.selectScheme(queryTeamScoreInfoForm);
        String id = pmaFSchemeIndexScoreSumTeam.getId();
        String scoreRankMethod = queryTeamScoreInfoForm.getScoreRankMethod();
        String compRateRankMethod = queryTeamScoreInfoForm.getCompRateRankMethod();
        String indexId = queryTeamScoreInfoForm.getIndexId();
        List<SchemeScoreInfoVo> schemeScoreInfoVo = null;
        if (scoreRankMethod.equals("asc") && compRateRankMethod.equals("asc")) {
            PageHelper.startPage(queryConditionForm.getPage(), queryConditionForm.getSize());
            schemeScoreInfoVo = mapper.teamAssessIndexInfoAscAndAsc(id, indexId);
            PageHelper.clearPage();
        } else if (scoreRankMethod.equals("asc") && compRateRankMethod.equals("desc")) {
            PageHelper.startPage(queryConditionForm.getPage(), queryConditionForm.getSize());
            schemeScoreInfoVo = mapper.teamAssessIndexInfoAscAndDesc(id, indexId);
            PageHelper.clearPage();
        } else if (scoreRankMethod.equals("desc") && compRateRankMethod.equals("asc")) {
            PageHelper.startPage(queryConditionForm.getPage(), queryConditionForm.getSize());
            schemeScoreInfoVo = mapper.teamAssessIndexInfoDescAndAsc(id, indexId);
            PageHelper.clearPage();
        } else if (scoreRankMethod.equals("desc") && compRateRankMethod.equals("desc")) {
            PageHelper.startPage(queryConditionForm.getPage(), queryConditionForm.getSize());
            schemeScoreInfoVo = mapper.teamAssessIndexInfoDescAndDesc(id, indexId);
            PageHelper.clearPage();
        }
        return schemeScoreInfoVo;
    }

    @Override
    public void teamAssessExportExcelAll(TeamAssessForm teamAssessForm, HttpServletRequest request, HttpServletResponse response) {
        UserInfoDTO userInfoDTO = getUserInfoDTO();
//        String role = getRoles();
        List<TeamExcleData> teamExcleData = new ArrayList<>();
        //excel的名称
        String fileName = "客户团队考核评分" + "_" + FastDateFormat.getInstance("yyyyMMddHHmmssSSS").format(new Date());
        String sheetName = "客户团队考核评分";
        if (teamAssessForm.getDataIds() == null) {
            //团队长
            if (isMgrTeamLeader(userInfoDTO) && StringUtils.isEmpty(teamAssessForm.getTeamId())) {
                String userId = userInfoDTO.getUserId();
                //查询该用户下属团队
                List<String> managerTeamList = mapper.selectManagerTeamList(userId);
                if (managerTeamList != null && !managerTeamList.isEmpty()) {
                    teamAssessForm.setTeamIdList(managerTeamList);
                }
            }
        }
        teamExcleData = mapper.selectAllToExcel(teamAssessForm);
        writeExcel(response, teamExcleData, fileName, sheetName, new TeamExcleData());
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

    public String getRoles() {
        ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
        String role = "";
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        String selectRole = request.getHeader("selectRole");
        for (ObjBean obj : dto.getBody().getRoles()) {
            if (obj.getId().equals(selectRole)) {
                role = obj.getCode();
            }
        }
        if ("".equals(role)) {
            role = this.Role;
        }
        return role;
    }

    public Map<String, Object> getQueryMap() {
        ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
        Map<String, Object> queryMap = new HashMap<>();
        UserInfoDTO user = dto.getBody();
        queryMap.put("userCode", user.getLoginCode());
        queryMap.put("orgCode", user.getOrg().getCode());
        //String lastMonthTime = DateUtils.getMonthTime(-1);
        //queryMap.put("startTime", lastMonthTime);
        String roleType = "";
        String role = getRoles();
        if ("R003,R016,R019,R020".contains(role)) {
            roleType = "2";
        } else if ("R002,R018,R015,R017,R021".contains(role)) {
            roleType = "1";
        }
        return queryMap;
    }

    public UserInfoDTO getUserInfoDTO() {
        ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
        UserInfoDTO user = dto.getBody();
        return user;
    }

    private boolean isMgrTeamLeader(UserInfoDTO userInfo) {
        List<ObjBean> roles = userInfo.getRoles();

        if (CollectionUtils.isEmpty(roles)) {
            throw new RuntimeException("用户角色信息不存在");
        }
        if (roles.size() == 1 && roles.get(0).getCode().equals(MGR_TEAM_LEADER)) {
            return true;
        }
        return false;
    }

    ;
}
