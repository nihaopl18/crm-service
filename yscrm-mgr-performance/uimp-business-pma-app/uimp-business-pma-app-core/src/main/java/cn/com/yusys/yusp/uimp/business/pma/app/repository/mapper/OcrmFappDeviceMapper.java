package cn.com.yusys.yusp.uimp.business.pma.app.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.uimp.business.pma.app.model.APPVersion;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @项目名称: yscrm-base-core模块
 * @类名称: OcrmFappDeviceInfoMapper
 * @类描述: # APP设备信息表 Dao类
 * @功能描述:
 * @创建人: lixt1
 * @创建时间: 2019-05-13 15:43:04
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 *        -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface OcrmFappDeviceMapper extends CommonMapper<APPVersion> {
	String getUuidNext();

	void addAppVersion(APPVersion appVersion);
	

	String queryVersion(@Param("downloadBelong") String downloadBelong);
	

	void addRecordDownload(@Param("downloadBelong") String downloadBelong,@Param("downloadVersion") String downloadVersion);

	void deleteAppVersion(APPVersion appVersion);

	Map<String, Object> checkVersion(@Param("versionBelong") String versionBelong);

	void updateAppVersion(APPVersion appVersion);

	List<Map<String, Object>> queryAppVersion(QueryModel model);
}