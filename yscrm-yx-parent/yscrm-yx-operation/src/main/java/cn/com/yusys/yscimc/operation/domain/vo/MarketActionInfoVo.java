package cn.com.yusys.yscimc.operation.domain.vo;

import java.util.List;

/**
 * @Author Lenovo
 * @Data 2021/12/16 16:29
 */
public class MarketActionInfoVo implements ContentInfoVo, Cloneable{
    // 渠道 id
    private String id;

    // 模板名称
    private String modelName;

    // 模板内容
    private String modelInfo;

    // 渠道类型
    private String modelType;

    // 适用类型(产品、风险、关怀)
    private String applyType;

    // 类别编号
    private String catlCode;

    // 适用对象 id
    private String applyObject;

    // 适用渠道
    private String applyChannel;

    // 模板中的关键字集合
    private List<String> keywordList;

    private CustomerInfoVo customerInfoVo;

    private ProductInfoVo productInfoVo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getModelInfo() {
        return modelInfo;
    }

    public void setModelInfo(String modelInfo) {
        this.modelInfo = modelInfo;
    }

    public String getModelType() {
        return modelType;
    }

    public void setModelType(String modelType) {
        this.modelType = modelType;
    }

    public String getApplyType() {
        return applyType;
    }

    public void setApplyType(String applyType) {
        this.applyType = applyType;
    }

    public String getCatlCode() {
        return catlCode;
    }

    public void setCatlCode(String catlCode) {
        this.catlCode = catlCode;
    }

    public String getApplyObject() {
        return applyObject;
    }

    public void setApplyObject(String applyObject) {
        this.applyObject = applyObject;
    }

    public String getApplyChannel() {
        return applyChannel;
    }

    public void setApplyChannel(String applyChannel) {
        this.applyChannel = applyChannel;
    }

    public List<String> getKeywordList() {
        return keywordList;
    }

    public MarketActionInfoVo setKeywordList(List<String> keywordList) {
        this.keywordList = keywordList;
        return this;
    }

    public CustomerInfoVo getCustomerInfoVo() {
        return customerInfoVo;
    }

    public void setCustomerInfoVo(CustomerInfoVo customerInfoVo) {
        this.customerInfoVo = customerInfoVo;
    }

    public ProductInfoVo getProductInfoVo() {
        return productInfoVo;
    }

    public void setProductInfoVo(ProductInfoVo productInfoVo) {
        this.productInfoVo = productInfoVo;
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getName() {
        return modelName;
    }

    @Override
    public String toString() {
        return "MarketActionInfoVo{" +
                "id='" + id + '\'' +
                ", modelName='" + modelName + '\'' +
                ", modelInfo='" + modelInfo + '\'' +
                ", modelType='" + modelType + '\'' +
                ", applyType='" + applyType + '\'' +
                ", catlCode='" + catlCode + '\'' +
                ", applyObject='" + applyObject + '\'' +
                ", applyChannel='" + applyChannel + '\'' +
                ", keywordList=" + keywordList +
                ", customerInfoVo=" + customerInfoVo +
                ", productInfoVo=" + productInfoVo +
                '}';
    }
}
