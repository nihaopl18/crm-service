package cn.com.yusys.yusp.uimp.distribution.repository.mapper;


import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.uimp.distribution.model.PmaMidInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface PmaMidInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(PmaMidInfo record);

    int insertSelective(PmaMidInfo record);

    PmaMidInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PmaMidInfo record);

    int updateByPrimaryKey(PmaMidInfo record);

    List<PmaMidInfo> selectList(QueryModel queryModel);

    Long selectCount(QueryModel queryModel);

    List<Map<String, Object>> queryMidHis(QueryModel model);

    List<Map<String, Object>> oneToManyQueryList(QueryModel queryModel);

    Long oneToManyQueryCount(QueryModel queryModel);

    List<Map<String, Object>> selectItem(String lookupCode);

    /**
     * 根据登录代码查询客户经理信息
     *
     * @param loginCode 登录代码
     * @return 客户经理信息
     */
    Map<String, Object> selectManager(String loginCode);

    /**
     * 根据登录代码查询用户信息
     *
     * @param loginCode 登录代码
     * @return 用户信息
     * @author weixy6
     * @date 2022/6/14
     */
    Map<String, Object> selectUser(@Param("loginCode") String loginCode);
}