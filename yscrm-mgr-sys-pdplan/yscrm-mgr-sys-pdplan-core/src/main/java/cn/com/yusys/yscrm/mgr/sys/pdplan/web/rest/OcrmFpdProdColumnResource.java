package cn.com.yusys.yscrm.mgr.sys.pdplan.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yscrm.mgr.sys.pdplan.domain.OcrmFpdProdColumn;
import cn.com.yusys.yscrm.mgr.sys.pdplan.domain.OcrmFpdProdTable;
import cn.com.yusys.yscrm.mgr.sys.pdplan.service.OcrmFpdProdColumnService;

/**
 * @项目名称: yscrm-mgr-sys-pdplan-core模块
 * @类名称: OcrmFpdProdColumnResource
 * @类描述: 产品展示表属性定义
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-01-23 19:29:10
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/ocrmfpdprodcolumn")
public class OcrmFpdProdColumnResource extends CommonResource<OcrmFpdProdColumn, String> {
    @Autowired
    private OcrmFpdProdColumnService ocrmFpdProdColumnService;

    @Override
    protected CommonService getCommonService() {
        return ocrmFpdProdColumnService;
    }
    /**
   	* @方法名称: save
   	* @方法描述: 保存产品展示表属性定义信息
   	* @参数与返回说明: 
   	* @算法描述: 
   	*/
    @PostMapping("/save")
    public ResultDto<Integer> save(@RequestBody List<OcrmFpdProdColumn> ocrmFpdProdColumns){
    	ResultDto<Integer> resultDto = null;
    	if (ocrmFpdProdColumns == null) {
			resultDto = new ResultDto<>();
			resultDto.setCode(-1);
			resultDto.setMessage("保存成功");
			return resultDto;
		}
    	resultDto = new ResultDto<>(ocrmFpdProdColumnService.save(ocrmFpdProdColumns));
    	resultDto.setCode(0);
    	resultDto.setMessage("保存成功");
		return resultDto;
    	
    	
    }

}
