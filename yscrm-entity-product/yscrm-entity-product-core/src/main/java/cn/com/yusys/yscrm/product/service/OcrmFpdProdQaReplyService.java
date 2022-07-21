package cn.com.yusys.yscrm.product.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import cn.com.yusys.yscrm.product.domain.OcrmFpdProdQaReply;
import cn.com.yusys.yscrm.product.domain.OcrmFpdProdQaReq;
import cn.com.yusys.yscrm.product.repository.mapper.OcrmFpdProdQaReplyMapper;
import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;
/**
 * @项目名称: yusp-crm-single-starter模块
 * @类名称: OcrmFpdProdQaReplyService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: yantianyi
 * @创建时间: 2019-02-12 09:32:23
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class OcrmFpdProdQaReplyService extends CommonService {
    @Autowired
    private OcrmFpdProdQaReplyMapper ocrmFpdProdQaReplyMapper;
	private static final String QUESTIONID = "questionId";
    @Autowired
   	private UaaClient uaaClient;
    
    @Override
    protected CommonMapper<?> getMapper() {
        return ocrmFpdProdQaReplyMapper;
    }
    
    /**
     * @方法名称: ctrateQuestionsAnswers
	 * @方法描述: 产品QA回复信息
	 * @param 
	 * @return
     * @throws ParseException 
	 */
	public int ctrateQuestionsAnswers(Map<String, String> map) throws ParseException {
		if(map.get("questionMan2") == "" || map.get("questionMan2") == null) {
			ResponseEntity<UserInfoDTO> dto  = uaaClient.getUserSessionInfo( HeaderUtil.getAccessToken());
			OcrmFpdProdQaReply ocrmFpdProdQaReply = new OcrmFpdProdQaReply();
			ocrmFpdProdQaReply.setQuestionId(map.get(QUESTIONID).toString());
			ocrmFpdProdQaReply.setLastChgUsr(dto.getBody().getLoginCode());
			ocrmFpdProdQaReply.setLastChgDt(new Date());
			ocrmFpdProdQaReply.setCorpOrgCode(dto.getBody().getInstu().getCode());
			ocrmFpdProdQaReply.setProdId(map.get("prodId").toString());
			ocrmFpdProdQaReply.setQuestionContent(map.get("questionContent2").toString());
			ocrmFpdProdQaReply.setQuestionMan(dto.getBody().getUserName());
			ocrmFpdProdQaReply.setQuestionDate(new Date());
			ocrmFpdProdQaReply.setIsRemind("1");
			return this.insertSelective(getMapper(), ocrmFpdProdQaReply);
		}else {
			ResponseEntity<UserInfoDTO> dto  = uaaClient.getUserSessionInfo( HeaderUtil.getAccessToken());
			OcrmFpdProdQaReply ocrmFpdProdQaReply = new OcrmFpdProdQaReply();
			ocrmFpdProdQaReply.setQuestionId(map.get(QUESTIONID).toString());
			ocrmFpdProdQaReply.setQuestionContent(map.get("questionContent2").toString());
			ocrmFpdProdQaReply.setQuestionMan(dto.getBody().getUserName());
			ocrmFpdProdQaReply.setQuestionDate(new Date());
			return this.updateSelective(getMapper(), ocrmFpdProdQaReply);
		}
		
	}

	/**
     * @方法名称: delerteQuestionsAnswers
	 * @方法描述: Q&A删除
	 * @param 
	 * @return
	 */
	public int delerteQuestionsAnswers(String questionId) {
		QueryModel queryModel = new QueryModel();
		queryModel.getCondition().put(QUESTIONID, questionId);
		return ocrmFpdProdQaReplyMapper.delerteQuestionsAnswers(queryModel);
	}
}
