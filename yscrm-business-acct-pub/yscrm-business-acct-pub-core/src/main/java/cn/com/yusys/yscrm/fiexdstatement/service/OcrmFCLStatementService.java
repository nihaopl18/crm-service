package cn.com.yusys.yscrm.fiexdstatement.service;

import cn.com.yusys.yscrm.custmgr.domain.DateUtils;
import cn.com.yusys.yscrm.fiexdstatement.domain.OcrmFClBranchtotalVO;
import cn.com.yusys.yscrm.fiexdstatement.domain.OcrmFClStatement;
import cn.com.yusys.yscrm.fiexdstatement.repository.mapper.OcrmFCLStatementMapper;
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
import org.apache.xmlbeans.impl.jam.internal.elements.PackageImpl;
import org.omg.CORBA.BAD_QOS;
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
public class OcrmFCLStatementService extends CommonService {

    @Autowired
    private OcrmFCLStatementMapper ocrmFCLStatementMapper;
    @Override
    protected CommonMapper getMapper() {
        return ocrmFCLStatementMapper;
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


    private static String isPeopleCode = "1"; //是否民生 ，1：是、0：否

    private static String headOrgId = "500"; //总行


    public void exportTest(HttpServletResponse response, QueryModel model) throws IOException {
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码
        String fileName = URLEncoder.encode("分行销售团队", "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
        String isPeople = (String)model.getCondition().get("isPeople"); //是否民生
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map = new HashMap<String, Object>();
        String aumBalanceStart=(String)model.getCondition().get("aumBalanceStart");
        String aumBalanceEnd=(String)model.getCondition().get("aumBalanceEnd");
        String dataDate=(String)model.getCondition().get("dataDate");
        String targetId=(String)model.getCondition().get("targetId"); //客户经理
        String mktRespPerson=(String)model.getCondition().get("mktRespPerson"); //机构
        String exportIds=(String)model.getCondition().get("exportIds");//批量导出

        map.put("aumBalanceEnd",aumBalanceEnd);
        map.put("aumBalanceStart",aumBalanceStart);
        map.put("dataDate",dataDate);
        map.put("targetId", targetId);
        if (!headOrgId.equals(mktRespPerson)){
            map.put("mktRespPerson", mktRespPerson);
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
        String role = (String) model.getCondition().get("selectRole");
        String roleType = "";
        if ("R003,R016,R019,R020".contains(role)){
            roleType = "2";
        }else if ("R002,R018,R015,R017,R021".contains(role)){
            roleType = "1";
        }
        map.put("roleType",roleType);
        map.put("sqlDataAuth",getDataAuth(role,roleType)); //拼接权限控制sql语句

        List<Map<String, Object>> resultList = new ArrayList<>();
        if (isPeopleCode.equalsIgnoreCase(isPeople)){
             //list = queryBranchList(model);
            list = ocrmFCLStatementMapper.queryBranchList(map);

                Map<String, Object> countStatement = ocrmFCLStatementMapper.getCount(map);
                if (countStatement != null){
                    countStatement.put("rm","总计");
                    list.add(countStatement);
                }
                resultList = list;

        }else {
            //list = queryBranchListUnPeople(model);
            list = ocrmFCLStatementMapper.queryBranchListUnPeople(map);

                Map<String, Object> countStatement = ocrmFCLStatementMapper.getCountUnpeople(map);
                if (countStatement != null){
                    countStatement.put("rm","总计");
                    list.add(countStatement);
                }
                resultList = list ;


        }
        //设置百分数
        setPercentage(resultList);
        exportFile(response, "statement_template.xlsx", "RM明细", resultList,isPeople,dataDate);
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

    public List<Map<String, Object>> queryBranchList(QueryModel queryModel) {
        PageHelper.startPage(queryModel.getPage(), queryModel.getSize());
        Map<String, Object> map = new HashMap<String, Object>();
        String aumBalanceStart=(String)queryModel.getCondition().get("aumBalanceStart");
        String aumBalanceEnd=(String)queryModel.getCondition().get("aumBalanceEnd");
        String dataDate=(String)queryModel.getCondition().get("dataDate");
        String targetId=(String)queryModel.getCondition().get("targetId"); //客户经理
        String mktRespPerson=(String)queryModel.getCondition().get("mktRespPerson"); //机构
        map.put("aumBalanceEnd",aumBalanceEnd);
        map.put("aumBalanceStart",aumBalanceStart);
        map.put("dataDate",dataDate);
        map.put("targetId", targetId);
        if (!headOrgId.equals(mktRespPerson)){
            map.put("mktRespPerson", mktRespPerson);
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

        List<Map<String, Object>> list = ocrmFCLStatementMapper.queryBranchList(map);
        Map<String, Object> countStatement = ocrmFCLStatementMapper.getCount(map);
        if (countStatement != null){
            countStatement.put("rm","总计");
            list.add(countStatement);
        }
        PageHelper.clearPage();
        return list;
    }

    public List<Map<String, Object>> queryBranchListUnPeople(QueryModel queryModel) {
        PageHelper.startPage(queryModel.getPage(), queryModel.getSize());
        Map<String, Object> map = new HashMap<String, Object>();
        String aumBalanceStart=(String)queryModel.getCondition().get("aumBalanceStart");
        String aumBalanceEnd=(String)queryModel.getCondition().get("aumBalanceEnd");
        String dataDate=(String)queryModel.getCondition().get("dataDate");
        String targetId=(String)queryModel.getCondition().get("targetId"); //客户经理
        String mktRespPerson=(String)queryModel.getCondition().get("mktRespPerson"); //机构
        map.put("aumBalanceEnd",aumBalanceEnd);
        map.put("aumBalanceStart",aumBalanceStart);
        map.put("dataDate",dataDate);
        map.put("targetId", targetId);
        if (!headOrgId.equals(mktRespPerson)){
            map.put("mktRespPerson", mktRespPerson);
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

        List<Map<String, Object>> list = ocrmFCLStatementMapper.queryBranchListUnPeople(map);
        Map<String, Object> countStatement = ocrmFCLStatementMapper.getCountUnpeople(map);
        if (countStatement != null){
            countStatement.put("rm","总计");
            list.add(countStatement);
        }
        PageHelper.clearPage();
        return list;
    }

    /**
     * 拼接权限控制sql语句
     * @param role
     * @return
     */
    private String getDataAuth(String role, String roleType) {
        String dataAuth = "";
        if (customerManage.contains(role)){ //客户经理
            dataAuth="and st.USER_ID = #{userCode}";
        }else if (patrolLeader.contains(role)){ //团队长
            dataAuth="and st.USER_ID in (SELECT user_id FROM OCRM_F_CM_TEAM_CUST_MANAGER cm INNER JOIN OCRM_F_CM_MKT_TEAM mt ON cm.MKT_TEAM_ID =mt.MKT_TEAM_ID AND mt.TEAM_LEADER_ID =#{userCode})";
        }else if (subbranch.contains(role) || branch.contains(role)){ //分支行
            if (roleType != "") {
                dataAuth="and st.USER_ID in (SELECT u.USER_ID FROM ADMIN_SM_USER u  " +
                        "INNER JOIN ADMIN_SM_USER_ROLE_REL ur ON u.USER_ID =ur.USER_ID " +
                        "INNER JOIN ADMIN_SM_ROLE r ON ur.ROLE_ID =r.ROLE_ID AND r.role_type = #{roleType} " +
                        "WHERE u.ORG_ID IN (SELECT ORG_ID FROM ADMIN_SM_ORG START WITH org_id = #{orgCode} CONNECT BY PRIOR ORG_ID = UP_ORG_ID))";
            }else {
                dataAuth="and st.USER_ID in (SELECT u.USER_ID FROM ADMIN_SM_USER u  " +
                        "INNER JOIN ADMIN_SM_USER_ROLE_REL ur ON u.USER_ID =ur.USER_ID " +
                        "WHERE u.ORG_ID IN (SELECT ORG_ID FROM ADMIN_SM_ORG START WITH org_id = #{orgCode} CONNECT BY PRIOR ORG_ID = UP_ORG_ID))";
            }
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

    public Map<String, Object> getCount(List<Map<String,Object>> resultList,List<Integer> ids){


        BigDecimal youhuiCustnumber =resultList.stream().map(resultMap -> (BigDecimal)resultMap.get("youhuiCustnumber")).reduce(BigDecimal.ZERO,BigDecimal::add);
        BigDecimal youhuiUpgrate =resultList.stream().map(resultMap -> (BigDecimal)resultMap.get("youhuiUpgrate")).reduce(BigDecimal.ZERO,BigDecimal::add);
        BigDecimal youhuiWinback =resultList.stream().map(resultMap -> (BigDecimal)resultMap.get("youhuiWinback")).reduce(BigDecimal.ZERO,BigDecimal::add);
        BigDecimal xianzhuoCustnumber =resultList.stream().map(resultMap -> (BigDecimal)resultMap.get("xianzhuoCustnumber")).reduce(BigDecimal.ZERO,BigDecimal::add);
        BigDecimal xianzhuoUpgrate =resultList.stream().map(resultMap -> (BigDecimal)resultMap.get("xianzhuoUpgrate")).reduce(BigDecimal.ZERO,BigDecimal::add);
        BigDecimal xianzhuoWinback =resultList.stream().map(resultMap -> (BigDecimal)resultMap.get("xianzhuoWinback")).reduce(BigDecimal.ZERO,BigDecimal::add);
        BigDecimal aumBalanceavgTHt =resultList.stream().map(resultMap -> (BigDecimal)resultMap.get("aumBalanceavgTHt")).reduce(BigDecimal.ZERO,BigDecimal::add);
        BigDecimal aumBalanceavgHtFht =resultList.stream().map(resultMap -> (BigDecimal)resultMap.get("aumBalanceavgHtFht")).reduce(BigDecimal.ZERO,BigDecimal::add);
        BigDecimal aumBalanceavgFhtTm =resultList.stream().map(resultMap -> (BigDecimal)resultMap.get("aumBalanceavgFhtTm")).reduce(BigDecimal.ZERO,BigDecimal::add);
        BigDecimal aumBalanceavgTmSm =resultList.stream().map(resultMap -> (BigDecimal)resultMap.get("aumBalanceavgTmSm")).reduce(BigDecimal.ZERO,BigDecimal::add);
        BigDecimal aumBalanceavgSmEndless =resultList.stream().map(resultMap -> (BigDecimal)resultMap.get("aumBalanceavgSmEndless")).reduce(BigDecimal.ZERO,BigDecimal::add);
        BigDecimal aumBalance =resultList.stream().map(resultMap -> (BigDecimal)resultMap.get("aumBalance")).reduce(BigDecimal.ZERO,BigDecimal::add);
        BigDecimal aumDeposit =resultList.stream().map(resultMap -> (BigDecimal)resultMap.get("aumDeposit")).reduce(BigDecimal.ZERO,BigDecimal::add);
        BigDecimal aumDepositSort =resultList.stream().map(resultMap -> (BigDecimal)resultMap.get("aumDepositSort")).reduce(BigDecimal.ZERO,BigDecimal::add);
        BigDecimal aumRate =resultList.stream().map(resultMap -> (BigDecimal)resultMap.get("aumRate")).reduce(BigDecimal.ZERO,BigDecimal::add);
        BigDecimal aumRateSort =resultList.stream().map(resultMap -> (BigDecimal)resultMap.get("aumRateSort")).reduce(BigDecimal.ZERO,BigDecimal::add);
        BigDecimal aumNonrate =resultList.stream().map(resultMap -> (BigDecimal)resultMap.get("aumNonrate")).reduce(BigDecimal.ZERO,BigDecimal::add);
        BigDecimal aumNonrateSort =resultList.stream().map(resultMap -> (BigDecimal)resultMap.get("aumNonrateSort")).reduce(BigDecimal.ZERO,BigDecimal::add);
        BigDecimal consignment =resultList.stream().map(resultMap -> (BigDecimal)resultMap.get("consignment")).reduce(BigDecimal.ZERO,BigDecimal::add);
        BigDecimal consignmentSort =resultList.stream().map(resultMap -> (BigDecimal)resultMap.get("consignmentSort")).reduce(BigDecimal.ZERO,BigDecimal::add);
        BigDecimal danaharta =resultList.stream().map(resultMap -> (BigDecimal)resultMap.get("danaharta")).reduce(BigDecimal.ZERO,BigDecimal::add);
        BigDecimal danahartaSort =resultList.stream().map(resultMap -> (BigDecimal)resultMap.get("danahartaSort")).reduce(BigDecimal.ZERO,BigDecimal::add);
        BigDecimal qdii =resultList.stream().map(resultMap -> (BigDecimal)resultMap.get("qdii")).reduce(BigDecimal.ZERO,BigDecimal::add);
        BigDecimal qdiiSort =resultList.stream().map(resultMap -> (BigDecimal)resultMap.get("qdiiSort")).reduce(BigDecimal.ZERO,BigDecimal::add);
        BigDecimal rmbfund =resultList.stream().map(resultMap -> (BigDecimal)resultMap.get("rmbfund")).reduce(BigDecimal.ZERO,BigDecimal::add);
        BigDecimal rmbfundSort =resultList.stream().map(resultMap -> (BigDecimal)resultMap.get("rmbfundSort")).reduce(BigDecimal.ZERO,BigDecimal::add);
        BigDecimal insurrance =resultList.stream().map(resultMap -> (BigDecimal)resultMap.get("insurrance")).reduce(BigDecimal.ZERO,BigDecimal::add);
        BigDecimal insurranceSort =resultList.stream().map(resultMap -> (BigDecimal)resultMap.get("insurranceSort")).reduce(BigDecimal.ZERO,BigDecimal::add);
        Map<String, Object> countStatement = new HashMap<>();
        countStatement.put("rm","总计");
        countStatement.put("youhuiCustnumber",youhuiCustnumber);
        countStatement.put("youhuiUpgrate",youhuiUpgrate);
        countStatement.put("youhuiWinback",youhuiWinback);
        countStatement.put("xianzhuoCustnumber",xianzhuoCustnumber);
        countStatement.put("xianzhuoUpgrate",xianzhuoUpgrate);
        countStatement.put("xianzhuoWinback",xianzhuoWinback);
        countStatement.put("aumBalanceavgTHt",aumBalanceavgTHt);
        countStatement.put("aumBalanceavgHtFht",aumBalanceavgHtFht);
        countStatement.put("aumBalanceavgFhtTm",aumBalanceavgFhtTm);
        countStatement.put("aumBalanceavgTmSm",aumBalanceavgTmSm);
        countStatement.put("aumBalanceavgSmEndless",aumBalanceavgSmEndless);
        countStatement.put("aumBalance",aumBalance);
        countStatement.put("aumDeposit",aumDeposit);
        countStatement.put("aumDepositSort",aumDepositSort);
        countStatement.put("aumRate",aumRate);
        countStatement.put("aumRateSort",aumRateSort);
        countStatement.put("aumNonrate",aumNonrate);
        countStatement.put("aumNonrateSort",aumNonrateSort);
        countStatement.put("consignment",consignment);
        countStatement.put("consignmentSort",consignmentSort);
        countStatement.put("danaharta",danaharta);
        countStatement.put("danahartaSort",danahartaSort);
        countStatement.put("qdii",qdii);
        countStatement.put("qdiiSort",qdiiSort);
        countStatement.put("rmbfund",rmbfund);
        countStatement.put("rmbfundSort",rmbfundSort);
        countStatement.put("insurrance",insurrance);
        countStatement.put("insurranceSort",insurranceSort);
        return countStatement;
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
