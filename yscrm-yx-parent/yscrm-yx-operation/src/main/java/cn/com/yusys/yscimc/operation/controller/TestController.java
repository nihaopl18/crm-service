package cn.com.yusys.yscimc.operation.controller;

import cn.com.yusys.yusp.cm.cust.repository.mapper.AcimFCiCustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Author Lenovo
 * @Data 2021/12/29 10:28
 */
@RestController
@RequestMapping("/api/marketplanaction")
public class TestController {

    @Autowired
    private AcimFCiCustomerMapper customerMapper;

    private static final String INTO_TEMPLATE =
            " into ACIM_F_CI_CUSTOMER " +
                    " (CUST_ID, CUST_TYPE, IDENT_TYPE, IDENT_NO, CUST_NAME, POTENTIAL_FLAG, BELONG_ORG, BELONG_MGR, CONTACT_NUMBER, RISK_LEVEL, WORTH_LEVEL, SERVICE_LEVEL) " +
                    " values ('aaaaaaaaaa@CUST_ID@', '@CUST_TYPE@', 'A', 'aaabbbccc', 'aaa@CUST_NAME@', '@POTENTIAL_FLAG@', " +
                    " '@BELONG_ORG@', '@BELONG_MGR@', '@CONTACT_NUMBER@', '@RISK_LEVEL@', '@WORTH_LEVEL@', '@SERVICE_LEVEL@') ";

    private static final String SQL_END = " select 1 from dual";

    private static Random random = new Random();

    private static List<String> mrgList = new ArrayList<>();
    private static List<String> orgList = new ArrayList<>();
    {
        mrgList.add("al01");
        mrgList.add("fanna0001");
        mrgList.add("508N1338");
        mrgList.add("506N1342");
        orgList.add("3");
        orgList.add("4");
        orgList.add("5");
        orgList.add("6");
        orgList.add("100");
        orgList.add("200");
        orgList.add("300");
        orgList.add("500");
    }

    private int baseCount = 1000000;

    @GetMapping("/addCustomer/{type}/{number}")
    public String addCustomer(@PathVariable String type, @PathVariable int number) {
        StringBuffer stringBuffer = new StringBuffer("INSERT ALL " + "\n");
        long replaceStart = System.nanoTime();
        for (int count = baseCount; count < number + baseCount; count++) {
            String replaceSql = INTO_TEMPLATE;
            replaceSql = replaceSql
                    // 替换客户 id
                    .replace("@CUST_ID@", type + String.valueOf(count))
                    // 替换客户类型
                    .replace("@CUST_TYPE@", random.nextBoolean() ? "1" : "2")
                    // 替换客户名称
                    .replace("@CUST_NAME@", String.valueOf(count))
                    // 潜在客户标识
                    .replace("@POTENTIAL_FLAG@", random.nextBoolean() ? "1" : "0")
                    // 所属机构
                    .replace("@BELONG_ORG@", orgList.get(random.nextInt(orgList.size())))
                    // 所属经理
                    .replace("@BELONG_MGR@", mrgList.get(random.nextInt(mrgList.size())))
                    // 联系电话
                    .replace("@CONTACT_NUMBER@", String.valueOf(random.nextInt(999999)))
                    // 风险偏好等级
                    .replace("@RISK_LEVEL@", String.valueOf(random.nextInt(3)))
                    // 客户价值等级
                    .replace("@WORTH_LEVEL@", String.valueOf(random.nextInt(10)))
                    // 客户服务等级
                    .replace("@SERVICE_LEVEL@", random.nextBoolean() ? "1" : "2");

            stringBuffer.append(replaceSql).append("\n");
        }
        stringBuffer.append(SQL_END);
        long replaceEnd = System.nanoTime();
        System.out.println("替换所用时间: " + (replaceEnd - replaceStart) / 1000 + ", sql 大小为: " + stringBuffer.toString().getBytes().length);

        long insertStart = System.nanoTime();
        customerMapper.insertAll(stringBuffer.toString());
        long insertEnd = System.nanoTime();
        System.out.println("插入所用的时间: " + (insertEnd - insertStart) / 1000);

        return stringBuffer.toString();
    }

    @GetMapping("/deleteCustomer/{id}")
    public String addCustomer(@PathVariable String id) {
        customerMapper.deleteByIdLike(id + "%'");
        return "success";
    }
}
