package cn.com.yusys.yscrm.product.service;

import cn.com.yusys.yscrm.product.domain.AcrmFpdProdUserFocusInfo;
import cn.com.yusys.yscrm.product.repository.mapper.AcrmFpdProdUserFocusMapper;
import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class AcrmFpdProdUserFocusService  extends CommonService {
    @Autowired
    private AcrmFpdProdUserFocusMapper acrmFpdProdUserFocusMapper;

    @Override
    protected CommonMapper getMapper() {
        return acrmFpdProdUserFocusMapper;
    }

    @Autowired
    private UaaClient uaaClient;

    public Boolean productUserFocusInfoQuery(String prodCode,String prodId) {
        ResponseEntity<UserInfoDTO> dto  = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
        AcrmFpdProdUserFocusInfo acrmFpdProdUserFocusInfo = new AcrmFpdProdUserFocusInfo();
        acrmFpdProdUserFocusInfo.setUserId(dto.getBody().getUserId());
        acrmFpdProdUserFocusInfo.setProdCode(prodCode);
        acrmFpdProdUserFocusInfo.setSrcProdCode(prodId);
        int count = acrmFpdProdUserFocusMapper.productUserFocusInfoQuery(acrmFpdProdUserFocusInfo);
        if (count > 0){
            return true;
        }else {
            return false;
        }
    }

    public String updateProductUserFocusInfo(AcrmFpdProdUserFocusInfo acrmFpdProdUserFocusInfo) {
        ResponseEntity<UserInfoDTO> dto  = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
        Boolean flag = productUserFocusInfoQuery(acrmFpdProdUserFocusInfo.getProdCode(),acrmFpdProdUserFocusInfo.getSrcProdCode());
        acrmFpdProdUserFocusInfo.setUserId(dto.getBody().getUserId());
        if (flag){
            Integer num = acrmFpdProdUserFocusMapper.deleteProductUserFocusInfo(acrmFpdProdUserFocusInfo);
            if (num >0){
                return "取消关注成功";
            }else {
                return "取消关注失败";
            }
        }else {
            SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            acrmFpdProdUserFocusInfo.setFocusDate(s.format(new Date()));
            acrmFpdProdUserFocusInfo.setUserName(dto.getBody().getUserName());
            Integer num = this.insertSelective(acrmFpdProdUserFocusInfo);
            if (num >0){
                return "关注成功";
            }else {
                return "关注失败";
            }
        }
    }
}
