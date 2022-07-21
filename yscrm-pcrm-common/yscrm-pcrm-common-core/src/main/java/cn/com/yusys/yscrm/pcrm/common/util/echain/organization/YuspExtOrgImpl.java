package cn.com.yusys.yscrm.pcrm.common.util.echain.organization;

import cn.com.yusys.yusp.echain.server.echain.EChainRuntimeContext;
import cn.com.yusys.yusp.echain.server.echain.organization.SqlUtil;
import cn.com.yusys.yusp.echain.server.echain.organization.YuspOrgImpl;
import com.ecc.echain.org.OrgIF;
import com.ecc.echain.org.model.*;
import com.ecc.echain.workflow.cache.OUCache;
import com.ecc.echain.workflow.model.WFClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class YuspExtOrgImpl implements OrgIF {
    private static final Logger LOGGER = LoggerFactory.getLogger(YuspExtOrgImpl.class);

    public YuspExtOrgImpl() {
    }

    public OrgModel getRootOrg(Connection con) {
        LOGGER.error("方法[getRootOrg]没有做实现");
        return null;
    }

    public List getAllBaseOrgs(Connection con) {
        List list = new ArrayList();
        LOGGER.error("方法[getAllBaseOrgs]没有做实现");
        return list;
    }

    public List getDirectSubOrgs(String orgid, Connection con) {
        ArrayList list = new ArrayList();

        try {
            String instuCde = this.getCurrentInstuCde();
            PreparedStatement ps = con.prepareStatement("SELECT T0.* FROM ADMIN_SM_ORG T0 JOIN ADMIN_SM_INSTU T1 ON(T0.INSTU_ID=T1.INSTU_ID) WHERE T1.INSTU_CDE=? AND T0.UP_ORG_ID=?");
            ps.setString(1, instuCde);
            ps.setString(2, orgid);
            ResultSet rs = ps.executeQuery();
            List<Map<String, String>> datas = SqlUtil.rsToStrMap(rs);
            rs.close();
            ps.close();
            if (datas != null) {
                Iterator var9 = datas.iterator();

                while(var9.hasNext()) {
                    Map<String, String> org = (Map)var9.next();
                    OrgModel orgModel = this.toOrgModel(org);
                    list.add(orgModel);
                }
            }
        } catch (Exception var11) {
            LOGGER.error(var11.getMessage(), var11);
        }

        return list;
    }

    public List getAllSubOrgs(String orgid, Connection con) {
        ArrayList list = new ArrayList();

        try {
            String instuCde = this.getCurrentInstuCde();
            PreparedStatement ps = con.prepareStatement("SELECT T0.* FROM (SELECT * FROM ADMIN_SM_ORG START WITH ORG_CODE=? CONNECT BY NOCYCLE PRIOR ORG_ID=UP_ORG_ID) T0 JOIN ADMIN_SM_INSTU T1 ON(T0.INSTU_ID=T1.INSTU_ID) WHERE T0.ORG_CODE <> ? AND T1.INSTU_CDE=? ORDER BY T0.ORG_LEVEL,T0.ORG_CODE");
            ps.setString(1, orgid);
            ps.setString(2, orgid);
            ps.setString(3, instuCde);
            ResultSet rs = ps.executeQuery();
            List<Map<String, String>> datas = SqlUtil.rsToStrMap(rs);
            rs.close();
            ps.close();
            if (datas != null && !datas.isEmpty()) {
                Iterator var9 = datas.iterator();

                while(var9.hasNext()) {
                    Map<String, String> org = (Map)var9.next();
                    OrgModel orgModel = this.toOrgModel(org);
                    list.add(orgModel);
                }
            }
        } catch (Exception var11) {
            LOGGER.error(var11.getMessage(), var11);
        }

        return list;
    }

    public OrgModel getParentOrg(String orgid, Connection con) {
        OrgModel supOrgModel = null;

        try {
            String instuCde = this.getCurrentInstuCde();
            PreparedStatement ps = con.prepareStatement("SELECT T0.* FROM ADMIN_SM_ORG T0 JOIN ADMIN_SM_INSTU T1 ON(T0.INSTU_ID=T1.INSTU_ID) WHERE T1.INSTU_CDE=? AND T0.ORG_ID=(SELECT UP_ORG_ID FROM ADMIN_SM_ORG WHERE ORG_CODE=?)");
            ps.setString(1, instuCde);
            ps.setString(2, orgid);
            ResultSet rs = ps.executeQuery();
            List<Map<String, String>> datas = SqlUtil.rsToStrMap(rs);
            rs.close();
            ps.close();
            if (datas != null && !datas.isEmpty()) {
                supOrgModel = this.toOrgModel((Map)datas.get(0));
            }
        } catch (Exception var8) {
            LOGGER.error(var8.getMessage(), var8);
        }

        return supOrgModel;
    }

    public OrgModel getOrgModel(String orgid, Connection con) {
        OrgModel model = new OrgModel();

        try {
            String instuCde = this.getCurrentInstuCde();
            PreparedStatement ps = con.prepareStatement("SELECT T0.* FROM ADMIN_SM_ORG T0 JOIN ADMIN_SM_INSTU T1 ON(T0.INSTU_ID=T1.INSTU_ID) WHERE T1.INSTU_CDE=? AND T0.ORG_CODE=?");
            ps.setString(1, instuCde);
            ps.setString(2, orgid);
            ResultSet rs = ps.executeQuery();
            List<Map<String, String>> datas = SqlUtil.rsToStrMap(rs);
            rs.close();
            ps.close();
            if (datas != null && !datas.isEmpty()) {
                model = this.toOrgModel((Map)datas.get(0));
            }
        } catch (Exception var8) {
            LOGGER.error(var8.getMessage(), var8);
        }

        return model;
    }

    public List getAllOrgs(Connection con) {
        ArrayList list = new ArrayList();

        try {
            String instuCde = this.getCurrentInstuCde();
            PreparedStatement ps = con.prepareStatement("SELECT T0.* FROM ADMIN_SM_ORG T0 JOIN ADMIN_SM_INSTU T1 ON(T0.INSTU_ID=T1.INSTU_ID) WHERE T1.INSTU_CDE=? ORDER BY ORG_LEVEL,ORG_CODE");
            ps.setString(1, instuCde);
            ResultSet rs = ps.executeQuery();
            List<Map<String, String>> datas = SqlUtil.rsToStrMap(rs);
            if (datas != null && !datas.isEmpty()) {
                Iterator var8 = datas.iterator();

                while(var8.hasNext()) {
                    Map<String, String> org = (Map)var8.next();
                    OrgModel orgModel = this.toOrgModel(org);
                    list.add(orgModel);
                }
            }

            rs.close();
            ps.close();
        } catch (Exception var10) {
            LOGGER.error(var10.getMessage(), var10);
        }

        System.out.println(list);
        return list;
    }

    public List getDirectDepsByOrg(String orgid, Connection con) {
        LOGGER.error("方法[getDirectDepsByOrg]没有做实现");
        return new ArrayList();
    }

    public List getAllDepsByOrg(String orgid, Connection con) {
        LOGGER.error("方法[getAllDepsByOrg]没有做实现");
        return new ArrayList();
    }

    public List getDirectSubDepsByDep(String orgid, String depid, Connection con) {
        LOGGER.error("方法[getDirectSubDepsByDep]没有做实现");
        return new ArrayList();
    }

    public List getAllSubDepsByDep(String orgid, String depid, Connection con) {
        LOGGER.error("方法[getAllSubDepsByDep]没有做实现");
        return new ArrayList();
    }

    public DepModel getParentDep(String orgid, String depid, Connection con) {
        LOGGER.error("方法[getParentDep]没有做实现");
        return null;
    }

    public DepModel getDepModel(String orgid, String depid, Connection con) {
        LOGGER.error("方法[getDepModel]没有做实现");
        return null;
    }

    public List getDirectUsersByOrg(String orgid, Connection con) {
        ArrayList list = new ArrayList();

        try {
            String instuCde = this.getCurrentInstuCde();
            PreparedStatement ps = con.prepareStatement("SELECT T0.* FROM ADMIN_SM_USER T0 JOIN ADMIN_SM_ORG T1 ON(T0.ORG_ID=T1.ORG_ID) JOIN ADMIN_SM_INSTU T2 ON(T1.INSTU_ID=T2.INSTU_ID) WHERE T0.USER_STS='A' AND T2.INSTU_CDE=? AND T1.ORG_CODE=?");
            ps.setString(1, instuCde);
            ps.setString(2, orgid);
            ResultSet rs = ps.executeQuery();
            List<Map<String, String>> datas = SqlUtil.rsToStrMap(rs);
            if (datas != null && !datas.isEmpty()) {
                Iterator var9 = datas.iterator();

                while(var9.hasNext()) {
                    Map<String, String> user = (Map)var9.next();
                    UserModel userModel = this.toUserModel(user);
                    list.add(userModel);
                }
            }

            rs.close();
            ps.close();
        } catch (Exception var11) {
            LOGGER.error(var11.getMessage(), var11);
        }

        return list;
    }

    public List getAllUsersByOrg(String orgid, Connection con) {
        ArrayList list = new ArrayList();

        try {
            String instuCde = this.getCurrentInstuCde();
            PreparedStatement ps = con.prepareStatement("SELECT T0.* FROM ADMIN_SM_USER T0 JOIN ADMIN_SM_ORG T1 ON(T0.ORG_ID=T1.ORG_ID) JOIN ADMIN_SM_INSTU T2 ON(T1.INSTU_ID=T2.INSTU_ID) WHERE T0.USER_STS='A' AND  T2.INSTU_CDE=? AND T1.ORG_CODE=?");
            ps.setString(1, instuCde);
            ps.setString(2, orgid);
            ResultSet rs = ps.executeQuery();
            List<Map<String, String>> datas = SqlUtil.rsToStrMap(rs);
            if (datas != null && !datas.isEmpty()) {
                Iterator var9 = datas.iterator();

                while(var9.hasNext()) {
                    Map<String, String> user = (Map)var9.next();
                    UserModel userModel = this.toUserModel(user);
                    list.add(userModel);
                }
            }

            rs.close();
            ps.close();
        } catch (Exception var11) {
            LOGGER.error(var11.getMessage(), var11);
        }

        return list;
    }

    public List getDirectUsersByDep(String orgid, String depid, Connection con) {
        LOGGER.error("方法[getDirectUsersByDep]没有做实现");
        return new ArrayList();
    }

    public List getAllUsersByDep(String orgid, String depid, Connection con) {
        LOGGER.error("方法[getAllUsersByDep]没有做实现");
        return new ArrayList();
    }

    public UserModel getUserModel(String orgid, String userid, Connection con) {
        return this.getUserModel(userid, con);
    }

    public UserModel getUserModel(String userid, Connection con) {
        UserModel userModel = null;

        try {
            String instuCde = this.getCurrentInstuCde();
            PreparedStatement ps = con.prepareStatement("SELECT T0.* FROM ADMIN_SM_USER T0 JOIN ADMIN_SM_ORG T1 ON(T0.ORG_ID=T1.ORG_ID) JOIN ADMIN_SM_INSTU T2 ON(T1.INSTU_ID=T2.INSTU_ID) WHERE T2.INSTU_CDE=? AND T0.LOGIN_CODE=?");
            ps.setString(1, instuCde);
            ps.setString(2, userid);
            ResultSet rs = ps.executeQuery();
            List<Map<String, String>> datas = SqlUtil.rsToStrMap(rs);
            if (datas != null && !datas.isEmpty()) {
                userModel = this.toUserModel((Map)datas.get(0));
            }

            rs.close();
            ps.close();
        } catch (Exception var8) {
            LOGGER.error(var8.getMessage(), var8);
        }

        return userModel;
    }

    public String getOrgIdByUser(String userid, Connection con) {
        String orgid = null;
        if (!this.getSignUser().equals(userid) && !userid.startsWith("T.")) {
            try {
                String instuCde = this.getCurrentInstuCde();
                PreparedStatement ps = con.prepareStatement("SELECT T1.ORG_CODE FROM ADMIN_SM_USER T0 JOIN ADMIN_SM_ORG T1 ON(T0.ORG_ID=T1.ORG_ID) JOIN ADMIN_SM_INSTU T2 ON(T1.INSTU_ID=T2.INSTU_ID) WHERE T2.INSTU_CDE=? AND T0.LOGIN_CODE=?");
                ps.setString(1, instuCde);
                ps.setString(2, userid);
                ResultSet rs = ps.executeQuery();
                List<Map<String, String>> datas = SqlUtil.rsToStrMap(rs);
                if (datas != null && !datas.isEmpty()) {
                    orgid = (String)((Map)datas.get(0)).get("ORG_CODE");
                }

                rs.close();
                ps.close();
            } catch (Exception var8) {
                LOGGER.error(var8.getMessage(), var8);
            }

            return orgid;
        } else {
            return orgid;
        }
    }

    public UserModel isValidUser(String orgid, String userid, String password, Connection con) {
        UserModel model = null;
        Object datas = new ArrayList();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT T0.*,T1.ORG_CODE FROM ADMIN_SM_USER T0 JOIN ADMIN_SM_ORG T1 ON(T0.ORG_ID=T1.ORG_ID) WHERE T0.LOGIN_CODE=?");
            ps.setString(1, userid);
            ResultSet rs = ps.executeQuery();
            datas = SqlUtil.rsToStrMap(rs);
            rs.close();
            ps.close();
        } catch (Exception var10) {
            LOGGER.error(var10.getMessage(), var10);
        }

        if (datas != null && !((List)datas).isEmpty()) {
            Map<String, String> userInfoMap = (Map)((List)datas).get(0);
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            boolean matches = passwordEncoder.matches(password, (String)userInfoMap.get("USER_PASSWORD"));
            if (matches) {
                model = this.toUserModel(userInfoMap);
                model.setUserstatus(1);
                model.setAdminflag(true);
                model.setWfadminflag(true);
                model.setSaflag(true);
                model.setPassword(password);
            }
        }

        return model;
    }

    public List getOrgLeaders(String orgid, Connection con) {
        LOGGER.error("方法[getOrgLeaders]没有做实现");
        return new ArrayList();
    }

    public List getOrgDirectors(String orgid, Connection con) {
        LOGGER.error("方法[getOrgDirectors]没有做实现");
        return new ArrayList();
    }

    public List getDepLeaders(String orgid, String depid, Connection con) {
        LOGGER.error("方法[getDepLeaders]没有做实现");
        return new ArrayList();
    }

    public List getDepDirectors(String orgid, String depid, Connection con) {
        LOGGER.error("方法[getDepDirectors]没有做实现");
        return new ArrayList();
    }

    public List getAllBaseRoles(Connection con) {
        return this.getAllRoles(con);
    }

    public List getAllRoles(Connection con) {
        return this.getAllRoles((String)null, con);
    }

    public List getAllRoles(String orgid, Connection con) {
        List list = new ArrayList();
        String instuCde = this.getCurrentInstuCde();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT T0.* FROM ADMIN_SM_ROLE T0 JOIN ADMIN_SM_ORG T1 ON(T0.ORG_ID=T1.ORG_ID) JOIN ADMIN_SM_INSTU T2 ON(T1.INSTU_ID=T2.INSTU_ID) WHERE T2.INSTU_CDE=? ");
            ps.setString(1, instuCde);
            ResultSet rs = ps.executeQuery();
            List<Map<String, String>> datas = SqlUtil.rsToStrMap(rs);
            if (datas != null && !datas.isEmpty()) {
                Iterator var9 = datas.iterator();

                while(var9.hasNext()) {
                    Map<String, String> role = (Map)var9.next();
                    RoleModel model = this.toRoleModel(role);
                    list.add(model);
                }
            }

            rs.close();
            ps.close();
        } catch (Exception var11) {
            LOGGER.error(var11.getMessage(), var11);
        }

        return list;
    }

    public List getRolesByName(String orgid, String roleName, Connection con) {
        ArrayList list = new ArrayList();

        try {
            String instuCde = this.getCurrentInstuCde();
            PreparedStatement ps = con.prepareStatement("SELECT T0.* FROM ADMIN_SM_ROLE T0 JOIN ADMIN_SM_ORG T1 ON(T0.ORG_ID=T1.ORG_ID) JOIN ADMIN_SM_INSTU T2 ON(T1.INSTU_ID=T2.INSTU_ID) WHERE T2.INSTU_CDE=? AND T0.ROLE_NAME LIKE ?");
            ps.setString(1, instuCde);
            ps.setString(2, "%" + roleName + "%");
            ResultSet rs = ps.executeQuery();
            List<Map<String, String>> datas = SqlUtil.rsToStrMap(rs);
            if (datas != null && !datas.isEmpty()) {
                Iterator var10 = datas.iterator();

                while(var10.hasNext()) {
                    Map<String, String> role = (Map)var10.next();
                    RoleModel roleModel = this.toRoleModel(role);
                    list.add(roleModel);
                }
            }

            rs.close();
            ps.close();
        } catch (Exception var12) {
            LOGGER.error(var12.getMessage(), var12);
        }

        return list;
    }

    public List getAllRoles(String orgid, String depid, Connection con) {
        return this.getAllRoles((String)null, con);
    }

    public RoleModel getRoleModel(String orgid, String roleid, Connection con) {
        RoleModel result = null;

        try {
            String instuCde = this.getCurrentInstuCde();
            PreparedStatement ps = con.prepareStatement("SELECT T0.* FROM ADMIN_SM_ROLE T0 JOIN ADMIN_SM_ORG T1 ON(T0.ORG_ID=T1.ORG_ID) JOIN ADMIN_SM_INSTU T2 ON(T1.INSTU_ID=T2.INSTU_ID) WHERE T2.INSTU_CDE=? AND T0.ROLE_CODE=?");
            ps.setString(1, instuCde);
            ps.setString(2, roleid);
            ResultSet rs = ps.executeQuery();
            List<Map<String, String>> datas = SqlUtil.rsToStrMap(rs);
            if (datas != null && !datas.isEmpty()) {
                result = this.toRoleModel((Map)datas.get(0));
            }

            rs.close();
            ps.close();
        } catch (Exception var9) {
            LOGGER.error(var9.getMessage(), var9);
        }

        return result;
    }

    public List getUsersByRole(String orgid, String roleid, Connection con) {
        ArrayList list = new ArrayList();

        try {
//            String instuCde = this.getCurrentInstuCde();
            PreparedStatement ps = con.prepareStatement("SELECT DISTINCT T0.* FROM ADMIN_SM_USER T0 JOIN ADMIN_SM_USER_ROLE_REL T1 ON(T0.USER_ID=T1.USER_ID) JOIN ADMIN_SM_ROLE T2 ON(T1.ROLE_ID=T2.ROLE_ID) JOIN ADMIN_SM_ORG T3 ON(T0.ORG_ID=T3.ORG_ID) WHERE T0.USER_STS='A' AND T2.ROLE_CODE=? AND T3.ORG_ID = ?");
//            ps.setString(1, instuCde);
            ps.setString(1, roleid);
            ps.setString(2, orgid);
            ResultSet rs = ps.executeQuery();
            List<Map<String, String>> datas = SqlUtil.rsToStrMap(rs);
            if(datas == null || datas.isEmpty()){
                ps = con.prepareStatement("SELECT DISTINCT T0.* FROM ADMIN_SM_USER T0 JOIN ADMIN_SM_USER_ROLE_REL T1 ON(T0.USER_ID=T1.USER_ID) JOIN ADMIN_SM_ROLE T2 ON(T1.ROLE_ID=T2.ROLE_ID) JOIN ADMIN_SM_ORG T3 ON(T0.ORG_ID=T3.ORG_ID) WHERE T0.USER_STS='A' AND T2.ROLE_CODE=? AND T3.ORG_ID like ?");
//                ps.setString(1, instuCde);
                ps.setString(1, roleid);
                ps.setString(2, orgid.substring(0,2) + "%");
                rs = ps.executeQuery();
                datas = SqlUtil.rsToStrMap(rs);
                if(datas == null || datas.isEmpty()){
                    ps = con.prepareStatement("SELECT DISTINCT T0.* FROM ADMIN_SM_USER T0 JOIN ADMIN_SM_USER_ROLE_REL T1 ON(T0.USER_ID=T1.USER_ID) JOIN ADMIN_SM_ROLE T2 ON(T1.ROLE_ID=T2.ROLE_ID) JOIN ADMIN_SM_ORG T3 ON(T0.ORG_ID=T3.ORG_ID) WHERE T0.USER_STS='A' AND T2.ROLE_CODE=? ");
//                    ps.setString(1, instuCde);
                    ps.setString(1, roleid);
                    rs = ps.executeQuery();
                    datas = SqlUtil.rsToStrMap(rs);
                }
            }
            if (datas != null && !datas.isEmpty()) {
                Iterator var10 = datas.iterator();

                while(var10.hasNext()) {
                    Map<String, String> user = (Map)var10.next();
                    UserModel userModel = this.toUserModel(user);
                    list.add(userModel);
                }
            }

            rs.close();
            ps.close();
        } catch (Exception var12) {
            LOGGER.error(var12.getMessage(), var12);
        }

        return list;
    }

    public List getRolesByUser(String orgid, String userid, Connection con) {
        ArrayList list = new ArrayList();

        try {
            String instuCde = this.getCurrentInstuCde();
            PreparedStatement ps = con.prepareStatement("SELECT DISTINCT T0.* FROM ADMIN_SM_ROLE T0 JOIN ADMIN_SM_USER_ROLE_REL T1 ON(T0.ROLE_ID=T1.ROLE_ID) JOIN ADMIN_SM_USER T2 ON(T1.USER_ID=T2.USER_ID) JOIN ADMIN_SM_ORG T3 ON(T2.ORG_ID=T3.ORG_ID) JOIN ADMIN_SM_INSTU T4 ON(T3.INSTU_ID=T4.INSTU_ID) WHERE T4.INSTU_CDE=? AND T2.LOGIN_CODE=?");
            ps.setString(1, instuCde);
            ps.setString(2, userid);
            ResultSet rs = ps.executeQuery();
            List<Map<String, String>> datas = SqlUtil.rsToStrMap(rs);
            if (datas != null && !datas.isEmpty()) {
                Iterator var10 = datas.iterator();

                while(var10.hasNext()) {
                    Map<String, String> role = (Map)var10.next();
                    RoleModel model = this.toRoleModel(role);
                    list.add(model);
                }
            }

            rs.close();
            ps.close();
        } catch (Exception var12) {
            LOGGER.error(var12.getMessage(), var12);
        }

        return list;
    }

    public List getAllBaseGroups(Connection con) {
        return this.getAllGroups(con);
    }

    public List getAllGroups(Connection con) {
        ArrayList list = new ArrayList();

        try {
            String instuCde = this.getCurrentInstuCde();
            PreparedStatement ps = con.prepareStatement("SELECT T0.* FROM ADMIN_SM_DUTY T0 JOIN ADMIN_SM_ORG T1 ON(T0.BELONG_ORG_ID=T1.ORG_ID) JOIN ADMIN_SM_INSTU T2 ON(T1.INSTU_ID=T2.INSTU_ID) WHERE T2.INSTU_CDE=?");
            ps.setString(1, instuCde);
            ResultSet rs = ps.executeQuery();
            List<Map<String, String>> datas = SqlUtil.rsToStrMap(rs);
            rs.close();
            ps.close();
            if (datas != null && !datas.isEmpty()) {
                for(int i = 0; i < datas.size(); ++i) {
                    GroupModel groupmodel = this.toGroupModel((Map)datas.get(i));
                    list.add(groupmodel);
                }
            }
        } catch (Exception var9) {
            LOGGER.error(var9.getMessage(), var9);
        }

        return list;
    }

    public List getAllGroups(String orgid, Connection con) {
        ArrayList list = new ArrayList();

        try {
            String instuCde = this.getCurrentInstuCde();
            PreparedStatement ps = con.prepareStatement("SELECT T0.* FROM ADMIN_SM_DUTY T0 JOIN ADMIN_SM_ORG T1 ON(T0.BELONG_ORG_ID=T1.ORG_ID) JOIN ADMIN_SM_INSTU T2 ON(T1.INSTU_ID=T2.INSTU_ID) WHERE T2.INSTU_CDE=?");
            ps.setString(1, instuCde);
            ResultSet rs = ps.executeQuery();
            List<Map<String, String>> datas = SqlUtil.rsToStrMap(rs);
            rs.close();
            ps.close();
            if (datas != null && !datas.isEmpty()) {
                for(int i = 0; i < datas.size(); ++i) {
                    Map duty = (Map)datas.get(i);
                    GroupModel groupmodel = this.toGroupModel(duty);
                    list.add(groupmodel);
                }
            }
        } catch (Exception var11) {
            LOGGER.error(var11.getMessage(), var11);
        }

        return list;
    }

    public List getAllGroups(String orgid, String depid, Connection con) {
        return this.getAllGroups(orgid, con);
    }

    public GroupModel getGroupModel(String orgid, String groupid, Connection con) {
        GroupModel groupModel = null;

        try {
            String instuCde = this.getCurrentInstuCde();
            PreparedStatement ps = con.prepareStatement("SELECT T0.* FROM ADMIN_SM_DUTY T0 JOIN ADMIN_SM_ORG T1 ON(T0.BELONG_ORG_ID=T1.ORG_ID) JOIN ADMIN_SM_INSTU T2 ON(T1.INSTU_ID=T2.INSTU_ID) WHERE T2.INSTU_CDE=? AND DUTY_CDE=?");
            ps.setString(1, instuCde);
            ps.setString(2, groupid);
            ResultSet rs = ps.executeQuery();
            List<Map<String, String>> datas = SqlUtil.rsToStrMap(rs);
            rs.close();
            ps.close();
            if (datas != null && !datas.isEmpty()) {
                groupModel = this.toGroupModel((Map)datas.get(0));
            }
        } catch (Exception var9) {
            LOGGER.error(var9.getMessage(), var9);
        }

        return groupModel;
    }

    public List getUsersByGroup(String orgid, String groupid, Connection con) {
        ArrayList list = new ArrayList();

        try {
            String instuCde = this.getCurrentInstuCde();
            PreparedStatement ps = con.prepareStatement("SELECT T0.* FROM ADMIN_SM_USER T0 JOIN ADMIN_SM_USER_DUTY_REL T1 ON(T0.USER_ID=T1.USER_ID) JOIN ADMIN_SM_DUTY T2 ON(T1.DUTY_ID=T2.DUTY_ID) JOIN ADMIN_SM_ORG T3 ON(T2.BELONG_ORG_ID=T3.ORG_ID) JOIN ADMIN_SM_INSTU T4 ON(T3.INSTU_ID=T4.INSTU_ID) WHERE T0.USER_STS='A' AND T4.INSTU_CDE=? AND T2.DUTY_CDE=?");
            ps.setString(1, instuCde);
            ps.setString(2, groupid);
            ResultSet rs = ps.executeQuery();
            List<Map<String, String>> datas = SqlUtil.rsToStrMap(rs);
            rs.close();
            ps.close();
            if (datas != null && !datas.isEmpty()) {
                Iterator var10 = datas.iterator();

                while(var10.hasNext()) {
                    Map<String, String> user = (Map)var10.next();
                    list.add(this.toUserModel(user));
                }
            }
        } catch (Exception var11) {
            LOGGER.error(var11.getMessage(), var11);
        }

        return list;
    }

    public List getGroupByUser(String orgid, String userid, Connection con) {
        ArrayList list = new ArrayList();

        try {
            String instuCde = this.getCurrentInstuCde();
            PreparedStatement ps = con.prepareStatement("SELECT T0.* FROM ADMIN_SM_DUTY T0 JOIN ADMIN_SM_USER_DUTY_REL T1 ON(T0.DUTY_ID=T1.DUTY_ID) JOIN ADMIN_SM_USER T2 ON(T1.USER_ID=T2.USER_ID) JOIN ADMIN_SM_ORG T3 ON(T0.BELONG_ORG_ID=T3.ORG_ID) JOIN ADMIN_SM_INSTU T4 ON(T3.INSTU_ID=T4.INSTU_ID) WHERE T4.INSTU_CDE=? AND T2.LOGIN_CODE=? ");
            ps.setString(1, instuCde);
            ps.setString(2, userid);
            ResultSet rs = ps.executeQuery();
            List<Map<String, String>> datas = SqlUtil.rsToStrMap(rs);
            rs.close();
            ps.close();
            if (datas != null && !datas.isEmpty()) {
                Iterator var10 = datas.iterator();

                while(var10.hasNext()) {
                    Map<String, String> duty = (Map)var10.next();
                    GroupModel groupModel = this.toGroupModel(duty);
                    list.add(groupModel);
                }
            }
        } catch (Exception var12) {
            LOGGER.error(var12.getMessage(), var12);
        }

        return list;
    }

    public String getGrantor(String orgid, String userid, String appid, Connection con) {
        LOGGER.error("方法[getGrantor]没有做实现");
        return null;
    }

    public List getSuperiorUsers(String orgid, String userid, Connection con) {
        Object list = new ArrayList();

        try {
            OrgModel supOrg = this.getParentOrg(orgid, con);
            if (supOrg == null) {
                return (List)list;
            }

            String supOrgId = supOrg.getOrgid();
            if (supOrgId != null && !supOrgId.equals(orgid)) {
                list = this.getDirectUsersByOrg(supOrgId, con);
            }
        } catch (Exception var7) {
            LOGGER.error(var7.getMessage(), var7);
        }

        return (List)list;
    }

    public List getJuniorUsers(String orgid, String userid, Connection con) {
        ArrayList list = new ArrayList();

        try {
            List<UserModel> supOrgList = this.getDirectUsersByOrg(orgid, con);
            if (supOrgList != null && !supOrgList.isEmpty()) {
                list.addAll(supOrgList);
            }

            List<OrgModel> subOrgList = this.getDirectSubOrgs(orgid, con);
            if (subOrgList != null) {
                Iterator var8 = subOrgList.iterator();

                while(var8.hasNext()) {
                    OrgModel subOrg = (OrgModel)var8.next();
                    List listTemp = this.getDirectUsersByOrg(subOrg.getOrgid(), con);
                    list.addAll(listTemp);
                }
            }
        } catch (Exception var10) {
            LOGGER.error(var10.getMessage(), var10);
        }

        return list;
    }

    public List getSameDepUsers(String orgid, String userid, Connection con) {
        LOGGER.error("方法[getSameDepUsers]没有做实现");
        return new ArrayList();
    }

    public List getSameOrgUsers(String orgid, String userid, Connection con) {
        Object list = new ArrayList();

        try {
            if (userid != null && userid.length() > 0) {
                UserModel userTmp = this.getUserModel(userid, con);
                orgid = userTmp.getOrgid();
            }

            list = this.getDirectUsersByOrg(orgid, con);
        } catch (Exception var6) {
            LOGGER.error(var6.getMessage(), var6);
        }

        return (List)list;
    }

    public String getUserEmail(String orgid, String userid, Connection con) {
        UserModel userModel = this.getUserModel(userid, con);
        String strResult = userModel.getEmail();
        return strResult;
    }

    public void loadOUCache(OUCache oucache, Connection con) {
        LOGGER.warn("不使用组织机构的jvm缓存，不做缓存加载");
    }

    public List getAllWFClient(String status, Connection con) {
        ArrayList list = new ArrayList();

        try {
            String strSql = "SELECT PKEY,CLIENTSIGN,CLIENTNAME,IP,TYPE,INVOKETYPE,STATUS,REMARK FROM WF_CLIENT ";
            if (status != null && status.length() > 0) {
                strSql = strSql + " WHERE STATUS= ?";
            }

            PreparedStatement ps = con.prepareStatement(strSql);
            if (status != null && status.length() > 0) {
                ps.setString(1, status);
            }

            ResultSet rs = ps.executeQuery();
            List<Map<String, String>> datas = SqlUtil.rsToStrMap(rs);
            rs.close();
            ps.close();
            if (datas != null && !datas.isEmpty()) {
                Iterator var9 = datas.iterator();

                while(var9.hasNext()) {
                    Map<String, String> wfClientTemp = (Map)var9.next();
                    WFClient wfClient = new WFClient();
                    wfClient.setPkey((String)wfClientTemp.get("PKEY"));
                    wfClient.setClientSign((String)wfClientTemp.get("CLIENTSIGN"));
                    wfClient.setClientName((String)wfClientTemp.get("CLIENTNAME"));
                    wfClient.setIP((String)wfClientTemp.get("IP"));
                    wfClient.setType((String)wfClientTemp.get("TYPE"));
                    wfClient.setInvokeType((String)wfClientTemp.get("INVOKETYPE"));
                    wfClient.setStatus((String)wfClientTemp.get("STATUS"));
                    wfClient.setRemark((String)wfClientTemp.get("REMARK"));
                    list.add(wfClient);
                }
            }
        } catch (Exception var11) {
            LOGGER.error(var11.getMessage(), var11);
        }

        return list;
    }

    public List<UserModel> queryUserModelsByName(String name, Connection con) {
        ArrayList list = new ArrayList();

        try {
            String instuCde = this.getCurrentInstuCde();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM ADMIN_SM_USER T0 JOIN ADMIN_SM_ORG T1 ON(T0.ORG_ID=T1.ORG_ID) JOIN ADMIN_SM_INSTU T2 ON(T1.INSTU_ID=T2.INSTU_ID)WHERE T2.INSTU_CDE=? AND T0.USER_NAME LIKE ?");
            ps.setString(1, instuCde);
            ps.setString(2, "%" + name + "%");
            ResultSet rs = ps.executeQuery();
            List<Map<String, String>> datas = SqlUtil.rsToStrMap(rs);
            Iterator var9 = datas.iterator();

            while(var9.hasNext()) {
                Map<String, String> user = (Map)var9.next();
                UserModel userModel = this.toUserModel(user);
                list.add(userModel);
            }

            rs.close();
            ps.close();
        } catch (Exception var11) {
            LOGGER.error(var11.getMessage(), var11);
        }

        return list;
    }

    public List getUpUpOrgUsers(String orgid, Connection con) {
        Object list = new ArrayList();

        try {
            OrgModel supOrg = this.getParentOrg(orgid, con);
            if (supOrg == null) {
                return (List)list;
            }

            String supOrgNo = supOrg.getOrgid();
            OrgModel supSupOrg = this.getParentOrg(supOrgNo, con);
            if (supSupOrg == null) {
                return (List)list;
            }

            String supSupOrgNo = supSupOrg.getOrgid();
            list = this.getDirectUsersByOrg(supSupOrgNo, con);
        } catch (Exception var8) {
            LOGGER.error(var8.getMessage(), var8);
        }

        return (List)list;
    }

    public List getUpUpOrgDownOrgUsers(String orgid, Connection con) {
        ArrayList list = new ArrayList();

        try {
            OrgModel supOrg = this.getParentOrg(orgid, con);
            if (supOrg == null) {
                return list;
            }

            OrgModel supSupOrg = this.getParentOrg(supOrg.getOrgid(), con);
            if (supSupOrg == null) {
                return list;
            }

            if (supSupOrg != null) {
                List<OrgModel> subOrgList = this.getDirectSubOrgs(supSupOrg.getOrgid(), con);
                if (subOrgList != null) {
                    Iterator var8 = subOrgList.iterator();

                    while(var8.hasNext()) {
                        OrgModel subOrg = (OrgModel)var8.next();
                        List listTemp = this.getDirectUsersByOrg(subOrg.getOrgid(), con);
                        list.addAll(listTemp);
                    }
                }
            }
        } catch (Exception var10) {
            LOGGER.error(var10.getMessage(), var10);
        }

        return list;
    }

    public List getUpDownOrgUsers(String orgid, Connection con) {
        ArrayList list = new ArrayList();

        try {
            OrgModel supOrg = this.getParentOrg(orgid, con);
            if (supOrg == null) {
                return list;
            }

            String supOrgNo = supOrg.getOrgid();
            List<UserModel> supOrgList = this.getDirectUsersByOrg(supOrgNo, con);
            if (supOrgList != null && !supOrgList.isEmpty()) {
                list.addAll(supOrgList);
            }

            List<OrgModel> subOrgList = this.getDirectSubOrgs(orgid, con);
            if (subOrgList != null) {
                Iterator var9 = subOrgList.iterator();

                while(var9.hasNext()) {
                    OrgModel subOrg = (OrgModel)var9.next();
                    List listTemp = this.getDirectUsersByOrg(subOrg.getOrgid(), con);
                    list.addAll(listTemp);
                }
            }
        } catch (Exception var11) {
            LOGGER.error(var11.getMessage(), var11);
        }

        return list;
    }

    public List getSameOrgLine(String orgid, Connection con) {
        ArrayList list = new ArrayList();

        try {
            String instuCde = this.getCurrentInstuCde();
            PreparedStatement ps = con.prepareStatement("SELECT T0.* FROM(SELECT * FROM ADMIN_SM_ORG START WITH ORG_CODE=? CONNECT BY NOCYCLE PRIOR UP_ORG_ID=ORG_ID)T0 JOIN ADMIN_SM_INSTU T1 ON(T0.INSTU_ID=T1.INSTU_ID) WHERE T1.INSTU_CDE=?");
            ps.setString(1, orgid);
            ps.setString(2, instuCde);
            ResultSet rs = ps.executeQuery();
            List<Map<String, String>> datas = SqlUtil.rsToStrMap(rs);
            rs.close();
            ps.close();
            if (datas != null && !datas.isEmpty()) {
                Iterator var9 = datas.iterator();

                while(var9.hasNext()) {
                    Map<String, String> bch = (Map)var9.next();
                    OrgModel supOrgModel = this.toOrgModel(bch);
                    list.add(supOrgModel.getOrgid());
                }
            }
        } catch (Exception var11) {
            LOGGER.error(var11.getMessage(), var11);
        }

        return list;
    }

    public List getSameOrgLineUsers(String orgid, Connection con) {
        List list = new ArrayList();
        List supOrgs = this.getSameOrgLine(orgid, con);

        for(int i = 0; i < supOrgs.size(); ++i) {
            String orgidTmp = (String)supOrgs.get(i);

            try {
                List listTemp = this.getDirectUsersByOrg(orgidTmp, con);
                if (listTemp != null & !listTemp.isEmpty()) {
                    list.addAll(listTemp);
                }
            } catch (Exception var8) {
                LOGGER.error(var8.getMessage(), var8);
            }
        }

        return list;
    }

    public String getDeptOrgid(String orgid, Connection con) {
        LOGGER.error("方法[getDeptOrgid]没有做实现");
        return null;
    }

    public List getSubDeptByOrgid(String orgid, Connection con) {
        LOGGER.error("方法[getSubDeptByOrgid]没有做实现");
        return new ArrayList();
    }

    public List getUpAndUpUpOrgUsers(String orgid, Connection con) {
        ArrayList list = new ArrayList();

        try {
            OrgModel supOrg = this.getParentOrg(orgid, con);
            if (supOrg == null) {
                return list;
            }

            String supOrgNo = supOrg.getOrgid();
            List listTemp = this.getDirectUsersByOrg(supOrgNo, con);
            if (listTemp != null & !listTemp.isEmpty()) {
                list.addAll(listTemp);
            }

            OrgModel supSupOrg = this.getParentOrg(supOrgNo, con);
            if (supSupOrg == null) {
                return list;
            }

            String supSupOrgNo = supSupOrg.getOrgid();
            List listTemp2 = this.getDirectUsersByOrg(supSupOrgNo, con);
            if (listTemp2 != null & !listTemp2.isEmpty()) {
                list.addAll(listTemp2);
            }
        } catch (Exception var10) {
            LOGGER.error(var10.getMessage(), var10);
        }

        return list;
    }

    public List getSampeAndUpOrgUsers(String orgid, Connection con) {
        List list = new ArrayList();
        list.addAll(this.getSameOrgUsers(orgid, (String)null, con));
        list.addAll(this.getSuperiorUsers(orgid, (String)null, con));
        return list;
    }

    public List getSampeOrgOrDeptUsers(String orgid, Connection con) {
        return new ArrayList();
    }

    protected OrgModel toOrgModel(Map<String, String> org) {
        OrgModel orgModel = new OrgModel();
        String orgId = (String)org.get("ORG_ID");
        String supOrgId = (String)org.get("UP_ORG_ID");
        if (orgId.equals(supOrgId)) {
            supOrgId = null;
        }

        orgModel.setOrgid(orgId);
        orgModel.setOrgname((String)org.get("ORG_NAME"));
        orgModel.setSuporgid(supOrgId);
        int orgLevel = Integer.valueOf((String)org.get("ORG_LEVEL"));
        orgModel.setOrglevel(orgLevel);
        if (orgLevel == 1) {
            orgModel.setSuporgid((String)null);
        }

        return orgModel;
    }

    protected UserModel toUserModel(Map<String, String> user) {
        UserModel userModel = new UserModel();
        userModel.setUserid((String)user.get("LOGIN_CODE"));
        userModel.setUsername((String)user.get("USER_NAME"));
        userModel.setEmail((String)user.get("USER_EMAIL"));
        userModel.setMobile((String)user.get("USR_OFFICETEL"));
        userModel.setOrgid((String)user.get("ORG_CODE"));
        return userModel;
    }

    private GroupModel toGroupModel(Map<String, String> duty) {
        GroupModel groupModel = new GroupModel();
        groupModel.setGroupid((String)duty.get("DUTY_CDE"));
        groupModel.setGroupname((String)duty.get("DUTY_NAME"));
        groupModel.setOrgid((String)duty.get("BELONG_ORG_ID"));
        return groupModel;
    }

    private RoleModel toRoleModel(Map<String, String> role) {
        RoleModel roleModel = new RoleModel();
        roleModel.setRoleid((String)role.get("ROLE_CODE"));
        roleModel.setRolename((String)role.get("ROLE_NAME"));
        roleModel.setOrgid((String)role.get("ORG_ID"));
        return roleModel;
    }

    protected String getCurrentInstuCde() {
        EChainRuntimeContext config = EChainRuntimeContext.instance();
        String instuCde = config.getInstuCde();
        return instuCde;
    }

    protected String getSignUser() {
        EChainRuntimeContext config = EChainRuntimeContext.instance();
        String signUser = config.getSignUserName();
        return signUser;
    }
}
