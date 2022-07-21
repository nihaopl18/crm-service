//package cn.com.yusys.yusp.cm.cust.web.rest;
//
//import cn.com.yusys.yusp.cm.cust.domain.CimFMmTagTagsInfo;
//import cn.com.yusys.yusp.cm.cust.service.MergeCimFMmTagAuthService;
//import cn.com.yusys.yusp.cm.cust.service.MergeCimFMmTagDataSourceService;
//import cn.com.yusys.yusp.cm.cust.service.MergeCimFMmTagTagsInfoService;
//import cn.com.yusys.yusp.commons.mapper.QueryModel;
//import cn.com.yusys.yusp.commons.service.CommonService;
//import cn.com.yusys.yusp.commons.web.rest.CommonResource;
//import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
//import com.codahale.metrics.annotation.Timed;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.net.URISyntaxException;
//import java.text.ParseException;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * @version 1.0.0
// * @项目名称: yusp-app-cim
// * @类名称: CimFMmTagTagsInfoResource
// * @类描述:
// * @功能描述: 标签管理
// * @创建人: yangxiao2@yusys.com.cn
// * @创建时间: 2018年09月28日
// * @修改备注:
// * @修改记录: 修改时间    修改人员    修改原因
// * -------------------------------------------------------------
// * @Copyright (c) 2017宇信科技-版权所有
// */
//@RestController
//@RequestMapping("/api/cimfmmtagtagsinfo")
//public class MergeCimFMmTagTagsInfoResource extends CommonResource<CimFMmTagTagsInfo, String> {
//    @Autowired
//    private MergeCimFMmTagTagsInfoService cimFMmTagTagsInfoService;
//    @Autowired
//    private MergeCimFMmTagAuthService cimFMmTagAuthService;
//    @Autowired
//    private MergeCimFMmTagDataSourceService cimFMmTagDataSourceService;
//
//    public MergeCimFMmTagTagsInfoResource(MergeCimFMmTagTagsInfoService service) {
//        super();
//        this.cimFMmTagTagsInfoService = service;
//        // TODO Auto-generated constructor stub
//    }
//
//    @Override
//    protected CommonService getCommonService() {
//        // TODO Auto-generated method stub
//        return this.cimFMmTagTagsInfoService;
//    }
//
//    /*
//     * 查询标签列表
//     * @param model
//     * @return list
//     * */
//    @GetMapping("/listtag")
//    public ResultDto<List<CimFMmTagTagsInfo>> getTagList(QueryModel model) {
//        List<CimFMmTagTagsInfo> list = cimFMmTagTagsInfoService.getTagList(model);
//        return new ResultDto<List<CimFMmTagTagsInfo>>(list);
//    }
//
//    /*
//     * 判断标签是否重复
//     * @param tag
//     * @return hashmap
//     * */
//    @PostMapping("/judgetag")
//    public ResultDto<List<Map<String, Object>>> judgeSameTag(@RequestBody CimFMmTagTagsInfo tag) {
//        List<Map<String, Object>> hashmap = this.cimFMmTagTagsInfoService.judgeSameTag(tag);
//        return new ResultDto<List<Map<String, Object>>>(hashmap);
//    }
//
//    /*
//     * 更新标签内容
//     * @param tag
//     * @return int
//     * */
//    @PostMapping("/updatetag")
//    @Timed
//    public ResultDto<Integer> updateTagList(@RequestBody CimFMmTagTagsInfo tag) throws URISyntaxException, ParseException {
//        ResultDto<Integer> resultDto = null;
//        resultDto = new ResultDto<Integer>();
//        if (this.cimFMmTagTagsInfoService.updateTagList(tag) != 1) {
//            resultDto.setCode(-1);
//            resultDto.setMessage("修改失败");
//        } else {
//            resultDto = new ResultDto<Integer>(this.cimFMmTagTagsInfoService.updateTagList(tag));
//            resultDto.setCode(0);
//            resultDto.setMessage("修改成功");
//        }
//
//        return resultDto;
//    }
//
//    /*
//     * 新增标签
//     * @param tag
//     * @return int
//     * */
//    @PostMapping("/inserttag")
//    @Timed
//    public ResultDto<CimFMmTagTagsInfo> insertTagList(@RequestBody CimFMmTagTagsInfo tag) throws URISyntaxException, ParseException {
//        return this.cimFMmTagTagsInfoService.insertTagList(tag);
//    }
//
//    /**
//     * 删除时校验标签分组下是否挂有标签
//     *
//     * @param model
//     * @return
//     */
//    @GetMapping("/getTagByGroupNo")
//    public ResultDto<List<CimFMmTagTagsInfo>> getTagByGroupNo(QueryModel model) throws JsonProcessingException {
//        List<CimFMmTagTagsInfo> list = this.cimFMmTagTagsInfoService.getTagByGroupNo(model);
//        ResultDto<List<CimFMmTagTagsInfo>> resultDto = new ResultDto<List<CimFMmTagTagsInfo>>(list);
//        resultDto.setTotal(list.size());
//        resultDto.setData(list);
//        return resultDto;
//    }
//
//    /*
//     * 返回标签分组编号
//     * @param
//     * @return hashmap
//     * */
////	 @PostMapping("/tagnodelist")
////	 public ResultDto<List<Map<String,Object>>> getTagNodeList(@RequestBody CimFMmTagTagsInfo tag) throws URISyntaxException {
////		 List<Map<String,Object>> hashmap = this.cimFMmTagTagsInfoService.getTagNodeList(tag);
////		 return new ResultDto<List<Map<String,Object>>>(hashmap);
////	 }
//    /*
//     * 批量删除标签内容
//     * @param tag
//     * @return map
//     * */
//    @PostMapping("/deletetags")
//    public ResultDto<Integer> deleteByTagNos(@RequestBody CimFMmTagTagsInfo tag) throws URISyntaxException {
//        ResultDto<Integer> resultDto = new ResultDto<Integer>();
//        if ("".equals(tag.getTagNos())) {
//            resultDto.setCode(-2);
//            resultDto.setMessage("删除失败");
//            return resultDto;
//        } else {
//            String[] tag_del = tag.getTagNos().split(",");
//            Map<String, Object> map = new HashMap<String, Object>();
//            int num = 0, custtag = 0;
//            for (int i = 0; i < tag_del.length; i++) {
//                map.put("tagNos", tag_del[i]);
//                num = this.cimFMmTagTagsInfoService.deleteByTagNos(map);
//                if (this.cimFMmTagTagsInfoService.getCustTag(tag_del[i]).equals("0")) {
//                    custtag++;
//                    // 删除标签的授权信息
//                    cimFMmTagAuthService.delTagNo(tag_del[i]);
//                    // 删除标签的数据来源信息
//                    cimFMmTagDataSourceService.delTagNo(tag_del[i]);
//                }
//                if (num < 1) {
//                    resultDto.setCode(-1);
//                    resultDto.setMessage("删除失败");
//                    break;
//                } else {
//                    resultDto = new ResultDto<Integer>(num);
//                    resultDto.setCode(0);
//                    resultDto.setMessage("删除成功");
//                }
//            }
//            if (custtag != tag_del.length) {
//                resultDto.setCode(-3);
//                resultDto.setMessage("删除失败");
//            }
//            return resultDto;
//        }
//    }
//
//    /*
//     * 查询审批中标签信息
//     * @param model
//     * @return list
//     * */
//    @GetMapping("/getuploadtag")
//    public ResultDto<List<CimFMmTagTagsInfo>> getUploadTagById(QueryModel model) {
//        List<CimFMmTagTagsInfo> list = this.cimFMmTagTagsInfoService.getUploadTagById(model);
//        return new ResultDto<List<CimFMmTagTagsInfo>>(list);
//    }
//
//    /*
//     * 更新标签生命周期
//     * @param tag
//     * @return int
//     * */
//    @PostMapping("/settaglifecycle")
//    public ResultDto<Integer> setTagLifeCycle(@RequestBody CimFMmTagTagsInfo tag) throws URISyntaxException {
//        ResultDto<Integer> dto = new ResultDto<Integer>(this.cimFMmTagTagsInfoService.setTagLifeCycle(tag));
//        dto.setMessage("更新状态成功");
//        return dto;
//    }
//
//    /*
//     * 查询审批中的标签
//     * @param tag
//     * @return int
//     * */
//    @PostMapping("/gettagnobyid")
//    public ResultDto<CimFMmTagTagsInfo> getTagById(String tagNo) {
//        CimFMmTagTagsInfo cimFMmTagTagsInfo = this.cimFMmTagTagsInfoService.getTagById(tagNo);
//        return new ResultDto<CimFMmTagTagsInfo>(cimFMmTagTagsInfo);
//    }
//
//    /*
//     * 查询审批中的标签
//     * @param orgLevel
//     * @return Map<String, Object>
//     * */
//    @PostMapping("/getorglevel")
//    public ResultDto<Map<String, Object>> getOrgLevel(@RequestBody QueryModel model) {
//        return new ResultDto<Map<String, Object>>(this.cimFMmTagTagsInfoService.getOrgLevel(model));
//    }
//
//    @GetMapping("/qrytag")
//    public ResultDto<List<Map<String, Object>>> qryTagBytagno(QueryModel model) {
//        List<Map<String, Object>> list = cimFMmTagTagsInfoService.qryTagBytagno(model);
//        return new ResultDto<List<Map<String, Object>>>(list);
//    }
//}
