package cn.com.yusys.yusp.uimp.business.pma.scheme.postParam.service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.base.service.UserInfoService;
import cn.com.yusys.yusp.uimp.business.pma.scheme.postParam.domain.PmaFPostParamListInfo;
import cn.com.yusys.yusp.uimp.business.pma.scheme.postParam.domain.PmaFPostParamPerInfo;
import cn.com.yusys.yusp.uimp.business.pma.scheme.postParam.repository.mapper.PmaFPostParamPerInfoMapper;
/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFPostParamPerInfoService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: asus
 * @创建时间: 2020-01-13 09:50:31
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Service
public class PmaFPostParamPerInfoService extends CommonService {
    @Autowired
    private PmaFPostParamPerInfoMapper pmaFPostParamPerInfoMapper;
    @Autowired
    private UserInfoService userInfoService;
    @Override
    protected CommonMapper<?> getMapper() {
        return pmaFPostParamPerInfoMapper;
    }
    @Transactional(readOnly = true)
    public List<Map<String, Object>> querylist(String paramId,String effectPost) {
		List<Map<String, Object>> list = this.pmaFPostParamPerInfoMapper.querylist(paramId,effectPost);
		return list;
	}
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
    public ResultDto<PmaFPostParamPerInfo> add (List<PmaFPostParamPerInfo> list) throws Exception {
    	ResultDto<PmaFPostParamPerInfo> result = new ResultDto<PmaFPostParamPerInfo>();
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
    	this.pmaFPostParamPerInfoMapper.deldetail(list.get(0).getParamId(),list.get(0).getEffectPost());
        if(list.size()==1&&(list.get(0).getUserId()== null ||"".equals(list.get(0).getUserId()))) {//表格数据为0条，但是为了删除现有数据，前台只传输一个参数编号
    		 
    	}else {
    		for(int i=0;i<list.size();i++) {
           	 //保存参数明细信息
           	list.get(i).setCreatorId(userInfoService.getUserInfo().getUserId());
           	list.get(i).setModifyUserId(userInfoService.getUserInfo().getUserId());
           	this.pmaFPostParamPerInfoMapper.insertSelective(list.get(i));
           }
    	}
        
		//result.setData(pmaFParamListInfo);
		result.setMessage("新增参数明细成功");
		result.setCode(0);
    	return result;
    }
}
