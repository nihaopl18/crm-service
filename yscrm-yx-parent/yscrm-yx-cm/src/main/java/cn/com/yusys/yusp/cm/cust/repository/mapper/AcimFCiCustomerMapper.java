package cn.com.yusys.yusp.cm.cust.repository.mapper;

import cn.com.yusys.yusp.cm.cust.domain.AcimBlackListCustomer;
import cn.com.yusys.yusp.cm.cust.domain.AcimFCiCustomer;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AcimFCiCustomerMapper extends CommonMapper<AcimFCiCustomer>{
	List<AcimFCiCustomer> getListByModel(QueryModel model);
	AcimFCiCustomer getIdByIdentNo(AcimFCiCustomer acimFCiCustomer);
	int addPotentialCust(AcimFCiCustomer acimFCiCustomer);
	AcimFCiCustomer getCustByid(String custId);
	List<AcimFCiCustomer> getCustTypeByid(String custId);
	String getSeq();
	List<AcimFCiCustomer> getCmpList(List<String> list);
	List<AcimFCiCustomer> getcustBycustId(List<String> list2);

	void deleteByIdLike(String id);

	void insertAll(@Param("sql") String sql);

	 List<AcimBlackListCustomer> getBlackListCustomer();
}
