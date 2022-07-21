package cn.com.yusys.yscrm.sysview.utils;

import cn.com.yusys.yscrm.sysview.domain.activity.TodoWorkExcel;

import java.util.ArrayList;
import java.util.List;

public class PagesUtils {

    public static List pages(List list, int page, int size) {
        List list1 = new ArrayList();
        int first = (page - 1) * size;
        int count = 0;
        int sum = list.size();
        while (count <= size && first < sum){
            list1.add(list.get(first));
            first++;
            count++;
        }
        return list1;
    }
}
