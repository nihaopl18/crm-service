package cn.com.yusys.yusp.admin.service;

import cn.com.yusys.yusp.uaa.client.dto.DataContrDTO;
import cn.com.yusys.yusp.uaa.client.dto.MenuContrDTO;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;

import java.util.List;

/**
 * @version 1.0.0
 * @项目名称: yusp-uaa
 * @类名称: UaaUserService
 * @类描述: 用户表操作
 * @功能描述:
 * @创建人: geql@yusys.com.cn
 * @创建时间: 2018-02-02 14:47
 * @修改备注:
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface UaaMenuContrDataInfoService {


    /**
     * @方法名称: getUserInfo
     * @方法描述:
     * @参数与返回说明:
     * @算法描述: 无
     */
    UserInfoDTO getUserInfo(String loginCode, String sysId, String roleId);

    /**
     * @方法名称: getMenuandContr
     * @方法描述: 获取用户菜单和控制点信息，放入缓存
     * @参数与返回说明: 用户放入session中的信息；
     * @算法描述:
     */
    MenuContrDTO getMenuandContr(UserInfoDTO userInfo,String roleId);

    /**
     * @方法名称: getDataContr
     * @方法描述: 获取用户数据权限信息，放入缓存
     * @参数与返回说明: 用户放入session中的信息；
     * @算法描述:
     */
    List<DataContrDTO> getDataContr(UserInfoDTO userInfo,String roleId);


}
