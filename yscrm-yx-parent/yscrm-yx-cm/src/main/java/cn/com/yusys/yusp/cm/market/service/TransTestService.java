package cn.com.yusys.yusp.cm.market.service;

import cn.com.yusys.yusp.cm.market.repository.mapper.TransTestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class TransTestService{
	@Autowired
	private	TransTestMapper transTestmapper;

	/**
	 * 查询交易字段明细
	 * @param transCode
	 * @return
	 */
	public List<Map<String, Object>> queryTrans(String transCode) {
		return transTestmapper.queryTrans(transCode);
	}
	/**
	 * 删除已经存在的测试数据
	 * @param trcd
	 */
	public void delTrans(String trcd) {
		transTestmapper.delTrans(trcd);
	}
	/**
	 * 插入最后一条测试数据
	 * @param translist
	 */
	public void insertTrans(List<Map<String, String>> translist) {
		transTestmapper.insertTrans(translist);
	}
}
