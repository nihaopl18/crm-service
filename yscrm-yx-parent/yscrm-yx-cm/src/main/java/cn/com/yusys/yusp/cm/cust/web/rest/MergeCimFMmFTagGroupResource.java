//package cn.com.yusys.yusp.cm.cust.web.rest;
//
//import cn.com.yusys.yusp.cm.cust.domain.CimFMmFTagGroup;
//import cn.com.yusys.yusp.cm.cust.service.MergeCimFMmFTagGroupService;
//import cn.com.yusys.yusp.commons.mapper.QueryModel;
//import cn.com.yusys.yusp.commons.service.CommonService;
//import cn.com.yusys.yusp.commons.web.rest.CommonResource;
//import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
///**
// * @author dell
// * @项目名称： yusp-app-cim
// * @类名称: CimFMmFTagGroupResource
// * @类描述:
// * @功能描述: 标签分组
// * @创建人: Yangjingbo
// * @创建时间: 2018年09月28日
// * @修改备注:
// * @修改记录: 修改时间    修改人员    修改原因
// */
//
//@RestController
//@RequestMapping("/api/cimfmmftagGrop")
//public class MergeCimFMmFTagGroupResource extends CommonResource<CimFMmFTagGroup, String> {
//    @Autowired
//    private MergeCimFMmFTagGroupService cimFmmTagGroupService;
//
//    public MergeCimFMmFTagGroupResource(MergeCimFMmFTagGroupService service) {
//        super();
//        this.cimFmmTagGroupService = service;
//        // TODO Auto-generated constructor stub
//    }
//
//    private final Logger log = LoggerFactory.getLogger(MergeCimFMmFTagGroupResource.class);
//
//    @Override
//    protected CommonService getCommonService() {
//        // TODO Auto-generated method stub
//        return this.cimFmmTagGroupService;
//    }
//
//    /**
//     * 查询获取分组树
//     *
//     * @return
//     */
//
//    @GetMapping("/getGroupTree")
//    public ResultDto<List<CimFMmFTagGroup>> getGroupTree() {
//        List<CimFMmFTagGroup> list = this.cimFmmTagGroupService.getGroupTree();
//        ResultDto<List<CimFMmFTagGroup>> resultDto = new ResultDto<List<CimFMmFTagGroup>>(list);
//        resultDto.setTotal(list.size());
//        resultDto.setData(list);
//        return resultDto;
//    }
//
//    /*
//     *新增标签分组
//     */
//    @PostMapping("/saveTagGroup")
//    public ResultDto<CimFMmFTagGroup> saveTagGroup(@RequestBody CimFMmFTagGroup record) {
//        QueryModel model = new QueryModel();
//        model.setCondition("{\"GroupName\":" + record.getGroupName() + "}");
//        List<CimFMmFTagGroup> list = this.cimFmmTagGroupService.getByParentNo(model);
//        ResultDto<CimFMmFTagGroup> resultDto = new ResultDto<CimFMmFTagGroup>();
//        if (!list.isEmpty()) {
//            resultDto.setCode(-1);
//            resultDto.setMessage("标签分组名称已存在");
//            return resultDto;
//        }
//        resultDto = new ResultDto<CimFMmFTagGroup>(this.cimFmmTagGroupService.saveTagGroup(record));
//        resultDto.setCode(0);
//        resultDto.setMessage("新增成功");
//        return resultDto;
//    }
//
//    @PostMapping("/deleteTagGroup")
//    public ResultDto<Integer> deleteTagGroup(@RequestBody QueryModel model) {
//        return new ResultDto<Integer>(this.cimFmmTagGroupService.deleteTagGroup(model));
//    }
//
//    /**
//     * 标签分组维护
//     *
//     * @param record
//     * @return
//     */
//
//    @PostMapping("/modifyTagGroup")
//    public ResultDto<Integer> modifyTagGroup(@RequestBody CimFMmFTagGroup record) {
//        return new ResultDto<Integer>(this.cimFmmTagGroupService.updateTagGroup(record));
//    }
//
//    /**
//     * 校验标签名称是否重复
//     *
//     * @param model
//     * @return
//     */
//    @GetMapping("/getByParentNo")
//    public ResultDto<List<CimFMmFTagGroup>> getByParentNo(QueryModel model) {
//        List<CimFMmFTagGroup> list = this.cimFmmTagGroupService.getByParentNo(model);
//        return new ResultDto<List<CimFMmFTagGroup>>(list);
//    }
//
//    /**
//     * 校验当前节点的上级节点是否为他的子节点,得到子节点
//     *
//     * @param model
//     * @return
//     */
//
//    @GetMapping("/getChild")
//    public ResultDto<List<CimFMmFTagGroup>> getChild(QueryModel model) {
//        List<CimFMmFTagGroup> list = this.cimFmmTagGroupService.getChild(model);
//        return new ResultDto<List<CimFMmFTagGroup>>(list);
//    }
//}