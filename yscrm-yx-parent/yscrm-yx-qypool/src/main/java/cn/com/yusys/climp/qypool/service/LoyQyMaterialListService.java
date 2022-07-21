//package cn.com.yusys.climp.qypool.service;
//
//import cn.com.yusys.climp.qypool.domain.LoyQyMaterialList;
//import cn.com.yusys.climp.qypool.repository.mapper.LoyQyMaterialListMapper;
//import cn.com.yusys.yusp.commons.file.ClientFactory;
//import cn.com.yusys.yusp.commons.file.FileManagementClient;
//import cn.com.yusys.yusp.commons.mapper.CommonMapper;
//import cn.com.yusys.yusp.commons.mapper.QueryModel;
//import cn.com.yusys.yusp.commons.security.SecurityUtils;
//import cn.com.yusys.yusp.commons.service.CommonService;
//import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
//import net.coobird.thumbnailator.Thumbnails;
//import org.bytedeco.javacpp.opencv_core.IplImage;
//import org.bytedeco.javacv.FFmpegFrameGrabber;
//import org.bytedeco.javacv.Frame;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.imageio.IIOImage;
//import javax.imageio.ImageIO;
//import javax.imageio.ImageWriteParam;
//import javax.imageio.ImageWriter;
//import java.awt.*;
//import java.awt.image.BufferedImage;
//import java.awt.image.ColorModel;
//import java.io.*;
//import java.util.List;
//import java.util.*;
//
///**
// * @项目名称: yusp-climp-qypool-core模块
// * @类名称: LoyQyMaterialListService
// * @类描述: 素材管理服务类
// * @功能描述:
// * @创建人: yangxiao2
// * @创建时间: 2019-04-17
// * @修改备注:
// * @修改记录: 修改时间 修改人员 修改原因
// * -------------------------------------------------------------
// * @version 1.0.0
// * @Copyright (c) 2017宇信科技-版权所有
// */
//@Service
//public class LoyQyMaterialListService extends CommonService{
//	@Autowired
//	private LoyQyMaterialListMapper mapper;
//    @Autowired
//    private UserInfoService userInfoService;
//    @Autowired
//    ClientFactory clientFactory;
//	@Override
//	protected CommonMapper<?> getMapper() {
//		return mapper;
//	}
//
//	// 缩略图id
//	private final static String IMG_THUMBNAIL_ID = "imgThumbnailId";
//	// 附件id
//	private final static String UPLOAD_FILE_ID = "uploadFileId";
//
//	/**
//	 * @方法名称:getOrgCode
//	 * @方法描述:获取登录用户的机构号
//	 * @参数与返回说明:
//	 * @算法描述:
//	 */
//	public String getOrgCode() {
//        return userInfoService.getOrgCode();
//	}
//	/**
//	 * @方法名称:materialQuery
//	 * @方法描述:查询素材列表
//	 * @参数与返回说明:
//	 * @算法描述:
//	 */
//	public List<Map<String,Object>>materialQuery(QueryModel model) {
//
//		return this.mapper.materialQuery(model);
//	}
//	/**
//	 * @方法名称:insert
//	 * @方法描述:新增素材列表
//	 * @参数与返回说明:
//	 * @算法描述:
//	 */
//	public ResultDto<Integer>insert(LoyQyMaterialList record){
//		ResultDto<Integer> dto = new ResultDto<Integer>();
//		String loginCode = SecurityUtils.getCurrentUserLogin();
//		boolean nullflag = "".equals(record.getUploadApproal())
//				&& "".equals(record.getUploadFile())
//				&& "".equals(record.getUploadLink())
//				&& "".equals(record.getDetailContent());
//		if (mapper.getSameName(record.getMaterialName()) != 0) {
//			// 素材名重复校验
//			dto.setCode(-1);
//			dto.setMessage("素材名重复");
//		} else if (nullflag) {
//			// 上传文件校验
//			dto.setCode(-1);
//			dto.setMessage("未上传文件");
//		} else {
//			if(record.getNaturalSize() != null && !record.getNaturalSize().equals("")) {
//				String[] size = record.getNaturalSize().split("\\*");
//				long math_size = Long.parseLong(size[0])*Long.parseLong(size[1]);
//				if(math_size != 0) {
//
//					if(math_size < 102400) {
//						record.setApplySize("4"); //
//					} else if(math_size<307200) { // 640*480
//						record.setApplySize("3"); // 中尺寸
//					} else if (math_size<1310720) { // 1280*1024
//						record.setApplySize("2"); // 大尺寸
//					} else { // 分辨率1920*1080
//						record.setApplySize("1"); // 特大尺寸
//					}
//
////					if(math_size<2073600) { // 分辨率1920*1080
////						record.setApplySize("4"); // 特大尺寸
////					} else if (math_size<1310720) { // 1280*1024
////						record.setApplySize("3"); // 大尺寸
////					} else if (math_size<307200) { // 640*480
////						record.setApplySize("2"); // 中尺寸
////					} else {
////						record.setApplySize("1"); // 小尺寸
////					}
//				}
//			}
//			if(record.getMaterialType().equals("1")||record.getMaterialType().equals("6")) {
//				// 图片压缩
//				String thumbNail = null;
//				try {
//					thumbNail = createNail(record.getUploadFileId());
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//				record.setImgThumbNailId(thumbNail);
//			}
////			if(record.getMaterialType().equals("4")) {
//				// 生成视频缩略图  改为前台传值
////				String videoImgId = createVideoNail(record.getUploadFileId());
////				record.setImgThumbNailId(videoImgId);
////			}
//			record.setId(getUUID());
//			record.setMaterialSts("1");// 初始状态未提交
//			record.setCreateDate(new Date());
//			record.setUpdateDate(record.getCreateDate());
//			record.setCreateOrg(getOrgCode());
//			record.setUpdateOrg(getOrgCode());
//			record.setCreateUser(loginCode);
//			record.setUpdateUser(loginCode);
//			mapper.insertSelective(record);
//			dto.setCode(0);
//			dto.setMessage("新增成功");
//		}
//		return dto;
//	}
//	/**
//	 * @方法名称:edit
//	 * @方法描述:修改素材列表
//	 * @参数与返回说明:
//	 * @算法描述:
//	 */
//	public ResultDto<Integer>edit(LoyQyMaterialList record) {
//		ResultDto<Integer> dto = new ResultDto<Integer>();
//		//初始化连接
//		FileManagementClient fileClient = clientFactory.getFileManagementClient();
//		fileClient.initConnection();
//		String loginCode = SecurityUtils.getCurrentUserLogin();
//		boolean nullflag = "".equals(record.getUploadApproal())
//				&& "".equals(record.getUploadFile())
//				&& "".equals(record.getUploadLink())
//				&& "".equals(record.getDetailContent());
//		Map<String,Object> map = new HashMap<String,Object>();
//		map.put("materialName", record.getMaterialName());
//		map.put("id", record.getId());
//		if (mapper.getSameNameEdit(map) != 0) {
//			// 素材名重复校验
//			dto.setCode(-1);
//			dto.setMessage("素材名重复");
//		} else if (nullflag) {
//			// 上传文件校验
//			dto.setCode(-1);
//			dto.setMessage("未上传文件");
//		} else {
//			Map<String,Object> fileId = mapper.getFileId(record.getId());
//			String type = record.getMaterialType();
//			if(!type.equals("1") && !type.equals("4") && !type.equals("6")) {
//				if(null != fileId && fileId.get(IMG_THUMBNAIL_ID)!=null) {
//					// 删除缩略图
//					fileClient.deleteFile(fileId.get(IMG_THUMBNAIL_ID).toString());
//				}
//			}
//			if(null != fileId && fileId.get(UPLOAD_FILE_ID) != null && record.getUploadFileId() != null) {
//				if(!fileId.get(UPLOAD_FILE_ID).toString().equals(record.getUploadFileId())) {
//					// 删除附件
//					fileClient.deleteFile(fileId.get(UPLOAD_FILE_ID).toString());
//				}
//				if(record.getMaterialType().equals("1")||record.getMaterialType().equals("6")) {
//					// 删除缩略图
//					fileClient.deleteFile(fileId.get(IMG_THUMBNAIL_ID).toString());
//					// 图片压缩
//					String thumbNail = createNail(record.getUploadFileId());
//					record.setImgThumbNailId(thumbNail);
//				}
//				if(record.getMaterialType().equals("4")) {
//					// 删除缩略图
//					fileClient.deleteFile(fileId.get(IMG_THUMBNAIL_ID).toString());
//					// 生成视频缩略图
//					String videoImgId = createVideoNail(record.getUploadFileId());
//					record.setImgThumbNailId(videoImgId);
//				}
//			}
//			record.setUpdateDate(new Date());
//			record.setUpdateUser(loginCode);
//			record.setUpdateOrg(getOrgCode());
//			mapper.updateByPrimaryKeySelective(record);
//			dto.setCode(0);
//			dto.setMessage("修改成功");
//		}
//		//关闭连接
//		fileClient .closeConnection();
//		return dto;
//	}
//	/**
//	 * @方法名称:delete
//	 * @方法描述:删除素材列表
//	 * @参数与返回说明:
//	 * @算法描述:
//	 */
//	public ResultDto<Integer>delete(Map<String,Object> map) {
//		ResultDto<Integer> dto = new ResultDto<Integer>();
//		boolean nullflag = map.get("uploadApproal") == null
//				&& map.get("uploadFile") == null
//				&& map.get("uploadLink") == null
//				&& map.get("detailContent") == null;
//		if (nullflag) {
//			dto.setCode(-1);
//			dto.setMessage("删除失败");
//		} else {
//			mapper.deleteByPrimaryKey(map.get("id").toString());
//			dto.setCode(0);
//			dto.setMessage("删除成功");
//		}
//		return dto;
//	}
//
//
//	/**
//	 * @方法名称:createNail
//	 * @方法描述:生成图片缩略图
//	 * @参数与返回说明:
//	 * @算法描述:
//	 */
//	public String createNail(String fileId) {
//		String nailFileId = fileId;
//		//初始化连接
//		FileManagementClient fileClient = clientFactory.getFileManagementClient();
//		fileClient.initConnection();
//		//下载文件转File
//		byte[] imgByte = fileClient.downloadFile(fileId);
//		BufferedOutputStream bos = null;
//		FileOutputStream fos = null;
//		File file = new File("thumbNail.jpg");
//		try {
//			fos = new FileOutputStream(file);
//			bos = new BufferedOutputStream(fos);
//	        bos.write(imgByte);
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if (bos != null) {
//                try {
//                    bos.close();
//                } catch (IOException e1) {
//                    e1.printStackTrace();
//                }
//            }
//            if (fos != null) {
//                try {
//                    fos.close();
//                } catch (IOException e1) {
//                    e1.printStackTrace();
//                }
//            }
//		}
//		// 设置图片质量压缩图片
//		float qulity = 0.2f;
//		try {
//			//File nailFile = compressPictureByQality(file,qulity);
//			Thumbnails.of(file).scale(1f).outputQuality(qulity).toFile(file);
//			nailFileId = fileClient.uploadFile(file);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		//关闭连接
//		fileClient.closeConnection();
//		return nailFileId;
//	}
//
//	/**
//	 * 生成视频缩略图
//	 * @param record
//	 * @return
//	 */
//	public ResultDto<String> create(LoyQyMaterialList record){
//		ResultDto<String> dto = new ResultDto<String>();
//		if(record.getMaterialType().equals("4")){
//			dto.setData(createVideoNail(record.getUploadFileId()));
//		}
//
//		return dto;
//	}
//	/**
//	 * @方法名称:createVideoNail
//	 * @方法描述:生成视频缩略图
//	 * @参数与返回说明:
//	 * @算法描述:
//	 */
//	public String createVideoNail(String fileId) {
//		String videoNailId = fileId;
//		//初始化连接
//		FileManagementClient fileClient = clientFactory.getFileManagementClient();
//		fileClient.initConnection();
//		byte[] videoByte = fileClient.downloadFile(fileId);
//		BufferedOutputStream bos = null;
//		FileOutputStream fos = null;
//		File file = new File("videoNail.mp4");
//		try {
//			if(!file.exists()) {
//				file.createNewFile();
//			}
//			fos = new FileOutputStream(file);
//			bos = new BufferedOutputStream(fos);
//	        bos.write(videoByte);
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if (bos != null) {
//                try {
//                    bos.close();
//                } catch (IOException e1) {
//                    e1.printStackTrace();
//                }
//            }
//            if (fos != null) {
//                try {
//                    fos.close();
//                } catch (IOException e1) {
//                    e1.printStackTrace();
//                }
//            }
//		}
//		try {
//			File imgFile = compressPictureByQality(videoImg(file),0.2f);
//			videoNailId = fileClient.uploadFile(imgFile);
//			file.delete();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		//关闭连接
//		fileClient .closeConnection();
//		return videoNailId;
//	}
//	 /**
//     * 压缩图片
//     * @param file
//     * @param qality 参数qality是取值0~1范围内  代表压缩的程度
//     * @return
//     * @throws IOException
//     */
//    public static File compressPictureByQality(File file,float qality) throws IOException {
//        BufferedImage src = null;
//        FileOutputStream out = null;
//        ImageWriter imgWrier;
//        ImageWriteParam imgWriteParams;
//        // 指定写图片的方式为 jpg
//        imgWrier = ImageIO.getImageWritersByFormatName("jpg").next();
//        imgWriteParams = new javax.imageio.plugins.jpeg.JPEGImageWriteParam(
//                null);
//        // 要使用压缩，必须指定压缩方式为MODE_EXPLICIT
//        imgWriteParams.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
//        // 这里指定压缩的程度，参数qality是取值0~1范围内，
//        imgWriteParams.setCompressionQuality(qality);
//        imgWriteParams.setProgressiveMode(ImageWriteParam.MODE_DISABLED);
//        ColorModel colorModel =ImageIO.read(file).getColorModel();// ColorModel.getRGBdefault();
//        imgWriteParams.setDestinationType(new javax.imageio.ImageTypeSpecifier(
//                colorModel, colorModel.createCompatibleSampleModel(32, 32)));
//        if (!file.exists()) {
//            throw new FileNotFoundException("Not Found Img File,文件不存在");
//        } else {
//            src = ImageIO.read(file);
//            out = new FileOutputStream(file);
//            imgWrier.reset();
//            // 必须先指定 out值，才能调用write方法, ImageOutputStream可以通过任何
//            // OutputStream构造
//            imgWrier.setOutput(ImageIO.createImageOutputStream(out));
//            // 调用write方法，就可以向输入流写图片
//            imgWrier.write(null, new IIOImage(src, null, null),
//                    imgWriteParams);
//            out.flush();
//            out.close();
//            return file;
//        }
//    }
//    /**
//     * 截取视频第6帧图片
//     * @param VideoFile 视频文件
//     * @return imgFile 缩略图文件
//     * @throws IOException
//     */
//    public File videoImg(File VideoFile) {
//    	File imgFile = new File("videoImg.jpg");
//    	try {
//			// FFmpegFrameGrabber ff = FFmpegFrameGrabber.createDefault(VideoFile);
//    		FFmpegFrameGrabber ff = FFmpegFrameGrabber.createDefault(VideoFile);
//			ff.start();
//			int ffLength = ff.getLengthInFrames();
//			Frame f = null;
//			int i = 0;
//			while(i<ffLength) {
//				f = ff.grabFrame();
//				if(i > 6 && f.image != null) {
//					break;
//				}
//				i++;
//			}
//			IplImage img = f.image;
//			BufferedImage bi = new BufferedImage(img.width(), img.height(), BufferedImage.TYPE_3BYTE_BGR);
//			bi.getGraphics().drawImage(f.image.getBufferedImage().getScaledInstance(img.width(), img.height(), Image.SCALE_SMOOTH),0, 0, null);
//			ImageIO.write(bi, "jpg", imgFile);
//			ff.stop();
//		} catch (org.bytedeco.javacv.FrameGrabber.Exception | IOException e) {
//			e.printStackTrace();
//		}
//    	return imgFile;
//    }
//
//    /**
//	 * @方法名称:getDptByOrgId
//	 * @方法描述:查询机构归属部门
//	 * @参数与返回说明:
//	 * @算法描述:
//	 */
//    public List<Map<String,Object>>getDptByOrgId(String orgId){
//    	return mapper.getDptByOrgId(orgId);
//    }
//
//	/**
//	 *
//	 * @方法名称: getfieldsChannel
//	 * @方法描述: 查询渠道所有的栏位信息
//	 * @参数与返回说明:
//	 * @算法描述:
//	 */
//	@Transactional(readOnly = true)
//	public List<Map<String, Object>> getfieldsChannel() {
//		List<Map<String, Object>> result= mapper.getfieldsChannel();
//		return result;
//	}
//	/**
//	 * @方法名称: getUUID
//	 * @方法描述: UUID生成器
//	 * @参数与返回说明:
//	 * @算法描述:
//	 */
//	private String getUUID() {
//		return UUID.randomUUID().toString().toLowerCase().replace("-", "");
//	}
//
//	public LoyQyMaterialList getMaterialContentById(String parameter) {
//		LoyQyMaterialList loyQyMaterialList = mapper.selectByPrimaryKey(parameter);
//		return loyQyMaterialList;
//	}
//
//	public int apply(LoyQyMaterialList record) {
//		LoyQyMaterialList entity = new LoyQyMaterialList();
//		entity.setId(record.getId());
//		entity.setMaterialSts("3");
//		return mapper.updateByPrimaryKeySelective(entity);
//	}
//}
