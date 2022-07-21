package cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.web.rest;

import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.service.PmaSystemUtilService;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version 1.0.0
 * @项目名称：yusp-frame
 * @类名称：PmaSystemUtilResource @类描述：
 * @功能描述:控件工具查询
 * @创建人：lcrack @创建时间：2017/12/18 14:35 @修改备注：
 * @修改日期 修改人员 修改原因 -------- -------- ----------------------------------------
 * modify by Cytus_ at 20180904 修改sonar扫描出现的bug， SimpleDateFormat类为线程不安全类，故不使用全局变量进行定义，改为局部变量定义方式
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/pmautil")
public class PmaSystemUtilResource {
    private static final Logger log = LoggerFactory.getLogger(PmaSystemUtilResource.class);
    //private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Autowired
    private PmaSystemUtilService service;

    /**
     * @param needManageOrg-需要管理机构
     * @方法名称: getOrgByParam
     * @方法描述:
     * @参数与返回说明:
     * @算法描述:
     */
    @GetMapping("/getorg")
    public ResultDto<List<Map<String, Object>>> getOrgByParam(String userId,  String orgId,
                                                              boolean needManageOrg,boolean lazy) {
        List<Map<String, Object>> list = service.getOrgByParam(orgId, userId, needManageOrg,lazy);
        return new ResultDto<>(list.size(), list);
    }
    
    /**
     * 
     * @方法名称: getorgById
     * @方法描述: 依据机构号查询机构信息（前端yufpOrgTree组件用）
     * @参数与返回说明:
     * @算法描述:
     */
    @GetMapping("/getorgById")
    public ResultDto<Map<String, Object>> getorgById(String orgId) {
        Map<String, Object> org = service.getorgById(orgId);
        return new ResultDto<>(1, org);
    }
    
    /**
     * 
     * @方法名称: getorgByIds
     * @方法描述: 依据机构号查询机构信息（前端yufpOrgTree组件用）, 兼容多个机构编号
     * @参数与返回说明:
     * @算法描述:
     */
    @GetMapping("/getorgByIds")
    public ResultDto<List<Map<String, Object>>> getorgByIds(String orgIds) {
        List<Map<String, Object>> org = service.getorgByIds(orgIds);
        return new ResultDto<>(1, org);
    }

    /**
     * @param orgId:机构代码-必传
     * @param orgLevel:机构层级-可以不传递,默认查询所有层级否则查询<=orgLevel
     * @param userId:用户id当需要管理机构的时候必须传递
     * @param needManage:是否需要当前用户的管理机构
     * @param needDpt:是否需要机构下的部门
     * @方法名称: getOrgtreeByParam
     * @方法描述: 获取机构控件数据
     * @参数与返回说明:
     * @算法描述:
     */
    @GetMapping("/getorgtree")
    public ResultDto<List<Map<String, Object>>> getOrgtreeByParam(@RequestParam String orgId, String userId,
                                                                  String orgLevel, boolean needManage, boolean
                                                                          needFin, boolean needDpt,boolean lazy, boolean needTeam) {
        log.debug("获取机构控件数据--传递参数:orgId:{},userId:{},orgLevel:{},needFin:{},needManage:{},needDpt:{}", orgId,
                userId, orgLevel, needFin, needManage, needDpt);
        List<Map<String, Object>> list = service.getOrgtreeByParam(orgId, userId, needManage, needFin, needDpt, orgLevel,lazy,needTeam);
        return new ResultDto<>(list.size(), list);
    }
    /**
     * @param orgId:机构代码-必传
     * @param orgLevel:机构层级-可以不传递,默认查询所有层级否则查询<=orgLevel
     * @param userId:用户id当需要管理机构的时候必须传递
     * @param needManage:是否需要当前用户的管理机构
     * @param needDpt:是否需要机构下的部门
     * @方法名称: getOrgtreeByParam
     * @方法描述: 获取机构控件数据
     * @参数与返回说明:
     * @算法描述:
     */
    @GetMapping("/getorgtreeapp")
    public ResultDto<List<Map<String, Object>>> getOrgtreeByParamApp(@RequestParam String orgId, boolean lazy) {
        List<Map<String, Object>> list = service.getOrgtreeByParamApp(orgId,lazy);
        return new ResultDto<>(list.size(), list);
    }
    /**
     * @param orgCode-所属机构
     * @方法名称: getDptByParam
     * @方法描述: 获取部门信息
     * @参数与返回说明:
     * @算法描述:
     */
    @GetMapping("/getdpt")
    public ResultDto<List<Map<String, Object>>> getDptByParam(@RequestParam(required = false) String orgCode) {
        Map<String, Object> params = new HashMap<String, Object>();
        log.debug("获取部门信息--传递参数: orgCode:{}", orgCode);
        params.put("orgCode", orgCode);
        return new ResultDto<>(service.getDptByParam(params).size(), service.getDptByParam(params));
    }

