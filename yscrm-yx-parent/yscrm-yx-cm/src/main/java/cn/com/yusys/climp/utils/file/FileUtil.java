package cn.com.yusys.climp.utils.file;

import org.springframework.util.Assert;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.InputStream;

public class FileUtil {
    public static void deleteFile(File... files) {
        for (File file : files) {
            if (file.exists()) {
                file.delete();
            }
        }
    }
    
    /**
       * 文件公共校验
     * @param file
     * @return
     * @author taolongqing
     */
    public static InputStream vaildataFile(MultipartFile file) {
		 try {
			   Assert.notNull(file, "文件不能为空");
			   Assert.isTrue(ExcelImportUtils.validateExcel(file.getOriginalFilename()), "请选择exel格式文件上传");
			   Assert.isTrue(file.getSize() > 0, "文件内容不能为空");
			   return file.getInputStream();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	 }
}
