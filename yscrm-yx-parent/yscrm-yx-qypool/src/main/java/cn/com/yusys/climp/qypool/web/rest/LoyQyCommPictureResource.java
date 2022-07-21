package cn.com.yusys.climp.qypool.web.rest;

import java.math.BigDecimal;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import cn.com.yusys.yusp.admin.domain.AdminFileUploadInfo;
import cn.com.yusys.yusp.admin.service.impl.FileProviderServiceImpl;
import cn.com.yusys.yusp.commons.file.FileManagementCilent;
import cn.com.yusys.yusp.commons.file.FileManagementCilentFactory;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.climp.qypool.domain.LoyQyCommPicture;
import cn.com.yusys.climp.qypool.service.LoyQyCommPictureService;
import org.springframework.web.multipart.MultipartFile;

/**
 * @项目名称: yusp-climp-qypool-core模块
 * @类名称: LoyQyCommPictureResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: chenlin
 * @创建时间: 2019-02-26 14:40:21
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/loyqycommpicture")
public class LoyQyCommPictureResource extends CommonResource<LoyQyCommPicture, String> {
	private Logger logger = LoggerFactory.getLogger(LoyQyCommPictureResource.class);
    @Autowired
    private LoyQyCommPictureService loyQyCommPictureService;

	@Autowired
	private FileProviderServiceImpl fileProviderServiceImpl;
	@Autowired
	FileManagementCilentFactory fileManagementCilentFactory;
	@Value("${application.localDiskPath}")
	private String path;
    @Override
    protected CommonService getCommonService() {
        return loyQyCommPictureService;
    }
    /**
    * @方法名称:getPicture
    * @方法描述:根据商品编号查询商品图片
    * @参数与返回说明:
    * @算法描述:
     */
    @GetMapping("/piclist")
   	public ResultDto<List<LoyQyCommPicture>> getPicture(String commodityCode) {
   		List<LoyQyCommPicture> list = loyQyCommPictureService.getPicture(commodityCode);
   		return new ResultDto<List<LoyQyCommPicture>>(list);
   	}
    
    @PostMapping("/savepic")
    public ResultDto<Map<String, Object>> savePic(@RequestBody LoyQyCommPicture picture) {
       ResultDto<Map<String, Object>> reuslt=new ResultDto<Map<String, Object>>();
		try {
	    	if(loyQyCommPictureService.isRepeatThumbnail(picture.getCommId(), picture.getPictureType(), picture.getId())) {
	    		reuslt.setCode(200001);
				reuslt.setMessage("商品已经存在一个缩略图，不能再新增缩略图!");
	    	}else {
	    		if("".equals(picture.getId())&&null==picture.getId()) {
	    			loyQyCommPictureService.update(picture);
	    		}else {
	    			loyQyCommPictureService.insert(picture);
	    		}
	    		reuslt.setCode(0);
	    		reuslt.setMessage("商品图片维护操作成功！");
	    	}
		}catch (Exception e) {
			e.printStackTrace();
			reuslt.setCode(100001);
			reuslt.setMessage("fail");
		}
		return reuslt;
    }
    /**
    * @方法名称:delPic
    * @方法描述:商品图片删除
    * @参数与返回说明:
    * @算法描述:
     */
    @PostMapping("/delpic")
    public ResultDto<Integer> delPic(@RequestBody Map<?,?> map) {
    	String[] idStr = map.get("ids").toString().split(",");
        return new ResultDto<Integer>(loyQyCommPictureService.delPic(idStr));
    }

	@PostMapping({"/uploadfile"})
	public ResultDto<AdminFileUploadInfo> uploadFile(MultipartFile file, AdminFileUploadInfo adminFileUploadInfo, String fileName) throws Exception {
		this.logger.debug("接口/uploadfile 接受参数:file:{},adminFileUploadInfo:{},fileName：{}", new Object[]{file.toString(), adminFileUploadInfo.toString(), fileName});
		if (StringUtils.isEmpty(fileName)) {
			fileName = file.getOriginalFilename();
		}

		fileName = URLDecoder.decode(fileName, "UTF-8");
		String fileNameExt = fileName.substring(fileName.lastIndexOf(".") + 1);
		FileManagementCilent fastDFSClient = this.fileManagementCilentFactory.getFileManagementCilent("localdisk",path+"/comm");
		fastDFSClient.initConnection();
		String fileId = fastDFSClient.uploadFile(file.getBytes(), fileNameExt, (Map)null);
		this.logger.debug("文件路径->{}", fileId);
		fastDFSClient.closeConnection();
		adminFileUploadInfo.setFileName(fileName);
		long size = file.getSize() / 1024L;
		adminFileUploadInfo.setFileSize(new BigDecimal(size));
		adminFileUploadInfo.setExtName(fileNameExt);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		adminFileUploadInfo.setUploadTime(df.format(new Date()));
		adminFileUploadInfo.setFilePath(fileId);
		if (StringUtils.isEmpty(adminFileUploadInfo.getBusNo())) {
			adminFileUploadInfo.setBusNo(UUID.randomUUID().toString().replaceAll("-", ""));
		}

		this.fileProviderServiceImpl.insertSelective(adminFileUploadInfo);
		return new ResultDto(adminFileUploadInfo);
	}

}