    /**
     * @param orgCode:默认传递当前用户session机构代码-必须
     * @param searchType:查询类型
     * @param loginCode:登陆代码
     * @param userName:用户姓名
     * @param roleId:角色
     * @param dutyId:岗位
     * @param page:第几页-必须
     * @param size:每页大小-必须
     * @方法名称: getUserByParam
     * @方法描述:
     * @参数与返回说明:
     * @算法描述:
     */
    @GetMapping("/getuser")
    public ResultDto<List<Map<String, Object>>> getUserByParam(@RequestParam String orgCode, @RequestParam Integer page,
                                                               @RequestParam Integer size, String searchType, String
                                                                       loginCode, String userName, String roleId,
                                                               String dutyId) {
        log.debug("获取用户信息--传递参数:orgCode:{},searchType:{},loginCode:{},userName:{},roleId:{},dutyId:{}", orgCode,
                searchType, loginCode, userName, roleId, dutyId);
        PageHelper.startPage(page, size);
        Map<String, Object> params = new HashMap<>();
        params.put("orgCode", orgCode);
        params.put("searchType", searchType);
        params.put("loginCode", loginCode);
        params.put("userName", userName);
        params.put("roleId", roleId);
        params.put("dutyId", dutyId);
        List<Map<String, Object>> result = service.getUserByParam(params);
        PageHelper.clearPage();
        ResultDto<List<Map<String, Object>>> resultDto = new ResultDto<>(result);
        resultDto.setMessage("请求数据成功!");
        resultDto.setCode(200);
        return resultDto;
    }
    /**
     * @param orgCode:默认传递当前用户session机构代码-必须
     * @param searchType:查询类型
     * @param loginCode:登陆代码
     * @param userName:用户姓名
     * @param roleId:角色
     * @param dutyId:岗位
     * @param page:第几页-必须
     * @param size:每页大小-必须
     * @方法名称: getUserByParam
     * @方法描述:
     * @参数与返回说明:
     * @算法描述:
     */
    @GetMapping("/getusertd")
    public ResultDto<List<Map<String, Object>>> getUserTdByParam(@RequestParam String orgCode, @RequestParam Integer page,
                                                               @RequestParam Integer size, String searchType, String
                                                                       loginCode, String userName, String roleId,
                                                               String dutyId) {
        log.debug("获取用户信息--传递参数:orgCode:{},searchType:{},loginCode:{},userName:{},roleId:{},dutyId:{}", orgCode,
                searchType, loginCode, userName, roleId, dutyId);
        PageHelper.startPage(page, size);
        Map<String, Object> params = new HashMap<>();
        params.put("orgCode", orgCode);
        params.put("searchType", searchType);
        params.put("loginCode", loginCode);
        params.put("userName", userName);
        params.put("roleId", roleId);
        params.put("dutyId", dutyId);
        List<Map<String, Object>> result = service.getUserTdByParam(params);
        PageHelper.clearPage();
        ResultDto<List<Map<String, Object>>> resultDto = new ResultDto<>(result);
        resultDto.setMessage("请求数据成功!");
        resultDto.setCode(200);
        return resultDto;
    }
    /**
     * @param orgCode:默认传递当前用户session机构代码
     * @param roleCode:角色代码
     * @param roleName:角色名称
     * @param roleLevel:角色层级
     * @param searchType:查询类型(所辖或者当前)
     * @param page:页数
     * @param size:每页记录数
     * @方法名称: getRoleByParam
     * @方法描述: 根据参数获取角色信息
     * @参数与返回说明:
     * @算法描述:
     */
    @GetMapping("/getrole")
    public ResultDto<List<Map<String, Object>>> getRoleByParam(@RequestParam String orgCode, @RequestParam Integer page,
                                                               @RequestParam Integer size, String searchType, String
                                                                       roleCode, String roleName, String
                                                                       roleLevel) {
        log.debug("获取角色信息--传递参数:orgCode:{},searchType:{},roleCode:{},roleName:{},roleLevel:{}", orgCode, searchType,
                roleCode, roleName, roleLevel);
        PageHelper.startPage(page, size);
        Map<String, Object> params = new HashMap<>();
        params.put("orgCode", orgCode);
        params.put("searchType", searchType);
        params.put("roleCode", roleCode);
        params.put("roleName", roleName);
        params.put("roleLevel", roleLevel);
        List<Map<String, Object>> result = service.getRoleByParam(params);
        PageHelper.clearPage();
        ResultDto<List<Map<String, Object>>> resultDto = new ResultDto<>(result);
        resultDto.setMessage("请求数据成功!");
        resultDto.setCode(200);
        return resultDto;
    }

