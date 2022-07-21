package cn.com.yusys.yscimc.operation.domain.dto;

import cn.com.yusys.yscimc.operation.domain.vo.ProductInfoVo;

import java.util.ArrayList;
import java.util.List;

/**
 * 产品组件解析器返回的数据类型
 * @author zhangyt12
 * @date 2021/12/13 20:36
 */
public class ProductInfoDto {

    private List<ProductInfoVo> productInfoVoList;

    public List<ProductInfoVo> getProductInfoVoList() {
        return productInfoVoList;
    }

    public ProductInfoDto setProductInfoVoList(List<ProductInfoVo> voList) {
        if (productInfoVoList == null) {
            this.productInfoVoList = voList;
        } else {
            productInfoVoList.addAll(voList);
        }
        return this;
    }

    public ProductInfoDto setProductInfoVoList(ProductInfoVo vo) {
        if (productInfoVoList == null) {
            List<ProductInfoVo> list = new ArrayList<>();
            list.add(vo);
            this.setProductInfoVoList(list);
        } else {
            productInfoVoList.add(vo);
        }
        return this;
    }
}
