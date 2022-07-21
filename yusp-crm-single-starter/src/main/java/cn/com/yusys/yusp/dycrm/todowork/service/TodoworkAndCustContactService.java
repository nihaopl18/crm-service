package cn.com.yusys.yusp.dycrm.todowork.service;

import cn.com.yusys.yscrm.info.workreport.domain.OcrmFwpCustomerContact;
import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.dycrm.todowork.domain.OcrmFwpTodoWork;
import cn.com.yusys.yusp.dycrm.todowork.domain.OcrmFwpTodoWorkSon;
import cn.com.yusys.yusp.dycrm.todowork.repository.mapper.TodoworkAndCustContactMapper;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;
import org.apache.ibatis.ognl.Ognl;
import org.apache.ibatis.ognl.OgnlContext;
import org.apache.ibatis.ognl.OgnlException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * @项目名称: dycrm-todowork模块
 * @类名称: OcrmFwpCustomerContactMapper
 * @类描述: #Dao类
 * @功能描述:
 * @创建人: lufl
 * @创建时间: 2021-12-28 15:20:24
 * @修改备注:
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class TodoworkAndCustContactService  extends CommonService {

    @Autowired
    private TodoworkAndCustContactMapper todoworkAndCustContactMapper;

    @Autowired
    private UaaClient uaaClient;

    private final Logger log = LoggerFactory.getLogger(TodoworkAndCustContactService.class);

    @Override
    protected CommonMapper getMapper() {
        return todoworkAndCustContactMapper;
    }

    public String getUuid() {
        OgnlContext contxet = new OgnlContext();
        try {
            Object ognl = Ognl.parseExpression("@java.util.UUID@randomUUID().toString().replace(\"-\", \"\")");
            return Ognl.getValue(ognl, contxet, contxet.getRoot()).toString();
        } catch (OgnlException var3) {
            var3.printStackTrace();
            return null;
        }
    }

    public void addTodoWorks(List<OcrmFwpTodoWork> list) {
        ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        try {
            date = s.parse(s.format(date));
        } catch (ParseException e) {
            log.error("日期格式化错误");
            e.printStackTrace();
        }
        for (OcrmFwpTodoWork ocrmFwpTodoWork: list) {
            String[] relationCusts = ocrmFwpTodoWork.getRelationCust().split(";");
            if (relationCusts.length > 0){
                List<OcrmFwpCustomerContact> ocrmFwpCustomerContacts = new ArrayList<>();
                for (int i = 0; i < relationCusts.length; i++){
                    OcrmFwpCustomerContact ocrmFwpCustomerContact = new OcrmFwpCustomerContact();
                    ocrmFwpCustomerContact.setContactCustId(relationCusts[i].split("-")[1]);
                    ocrmFwpCustomerContact.setContactCustName(relationCusts[i].split("-")[0]);

                    ocrmFwpCustomerContact.setIsDraft("N-0");
                    ocrmFwpCustomerContact.setSourceTable("1");
                    ocrmFwpCustomerContact.setIsDelete("N");
                    ocrmFwpCustomerContact.setCustomerContactId(getUuid());
                    ocrmFwpCustomerContact.setCreatorId(dto.getBody().getLoginCode());
                    ocrmFwpCustomerContact.setCreatorName(dto.getBody().getUserName());
                    ocrmFwpCustomerContact.setCreatorOrgId(dto.getBody().getOrg().getId());
                    ocrmFwpCustomerContact.setCreatorOrgName(dto.getBody().getOrg().getName());
                    ocrmFwpCustomerContact.setCreateDate(date);
                    ocrmFwpCustomerContact.setContactDate(ocrmFwpTodoWork.getStartDate());
                    ocrmFwpCustomerContact.setContactGoal(ocrmFwpTodoWork.getContactGoal());
                    ocrmFwpCustomerContact.setContactType(ocrmFwpTodoWork.getContactType());
                    ocrmFwpCustomerContacts.add(ocrmFwpCustomerContact);
                }
                addCustomerContacts(ocrmFwpCustomerContacts);
            }
        }
    }

    public void addTodoWorkSons(List<OcrmFwpTodoWorkSon> list) {
        List<OcrmFwpTodoWork> ocrmFwpTodoWorks = new ArrayList<>();
        for (OcrmFwpTodoWorkSon ocrmFwpTodoWorkSon: list) {
            OcrmFwpTodoWork ocrmFwpTodoWork = new OcrmFwpTodoWork();
            ocrmFwpTodoWork.setRelationCust(ocrmFwpTodoWorkSon.getRelationCust());
            ocrmFwpTodoWork.setStartDate(ocrmFwpTodoWorkSon.getStartDate());
            ocrmFwpTodoWork.setContactType(ocrmFwpTodoWorkSon.getContactType());
            ocrmFwpTodoWork.setContactGoal(ocrmFwpTodoWorkSon.getContactGoal());
            ocrmFwpTodoWorks.add(ocrmFwpTodoWork);
        }
        addTodoWorks(ocrmFwpTodoWorks);
    }

    public void addCustomerContacts(List<OcrmFwpCustomerContact> list) {
        for (OcrmFwpCustomerContact ocrmFwpCustomerContact: list) {
            this.insertSelective(ocrmFwpCustomerContact);
        }
    }

}
