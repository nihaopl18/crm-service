package cn.com.yusys.yusp.uimp.business.pma.app.service;

import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.base.service.UserInfoService;
import cn.com.yusys.yusp.uimp.business.pma.app.model.APPVersion;
import cn.com.yusys.yusp.uimp.business.pma.app.repository.mapper.OcrmFappDeviceMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdminSmUserMobileService {

	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private OcrmFappDeviceMapper ocrmFappDeviceInfoMapper;

//	app 版本只有一个，先删除在插入（用versionBelong区分安卓与IOS 0-安卓   1-IOS）
	public ResultDto<Object> addAppVersion(APPVersion appVersion) {
		ResultDto<Object> resultDto = new ResultDto<Object>();
		try {
			ocrmFappDeviceInfoMapper.deleteAppVersion(appVersion);
			String uuid = ocrmFappDeviceInfoMapper.getUuidNext();
			appVersion.setId(uuid);
			appVersion.setUpdateDate(new Date());
			appVersion.setUpdateUser(userInfoService.getUserInfo().getUserId());
			appVersion.setUpdateOrg(userInfoService.getOrgCode());
			appVersion.setIsDel("A");
			appVersion.setisMast("1");
			ocrmFappDeviceInfoMapper.addAppVersion(appVersion);
			resultDto.setCode(0);
			resultDto.setMessage("新增成功");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
//			throw new YuspException(messageProviderService.getMessage("300000"));
		}
		return resultDto;
	}
	public void recordDownload(String fileName) {
		String downloadBelong = null;
		if (fileName.equals("NM_MYT_ANDROID.apk")) {
			downloadBelong = "0";
		}
		if (fileName.equals("NM_MYT_IOS.ipa")) {
			downloadBelong = "1";
		}
		String downloadVersion = ocrmFappDeviceInfoMapper.queryVersion(downloadBelong);
		ocrmFappDeviceInfoMapper.addRecordDownload(downloadBelong,downloadVersion);
	}
	public Map<String, Object> checkVersion(String versionBelong) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = ocrmFappDeviceInfoMapper.checkVersion(versionBelong);
		return map;
	}
	public Map<String, Object> checkAppVersion(String appVer,String versionBelong ) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> mapNew = new HashMap<String, Object>();
		map = ocrmFappDeviceInfoMapper.checkVersion(versionBelong);
		if(map.size()!=0) {
			String newVersion = String.valueOf(map.get("versionId"));
			if( compareVersion(newVersion,appVer)!=1) {//如果最新版本不高于当前手机安装版本则不更新
				mapNew.put("upgradeFlag", "0");
			}else {
				mapNew.put("md5", null);
				mapNew.put("appId", "10000004");
				mapNew.put("fileUrl", map.get("downloadUrl"));
				mapNew.put("appstoreUrl", map.get("downloadUrl"));
				mapNew.put("pubId", "10000");
				mapNew.put("versionId", map.get("versionId"));
				mapNew.put("upgradeFlag", map.get("isMast"));
				mapNew.put("pubDescribe", map.get("content"));
			}
		}
		return mapNew;
	}

	public ResultDto<Object> updateAppVersion(APPVersion appVersion) {
		ResultDto<Object> resultDto = new ResultDto<Object>();
		try {
			ocrmFappDeviceInfoMapper.updateAppVersion(appVersion);
			resultDto.setCode(0);
			resultDto.setMessage("新增成功");
		} catch (Exception e) {
			e.printStackTrace();
//			throw new YuspException(messageProviderService.getMessage("300000"));
		}
		return resultDto;
	}

	public List<Map<String, Object>> queryAppVersion(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String, Object>> list = this.ocrmFappDeviceInfoMapper.queryAppVersion(model);
		PageHelper.clearPage();
		return list;
	}
	
	
	public  int compareVersion(String v1, String v2) {
        if (v1.equals(v2)) {
            return 0;
        }
        String[] version1Array = v1.split("[._-]");
        String[] version2Array = v2.split("[._-]");
        int index = 0;
        int minLen = Math.min(version1Array.length, version2Array.length);
        long diff = 0;
        
        while (index < minLen
                && (diff = Long.parseLong(version1Array[index])
                - Long.parseLong(version2Array[index])) == 0) {
            index++;
        }
        if (diff == 0) {
            for (int i = index; i < version1Array.length; i++) {
                if (Long.parseLong(version1Array[i]) > 0) {
                    return 1;
                }
            }
            
            for (int i = index; i < version2Array.length; i++) {
                if (Long.parseLong(version2Array[i]) > 0) {
                    return -1;
                }
            }
            return 0;
        } else {
            return diff > 0 ? 1 : -1;
        }
    }
}
