package cn.com.yusys.yscrm.custgrade.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yscrm.custgrade.domain.OcrmCiGradePrefeLevel;
import cn.com.yusys.yscrm.custgrade.domain.OcrmCiGradePreferent;
import cn.com.yusys.yscrm.custgrade.repository.mapper.OcrmCiGradePrefeLevelMapper;
import cn.com.yusys.yscrm.custgrade.repository.mapper.OcrmCiGradePreferentMapper;
import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;

/**
 * @项目名称: yscrm-mgr-cust-grade-core模块
 * @类名称: CustGradeDiscountSchemeService
 * @类描述: #服务类
 * @功能描述:
 * @创建人: Administrator
 * @创建时间: 2019-02-13 10:36:49
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 *        -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class CustGradeDiscountSchemeService extends CommonService {
	private Logger logger = LoggerFactory.getLogger(CustGradeDiscountSchemeService.class);

	@Autowired
	private OcrmCiGradePreferentMapper ocrmCiGradePreferentMapper;
	@Autowired
	private OcrmCiGradePrefeLevelMapper OcrmCiGradePrefeLevelMapper;
	@Override
	protected CommonMapper<?> getMapper() {
		return ocrmCiGradePreferentMapper;
	}
	
	@Autowired
    private UaaClient uaaClient;

	/**
	 * 查询优惠方案
	 * 
	 * @param model
	 * @return
	 */
	public List<Map<String, Object>> getAllGradeDis(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String, Object>> list = ocrmCiGradePreferentMapper.querylist(model);
		PageHelper.clearPage();
		return list;
	}

	/**
	 * 查询优惠方案对应的等级
	 * 
	 * @param model
	 * @return
	 */
	public List<Map<String, Object>> getDetail(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String, Object>> list = ocrmCiGradePreferentMapper
				.detail((String) model.getCondition().get("preferentId"));
		PageHelper.clearPage();
		return list;
	}
     /**
      * 删除 优惠方案   和关联的对应的等级
      * 
      */
	public int deleteByPreferentId(String preferentId) {
		int n=0;
		if(preferentId!=null) {
			String [] preferentIdarr=preferentId.split(",");
			for (int i=0;i<preferentIdarr.length;i++) {
				n++;
				ocrmCiGradePreferentMapper.deletebyPreFerentId(preferentIdarr[i]);
				this.ocrmCiGradePreferentMapper.deleteByPreId(preferentIdarr[i]);
			}
		}
		
		return n;
	}
	
	
	/**
	 * 新增
	 * 
	 */
	public OcrmCiGradePreferent insertGrade(OcrmCiGradePreferent pre,List<Map<String,Object>> gradeValue) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
	    Date date = new Date();
		ResponseEntity<UserInfoDTO> dto  = uaaClient.getUserSessionInfo( HeaderUtil.getAccessToken());

		//logger.info("机构号：--------"+dto.getBody().getOrg().getCode()+"---------------");
		pre.setLastUpdateDate(date);
		
		pre.setCreateDate(date);
		pre.setCreateUserId(dto.getBody().getLoginCode());// 登录ID
		pre.setLastUpdateUserId(pre.getCreateUserId());//增加维护人
		pre.setCreateOrgId(dto.getBody().getOrg().getCode());
		pre.setCorpOrgCode(dto.getBody().getInstu().getCode());
		pre.setPreferentOrg(dto.getBody().getOrg().getCode());
		pre.setPreferentId(getPreferentId());
		logger.info("新增数据：【" + pre + "】 "
				+ df.format(new Date()));
		this.insertSelective(ocrmCiGradePreferentMapper, pre);
		if(gradeValue!=null&&!gradeValue.isEmpty()) {
			for (Map<String,Object> m:gradeValue) {
				OcrmCiGradePrefeLevel level=new OcrmCiGradePrefeLevel();
				if(m.get("gradeLevel")!=null||m.get("preferentStr")!=null) {
					level.setCorpOrgCode(dto.getBody().getInstu().getCode());
					level.setCreateDate(df.format(new Date()));
					level.setCreateOrgId(dto.getBody().getOrg().getCode());
					level.setCreateUserId(dto.getBody().getLoginCode());
					level.setPreferentId(pre.getPreferentId());
				}
				
				if(m.get("gradeLevel")!=null) {
					level.setGradeLevel(String.valueOf(m.get("gradeLevel")));

				}
				if(m.get("preferentStr")!=null) {
					level.setPreferentStr(String.valueOf(m.get("preferentStr")));
				}
				
				this.insertSelective(OcrmCiGradePrefeLevelMapper,level);
			}
		}
		
		return pre ;
		
	}
	
	
	public String getPreferentId() {
		String PreferentId="";
		PreferentId="CRM";
		Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);//获取年份
        PreferentId+=year;
       String SeqGP=this.ocrmCiGradePreferentMapper.seacherSeqGradePre();
       PreferentId+=SeqGP;
	  return PreferentId;
	}
	
	public int updateGrade(OcrmCiGradePreferent pre,List<Map<String,Object>> gradeValue) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
	    Date date = new Date();
		ResponseEntity<UserInfoDTO> dto  = uaaClient.getUserSessionInfo( HeaderUtil.getAccessToken());

		//logger.info("机构号：--------"+dto.getBody().getOrg().getCode()+"---------------");
		pre.setLastUpdateDate(date);
		pre.setLastUpdateUserId(dto.getBody().getLoginCode());
		pre.setLastUpdateOrgId(dto.getBody().getOrg().getCode());
		this.updateSelective(ocrmCiGradePreferentMapper, pre);
		// 删除优惠方案关联
		this.ocrmCiGradePreferentMapper.deleteByPreId(pre.getPreferentId());
		if(gradeValue!=null&&!gradeValue.isEmpty()) {
			for (Map<String,Object> m:gradeValue) {
				OcrmCiGradePrefeLevel level=new OcrmCiGradePrefeLevel();
				if(m.get("gradeLevel")!=null||m.get("preferentStr")!=null) {
					level.setCorpOrgCode(dto.getBody().getInstu().getCode());
					level.setCreateDate(df.format(new Date()));
					level.setCreateOrgId(dto.getBody().getOrg().getCode());
					level.setCreateUserId(dto.getBody().getLoginCode());
					level.setPreferentId(pre.getPreferentId());
				}
				
				if(m.get("gradeLevel")!=null) {
					level.setGradeLevel(String.valueOf(m.get("gradeLevel")));

				}
				if(m.get("preferentStr")!=null) {
					level.setPreferentStr(String.valueOf(m.get("preferentStr")));
				}
				
				this.insertSelective(OcrmCiGradePrefeLevelMapper,level);
			}
		}
		return 1;
	}
}
