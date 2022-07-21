package cn.com.yusys.yscrm.sysview.service;

import cn.com.yusys.yscrm.sysview.domain.*;
import cn.com.yusys.yscrm.sysview.repository.mapper.TouchInfoWorkReportMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: sxm
 * @time: 2021/8/14 18:41
 */
@Service
public class TouchInfoWorkReportService {
    public static final String OFFLINE = "2";
    public static final String CALL = "1";
    public static final String MESSAGE = "3";
    public static final String FEEDBACK = "4";
    public static final String FORMATTER = "yyyy-MM";
    @Autowired
    private TouchInfoWorkReportMapper touchInfoWorkReportMapper;

    @Transactional(readOnly = true)
    public Map<String, Object> getInfo(QueryModel model) {
        Map<String, Object> map = new HashMap<>();
        TouchBaseInfo touchBaseInfo=new TouchBaseInfo();
        TouchVisitInfo touchVisitInfo=new  TouchVisitInfo();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(FORMATTER);
        String month=dateTimeFormatter.format(LocalDateTime.now());
        String lastMonth=dateTimeFormatter.format(LocalDateTime.now().minusMonths(1));
        List<TouchInfo> list = touchInfoWorkReportMapper.getBaseInfo(model);
        for (TouchInfo obj:list) {
            if (OFFLINE.equals(obj.getType())){
                if (month.equals(obj.getDate())){
                    touchBaseInfo.setContact1(obj.getCount());
                }
                if (lastMonth.equals(obj.getDate())){
                    touchBaseInfo.setLastContact1(obj.getCount());
                }
            }
            if (CALL.equals(obj.getType())){
                if (month.equals(obj.getDate())){
                    touchBaseInfo.setContact3(obj.getCount());
                }
                if (lastMonth.equals(obj.getDate())){
                    touchBaseInfo.setLastContact3(obj.getCount());
                }
            }
            if (MESSAGE.equals(obj.getType())){
                if (month.equals(obj.getDate())){
                    touchBaseInfo.setContact5(obj.getCount());
                }
                if (lastMonth.equals(obj.getDate())){
                    touchBaseInfo.setLastContact5(obj.getCount());
                }
            }
//            if (FEEDBACK.equals(obj.getType())){
//                if (month.equals(obj.getDate())){
//                    touchBaseInfo.setContact7(obj.getCount());
//                }
//                if (lastMonth.equals(obj.getDate())){
//                    touchBaseInfo.setLastContact7(obj.getCount());
//                }
//            }
        }
        List<TouchInfo> list1 = touchInfoWorkReportMapper.getBaseBackInfo(model);
        for (TouchInfo obj:list1) {
            if (month.equals(obj.getDate())){
                touchBaseInfo.setContact7(obj.getCount());
            }
            if (lastMonth.equals(obj.getDate())){
                touchBaseInfo.setLastContact7(obj.getCount());
            }
        }
        touchBaseInfo.setContact2(touchBaseInfo.getLastContact1() == 0 ? (touchBaseInfo.getContact1() == 0 ? 0 : 100) : (touchBaseInfo.getContact1() == 0 ? 0 :(touchBaseInfo.getContact1()-touchBaseInfo.getLastContact1())/touchBaseInfo.getLastContact1() * 100));
        touchBaseInfo.setContact4(touchBaseInfo.getLastContact3() == 0 ? (touchBaseInfo.getContact3() == 0 ? 0 : 100) : (touchBaseInfo.getContact3() == 0 ? 0 :(touchBaseInfo.getContact3()-touchBaseInfo.getLastContact3())/touchBaseInfo.getLastContact3() * 100));
        touchBaseInfo.setContact6(touchBaseInfo.getLastContact5() == 0 ? (touchBaseInfo.getContact5() == 0 ? 0 : 100) : (touchBaseInfo.getContact5() == 0 ? 0 :(touchBaseInfo.getContact5()-touchBaseInfo.getLastContact5())/touchBaseInfo.getLastContact5() * 100));
        touchBaseInfo.setContact8(touchBaseInfo.getLastContact7() == 0 ? (touchBaseInfo.getContact7() == 0 ? 0 : 100) : (touchBaseInfo.getContact7() == 0 ? 0 :(touchBaseInfo.getContact7()-touchBaseInfo.getLastContact7())/touchBaseInfo.getLastContact7() * 100));
        map.put("baseInfo",touchBaseInfo);
        List<TouchInfoDate> wisitList = touchInfoWorkReportMapper.getVisitInfo(model);
        for (TouchInfoDate obj:wisitList) {
            if (OFFLINE.equals(obj.getType())){
                touchVisitInfo.setContactDate1(obj.getDate());
            }
            if (CALL.equals(obj.getType())){
                touchVisitInfo.setContactDate2(obj.getDate());
            }
            if (MESSAGE.equals(obj.getType())){
                touchVisitInfo.setContactDate3(obj.getDate());
            }
//            if (FEEDBACK.equals(obj.getType())){
//                touchVisitInfo.setContactDate4(obj.getDate());
//            }
        }
        List<String> wisitList1 = touchInfoWorkReportMapper.getVisitBackInfo(model);
        touchVisitInfo.setContactDate4(wisitList1);
        map.put("visitInfo",touchVisitInfo);

        return map;
    }
    @Transactional(readOnly = true)
    public List<TouchVisitInfoDetail> getDetail(QueryModel model) {
      PageHelper.startPage(model.getPage(), model.getSize());
        List<TouchVisitInfoDetail> list=touchInfoWorkReportMapper.getVisitInfoDetail(model);
        PageHelper.clearPage();
        return list;
    }
}
