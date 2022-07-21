package cn.com.yusys.climp.qypool.web.rest;

import java.util.List;
import java.util.Map;

import cn.com.yusys.climp.qypool.domain.LoyQyCommModelStorage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.climp.qypool.domain.LoyQyCommModel;
import cn.com.yusys.climp.qypool.service.LoyQyCommModelService;

/**
 * @项目名称: yusp-climp-qypool-core模块
 * @类名称: LoyQyCommModelResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: chenlin
 * @创建时间: 2019-02-26 14:40:00
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/loyqycommmodel")
public class LoyQyCommModelResource extends CommonResource<LoyQyCommModel, String> {
    private Logger logger = LoggerFactory.getLogger(LoyQyCommModelResource.class);
    @Autowired
    private LoyQyCommModelService loyQyCommModelService;

    @Override
    protected CommonService getCommonService() {
        return loyQyCommModelService;
    }
    /**
    * @方法名称:getModel
    * @方法描述:根据商品编号查询商品规格
    * @参数与返回说明:
    * @算法描述:
     */
    @GetMapping("/modellist")
   	public ResultDto<List<LoyQyCommModel>> getModel(String commodityCode) {
   		List<LoyQyCommModel> list = loyQyCommModelService.getModel(commodityCode);
   		return new ResultDto<List<LoyQyCommModel>>(list);
   	}
    /**
     * @方法名称:updateModel
     * @方法描述:商品规格库存管理
     * @参数与返回说明:
     * @算法描述:
     */
    @PostMapping("/updatemodel")
    public ResultDto<Integer> updateModel(@RequestBody LoyQyCommModelStorage loyQyCommModelStorage) {
        // return new ResultDto<Integer>(loyQyCommModelService.delModel(idStr));
        try {
            return new ResultDto<>(loyQyCommModelService.updateModel(loyQyCommModelStorage));
        }catch (Exception e){
            ResultDto rs = new ResultDto();
            rs.setCode(-1);
            rs.setMessage("系统错误");
            logger.error(e.getMessage());
            e.printStackTrace();
            return rs;
        }
    }
    /**
    * @方法名称:delModel
    * @方法描述:商品规格删除
    * @参数与返回说明:
    * @算法描述:
     */
    @PostMapping("/delmodel")
    public ResultDto<Integer> delModel(@RequestBody Map<?,?> map) {
    	String[] idStr = map.get("ids").toString().split(",");
        // return new ResultDto<Integer>(loyQyCommModelService.delModel(idStr));
    	return new ResultDto<Integer>(loyQyCommModelService.delGiftModel(idStr));
    }
    /**
    * @方法名称:defaultModel
    * @方法描述:默认规格
    * @参数与返回说明:
    * @算法描述:
     */
    @RequestMapping("/defaultmodel")
	public ResultDto<Integer> defaultModel(@RequestBody String id) {
		return new ResultDto<Integer>(loyQyCommModelService.defaultModel(id));
	}
    /**
     * @方法名称:modelParamQuery
     * @方法描述:商品规格查询
     * @参数与返回说明:
     * @算法描述:
      */
    @GetMapping("/modelparamquery")
    public ResultDto<List<Map<String,Object>>> modelParamQuery(@RequestParam(required = false) String commodityCode) {
    	return new ResultDto<List<Map<String,Object>>>(loyQyCommModelService.modelParamQuery(commodityCode));
    }
}
