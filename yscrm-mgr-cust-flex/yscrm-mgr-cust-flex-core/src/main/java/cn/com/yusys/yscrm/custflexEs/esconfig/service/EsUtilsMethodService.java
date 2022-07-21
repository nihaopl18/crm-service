package cn.com.yusys.yscrm.custflexEs.esconfig.service;

import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yscrm.custflexEs.esconfig.dto.PageInfo;

import org.springframework.stereotype.Service;

/**
 * @ClassName: EsUtilsMethodsService
 * @Description: TODO
 * @Author: Administrator
 * @Date: 2020/8/7 11:08
 * @Version: 1.0
 **/
@Service
public class EsUtilsMethodService {

    public PageInfo getPagingInfo(QueryModel model){
        // 查询第几页
    	Integer queryPage = model.getPage();
        // 每页的页数
    	Integer pageSize = model.getSize();
        
		if (queryPage == null || queryPage <= 0) {
			queryPage = 1;
		}
			
		if (pageSize == null || pageSize <= 0) {
			pageSize = 10;
		}
        // 判断从第几条开始
        int start = (queryPage - 1) * pageSize + 1;
        // 判断到第几条结束
        int end = queryPage * pageSize;
        // 判断截取时从第几条开始
        int subStart = start - 1;
        // 判断截取时到第几条结束
        int subEnd = end - 1;

        PageInfo pageInfo = new PageInfo();

        pageInfo.setStart(start);

        pageInfo.setEnd(end);

        pageInfo.setSubStart(subStart);

        pageInfo.setSubEnd(subEnd);

        pageInfo.setPageSize(pageSize);

        return pageInfo;

    }
}
