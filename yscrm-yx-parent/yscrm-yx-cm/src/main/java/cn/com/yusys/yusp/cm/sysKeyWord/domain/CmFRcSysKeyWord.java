package cn.com.yusys.yusp.cm.sysKeyWord.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "cm_f_rc_sys_key_word")
public class CmFRcSysKeyWord extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Generated(GenerationType.UUID)
	private String id;

	@Column(name="SOURCE_TAB_ENAME")
	private String sourceTabEname;

	@Column(name="SOURCE_TAB_CNAME")
	private String sourceTabCname;

	@Column(name="SOURCE_FIELD_ENAME")
	private String sourceFieldEname;

	@Column(name="SOURCE_FIELD_CNAME")
	private String sourceFieldCname;

	@Column(name="ADESCRIBE")
	private String adescribe;

	@Column(name="ALIAS_NAME")
	private String aliasName;
	
	@Column(name="KEYWORD_SOURCE")
	private String keywordSource;
	
	@Column(name="KEYWORD_CONNECT")
	private String keywordConnect;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSourceTabEname() {
		return sourceTabEname;
	}

	public void setSourceTabEname(String sourceTabEname) {
		this.sourceTabEname = sourceTabEname;
	}

	public String getSourceTabCname() {
		return sourceTabCname;
	}

	public void setSourceTabCname(String sourceTabCname) {
		this.sourceTabCname = sourceTabCname;
	}

	public String getSourceFieldEname() {
		return sourceFieldEname;
	}

	public void setSourceFieldEname(String sourceFieldEname) {
		this.sourceFieldEname = sourceFieldEname;
	}

	public String getSourceFieldCname() {
		return sourceFieldCname;
	}

	public void setSourceFieldCname(String sourceFieldCname) {
		this.sourceFieldCname = sourceFieldCname;
	}

	public String getAdescribe() {
		return adescribe;
	}

	public void setAdescribe(String adescribe) {
		this.adescribe = adescribe;
	}

	public String getAliasName() {
		return aliasName;
	}

	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}
	
	public String getKeywordSource() {
		return keywordSource;
	}

	public void setKeywordSource(String keywordSource) {
		this.keywordSource = keywordSource;
	}
	
	public String getKeywordConnect() {
		return keywordConnect;
	}

	public void setKeywordConnect(String keywordConnect) {
		this.keywordConnect = keywordConnect;
	}
	
}
