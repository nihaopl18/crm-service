package cn.com.yusys.yusp.cm.market.web.rest;

import cn.com.yusys.yusp.cm.market.domain.FrTransInfoAllModel;
import cn.com.yusys.yusp.cm.market.domain.FrTransInfoModel;
import cn.com.yusys.yusp.cm.market.domain.FrTransMapModel;
import cn.com.yusys.yusp.cm.market.service.TransManagerService;
import cn.com.yusys.yusp.cm.ruleConfig.domain.CmFRcTableEcName;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import com.codahale.metrics.annotation.Timed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.util.StringUtil;

import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 交易管理web控制端
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/api/transmanger")
public class TransManagerResource extends CommonResource<FrTransInfoModel, String>{

	
	 
	@Autowired
	private TransManagerService transManagerService;
	
	@Override
	protected CommonService getCommonService() {
		// TODO Auto-generated method stub
		return this.transManagerService;
	}
	
	  @GetMapping("/queryparamList")
	  @Timed
	  public ResultDto<List<Map<String,String>>> queryParamList(QueryModel queryModel) {
	      

	        List<Map<String,String>> list = transManagerService.queryFrParamPoolList(queryModel);

	        return new ResultDto<List<Map<String,String>>>(list);
	  }
	  
	  @GetMapping("/queryrefparamList")
	  @Timed
	  public ResultDto<List<Map<String,String>>> queryrefparamList(QueryModel queryModel) {
	        queryModel.getCondition().put("paramType", "3"); 
	        List<Map<String,String>> list = transManagerService.queryFrParamPoolList(queryModel);
	        return new ResultDto<List<Map<String,String>>>(list);
	  }


	
	  /**
     * @函数名称:create
     * @函数描述:实体类创建，公共API接口
     * @参数与返回说明:
     * @算法描述:
     */
    @PostMapping("/")
    @Timed
    @Override
    public ResultDto<FrTransInfoModel> create(@RequestBody FrTransInfoModel t)
            throws URISyntaxException { 
    	
    	FrTransInfoModel queryObj = new FrTransInfoModel();
    	ResultDto<FrTransInfoModel> retResult = new ResultDto<FrTransInfoModel>(); 
    	System.err.println("开始处理.............");
    	if(StringUtil.isEmpty( t.getTransCode())) {
    		retResult.setCode(-1);
    		retResult.setMessage("后台交易码不能为空");
    		return retResult;
    	}else {
    		queryObj.setTransCode(t.getTransCode());
    		List<Map<String,String>> list =transManagerService.queryFrParamPoolWithNoPage(queryObj);
    
    		System.err.println("----------" + list.size());
    		
    		if(list.size()>0) {
    		retResult.setCode(-1);
    		retResult.setMessage("操作失败：交易码["+t.getTransCode()+"]在系统中已经存在！");
    		return  retResult;
    	}
    	}
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
    	t.setOpTime(df.format(new Date()));
    	transManagerService.addTransInfo(t); 
    	System.err.println("开始end.............");
        return new ResultDto<FrTransInfoModel>(t);
    }
    
    @GetMapping("/querycurrentparamlist")
    @Timed
    public ResultDto<List<FrTransMapModel>> queryParamList(FrTransInfoModel frTransInfoModel) {
        List<FrTransMapModel> list = transManagerService.getCurrentTransParamList(frTransInfoModel);
        return new ResultDto<List<FrTransMapModel>>(list);
    }
    
    
    @PostMapping("/update")
    @Timed
    @Override
    public ResultDto<Integer> update( @RequestBody FrTransInfoModel t)
            throws URISyntaxException {
        

    	ResultDto<Integer> rs = new ResultDto<Integer>();
    	try {
    	transManagerService.updateTrans(t);
    	rs.setCode(0);
    	rs.setMessage("成功");
    	}catch(Exception e) {
    		rs.setCode(-1);
        	rs.setMessage("失败");
    	}

        return  rs;
    }
    
    /**
	* @方法名称: deleteMult
	* @方法描述: 多个删除
	* @参数与返回说明: 
	* @算法描述: 
	*/
	@PostMapping("/deletes/{ids}")
	@Timed
	public ResultDto<Integer> deleteMult(@PathVariable String ids) {
		 
		
		if(!StringUtil.isEmpty(ids)) {
			String[] idArray = ids.toString().split(",");
			List<String> list = new ArrayList<String>();
			 for(int i=0;i<idArray.length;i++) {
				 list.add( idArray[i]);
			 }
			 Map<String,List<String>> paramMap = new HashMap<String,List<String>>();
			 paramMap.put("Listpks", list);
			 transManagerService.deleteTransByPks(paramMap);
			 return new ResultDto<Integer>(idArray.length); 
		}else {
			return new ResultDto<Integer>(0);
		}
		
	 
		
	}
	
	   @PostMapping("/updatetranssetting")
	    @Timed 
	    public ResultDto<Integer> transSetting( @RequestBody FrTransInfoAllModel frTransInfoAllModel)
	            throws URISyntaxException {
	        

	    	ResultDto<Integer> rs = new ResultDto<Integer>();
	    	try {   
	    		
	    	 
	    		//System.err.println(frTransInfoAllModel.getTransMapList().size()+"###########size");
	    	 
	    	transManagerService.updateTransMapsetting(frTransInfoAllModel);
	    	rs.setCode(0);
	    	rs.setMessage("成功");
	    	}catch(Exception e) {
	    		e.printStackTrace();
	    		rs.setCode(-1);
	        	rs.setMessage("失败");
	    	}

	        return  rs;
	    }
	   /**
	    * 创建表
	    * @param transCode
	    * @return
	    */
	   @PostMapping("/createtab")
	   public ResultDto<Integer> createTab(@RequestBody FrTransInfoModel frTransInfoModel){
		   return new ResultDto<Integer>(transManagerService.createTab(frTransInfoModel));
	   }
	   
	   @GetMapping("/querylist")
		public ResultDto<List<FrTransInfoModel>> querylist(QueryModel queryModel) {
			List<FrTransInfoModel> list = transManagerService.querylist(queryModel);
			return new ResultDto<List<FrTransInfoModel>>(list);
		} 

	   
	   @GetMapping("/checktranscode")
	   public ResultDto<List<CmFRcTableEcName>> checkTransCode(String transCode){
		   List<CmFRcTableEcName> list = transManagerService.getTableByTransCode(transCode);
		   return new ResultDto<List<CmFRcTableEcName>>(list);
	   }
}
