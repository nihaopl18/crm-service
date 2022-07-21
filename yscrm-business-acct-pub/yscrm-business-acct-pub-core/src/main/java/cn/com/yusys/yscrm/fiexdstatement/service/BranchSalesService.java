package cn.com.yusys.yscrm.fiexdstatement.service;


import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BranchSalesService extends CommonService {



    @Autowired
    private OcrmFClBranchtotalService ocrmFClBranchtotalService;

    @Autowired
    private OcrmFCLStatementService ocrmFCLStatementService;

    @Autowired
    private OcrmFClCustomerDetailsService ocrmFClCustomerDetailsService;

    private static String branchLevel="branchLevel";
    private static String custLevel="custLevel";



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

    @Override
    protected CommonMapper getMapper() {
        return null;
    }

    public List<Map<String, Object>> queryList(QueryModel queryModel) {
        Map<String, Object> map = new HashMap<>();
        String selectRole = getRole(); //查询其角色编码
        //String selectRole=(String)queryModel.getCondition().get("selectRole");
        String dataDate=(String)queryModel.getCondition().get("dataDate"); //日期天数
        String isPeople = (String)queryModel.getCondition().get("isPeople"); //是否民生
        String value=(String) queryModel.getCondition().get("targetId"); //客户经理/机构
        String roleFlag=(String) queryModel.getCondition().get("roleFlag"); //标识
        map.put("dataDate", dataDate);
        map.put("isPeople", isPeople);
        List<Map<String, Object>> list = new ArrayList<>();
        if (roleFlag != ""&&roleFlag != null){
            if (branchLevel.equals(roleFlag)){
                if (isPeopleCode.equalsIgnoreCase(isPeople)){
                    list=ocrmFCLStatementService.queryBranchList(queryModel);
                }else {
                    list=ocrmFCLStatementService.queryBranchListUnPeople(queryModel);
                }
            }else if (custLevel.equals(roleFlag)){
                list=ocrmFClCustomerDetailsService.queryBranchList(queryModel);
            }
        }else {
            if (headOffice.contains(selectRole) || headOfficeB.contains(selectRole)){ //如果是总行级别以上
                if (isPeopleCode.equalsIgnoreCase(isPeople)){
                    list=ocrmFClBranchtotalService.queryBranchList(queryModel);
                }else {
                    list=ocrmFClBranchtotalService.queryBranchListUnPeople(queryModel);
                }

            }
            if (branch.contains(selectRole) || subbranch.contains(selectRole) || patrolLeader.contains(selectRole) ){ //如果是分行支行权限以上
                if (isPeopleCode.equalsIgnoreCase(isPeople)){
                    list=ocrmFCLStatementService.queryBranchList(queryModel);
                }else {
                    list=ocrmFCLStatementService.queryBranchListUnPeople(queryModel);
                }
            }
            if (customerManage.contains(selectRole)){ //客户经理权限
                list=ocrmFClCustomerDetailsService.queryBranchList(queryModel);
            }
        }
        return list;
    }

    public static String getRole() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        String selectRole = request.getHeader("selectRole");
        return selectRole;
    }

    public void export(HttpServletResponse response, QueryModel queryModel) throws IOException {
        String selectRole = (String) queryModel.getCondition().get("selectRole"); //角色中文名
        //String selectRole = getRole(); //查询其角色编码
        String isPeople = (String)queryModel.getCondition().get("isPeople"); //是否民生
        String roleFlag=(String) queryModel.getCondition().get("roleFlag"); //标识
        if (roleFlag != null && roleFlag != ""){
            if (branchLevel.equals(roleFlag)){
                ocrmFCLStatementService.exportTest(response,queryModel);

            }else if (custLevel.equals(roleFlag)){
                ocrmFClCustomerDetailsService.export(response,queryModel);
            }
        }else {
            if (headOffice.contains(selectRole) || headOfficeB.contains(selectRole)){ //如果是总行级别以上
                ocrmFClBranchtotalService.export(response,queryModel);
            }
            if (branch.contains(selectRole) || subbranch.contains(selectRole) || patrolLeader.contains(selectRole) ){ //如果是分行支行权限以上
                ocrmFCLStatementService.exportTest(response,queryModel);
            }
            if (customerManage.contains(selectRole) ){ //客户经理权限
                ocrmFClCustomerDetailsService.export(response,queryModel);
            }
        }
    }
}
