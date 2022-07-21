package cn.com.yusys.climp.qypool.web.rest;

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
import org.springframework.web.multipart.MultipartFile;

import cn.com.yusys.climp.qypool.domain.LoyQyVirtBatch;
import cn.com.yusys.climp.qypool.domain.LoyQyVirtTicket;
import cn.com.yusys.climp.qypool.domain.LoyQyVirtTicketKind;
import cn.com.yusys.climp.qypool.service.LoyQyVirtTicketService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;

/**
 * @项目名称: yusp-climp-qypool模块
 * @类名称: LoyQyVirtTicketResource
 * @类描述: #资源类
 * @功能描述:
 * @创建人: hujun3
 * @创建时间: 2019-02-21 15:19:34
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 *        -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/loyqyvirtticket")
public class LoyQyVirtTicketResource extends CommonResource<LoyQyVirtTicket, String> {

	private static final String loyAcEquCatalogService = null;
	private Logger logger = LoggerFactory.getLogger(LoyQyVirtTicketResource.class);
	@Autowired
	private LoyQyVirtTicketService loyQyVirtTicketService;

	@Override
	protected CommonService getCommonService() {
		return loyQyVirtTicketService;
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

		ResultDto<List<Map<String, Object>>> reuslt = new ResultDto<List<Map<String, Object>>>();
		try {
			List<Map<String, Object>> list = loyQyVirtTicketService.findAllByParam(queryModel);
			if (list.isEmpty()) {
				reuslt.setCode(200001);
				reuslt.setMessage("noData");
			} else {
				reuslt = new ResultDto<List<Map<String, Object>>>(list);
			}
			logger.info("虚拟票券分页查询");
		} catch (Exception e) {
			reuslt.setCode(100001);
			reuslt.setMessage("fail");
		}
		return reuslt;
	}

	/**
	 * 
	 * @方法名称: getdetail
	 * @方法描述: 审批页面查询虚拟票券信息
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@GetMapping("/detail")
	public ResultDto<Map<String, Object>> getdetail(String id) {

		ResultDto<Map<String, Object>> reuslt = new ResultDto<Map<String, Object>>();
		try {
			List<Map<String, Object>> list = loyQyVirtTicketService.wfQueryTicketInfo(id);
			if (list.isEmpty()) {
				reuslt.setCode(200001);
				reuslt.setMessage("noData");
			} else {
				reuslt = new ResultDto<Map<String, Object>>(list.get(0));
			}
			logger.info("审批页面查询虚拟票券信息");
		} catch (Exception e) {
			reuslt.setCode(100001);
			reuslt.setMessage("fail");
		}
		return reuslt;
	}

	/**
	 * 
	 * @方法名称: queryInfoByIds
	 * @方法描述: 根据多条ID查询票券信息
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@GetMapping("/querybyids")
	public ResultDto<List<LoyQyVirtTicket>> queryInfoByIds(String ticketNo) {

		ResultDto<List<LoyQyVirtTicket>> reuslt = new ResultDto<List<LoyQyVirtTicket>>();
		try {
			List<LoyQyVirtTicket> list = loyQyVirtTicketService.queryInfoByIds(ticketNo);
			if (list.isEmpty()) {
				reuslt.setCode(200001);
				reuslt.setMessage("noData");
			} else {
				reuslt = new ResultDto<List<LoyQyVirtTicket>>(list);
			}
			logger.info("查询虚拟票券信息");
		} catch (Exception e) {
			reuslt.setCode(100001);
			reuslt.setMessage("fail");
		}
		return reuslt;
	}

	/**
	 * 
	 * @方法名称: getBatchList
	 * @方法描述: 分页查询批次
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@GetMapping("/querybatch")
	public ResultDto<List<Map<String, Object>>> getBatchList(QueryModel queryModel) {

		ResultDto<List<Map<String, Object>>> reuslt = new ResultDto<List<Map<String, Object>>>();
		try {
			List<Map<String, Object>> list = loyQyVirtTicketService.findBatchByParam(queryModel);
			if (list.isEmpty()) {
				reuslt.setCode(200001);
				reuslt.setMessage("noData");
			} else {
				reuslt = new ResultDto<List<Map<String, Object>>>(list);
			}
			logger.info("虚拟票券批次分页查询");
		} catch (Exception e) {
			reuslt.setCode(100001);
			reuslt.setMessage("fail");
		}
		return reuslt;
	}

	/**
	 * 
	 * @方法名称: getBatchDetail
	 * @方法描述: 审批页面查询虚拟票券批次信息
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@GetMapping("/batchdetail")
	public ResultDto<Map<String, Object>> getBatchDetail(String id) {

		ResultDto<Map<String, Object>> reuslt = new ResultDto<Map<String, Object>>();
		try {
			List<Map<String, Object>> list = loyQyVirtTicketService.wfQueryBatchInfo(id);
			if (list.isEmpty()) {
				reuslt.setCode(200001);
				reuslt.setMessage("noData");
			} else {
				reuslt = new ResultDto<Map<String, Object>>(list.get(0));
			}
			logger.info("审批页面查询虚拟票券批次信息");
		} catch (Exception e) {
			reuslt.setCode(100001);
			reuslt.setMessage("fail");
		}
		return reuslt;
	}

	/**
	 * 
	 * @方法名称: getStockList
	 * @方法描述: 分页查询虚拟票券库存信息
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@GetMapping("/querystock")
	public ResultDto<List<Map<String, Object>>> getStockList(QueryModel queryModel) {

		ResultDto<List<Map<String, Object>>> reuslt = new ResultDto<List<Map<String, Object>>>();
		try {
			List<Map<String, Object>> list = loyQyVirtTicketService.findStockByParam(queryModel);
			if (list.isEmpty()) {
				reuslt.setCode(200001);
				reuslt.setMessage("noData");
			} else {
				reuslt = new ResultDto<List<Map<String, Object>>>(list);
			}
			logger.info("虚拟票券库存分页查询");
		} catch (Exception e) {
			reuslt.setCode(100001);
			reuslt.setMessage("fail");
		}
		return reuslt;
	}

	/**
	 * 
	 * @方法名称: addTicketInfo
	 * @方法描述: 新增虚拟票券数据
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@PostMapping("/addticketinfo")
	public ResultDto<Object> addTicketInfo(@RequestBody LoyQyVirtTicket pool) throws URISyntaxException {
		ResultDto<Object> reuslt = new ResultDto<Object>();
		try {
			loyQyVirtTicketService.addTicketInfo(pool);
			reuslt.setMessage("success");
			logger.info("新增虚拟票券数据");
		} catch (Exception e) {
			e.printStackTrace();
			reuslt.setCode(100001);
			reuslt.setMessage("fail:" + e);
		}
		return reuslt;
	}

	/**
	 * 
	 * @方法名称: updateTicketInfo
	 * @方法描述: 更新虚拟票券数据
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@PostMapping("/updateticketinfo")
	public ResultDto<Object> updateTicketInfo(@RequestBody LoyQyVirtTicket pool) throws URISyntaxException {
		ResultDto<Object> reuslt = new ResultDto<Object>();
		try {
			loyQyVirtTicketService.updateTicketInfo(pool);
			reuslt.setMessage("success");
			logger.info("更新虚拟票券数据");
		} catch (Exception e) {
			e.printStackTrace();
			reuslt.setCode(100001);
			reuslt.setMessage("fail:" + e);
		}
		return reuslt;
	}

	/**
	 * 
	 * @方法名称: addBatchInfo
	 * @方法描述: 新增虚拟票券批次数据
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@PostMapping("/addbatchinfo")
	public ResultDto<Object> addBatchInfo(@RequestBody LoyQyVirtBatch pool) throws URISyntaxException {
		ResultDto<Object> reuslt = new ResultDto<Object>();
		try {
			loyQyVirtTicketService.addBatchInfo(pool);
			reuslt.setMessage("success");
			logger.info("新增虚拟票券批次数据");
		} catch (Exception e) {
			e.printStackTrace();
			reuslt.setCode(100001);
			reuslt.setMessage("fail:" + e);
		}
		return reuslt;
	}

	/**
	 * 
	 * @方法名称: updateBatchInfo
	 * @方法描述: 修改虚拟票券批次数据
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@PostMapping("/updatebatchinfo")
	public ResultDto<Object> updateBatchInfo(@RequestBody LoyQyVirtBatch pool) throws URISyntaxException {
		ResultDto<Object> reuslt = new ResultDto<Object>();
		try {
			loyQyVirtTicketService.updateBatchInfo(pool);
			reuslt.setMessage("success");
			logger.info("修改虚拟票券批次数据");
		} catch (Exception e) {
			e.printStackTrace();
			reuslt.setCode(100001);
			reuslt.setMessage("fail:" + e);
		}
		return reuslt;
	}

	/**
	 * 
	 * @方法名称: updateTicketSts
	 * @方法描述: 更新虚拟票券数据的生效状态
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@PostMapping("/updatests")
	public ResultDto<Object> updateTicketSts(@RequestBody Map<?, ?> param) throws URISyntaxException {
		ResultDto<Object> reuslt = new ResultDto<Object>();
		try {
			if (param != null) {
				loyQyVirtTicketService.updateStsById(param.get("ids").toString(), param.get("status").toString());
				;
				reuslt.setMessage("success");
				logger.info("更新虚拟票券数据的生效状态");
			} else {
				reuslt.setCode(100001);
				reuslt.setMessage("fail:请求参数为空");
			}

		} catch (Exception e) {
			e.printStackTrace();
			reuslt.setCode(100001);
			reuslt.setMessage("fail:" + e);
		}
		return reuslt;
	}

	/**
	 * 
	 * @方法名称: deleteTicket
	 * @方法描述: 删除相关数据
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@PostMapping("/deleteinfo")
	public ResultDto<Object> deleteTicket(String ids) throws URISyntaxException {
		ResultDto<Object> reuslt = new ResultDto<Object>();
		try {
			loyQyVirtTicketService.deleteByIds(ids);
			reuslt.setMessage("success");
			logger.info("删除虚拟票券数据");
		} catch (Exception e) {
			e.printStackTrace();
			reuslt.setCode(100001);
			reuslt.setMessage("fail:" + e);
		}
		return reuslt;
	}

	/**
	 * 
	 * @方法名称: deleteBatch
	 * @方法描述: 删除批次相关数据
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@PostMapping("/deletebatchinfo")
	public ResultDto<Object> deleteBatch(String ids) throws URISyntaxException {
		ResultDto<Object> reuslt = new ResultDto<Object>();
		try {
			loyQyVirtTicketService.deleteBatchInfo(ids);
			reuslt.setMessage("success");
			logger.info("删除虚拟票券批次数据");
		} catch (Exception e) {
			e.printStackTrace();
			reuslt.setCode(100001);
			reuslt.setMessage("fail:" + e);
		}
		return reuslt;
	}

	/**
	 * 
	 * @方法名称: uploadStocklist
	 * @方法描述: 批量导入虚拟票券信息数据
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@PostMapping("/uploadstocklist")
	public ResultDto<Object> uploadStocklist(@RequestParam(required = false) String flag,
			@RequestParam(required = false) String batchNo, @RequestParam(required = false) String ticketNo,
			MultipartFile file) {
		ResultDto<Object> rs = new ResultDto<Object>();
		try {
			String magges = this.loyQyVirtTicketService.dataImport(flag, batchNo, ticketNo, file);
			if (magges.equals("")) {
				rs.setMessage("导入失败");
				rs.setCode(-1);
				return rs;
			}
			rs.setMessage(magges);
			rs.setCode(0);
			return rs;
		} catch (Exception e) {
			rs.setCode(-1);
			rs.setMessage("导入失败：" + e.getMessage());
			// TODO Auto-generated catch block
			// e.printStackTrace();
		} // UTF-8
		return rs;
	}

	@GetMapping("/listtree")
	public ResultDto<List<Map<String, Object>>> listTree(QueryModel model) {
		return new ResultDto<>(loyQyVirtTicketService.getListTree(model));
	}

	@PostMapping("/add")
	public ResultDto<Integer> add(@RequestBody LoyQyVirtTicketKind record) {
		return new ResultDto<>(loyQyVirtTicketService.add(record));
	}

	@PostMapping("/upd")
	public ResultDto<Integer> upd(@RequestBody LoyQyVirtTicketKind record) {
		return new ResultDto<>(loyQyVirtTicketService.upd(record));
	}

	@PostMapping("/del")
	public ResultDto<Integer> del(@RequestBody String id) {
		return loyQyVirtTicketService.del(id);
	}
}
