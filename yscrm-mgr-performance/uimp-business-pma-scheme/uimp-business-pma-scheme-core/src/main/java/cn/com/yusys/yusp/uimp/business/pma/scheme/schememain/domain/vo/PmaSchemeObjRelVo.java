package cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.domain.vo;

import java.util.List;

/**
 * @description:
 * @author: Zhan YongQiang
 * @date: 2022/5/20 10:27
 */
public class PmaSchemeObjRelVo {


    private String schemeId;

    private String evlObjType;

    private List<PmaSchemeObjParamVo> objList;


    public String getSchemeId() {
        return schemeId;
    }

    public void setSchemeId(String schemeId) {
        this.schemeId = schemeId;
    }

    public String getEvlObjType() {
        return evlObjType;
    }

    public void setEvlObjType(String evlObjType) {
        this.evlObjType = evlObjType;
    }

    public List<PmaSchemeObjParamVo> getObjList() {
        return objList;
    }

    public void setObjList(List<PmaSchemeObjParamVo> objList) {
        this.objList = objList;
    }
}
