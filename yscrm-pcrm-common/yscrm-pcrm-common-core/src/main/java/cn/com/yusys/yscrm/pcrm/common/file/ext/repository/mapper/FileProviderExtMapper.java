package cn.com.yusys.yscrm.pcrm.common.file.ext.repository.mapper;

import cn.com.yusys.yscrm.pcrm.common.file.ext.domain.OcrmFWpFileLog;
import cn.com.yusys.yusp.admin.domain.AdminFileUploadInfo;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

import java.util.List;
import java.util.Map;

public interface FileProviderExtMapper  extends CommonMapper<OcrmFWpFileLog> {
    List<Map<String, Object>> annexInformationQuery(QueryModel queryModel);
}
