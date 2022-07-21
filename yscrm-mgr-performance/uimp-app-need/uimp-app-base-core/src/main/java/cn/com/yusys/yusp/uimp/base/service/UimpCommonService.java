package cn.com.yusys.yusp.uimp.base.service;

import cn.com.yusys.yusp.commons.file.FileManagementCilent;
import cn.com.yusys.yusp.commons.file.FileManagementCilentFactory;
import cn.com.yusys.yusp.commons.util.MimeMappingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @项目名称: uimp-app-base-core模块
 * @类名称: UimpCommonService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-12-07 17:56:14
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Service
public class UimpCommonService {
	
	@Autowired
    private FileManagementCilentFactory fileManagementCilentFactory;
	
	public void download(String filePath, HttpServletResponse response, HttpServletRequest request) {
		FileManagementCilent fileClient = fileManagementCilentFactory.getFileManagementCilent();
		try {
			fileClient.initConnection();
			String[] filePaths = filePath.split(",");
			byte[] downloadFile = batchDownloadFile(filePaths, fileClient);
			String fileName = filePaths[0].substring(filePaths[0].lastIndexOf("/") + 1);
			if (filePaths.length > 1) {
				fileName = System.currentTimeMillis() + ".zip";
			}
			writeFile(MimeMappingUtils.getEncodeFileName(request, fileName), MimeMappingUtils.getMimeType(fileName), downloadFile, response);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fileClient.closeConnection();
		}
	}
	
	/**
	 * 批量下载文件，多个文件统一压缩打包成zip文件
	 *
	 * @param filePaths
	 * @param fileClient
	 * @return
	 * @throws Exception
	 */
	private byte[] batchDownloadFile(String[] filePaths, FileManagementCilent fileClient) throws Exception {
		// 单文件直接下载返回
		if (filePaths.length == 1) {
			return fileClient.downloadFile(filePaths[0]);
		}

		// 多个文件打成zip包
		try (ByteArrayOutputStream bos = new ByteArrayOutputStream(); ZipOutputStream zos = new ZipOutputStream(bos)) {
			for (String fileId : filePaths) {
				// 下载文件
				byte[] array = fileClient.downloadFile(fileId);
				String fileName = fileId.substring(fileId.lastIndexOf("/") + 1);
				zos.putNextEntry(new ZipEntry(fileName));
				zos.write(array);
			}
			return bos.toByteArray();
		} catch (Exception e) {
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
	 * @throws IOException
	 */
	private void writeFile(String fileName, String mimeType, byte[] fileByte, HttpServletResponse response)
			throws IOException {
		response.reset();
		response.setContentType(mimeType + ";charset=UTF-8");
		response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
		response.getOutputStream().write(fileByte);
		response.getOutputStream().flush();
	}
	
}
