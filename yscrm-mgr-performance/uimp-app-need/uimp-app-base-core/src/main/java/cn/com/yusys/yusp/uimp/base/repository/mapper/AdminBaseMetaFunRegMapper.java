package cn.com.yusys.yusp.uimp.base.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.uimp.base.domain.AdminBaseMetaFunReg;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @项目名称: uimp-app-base-core模块
 * @类名称: AdminBaseMetaFuncRegMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-12-07 17:56:14
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
public interface AdminBaseMetaFunRegMapper extends CommonMapper<AdminBaseMetaFunReg> {
	List<Map<String, Object>> querylist(QueryModel model);
	List<AdminBaseMetaFunReg> queryAll();
	void createbusifunc(@Param("funcName") String funcName,@Param("funcDesc") String funcDesc,@Param("funcUrl") String funcUrl);
	AdminBaseMetaFunReg getAdminBaseMetaFunReg(@Param("funCode") String funCode);
	void deletebusifunc(@Param("funcUrl") String funcUrl);
	void delFuncode(@Param("funCode") String funCode);
	void delColumnTable(@Param("funCode") String funCode);
	void delColumnCfgTable(@Param("funCode") String funCode);
}