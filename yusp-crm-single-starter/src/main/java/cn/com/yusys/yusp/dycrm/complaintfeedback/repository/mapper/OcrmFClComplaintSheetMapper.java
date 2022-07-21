package cn.com.yusys.yusp.dycrm.complaintfeedback.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.dycrm.complaintfeedback.domain.CustomerInformationDTO;
import cn.com.yusys.yusp.dycrm.complaintfeedback.domain.OcrmFClComplaintSheet;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface OcrmFClComplaintSheetMapper extends CommonMapper<OcrmFClComplaintSheet> {


    List<Map<String, Object>> queryComplaint(Map<String, Object> queryMap);

    CustomerInformationDTO queryComplaintSheetInfo(Map<String, Object> queryMap);

    int saveData(Map<String, Object> queryMap);

    OcrmFClComplaintSheet sheetQueryHandle(String sheetId);

    CustomerInformationDTO sheetQueryHandleTest(String sheetId);
}
