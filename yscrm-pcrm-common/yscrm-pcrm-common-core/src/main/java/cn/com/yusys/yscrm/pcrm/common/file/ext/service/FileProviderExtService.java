package cn.com.yusys.yscrm.pcrm.common.file.ext.service;

import cn.com.yusys.yscrm.pcrm.common.file.ext.domain.OcrmFWpFileLog;
import cn.com.yusys.yscrm.pcrm.common.file.ext.repository.mapper.FileProviderExtMapper;
import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.ognl.Ognl;
import org.apache.ibatis.ognl.OgnlContext;
import org.apache.ibatis.ognl.OgnlException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

@Service
public class FileProviderExtService extends CommonService {

    @Autowired
    private FileProviderExtMapper fileProviderExtMapper;

    @Autowired
    private UaaClient uaaClient;

    @Override
    protected CommonMapper getMapper() {
        return fileProviderExtMapper;
    }

    private String getUuid() {
        OgnlContext contxet = new OgnlContext();
        try {
            Object ognl = Ognl.parseExpression("@java.util.UUID@randomUUID().toString().replace(\"-\", \"\")");
            return Ognl.getValue(ognl, contxet, contxet.getRoot()).toString();
        } catch (OgnlException var3) {
            var3.printStackTrace();
            return null;
        }
    }

    public UserInfoDTO getUserInfoDTO() {
        ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
        UserInfoDTO user = dto.getBody();
        return user;
    }

    public List<Map<String, Object>> annexInformationQuery(QueryModel queryModel) {
        PageHelper.startPage(queryModel.getPage(), queryModel.getSize());
        List<Map<String,Object>> list = fileProviderExtMapper.annexInformationQuery(queryModel);
        PageHelper.clearPage();
        return list;
    }

    public void addFilelog(QueryModel queryModel) {
        OcrmFWpFileLog ocrmFWpFileLog = new OcrmFWpFileLog();
        UserInfoDTO user = this.getUserInfoDTO();
        Map<String,Object> map = queryModel.getCondition();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ocrmFWpFileLog.setUserId(user.getUserCode());
        ocrmFWpFileLog.setUserName(user.getUserName());
        ocrmFWpFileLog.setOperBusiId((String) map.get("busiNo"));
        String fileId = (String) map.get("fileId");
        String[] fileIds = fileId.split(",");
        if (fileIds.length>1){
            for (String id: fileIds){
                if (id != null && !"".equals(id)) {
                    ocrmFWpFileLog.setLogId(this.getUuid());
                    ocrmFWpFileLog.setOperObjId(id);
                    this.insertSelective(fileProviderExtMapper, ocrmFWpFileLog);
                }
            }
        }else {
            ocrmFWpFileLog.setLogId(this.getUuid());
            ocrmFWpFileLog.setOperObjId(fileId);
            this.insertSelective(fileProviderExtMapper,ocrmFWpFileLog);
        }
    }
}
