package cn.com.yusys.yscrm.pcrm.common.util.echain.extnodeuser;

import cn.com.yusys.yscrm.pcrm.common.util.BeanUtils;
import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.echain.server.echain.organization.SqlUtil;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;
import com.ecc.echain.db.DbControl;
import com.ecc.echain.ext.NodeUserListExtIF;
import com.ecc.echain.workflow.engine.EVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class NodeUserListExtClass implements NodeUserListExtIF {
    private static final Logger LOGGER = LoggerFactory.getLogger(NodeUserListExtClass.class);

    @Autowired
    private UaaClient uaaClient = BeanUtils.getBean(UaaClient.class);

    public Map<String, String> getUser(EVO evo){
        String role = "";
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
        String selectRole = request.getHeader("selectRole");
        switch (selectRole){
            case "R002":
                role = "R018";
                break;
            case "R003":
                role = "R019";
                break;
            default:
                break;
        }
        Map<String,String> map = new HashMap<>();
        map.put("roleid",role);
        map.put("userid",dto.getBody().getLoginCode());
        map.put("orgid",evo.getOrgid());
        return map;
    }

    @Override
    public List getNodeUserList(EVO evo) throws Exception {
        System.out.println("【info】调用NodeUserListExtClass.getNodeUserList()方法");
        Map<String,String> cuser = this.getUser(evo);
        DbControl db = DbControl.getInstance();
        Connection con = null;
        if (evo.getConnection() != null){
            con = evo.getConnection();
        }else {
            con = db.getConnection();
        }
        List<String> list = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT T0.* FROM ADMIN_SM_USER T0 JOIN OCRM_F_CM_MKT_TEAM T1 ON (T0.USER_ID = T1.TEAM_LEADER_ID) JOIN OCRM_F_CM_TEAM_CUST_MANAGER T2 ON (T1.MKT_TEAM_ID = T2.MKT_TEAM_ID AND T2.USER_ID = ?) WHERE T0.USER_STS = 'A'");
            ps.setString(1, cuser.get("userid"));
            ResultSet rs = ps.executeQuery();
            List<Map<String, String>> datas = SqlUtil.rsToStrMap(rs);
            if (datas == null || datas.isEmpty()) {
                ps = con.prepareStatement("SELECT DISTINCT T0.* FROM ADMIN_SM_USER T0 JOIN ADMIN_SM_USER_ROLE_REL T1 ON(T0.USER_ID=T1.USER_ID) JOIN ADMIN_SM_ROLE T2 ON(T1.ROLE_ID=T2.ROLE_ID) JOIN ADMIN_SM_ORG T3 ON(T0.ORG_ID=T3.ORG_ID) WHERE T0.USER_STS='A' AND T2.ROLE_CODE=? AND T3.ORG_ID = ?");
                ps.setString(1, cuser.get("roleid"));
                ps.setString(2, cuser.get("orgid"));
                rs = ps.executeQuery();
                datas = SqlUtil.rsToStrMap(rs);
                if (datas == null || datas.isEmpty()) {
                    ps = con.prepareStatement("SELECT DISTINCT T0.* FROM ADMIN_SM_USER T0 JOIN ADMIN_SM_USER_ROLE_REL T1 ON(T0.USER_ID=T1.USER_ID) JOIN ADMIN_SM_ROLE T2 ON(T1.ROLE_ID=T2.ROLE_ID) JOIN ADMIN_SM_ORG T3 ON(T0.ORG_ID=T3.ORG_ID) WHERE T0.USER_STS='A' AND T2.ROLE_CODE=? AND T3.ORG_ID like ?");
                    ps.setString(1, cuser.get("roleid"));
                    ps.setString(2, cuser.get("orgid").substring(0, 2) + "%");
                    rs = ps.executeQuery();
                    datas = SqlUtil.rsToStrMap(rs);
                    if (datas == null || datas.isEmpty()) {
                        ps = con.prepareStatement("SELECT DISTINCT T0.* FROM ADMIN_SM_USER T0 JOIN ADMIN_SM_USER_ROLE_REL T1 ON(T0.USER_ID=T1.USER_ID) JOIN ADMIN_SM_ROLE T2 ON(T1.ROLE_ID=T2.ROLE_ID) JOIN ADMIN_SM_ORG T3 ON(T0.ORG_ID=T3.ORG_ID) WHERE T0.USER_STS='A' AND T2.ROLE_CODE=? ");
                        ps.setString(1, cuser.get("roleid"));
                        rs = ps.executeQuery();
                        datas = SqlUtil.rsToStrMap(rs);
                    }
                }
            }
            if (datas != null && !datas.isEmpty()) {
                Iterator var10 = datas.iterator();

                while (var10.hasNext()){
                    Map<String,String> user = (Map)var10.next();
                    list.add(user.get("LOGIN_CODE"));
                }
            }
            rs.close();
            ps.close();
        }catch (Exception var12) {
            LOGGER.error(var12.getMessage(), var12);
        }
        return list;
    }
}
