//package cn.com.yusys.yusp.uimp.base.app.uaa.web.rest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import cn.com.yusys.yusp.commons.service.CommonService;
//import cn.com.yusys.yusp.commons.web.rest.CommonResource;
//import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
//import cn.com.yusys.yusp.uimp.base.app.uaa.domain.PmaFappAgreement;
//import cn.com.yusys.yusp.uimp.base.app.uaa.service.PmaFappAgreementService;
//
///**
// * @项目名称: yscrm-base-core模块
// * @类名称: PmaFappAgreementResource
// * @类描述: #资源类
// * @功能描述: 
// * @创建人: sawyer
// * @创建时间: 2019-07-17 17:29:20
// * @修改备注: 
// * @修改记录: 修改时间    修改人员    修改原因
// * -------------------------------------------------------------
// * @version 1.0.0
// * @Copyright (c) 宇信科技-版权所有
// */
//@RestController
//@RequestMapping("/api/app/agreement")
//public class PmaFappAgreementResource extends CommonResource<PmaFappAgreement, String> {
//	@Autowired
//	private PmaFappAgreementService pmaFappAgreementService;
//
//	@RequestMapping(value = "/queryList")
//	@ResponseBody
//	public ResultDto<String> queryList() {
//		ResultDto<String> result = new ResultDto<String>();
//		String list = pmaFappAgreementService.queryList();
//		result.setCode(0);
//		result.setMessage("协议返回成功！");
//		result.setData(list);
//		return result;
//	}
//
//	@Override
//	protected CommonService getCommonService() {
//		return pmaFappAgreementService;
//	}
//
//}
