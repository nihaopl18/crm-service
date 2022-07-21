package cn.com.yusys.yscimc.operation.service.impl;

import cn.com.yusys.yscimc.operation.domain.OcrmFCiFqRelation;
import cn.com.yusys.yscimc.operation.domain.vo.FqRelationVo;
import cn.com.yusys.yscimc.operation.repository.mapper.OcrmFCiFqRelationMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @version 1.0.0
 * @项目名称: crm-service
 * @类名称: OcrmFCiFqRelationService
 * @类描述:
 * @功能描述: 指标关系管理
 * @创建人: zhangxs4@yusys.com.cn
 * @创建时间: 2019年01月14日
 * @修改备注:
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @Copyright (c) 2017宇信科技-版权所有
 */

@Service
public class OcrmFCiFqRelationService extends CommonService {
    @Autowired
    private OcrmFCiFqRelationMapper mapper;
    private final Logger logger = LoggerFactory.getLogger(OcrmFCiFqRelationService.class);

    @Override
    protected CommonMapper getMapper() {
        // TODO Auto-generated method stub
        return this.mapper;
    }

    /**
     * 查询基本信息
     */
    public List<Map<String, Object>> getListByModel(QueryModel model) {
        PageHelper.startPage(model.getPage(), model.getSize());
        List<Map<String, Object>> list = mapper.getListByModel(model);
        PageHelper.clearPage();
        return list;
    }

    /**
     * 查询基本信息
     */
    public List<Map<String, Object>> getDataObj(QueryModel queryModel) {
        List<Map<String, Object>> list = mapper.getDataObj(queryModel);
        return list;
    }

    /**
     * 查询右表
     */
    public List<Map<String, Object>> getDataObjs(QueryModel queryModel) {
        String joinLeftTab = String.valueOf(queryModel.getCondition().get("joinLeftTab"));
        StringBuffer builder = new StringBuffer("select c.group_id as value,(c.dbtable_name||g.group_name) as name,c.dbtable_name as tabName  from " +
                "CIMP_F_CI_FQ_DBCOL c left join CIMP_F_CI_FQ_GROUP g on c.group_id= g.id where 1=1 " +
                "and c.group_id in (select id from CIMP_F_CI_FQ_GROUP where obj_id = '" + joinLeftTab + "') " +
                "group by c.group_id,c.dbtable_name,g.group_name");

        String SQL = builder.toString();
        List<Map<String, Object>> list = mapper.getDataObjs(SQL);
        return list;
    }

    /**
     * 左表字段
     */
    public List<Map<String, Object>> getColDataObj(QueryModel queryModel) {
        String tabname = (String) queryModel.getCondition().get("tabName");
        String joinLeftTab = String.valueOf(queryModel.getCondition().get("joinLeftTab"));
        StringBuffer builder = new StringBuffer("select c.id as value,c.col_name_e as name,c.alias from CIMP_F_CI_FQ_DBCOL c " +
                "where 1=1 and c.obj_id = '" + joinLeftTab + "' and c.dbtable_name = '" + tabname + "'  ");

        String SQL = builder.toString();
        List<Map<String, Object>> list = mapper.getColDataObj(SQL);
        return list;
    }

    /**
     * 右表字段
     */
    public List<Map<String, Object>> getColDataObjs(QueryModel queryModel) {

        logger.info("joinRightTab===" + queryModel.getCondition().get("joinRightTab"));
        String tabName = (String) queryModel.getCondition().get("tabName");
        String joinRightTab = String.valueOf(queryModel.getCondition().get("joinRightTab"));
        StringBuffer builder = new StringBuffer("select c.id as value,c.col_name_e as name from CIMP_F_CI_FQ_DBCOL c " +
                "where 1=1 and c.group_id = '" + joinRightTab + "' and c.dbtable_name = '" + tabName + "'  ");

        String SQL = builder.toString();
        List<Map<String, Object>> list = mapper.getColDataObjs(SQL);
        return list;
    }

    /**
     * 新增
     *
     * @param record
     * @return
     */
    public int addData(OcrmFCiFqRelation record) {
        record.setId(mapper.getSeq());
        int num = mapper.addData(record);
        return num;
    }

    /**
     * 修改
     *
     * @param record
     * @return
     */

    public int updateData(OcrmFCiFqRelation record) {
        int count = 0;
        mapper.updateData(record);
        return count;
    }

    public int deletebyid(String id) {
        return mapper.deletebyid(id);
    }


    public List<FqRelationVo> getFqRelationVo() {
        return mapper.getFqRelationVo();
    }

}

