package cn.com.yusys.yusp.dycrm.complaintfeedback.repository.mapper;

import cn.com.yusys.yusp.dycrm.complaintfeedback.domain.CustomerInformationDTO;

import java.util.Map;

public interface CSRSheetPushOperateMapper {
    Map<String, Object> queryCustMgrNo(Map<String, Object> map);

    int sheetIdIsExist(Map<String, Object> map);

    int coverSheet(Map<String, Object> map);

    Map<String, Object> queryEcifNo(Map<String, Object> map);

    int sheetPushHandle(Map<String, Object> map);

    Map<String, Object> queryEcifNoByCust(CustomerInformationDTO customerInformationDTO);

    int sheetIdIsExistTest(CustomerInformationDTO customerInformationDTO);

    int coverSheetTest(CustomerInformationDTO customerInformationDTO);

    int sheetPushHandleTest(CustomerInformationDTO customerInformationDTO);
}
