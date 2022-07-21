package cn.com.yusys.climp.trial.web.rest;

import java.io.File;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yusys.us.BatchEngine;

import cn.com.yusys.climp.trial.domain.LoyEngTrialBatch;
import cn.com.yusys.climp.trial.service.LoyEngTrialBatchService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;



/**
 * @项目名称: yusp-climp-trial模块
 * @类名称: LoyEngTrialBatchResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: hujun3
 * @创建时间: 2019-01-03 16:49:16
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/loyTrialBatch")
public class LoyEngTrialBatchResource extends CommonResource<LoyEngTrialBatch, String> {
	private Logger logger = LoggerFactory.getLogger(LoyEngTrialBatchResource.class);
    @Autowired
    private LoyEngTrialBatchService loyEngTrialBatchService;

    @Override
    protected CommonService getCommonService() {
        return loyEngTrialBatchService;
    }
	/**
	 * 
	* @方法名称: getTrailBatrchInfo
	* @方法描述: 查询试算批次信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	@GetMapping("/query")
	public ResultDto<List<Map<String, Object>>> getTrailBatrchInfo(QueryModel queryModel) {
		
		ResultDto<List<Map<String, Object>>> reuslt=new ResultDto<List<Map<String, Object>>>();
		try {
			List<Map<String, Object>> list = loyEngTrialBatchService.queryTrialBatchByPage(queryModel);
			if(list.isEmpty()) {
				reuslt.setCode(200001);
				reuslt.setMessage("noData");
			}else {
				reuslt=new ResultDto<List<Map<String, Object>>>(list);;
			}
			logger.info("分页查询试算批次信息页查询");
		}catch (Exception e) {
			e.printStackTrace();
			reuslt.setCode(100001);
			reuslt.setMessage("fail");
		}
		return reuslt;
	}
	/**
	 * 
	* @方法名称: addTrialBatch
	* @方法描述: 新增试算批次数据
	* @参数与返回说明: 
	* @算法描述:
	 */
	@PostMapping("/savetrialinfo")
	public ResultDto<Object> addTrialBatch(@RequestBody LoyEngTrialBatch pool) throws URISyntaxException {
		ResultDto<Object> reuslt=new ResultDto<Object>();
		try {
			List<Map<String, Object>> info=loyEngTrialBatchService.queryTrialBatchNow();
			if(info.isEmpty()) {
				int n = loyEngTrialBatchService.insertInfo(pool);
				if(n>0) {
					reuslt.setMessage("success");
				}else {
					reuslt.setCode(200001);
					reuslt.setMessage("fail");
				}
				logger.info("新增试算批次信息");
			}else {
				reuslt.setCode(100002);
				reuslt.setMessage("还有未完成的试算任务，请稍后!");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			reuslt.setCode(100001);
			reuslt.setMessage("fail:"+e);
		}
		return reuslt;
	}
	/**
	 * 
	* @方法名称: startTrialEngine
	* @方法描述: 启动试算引擎
	* @参数与返回说明: 
	* @算法描述:
	 */
	@PostMapping("/starttrialengine")
	public ResultDto<Map<String, Object>> startTrialEngine(@RequestParam(value="activityId",required = false) String activityId,@RequestParam(value="bno",required = false) String bno) {
		
		ResultDto<Map<String, Object>> reuslt=new ResultDto<Map<String, Object>>();
		try {
			LoyEngTrialBatch tb = loyEngTrialBatchService.startTrialEngine(bno,activityId);
			String path=loyEngTrialBatchService.queryPropInfo("TRIAL_COF_PATH");//试算配置文件路径
	    	//开始调用引擎,此次代码不放在service中的原因在于,service操作的事务没有提交，后续引擎处理会存在问题
	    	String[] args = new String[2];
	    	//File file = ExternalPathManager.getInstance().getTrialConfigFile();
//	    	if(!file.exists()){
//	    		throw new BizException(1,0,"-1","引擎启动配置文件不存在！");
//	    	}
//	    	try {
				//args[0] = "D:/trialconf/server.conf";
	    		args[0] = path+"server.conf";
	    		logger.info(args[0]);
	    		File file =new File(args[0]);
	    		if(file.exists()) {
	    			args[1] = tb.getTransactionCode();
	    	    	BatchEngine.main(args);
	    			logger.info("启动试算引擎");
	    		}else {
	    			loyEngTrialBatchService.deleteBatch(bno);
	    			reuslt.setCode(100002);
	    			reuslt.setMessage("引擎启动配置文件不存在,请检查文件路径");
	    			logger.info("引擎启动配置文件不存在,请检查文件路径");
	    		}
//			} catch (IOException e) {
//				e.printStackTrace();
//				throw new BizException(1,0,"-1","引擎启动配置文件不存在！");
//			}
	    	
		}catch (Exception e) {
			e.printStackTrace();
			loyEngTrialBatchService.deleteBatch(bno);
			reuslt.setCode(100001);
			reuslt.setMessage("fail");
		}
		return reuslt;
	}
	/**
	 * 
	* @方法名称: orgReport
	* @方法描述: 查询根据机构汇总的成本分摊信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	@GetMapping("/orgreport")
	public ResultDto<List<Map<String, Object>>> orgReport(QueryModel queryModel) {
		
		ResultDto<List<Map<String, Object>>> reuslt=new ResultDto<List<Map<String, Object>>>();
		try {
			List<Map<String, Object>> list = loyEngTrialBatchService.queryOrgReport(queryModel);
			if(list.isEmpty()) {
				reuslt.setCode(200001);
				reuslt.setMessage("noData");
			}else {
				reuslt.setData(list);
			}
			logger.info("查询根据机构汇总的成本分摊信息");
		}catch (Exception e) {
			e.printStackTrace();
			reuslt.setCode(100001);
			reuslt.setMessage("fail");
		}
		return reuslt;
	}
	/**
	 * 
	* @方法名称: productReport
	* @方法描述: 查询根据产品汇总的成本分摊信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	@GetMapping("/productreport")
	public ResultDto<List<Map<String, Object>>> productReport(QueryModel queryModel) {
		
		ResultDto<List<Map<String, Object>>> reuslt=new ResultDto<List<Map<String, Object>>>();
		try {
			List<Map<String, Object>> list = loyEngTrialBatchService.queryProdReport(queryModel);
			if(list.isEmpty()) {
				reuslt.setCode(200001);
				reuslt.setMessage("noData");
			}else {
				reuslt.setData(list);
			}
			logger.info("查询根据产品汇总的成本分摊信息");
		}catch (Exception e) {
			e.printStackTrace();
			reuslt.setCode(100001);
			reuslt.setMessage("fail");
		}
		return reuslt;
	}
	/**
	 * 
	* @方法名称: orgProductReport
	* @方法描述: 查询根据机构和产品汇总的成本分摊信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	@GetMapping("/orgproductreport")
	public ResultDto<List<Map<String, Object>>> orgProductReport(QueryModel queryModel) {
		
		ResultDto<List<Map<String, Object>>> reuslt=new ResultDto<List<Map<String, Object>>>();
		try {
			List<Map<String, Object>> list = loyEngTrialBatchService.queryOrgProdReport(queryModel);
			if(list.isEmpty()) {
				reuslt.setCode(200001);
				reuslt.setMessage("noData");
			}else {
				reuslt.setData(list);
			}
			logger.info("查询根据机构和产品汇总的成本分摊信息");
		}catch (Exception e) {
			e.printStackTrace();
			reuslt.setCode(100001);
			reuslt.setMessage("fail");
		}
		return reuslt;
	}
	/**
	 * 
	* @方法名称: queryTransactionCode
	* @方法描述: 查询交易类型数据
	* @参数与返回说明: 
	* @算法描述:
	 */
	@GetMapping("/querytransactioncode")
	public ResultDto<List<Map<String, Object>>> queryTransactionCode() {
		
		ResultDto<List<Map<String, Object>>> reuslt=new ResultDto<List<Map<String, Object>>>();
		try {
			List<Map<String, Object>> list = loyEngTrialBatchService.queryTransactionCode();
			if(list.isEmpty()) {
				reuslt.setCode(200001);
				reuslt.setMessage("noData");
			}else {
				reuslt.setData(list);
			}
			logger.info("查询交易类型数据");
		}catch (Exception e) {
			e.printStackTrace();
			reuslt.setCode(100001);
			reuslt.setMessage("fail");
		}
		return reuslt;
	}
}
