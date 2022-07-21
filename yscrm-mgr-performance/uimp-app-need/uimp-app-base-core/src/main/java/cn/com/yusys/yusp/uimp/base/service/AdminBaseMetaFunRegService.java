package cn.com.yusys.yusp.uimp.base.service;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.base.constants.DistributionConstants;
import cn.com.yusys.yusp.uimp.base.domain.AdminBaseMetaFunColumn;
import cn.com.yusys.yusp.uimp.base.domain.AdminBaseMetaFunColumnCfg;
import cn.com.yusys.yusp.uimp.base.domain.AdminBaseMetaFunReg;
import cn.com.yusys.yusp.uimp.base.repository.mapper.*;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @项目名称: uimp-app-base-core模块
 * @类名称: AdminBaseMetaFuncRegService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-12-07 17:56:14
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Service
public class AdminBaseMetaFunRegService extends CommonService {
	
    @Autowired
    private AdminBaseMetaFunRegMapper adminBaseMetaFunRegMapper;
    
    @Autowired
    private AdminBaseMetaFunColumnMapper adminBaseMetaFunColumnMapper;
    
    @Autowired
    private AdminBaseMetaFunColumnCfgMapper adminBaseMetaFunColumnCfgMapper;
    
    @Autowired
    private AdminBaseMetaFunTableService adminBaseMetaFunTableService;
    
    @Autowired
    private AdminBaseMetaFunColumnService adminBaseMetaFunColumnService;

    @Autowired
    private AdminBaseMetaFunColumnCfgService adminBaseMetaFunColumnCfgService;
    
    @Autowired
    private AdminBaseMetaFunTableMapper adminBaseMetaFunTableMapper;
    
    @Autowired
	private AdminBaseMetaFunPageCfgMapper adminBaseMetaFunPageCfgMapper;
    
    @Autowired
    private UserInfoService userInfoService;
    
    @Override
    protected CommonMapper<?> getMapper() {
        return adminBaseMetaFunRegMapper;
    }
    
    @Transactional(readOnly = true)
    public List<Map<String, Object>> querylist(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String, Object>> list = this.adminBaseMetaFunRegMapper.querylist(model);
		PageHelper.clearPage();
		return list;
	}
    
    @Transactional(readOnly = true)
    public AdminBaseMetaFunReg getAdminBaseMetaFunReg(String funCode) {
    	return this.adminBaseMetaFunRegMapper.getAdminBaseMetaFunReg(funCode);
    }
    
