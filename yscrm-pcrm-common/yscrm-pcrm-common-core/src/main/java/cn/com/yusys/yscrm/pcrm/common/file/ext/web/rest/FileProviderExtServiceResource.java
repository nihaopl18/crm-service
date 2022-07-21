package cn.com.yusys.yscrm.pcrm.common.file.ext.web.rest;

import cn.com.yusys.yscrm.pcrm.common.file.ext.service.FileProviderExtService;
import cn.com.yusys.yusp.admin.domain.AdminFileUploadInfo;
import cn.com.yusys.yusp.commons.file.FileManagementCilent;
import cn.com.yusys.yusp.commons.file.FileManagementCilentFactory;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.util.file.FileTypeUtil;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import com.codahale.metrics.annotation.Timed;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@RestController
@RequestMapping({"/api/file/provider/ext"})
public class FileProviderExtServiceResource extends CommonResource<AdminFileUploadInfo, String> {
    private Logger logger = LoggerFactory.getLogger(FileProviderExtServiceResource.class);

    @Autowired
    private FileProviderExtService fileProviderExtService;

    @Autowired
    FileManagementCilentFactory fileManagementCilentFactory;

    @Override
    protected CommonService getCommonService() {
        return fileProviderExtService;
    }

    /**
     * @函数名称:annexInformationQuery
     * @函数描述: 附件信息查询
     * @参数与返回说明:
     * @param queryModel
     *            分页查询类
     * @算法描述:
     */
    @GetMapping("/annexinformationquery")
    @Timed
    protected ResultDto<List<Map<String, Object>>> annexInformationQuery(QueryModel queryModel) {
        List<Map<String, Object>> list = null;
        list = fileProviderExtService.annexInformationQuery(queryModel);
        return new ResultDto<>(list);
    }

    /**
     * @函数名称:download
     * @函数描述: 附件下载
     * @参数与返回说明:
     * @param queryModel
     * @算法描述:
     */
    @GetMapping({"/download"})
    public void download(QueryModel queryModel, HttpServletResponse response, HttpServletRequest request) {
        String fileId = (String) queryModel.getCondition().get("fileId");
        this.logger.debug("请求参数:{}", fileId);
        FileManagementCilent fileClient = this.fileManagementCilentFactory.getFileManagementCilent();

        try {
            fileClient.initConnection();
            String[] fileIds = fileId.split(",");
            byte[] downloadFile = this.batchDownloadFile(fileIds, fileClient);
            String fileName = fileIds[0].substring(fileIds[0].lastIndexOf("/") + 1);
            if (fileIds.length > 1) {
                fileName = System.currentTimeMillis() + ".zip";
            }

            this.writeFile(FileTypeUtil.getEncodeFileName(request, fileName), FileTypeUtil.getMimeType(fileName), downloadFile, response);
            fileProviderExtService.addFilelog(queryModel);
        } catch (Exception var11) {
            var11.printStackTrace();
        } finally {
            fileClient.closeConnection();
        }
    }

    private byte[] batchDownloadFile(String[] fileIds, FileManagementCilent fileClient) throws Exception {
        if (fileIds.length == 1) {
            return fileClient.downloadFile(fileIds[0]);
        } else {
            ZipOutputStream zos = null;
            ByteArrayOutputStream bos = null;

            try {
                bos = new ByteArrayOutputStream();
                zos = new ZipOutputStream(bos);
                String[] var8 = fileIds;
                int var7 = fileIds.length;

                for(int var6 = 0; var6 < var7; ++var6) {
                    String fileId = var8[var6];
                    byte[] array = fileClient.downloadFile(fileId);
                    String fileName = fileId.substring(fileId.lastIndexOf("/") + 1);
                    zos.putNextEntry(new ZipEntry(fileName));
                    zos.write(array);
                }
            } catch (Exception var14) {
                throw new Exception("下载异常：", var14);
            } finally {
                IOUtils.closeQuietly(zos);
                IOUtils.closeQuietly(bos);
            }

            return bos.toByteArray();
        }
    }

    private void writeFile(String fileName, String mimeType, byte[] fileByte, HttpServletResponse response) throws IOException {
        response.reset();
        response.setContentType(mimeType + ";charset=UTF-8");
        response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
        response.getOutputStream().write(fileByte);
        response.getOutputStream().flush();
    }
}
