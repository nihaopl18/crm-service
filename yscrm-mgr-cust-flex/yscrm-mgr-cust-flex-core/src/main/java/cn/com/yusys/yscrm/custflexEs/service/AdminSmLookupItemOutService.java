package cn.com.yusys.yscrm.custflexEs.service;

import cn.com.yusys.yscrm.custflexEs.model.CrmFEsExportQuery;
import cn.com.yusys.yscrm.custflexEs.model.CrmFEsExportZhQuery;
import cn.com.yusys.yscrm.custflexEs.model.CrmFEsUserQueryVO;
import cn.com.yusys.yscrm.custflexEs.model.LookupItemVO;
import cn.com.yusys.yscrm.custflexEs.repository.mapper.AdminSmLookupItemOutInfoMapper;
import cn.com.yusys.yscrm.pcrm.common.remindInfo.utils.HumpToUnderlineTtils;
import cn.com.yusys.yusp.admin.domain.AdminSmLookupItem;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @version 1.0.0
 * @项目名称：yusp-admin
 * @类名称：AdminSmLookupItemService
 * @类描述：数据字典内容
 * @功能描述:
 * @创建人：liaoxd@yusys.com.cn @创建时间：2017-12-13 11:18 @修改备注：
 * @修改日期 修改人员 修改原因 -------- -------- ----------------------------------------
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class AdminSmLookupItemOutService extends CommonService {
    @Autowired
    private  AdminSmLookupItemOutInfoMapper mapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return this.mapper;
    }


    //    @Transactional
    @CachePut(value = "AdminSmLookupItem", key = "#adminSmLookupItem.lookupCode")
    public Map<String, List<Map<String, String>>> createWithCache(AdminSmLookupItem adminSmLookupItem) {
        this.insert(adminSmLookupItem);
        List<String> param = new ArrayList<String>();
        param.add(adminSmLookupItem.getLookupCode());
        List<Map<String, String>> list = this.mapper.getLookupCodeListByLookUpCodes(param);
        return this.cacheInputMap(list, adminSmLookupItem.getLookupCode());
    }

//    @Transactional
    @CachePut(value = "AdminSmLookupItem", key = "#adminSmLookupItem.lookupCode")
    public Map<String, List<Map<String, String>>> updateWithCache(AdminSmLookupItem adminSmLookupItem) {
        this.updateSelective(adminSmLookupItem);
        List<String> param = new ArrayList<String>();
        param.add(adminSmLookupItem.getLookupCode());
        List<Map<String, String>> list = this.mapper.getLookupCodeListByLookUpCodes(param);
        return this.cacheInputMap(list, adminSmLookupItem.getLookupCode());
    }

