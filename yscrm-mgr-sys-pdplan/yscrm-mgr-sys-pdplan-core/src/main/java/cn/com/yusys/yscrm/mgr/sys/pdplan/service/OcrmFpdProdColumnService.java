package cn.com.yusys.yscrm.mgr.sys.pdplan.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.util.UtilTools;
import cn.com.yusys.yscrm.mgr.sys.pdplan.domain.OcrmFpdProdColumn;
import cn.com.yusys.yscrm.mgr.sys.pdplan.repository.mapper.OcrmFpdProdColumnMapper;
/**
 * @项目名称: yscrm-mgr-sys-pdplan-core模块
 * @类名称: OcrmFpdProdColumnService
 * @类描述: 产品展示表属性定义
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-01-23 19:29:10
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class OcrmFpdProdColumnService extends CommonService {
    @Autowired
    private OcrmFpdProdColumnMapper ocrmFpdProdColumnMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return this.ocrmFpdProdColumnMapper;
    }
    /*
     * 删除已经存在的表属性定义信息，再新增
     */
    @Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
	public int save(List<OcrmFpdProdColumn> ocrmFpdProdColumns) {
		// TODO 自动生成的方法存根
		ocrmFpdProdColumnMapper.delColumnsByTableId(ocrmFpdProdColumns.get(0).getTableId());
		int num = 0;
		for (int i = 0; i < ocrmFpdProdColumns.size(); i++) {
			OcrmFpdProdColumn ocrmFpdProdColumn = ocrmFpdProdColumns.get(i);
			ocrmFpdProdColumn.setColumnId(UUID.randomUUID().toString().replaceAll("-", ""));
			UtilTools.updateUtl(ocrmFpdProdColumn);
			num += insertSelective(getMapper(),ocrmFpdProdColumn);
		}
		return num;
	}

}
