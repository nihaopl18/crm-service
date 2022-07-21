package cn.com.yusys.yusp.uimp.business.pma.scheme.evlIndex.enums;

/**
 * 余额类型
 * @author Administrator
 *
 */
public enum YETypeEnum {
	YE_TYPE_01("01", "余额处理后"),
	YE_TYPE_02("02", "月日均余额处理后"),
	YE_TYPE_03("03", "季日均余额处理后"),
	YE_TYPE_04("04", "年日均余额处理后"),
	YE_TYPE_05("05", "日利息支出处理后"),
	YE_TYPE_06("06", "日FTP收入处理后"),
	YE_TYPE_07("07", "日FTP利润处理后"),
	YE_TYPE_08("08", "月利息支出处理后"),
	YE_TYPE_09("09", "月FTP收入处理后"),
	YE_TYPE_10("10", "月FTP利润处理后"),
	YE_TYPE_11("11", "季利息支出处理后"),
	YE_TYPE_12("12", "季FTP收入处理后"),
	YE_TYPE_13("13", "季FTP利润处理后"),
	YE_TYPE_14("14", "年利息支出处理后"),
	YE_TYPE_15("15", "年FTP收入处理后"),
	YE_TYPE_16("16", "年FTP利润处理后"),
	YE_TYPE_17("17", "客户数处理后"),
	YE_TYPE_18("18", "账户数处理后"),
	YE_TYPE_19("19", "日利息收入处理后"),
	YE_TYPE_20("20", "月利息收入处理后"),
	YE_TYPE_21("21", "季利息收入处理后"),
	YE_TYPE_22("22", "年利息收入处理后");
	
	private String key;

	private String name;
	
	YETypeEnum(String key, String name) {
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

	public static YETypeEnum getByKey(String key) {
		for (YETypeEnum entity : YETypeEnum.values()) {
			if (entity.key.equals(key)) {
				return entity;
			}
		}
		return null;
	}

	public static YETypeEnum getByName(String name) {
		for (YETypeEnum entity : YETypeEnum.values()) {
			if (entity.name.equals(name)) {
				return entity;
			}
		}
		return null;
	}
public static void main(String[] args) {
	
	System.out.println(YETypeEnum.valueOf("YE_TYPE_01").getName());
}
}
