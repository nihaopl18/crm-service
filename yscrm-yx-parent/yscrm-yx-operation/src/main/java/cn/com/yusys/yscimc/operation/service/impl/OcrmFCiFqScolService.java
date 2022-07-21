package cn.com.yusys.yscimc.operation.service.impl;

import cn.com.yusys.yscimc.operation.repository.mapper.OcrmFCiFqScolMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 灵活查询方案
 *
 * @author zhangxs4
 */
@Service
public class OcrmFCiFqScolService extends CommonService {

    @Autowired
    private OcrmFCiFqScolMapper ocrmFCiFqScolMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        // TODO 自动生成的方法存根
        return this.ocrmFCiFqScolMapper;
    }

    /**
     * 根据节点信息查询条件字段列
     *
     * @param
     * @return
     */
    public List<Map<String, Object>> getScol(String ssId) {
        List<Map<String, Object>> list = ocrmFCiFqScolMapper.getScol(ssId);
        return list;
    }

    /**
     * 根据节点信息查询条件字段列与数据库对应字段信息
     *
     * @param
     * @return
     */
    public List<Map<String, Object>> getScolAndDbcol(String ssId) {
        List<Map<String, Object>> list = ocrmFCiFqScolMapper.getScolAndDbcol(ssId);
        return list;
    }

    public Map<String, String> getUuid(String orgCode) {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        Map<String, String> map = this.ocrmFCiFqScolMapper.getUuid(orgCode);
        map.put("uuid", uuid);
        return map;
    }
}


