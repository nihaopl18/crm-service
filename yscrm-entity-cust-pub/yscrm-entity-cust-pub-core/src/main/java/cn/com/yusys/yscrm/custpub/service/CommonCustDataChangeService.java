package cn.com.yusys.yscrm.custpub.service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import cn.com.yusys.yscrm.custpub.annotation.ColumnConfig;
import cn.com.yusys.yscrm.custpub.domain.OcrmFciCustUpdateHis;
import cn.com.yusys.yscrm.custpub.repository.mapper.OcrmFciCustUpdateHisMapper;
import cn.com.yusys.yusp.admin.service.AdminSmLookupItemService;
import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;

@Service
public class CommonCustDataChangeService extends CommonService {

	@Autowired
	private OcrmFciCustUpdateHisMapper mapper;

	@Autowired
	private AdminSmLookupItemService adminSmLookupItemService;

	@Autowired
	private UaaClient uaaClient;

	@Override
	protected CommonMapper getMapper() {
		return this.mapper;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void saveChangeData(Object current, Object original, String custId, String chgMod, String chgType,
			boolean keyMode) throws Exception {
		ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		Class cls = current.getClass();
		Field[] fields = cls.getDeclaredFields();
		if (keyMode) {// 关键字模式
			String chgBefKey = "";
			String chgBefValue = "";
			String chgAftKey = "";
			String chgAftValue = "";
			for (Field field : fields) {
				if (field.isAnnotationPresent(ColumnConfig.class)) {
					ColumnConfig columnConfig = field.getAnnotation(ColumnConfig.class);
					if (columnConfig.key()) {// 判断是否为关键字
						String varName = field.getName();
						boolean access = field.isAccessible();
						if (!access) {
							field.setAccessible(true);
						}
						Object cur_obj = field.get(current);
						Object ori_obj = field.get(original);
						String cur_str = cur_obj == null ? "" : cur_obj.toString();// 避免空指针异常
						String ori_str = ori_obj == null ? "" : ori_obj.toString();// 避免空指针异常
						Map m = adminSmLookupItemService.getLookupCodeList(columnConfig.lookup());
						String oldValue = "";
						String newValue = "";
						if (m != null && m.size() > 0) {
							List<Map<String, String>> lookupitemList = (ArrayList) m.get(columnConfig.lookup());
							for (Map item : lookupitemList) {
								if (cur_str.equals(item.get("key"))) {
									newValue = (String) item.get("value");
								}
								if (ori_str.equals(item.get("key"))) {
									oldValue = (String) item.get("value");
								}
							}
						}
						if (columnConfig.lookup() != null && !"".equals(columnConfig.lookup())) {
							if (!"".equals(oldValue) && oldValue != null) {
								chgBefValue = chgBefValue + oldValue + ",";
							}
							if (!"".equals(newValue) && newValue != null) {
								chgAftValue = chgAftValue + newValue + ",";
							}
						} else {
							if (!"".equals(ori_str) && ori_str != null) {
								chgBefValue = chgBefValue + ori_str + ",";
							}
							if (!"".equals(cur_str) && cur_str != null) {
								chgAftValue = chgAftValue + cur_str + ",";
							}
						}
//						if (!cur_str.equals(ori_str)) {
//						}
						if (!access) {
							field.setAccessible(false);
						}
					} else {
						continue;
					}

				}
			}
			if (!"".equals(chgBefValue) || !"".equals(chgAftValue)) {
				if(chgBefValue.lastIndexOf(",")!=-1) {
					chgBefValue = chgBefValue.substring(0, chgBefValue.lastIndexOf(","));
				}
				if(chgAftValue.lastIndexOf(",")!=-1) {
					chgAftValue = chgAftValue.substring(0, chgAftValue.lastIndexOf(","));
				}
				OcrmFciCustUpdateHis ocrmFciCustUpdateHis = new OcrmFciCustUpdateHis();
				ocrmFciCustUpdateHis.setCustId(custId);
				ocrmFciCustUpdateHis.setChgOrgId(dto.getBody().getOrg().getId());
				ocrmFciCustUpdateHis.setChgUsr(dto.getBody().getLoginCode());
				ocrmFciCustUpdateHis.setChgDt(new Date());
				ocrmFciCustUpdateHis.setChgMod(chgMod);
				ocrmFciCustUpdateHis.setChgType(chgType);
				ocrmFciCustUpdateHis.setChgEngName("");
				ocrmFciCustUpdateHis.setChgChiName("");
				ocrmFciCustUpdateHis.setChgBefKeyValue(chgBefKey);
				ocrmFciCustUpdateHis.setChgBefValueValue(chgBefValue);
				ocrmFciCustUpdateHis.setChgAftKeyValue(chgAftKey);
				ocrmFciCustUpdateHis.setChgAftValueValue(chgAftValue);
//				ocrmFciCustUpdateHis.setCorpOrgCode(dto.getBody().getInstu().getCode());
				this.mapper.insertSelective(ocrmFciCustUpdateHis);
			}
		} else {
			for (Field field : fields) {
				if (field.isAnnotationPresent(ColumnConfig.class)) {
					String varName = field.getName();
					boolean access = field.isAccessible();
					if (!access) {
						field.setAccessible(true);
					}
					Object cur_obj = field.get(current);
					Object ori_obj = field.get(original);
					String cur_str = cur_obj == null ? "" : cur_obj.toString();// 避免空指针异常
					String ori_str = ori_obj == null ? "" : ori_obj.toString();// 避免空指针异常
					ColumnConfig columnConfig = field.getAnnotation(ColumnConfig.class);
					if (!cur_str.equals(ori_str)) {
						Map m = adminSmLookupItemService.getLookupCodeList(columnConfig.lookup());
						String oldValue = "";
						String newValue = "";
						if (m != null && m.size() > 0) {
							List<Map<String, String>> lookupitemList = (ArrayList) m.get(columnConfig.lookup());
							for (Map item : lookupitemList) {
								if (cur_str.equals(item.get("key"))) {
									newValue = (String) item.get("value");
								}
								if (ori_str.equals(item.get("key"))) {
									oldValue = (String) item.get("value");
								}
							}
						}
						OcrmFciCustUpdateHis ocrmFciCustUpdateHis = new OcrmFciCustUpdateHis();
						ocrmFciCustUpdateHis.setCustId(custId);
						ocrmFciCustUpdateHis.setChgOrgId(dto.getBody().getOrg().getId());
						ocrmFciCustUpdateHis.setChgUsr(dto.getBody().getLoginCode());
						ocrmFciCustUpdateHis.setChgDt(new Date());
						ocrmFciCustUpdateHis.setChgMod(chgMod);
						ocrmFciCustUpdateHis.setChgType(chgType);
						ocrmFciCustUpdateHis.setChgEngName(varName);
						ocrmFciCustUpdateHis.setChgChiName(columnConfig.description());
						if (columnConfig.lookup() != null && !"".equals(columnConfig.lookup())) {
							ocrmFciCustUpdateHis.setChgBefKeyValue(ori_str);
							ocrmFciCustUpdateHis.setChgBefValueValue(oldValue);
							ocrmFciCustUpdateHis.setChgAftKeyValue(cur_str);
							ocrmFciCustUpdateHis.setChgAftValueValue(newValue);
						} else {
							ocrmFciCustUpdateHis.setChgBefKeyValue("");
							ocrmFciCustUpdateHis.setChgBefValueValue(ori_str);
							ocrmFciCustUpdateHis.setChgAftKeyValue("");
							ocrmFciCustUpdateHis.setChgAftValueValue(cur_str);
						}
//						ocrmFciCustUpdateHis.setCorpOrgCode(dto.getBody().getInstu().getCode());
						this.mapper.insertSelective(ocrmFciCustUpdateHis);
					}
					if (!access) {
						field.setAccessible(false);
					}
				}
			}
		}

	}
}
