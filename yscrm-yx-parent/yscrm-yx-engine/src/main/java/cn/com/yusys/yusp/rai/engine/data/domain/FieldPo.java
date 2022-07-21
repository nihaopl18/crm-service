package cn.com.yusys.yusp.rai.engine.data.domain;

import cn.com.yusys.yusp.rai.engine.data.enums.FieldTypeEnum;
import lombok.Data;


/**
 * 规则字段信息
 * @author zhangchi
 * @date 2021年12月06日 14:50:15
 * @version 1.0.0
 */
@Data
public class FieldPo implements Comparable<FieldPo> {

    /**
     * 字段编码
     */
    private String fieldCode;

    /**
     * 字段名称
     */
    private String fieldName;

    /**
     * 字段类型
     */
    private FieldTypeEnum fieldType;

    @Override
    public int compareTo(FieldPo o) {
        return fieldName.compareTo(o.getFieldName());
    }

    @Override
    public int hashCode(){
        return (fieldCode + fieldName).hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FieldPo field = (FieldPo) o;
        return fieldCode.equals(field.getFieldCode());
    }

}
