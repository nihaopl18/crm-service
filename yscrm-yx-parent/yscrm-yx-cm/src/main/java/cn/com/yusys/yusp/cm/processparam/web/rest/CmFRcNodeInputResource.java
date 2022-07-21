package cn.com.yusys.yusp.cm.processparam.web.rest;

import cn.com.yusys.yusp.cm.processparam.domain.CmFRcNodeInputInfo;
import cn.com.yusys.yusp.cm.processparam.service.CmFRcNodeInputService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * @version 1.0.0
 * @项目名称: yusp-app-cm
 * @类名称: CmFRcNodeInputResource
 * @类描述: 组件输入参数接口
 * @功能描述:
 * @创建人: yangxiao2@yusys.com.cn
 * @创建时间: 2018-11-15
 * @修改备注:
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @Copyright (c) 2018宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/cmfrcnodeinput")
public class CmFRcNodeInputResource extends CommonResource<CmFRcNodeInputInfo, Serializable> {

    @Autowired
    private CmFRcNodeInputService service;

    @Override
    protected CommonService getCommonService() {
        return this.service;
    }

    /**
     * @方法名称: getList
     * @方法描述: 查询查询组件输入参数表
     * @参数与返回说明:
     * @算法描述:
     **/
    @PostMapping("/list")
    public ResultDto<List<Map<String, Object>>> getList(@RequestBody CmFRcNodeInputInfo record) {
        return this.service.getList(record);
    }

    /**
     * @throws ParseException
     * @方法名称: insertList
     * @方法描述: 查询查询组件输入参数表
     * @参数与返回说明:
     * @算法描述:
     **/
    @PostMapping("/insertlist")
    public ResultDto<Integer> insertList(@RequestBody CmFRcNodeInputInfo record) throws ParseException {
        return this.service.insertList(record);
    }

    /**
     * @throws ParseException
     * @方法名称: updateList
     * @方法描述: 查询查询组件输入参数表
     * @参数与返回说明:
     * @算法描述:
     **/
    @PostMapping("/updatelist")
    public ResultDto<Integer> updateList(@RequestBody CmFRcNodeInputInfo record) throws ParseException {
        return this.service.updateList(record);
    }

    /**
     * @throws
     * @方法名称: deleteList
     * @方法描述: 查询查询组件输入参数表
     * @参数与返回说明:
     * @算法描述:
     **/
    @PostMapping("/deletelist")
    public ResultDto<Integer> deleteList(@RequestBody CmFRcNodeInputInfo record) {
        return this.service.deleteList(record);
    }

    // 保存
    @PostMapping("/save")
    public ResultDto<Integer> save(@RequestBody CmFRcNodeInputInfo record) throws ParseException {
        int num = service.checkBe(record.getNodeId());
        if (num == 0) {
            return this.service.add(record);
        }
        return service.upd(record);
    }

    // 查询是否存在组件ID
    @PostMapping("/checknodeid")
    public ResultDto<CmFRcNodeInputInfo> checknodeid(@RequestBody QueryModel model) throws ParseException {
        return new ResultDto<>(service.checknodeid(model));
    }

    // 保存
    @PostMapping("/saveinputmerge")
    public ResultDto<Integer> saveinputmerge(@RequestBody CmFRcNodeInputInfo record) throws ParseException {
        int num = service.checkBe(record.getNodeId());
        if (num == 0) {
            return this.service.addmerge(record);
        }
        return service.upd(record);
    }
}
