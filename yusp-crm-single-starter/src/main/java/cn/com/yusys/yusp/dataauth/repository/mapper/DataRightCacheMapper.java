package cn.com.yusys.yusp.dataauth.repository.mapper;

import cn.com.yusys.yusp.uaa.client.dto.DataContrDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @version 1.0.0
 * @项目名称: 数据权限模块
 * @类名称: DataRightCacheMapper
 * @类描述: #数据权限dao类
 * @功能描述: 数据权限列表查询信息
 * @创建人: admin
 * @创建时间: 2018-10-29 120:49:02
 * @修改备注:
 * @修改记录: 修改时间    修改人员    修改原因
 *            2018-10-29    liuaj	   目前数据权限支持微服务的模式，故改为单体模式操作
 * -------------------------------------------------------------
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface DataRightCacheMapper {

	public List<DataContrDTO> selectDataAuthList(@Param("loginCode") String loginCode, @Param("sysId") String sysId,@Param("selectRole") String selectRole);

}	
