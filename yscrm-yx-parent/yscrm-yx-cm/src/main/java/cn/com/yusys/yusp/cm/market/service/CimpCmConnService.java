package cn.com.yusys.yusp.cm.market.service;


import cn.com.yusys.yusp.cm.market.repository.mapper.CimpCmConnMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 流程模板——节点信息服务类
 * @author chenlin
 *
 */
@Service
public class CimpCmConnService  extends CommonService{
	
	@Autowired
	private CimpCmConnMapper connMapper;

	@Override
	protected CommonMapper<?> getMapper() {
		// TODO 自动生成的方法存根
		return this.connMapper;
	}
	
}
