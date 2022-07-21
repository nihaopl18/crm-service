package cn.com.yusys.yscrm.custpub.domain;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;
import cn.com.yusys.yscrm.custpub.annotation.ColumnConfig;
import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * @项目名称: yscrm-entity-cust-pub-core模块
 * @类名称: AcrmFciAddrInfo
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-01-28 15:23:01
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "ACRM_F_CI_ADDR_INFO")
public class AcrmFciAddrInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	/** ID主键 **/
	@Id
	@Column(name = "ID", unique = false, nullable = true, length = 32)
	@Generated(GenerationType.UUID)
	private String id;
	
	/** 数据日期
 **/
	@Column(name = "DATA_DT", unique = false, nullable = true, length = 8)
	private Date dataDt;
	
	/** 创建日期
 **/
	
	@Column(name = "CRAT_DT", unique = false, nullable = true, length = 7)
	private Date cratDt;
	
	/** 创建机构编号
 **/
	@Column(name = "CRAT_ORG_ID", unique = false, nullable = true, length = 20)
	private String cratOrgId;
	
	/** 创建人
 **/
	@Column(name = "CRAT_USR", unique = false, nullable = true, length = 20)
	private String cratUsr;
	
	/** 最新更新系统
 **/
	@Column(name = "LAST_CHG_SYS", unique = false, nullable = true, length = 20)
	private String lastChgSys;
	
	/** 最新更新人
 **/
	@Column(name = "LAST_CHG_USR", unique = false, nullable = true, length = 20)
	private String lastChgUsr;
	
	/** 最新更新时间
 **/
	
	@Column(name = "LAST_CHG_DT", unique = false, nullable = true, length = 7)
	private Date lastChgDt;
	
	/** 法人
 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 20)
	private String corpOrgCode;
	
	/** 客户标识
 **/
	@Column(name = "CUST_ID", unique = false, nullable = true, length = 17)
	private String custId;
	
	/** 客户类型
 **/
	@Column(name = "CUST_TYPE", unique = false, nullable = true, length = 30)
	private String custType;
	
	/** 地址类型代码
 **/
	@Column(name = "ADDR_TYPE_CD", unique = false, nullable = true, length = 30)
	@ColumnConfig(description = "地址类型", lookup = "CD0012", key = true)
	private String addrTypeCd;
	
	/** 地址内容1
 **/
	@Column(name = "ADDR_COMM_ONE", unique = false, nullable = true, length = 200)
	@ColumnConfig(description = "详细地址", lookup = "", key = true)
	private String addrCommOne;
	
	/** 地址内容2
 **/
	@Column(name = "ADDR_COMM_TWO", unique = false, nullable = true, length = 200)
	private String addrCommTwo;
	
	/** 地址内容3
 **/
	@Column(name = "ADDR_COMM_THREE", unique = false, nullable = true, length = 200)
	private String addrCommThree;
	
	/** 邮政编码
 **/
	@Column(name = "POST_CD", unique = false, nullable = true, length = 20)
	private String postCd;
	
	/** 国家代码
 **/
	@Column(name = "NATION_CD", unique = false, nullable = true, length = 20)
	private String nationCd;
	
	/** 省份代码
 **/
	@Column(name = "PROV_CD", unique = false, nullable = true, length = 20)
	private String provCd;
	
	/** 城市名称
 **/
	@Column(name = "CITY_NAME", unique = false, nullable = true, length = 100)
	private String cityName;
	
	/** 县区
 **/
	@Column(name = "AREA_CD", unique = false, nullable = true, length = 100)
	private String areaCd;
	
	/** 乡镇
 **/
	@Column(name = "TOWN_NAME", unique = false, nullable = true, length = 100)
	private String townName;
	
	/** 社区/街道
 **/
	@Column(name = "STREET_NAME", unique = false, nullable = true, length = 100)
	private String streetName;
	
	/** 详细地址
 **/
	@Column(name = "FULL_ADDR", unique = false, nullable = true, length = 500)
	private String fullAddr;
	
	/** 主地址标志
 **/
	@Column(name = "MAIN_ADDR_FLG", unique = false, nullable = true, length = 30)
	private String mainAddrFlg;
	
	/** 主地址标志设置系统
 **/
	@Column(name = "FLG_SET_SYS", unique = false, nullable = true, length = 30)
	private String flgSetSys;
	
	
	/**
	 * @param id
	 */
	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}
	
    /**
     * @return Id
     */	
	public String getId() {
		return this.id;
	}
	

	
	public Date getDataDt() {
		return dataDt;
	}

	public void setDataDt(Date dataDt) {
		this.dataDt = dataDt;
	}

	/**
	 * @param cratDt
	 */
	public void setCratDt(Date cratDt) {
		this.cratDt = cratDt;
	}
	
    /**
     * @return CratDt
     */	
	public Date getCratDt() {
		return this.cratDt;
	}
	
	/**
	 * @param cratOrgId
	 */
	public void setCratOrgId(String cratOrgId) {
		this.cratOrgId = cratOrgId == null ? null : cratOrgId.trim();
	}
	
    /**
     * @return CratOrgId
     */	
	public String getCratOrgId() {
		return this.cratOrgId;
	}
	
	/**
	 * @param cratUsr
	 */
	public void setCratUsr(String cratUsr) {
		this.cratUsr = cratUsr == null ? null : cratUsr.trim();
	}
	
    /**
     * @return CratUsr
     */	
	public String getCratUsr() {
		return this.cratUsr;
	}
	
	/**
	 * @param lastChgSys
	 */
	public void setLastChgSys(String lastChgSys) {
		this.lastChgSys = lastChgSys == null ? null : lastChgSys.trim();
	}
	
    /**
     * @return LastChgSys
     */	
	public String getLastChgSys() {
		return this.lastChgSys;
	}
	
	/**
	 * @param lastChgUsr
	 */
	public void setLastChgUsr(String lastChgUsr) {
		this.lastChgUsr = lastChgUsr == null ? null : lastChgUsr.trim();
	}
	
    /**
     * @return LastChgUsr
     */	
	public String getLastChgUsr() {
		return this.lastChgUsr;
	}
	
	/**
	 * @param lastChgDt
	 */
	public void setLastChgDt(Date lastChgDt) {
		this.lastChgDt = lastChgDt;
	}
	
    /**
     * @return LastChgDt
     */	
	public Date getLastChgDt() {
		return this.lastChgDt;
	}
	
	/**
	 * @param corpOrgCode
	 */
	public void setCorpOrgCode(String corpOrgCode) {
		this.corpOrgCode = corpOrgCode == null ? null : corpOrgCode.trim();
	}
	
    /**
     * @return CorpOrgCode
     */	
	public String getCorpOrgCode() {
		return this.corpOrgCode;
	}
	
	/**
	 * @param custId
	 */
	public void setCustId(String custId) {
		this.custId = custId == null ? null : custId.trim();
	}
	
    /**
     * @return CustId
     */	
	public String getCustId() {
		return this.custId;
	}
	
	/**
	 * @param custType
	 */
	public void setCustType(String custType) {
		this.custType = custType == null ? null : custType.trim();
	}
	
    /**
     * @return CustType
     */	
	public String getCustType() {
		return this.custType;
	}
	
	/**
	 * @param addrTypeCd
	 */
	public void setAddrTypeCd(String addrTypeCd) {
		this.addrTypeCd = addrTypeCd == null ? null : addrTypeCd.trim();
	}
	
    /**
     * @return AddrTypeCd
     */	
	public String getAddrTypeCd() {
		return this.addrTypeCd;
	}
	
	
	
  
	
	
	/**
	 * @param postCd
	 */
	public void setPostCd(String postCd) {
		this.postCd = postCd == null ? null : postCd.trim();
	}
	
    /**
     * @return PostCd
     */	
	public String getPostCd() {
		return this.postCd;
	}
	
	/**
	 * @param nationCd
	 */
	public void setNationCd(String nationCd) {
		this.nationCd = nationCd == null ? null : nationCd.trim();
	}
	
    /**
     * @return NationCd
     */	
	public String getNationCd() {
		return this.nationCd;
	}
	
	/**
	 * @param provCd
	 */
	public void setProvCd(String provCd) {
		this.provCd = provCd == null ? null : provCd.trim();
	}
	
    /**
     * @return ProvCd
     */	
	public String getProvCd() {
		return this.provCd;
	}
	
	/**
	 * @param cityName
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName == null ? null : cityName.trim();
	}
	
    /**
     * @return CityName
     */	
	public String getCityName() {
		return this.cityName;
	}
	
	/**
	 * @param areaCd
	 */
	public void setAreaCd(String areaCd) {
		this.areaCd = areaCd == null ? null : areaCd.trim();
	}
	
    /**
     * @return AreaCd
     */	
	public String getAreaCd() {
		return this.areaCd;
	}
	
	/**
	 * @param townName
	 */
	public void setTownName(String townName) {
		this.townName = townName == null ? null : townName.trim();
	}
	
    /**
     * @return TownName
     */	
	public String getTownName() {
		return this.townName;
	}
	
	/**
	 * @param streetName
	 */
	public void setStreetName(String streetName) {
		this.streetName = streetName == null ? null : streetName.trim();
	}
	
    /**
     * @return StreetName
     */	
	public String getStreetName() {
		return this.streetName;
	}
	
	/**
	 * @param fullAddr
	 */
	public void setFullAddr(String fullAddr) {
		this.fullAddr = fullAddr == null ? null : fullAddr.trim();
	}
	
    /**
     * @return FullAddr
     */	
	public String getFullAddr() {
		return this.fullAddr;
	}
	
	/**
	 * @param mainAddrFlg
	 */
	public void setMainAddrFlg(String mainAddrFlg) {
		this.mainAddrFlg = mainAddrFlg == null ? null : mainAddrFlg.trim();
	}
	
    /**
     * @return MainAddrFlg
     */	
	public String getMainAddrFlg() {
		return this.mainAddrFlg;
	}
	
	/**
	 * @param flgSetSys
	 */
	public void setFlgSetSys(String flgSetSys) {
		this.flgSetSys = flgSetSys == null ? null : flgSetSys.trim();
	}
	
    /**
     * @return FlgSetSys
     */	
	public String getFlgSetSys() {
		return this.flgSetSys;
	}


    public String getAddrCommOne() {
		return addrCommOne;
	}

	public void setAddrCommOne(String addrCommOne) {
		this.addrCommOne = addrCommOne;
	}

	public String getAddrCommTwo() {
		return addrCommTwo;
	}

	public void setAddrCommTwo(String addrCommTwo) {
		this.addrCommTwo = addrCommTwo;
	}

	public String getAddrCommThree() {
		return addrCommThree;
	}

	public void setAddrCommThree(String addrCommThree) {
		this.addrCommThree = addrCommThree;
	}

	@Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        AcrmFciAddrInfo other = (AcrmFciAddrInfo) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        	&& (this.getDataDt()== null ? other.getDataDt() == null : this.getDataDt().equals(other.getDataDt()))
                	&& (this.getCratOrgId() == null ? other.getCratOrgId() == null : this.getCratOrgId().equals(other.getCratOrgId()))
        	&& (this.getCratUsr() == null ? other.getCratUsr() == null : this.getCratUsr().equals(other.getCratUsr()))
        	&& (this.getLastChgSys() == null ? other.getLastChgSys() == null : this.getLastChgSys().equals(other.getLastChgSys()))
        	&& (this.getLastChgUsr() == null ? other.getLastChgUsr() == null : this.getLastChgUsr().equals(other.getLastChgUsr()))
                	&& (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
        	&& (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
        	&& (this.getCustType() == null ? other.getCustType() == null : this.getCustType().equals(other.getCustType()))
        	&& (this.getAddrTypeCd() == null ? other.getAddrTypeCd() == null : this.getAddrTypeCd().equals(other.getAddrTypeCd()))
        	&& (this.getAddrCommOne() == null ? other.getAddrCommOne() == null : this.getAddrCommOne().equals(other.getAddrCommOne()))
        	&& (this.getAddrCommTwo() == null ? other.getAddrCommTwo() == null : this.getAddrCommTwo().equals(other.getAddrCommTwo()))
        	&& (this.getAddrCommThree() == null ? other.getAddrCommThree() == null : this.getAddrCommThree().equals(other.getAddrCommThree()))
        	&& (this.getPostCd() == null ? other.getPostCd() == null : this.getPostCd().equals(other.getPostCd()))
        	&& (this.getNationCd() == null ? other.getNationCd() == null : this.getNationCd().equals(other.getNationCd()))
        	&& (this.getProvCd() == null ? other.getProvCd() == null : this.getProvCd().equals(other.getProvCd()))
        	&& (this.getCityName() == null ? other.getCityName() == null : this.getCityName().equals(other.getCityName()))
        	&& (this.getAreaCd() == null ? other.getAreaCd() == null : this.getAreaCd().equals(other.getAreaCd()))
        	&& (this.getTownName() == null ? other.getTownName() == null : this.getTownName().equals(other.getTownName()))
        	&& (this.getStreetName() == null ? other.getStreetName() == null : this.getStreetName().equals(other.getStreetName()))
        	&& (this.getFullAddr() == null ? other.getFullAddr() == null : this.getFullAddr().equals(other.getFullAddr()))
        	&& (this.getMainAddrFlg() == null ? other.getMainAddrFlg() == null : this.getMainAddrFlg().equals(other.getMainAddrFlg()))
        	&& (this.getFlgSetSys() == null ? other.getFlgSetSys() == null : this.getFlgSetSys().equals(other.getFlgSetSys()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDataDt() == null) ? 0 : getDataDt().hashCode());
        result = prime * result + ((getCratOrgId() == null) ? 0 : getCratOrgId().hashCode());
        result = prime * result + ((getCratUsr() == null) ? 0 : getCratUsr().hashCode());
        result = prime * result + ((getLastChgSys() == null) ? 0 : getLastChgSys().hashCode());
        result = prime * result + ((getLastChgUsr() == null) ? 0 : getLastChgUsr().hashCode());
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getCustType() == null) ? 0 : getCustType().hashCode());
        result = prime * result + ((getAddrTypeCd() == null) ? 0 : getAddrTypeCd().hashCode());
        result = prime * result + ((getAddrCommOne() == null) ? 0 : getAddrCommOne().hashCode());
        result = prime * result + ((getAddrCommTwo() == null) ? 0 : getAddrCommTwo().hashCode());
        result = prime * result + ((getAddrCommThree() == null) ? 0 : getAddrCommThree().hashCode());
        result = prime * result + ((getPostCd() == null) ? 0 : getPostCd().hashCode());
        result = prime * result + ((getNationCd() == null) ? 0 : getNationCd().hashCode());
        result = prime * result + ((getProvCd() == null) ? 0 : getProvCd().hashCode());
        result = prime * result + ((getCityName() == null) ? 0 : getCityName().hashCode());
        result = prime * result + ((getAreaCd() == null) ? 0 : getAreaCd().hashCode());
        result = prime * result + ((getTownName() == null) ? 0 : getTownName().hashCode());
        result = prime * result + ((getStreetName() == null) ? 0 : getStreetName().hashCode());
        result = prime * result + ((getFullAddr() == null) ? 0 : getFullAddr().hashCode());
        result = prime * result + ((getMainAddrFlg() == null) ? 0 : getMainAddrFlg().hashCode());
        result = prime * result + ((getFlgSetSys() == null) ? 0 : getFlgSetSys().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", dataDt=").append(dataDt);
		sb.append(", cratDt=").append(cratDt);
		sb.append(", cratOrgId=").append(cratOrgId);
		sb.append(", cratUsr=").append(cratUsr);
		sb.append(", lastChgSys=").append(lastChgSys);
		sb.append(", lastChgUsr=").append(lastChgUsr);
		sb.append(", lastChgDt=").append(lastChgDt);
		sb.append(", corpOrgCode=").append(corpOrgCode);
		sb.append(", custId=").append(custId);
		sb.append(", custType=").append(custType);
		sb.append(", addrTypeCd=").append(addrTypeCd);
		sb.append(", addrCommOne=").append(addrCommOne);
		sb.append(", addrCommTwo=").append(addrCommTwo);
		sb.append(", addrCommThree=").append(addrCommThree);
		sb.append(", postCd=").append(postCd);
		sb.append(", nationCd=").append(nationCd);
		sb.append(", provCd=").append(provCd);
		sb.append(", cityName=").append(cityName);
		sb.append(", areaCd=").append(areaCd);
		sb.append(", townName=").append(townName);
		sb.append(", streetName=").append(streetName);
		sb.append(", fullAddr=").append(fullAddr);
		sb.append(", mainAddrFlg=").append(mainAddrFlg);
		sb.append(", flgSetSys=").append(flgSetSys);
        sb.append("]");
        return sb.toString();
    }
}