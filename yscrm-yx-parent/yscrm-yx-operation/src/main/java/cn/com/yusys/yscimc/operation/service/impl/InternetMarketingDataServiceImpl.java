package cn.com.yusys.yscimc.operation.service.impl;

import cn.com.yusys.yscimc.assemble.service.CmicAppAssembleSignUpService;
import cn.com.yusys.yscimc.assemble.vo.CmicAppAssembleSignUpVo;
import cn.com.yusys.yscimc.operation.repository.mapper.ActivityFieldInfoMapper;
import cn.com.yusys.yscimc.operation.service.InternetMarketingDataService;
import cn.com.yusys.yusp.cm.market.service.YscimcFmkActiFissionService;
import cn.com.yusys.yusp.cm.market.service.YscimcFmkActiShareService;
import cn.com.yusys.yusp.cm.market.vo.YscimcFMkActiFissionVo;
import cn.com.yusys.yusp.cm.market.vo.YscimcFMkActiShareVo;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author houyx3
 * @email houyx3@yusys.com.cn
 * @date 2022/1/17 15:50
 */
@Service("internetMarketingDataService")
public class InternetMarketingDataServiceImpl implements InternetMarketingDataService {


    private String activityImgUrl = "/api/file/provider/download?fileId=";

    @Value("${yscimc.operation.activityUrl}")
    private String activityUrl;
    @Value("${yscimc.operation.extranetUrl}")
    private String extranetUrl;

    @Autowired
    private ConfigurableEnvironment environment;

    @Autowired
    private ActivityFieldInfoMapper fieldInfoMapper;

    @Autowired
    private CmicAppAssembleSignUpService signUpService;

    @Autowired
    private YscimcFmkActiFissionService fissionService;

    @Autowired
    private YscimcFmkActiShareService shareService;


    @Override
    public List<Map<String, Object>> getMobileBankingWindows(String data) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date nowDate = new Date();
//        Map<String, Object> systemProperties = environment.getSystemProperties();
//        Iterator<Map.Entry<String, Object>> iterator = systemProperties.entrySet().iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }
        try {
            InetAddress localHost = Inet4Address.getLocalHost();
            System.out.println(localHost);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        String property = environment.getProperty("local.server.port");
        System.out.println(property);
        String date = sdf.format(nowDate);
        List<Map<String, Object>> mobileBankingWindows = fieldInfoMapper.getMobileBankingWindows(date);
        mobileBankingWindows.forEach(vo -> {
            vo.put("actHtml", activityUrl + vo.get("actHtml"));
            vo.put("imageAddr", extranetUrl + activityImgUrl + "/" + vo.get("imageAddr"));

        });
        return mobileBankingWindows;

    }

    @Override
    public Object getSignUpData(String data) {
        JSONObject jsonObject = JSONObject.parseObject(data);
        String id = jsonObject.get("id").toString();
        CmicAppAssembleSignUpVo vo = signUpService.getInfoById(id);
        vo.setImageurl(extranetUrl + activityImgUrl + "/" + vo.getImageurl());
        vo.getList().forEach(listVo -> {
            listVo.setImgUrl(extranetUrl + activityImgUrl + "/" + listVo.getImgUrl());
        });
        return vo;
    }

    @Override
    public Object getFissionData(String data) {
        JSONObject jsonObject = JSONObject.parseObject(data);
        String id = jsonObject.get("id").toString();
        YscimcFMkActiFissionVo vo = fissionService.getInfoByAssemble(id);
        vo.setImageurl(extranetUrl + activityImgUrl + "/" + vo.getImageurl());
        vo.getImages().forEach(listVo -> {
            listVo.setImgUrl(extranetUrl + activityImgUrl + "/" + listVo.getImgUrl());
        });
        return vo;
    }

    @Override
    public Object getShareData(String data) {
        JSONObject jsonObject = JSONObject.parseObject(data);
        String id = jsonObject.get("id").toString();
        YscimcFMkActiShareVo vo = shareService.getInfoByAssemble(id);
        if (null == vo){
            return null;
        }
        vo.setImageurl(extranetUrl + activityImgUrl + "/" + vo.getImageurl());
        vo.getImages().forEach(listVo -> {
            listVo.setImgUrl(extranetUrl + activityImgUrl + "/" + listVo.getImgUrl());
        });
        return vo;
    }

    private String getHostAddr() {
        try {
            InetAddress localHost = Inet4Address.getLocalHost();
            return localHost.getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getPort() {
        return environment.getProperty("local.server.port");
    }

    private String getServicePath() {
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        String scheme = request.getScheme();
        return scheme + "://" + getHostAddr() + ":" + getPort()  + environment.getProperty("server.servlet.context-path");
    }

}
