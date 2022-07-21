package cn.com.yusys.yusp.uimp.business.pma.scheme.indexImp.vo;

import java.math.BigDecimal;

import cn.com.yusys.yusp.uimp.business.pma.scheme.indexImp.domain.PmaASchemeIndexRel;

/** 
 * @ClassName: PmaASchemeIndexRelVo 
 * @Description: 考核方案和指标关系VO
 * @author: chenhx
 * @date 2016年1月12日 上午9:52:11 
 * @version V3.3
 *  
 */ 
public class PmaASchemeIndexRelVo extends PmaASchemeIndexRel{

    /** serialVersionUID: **/
    private static final long serialVersionUID = 1L;

    /** schemeName:考核方案名称 **/
    private String schemeName;

    /** statDate:数据日期 **/
    private String statDate;

    /** aditionType:补录类型（指标补录、目标补录、基数补录） **/
    private String aditionType;

    /** evlObjId:考核对象ID **/
    private String evlObjId;

    /** evlObjName:考核对象名称 **/
    private String evlObjName;

    /** evlObjId:考核对象IDS **/
    private String evlObjIds;

    /** evlObjNames:考核对象名称 **/
    private String evlObjNames;

    /** indexId:指标名称 **/
    private String indexName;

    /** indexValue:指标值 **/
    private BigDecimal indexValue;

    /** indexArray:已选指标数组 **/
    private String[] indexIdArray;

    /** indexNameArray:已选指标数组 **/
    private String[] indexNameArray;

    /** indexDimAll:带维度ID的指标串(格式 ：B0001179[01.AA.00]) **/
    private String indexDimIdAll;

    /** indexDimNameAll:带维度名称的指标串（格式：指标名称A[月日均.折人民币.月目标]） **/
    private String indexDimNameAll;
    
    /** indexId:指标名称 **/
    private String postname;
    
    /** indexId:指标名称 **/
    private String unitname;

    
    /** indexId:指标名称 **/
    private String postnames;
    
    /** indexId:指标名称 **/
    private String unitnames;
    
    public String getPostnames() {
		return postnames;
	}

	public void setPostnames(String postnames) {
		this.postnames = postnames;
	}

	public String getUnitnames() {
		return unitnames;
	}

	public void setUnitnames(String unitnames) {
		this.unitnames = unitnames;
	}

	public String getPostname() {
		return postname;
	}

	public void setPostname(String postname) {
		this.postname = postname;
	}

	public String getUnitname() {
		return unitname;
	}

	public void setUnitname(String unitname) {
		this.unitname = unitname;
	}

	public String getSchemeName() {
        return schemeName;
    }

    public void setSchemeName(String schemeName) {
        this.schemeName = schemeName;
    }

    public String getStatDate() {
        return statDate;
    }

    public void setStatDate(String statDate) {
        this.statDate = statDate;
    }

    public String getAditionType() {
        return aditionType;
    }

    public void setAditionType(String aditionType) {
        this.aditionType = aditionType;
    }

    public String getEvlObjIds() {
        return evlObjIds;
    }

    public void setEvlObjIds(String evlObjIds) {
        this.evlObjIds = evlObjIds;
    }

    public String getEvlObjNames() {
        return evlObjNames;
    }

    public void setEvlObjNames(String evlObjNames) {
        this.evlObjNames = evlObjNames;
    }

    public BigDecimal getIndexValue() {
        return indexValue;
    }

    public void setIndexValue(BigDecimal indexValue) {
        this.indexValue = indexValue;
    }

    public String getIndexName() {
        return indexName;
    }

    public void setIndexName(String indexName) {
        this.indexName = indexName;
    }

    public String[] getIndexIdArray() {
        return indexIdArray;
    }

    public void setIndexIdArray(String[] indexIdArray) {
        this.indexIdArray = indexIdArray;
    }

    public String[] getIndexNameArray() {
        return indexNameArray;
    }

    public void setIndexNameArray(String[] indexNameArray) {
        this.indexNameArray = indexNameArray;
    }

    public String getEvlObjId() {
        return evlObjId;
    }

    public String getIndexDimIdAll() {
        return indexDimIdAll;
    }

    public void setIndexDimIdAll(String indexDimIdAll) {
        this.indexDimIdAll = indexDimIdAll;
    }

    public String getIndexDimNameAll() {
        return indexDimNameAll;
    }

    public void setIndexDimNameAll(String indexDimNameAll) {
        this.indexDimNameAll = indexDimNameAll;
    }

    public void setEvlObjId(String evlObjId) {
        this.evlObjId = evlObjId;
    }

    public String getEvlObjName() {
        return evlObjName;
    }

    public void setEvlObjName(String evlObjName) {
        this.evlObjName = evlObjName;
    }

}