    /**
     * @param orgCode:默认传递当前用户session机构代码
     * @param dutyCode:岗位代码
     * @param dutyName:岗位名称
     * @方法名称: getDutyByParam
     * @方法描述: 根据condition查询岗位信息
     * @参数与返回说明:
     * @算法描述:
     */
    @GetMapping("/getduty")
    public ResultDto<List<Map<String, Object>>> getDutyByParam(@RequestParam String orgCode, @RequestParam Integer
            page,
                                                               @RequestParam Integer size, String searchType, String
                                                                       dutyCode, String dutyName) {
        PageHelper.startPage(page, size);
        log.debug("获取岗位信息--传递参数:orgCode:{},searchType:{},dutyCode:{},dutyName:{}", orgCode, searchType, dutyCode,
                dutyName);
        Map<String, Object> params = new HashMap<>();
        params.put("orgCode", orgCode);
        params.put("searchType", searchType);
        params.put("dutyCode", dutyCode);
        params.put("dutyName", dutyName);
        List<Map<String, Object>> result = service.getDutyByParam(params);
        PageHelper.clearPage();
        ResultDto<List<Map<String, Object>>> resultDto = new ResultDto<>(result);
        resultDto.setMessage("请求数据成功!");
        resultDto.setCode(200);
        return resultDto;
    }


    /**
     * @方法名称: getRoleByUser
     * @方法描述: 根据session会话信息获取当前用户管理角色
     * @参数与返回说明:
     * @算法描述:
     */
    @GetMapping("/getrolebyuser")
    public ResultDto<List<Map<String, Object>>> getRoleByUser(@RequestParam String userId) {
        return new ResultDto<List<Map<String, Object>>>(service.getRoleByUser(userId));
    }

    /**
     * @方法名称: getDutyByUser
     * @方法描述: 根据session会话信息获取当前用户管理部门
     * @参数与返回说明:
     * @算法描述:
     */
    @GetMapping("/getdutybyuser")
    public ResultDto<List<Map<String, Object>>> getDutyByUser(@RequestParam String userId) {
        return new ResultDto<List<Map<String, Object>>>(service.getDutyByUser(userId));
    }


    @GetMapping("/getTeamOrMktInfo")
    public ResultDto<List<Map<String, Object>>> getTeamOrMktInfo(String orgId,String evlObjType) {
        return new ResultDto<List<Map<String, Object>>>(service.getTeamOrMktInfo(orgId,evlObjType));
    }


    @GetMapping("/getLookUpItemByIndexId")
    public ResultDto<List<Map<String, Object>>> getLookUpItemByIndexId(String lookUpCode, String indexId) {
        return new ResultDto<List<Map<String, Object>>>(service.getLookUpItemByIndexId(lookUpCode,indexId));
    }
}
