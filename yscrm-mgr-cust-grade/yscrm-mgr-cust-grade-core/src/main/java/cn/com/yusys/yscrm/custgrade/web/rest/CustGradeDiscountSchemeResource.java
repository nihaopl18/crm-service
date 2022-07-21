package cn.com.yusys.yscrm.custgrade.web.rest;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.bouncycastle.util.Integers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yscrm.custgrade.domain.OcrmCiGradePreferent;
import cn.com.yusys.yscrm.custgrade.service.CustGradeDiscountSchemeService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;

/**
 * @项目名称: yscrm-mgr-cust-grade-core模块
 * @类名称: CustGradeDiscountSchemeResource
 * @类描述: #资源类
 * @功能描述:
 * @创建人: Administrator
 * @创建时间: 2019-02-13 10:36:49
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 *        -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/custgradediscountscheme")
public class CustGradeDiscountSchemeResource extends CommonResource<OcrmCiGradePreferent, String> {
	@Autowired
	private CustGradeDiscountSchemeService ocrmCiGradePreferentService;

	@Override
	protected CommonService getCommonService() {
		return ocrmCiGradePreferentService;
	}

	/**
	 * 查询方案
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/querylist")
	public ResultDto<List<Map<String, Object>>> getAllGradeDis(QueryModel model) {
		List<Map<String, Object>> list = ocrmCiGradePreferentService.getAllGradeDis(model);
		return new ResultDto<List<Map<String, Object>>>(list);
	}

	/**
	 * 查询详情
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/detail")
	public ResultDto<List<Map<String, Object>>> getDetail(QueryModel model) {
		List<Map<String, Object>> list = ocrmCiGradePreferentService.getDetail(model);
		return new ResultDto<List<Map<String, Object>>>(list);
	}

	/**
	 * 删除
	 * 
	 * @param preferentId
	 * @return
	 */
	@RequestMapping("/delete")
	public ResultDto<Integer> deleteByPreferentId(@RequestBody Map<String,String> preferentId) {
		Integer n = Integers.valueOf(ocrmCiGradePreferentService.deleteByPreferentId(preferentId.get("preferentId")));
		return new ResultDto<Integer>(n);
	}

	/**
	 * 新增 优惠方案
	 */
	@SuppressWarnings("deprecation")
	@RequestMapping("/insert")
	public ResultDto<Object> insert(@RequestBody Map<String, Object> map) {
		// 获取必输项
		String preferentContent = String.valueOf(map.get("preferentContent"));
		String useCustType = String.valueOf(map.get("useCustType"));
		String preferentStatus = String.valueOf(map.get("preferentStatus"));
		String preferentBeginData = String.valueOf(map.get("preferentBeginData"));
		// 其他数据
		String useChannl = String.valueOf(map.get("useChannl"));
		String preferentEndData = String.valueOf(map.get("preferentEndData"));
		String remark = String.valueOf(map.get("remark"));
		OcrmCiGradePreferent pre=new OcrmCiGradePreferent();
		  
		  Date date=null; 
		  SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd"); 
//		  date=formatter.parse(); 
		  System.out.println(date); 
		pre.setUseCustType(useCustType);
		try {
			pre.setPreferentBeginData(formatter.parse(preferentBeginData));
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		pre.setPreferentContent(preferentContent);
		pre.setPreferentStatus(preferentStatus);
		if (useChannl != null) {
			pre.setUseChannl(useChannl);
		}
		if (preferentEndData != null) {
			try {
				pre.setPreferentEndData(formatter.parse(preferentEndData));
			} catch (ParseException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		if (remark != null) {
         pre.setRemark(remark);
		}
		
		// 关联数据
		List<Map<String,Object>> gradeValue=(List<Map<String, Object>>) map.get("gradeValue");
		OcrmCiGradePreferent gp=this.ocrmCiGradePreferentService.insertGrade(pre, gradeValue);
				
		return new ResultDto<Object>(gp.getPreferentId());
	}

	
	 /**
	  * 修改优惠方案
	  */
	    @RequestMapping("/updatepre")
	  public ResultDto<Object> update(@RequestBody Map<String, Object> map) {
	    	Map<String, Object> preMap= (Map) map.get("model");
	    	preMap.remove("rowId");
	    	OcrmCiGradePreferent pre =new OcrmCiGradePreferent();
	    	pre=map2Object(preMap,OcrmCiGradePreferent.class);
		  List<Map<String,Object>> gradeValue=(List<Map<String, Object>>) map.get("gradeValue");
         int m=this.ocrmCiGradePreferentService.updateGrade(pre, gradeValue);
 		return new ResultDto<Object>(m);

	  }
	    
	    
	    
	    /**
	     * Map转成实体对象
	     *
	     * @param map   map实体对象包含属性
	     * @param clazz 实体对象类型
	     * @return
	     */
	    public static <T> T map2Object(Map<String, Object> map, Class<T> clazz) {
	        if (map == null) {
	            return null;
	        }
	        T obj = null;
	        try {
	            obj = clazz.newInstance();
	 
	            Field[] fields = obj.getClass().getDeclaredFields();
	            for (Field field : fields) {
	                int mod = field.getModifiers();
	                if (Modifier.isStatic(mod) || Modifier.isFinal(mod)) {
	                    continue;
	                }
	                field.setAccessible(true);
	                String filedTypeName = field.getType().getName();
	                if (filedTypeName.equalsIgnoreCase("java.util.date")) {
	                    String datetimestamp = String.valueOf(map.get(field.getName()));
	                    if (datetimestamp.equalsIgnoreCase("null")) {
	                        field.set(obj, null);
	                    } else {
	                    	if(datetimestamp.contains("T")) {
	                    		 SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd"); 
	                    		 field.set(obj, formatter.parse(datetimestamp.split("T")[0]));
	                    	}else 
	                        field.set(obj, new Date(Long.parseLong(datetimestamp)));
	                    }
	                } else {
	                    field.set(obj, map.get(field.getName()));
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return obj;
	    }
}
