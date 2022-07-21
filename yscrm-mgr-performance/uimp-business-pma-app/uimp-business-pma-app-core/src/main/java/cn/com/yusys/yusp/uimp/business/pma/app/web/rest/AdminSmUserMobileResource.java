package cn.com.yusys.yusp.uimp.business.pma.app.web.rest;



import cn.com.yusys.yusp.admin.domain.AdminFileUploadInfo;
import cn.com.yusys.yusp.commons.file.ClientFactory;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.util.DateUtil;
import cn.com.yusys.yusp.commons.util.MimeMappingUtils;
import cn.com.yusys.yusp.commons.util.SpringContextUtil;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.base.service.UserInfoService;
import cn.com.yusys.yusp.uimp.business.pma.app.domain.AdminSmAnnexe;
import cn.com.yusys.yusp.uimp.business.pma.app.model.APPVersion;
import cn.com.yusys.yusp.uimp.business.pma.app.repository.mapper.AdminSmAnnexeMapper;
import cn.com.yusys.yusp.uimp.business.pma.app.service.AdminSmUserMobileService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import tk.mybatis.mapper.util.StringUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @项目名称: yusp-yscrm-mobile-starter模块
 * @类名称: AdminSmUserMobileResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: wsh
 * @创建时间: 2020-08-05 21:02:16
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Api(tags = "移动端我的")
@RestController
@RequestMapping("/api/app/adminsmusermobile")
public class AdminSmUserMobileResource {
	@Autowired
	ClientFactory fileManagementCilentFactory;
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private AdminSmAnnexeMapper adminSmAnnexeMapper;
	@Autowired
	private AdminSmUserMobileService adminSmUserMobileService;
//	@Value("${application.file.local-disk-path}")
	private String localDiskPath;
//	@Value("${application.app.android-download-url}")
	private String androidDownloadUrl;
//	@Value("${application.app.ios-download-url}")
	private String iosDownloadUrl;
//
//	@Value("${application.file.app-upload-url}")
//	private String appUploadUrl;
	@Autowired
	private UserInfoService userInfoService;
	// 上传APP安装包
	@RequestMapping("/uploadapp")
	public ResultDto<Object> uploadApp(MultipartFile file) throws Exception {
		ResultDto<Object> resultDto = new ResultDto<Object>();
		String filename = file.getOriginalFilename();
		String filePath = localDiskPath; // 生产环境
		file.getSize();
		File fileTarget = new File(filePath +"/"+ filename);
		if (fileTarget.exists()) {
			fileTarget.delete();
		}
		File dest = new File(filePath +"/"+ filename);
		try {
			file.transferTo(dest);
			resultDto.setCode(0);
			resultDto.setData(filePath +"/"+ filename);
			resultDto.setMessage("上传成功");
		} catch (IOException e) {
			e.printStackTrace();
			resultDto.setCode(-1);
//			logger.info("/api/app/uploadapp上传APP安装包抛出异常，异常信息为:" + e);
			resultDto.setMessage("上传失败");
		}
		return resultDto;
	}
	// 下载APP安装包
		@GetMapping("/download")
		public void download(String fileId, HttpServletResponse response, HttpServletRequest request) {
			FileManagementClient fileClient = fileManagementCilentFactory.getFileManagementClient();
			try {
				fileClient.initConnection();
				String[] fileIds = fileId.split(",");
				byte[] downloadFile = batchDownloadFile(fileIds, fileClient);
				String fileName = fileIds[0].substring(fileIds[0].lastIndexOf("/") + 1);
				if (fileIds.length > 1) {
					fileName = System.currentTimeMillis() + ".zip";
				}
				writeFile(MimeMappingUtils.getEncodeFileName(request, fileName), MimeMappingUtils.getMimeType(fileName),downloadFile, response);
				// 记录下载信息
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String time = df.format(new Date());
				adminSmUserMobileService.recordDownload(fileName);
//				logger.info("下载APP安装包,fileName为:" + fileName+",时间为:"+time);
			} catch (Exception e) {
//				logger.info("/api/app/download下载APP安装包抛出异常，异常信息为:" + e);
				e.printStackTrace();
			} finally {
				fileClient.closeConnection();
			}
		}
		/**
		 * 批量下载文件，多个文件统一压缩打包成zip文件
		 *
		 * @param fileIds    文件id，多个用,隔开
		 * @param fileClient
		 * @return
		 * @throws Exception
		 */
		private byte[] batchDownloadFile(String[] fileIds, FileManagementClient fileClient) throws Exception {
			// 单文件直接下载返回
			if (fileIds.length == 1) {
				return fileClient.downloadFile(fileIds[0]);
			}
			// 多个文件打成zip包
			try (ByteArrayOutputStream bos = new ByteArrayOutputStream(); ZipOutputStream zos = new ZipOutputStream(bos)) {
				for (String fileId : fileIds) {
					// 下载文件
					byte[] array = fileClient.downloadFile(fileId);
					String fileName = fileId.substring(fileId.lastIndexOf("/") + 1);
					zos.putNextEntry(new ZipEntry(fileName));
					zos.write(array);
					zos.closeEntry();
				}
				zos.close();
				return bos.toByteArray();
			} catch (Exception e) {
//				logger.info("/api/app/download下载APP安装包的batchDownloadFile抛出异常，异常信息为:" + e);
				throw new Exception("下载异常：", e);
			}
		}
		/**
		 * 输出文件流
		 *
		 * @param fileName 文件名称
		 * @param mimeType 文件类型
		 * @param fileByte 文件字节
		 * @param response
		 * @param fileSize
		 * @throws IOException
		 */
		private void writeFile(String fileName, String mimeType, byte[] fileByte, HttpServletResponse response) throws IOException {
			response.reset();
			response.setContentType(mimeType + ";charset=UTF-8");
			response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
			response.setHeader("Content-Length", String.valueOf(fileByte.length));
			response.getOutputStream().write(fileByte);
			response.getOutputStream().flush();
		}

