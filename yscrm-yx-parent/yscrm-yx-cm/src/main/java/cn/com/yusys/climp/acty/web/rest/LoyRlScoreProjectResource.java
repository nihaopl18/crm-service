package cn.com.yusys.climp.acty.web.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.climp.acty.domain.LoyRlScoreProject;
import cn.com.yusys.climp.acty.service.LoyRlScoreProjectService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;

/**
 * @项目名称: yusp-climp-single-starter模块
 * @类名称: LoyRlScoreProjectResource
 * @类描述: 积分活动分类资源类
 * @功能描述: 
 * @创建人: chenlin2@yusys.com.cn
 * @创建时间: 2019-01-03 09:40:41
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/scoreproject")
public class LoyRlScoreProjectResource extends CommonResource<LoyRlScoreProject, String> {
    @Autowired
    private LoyRlScoreProjectService loyRlScoreProjectService;

    @Override
    protected CommonService getCommonService() {
        return loyRlScoreProjectService;
    }
    /**
	 * 查询积分活动分类树
	 * @param queryModel
	 * @return
	 */
	@GetMapping("/list")
	public ResultDto<List<LoyRlScoreProject>> getScoreProject(
			QueryModel queryModel) {
		List<LoyRlScoreProject> list = loyRlScoreProjectService.getScoreProject(queryModel);
		return new ResultDto<List<LoyRlScoreProject>>(list);
	}
	/**
	 * 积分活动分类刪除
	 * @param ids
	 * @return
	 */
	@PostMapping("/deletebatch")
    public ResultDto<Integer> deleteBatch(@RequestBody Map<?,?> map) {
    	String[] idStr=map.get("id").toString().split(",");
    	String orgCode = map.get("orgCode").toString();
        return new ResultDto<Integer>(loyRlScoreProjectService.deleteBatch(idStr,orgCode));
    }
}
