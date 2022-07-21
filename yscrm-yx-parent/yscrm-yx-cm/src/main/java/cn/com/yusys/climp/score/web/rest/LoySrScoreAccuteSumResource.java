package cn.com.yusys.climp.score.web.rest;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.climp.score.domain.LoySrScoreAccuteSum;
import cn.com.yusys.climp.score.service.LoySrScoreAccuteSumService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;


/**
 * @项目名称:  yusp-climp-cust模块
 * @类名称: LoySrScoreAccuteSumResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-01-22 15:04:27
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/loysrscoreaccutesum")
public class LoySrScoreAccuteSumResource extends CommonResource<LoySrScoreAccuteSum, String> {
	private Logger logger = LoggerFactory.getLogger(LoySrScoreAccuteSumResource.class);
    @Autowired
    private LoySrScoreAccuteSumService loySrScoreAccuteSumService;

    @Override
    protected CommonService getCommonService() {
        return loySrScoreAccuteSumService;
    }
	/**
	 * 
	* @方法名称: getList
	* @方法描述: 分页查询
	* @参数与返回说明: 
	* @算法描述:
	 */
	@GetMapping("/query")
	public ResultDto<List<Map<String, Object>>> getList(QueryModel queryModel) {
		
		ResultDto<List<Map<String, Object>>> reuslt=new ResultDto<List<Map<String, Object>>>();
		try {
			List<Map<String, Object>> list = loySrScoreAccuteSumService.findAllByParam(queryModel);
			
			if(list.isEmpty()) {
				reuslt.setCode(200001);
				reuslt.setMessage("noData");
			}else {
				reuslt=new ResultDto<List<Map<String, Object>>>(list);
				//reuslt.setTotal(total);
			}
			logger.info("客户累积积分信息分页查询");
		}catch (Exception e) {
			reuslt.setCode(100001);
			reuslt.setMessage("fail");
		}
		return reuslt;
	}
}