	// 查询APP版本
		@RequestMapping("/queryappversion")
		public ResultDto<List<Map<String, Object>>> queryAppVersion(QueryModel model) {
			List<Map<String, Object>> list = this.adminSmUserMobileService.queryAppVersion(model);
			return new ResultDto<List<Map<String, Object>>>(list);
		}

		// 添加APP版本
		@RequestMapping("/addAppVersion")
		public ResultDto<Object> addAppVersion(@RequestBody APPVersion appVersion) {
			String downLoadUrl = "";
	           if ("0".equals(appVersion.getVersionBelong())) {
	        	   downLoadUrl = androidDownloadUrl;
	           } else if ("1".equals(appVersion.getVersionBelong())) {
	        	   downLoadUrl = iosDownloadUrl;
	           } else {
	        	   downLoadUrl = "";
	           }
			appVersion.setDownLoadUrl(downLoadUrl);
			return adminSmUserMobileService.addAppVersion(appVersion);
		}

		// 检查APP版本
		@RequestMapping(value = "/checkVersion")
		@ResponseBody
		public ResultDto<Object> checkVersion(String versionBelong) {
			Map<String, Object> list = adminSmUserMobileService.checkVersion(versionBelong);
			ResultDto<Object> data = new ResultDto<Object>();
			data.setData(list);
			return data;
		}
  	public String uploadFileService(MultipartFile file, String fileName) throws IOException {
		// TODO 自动生成的方法存根
		// 当未单独传递文件名称时，取文件name，可能中文乱码
		if (StringUtil.isEmpty(fileName)) {
			fileName = file.getOriginalFilename();
		}
		fileName = URLDecoder.decode(fileName, "UTF-8");
		String fileNameExt = fileName.substring(fileName.lastIndexOf(".") + 1);
		FileManagementClient fastDFSClient = fileManagementCilentFactory.getFileManagementClient();
		fastDFSClient.initConnection();
		String fileId = fastDFSClient.uploadFile(file.getBytes(), fileNameExt, null);
//		logger.debug("File path->{}", fileId);
		fastDFSClient.closeConnection();
		int index = fileId.indexOf("/");
		index = fileId.indexOf("/", index + 1);
		String str1 = fileId.substring(index + 1);
		AdminFileUploadInfo adminFileUploadInfo = new AdminFileUploadInfo();
		adminFileUploadInfo.setFileName(str1);// 文件名称
		long size = file.getSize() / 1024;
//		adminFileUploadInfo.setFileId(StringUtil.getUUID());// 附件编号
		adminFileUploadInfo.setFileSize(new BigDecimal(file.getSize()));// 文件大小
		adminFileUploadInfo.setExtName(fileNameExt);// 文件扩展名
		adminFileUploadInfo.setUploadTime(DateUtil.formatDateTimeByDef());// 上传时间
		adminFileUploadInfo.setFilePath(fileId);// 文件存储路径
		// 解决上传未带业务流水号的bug
//		if (StringUtil.isEmpty(adminFileUploadInfo.getBusNo())) {
//			// 使用uuid,
//			adminFileUploadInfo.setBusNo(StringUtil.getUUID());
//		}
		AdminSmAnnexe adminSmAnnexe = new AdminSmAnnexe();
		adminSmAnnexe.setAnnexeId(adminFileUploadInfo.getFileId());// 附件编号
		adminSmAnnexe.setAnnexeName(fileName);// 附件名称
		String annexeType = "";
		if ("psd".equals(fileNameExt)) {
			annexeType = "01";
		} else if ("jpg".equals(fileNameExt)) {
			annexeType = "02";
		} else if ("jpeg".equals(fileNameExt)) {
			annexeType = "03";
		} else if ("gif".equals(fileNameExt)) {
			annexeType = "04";
		} else if ("tiff".equals(fileNameExt)) {
			annexeType = "05";
		} else if ("png".equals(fileNameExt)) {
			annexeType = "06";
		} else if ("pcx".equals(fileNameExt)) {
			annexeType = "07";
		} else if ("eps".equals(fileNameExt)) {
			annexeType = "08";
		} else if ("bmp".equals(fileNameExt)) {
			annexeType = "09";
		} else if ("doc".equals(fileNameExt)) {
			annexeType = "11";
		} else if ("docx".equals(fileNameExt)) {
			annexeType = "12";
		} else if ("xls".equals(fileNameExt)) {
			annexeType = "21";
		} else if ("xlsx".equals(fileNameExt)) {
			annexeType = "22";
		} else if ("zip".equals(fileNameExt)) {
			annexeType = "31";
		} else if ("rar".equals(fileNameExt)) {
			annexeType = "32";
		} else if ("html".equals(fileNameExt)) {
			annexeType = "41";
		}
		adminSmAnnexe.setAnnexeType(annexeType);// 附件类型
		adminSmAnnexe.setAnnexeSize(new BigDecimal(file.getSize()));// 附件大小(kb)
		adminSmAnnexe.setClientName(null);// 客户端名称
		adminSmAnnexe.setAnnexeSerName(request.getServerName());// 附件服务器名称
		adminSmAnnexe.setPhysicalAddress(getFilePath().concat(fileId));// 物理地址
		adminSmAnnexe.setCreateUserId(userInfoService.getUserInfo().getLoginCode());// 创建人编号
		adminSmAnnexe.setCreateUserName(userInfoService.getUserInfo().getUserName());// 创建人姓名
		adminSmAnnexe.setCreateTime(DateUtil.formatDateTimeByDef());// 创建时间
		adminSmAnnexe.setCreateOrgId(userInfoService.getUserInfo().getOrg().getCode());// 创建人机构编号
		adminSmAnnexe.setCreateOrgName(userInfoService.getUserInfo().getOrg().getName());// 创建人机构名称
		int i = adminSmAnnexeMapper.insertSelective(adminSmAnnexe);
//		int j = adminFileUploadInfoMapper.insertSelective(adminFileUploadInfo);
		return adminFileUploadInfo.getFilePath();
	}
	/**
	 * 获取文件上传路径 --配置
	 * 
	 * @return
	 */
	public String getFilePath() {
		Environment environment = SpringContextUtil.getBean(Environment.class);
		String pathConfiguration = environment.getProperty("info.file.local-disk-path");
		pathConfiguration = (pathConfiguration == null ? "" : pathConfiguration);
		char[] c = pathConfiguration.toCharArray();
		if (!(c[c.length - 1] == '/' || c[c.length - 1] == '\\')) {
			pathConfiguration = pathConfiguration + "/";
		}
		return pathConfiguration;
	}

}
