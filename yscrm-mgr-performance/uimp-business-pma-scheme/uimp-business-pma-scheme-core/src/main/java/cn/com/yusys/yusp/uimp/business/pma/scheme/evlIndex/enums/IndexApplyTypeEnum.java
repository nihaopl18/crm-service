package cn.com.yusys.yusp.uimp.business.pma.scheme.evlIndex.enums;

/**
 * 应用类型
 * @author Administrator
 *
 */
public enum IndexApplyTypeEnum {
	INDEX_APPLY_TYPE_00("00", "指标"),
	INDEX_APPLY_TYPE_01("01", "任务"),
	INDEX_APPLY_TYPE_02("02", "比上月"),
	INDEX_APPLY_TYPE_03("03", "比上季"),
	INDEX_APPLY_TYPE_04("04", "比上年"),
	INDEX_APPLY_TYPE_05("05", "手工录入基数"),
	INDEX_APPLY_TYPE_06("06", "上月指标回溯"),
	INDEX_APPLY_TYPE_07("07", "上季指标回溯"),
	INDEX_APPLY_TYPE_08("08", "上年指标回溯"),
	INDEX_APPLY_TYPE_09("09", "全行指标下刷");
	
	
	private String key;

	private String name;
	
	IndexApplyTypeEnum(String key, String name) {
		this.key = key;
		this.name = name;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static IndexApplyTypeEnum getByKey(String key) {
		for (IndexApplyTypeEnum entity : IndexApplyTypeEnum.values()) {
			if (entity.key.equals(key)) {
				return entity;
			}
		}
		return null;
	}

	public static IndexApplyTypeEnum getByName(String name) {
		for (IndexApplyTypeEnum entity : IndexApplyTypeEnum.values()) {
			if (entity.name.equals(name)) {
				return entity;
			}
		}
		return null;
	}
public static void main(String[] args) {
	
	System.out.println(IndexApplyTypeEnum.valueOf("INDEX_APPLY_TYPE_01").getName());
}
}
