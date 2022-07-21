package cn.com.yusys.yusp.cm.market.domain;

import java.util.ArrayList;
import java.util.List;


 
public class FrTransInfoAllModel extends FrTransInfoModel implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	List<FrTransMapModel> transMapList = new ArrayList<FrTransMapModel>();

	public List<FrTransMapModel> getTransMapList() {
		return transMapList;
	}

	public void setTransMapList(List<FrTransMapModel> transMapList) {
		this.transMapList = transMapList;
	}

	 
	
	

}
