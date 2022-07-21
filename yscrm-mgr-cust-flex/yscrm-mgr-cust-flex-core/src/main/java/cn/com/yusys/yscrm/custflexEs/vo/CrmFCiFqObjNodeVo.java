package cn.com.yusys.yscrm.custflexEs.vo;

import java.util.List;

/**
 * 灵活查询指标对象
 *
 * @author hujun3
 * @date 2021/09/14 19:28
 **/
public class CrmFCiFqObjNodeVo extends CrmFCiFqObjVo {
    private List<CrmFCiFqObjNodeVo> children;

    public List<CrmFCiFqObjNodeVo> getChildren() {
        return children;
    }

    public void setChildren(List<CrmFCiFqObjNodeVo> children) {
        this.children = children;
    }
}
