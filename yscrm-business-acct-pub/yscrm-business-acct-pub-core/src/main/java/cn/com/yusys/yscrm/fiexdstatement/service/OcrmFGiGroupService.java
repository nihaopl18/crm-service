package cn.com.yusys.yscrm.fiexdstatement.service;

import cn.com.yusys.yscrm.custmgr.domain.DateUtils;
import cn.com.yusys.yscrm.fiexdstatement.repository.mapper.OcrmFGiGroupMapper;
import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OcrmFGiGroupService extends CommonService {

    @Autowired
    private OcrmFGiGroupMapper ocrmFGiGroupMapper;

    @Override
    protected CommonMapper getMapper() {
        return ocrmFGiGroupMapper;
    }

    @Autowired
    private UaaClient uaaClient;

    //总行
    @Value("${role.headOffice}")
    private String headOffice;
    //总行理财个贷主管
    @Value("${role.headOfficeB}")
    private String headOfficeB;
    //分行
    @Value("${role.branch}")
    private String branch;
    //支行
    @Value("${role.subbranch}")
    private String subbranch;
    //客户经理
    @Value("${role.customerManage}")
    private String  customerManage;
    //团队
    @Value("${role.patrolLeader}")
    private String patrolLeader;

    private static String headOrgId = "500"; //总行

    public List<Map<String, Object>> queryList(QueryModel queryModel) {
        Map<String, Object> map = new HashMap<>();
        String dataDate=(String)queryModel.getCondition().get("dataDate"); //日期天数
        String targetId=(String)queryModel.getCondition().get("targetId"); //客户经理
        String aumBalanceStart=(String)queryModel.getCondition().get("aumBalanceStart");
        String aumBalanceEnd=(String)queryModel.getCondition().get("aumBalanceEnd");
        String mktRespPerson=(String)queryModel.getCondition().get("mktRespPerson"); //机构
        map.put("dataDate", dataDate);
        map.put("targetId", targetId);
        map.put("aumBalanceStart", aumBalanceStart);
        map.put("aumBalanceEnd", aumBalanceEnd);
        if (!headOrgId.equals(mktRespPerson)){
            map.put("mktRespPerson", mktRespPerson);
        }
        PageHelper.startPage(queryModel.getPage(), queryModel.getSize());

        ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken()); //获取当前登录人信息
        UserInfoDTO user = dto.getBody(); //获取当前登录者信息
        map.put("userCode", user.getLoginCode());  //登录用户编码
        map.put("orgCode", user.getOrg().getCode());  //登录用户所属机构编码
        //判断属于理财还是个贷
        String role = getRole();
        String roleType = "";
        if ("R003,R016,R019,R020".contains(role)){
            roleType = "2";
        }else if ("R002,R018,R015,R017,R021".contains(role)){
            roleType = "1";
        }
        map.put("roleType",roleType);
        map.put("sqlDataAuth",getDataAuth(role,roleType)); //拼接权限控制sql语句

        List<Map<String, Object>> list = ocrmFGiGroupMapper.queryList(map);
        PageHelper.clearPage();
        return list;
    }

    public void export(HttpServletResponse response, QueryModel queryModel) throws IOException {
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码
        String fileName = URLEncoder.encode("管户", "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");

        //List<Map<String, Object>> list = queryList(queryModel);
        Map<String, Object> map = new HashMap<>();
        String dataDate=(String)queryModel.getCondition().get("dataDate"); //日期天数
        String targetId=(String)queryModel.getCondition().get("targetId"); //客户经理
        String aumBalanceStart=(String)queryModel.getCondition().get("aumBalanceStart");
        String aumBalanceEnd=(String)queryModel.getCondition().get("aumBalanceEnd");
        String mktRespPerson=(String)queryModel.getCondition().get("mktRespPerson"); //机构
        String exportIds=(String)queryModel.getCondition().get("exportIds");
        //List<Integer> ids=(List) queryModel.getCondition().get("ids"); //批量导出
        map.put("dataDate", dataDate);
        map.put("targetId", targetId);
        map.put("aumBalanceStart", aumBalanceStart);
        map.put("aumBalanceEnd", aumBalanceEnd);
        if (!headOrgId.equals(mktRespPerson)){
            map.put("mktRespPerson", mktRespPerson);
        }

        ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken()); //获取当前登录人信息
        UserInfoDTO user = dto.getBody(); //获取当前登录者信息
        map.put("userCode", user.getLoginCode());  //登录用户编码
        map.put("orgCode", user.getOrg().getCode());  //登录用户所属机构编码
        //判断属于理财还是个贷
        String role = (String) queryModel.getCondition().get("selectRole");
        String roleType = "";
        if ("R003,R016,R019,R020".contains(role)){
            roleType = "2";
        }else if ("R002,R018,R015,R017,R021".contains(role)){
            roleType = "1";
        }
        map.put("roleType",roleType);
        map.put("sqlDataAuth",getDataAuth(role,roleType)); //拼接权限控制sql语句
        if (StringUtils.isNotEmpty(exportIds)) {
            String[] cust = exportIds.split(",");
            String str = "";
            str = "in(";
            for (int i = 0; i < cust.length; i++) {
                str += "'" + cust[i] + "',";
            }
            str = str.substring(0, str.length() - 1);
            str += ")";
            map.put("exportIds",str);
        }


        List<Map<String, Object>> resultList = ocrmFGiGroupMapper.queryList(map);

        exportFile(response, "group_template.xlsx", "管户", resultList,dataDate);
    }

    private void exportFile(HttpServletResponse response, String fileName, String title, List list,String dataDate) throws IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("date", dataDate);
        String templateFileName = "templates" + File.separator + fileName;
        ExcelWriter excelWriter = null;
        excelWriter = EasyExcel.write(response.getOutputStream())
                .withTemplate(new ClassPathResource(templateFileName).getInputStream()).build();
        WriteSheet writeSheet = EasyExcel.writerSheet().build();
        // 填充集合 data
        excelWriter.fill(list, writeSheet);
        excelWriter.fill(map, writeSheet);
        // 关闭流
        excelWriter.finish();
    }

    /**
     * 拼接sql语句
     * @param role
     * @return
     */
    public String getDataAuth(String role,String roleType){
        String dataAuth = "";
        if (branch.contains(role)){ //分行
            dataAuth = "and S.ORG_ID like concat(#{orgCode},'%') AND S.MGR_TYPE='1'";
        }else if (subbranch.contains(role)){ //支行
            dataAuth = "and S.ORG_ID = #{orgCode} AND S.MGR_TYPE='1'";
        }else if (customerManage.contains(role)){ //客户经理
            dataAuth = "and S.MGR_ID = #{userCode} AND S.MGR_TYPE='1'";
        }else if (patrolLeader.contains(role)){ //团队长
            dataAuth = "and S.MGR_ID IN (SELECT tmm.USER_ID FROM OCRM_F_CM_TEAM_CUST_MANAGER tmm " +
                    " inner join OCRM_F_CM_MKT_TEAM tm  on tm.mkt_team_id = tmm.mkt_team_id " +
                    "  WHERE TEAM_LEADER_ID = #{userCode}) AND S.MGR_TYPE='1'";
        }
        return dataAuth;
    }

    /**
     * 获取当前角色
     * @return
     */
    public static String getRole() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        String selectRole = request.getHeader("selectRole");
        return selectRole;
    }

}
