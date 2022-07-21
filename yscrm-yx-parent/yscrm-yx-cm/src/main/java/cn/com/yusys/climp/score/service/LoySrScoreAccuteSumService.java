package cn.com.yusys.climp.score.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import cn.com.yusys.climp.cust.repository.mapper.LoyCmCustInfoMapper;
import cn.com.yusys.climp.qypool.service.UserInfoService;
import cn.com.yusys.climp.score.domain.LoySrScoreAccuteSum;
import cn.com.yusys.climp.score.domain.LoySrScoreCollect;
import cn.com.yusys.climp.score.domain.ScoreExch;
import cn.com.yusys.climp.score.repository.mapper.LoySrScoreCollectMapper;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.climp.score.repository.mapper.LoySrScoreAccuteSumMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;

/**
 * @项目名称:  yusp-climp-cust模块
 * @类名称: LoySrScoreAccuteSumService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-01-22 15:04:27
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class LoySrScoreAccuteSumService extends CommonService {
	private Logger logger = LoggerFactory.getLogger(LoySrScoreAccuteSumService.class);
    @Autowired
    private LoySrScoreAccuteSumMapper loySrScoreAccuteSumMapper;
	@Autowired
	private LoyCmCustInfoMapper loyCmCustInfoMapper;
	@Autowired
	private LoySrScoreCollectMapper loySrScoreCollectMapper;

	@Autowired
	private UserInfoService userInfoService;

	SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    protected CommonMapper<?> getMapper() {
        return loySrScoreAccuteSumMapper;
    }
	/**
	 * 
	* @方法名称: findAllByParam
	* @方法描述: 分页查询
	* @参数与返回说明: 
	* @算法描述:
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> findAllByParam(QueryModel param){
		// 设置分页查询参数(设置到线程变量中了)
		PageHelper.startPage(param.getPage(), param.getSize());
//		param.setSort("cust_id desc");
		List<Map<String, Object>> result=this.loySrScoreAccuteSumMapper.queryCustContriByPage(param);
		PageHelper.clearPage();
		logger.info("客户累积积分贡献度信息分页查询");
		return result;
	}

	/**
	 * 积分兑换-积分扣减
	 * @param scoreExch
	 * @return
	 */
	public String scoreDeduct(ScoreExch scoreExch) throws Exception{
		ResultDto<String> rs = new ResultDto<>();

		LoySrScoreAccuteSum loySrScoreAccuteSum = new LoySrScoreAccuteSum();
		loySrScoreAccuteSum.setCustNo(scoreExch.getCustId());
		loySrScoreAccuteSum.setScoreDealType("20");
		loySrScoreAccuteSum.setThisSumScore(scoreExch.getDeduScore().negate());
		loySrScoreAccuteSum.setLastSrAccute(scoreExch.getScoreSum());
		loySrScoreAccuteSum.setCurrSrAccute(loySrScoreAccuteSum.getLastSrAccute().subtract(scoreExch.getDeduScore()));
		String date = scoreExch.getOderDt();
		if (date == ""){
			date = s.format(new Date());
		}
		loySrScoreAccuteSum.setBusnDate(s.parse(date));
		this.insertSelective(loySrScoreAccuteSumMapper,loySrScoreAccuteSum);//客户积分明细

		/*
		添加积分扣减提醒信息
		 */

		List<Map<String,Object>> loySrScoreCollects = loyCmCustInfoMapper.getUseableAccount(scoreExch.getCustId());//查询客户可用积分账户
		if (loySrScoreCollects != null && loySrScoreCollects.size() > 0){
			LoySrScoreCollect loySrScoreCollect = new LoySrScoreCollect();
			loySrScoreCollect.setScdId(loySrScoreAccuteSum.getScdId());
			loySrScoreCollect.setCustNo(scoreExch.getCustId());
			loySrScoreCollect.setBusnDate(loySrScoreAccuteSum.getBusnDate());
			int i = 0;
			BigDecimal deduScore = scoreExch.getDeduScore();
			Map<String,Object> map = null;
			while (deduScore.compareTo(BigDecimal.ZERO) > 0){
				map = loySrScoreCollects.get(i);
				loySrScoreCollect.setAccountCode((String) map.get("sdaId"));
				loySrScoreCollect.setScoreDealType("20");
				loySrScoreCollect.setLastSrAccute((BigDecimal) map.get("useableScore"));
				if (deduScore.compareTo(loySrScoreCollect.getLastSrAccute()) <= 0){
					loySrScoreCollect.setThisSumScore(deduScore.negate());
					loySrScoreCollect.setCurrSrAccute(loySrScoreCollect.getLastSrAccute().subtract(deduScore));
					deduScore = BigDecimal.ZERO;
				}else {
					loySrScoreCollect.setThisSumScore(loySrScoreCollect.getLastSrAccute().negate());
					loySrScoreCollect.setCurrSrAccute(BigDecimal.ZERO);
					deduScore = deduScore.subtract(loySrScoreCollect.getLastSrAccute());
				}
				this.insertSelective(loySrScoreCollectMapper,loySrScoreCollect);//客户账户积分明细
				loySrScoreCollect.setId(null);
				i++;
			}
		}
		return loySrScoreAccuteSum.getScdId();
	}

}
