package cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.service.impl;

import cn.com.yusys.yusp.uimp.base.service.UserInfoService;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.domain.PmaFAssessTargetEntity;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.domain.vo.TargetDistriExcelVo;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.repository.mapper.PmaFAssessTargetMapper;
import cn.com.yusys.yusp.uimp.business.pma.scheme.tools.AddCommonFieldTools;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/** 目标下发Excel导入
 * @author houyx3
 * @email houyx3@yusys.com.cn
 * @date 2022/5/20 14:00
 */
@Service
public class TargetDistriExcelVoListener extends AnalysisEventListener<TargetDistriExcelVo> {

    public TargetDistriExcelVoListener(PmaFAssessTargetMapper pmaFAssessTargetMapper, UserInfoService userInfoService) {
        this.pmaFAssessTargetMapper = pmaFAssessTargetMapper;
        this.userInfoService = userInfoService;
    }
    private static final int BATCH_COUNT = 200;

    private final List<PmaFAssessTargetEntity> list = new ArrayList<>(BATCH_COUNT);

    private PmaFAssessTargetMapper pmaFAssessTargetMapper;

    private final UserInfoService userInfoService;

    // 周期类型码值定义
    private static final HashMap<String, String> IN_CYCLE_TYPE_MAP = new HashMap<>(8);
    static {
        IN_CYCLE_TYPE_MAP.put("年", "Y");
        IN_CYCLE_TYPE_MAP.put("半年", "HY");
        IN_CYCLE_TYPE_MAP.put("季", "Q");
        IN_CYCLE_TYPE_MAP.put("月", "M");
    }
    // 考核对象类型码值定义
    private static final HashMap<String, String> IN_EVL_OBJ_TYPE = new HashMap<>(8);
    static {
        IN_EVL_OBJ_TYPE.put("客户经理", "01");
        IN_EVL_OBJ_TYPE.put("团队", "02");
        IN_EVL_OBJ_TYPE.put("机构", "04");
    }
    @Autowired
    private void setPmaFAssessTargetMapper(PmaFAssessTargetMapper pmaFAssessTargetMapper) {
        this.pmaFAssessTargetMapper = pmaFAssessTargetMapper;
    }


    @Override
    public void invoke(TargetDistriExcelVo targetDistriExcelVo, AnalysisContext analysisContext) {

        PmaFAssessTargetEntity entity = new PmaFAssessTargetEntity();
        BeanUtils.copyProperties(targetDistriExcelVo, entity);
        AddCommonFieldTools.createCommonFieldFun(entity, userInfoService.getUserInfo());
        entity.setId(UUID.randomUUID().toString().replace("-", ""));
        entity.setEvlObjType(IN_EVL_OBJ_TYPE.get(entity.getEvlObjType()));
        entity.setSchemeCycleType(IN_CYCLE_TYPE_MAP.get(entity.getSchemeCycleType()));
        list.add(entity);
        if (list.size() >= BATCH_COUNT) {
            saveData(list);
            list.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        saveData(list);
        list.clear();
    }

    @Transactional(rollbackFor = Exception.class)
    public void saveData(List<PmaFAssessTargetEntity> list) {
        // 集合去重
        List<PmaFAssessTargetEntity> list1 = new ArrayList<>();
        for (PmaFAssessTargetEntity pma : list) {
            boolean b = list1.stream().anyMatch(vo -> pma.getYears().equals(vo.getYears()) && pma.getSchemeId().equals(vo.getSchemeId()) && pma.getIndexId().equals(vo.getIndexId()) && pma.getEvlObjId().equals(vo.getEvlObjId()));
            if (b){
                continue;
            }
            list1.add(pma);
        }



        // 批量新增修改
        pmaFAssessTargetMapper.upsert(list1);

    }


}
