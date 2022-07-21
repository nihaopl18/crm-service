package cn.com.yusys.yscimc.operation.service;

import java.util.List;
import java.util.Map;

public interface InternetMarketingDataService {

    /**
     * 获取手机银行栏位信息
     * @param data
     * @return
     */
    List<Map<String,Object>> getMobileBankingWindows(String data);

    /**
     * 获取报名组件信息
     * @param data
     * @return
     */
    Object getSignUpData(String data);

    /**
     * 获取分享组件信息
     * @param data
     * @return
     */
    Object getShareData(String data);

    /**
     * 获取裂变组件信息
     * @param data
     * @return
     */
    Object getFissionData(String data);
}
