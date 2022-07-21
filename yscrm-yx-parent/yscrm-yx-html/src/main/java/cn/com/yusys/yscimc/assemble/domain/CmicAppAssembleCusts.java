package cn.com.yusys.yscimc.assemble.domain;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;
import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import java.io.Serializable;
import java.util.Date;


/**
 * @version 1.0.0
 * @项目名称: yscimc-app-mobile模块
 * @类名称: CmicAppAssembleCusts
 * @类描述: #数据实体类
 * @功能描述: 拼团活动实体
 * @创建人: chenl
 * @创建时间: 2019-06-10 20:24:36
 * @修改备注:
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "CMIC_APP_ASSEMBLE_CUSTS")
public class CmicAppAssembleCusts extends BaseDomain implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 编号
     **/
    @Id
    @Column(name = "ID")
    @Generated(GenerationType.UUID)
    private String id;

    /**
     * 活动号（节点id）
     **/
    @Column(name = "ACTY_ID", unique = false, nullable = true, length = 32)
    private String actyId;

    /**
     * 团ID
     **/
    @Column(name = "ASSEMBLE_ID", unique = false, nullable = true, length = 32)
    private String assembleId;

    /**
     * 推荐人ID
     **/
    @Column(name = "RECOMMENDER_ID", unique = false, nullable = true, length = 32)
    private String recommenderId;

    /**
     * 推荐人
     **/
    @Column(name = "RECOMMENDER", unique = false, nullable = true, length = 40)
    private String recommender;

    /**
     * 客户号
     **/
    @Column(name = "CUST_ID", unique = false, nullable = true, length = 32)
    private String custId;

    /**
     * 产品ID
     **/
    @Column(name = "PRO_ID", unique = false, nullable = true, length = 32)
    private String proId;

    /**
     * 规格ID
     **/
    @Column(name = "MODEL_ID", unique = false, nullable = true, length = 32)
    private String modelId;

    /**
     * 渠道
     **/
    @Column(name = "CHANNEL", unique = false, nullable = true, length = 20)
    private String channel;

    /**
     * 栏位
     **/
    @Column(name = "HURDLES", unique = false, nullable = true, length = 20)
    private String hurdles;

    /**
     * 购买数量
     **/
    @Column(name = "BUY_NUM", unique = false, nullable = true, length = 10)
    private long buyNum;

    /**
     * 拼团价格
     **/
    @Column(name = "ASSEMBLE_PIRCE", unique = false, nullable = true, length = 20)
    private String assemblePirce;

    /**
     * 拼团时间
     **/
    @Column(name = "ASSEMBLE_TIME", unique = false, nullable = true)
    private Date assembleTime;

    /**
     * 是否团长
     **/
    @Column(name = "IS_REG_COM", unique = false, nullable = true, length = 20)
    private String isRegCom;

    /**
     * 拼团类型（1-一号团，2-二号团，3-三号团）
     */
    @Column(name="ASSEMBLE_TYPE",unique = false, nullable = true, length = 10)
    private String assembleType;

    /***加入团或者新开团标识**/
    @Transient
    private String newOrIn;

    /***成团人数**/
    @Transient
    private String assembleNum;

    /***产品类型**/
    @Transient
    private String prodType;


    public String getProdType() {
        return prodType;
    }

    public void setProdType(String prodType) {
        this.prodType = prodType;
    }

    public String getNewOrIn() {
        return newOrIn;
    }

    public void setNewOrIn(String newOrIn) {
        this.newOrIn = newOrIn;
    }

    public String getAssembleNum() {
        return assembleNum;
    }

    public void setAssembleNum(String assembleNum) {
        this.assembleNum = assembleNum;
    }

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

    /**
     * @param actyId
     */
    public void setActyId(String actyId) {
        this.actyId = actyId == null ? null : actyId.trim();
    }

    /**
     * @return ActyId
     */
    public String getActyId() {
        return this.actyId;
    }

    /**
     * @param assembleId
     */
    public void setAssembleId(String assembleId) {
        this.assembleId = assembleId == null ? null : assembleId.trim();
    }

    /**
     * @return AssembleId
     */
    public String getAssembleId() {
        return this.assembleId;
    }

    /**
     * @param recommenderId
     */
    public void setRecommenderId(String recommenderId) {
        this.recommenderId = recommenderId == null ? null : recommenderId.trim();
    }

    /**
     * @return RecommenderId
     */
    public String getRecommenderId() {
        return this.recommenderId;
    }

    /**
     * @param recommender
     */
    public void setRecommender(String recommender) {
        this.recommender = recommender == null ? null : recommender.trim();
    }

    /**
     * @return Recommender
     */
    public String getRecommender() {
        return this.recommender;
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
     * @param proId
     */
    public void setProId(String proId) {
        this.proId = proId == null ? null : proId.trim();
    }

    /**
     * @return ProId
     */
    public String getProId() {
        return this.proId;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    /**
     * @param channel
     */
    public void setChannel(String channel) {
        this.channel = channel == null ? null : channel.trim();
    }

    /**
     * @return Channel
     */
    public String getChannel() {
        return this.channel;
    }

    /**
     * @param hurdles
     */
    public void setHurdles(String hurdles) {
        this.hurdles = hurdles == null ? null : hurdles.trim();
    }

    /**
     * @return Hurdles
     */
    public String getHurdles() {
        return this.hurdles;
    }

    /**
     * @param buyNum
     */
    public void setBuyNum(long buyNum) {
        this.buyNum = buyNum;
    }

    /**
     * @return BuyNum
     */
    public long getBuyNum() {
        return this.buyNum;
    }

    /**
     * @param assemblePirce
     */
    public void setAssemblePirce(String assemblePirce) {
        this.assemblePirce = assemblePirce == null ? null : assemblePirce.trim();
    }

    /**
     * @return AssemblePirce
     */
    public String getAssemblePirce() {
        return this.assemblePirce;
    }


    public Date getAssembleTime() {
        return assembleTime;
    }

    public void setAssembleTime(Date assembleTime) {
        this.assembleTime = assembleTime;
    }

    public String getIsRegCom() {
        return isRegCom;
    }

    public void setIsRegCom(String isRegCom) {
        this.isRegCom = isRegCom;
    }

    public String getAssembleType() {
        return assembleType;
    }

    public void setAssembleType(String assembleType) {
        this.assembleType = assembleType;
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
        CmicAppAssembleCusts other = (CmicAppAssembleCusts) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getActyId() == null ? other.getActyId() == null : this.getActyId().equals(other.getActyId()))
                && (this.getAssembleId() == null ? other.getAssembleId() == null : this.getAssembleId().equals(other.getAssembleId()))
                && (this.getRecommenderId() == null ? other.getRecommenderId() == null : this.getRecommenderId().equals(other.getRecommenderId()))
                && (this.getRecommender() == null ? other.getRecommender() == null : this.getRecommender().equals(other.getRecommender()))
                && (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
                && (this.getProId() == null ? other.getProId() == null : this.getProId().equals(other.getProId()))
                && (this.getChannel() == null ? other.getChannel() == null : this.getChannel().equals(other.getChannel()))
                && (this.getHurdles() == null ? other.getHurdles() == null : this.getHurdles().equals(other.getHurdles()))
                && (this.getAssemblePirce() == null ? other.getAssemblePirce() == null : this.getAssemblePirce().equals(other.getAssemblePirce()))
                && (this.getIsRegCom() == null ? other.getIsRegCom() == null : this.getIsRegCom().equals(other.getIsRegCom()))
                && (this.getAssembleType() == null ? other.getAssembleType() == null : this.getAssembleType().equals(other.getAssembleType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getActyId() == null) ? 0 : getActyId().hashCode());
        result = prime * result + ((getAssembleId() == null) ? 0 : getAssembleId().hashCode());
        result = prime * result + ((getRecommenderId() == null) ? 0 : getRecommenderId().hashCode());
        result = prime * result + ((getRecommender() == null) ? 0 : getRecommender().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getProId() == null) ? 0 : getProId().hashCode());
        result = prime * result + ((getChannel() == null) ? 0 : getChannel().hashCode());
        result = prime * result + ((getHurdles() == null) ? 0 : getHurdles().hashCode());
        result = prime * result + ((getAssemblePirce() == null) ? 0 : getAssemblePirce().hashCode());
        result = prime * result + ((getIsRegCom() == null) ? 0 : getIsRegCom().hashCode());
        result = prime * result + ((getAssembleType() == null) ? 0 : getAssembleType().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", actyId=").append(actyId);
        sb.append(", assembleId=").append(assembleId);
        sb.append(", recommenderId=").append(recommenderId);
        sb.append(", recommender=").append(recommender);
        sb.append(", custId=").append(custId);
        sb.append(", proId=").append(proId);
        sb.append(", channel=").append(channel);
        sb.append(", hurdles=").append(hurdles);
        sb.append(", buyNum=").append(buyNum);
        sb.append(", assemblePirce=").append(assemblePirce);
        sb.append(", isRegCom=").append(isRegCom);
        sb.append(", assembleType=").append(assembleType);
        sb.append("]");
        return sb.toString();
    }
}