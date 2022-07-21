package cn.com.yusys.yusp.uimp.business.pma.scheme.evlIndex.enums;

/**
 * 考核对象类型
 * @author zhengxinglong
 *
 */
public enum ObjTypeEnum {
	OBJ_TYPE_01("01", "员工"),
	OBJ_TYPE_02("02", "机构(人)"),
	OBJ_TYPE_03("03", "机构(业务,账面)"),
	OBJ_TYPE_04("04", "团队");
	
	private String key;

	private String name;
	
	ObjTypeEnum(String key, String name) {
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

	public static ObjTypeEnum getByKey(String key) {
		for (ObjTypeEnum entity : ObjTypeEnum.values()) {
			if (entity.key.equals(key)) {
				return entity;
			}
		}
		return null;
	}

	public static ObjTypeEnum getByName(String name) {
		for (ObjTypeEnum entity : ObjTypeEnum.values()) {
			if (entity.name.equals(name)) {
				return entity;
			}
		}
		return null;
	}
public static void main(String[] args) {
	
	System.out.println(ObjTypeEnum.valueOf("OBJ_TYPE_01").getName());
}
}
