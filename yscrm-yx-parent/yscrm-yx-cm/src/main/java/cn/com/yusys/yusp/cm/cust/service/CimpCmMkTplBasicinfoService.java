package cn.com.yusys.yusp.cm.cust.service;

import cn.com.yusys.yusp.cm.cust.domain.CimpCmMkTplBasicinfo;
import cn.com.yusys.yusp.cm.cust.repository.mapper.CimpCmMkTplBasicinfoMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CimpCmMkTplBasicinfoService extends CommonService{
	
	@Autowired
	private CimpCmMkTplBasicinfoMapper mapper;
	@Override
	protected CommonMapper getMapper() {
		// TODO 自动生成的方法存根
		return this.mapper;
	}
	@Transactional(readOnly = true)
	public List<CimpCmMkTplBasicinfo> getListByModel(QueryModel model) {
		// TODO 自动生成的方法存根
		PageHelper.startPage(model.getPage(), model.getSize());
		List<CimpCmMkTplBasicinfo> list = mapper.getListByModel(model);
		PageHelper.clearPage();
		return list;
	}
	public int checkName(String name) {
		// TODO 自动生成的方法存根
		int i=mapper.checkName(name);
		return mapper.checkName(name);
	}
	public ResultDto<CimpCmMkTplBasicinfo> add(CimpCmMkTplBasicinfo c) {
		// TODO 自动生成的方法存根
		ResultDto<CimpCmMkTplBasicinfo> resultDto = null;
		c.setTempId(mapper.getSeq());
		c.setTempSts("2");
		if (insertSelective(getMapper(), c) == 1) {
			resultDto = new ResultDto<>(c);
			resultDto.setCode(0);
			resultDto.setMessage("新增成功");
		}else {
			resultDto = new ResultDto<>();
			resultDto.setCode(-1);
			resultDto.setMessage("新增失败");
		}
		return resultDto;
	}
	public int checkUpName(String id, String name) {
		// TODO 自动生成的方法存根
		int num = 0;
		if (mapper.checkName(name) == 0) {//数据库没有此名称可以修改
			num = 1;
		}else if (mapper.checkName(name) != 0 && name.equals(mapper.getNameById(id))) {//数据库有此名称并且此名称是当前对象的名称，num=1 表示可以修改
			num = 1;
		}
		return num;
	}
	public int updateFun(CimpCmMkTplBasicinfo c) {
		Util.updateUtl(c);
		int num = mapper.updateFun(c);
		return num;
	}

}
