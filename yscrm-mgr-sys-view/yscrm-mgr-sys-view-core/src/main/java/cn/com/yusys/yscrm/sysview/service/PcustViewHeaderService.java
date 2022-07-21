package cn.com.yusys.yscrm.sysview.service;

import cn.com.yusys.yscrm.sysview.domain.*;
import cn.com.yusys.yscrm.sysview.repository.mapper.PcustBaseInfoMapper;
import cn.com.yusys.yscrm.sysview.repository.mapper.PcustViewHeaderMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @author: sxm
 * @time: 2021/8/11 17:32
 */
@Service
public class PcustViewHeaderService {
    private final Logger logger = LoggerFactory.getLogger(PcustViewHeaderService.class);

    public static final String ZERO = "0";

    public static final String FORMATTER = "yyyy-MM";
    public final static String MGR_ROLE_1 = "R014,R015,R016";
    @Autowired
    private PcustViewHeaderMapper pCustViewHeaderMapper;


    @Transactional(readOnly = true)
    public Map<String, Object> getView(QueryModel model) {
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(2);
        Map<String, Object> map = new HashMap<>();

        //事件信息
        map.put("eventInfo", pCustViewHeaderMapper.getEventInfo(model));
        //个人信息
        PerInfo perInfo = pCustViewHeaderMapper.getPerInfo(model);
        if (perInfo != null && perInfo.getValueScore() != null && perInfo.getLastValueScore() != null) {
            perInfo.setValueScore1(getPercent(perInfo.getValueScore(), perInfo.getLastValueScore()));
        }
        map.put("perInfo", perInfo);

        //AUM信息
        Map<String, Object> aumInfomap = new HashMap<>();
        AumInfo aumInfo = pCustViewHeaderMapper.getAumDpsInfo(model);
        if (aumInfo != null) {
            aumInfomap.put("aumInfos", getAumInfos(aumInfo));
            aumInfomap.put("max", new AumInfoMonth(aumInfo.getMaxAum(), aumInfo.getMaxAumDate()));
            aumInfomap.put("current", new AumInfoMonth(aumInfo.getCurrentAum(), aumInfo.getDataDate()));
            aumInfomap.put("history", new AumInfoMonth(aumInfo.getMaxAumHis(), aumInfo.getMaxAumDateHis()));
        }
        map.put("aumInfo", aumInfomap);
        map.put("contactWay", pCustViewHeaderMapper.getContactWay(model));

        //资产信息
        PropertyInfo propertyInfo = pCustViewHeaderMapper.getPropertyInfo(model);
        map.put("propertyInfo", propertyInfo);
        map.put("perLabelInfo", pCustViewHeaderMapper.getPerLabelInfo(model));
        return map;
    }


    private String getPercent(String current, String last) {
        if (last.equals(ZERO)) {
            return null;
        }
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(2);
        return numberFormat.format((Float.valueOf(current) - Float.valueOf(last)) / Float.valueOf(last) * 100) + "%";

    }

    @Transactional(readOnly = true)
    public List<PerLabelInfo> queryLabel(QueryModel model) {
        return pCustViewHeaderMapper.getCustomLabel(model);
    }

    /**
     * 设置AUM折线图数据
     *
     * @param a
     * @return
     */
    private List<AumInfoMonth> getAumInfos(AumInfo a) {
        List<AumInfoMonth> list = new ArrayList<>();
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(FORMATTER);
        SimpleDateFormat s = new SimpleDateFormat(FORMATTER);
        Date date = new Date();
        if (StringUtils.isEmpty(a.getDataDate())) {
            a.setDataDate(s.format(new Date()));
        }
        try {
            date = s.parse(a.getDataDate());
        } catch (ParseException e1) {
            // TODO 自动生成的 catch 块
            e1.printStackTrace();
        }
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        Class c = AumInfo.class;
//        list.add(new AumInfoMonth(a.getAgo0M(),dateTimeFormatter.format(LocalDateTime.now())));
        for (int i = 1; i < 13; i++) {
            AumInfoMonth am = new AumInfoMonth();
            try {
                am.setBalance((String) c.getMethod("getAgo" + i + "M").invoke(a));
            } catch (ReflectiveOperationException e) {
                logger.error("设置AUM折线图数据失败");
                am.setBalance("");
            }
            am.setMonth(s.format(ca.getTime()));
            list.add(am);
            ca.add(Calendar.MONTH, -1);
        }
        return list;
    }
    public  String getrole() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        String selectRole = request.getHeader("selectRole");
        return selectRole;
    }

    public Boolean ispcustview(QueryModel queryModel) {
        Boolean inner=false;
        if(MGR_ROLE_1.contains(getrole())){
            inner=true;
        }else if (queryModel.getCondition().get("mgrId") == null || queryModel.getCondition().get("mgrId") == "" || queryModel.getCondition().get("custId") == null || queryModel.getCondition().get("custId") == "") {
            inner=false;
        } else {
            Date newDate = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String dataDate = sdf.format(newDate);
            queryModel.getCondition().put("dataDate", dataDate);
            int count = pCustViewHeaderMapper.ispcustview(queryModel);
            String staffFlg = pCustViewHeaderMapper.selectinner(queryModel);
          if (count > 0 && !"Y".equals(staffFlg)) {
              inner=true;
            }else{
              inner=false;
            }

        }
        return inner;
    }
}