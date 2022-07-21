package cn.com.yusys.yusp.dycrm.transferInfo.repository.mapper;

import java.util.List;
import java.util.Map;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.dycrm.transferInfo.domain.AcrmFlaTranDetail;
import cn.com.yusys.yusp.dycrm.transferInfo.domain.TransferInfoFA;
import cn.com.yusys.yusp.dycrm.transferInfo.domain.TransferInfoLA;

public interface AcrmFlaTranDetailMapper extends CommonMapper<AcrmFlaTranDetail> {

	List<Map<String, Object>> queryMonth(QueryModel queryModel);

	List<Map<String, Object>> queryAll(QueryModel queryModel);

    List<TransferInfoLA> excelMonth(QueryModel model);

	List<TransferInfoLA> excelAll(QueryModel model);
}
