package cn.com.yusys.yscrm.product.web.rest;

import cn.com.yusys.yscrm.product.domain.AcrmFpdProdInfo;
import cn.com.yusys.yscrm.product.domain.AcrmFpdProdUserFocusInfo;
import cn.com.yusys.yscrm.product.service.AcrmFpdProdUserFocusService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/acrmfpdproduserfocusinfo")
public class AcrmFpdProdUserFocusResource  extends CommonResource<AcrmFpdProdUserFocusInfo, String> {
    @Autowired
    private AcrmFpdProdUserFocusService acrmFpdProdUserFocusService;

    @Override
    protected CommonService getCommonService() {
        return acrmFpdProdUserFocusService;
    }

    /**
     * @方法名称: productUserFocusInfoQuery
     * @方法描述: 用户关注
     * @param prodCode,prodId
     * @return
     */
    @GetMapping("/infoquery")
    public ResultDto<Boolean> productUserFocusInfoQuery(@RequestParam(value="prodCode")String prodCode, @RequestParam(value="prodId") String prodId) {
        Boolean flag = acrmFpdProdUserFocusService.productUserFocusInfoQuery(prodCode, prodId);
        return new ResultDto<>(flag);
    }


    /**
     * @方法名称: productUserFocusInfoQuery
     * @方法描述: 用户关注
     * @param prodCode,prodId
     * @return
     */
    @PostMapping("/updateinfo")
    public ResultDto<String> updateProductUserFocusInfo(@RequestBody AcrmFpdProdUserFocusInfo acrmFpdProdUserFocusInfo) {
        String result = acrmFpdProdUserFocusService.updateProductUserFocusInfo(acrmFpdProdUserFocusInfo);
        return new ResultDto<>(result);
    }
}
