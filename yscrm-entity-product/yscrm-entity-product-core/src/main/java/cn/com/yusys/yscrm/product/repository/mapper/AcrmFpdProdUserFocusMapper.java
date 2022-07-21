package cn.com.yusys.yscrm.product.repository.mapper;

import cn.com.yusys.yscrm.product.domain.AcrmFpdProdUserFocusInfo;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;

public interface AcrmFpdProdUserFocusMapper extends CommonMapper<AcrmFpdProdUserFocusInfo> {

    Integer productUserFocusInfoQuery(AcrmFpdProdUserFocusInfo acrmFpdProdUserFocusInfo);

    Integer deleteProductUserFocusInfo(AcrmFpdProdUserFocusInfo acrmFpdProdUserFocusInfo);
}
