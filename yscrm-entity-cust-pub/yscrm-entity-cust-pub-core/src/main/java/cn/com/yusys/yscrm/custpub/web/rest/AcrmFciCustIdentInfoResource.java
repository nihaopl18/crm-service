package cn.com.yusys.yscrm.custpub.web.rest;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yscrm.custpub.domain.AcrmFciCustIdentInfo;
import cn.com.yusys.yscrm.custpub.service.AcrmFciCustIdentInfoService;

/**
 * @项目名称: yscrm-entity-cust-pub-core模块
 * @类名称: AcrmFciCustIdentInfoResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-01-27 17:34:34
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/acrmfcicustident")
public class AcrmFciCustIdentInfoResource extends CommonResource<AcrmFciCustIdentInfo, String> {
    @Autowired
    private AcrmFciCustIdentInfoService acrmFciCustIdentInfoService;

    @Override
    protected CommonService getCommonService() {
        return this.acrmFciCustIdentInfoService;
    }
	@GetMapping("/queryidentlist/{custId}")
	public ResultDto<Object> queryIdentList(@PathVariable String custId,QueryModel model) {
		List<Map<String, Object>> list = acrmFciCustIdentInfoService.queryIdentList(custId,model);
		return new ResultDto<Object>(list);
	}
	@PostMapping("/addident")
	public ResultDto<Object> addIdent(@RequestBody AcrmFciCustIdentInfo  pool) throws URISyntaxException {
		    String returnStr="";
	      
			AcrmFciCustIdentInfo list = acrmFciCustIdentInfoService.insertIdent(pool);
			returnStr=list.getId();
		
		
		return new ResultDto<Object>(returnStr);
	}
	@PostMapping("/updateident")
	public ResultDto<Object> updateIdent(@RequestBody AcrmFciCustIdentInfo  pool) throws URISyntaxException {
		    String returnStr="";
	
			int n = acrmFciCustIdentInfoService.updateIdent(pool);
			returnStr=String.valueOf(n);
		
		
		   return new ResultDto<Object>(returnStr);
	}
	@PostMapping("/delete")
	public ResultDto<Object> delete(@RequestBody Map idmap) {
		int n=0;
		if(idmap !=null) {
			//SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd ");//设置日期格式
			String ids=idmap.get("id").toString();
			String[] idStr=ids.toString().split(",");
			for(int i=0;i<idStr.length;i++) {
				if(!"".equals(idStr[i])) {
					n=n+this.acrmFciCustIdentInfoService.deleteIdentInfo(idStr[i]);
				}
			}
			//logger.info("批量删除  【主键："+ids+"】 "+df.format(new Date()));
		}
		return new ResultDto<Object>(n);
	}

}
