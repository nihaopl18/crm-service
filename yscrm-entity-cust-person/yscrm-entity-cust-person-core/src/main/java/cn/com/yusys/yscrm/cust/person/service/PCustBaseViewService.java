package cn.com.yusys.yscrm.cust.person.service;



import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yscrm.cust.person.domain.AcrmFciPerResumeInfo;
import cn.com.yusys.yscrm.cust.person.domain.OcrmFciCustUpdateHis;
import cn.com.yusys.yscrm.cust.person.repository.mapper.AcrmFciPerKeyFlagMapper;
import cn.com.yusys.yscrm.cust.person.repository.mapper.OcrmFciCustUpdateHisPerMapper;
import cn.com.yusys.yscrm.cust.person.repository.mapper.OcrmFciPreRelatInfoMapper;
import cn.com.yusys.yscrm.cust.person.repository.mapper.OcrmFciPreWorkInfoMapper;
import cn.com.yusys.yscrm.cust.person.repository.mapper.PCustBaseViewMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;



/**
 * @项目名称: yscrm-entity-cust-person-core模块
 * @类名称: AcrmFciPerCustService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-01-22 17:20:26
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class PCustBaseViewService extends CommonService {
    @Autowired
    private PCustBaseViewMapper pCustBaseViewMapper;
    
    @Autowired
    private OcrmFciPreWorkInfoMapper ocrmFciPreWorkInfoMapper;
    
    @Autowired
    private OcrmFciPreRelatInfoMapper ocrmFciPreRelatInfoMapper;
    
    @Autowired
    private AcrmFciPerKeyFlagMapper acrmFciPerKeyFlagMapper;
    
    @Autowired
    private OcrmFciCustUpdateHisPerMapper ocrmFciCustUpdateHisMapper;
    
    @Override
    protected CommonMapper<?> getMapper() {
        return pCustBaseViewMapper;
    }
	@Transactional(readOnly = true) // 基本信息查询
	public List<Map<Object, String>> getList(QueryModel model,String custId) {
		Map<String, String> paramMap=new HashMap<String, String>();
		paramMap.put("custId", custId);
		// TODO 自动生成的方法存根
		return pCustBaseViewMapper.getList(paramMap);
	}
	@Transactional(readOnly = true) // 工作信息查询
	public List<Map<Object, String>> getworkList(QueryModel model,String custId) {
		Map<String, String> paramMap=new HashMap<String, String>();
		paramMap.put("custId", custId);
		// TODO 自动生成的方法存根
		return pCustBaseViewMapper.getworkList(paramMap);
	}
	@Transactional(readOnly = true) // 涉农个性标识信息
	public List<Map<Object, String>> getrelatList(QueryModel model,String custId) {
		Map<String, String> paramMap=new HashMap<String, String>();
		paramMap.put("custId", custId);
		// TODO 自动生成的方法存根
		return pCustBaseViewMapper.getrelatList(paramMap);
	}
	@Transactional(readOnly = true) // 重要标志信息
	public List<Map<Object, String>> getimportFlagList(QueryModel model,String custId) {
		Map<String, String> paramMap=new HashMap<String, String>();
		paramMap.put("custId", custId);
		// TODO 自动生成的方法存根
		return pCustBaseViewMapper.getimportFlagList(paramMap);
	}
	@Transactional(readOnly = true) // 履历信息
	public List<Map<Object, String>> getresumeList(QueryModel model,String custId) {
	    PageHelper.startPage(model.getPage(),model.getSize());
		Map<String, String> paramMap=new HashMap<String, String>();
		paramMap.put("custId", custId);
		List<Map<Object, String>> list=pCustBaseViewMapper.getresumeList(paramMap);
		PageHelper.clearPage();
		// TODO 自动生成的方法存根
		return list;				
	}
	// 基本信息修改
	public int updatebaseInfo(Map c) {
		
		return pCustBaseViewMapper.updatebaseInfo(c);
	}
	// 工作信息修改
	public int updateworkInfo(Map c) {
		
		//c.put("lastUpdateSys","CRM");//最新更新系统
		return pCustBaseViewMapper.updateworkInfo(c);
	}
    // 与我行关系修改
	public int updaterelationInfo(Map c) {
		
		
		return pCustBaseViewMapper.updaterelationInfo(c);
	}
	// 涉农个性标识修改
	public int updaterelatInfo(Map c) {
		
		
		return pCustBaseViewMapper.updaterelatInfo(c);
	}
	// 重要标志修改
	public int updateimportInfo(Map c) {
		
	
		return pCustBaseViewMapper.updateimportInfo(c);
	}
	// 履历修改
	public int updateresumeInfo(Map c) {
		AcrmFciPerResumeInfo  acrmFciPerResumeInfo=new AcrmFciPerResumeInfo();
			                          
		if(c.get("endDate")!=null) {
			acrmFciPerResumeInfo.setEndDate(c.get("endDate").toString().replace("-", ""));
		}
		if(c.get("startDate")!=null) {
			acrmFciPerResumeInfo.setStartDate(c.get("startDate").toString().replace("-", ""));
		}
		if(c.get("custId")!=null) {
			acrmFciPerResumeInfo.setCustId(c.get("custId").toString());
		}
		if(c.get("id")!=null) {
			acrmFciPerResumeInfo.setId(c.get("id").toString());
		}
		if(c.get("country")!=null) {
			acrmFciPerResumeInfo.setCountry(c.get("country").toString());
		}
		if(c.get("city")!=null) {
			acrmFciPerResumeInfo.setCity(c.get("city").toString());
		}
		if(c.get("comSch")!=null) {
			acrmFciPerResumeInfo.setComSch(c.get("comSch").toString());
		}
		if(c.get("dept")!=null) {
			acrmFciPerResumeInfo.setDept(c.get("dept").toString());
		}
		if(c.get("schDept")!=null) {
			acrmFciPerResumeInfo.setSchDept(c.get("schDept").toString());
		}
	
		if(c.get("schMajor")!=null) {
			acrmFciPerResumeInfo.setSchMajor(c.get("schMajor").toString());
		}
		if(c.get("schLength")!=null) {
			acrmFciPerResumeInfo.setSchLength(c.get("schLength").toString());
		}
		if(c.get("duty")!=null) {
			acrmFciPerResumeInfo.setDuty(c.get("duty").toString());
		}
		if(c.get("remarks")!=null) {
			acrmFciPerResumeInfo.setRemarks(c.get("remarks").toString());
		}
		if(c.get("fullPartFlg")!=null) {
			acrmFciPerResumeInfo.setFullPartFlg(c.get("fullPartFlg").toString());
		}
		if(c.get("lastChgSys")!=null) {
			acrmFciPerResumeInfo.setLastChgSys(c.get("lastChgSys").toString());
		}
		if(c.get("lastChgUsr")!=null) {
			acrmFciPerResumeInfo.setLastChgUsr(c.get("lastChgUsr").toString());
		}
		if(c.get("lastChgDt")!=null) {
			     Date currentTime = new Date();

			     SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			     String dateString = formatter.format(currentTime);
			     ParsePosition pos = new ParsePosition(0);
		         Date currentTime_2 = formatter.parse(dateString, pos);
			     acrmFciPerResumeInfo.setLastChgDt(currentTime_2);
			
		
		}
		return  this.updateSelective(acrmFciPerResumeInfo);
				
	}
	// 履历新增
	public int insertresumeInfo(Map c) {
		AcrmFciPerResumeInfo  acrmFciPerResumeInfo=new AcrmFciPerResumeInfo();
		if(c.get("endDate")!=null) {
			acrmFciPerResumeInfo.setEndDate(c.get("endDate").toString().replace("-", ""));
		}
		if(c.get("startDate")!=null) {
			acrmFciPerResumeInfo.setStartDate(c.get("startDate").toString().replace("-", ""));
		}
		if(c.get("custId")!=null) {
			acrmFciPerResumeInfo.setCustId(c.get("custId").toString());
		}
		
		if(c.get("country")!=null) {
			acrmFciPerResumeInfo.setCountry(c.get("country").toString());
		}
		if(c.get("city")!=null) {
			acrmFciPerResumeInfo.setCity(c.get("city").toString());
		}
		if(c.get("comSch")!=null) {
			acrmFciPerResumeInfo.setComSch(c.get("comSch").toString());
		}
		if(c.get("dept")!=null) {
			acrmFciPerResumeInfo.setDept(c.get("dept").toString());
		}
		if(c.get("schDept")!=null) {
			acrmFciPerResumeInfo.setSchDept(c.get("schDept").toString());
		}
	
		if(c.get("schMajor")!=null) {
			acrmFciPerResumeInfo.setSchMajor(c.get("schMajor").toString());
		}
		if(c.get("schLength")!=null) {
			acrmFciPerResumeInfo.setSchLength(c.get("schLength").toString());
		}
		if(c.get("duty")!=null) {
			acrmFciPerResumeInfo.setDuty(c.get("duty").toString());
		}
		if(c.get("remarks")!=null) {
			acrmFciPerResumeInfo.setRemarks(c.get("remarks").toString());
		}
		if(c.get("fullPartFlg")!=null) {
			acrmFciPerResumeInfo.setFullPartFlg(c.get("fullPartFlg").toString());
		}
		
		if(c.get("cratUsr")!=null) {
			acrmFciPerResumeInfo.setCratUsr(c.get("cratUsr").toString());
		}
		if(c.get("cratDt")!=null) {
		   
			try {
				 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
				acrmFciPerResumeInfo.setCratDt( sdf.parse(c.get("cratDt").toString()));
			} catch (ParseException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		
		if(c.get("cratOrgId")!=null) {
			acrmFciPerResumeInfo.setCratOrgId(c.get("cratOrgId").toString());
		}
		if(c.get("lastChgSys")!=null) {
			acrmFciPerResumeInfo.setLastChgSys(c.get("lastChgSys").toString());
		}
		if(c.get("lastChgUsr")!=null) {
			acrmFciPerResumeInfo.setLastChgUsr(c.get("lastChgUsr").toString());
		}
		if(c.get("lastChgDt")!=null) {
			
			try {
				SimpleDateFormat sdflast = new SimpleDateFormat("yyyy-MM-dd"); 
				acrmFciPerResumeInfo.setLastChgDt(sdflast.parse(c.get("lastChgDt").toString()));
			} catch (ParseException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			
		
		}
		return this.insertSelective(acrmFciPerResumeInfo);
	}
	// 获取id的下一个值
	public String  getNextId() {

		return pCustBaseViewMapper.getNextId();
	}
	//基本信息新增
	public int insertWorkExist(Map c) {
		return this.insertSelective(ocrmFciPreWorkInfoMapper, c);
	}
	//涉农个性表示信息新增 
	public int insertRelatInfo(Map relatMap) {
		return this.insertSelective(ocrmFciPreRelatInfoMapper, relatMap);
	}
	//重要标志信息
	public int insertImportInfo(Map importMap) {
		
		return this.insertSelective(acrmFciPerKeyFlagMapper, importMap);
	}
	public int changeList(Map ocuh) {
		return this.insertSelective(ocrmFciCustUpdateHisMapper, ocuh);
	}
	public List<Map<String, Object>> queryCustUpdateHis(QueryModel model,String custId) {
		PageHelper.startPage(model.getPage(),model.getSize());
		List<Map<String, Object>> list=pCustBaseViewMapper.queryCustUpdateHis(custId);
		PageHelper.clearPage();
		return list;
	}
	public int updateIsUse(String custId, String updateName) {
		return pCustBaseViewMapper.updateIsUse(custId,updateName);
		
	}
	public int saveImage(QueryModel model, String custId) {
		// TODO 自动生成的方法存根
		int flag =0;
		if(model.getCondition().get("imagePath")!=null) {
			flag = pCustBaseViewMapper.saveImage(model.getCondition().get("imagePath").toString(),custId);
			pCustBaseViewMapper.saveImage1(model.getCondition().get("imagePath").toString(),custId);
		}
		return flag;
	}
	public String getItemName(Map mapCode) {
		// TODO 自动生成的方法存根
		return pCustBaseViewMapper.getItemName(mapCode);
	}
}
