package cn.com.yusys.yscimc.operation.domain.bo;

import cn.com.yusys.yscimc.operation.domain.vo.CustomerInfoVo;
import cn.com.yusys.yscimc.operation.domain.vo.MarketActionInfoVo;
import cn.com.yusys.yscimc.operation.domain.vo.ProductInfoVo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author Lenovo
 * @Data 2021/12/16 19:41
 */
public class ProcessedDataBo {

    private Set<CustomerInfoVo> customerInfoVoSet;

    private List<ProductInfoVo> productInfoVoList;

    private List<MarketActionInfoVo> marketActionInfoVoList;

    /**
     * 营销动作、素材、分享、报名、分裂 相关信息
     */
    private ComponentDataBo componentDataBo;

    public Set<CustomerInfoVo> getCustomerInfoVoSet() {
        return customerInfoVoSet;
    }

    public ProcessedDataBo setCustomerInfoVoSet(Set<CustomerInfoVo> voSet) {
        if (customerInfoVoSet == null) {
            customerInfoVoSet = voSet;
        } else {
            customerInfoVoSet.addAll(voSet);
        }
        return this;
    }

    public ProcessedDataBo setCustomerInfoVoSet(CustomerInfoVo vo) {
        if (customerInfoVoSet == null) {
            customerInfoVoSet = new HashSet<>();
        }
        customerInfoVoSet.add(vo);
        return this;
    }
    public ProcessedDataBo setCustomerInfoVoRemoveBlackList(Set<CustomerInfoVo> voSet){
        this.customerInfoVoSet=voSet;
        return this;
    }

    public List<ProductInfoVo> getProductInfoVoList() {
        return productInfoVoList;
    }

    public ProcessedDataBo setProductInfoVoList(List<ProductInfoVo> productInfoVoList) {
        this.productInfoVoList = productInfoVoList;
        return this;
    }

    public List<MarketActionInfoVo> getMarketActionInfoVoList() {
        return marketActionInfoVoList;
    }

    public void setMarketActionInfoVoList(List<MarketActionInfoVo> marketActionInfoVoList) {
        this.marketActionInfoVoList = marketActionInfoVoList;
    }

    public ComponentDataBo getComponentDataBo() {
        return componentDataBo;
    }

    public void setComponentDataBo(ComponentDataBo componentDataBo) {
        this.componentDataBo = componentDataBo;
    }

    @Override
    public String toString() {
        return "ProcessedDataBo{" +
                "customerInfoVoSet=" + customerInfoVoSet +
                ", productInfoVoList=" + productInfoVoList +
                ", marketActionInfoVoList=" + marketActionInfoVoList +
                ", componentDataBo=" + componentDataBo +
                '}';
    }
}
