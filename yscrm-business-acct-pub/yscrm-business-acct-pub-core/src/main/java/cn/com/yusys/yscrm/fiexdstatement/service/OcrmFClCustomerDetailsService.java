package cn.com.yusys.yscrm.fiexdstatement.service;

import cn.com.yusys.yscrm.custmgr.domain.DateUtils;
import cn.com.yusys.yscrm.fiexdstatement.domain.OcrmFClBranchtotal;
import cn.com.yusys.yscrm.fiexdstatement.domain.OcrmFClCustomerDetails;
import cn.com.yusys.yscrm.fiexdstatement.domain.OcrmFClStatement;
import cn.com.yusys.yscrm.fiexdstatement.repository.mapper.OcrmFClCustomerDetailsMapper;
import cn.com.yusys.yscrm.pcrm.common.remindInfo.utils.ExportExcelUtils2;
import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
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
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OcrmFClCustomerDetailsService extends CommonService {

    @Autowired
    private OcrmFClCustomerDetailsMapper ocrmFClCustomerDetailsMapper;

    @Override
    protected CommonMapper getMapper() {
        return ocrmFClCustomerDetailsMapper;
    }

    private static String isPeopleCode = "1"; //是否民生 ，1：是、0：否

    private static String headOrgId = "500"; //总行

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

    public List<Map<String, Object>> queryBranchList(QueryModel queryModel) {
        PageHelper.startPage(queryModel.getPage(), queryModel.getSize());
        Map<String, Object> map = new HashMap<String, Object>();
        String custGrade=(String)queryModel.getCondition().get("custGrade");
        String dataDate=(String)queryModel.getCondition().get("dataDate");
        String aumBalanceStart=(String)queryModel.getCondition().get("aumBalanceStart");
        String aumBalanceEnd=(String)queryModel.getCondition().get("aumBalanceEnd");
        String isPeople=(String)queryModel.getCondition().get("isPeople");
        String mktRespPerson = (String)queryModel.getCondition().get("mktRespPerson");
        map.put("dataDate",dataDate);
        map.put("aumBalanceStart",aumBalanceStart);
        map.put("aumBalanceEnd",aumBalanceEnd);
        map.put("isPeople",isPeople);
        if (!headOrgId.equals(mktRespPerson)){
            map.put("mktRespPerson",mktRespPerson);
        }
        if (StringUtils.isNotEmpty(custGrade)) {
            String[] cust = custGrade.split(",");
            String str = "";
            str = "in(";
            for (int i = 0; i < cust.length; i++) {
                str += "'" + cust[i] + "',";
            }
            str = str.substring(0, str.length() - 1);
            str += ")";
            map.put("custGrade",str);
        }

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


        List<Map<String, Object>> list = ocrmFClCustomerDetailsMapper.queryBranchListUnPeople(map);
        PageHelper.clearPage();
        return list;
    }

    public void export(HttpServletResponse response, QueryModel queryModel) throws IOException {
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码
        String fileName = URLEncoder.encode("分行销售团队", "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
        //List<Map<String, Object>> list = queryBranchList(queryModel);
        Map<String, Object> map = new HashMap<String, Object>();
        String custGrade=(String)queryModel.getCondition().get("custGrade");
        String dataDate=(String)queryModel.getCondition().get("dataDate");
        String aumBalanceStart=(String)queryModel.getCondition().get("aumBalanceStart");
        String aumBalanceEnd=(String)queryModel.getCondition().get("aumBalanceEnd");
        String isPeople=(String)queryModel.getCondition().get("isPeople");
        String ecifCustids=(String)queryModel.getCondition().get("ecifCustids");
        String mktRespPerson = (String)queryModel.getCondition().get("mktRespPerson");
        String exportIds=(String)queryModel.getCondition().get("exportIds"); //批量导出
        map.put("dataDate",dataDate);
        if (!headOrgId.equals(mktRespPerson)){
            map.put("mktRespPerson",mktRespPerson);
        }
        map.put("aumBalanceStart",aumBalanceStart);
        map.put("aumBalanceEnd",aumBalanceEnd);
        map.put("isPeople",isPeople);
        if (StringUtils.isNotEmpty(custGrade)) {
            String[] cust = custGrade.split(",");
            String str = "";
            str = "in(";
            for (int i = 0; i < cust.length; i++) {
                str += "'" + cust[i] + "',";
            }
            str = str.substring(0, str.length() - 1);
            str += ")";
            map.put("custGrade",str);
        }
        if (ecifCustids !=null && ecifCustids !=""){
            map.put("ecifCustids",ecifCustids.split(","));
        }
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

        List<Map<String, Object>> resultList = new ArrayList<>();
        List<Map<String, Object>> list = ocrmFClCustomerDetailsMapper.queryBranchListUnPeople(map);

            resultList = list;

        //设置百分数
        setPercentage(list);
        exportFile(response, "customer_template.xlsx", "客户明细", resultList,isPeople,dataDate);
    }

    private void exportFile(HttpServletResponse response, String fileName, String title, List list,String isPeople,String dataDate) throws IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        if (isPeopleCode.equals(isPeople)){
            map.put("isPeople","是");
        }else {
            map.put("isPeople","否");
        }
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
        if (headOffice.contains(role) || headOfficeB.contains(role)){ //总行
            if (roleType!=""){
                dataAuth = " AND S.MGR_TYPE=#{roleType}";
            }else {
                dataAuth = " AND S.MGR_TYPE='1' ";
            }
        }else if (branch.contains(role)){ //分行支行
            if (roleType!=""){
                dataAuth = "and S.ORG_ID like concat(#{orgCode},'%') AND S.MGR_TYPE=#{roleType}";
            }else {
                dataAuth = "and S.ORG_ID like concat(#{orgCode},'%') AND S.MGR_TYPE='1' ";
            }
        }else if (subbranch.contains(role)){
            if (roleType!=""){
                dataAuth = "and S.ORG_ID = #{orgCode}  AND S.MGR_TYPE=#{roleType}";
            }else {
                dataAuth = "and S.ORG_ID = #{orgCode}   AND S.MGR_TYPE='1' ";
            }
        }else if (customerManage.contains(role)){ //客户经理
            dataAuth = "and S.MGR_ID = #{userCode} AND S.MGR_TYPE=#{roleType}";
        }else if (patrolLeader.contains(role)){ //团队长
            dataAuth = "and S.MGR_ID IN (SELECT tmm.USER_ID FROM OCRM_F_CM_TEAM_CUST_MANAGER tmm " +
                    " inner join OCRM_F_CM_MKT_TEAM tm  on tm.mkt_team_id = tmm.mkt_team_id " +
                    "  WHERE TEAM_LEADER_ID = #{userCode}) AND S.MGR_TYPE=#{roleType}";
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

    /**
     * 转换百分数
     * @param resultList
     */
    private void setPercentage(List<Map<String, Object>> resultList) {
        NumberFormat nf   =   NumberFormat.getPercentInstance();
        nf.setMinimumFractionDigits( 2 );
        for (Map<String, Object> map : resultList) {
            BigDecimal aumDepositSort = (BigDecimal)map.get("aumDepositSort")!=null ? (BigDecimal)map.get("aumDepositSort") : new BigDecimal("0");
            BigDecimal aumRateSort = (BigDecimal)map.get("aumRateSort")!=null ? (BigDecimal)map.get("aumRateSort") : new BigDecimal("0");
            BigDecimal aumNonrateSort = (BigDecimal)map.get("aumNonrateSort")!=null ? (BigDecimal)map.get("aumNonrateSort") : new BigDecimal("0");
            BigDecimal consignmentSort = (BigDecimal)map.get("consignmentSort")!=null ? (BigDecimal)map.get("consignmentSort") : new BigDecimal("0");
            BigDecimal danahartaSort = (BigDecimal)map.get("danahartaSort")!=null ? (BigDecimal)map.get("danahartaSort") : new BigDecimal("0");
            BigDecimal qdiiSort = (BigDecimal)map.get("qdiiSort")!=null ? (BigDecimal)map.get("qdiiSort") : new BigDecimal("0");
            BigDecimal rmbfundSort = (BigDecimal)map.get("rmbfundSort")!=null ? (BigDecimal)map.get("rmbfundSort") : new BigDecimal("0");
            BigDecimal insurranceSort = (BigDecimal)map.get("insurranceSort")!=null ? (BigDecimal)map.get("insurranceSort") : new BigDecimal("0");
            map.put("aumDepositSort",nf.format(aumDepositSort));
            map.put("aumRateSort",nf.format(aumRateSort));
            map.put("aumNonrateSort",nf.format(aumNonrateSort));
            map.put("consignmentSort",nf.format(consignmentSort));
            map.put("danahartaSort",nf.format(danahartaSort));
            map.put("qdiiSort",nf.format(qdiiSort));
            map.put("rmbfundSort",nf.format(rmbfundSort));
            map.put("insurranceSort",nf.format(insurranceSort));
        }
    }
}
