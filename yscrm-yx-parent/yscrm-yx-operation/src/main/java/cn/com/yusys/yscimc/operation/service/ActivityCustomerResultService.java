package cn.com.yusys.yscimc.operation.service;

import cn.com.yusys.yscimc.operation.domain.ActivityCustomerResultEntity;
import cn.com.yusys.yscimc.operation.domain.dto.ActivityResultDto;
import cn.com.yusys.yscimc.operation.domain.form.ActivityResultForm;

import java.util.List;

public interface ActivityCustomerResultService {

    void saveBatch(List<ActivityCustomerResultEntity> list);

    ActivityResultDto getActivityResult(ActivityResultForm resultForm);

    List<ActivityCustomerResultEntity> getResultByTempId(ActivityResultForm resultForm);
}