    /**
	 * @方法名称: saveorupdate
	 * @方法描述: 新增或保存业务注册信息
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
    @Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
    public ResultDto<Object> saveorupdate(AdminBaseMetaFunReg adminBaseMetaFuncReg) throws Exception {
    	ResultDto<Object> resultDto = new ResultDto<>();
    	try {
			if (adminBaseMetaFuncReg.getId() != null) { //修改
				this.adminBaseMetaFunRegMapper.updateByPrimaryKeySelective(adminBaseMetaFuncReg);
				resultDto.setCode(0);
				resultDto.setMessage("保存业务注册信息成功");
			} else { //新增
				this.adminBaseMetaFunRegMapper.insertSelective(adminBaseMetaFuncReg);
				resultDto.setCode(0);
			    resultDto.setMessage("新增业务注册信息成功");
			}
		} catch (Exception e) {
			resultDto.setCode(500);
		    resultDto.setMessage(e.getMessage());
		}
		return resultDto;
    }
    
    
    /**
	 * @方法名称: remove
	 * @方法描述: 删除业务注册信息
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
    @Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
    public ResultDto<Object> remove(String funCode) throws Exception {
    	ResultDto<Object> resultDto = new ResultDto<>();
    	try {
    		this.adminBaseMetaFunRegMapper.delFuncode(funCode);
    		this.adminBaseMetaFunTableMapper.delMetaFunByFunCode(funCode);
    		this.adminBaseMetaFunPageCfgMapper.delPageCfgByFunCode(funCode);
    		this.adminBaseMetaFunRegMapper.delColumnTable(funCode + "_table");
    		this.adminBaseMetaFunRegMapper.delColumnCfgTable(funCode + "_table");
    		resultDto.setCode(0);
		    resultDto.setMessage("删除业务注册信息成功");
		} catch (Exception e) {
			resultDto.setCode(500);
		    resultDto.setMessage(e.getMessage());
		}
		return resultDto;
    }
    
    /**
	 * @方法名称: savefuncolandcfg
	 * @方法描述: 保存字段信息和相关配置
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public ResultDto<Object> savefuncolandcfg(@RequestBody AdminBaseMetaFunReg adminBaseMetaFunReg) throws Exception {
		ResultDto<Object> resultDto = new ResultDto<>();
		try {
			String tableCode = adminBaseMetaFunReg.getFunColumnList().get(0).getTableCode();
			this.adminBaseMetaFunColumnMapper.delFunColumnByTableCode(tableCode);
			this.adminBaseMetaFunColumnCfgMapper.delFunColumnCfgByTableCode(tableCode);
			addPeriodPK(adminBaseMetaFunReg.getFunColumnList());
			saveFunColumn(adminBaseMetaFunReg.getFunColumnList());
			saveFunColumnCfg(adminBaseMetaFunReg.getFunColumnCfgList());
			resultDto.setCode(0);
			resultDto.setMessage("保存字段信息和相关配置");
		} catch (Exception e) {
			e.printStackTrace();
			resultDto.setCode(500);
			resultDto.setMessage(e.getMessage());
		}
		return resultDto;
	}
	
	
	/**
	 * @方法名称: addPeriodPK
	 * @方法描述: 将分配主键字段插入到分配区间表和分配区间历史表中
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	private void addPeriodPK(List<AdminBaseMetaFunColumn> colList) {
		String tableCode = colList.get(0).getTableCode();
		String tableCodePrefix = tableCode.substring(0, tableCode.length() - 1);
		String periodTableCode = tableCodePrefix + "2";
		String periodHisTableCode = tableCodePrefix + "4";
		/**
		 * 删除分配区间表和分配区间历史表中关联信息表的业务主键字段 
		 * 后缀大于900的为业务主键字段
		 */
		this.adminBaseMetaFunColumnMapper.delPeriodPK(periodTableCode, periodTableCode + "_900");
		this.adminBaseMetaFunColumnMapper.delPeriodPK(periodHisTableCode, periodHisTableCode + "_900");
		int columnSequnce = 999;
		for (AdminBaseMetaFunColumn adminBaseMetaFunColumn : colList) {
			if (DistributionConstants.YES.equals(adminBaseMetaFunColumn.getIsPk())) {
				AdminBaseMetaFunColumn periodCol = new AdminBaseMetaFunColumn(
						adminBaseMetaFunColumn.getColumnCnName(),
						adminBaseMetaFunColumn.getColumnName(),
						adminBaseMetaFunColumn.getColumnType(),
						adminBaseMetaFunColumn.getColumnLength(), 
						periodTableCode,
						generateColumnCode(periodTableCode, columnSequnce--),null);
				AdminBaseMetaFunColumn periodHisCol = new AdminBaseMetaFunColumn(
						adminBaseMetaFunColumn.getColumnCnName(),
						adminBaseMetaFunColumn.getColumnName(),
						adminBaseMetaFunColumn.getColumnType(),
						adminBaseMetaFunColumn.getColumnLength(), 
						periodHisTableCode,
						generateColumnCode(periodHisTableCode, columnSequnce--),null);
				this.adminBaseMetaFunColumnMapper.insertSelective(periodCol);
				this.adminBaseMetaFunColumnMapper.insertSelective(periodHisCol);
			}
		}
	}
	
	
	/**
	 * @方法名称: saveFunColumn
	 * @方法描述: 保存字段信息和相关配置
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	private void saveFunColumn(List<AdminBaseMetaFunColumn> colList) {
		for (AdminBaseMetaFunColumn adminBaseMetaFunColumn : colList) {
			this.insertSelective(adminBaseMetaFunColumnMapper, adminBaseMetaFunColumn);
		}
	}
	
	/**
	 * @方法名称: saveFunColumnCfg
	 * @方法描述: 保存字段信息和相关配置
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	private void saveFunColumnCfg(List<AdminBaseMetaFunColumnCfg> colCfgList) {
		for (AdminBaseMetaFunColumnCfg adminBaseMetaFunColumnCfg : colCfgList) {
			this.insertSelective(this.adminBaseMetaFunColumnCfgMapper, adminBaseMetaFunColumnCfg);
		}
	}
	
	
	/**
	 * @方法名称: generateColumnCode
	 * @方法描述: 生成columnCode
	 * @参数与返回说明:
	 * @算法描述:
	 */
	private String generateColumnCode(String tableCode, int seq) {
		StringBuffer sb = new StringBuffer();
		sb.append(tableCode).append("_");
		if (seq < 10) {
			sb.append("00");
		} else if (seq < 100) {
			sb.append("0");
		}
		sb.append(seq);
		return sb.toString();
	}
	
//	@Cacheable(value = "AdminBaseMetaFunReg")
	public ConcurrentHashMap<String, AdminBaseMetaFunReg> getFunRegInfo() {
		ConcurrentHashMap<String, AdminBaseMetaFunReg> pageCfg = new ConcurrentHashMap<String, AdminBaseMetaFunReg>();
		List<AdminBaseMetaFunReg> list = adminBaseMetaFunRegMapper.queryAll();
		for(AdminBaseMetaFunReg adminBaseMetaFunReg : list) {
			pageCfg.put(adminBaseMetaFunReg.getFunCode(), adminBaseMetaFunReg);
		}
		return pageCfg;
	}
	
//	@CachePut(value = "AdminBaseMetaFunReg")
	public ConcurrentHashMap<String, AdminBaseMetaFunReg> refreshFunRegInfo() {
		ConcurrentHashMap<String, AdminBaseMetaFunReg> pageCfg = new ConcurrentHashMap<String, AdminBaseMetaFunReg>();
		List<AdminBaseMetaFunReg> list = adminBaseMetaFunRegMapper.queryAll();
		for(AdminBaseMetaFunReg adminBaseMetaFunReg : list) {
			pageCfg.put(adminBaseMetaFunReg.getFunCode(), adminBaseMetaFunReg);
		}
		return pageCfg;
	}
	
	public void refreshfuncolandcfg(String funCode){
		List<Map<String,Object>> funTableList = adminBaseMetaFunTableService.querylist(funCode);
		//清空缓存，重新刷新
		adminBaseMetaFunColumnCfgService.clearFunColumnCfg();
		for(Map<String,Object> funTableMap : funTableList) {
			String tableCode = String.valueOf(funTableMap.get("tableCode"));
	        adminBaseMetaFunColumnService.refreshFunColumn(tableCode);
	        List<Map<String,Object>> funColumnList = adminBaseMetaFunColumnService.querylist(tableCode);
	        for(Map<String,Object> funColumnMap : funColumnList) {
	        	String columnCode = String.valueOf(funColumnMap.get("columnCode"));
		        adminBaseMetaFunColumnCfgService.refreshFunColumnCfg(columnCode);
	        }
		}
	}

}
