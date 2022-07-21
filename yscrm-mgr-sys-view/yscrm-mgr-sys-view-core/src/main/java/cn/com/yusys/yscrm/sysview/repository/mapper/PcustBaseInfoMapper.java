package cn.com.yusys.yscrm.sysview.repository.mapper;

import cn.com.yusys.yscrm.custpub.domain.AcrmCustCount;
import cn.com.yusys.yscrm.sysview.domain.*;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


public interface PcustBaseInfoMapper {

    BaseInfo getBaseInfo(QueryModel model);

    List<CertInfo> getCertInfo(QueryModel model);

    EduInfo getEduInfo(QueryModel model);

    OccInfo getOccInfo(QueryModel model);

    HouseInfo getHouseInfo(QueryModel model);

    BelongInfo getBelongInfo(QueryModel model);

    FamInfo getFamInfo(QueryModel model);

    String getcustIdName(String custId);

    void insertCount(AcrmCustCount acrmCustCount);


    void insertassets(CrmFCiUserAssets crmFCiUserAssets);

    void updateassets(CrmFCiUserAssets crmFCiUserAssets);

    void insertinformation(CrmFCiUserInformation userInformation);

    void updateformation(CrmFCiUserInformation userInformation);

    CrmFCiUserInformation selectuserInfo(Map<String, Object> map);

    List<CrmFCiUserAssets> selectassets(Map<String, Object> map);

    int checkUpNameId(Map<String, Object> map);

    void checkdelete(Map<String, Object> map);
}
