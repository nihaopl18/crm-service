package cn.com.yusys.yscrm.cust.person.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class SoapUtil {
	public Map<Object, String> map = new HashMap<Object, String>();

	public Map<Object, String> parse(String soap) throws DocumentException {
		Document document = DocumentHelper.parseText(soap);// 报文转成doc对象
		Element root = document.getRootElement();// 获取根元素，准备递归解析这个XML树
		getCode(root);
		return map;
	}

	public void getCode(Element root) {
		if (root.elements() != null) {
			List<Element> list = root.elements();// 如果当前根节点有子节点，找到子节点
			for (Element e: list) {//遍历每个节点
				if (e.elements().size() > 0) {//当前节点不为空的话，递归遍历子节点
					getCode(e);
				}
				if (e.elements().size() == 0) {//如果为叶子节点，那么直接把名字和值放入map
					map.put(e.getName(), e.getTextTrim());
				}
			}
		}
	}

	public static void main(String[] args) {
		SoapUtil parse = new SoapUtil();
		String soap = "";
		try {
			Map<Object, String> map = parse.parse(soap);
			System.out.println(map.get("AccNo").toString());
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
}
