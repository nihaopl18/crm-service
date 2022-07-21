package cn.com.yusys.yscrm.custgrade.repository.mapper;

import java.util.List;
import java.util.Map;

import cn.com.yusys.yscrm.custgrade.domain.OcrmCiGradePreferent;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

/**
 * @项目名称: yscrm-mgr-cust-grade-core模块
 * @类名称: OcrmCiGradePreferentMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-13 10:36:49
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface OcrmCiGradePreferentMapper extends CommonMapper<OcrmCiGradePreferent> {
 public List<Map<String,Object>> querylist (QueryModel Model);
 public List<Map<String,Object>> detail(String preferentId);
 public int deletebyPreFerentId(String preferentId);
 public String seacherSeqGradePre();
 public void deleteByPreId(String preferentId);
}