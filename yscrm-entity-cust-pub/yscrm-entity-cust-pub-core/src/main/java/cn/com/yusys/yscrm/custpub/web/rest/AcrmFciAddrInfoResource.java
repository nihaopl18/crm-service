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
import cn.com.yusys.yscrm.custpub.domain.AcrmFciAddrInfo;
import cn.com.yusys.yscrm.custpub.domain.AcrmFciCustIdentInfo;
import cn.com.yusys.yscrm.custpub.service.AcrmFciAddrInfoService;

/**
 * @项目名称: yscrm-entity-cust-pub-core模块
 * @类名称: AcrmFciAddrInfoResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-01-28 15:23:01
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/acrmfciaddrinfo")
public class AcrmFciAddrInfoResource extends CommonResource<AcrmFciAddrInfo, String> {
    @Autowired
    private AcrmFciAddrInfoService acrmFciAddrInfoService;

    @Override
    protected CommonService getCommonService() {
        return this.acrmFciAddrInfoService;
    }
	@GetMapping("/queryaddrlist/{custId}")
	public ResultDto<Object> queryAddrList(@PathVariable String custId,QueryModel model) {
		List<Map<String, Object>> list = acrmFciAddrInfoService.queryAddrList(custId,model);
		return new ResultDto<Object>(list);
	}
	@PostMapping("/addaddr")
	public ResultDto<Object> addAddr(@RequestBody AcrmFciAddrInfo  pool) throws URISyntaxException {
		    String returnStr="";
	      
	        AcrmFciAddrInfo list = acrmFciAddrInfoService.insertAddr(pool);
			returnStr=list.getId();
		
		
		return new ResultDto<Object>(returnStr);
	}
	@PostMapping("/updateaddr")
	public ResultDto<Object> updateAddr(@RequestBody AcrmFciAddrInfo  pool) throws URISyntaxException {
		    String returnStr="";
	
			int n = acrmFciAddrInfoService.updateAddr(pool);
			returnStr=String.valueOf(n);
		
		
		   return new ResultDto<Object>(returnStr);
	}
	@PostMapping("/deleteaddr")
	public ResultDto<Object> deleteAddr(@RequestBody Map idmap) {
		int n=0;
		if(idmap !=null) {
			//SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd ");//设置日期格式
			String ids=idmap.get("id").toString();
			String[] idStr=ids.toString().split(",");
			for(int i=0;i<idStr.length;i++) {
				if(!"".equals(idStr[i])) {
					n=n+this.acrmFciAddrInfoService.deleteAddrInfo(idStr[i]);
				}
			}
			//logger.info("批量删除  【主键："+ids+"】 "+df.format(new Date()));
		}
		return new ResultDto<Object>(n);
	}

}
