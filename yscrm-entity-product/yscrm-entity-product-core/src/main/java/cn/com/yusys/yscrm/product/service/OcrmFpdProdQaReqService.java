package cn.com.yusys.yscrm.product.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yscrm.product.domain.OcrmFpdProdQaReq;
import cn.com.yusys.yscrm.product.repository.mapper.OcrmFpdProdQaReqMapper;
import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;
/**
 * @项目名称: yusp-crm-single-starter模块
 * @类名称: OcrmFpdProdQaReqService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: yantianyi
 * @创建时间: 2019-02-11 17:12:14
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class OcrmFpdProdQaReqService extends CommonService {
    @Autowired
    private OcrmFpdProdQaReqMapper ocrmFpdProdQaReqMapper;

    @Autowired
   	private UaaClient uaaClient;
    
    @Override
    protected CommonMapper<?> getMapper() {
        return ocrmFpdProdQaReqMapper;
    }
    
    /**
     * @方法名称: questionsAnswersQuery
	 * @方法描述: Q&A查询
	 * @param 
	 * @return
	 */
	public List<Map<String, Object>> questionsAnswersQuery(QueryModel model, String prodId){
		PageHelper.startPage(model.getPage(), model.getSize());
		model.getCondition().put("prodId", prodId);
		List<Map<String, Object>> list = ocrmFpdProdQaReqMapper.questionsAnswersQuery(model);
		PageHelper.clearPage();
		return list;	
	}
	
	/**
     * @方法名称: ctrateQuestionsAnswers
	 * @方法描述: 产品QA提问信息
	 * @param 
	 * @return
	 * @throws ParseException 
	 */
	public int ctrateQuestionsAnswers(Map<String, String> map) throws ParseException {
		ResponseEntity<UserInfoDTO> dto  = uaaClient.getUserSessionInfo( HeaderUtil.getAccessToken());
		OcrmFpdProdQaReq ocrmFpdProdQaReq = new OcrmFpdProdQaReq();
		ocrmFpdProdQaReq.setLastChgUsr(dto.getBody().getLoginCode());
		ocrmFpdProdQaReq.setLastChgDt(new Date());
		ocrmFpdProdQaReq.setCorpOrgCode(dto.getBody().getInstu().getCode());
		ocrmFpdProdQaReq.setProdId(map.get("prodId").toString());
		ocrmFpdProdQaReq.setQuestionContent(map.get("questionContent2").toString());
		ocrmFpdProdQaReq.setQuestionMan(dto.getBody().getUserName());
		ocrmFpdProdQaReq.setQuestionDate(new Date());
		ocrmFpdProdQaReq.setIsRemind("1");
		return this.insertSelective(getMapper(), ocrmFpdProdQaReq);
	}

	/**
     * @方法名称: delerteQuestionsAnswers
	 * @方法描述: Q&A删除
	 * @param 
	 * @return
	 */
	public int delerteQuestionsAnswers(String questionId) {
		QueryModel queryModel = new QueryModel();
		queryModel.getCondition().put("questionId", questionId);
		return ocrmFpdProdQaReqMapper.delerteQuestionsAnswers(queryModel);
	}
	
}
