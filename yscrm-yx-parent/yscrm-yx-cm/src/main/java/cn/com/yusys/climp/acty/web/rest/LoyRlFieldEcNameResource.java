package cn.com.yusys.climp.acty.web.rest;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.climp.acty.domain.LoyRlFieldEcName;
import cn.com.yusys.climp.acty.service.LoyRlFieldEcNameService;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;

/**
 * @项目名称: yusp-climp-single-starter模块
 * @类名称: LoyRlFieldEcNameResource
 * @类描述: 表字段资源类
 * @功能描述: 
 * @创建人: chenlin2@yusys.com.cn
 * @创建时间: 2018-12-29 15:08:29
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/fieldecname")
public class LoyRlFieldEcNameResource extends CommonResource<LoyRlFieldEcName, String> {
    @Autowired
    private LoyRlFieldEcNameService loyRlFieldEcNameService;

    @Override
    protected CommonService getCommonService() {
        return loyRlFieldEcNameService;
    }
    /**
	 * 查询字段信息
	 * @param tableId
	 * @param queryModel
	 * @return
	 */
	@GetMapping("/fieldlist")
	public ResultDto<List<LoyRlFieldEcName>> getFieldByTableId(@RequestParam(required = false) String tableId) {
    	List<LoyRlFieldEcName> list = loyRlFieldEcNameService.getFieldByTableId(tableId);
		return new ResultDto<List<LoyRlFieldEcName>>(list);
	}
	
	/**
	 * 保存表字段汉化
	 * @param t
	 * @return
	 * @throws URISyntaxException
	 */
	@PostMapping("/savefield")
    public  ResultDto<Object> saveField(@RequestBody ArrayList<LoyRlFieldEcName> t)
            throws URISyntaxException {
    	 List<LoyRlFieldEcName> list = t;
    	 loyRlFieldEcNameService.saveField(list);
         return new ResultDto<Object>();
    }
}
