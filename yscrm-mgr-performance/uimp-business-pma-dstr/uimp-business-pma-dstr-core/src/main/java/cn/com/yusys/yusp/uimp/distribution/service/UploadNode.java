package cn.com.yusys.yusp.uimp.distribution.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UploadNode {

    public Map<String,String> value = new HashMap<>();
    public List<UploadNode> children = new ArrayList<>();

    public boolean hasChild() {
        return !children.isEmpty();
    }
}