//    @Transactional
    @CacheEvict(value = "AdminSmLookupItem", key = "#lookupCode")
    public int deleteWithCache(String lookupItemId, String lookupCode) {
        AdminSmLookupItem item = new AdminSmLookupItem();
        item.setLookupCode(lookupCode);
        return super.deleteByPrimaryKey(lookupItemId);
    }


    public List<Map<String, String>> getLookupInfoWithCache(String lookupCode) {
        List<String> param = new ArrayList<String>();
        param.add(lookupCode);
        return this.mapper.getLookupCodeListByLookUpCodes(param);
    }

    /**
     * @方法名称:cacheInputMap
     * @方法描述:组装字典码列表加入缓存的数据格式
     * @参数与返回说明:
     * @算法描述:
     */
    public Map<String, List<Map<String, String>>> cacheInputMap(List<Map<String, String>> list, String lookupCode) {
        Map<String, List<Map<String, String>>> resultMap = new HashMap<String, List<Map<String, String>>>();
        List<Map<String, String>> itemList = new ArrayList<Map<String, String>>();
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                lookupCode = list.get(i).get("lookupCode");

                if (!resultMap.containsKey(lookupCode)) {
                    itemList = new ArrayList<Map<String, String>>();
                } else {
                    itemList = resultMap.get(lookupCode);
                }
                Map<String, String> itemMap = new HashMap<String, String>();

                String lookupItemCode = list.get(i).get("lookupItemCode");
                String lookupItemName = list.get(i).get("lookupItemName");
                itemMap.put("key", lookupItemCode);
                itemMap.put("value", lookupItemName);
                itemList.add(itemMap);
                resultMap.put(lookupCode, itemList);
            }
        }
        return resultMap;
    }


    /**
     * @方法名称:getLookupCodeList
     * @方法描述:根据lookupCode，查询字典码列表，并加入缓存中
     * @参数与返回说明:
     * @算法描述:
     */
    @Cacheable(value = "AdminSmLookupItem", key = "#lookupCode")
    public Map<String, List<Map<String, String>>> getLookupCodeList(String lookupCode) {

        List<Map<String, String>> list = this.getLookupInfoWithCache(lookupCode);

        return this.cacheInputMap(list, lookupCode);
    }

    @Override
    public int insert(Object record) {
        AdminSmLookupItem adminSmLookupItem = (AdminSmLookupItem) record;
        adminSmLookupItem.setLastChgDt(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        return this.insertSelective(getMapper(), record);
    }

    @Override
    public int updateSelective(Object record) {
        AdminSmLookupItem adminSmLookupItem = (AdminSmLookupItem) record;
        adminSmLookupItem.setLastChgDt(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        return this.updateSelective(getMapper(), record);
    }

    /**
     * @方法名称:getListByCodeForTree
     * @方法描述:根据lookupCode，查询字典内容并在树展示
     * @参数与返回说明:
     * @算法描述:
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public List<Map<String, String>> getListByCodeForTree(String lookupCode) {
        Map param = new HashMap<>();
        param.put("lookupCode", lookupCode);
        return this.mapper.getListByCodeForTree(param);

    }

    /**
     * @函数名称:selectByModel
     * @函数描述:重新，支持页面模糊查询
     * @参数与返回说明:
     * @算法描述:
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T> List<T> selectByModel(QueryModel model) {

        if (model.getCondition().containsKey("lookupItemName")) {
            model.getCondition().put("lookupItemName", "%" + model.getCondition().get("lookupItemName") + "%");
        }
        // 设置分页查询参数(设置到线程变量中了)
        PageHelper.startPage(model.getPage(), model.getSize());

        List<Map<String, String>> list = this.mapper.getItemListBycodeOrName(model);

        // 清除线程绑定的分页参数，防止影响同线程的其他查询
        PageHelper.clearPage();

        return (List<T>) list;
    }

    /**
     * 更新缓存.
     * @param key
     * @param value
     * @return
     */
    @CachePut(value = "AdminSmLookupItem", key = "#key")
    public Map<String, List<Map<String, String>>> putItemCache(String key, List<Map<String, String>> value) {
        Map<String, List<Map<String, String>>> singleCode = new HashMap<>();
        singleCode.put(key, value);
        return singleCode;
    }

    /**
     * 根据查询的数据字典组装缓存标准格式.
     * <pre>
     *     [
     *   "java.util.HashMap",
     *   {
     *     "APPTEST": [
     *       "java.util.ArrayList",
     *       [
     *         [
     *           "java.util.HashMap",
     *           {
     *             "value": "状态",
     *             "key": "1"
     *           }
     *         ]
     *       ]
     *     ]
     *   }
     * </pre>
     * @return
     */
    public Map<String, List<Map<String, String>>> getItemList() {
        List<Map<String, String>> list = mapper.getItemListBycodeOrName(new QueryModel());
        Map<String, List<Map<String, String>>> handled =
                list.stream().
                        collect(Collectors.toMap(l -> l.get("lookupCode"),
                                l -> getListByCode(l.get("lookupCode"), list),
                                (oldValue, newValue) -> oldValue));
        return handled;
    }

    /**
     * 将相同code的数据放到List.
     * @param lookupCode
     * @param list
     * @return
     */
    private List<Map<String, String>> getListByCode(String lookupCode,
                                                    List<Map<String, String>> list) {
        List<Map<String, String>> valueList = new ArrayList<>();
        Map<String, String> value;
        for (Map<String, String> map : list) {
            if (map.get("lookupCode").equals(lookupCode)) {
                value = new HashMap<>();
                value.put("key", map.get("lookupItemCode"));
                value.put("value", map.get("lookupItemName"));
                valueList.add(value);
            }
        }
        return valueList;
    }
    public List<String> getLookupItemNameByLookupCodeAndLookupItemCode(String lookupCode, List<String> lookupItemCodes) {
        return mapper.getLookupItemNameByLookupCodeAndLookupItemCode(lookupCode, lookupItemCodes);
    }

    public void deleteEsUserQuery(Map<String, String> map) {
        mapper.deleteEsUserQuery(map);
    }

    public void insertEsUserQuery(List<CrmFEsUserQueryVO> list) {
        mapper.insertEsUserQuery(list);
    }

    public List<CrmFEsUserQueryVO> getEsUserQueryList(String userId) {
        return  mapper.getEsUserQueryList(userId);
    }

    public void insertEsExportQuery(List<CrmFEsExportQuery> list) {
        mapper.insertEsExportQuery(list);
    }

    public List<CrmFEsExportQuery> getEsExportQueryList(Map<String,String> map) {
        return  mapper.getEsExportQueryList(map);
    }

    public void insertEsExportZhQuery(List<CrmFEsExportZhQuery> list) {
        mapper.insertEsExportZhQuery(list);
    }

    public List<CrmFEsExportZhQuery> getEsExportZhQueryList(Map<String, String> map) {
        return  mapper.getEsExportZhQueryList(map);
    }

    public void deleteExportQuery(String seqno) {
        mapper.deleteExportQuery(seqno);
        mapper.deleteExportzhQuery(seqno);
    }



    public Map<String,List<Map<String, Object>>> selectBymZ(List<String> columnENameList) {
        String ename=String.join(",",columnENameList);
        String[] cust = ename.split(",");
        String str = "";
        if (cust != null && cust.length > 0) {
            str = "in(";
            for (int i = 0; i < cust.length; i++) {
                str += "'" + HumpToUnderlineTtils.humpToUnderline(cust[i]) + "',";
            }
            str = str.substring(0, str.length() - 1);
            str += ")";
        }
        List<LookupItemVO> list=mapper.selectBymZ(str);
        Map<String,List<Map<String, Object>>> mapMap=new HashMap<>();
        for(LookupItemVO lookupItemVO:list){
            String key=lookupItemVO.getColNameE();
            List<Map<String, Object>> list2=new ArrayList<>();
            for(LookupItemVO ItemVO:list){
                if(key.equals(ItemVO.getColNameE())){
                    Map<String, Object> map=new HashMap<>();
                    map.put(ItemVO.getLookupItemCode(),ItemVO.getLookupItemName());
                    list2.add(map);
                }
            }
            mapMap.put(key,list2);
        }
        return mapMap;
    }

}
