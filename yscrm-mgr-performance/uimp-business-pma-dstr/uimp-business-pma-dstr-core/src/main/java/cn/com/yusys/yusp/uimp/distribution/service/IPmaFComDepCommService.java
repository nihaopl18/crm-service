package cn.com.yusys.yusp.uimp.distribution.service;

import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;

import java.util.List;
import java.util.Map;

/**
 * @author:Mr.raop
 * @create:2022-05-20
 */
public interface IPmaFComDepCommService {

    /**
     *公共查询
     * @param model
     * @return
     */
    List<Map<String, Object>> queryCommList(QueryModel model);

    /**
     *查询历史记录
     * @param model
     * @return
     */
    List<Map<String, Object>>  queryHisList(QueryModel model);

    /**
     *保存区间及明细记录
     * @param map
     */
    ResultDto<Object> savezbBean(Map<String,Object> map);

    /**
     *审批
     * @param bean
     */
    void executeApprove(Map<String,Object> bean);
}
