package cn.com.yusys.yscrm.product.web.rest;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yscrm.product.domain.OcrmFpdProdQaReq;
import cn.com.yusys.yscrm.product.service.OcrmFpdProdQaReplyService;
import cn.com.yusys.yscrm.product.service.OcrmFpdProdQaReqService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;

/**
 * @项目名称: yusp-crm-single-starter模块
 * @类名称: OcrmFpdProdQaReqResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: yantianyi
 * @创建时间: 2019-02-11 17:12:14
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/ocrmfpdprodqareq")
public class OcrmFpdProdQaReqResource extends CommonResource<OcrmFpdProdQaReq, String> {
    @Autowired
    private OcrmFpdProdQaReqService ocrmFpdProdQaReqService;

    @Autowired
    private OcrmFpdProdQaReplyService ocrmFpdProdQaReplyService;
    
    @Override
    protected CommonService getCommonService() {
        return ocrmFpdProdQaReqService;
    }
    
    /**
   	 * @方法名称: questionsAnswersQuery
   	 * @方法描述: Q&A查询
   	 * @param 
   	 * @return
   	 */
   	@GetMapping("/questionsanswersquery/{prodId}")
   	public ResultDto<List<Map<String, Object>>> questionsAnswersQuery(QueryModel model, @PathVariable String prodId){
   		List<Map<String, Object>> focusCust = ocrmFpdProdQaReqService.questionsAnswersQuery(model, prodId);
   		if(focusCust.size()>0) {
   			return new ResultDto<List<Map<String, Object>>>(focusCust);
   		}else {
   			return null;
   		}
   	}
   	
   	/**
	 * @方法名称: ctrateQuestionsAnswers
	 * @方法描述: Q&A新增
	 * @param 
	 * @return
   	 * @throws ParseException 
	 */
	@PostMapping("/ctratequestionsanswers")
	public ResultDto<Object> ctrateQuestionsAnswers(@RequestBody Map<String, String> map) throws ParseException {
		int result = 0;
		if(map.get("questionId") == "" || map.get("questionId") == null) {
			//产品QA提问信息
			result = ocrmFpdProdQaReqService.ctrateQuestionsAnswers(map);
		}else {
			//产品QA回复信息
			result = ocrmFpdProdQaReplyService.ctrateQuestionsAnswers(map);
		}
		return new ResultDto<Object>(result);
	}

	/**
	 * @方法名称: delerteQuestionsAnswers
	 * @方法描述: Q&A删除
	 * @param 
	 * @return
	 */
	@PostMapping("/delertequestionsanswers")
	public int delerteQuestionsAnswers(@RequestBody Map<String, String> map) {
		String questionId = map.get("questionId").toString();
		//删除产品Q&A回复信息
		ocrmFpdProdQaReplyService.delerteQuestionsAnswers(questionId);
		//删除信息Q&A提问信息
		return ocrmFpdProdQaReqService.delerteQuestionsAnswers(questionId);
	}
	
}
