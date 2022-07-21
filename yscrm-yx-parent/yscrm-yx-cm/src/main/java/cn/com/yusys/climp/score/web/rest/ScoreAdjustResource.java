package cn.com.yusys.climp.score.web.rest;

import cn.com.yusys.climp.score.domain.FileVO;
import cn.com.yusys.climp.score.domain.ScoreExch;
import cn.com.yusys.climp.score.service.ScoreAdjustService;
import cn.com.yusys.yusp.admin.domain.AdminFileUploadInfo;
import cn.com.yusys.yusp.admin.web.rest.FileProviderServiceResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import org.apache.http.entity.ContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.util.Map;

/**
 * @项目名称: yusp-climp-acct模块
 * @类名称: AccountTarResource
 * @类描述: #资源类
 * @功能描述:
 * @创建人: Administrator
 * @创建时间: 2018-12-27 10:50:42
 * @修改备注:
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/scoreadjust")
public class ScoreAdjustResource {
    private Logger logger = LoggerFactory.getLogger(ScoreAdjustResource.class);

    @Autowired
    private ScoreAdjustService scoreAdjustService;
    @Autowired
    private FileProviderServiceResource fileProviderServiceResource;

    /**
     * 积分兑换
     * @return
     */
    @PostMapping("/exch")
    public ResultDto<ScoreExch> scoreExch(@RequestBody ScoreExch scoreExch){
        ResultDto<ScoreExch> rs = null;
        try {
            scoreExch.setOrderChannel("10");
            rs = scoreAdjustService.scoreExch(scoreExch);
            rs.setMessage(rs.getMessage().split("@")[1]);
        }catch (Exception e){
            rs = new ResultDto<>();
            rs.setCode(-1);
            rs.setMessage("兑换失败");
            logger.error(e.getMessage());
            e.printStackTrace();
        }finally {
            return rs;
        }
    }


    /**
     * 名单制积分赠送
     * @return
     */
    @PostMapping("/excelCheck")
    public ResultDto<Map<String,String>> excelCheck(MultipartFile file, AdminFileUploadInfo adminFileUploadInfo, String fileName){
        try {
            Map<String, String> reMap =scoreAdjustService.excelCheck(file);
            String code = reMap.get("err_code");
            if ("1".equals(code) || "2".equals(code) || "-1".equals(code) || "3".equals(code)){
                return new ResultDto<>(reMap);
            }else {
                ResultDto<AdminFileUploadInfo> resultDto = fileProviderServiceResource.uploadFile(file,adminFileUploadInfo,fileName);
                if ("99".equals(code)){
                    reMap.put("fileId",resultDto.getData().getFilePath());
                    return new ResultDto<>(reMap);
                }else if ("0".equals(code)){
                    scoreAdjustService.excelExport(reMap.get("importCode"),resultDto.getData().getFilePath(),false);
                    ResultDto<Map<String,String>> rs = new ResultDto<>();
                    rs.setCode(0);
                    rs.setMessage("导入成功");
                    return rs;
                }else {
                    ResultDto<Map<String,String>> rs = new ResultDto<>();
                    rs.setCode(-1);
                    rs.setMessage("未知错误");
                    return rs;
                }
            }
        }catch (Exception e) {
            ResultDto<Map<String,String>> rs = new ResultDto<>();
            rs.setCode(-1);
            rs.setMessage(e.getMessage());
            return rs;
            // TODO Auto-generated catch block
            //e.printStackTrace();
        }
    }
}
