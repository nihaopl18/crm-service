package cn.com.yusys.yusp.uimp.business.pma.scheme.postParam.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.base.service.UserInfoService;
import cn.com.yusys.yusp.uimp.business.pma.scheme.orgParam.domain.PmaFParamListInfo;
import cn.com.yusys.yusp.uimp.business.pma.scheme.postParam.domain.PmaFPostParamListInfo;
import cn.com.yusys.yusp.uimp.business.pma.scheme.postParam.repository.mapper.PmaFPostParamListInfoMapper;
import cn.com.yusys.yusp.uimp.business.pma.scheme.postParam.repository.mapper.PmaFPostParamPerInfoMapper;
/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFPostParamListInfoService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: asus
 * @创建时间: 2020-01-13 09:50:05
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Service
public class PmaFPostParamListInfoService extends CommonService {
    @Autowired
    private PmaFPostParamListInfoMapper pmaFPostParamListInfoMapper;
    @Autowired
    private PmaFPostParamPerInfoMapper pmaFPostParamPerInfoMapper;
    @Autowired
    private UserInfoService userInfoService;
    @Override
    protected CommonMapper<?> getMapper() {
        return pmaFPostParamListInfoMapper;
    }
    @Transactional(readOnly = true)
    public List<Map<String, Object>> querylist(String paramId) {
    	
		List<Map<String, Object>> list = this.pmaFPostParamListInfoMapper.querylist(paramId);
		return list;
	}
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
    public ResultDto<PmaFPostParamListInfo> add (List<PmaFPostParamListInfo> list) throws Exception {
    	ResultDto<PmaFPostParamListInfo> result = new ResultDto<PmaFPostParamListInfo>();
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
    	this.pmaFPostParamListInfoMapper.deldetail(list.get(0).getParamId());
    	if(list.size()==1&&(list.get(0).getEffectPost() == null ||"".equals(list.get(0).getEffectPost()))) {//表格数据为0条，但是为了删除现有数据，前台只传输一个参数编号
    		
    	}else {//
    		  for(int i=0;i<list.size();i++) {
    	        	 //保存参数明细信息
    	        	list.get(i).setCreatorId(userInfoService.getUserInfo().getUserId());
    	        	list.get(i).setModifyUserId(userInfoService.getUserInfo().getUserId());
    	        	list.get(i).setCreateDate(df.format(new Date()));
    	        	this.pmaFPostParamListInfoMapper.insertSelective(list.get(i));
    	        	this.pmaFPostParamPerInfoMapper.deldetail(list.get(i).getParamId(), list.get(i).getEffectPost());//删除人员岗位的同一参数同一岗位的所有人员数据
    	        	if(list.get(i).getList()==null) {
    	        		
    	        	}else {
    	        		for(int j=0;j<list.get(i).getList().size();j++) {
    	        			list.get(i).getList().get(j).setCreateDate(df.format(new Date()));
    	        			list.get(i).getList().get(j).setCreatorId(userInfoService.getUserInfo().getUserId());
    	        			this.pmaFPostParamPerInfoMapper.insertSelective(list.get(i).getList().get(j));
    	        		}
    	        	}
    	        	
    	        }
    	}
      
		//result.setData(pmaFParamListInfo);
		result.setMessage("新增参数明细成功");
		result.setCode(0);
    	return result;
    }
}
