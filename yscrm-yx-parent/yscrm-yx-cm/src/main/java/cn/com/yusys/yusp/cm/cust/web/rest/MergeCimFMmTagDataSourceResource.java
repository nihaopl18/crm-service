//package cn.com.yusys.yusp.cm.cust.web.rest;
//
//import cn.com.yusys.yusp.cm.cust.domain.CimFMmTagDataSource;
//import cn.com.yusys.yusp.cm.cust.service.MergeCimFMmTagDataSourceService;
//import cn.com.yusys.yusp.commons.mapper.QueryModel;
//import cn.com.yusys.yusp.commons.service.CommonService;
//import cn.com.yusys.yusp.commons.web.rest.CommonResource;
//import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
//import com.codahale.metrics.annotation.Timed;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.net.URISyntaxException;
//import java.text.ParseException;
//import java.util.List;
//import java.util.Map;
//
///**
// * @version 1.0.0
// * @项目名称: yusp-app-cim-cust
// * @类名称: CimFMmTagDataSourceResource
// * @类描述:
// * @功能描述: 模型版本信息
// * @创建人: yangye@yusys.com.cn
// * @创建时间: 2018年09月27日
// * @修改备注:
// * @修改记录: 修改时间    修改人员    修改原因
// * -------------------------------------------------------------
// * @Copyright (c) 2017宇信科技-版权所有
// */
//@RestController
//@RequestMapping("/api/cimfmmtagdatasource")
//public class MergeCimFMmTagDataSourceResource extends CommonResource<CimFMmTagDataSource, String> {
//    @Autowired
//    private MergeCimFMmTagDataSourceService cimFMmTagDataSourceService;
//
//    public MergeCimFMmTagDataSourceResource(MergeCimFMmTagDataSourceService service) {
//        super();
//        this.cimFMmTagDataSourceService = service;
//        // TODO Auto-generated constructor stub
//    }
//
//    private final Logger log = LoggerFactory.getLogger(MergeCimFMmTagDataSourceResource.class);
//
//    @Override
//    protected CommonService getCommonService() {
//        // TODO Auto-generated method stub
//        return this.cimFMmTagDataSourceService;
//    }
//
//    /*
//     * 查询数据来源内容
//     * */
//    @GetMapping("/datasourcelist")
//    public ResultDto<List<Map<String, Object>>> getTagDataSourceList(QueryModel model) {
//        List<Map<String, Object>> list = cimFMmTagDataSourceService.getTagDataSourceList(model);
//        //log.info("list.size()="+list.size());
//        ResultDto<List<Map<String, Object>>> resultDto = new ResultDto<List<Map<String, Object>>>();
//        resultDto.setTotal(list.size());
//        resultDto.setData(list);
//        return resultDto;
//    }
//    /*
//     * 删除数据来源内容
//     * */
//
//    @PostMapping("/deletesource")
//    public ResultDto<List<CimFMmTagDataSource>> deleteTagDataSource(@RequestBody QueryModel record) throws URISyntaxException, ParseException {
//        ResultDto<List<CimFMmTagDataSource>> resultDto = new ResultDto<List<CimFMmTagDataSource>>();
//        int num = cimFMmTagDataSourceService.deleteTagDataSource(record);
//        log.info("num=" + num);
//        if (num == 0) {
//            resultDto.setMessage("删除失败！");
//            resultDto.setCode(-1);
//        } else {
//            resultDto.setMessage("success");
//            resultDto.setCode(0);
//        }
//        return resultDto;
//    }
//
//    /*
//     * 新增数据来源
//     * */
//    @PostMapping("/insertsource")
//    public ResultDto<List<CimFMmTagDataSource>> insertTagDataSource(@RequestBody CimFMmTagDataSource record) throws URISyntaxException, ParseException {
//        if (cimFMmTagDataSourceService.checkTagNo(record.getTagNo()) == 0) {
//            ResultDto<List<CimFMmTagDataSource>> resultDto = new ResultDto<List<CimFMmTagDataSource>>();
//            resultDto.setMessage("新增失败！");
//            resultDto.setCode(-1);
//            return resultDto;
//        }
//        ;
//        ResultDto<List<CimFMmTagDataSource>> resultDto = new ResultDto<List<CimFMmTagDataSource>>();
//        int num = cimFMmTagDataSourceService.insertTagDataSource(record);
//        log.info("num=" + num);
//        if (num == 0) {
//            resultDto.setMessage("新增失败！");
//            resultDto.setCode(-1);
//        } else {
//            resultDto.setMessage("success");
//            resultDto.setCode(0);
//        }
//        return resultDto;
//    }
//
//    /*
//     * 修改数据来源内容
//     * */
//    @PostMapping("/updatesource")
//    public ResultDto<List<CimFMmTagDataSource>> updateTagDataSource(@RequestBody CimFMmTagDataSource record) throws URISyntaxException, ParseException {
//        ResultDto<List<CimFMmTagDataSource>> resultDto = new ResultDto<List<CimFMmTagDataSource>>();
//        int num = cimFMmTagDataSourceService.updateTagDataSource(record);
//        log.info("num=" + num);
//        if (num == 0) {
//            resultDto.setMessage("修改失败！");
//            resultDto.setCode(-1);
//        } else {
//            resultDto.setMessage("success");
//            resultDto.setCode(0);
//        }
//        return resultDto;
//    }
//
//    /*
//     * 查找选中表中的实体属性
//     * */
//    @PostMapping("/getEntityNo")
//    @Timed
//    public ResultDto<List<Map<String, Object>>> getEntityNo(@RequestBody QueryModel queryModel) {
//        List<Map<String, Object>> list = this.cimFMmTagDataSourceService.getEntityNo(queryModel);
//        ResultDto<List<Map<String, Object>>> resultDto = new ResultDto<List<Map<String, Object>>>();
//        resultDto.setTotal(list.size());
//        resultDto.setData(list);
//        return resultDto;
//    }
//
//    /*
//     * 查找数据库中所有表名
//     * */
//    @GetMapping("/getTableName")
//    public ResultDto<List<Map<String, Object>>> getTableName(QueryModel queryModel) {
//        List<Map<String, Object>> list = this.cimFMmTagDataSourceService.getTableName(queryModel);
//        ResultDto<List<Map<String, Object>>> resultDto = new ResultDto<List<Map<String, Object>>>();
//        resultDto.setTotal(list.size());
//        resultDto.setData(list);
//        return resultDto;
//    }
//
//    /*
//     * 查找数据库中来源实体编号、属性、表名是否重复
//     * */
//    @GetMapping("/dsRepeat")
//    public ResultDto<List<Map<String, Object>>> getDsRepeat(QueryModel queryModel) {
//        List<Map<String, Object>> list = this.cimFMmTagDataSourceService.getDsRepeat(queryModel);
//        ResultDto<List<Map<String, Object>>> resultDto = new ResultDto<List<Map<String, Object>>>();
//        resultDto.setTotal(list.size());
//        resultDto.setData(list);
//        return resultDto;
//    }
//}
