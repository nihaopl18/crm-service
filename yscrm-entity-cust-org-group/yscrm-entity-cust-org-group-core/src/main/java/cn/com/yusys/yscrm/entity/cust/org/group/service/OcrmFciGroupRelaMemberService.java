package cn.com.yusys.yscrm.entity.cust.org.group.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.util.UtilTools;
import cn.com.yusys.yscrm.entity.cust.org.group.domain.OcrmFciGroup;
import cn.com.yusys.yscrm.entity.cust.org.group.domain.OcrmFciGroupRela;
import cn.com.yusys.yscrm.entity.cust.org.group.domain.OcrmFciGroupRelaMember;
import cn.com.yusys.yscrm.entity.cust.org.group.repository.mapper.OcrmFciGroupRelaMapper;
import cn.com.yusys.yscrm.entity.cust.org.group.repository.mapper.OcrmFciGroupRelaMemberMapper;
/**
 * @项目名称: yscrm-entity-cust-org-group-core模块
 * @类名称: OcrmFciGroupRelaMemberService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-02-18 19:13:07
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class OcrmFciGroupRelaMemberService extends CommonService {
	
    @Autowired
    private OcrmFciGroupRelaMemberMapper ocrmFciGroupRelaMemberMapper;
    
    @Autowired
    private OcrmFciGroupRelaService ocrmFciGroupRelaService;
    
    @Autowired
    private OcrmFciGroupRelaMapper ocrmFciGroupRelaMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return ocrmFciGroupRelaMemberMapper;
    }
    /**
     * @方法名称: add
     * @方法描述: 保存关系图的节点和连接信息
     * @参数与返回说明: 
     * @算法描述: 无
     */
	public int add(Map<Object, Object> map) {
		// TODO 自动生成的方法存根
		String groupNo = (String) map.get("groupNo");
		ocrmFciGroupRelaMemberMapper.delByGroupNo(groupNo);
		ocrmFciGroupRelaMapper.delByGroupNo(groupNo);
		List ocrmFciGroupRelaMembers = JSON.parseObject(map.get("nodeData").toString(),List.class);
		List ocrmFciGroupRelas =JSON.parseObject(map.get("connData").toString(),List.class);
		for (int i = 0; i < ocrmFciGroupRelaMembers.size(); i++) {
			if(ocrmFciGroupRelaMembers.get(i)!=null) {
				OcrmFciGroupRelaMember ocrmFciGroupRelaMember = JSON.parseObject(ocrmFciGroupRelaMembers.get(i).toString(),OcrmFciGroupRelaMember.class) ;
				ocrmFciGroupRelaMember.setGroupNo(groupNo);
				//ocrmFciGroupRelaMember.setRelaMemberId(UtilTools.getUUID());
				//UtilTools.createUtl(ocrmFciGroupRelaMember);
				insertSelective(getMapper(), ocrmFciGroupRelaMember);
			}
		}
		for (int i = 0; i < ocrmFciGroupRelas.size(); i++) {
			if(ocrmFciGroupRelas.get(i)!=null) {
				OcrmFciGroupRela ocrmFciGroupRela = JSON.parseObject(ocrmFciGroupRelas.get(i).toString(),OcrmFciGroupRela.class) ;
				if(ocrmFciGroupRela.getRelaName()==null) {
					ocrmFciGroupRela.setRelaName("");
				}
				ocrmFciGroupRela.setGroupNo(groupNo);
				ocrmFciGroupRela.setRelaId(UtilTools.getUUID());
				ocrmFciGroupRelaService.insertSelective(ocrmFciGroupRela);
			}
		}
		return 0;
	}
	/**
     * @方法名称: delete
     * @方法描述: 删除关系图信息
     * @参数与返回说明: 
     * @算法描述: 无
     */
	public void deleteInfo(String groupNo) {
		ocrmFciGroupRelaMemberMapper.delByGroupNo(groupNo);
		ocrmFciGroupRelaMapper.delByGroupNo(groupNo);
	}
	/**
     * @方法名称: getList
     * @方法描述: 查询关系图的节点和连接信息
     * @参数与返回说明: 
     * @算法描述: 无
     */
	public Map<String, Object> getList(String groupNo) {
		Map<String,Object> reuslt=new HashMap<String,Object>();
		List<Map<String, Object>>  rela=ocrmFciGroupRelaMapper.getRelaInfoByGroupNo(groupNo);
		List<Map<String, Object>> nodes=ocrmFciGroupRelaMemberMapper.getRelaMemberByGroupNo(groupNo);
		//if(!nodes.isEmpty()) {
			reuslt.put("nodes", nodes);
			reuslt.put("conns", rela);
		//}
		// TODO 自动生成的方法存根
		return reuslt;
	}
	/**
     * @方法名称: getMembersByGroupNo
     * @方法描述:查询集团成员信息
     * @参数与返回说明: 
     * @算法描述: 无
     */
	public List<Map<String, Object>> getMembersByGroupNo(String groupNo,String custName) {
		Map<String,String> param=new HashMap<String,String>();
		param.put("groupNo", groupNo);
		param.put("custName", custName);
		List<Map<String, Object>> list = ocrmFciGroupRelaMemberMapper.getMembersByGroupNo(param);
		return list;
	}

}
