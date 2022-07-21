//package cn.com.yusys.climp.qypool.web.rest;
//
//import cn.com.yusys.climp.qypool.domain.LoyQyMaterialList;
//import cn.com.yusys.climp.qypool.service.LoyQyMaterialListService;
//import cn.com.yusys.yusp.commons.mapper.QueryModel;
//import cn.com.yusys.yusp.commons.service.CommonService;
//import cn.com.yusys.yusp.commons.web.rest.CommonResource;
//import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
//import org.apache.poi.poifs.filesystem.DirectoryEntry;
//import org.apache.poi.poifs.filesystem.DocumentEntry;
//import org.apache.poi.poifs.filesystem.POIFSFileSystem;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.ByteArrayInputStream;
//import java.io.FileOutputStream;
//import java.io.OutputStream;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api/material")
//public class LoyQyMaterialListResource extends CommonResource<LoyQyMaterialList, String> {
//
//    @Autowired
//    private LoyQyMaterialListService service;
//
//    @Override
//    protected CommonService getCommonService() {
//        return service;
//    }
//
//    /**
//     * @方法名称:materialQuery
//     * @方法描述:查询素材列表
//     * @参数与返回说明:
//     * @算法描述:
//     */
//    @GetMapping("/query")
//    public ResultDto<List<Map<String, Object>>> materialQuery(QueryModel model) {
//        return new ResultDto<List<Map<String, Object>>>(this.service.materialQuery(model));
//    }
//
//    /**
//     * @方法名称:insert
//     * @方法描述:新增素材列表
//     * @参数与返回说明:
//     * @算法描述:
//     */
//    @PostMapping("/insert")
//    public ResultDto<Integer> insert(@RequestBody LoyQyMaterialList record) {
//        return this.service.insert(record);
//    }
//
//    /**
//     * @方法名称:edit
//     * @方法描述:修改素材列表
//     * @参数与返回说明:
//     * @算法描述:
//     */
//    @PostMapping("/edit")
//    public ResultDto<Integer> edit(@RequestBody LoyQyMaterialList record) {
//        return this.service.edit(record);
//    }
//
//    /**
//     * @方法名称:delete
//     * @方法描述:删除素材列表
//     * @参数与返回说明:
//     * @算法描述:
//     */
//    @PostMapping("/delete")
//    public ResultDto<Integer> delete(@RequestBody Map<String, Object> map) {
//        return this.service.delete(map);
//    }
//
//    /**
//     * @方法名称:getDptByOrgId
//     * @方法描述:查询机构归属部门
//     * @参数与返回说明:
//     * @算法描述:
//     */
//    @GetMapping("/getdptbyorgid")
//    public ResultDto<List<Map<String, Object>>> getDptByOrgId(@RequestParam(required = true) String orgId) {
//        return new ResultDto<List<Map<String, Object>>>(service.getDptByOrgId(orgId));
//    }
//
//    /**
//     * @方法名称: getfieldsChannel
//     * @方法描述: 查询渠道所有的栏位信息
//     * @参数与返回说明:
//     * @算法描述:
//     */
//    @GetMapping("/getfieldschannel")
//    public ResultDto<List<Map<String, Object>>> getfieldsChannel() {
//        List<Map<String, Object>> list = service.getfieldsChannel();
//        return new ResultDto<List<Map<String, Object>>>(list);
//    }
//
//    /**
//     * @方法名称:createvideonail
//     * @方法描述:生成视频缩略图
//     * @参数与返回说明:
//     * @算法描述:
//     */
//    @PostMapping("/createvideonail")
//    public ResultDto<String> createVideoNail(@RequestBody LoyQyMaterialList record) {
//        return this.service.create(record);
//    }
//
//    /**
//     * @方法名称:apply
//     * @方法描述:申请审批
//     * @参数与返回说明:
//     * @算法描述:
//     */
//    @PostMapping("/apply")
//    public ResultDto<Integer> apply(@RequestBody LoyQyMaterialList record) {
//
//        return new ResultDto(this.service.apply(record));
//    }
//
//    @GetMapping("/wordExport")
//    public void wordExport(HttpServletRequest request, HttpServletResponse response) {
//        LoyQyMaterialList loyQyMaterialList = this.service.getMaterialContentById(request.getParameter("id"));
//
//        if (null == loyQyMaterialList) {
//            return;
//        }
//        // 数据库查富文本数据
//        String richText = "<html><body>" + loyQyMaterialList.getDetailContent() + "</body></html>";
//        try {
//            //设置编码
//            byte b[] = richText.getBytes("GBK");
//            ByteArrayInputStream bais = new ByteArrayInputStream(b);
//            POIFSFileSystem poifs = new POIFSFileSystem();
//            // ##############下面这两个不能删掉
//            DirectoryEntry directory = poifs.getRoot();
//            DocumentEntry documentEntry = directory.createDocument("WordDocument", bais);
//            //################这两个不能删掉
//            //输出文件
//            String name = loyQyMaterialList.getMaterialName();
//            response.reset();
//            response.setHeader("Content-Disposition",
//                    "attachment;filename=" +
//                            new String(name.getBytes("GB2312"), "iso-8859-1") + ".doc");
//            response.setContentType("application/msword");
//            OutputStream ostream = response.getOutputStream();
//            poifs.writeFilesystem(ostream);
//            bais.close();
//            ostream.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//}
