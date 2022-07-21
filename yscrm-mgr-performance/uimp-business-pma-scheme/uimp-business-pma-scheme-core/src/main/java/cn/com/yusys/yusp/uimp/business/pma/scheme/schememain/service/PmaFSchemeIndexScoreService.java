package cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.service;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.domain.PmaFSchemeIndexScore;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.domain.PmaFSchemeIndexScoreParam;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.domain.PmaScoreModelParams;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.domain.vo.PamScoreParamVo;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.domain.vo.PmaSchemeScoreReqVo;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.domain.vo.PmaScoreIndexVo;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.repository.mapper.PmaFSchemeIndexScoreMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @description: 考核方案评分模型业务处理类
 * @author: Zhan YongQiang
 * @date: 2022/4/2 15:53
 */
@Service
public class PmaFSchemeIndexScoreService extends CommonService {

    @Autowired
    private PmaFSchemeIndexScoreMapper pmaFSchemeIndexScoreMapper;


    @Override
    protected CommonMapper getMapper() {
        return pmaFSchemeIndexScoreMapper;
    }

    /**
     * 查询所有的评分模型管理表中已启用的模型数据
     */
    public List<Map<String, Object>> queryAllScoreInfo() {
        return this.pmaFSchemeIndexScoreMapper.queryAllScoreInfo();
    }

    public List<PmaScoreModelParams> queryParamsByModelId(String modelId) {
        return this.pmaFSchemeIndexScoreMapper.queryParamsByModelId(modelId);
    }

    /**
     * 保存考核方案评分模型配置
     * @param vo
     */
    @Transactional(rollbackFor = Exception.class)
    public void saveSchemeIndexScore(PmaSchemeScoreReqVo vo) {
        String schemeId = vo.getSchemeId();
        String indexId = vo.getIndexId();
        String scoreModelId = vo.getScoreModelId();
        this.pmaFSchemeIndexScoreMapper.deleteScoreBySchemeId(schemeId,indexId,vo.getApplyType(),vo.getBalType(),vo.getEvlObjType());
        this.pmaFSchemeIndexScoreMapper.deleteScoreParamByModelId(schemeId,indexId,scoreModelId,vo.getApplyType(),vo.getBalType(),vo.getEvlObjType());
        PmaFSchemeIndexScore pmaFSchemeIndexScore = new PmaFSchemeIndexScore();
        pmaFSchemeIndexScore.setSchemeId(schemeId);
        pmaFSchemeIndexScore.setIndexId(indexId);
        pmaFSchemeIndexScore.setApplyTypeId(vo.getApplyType());
        pmaFSchemeIndexScore.setBalTypeId(vo.getBalType());
        pmaFSchemeIndexScore.setEvlObjType(vo.getEvlObjType());
        pmaFSchemeIndexScore.setCurrency(vo.getCurrency());
        pmaFSchemeIndexScore.setScoreModelId(scoreModelId);
        pmaFSchemeIndexScore.setScoreFormula(vo.getScoreFormula());
        pmaFSchemeIndexScore.setScoreWeight(vo.getScoreWeight());
        pmaFSchemeIndexScore.setId(UUID.randomUUID().toString().replace("-",""));
        Map<String, String> paramMap = vo.getParamMap();
        List<PmaFSchemeIndexScoreParam> pmaFSchemeIndexScoreParamList = new ArrayList<>();
        paramMap.forEach((key,value) ->{
            PmaFSchemeIndexScoreParam pmaFSchemeIndexScoreParam = new PmaFSchemeIndexScoreParam();
            pmaFSchemeIndexScoreParam.setEnName(key);
            pmaFSchemeIndexScoreParam.setParamValue(value);
            pmaFSchemeIndexScoreParam.setSchemeId(schemeId);
            pmaFSchemeIndexScoreParam.setIndexId(indexId);
            pmaFSchemeIndexScoreParam.setApplyTypeId(vo.getApplyType());
            pmaFSchemeIndexScoreParam.setBalTypeId(vo.getBalType());
            pmaFSchemeIndexScoreParam.setEvlObjType(vo.getEvlObjType());
            pmaFSchemeIndexScoreParam.setCurrency(vo.getCurrency());
            pmaFSchemeIndexScoreParam.setScoreModelId(scoreModelId);
            pmaFSchemeIndexScoreParam.setCnName(vo.getCnNameMap().get(key));
            pmaFSchemeIndexScoreParam.setId(UUID.randomUUID().toString().replace("-",""));
            pmaFSchemeIndexScoreParamList.add(pmaFSchemeIndexScoreParam);
        });
        this.pmaFSchemeIndexScoreMapper.insertSelective(pmaFSchemeIndexScore);
        this.pmaFSchemeIndexScoreMapper.batchInsertParams(pmaFSchemeIndexScoreParamList);
    }


    /**
     * 根据考核方案查询评分模型配置
     * @param schemeId
     * @param indexId
     * @return
     */
    public PmaSchemeScoreReqVo queryScoreBySchemeId(String schemeId, String indexId,String applyType, String balType, String evlObjType) {

        PmaSchemeScoreReqVo vo = new PmaSchemeScoreReqVo();
        List<PmaScoreIndexVo> pmaScoreIndexVoList= this.pmaFSchemeIndexScoreMapper.queryScoreBySchemeId(schemeId,indexId,applyType,balType,evlObjType);
        if (!CollectionUtils.isEmpty(pmaScoreIndexVoList)) {
            PmaScoreIndexVo pmaScoreIndexVo = pmaScoreIndexVoList.get(0);
            vo.setScoreFormula(pmaScoreIndexVo.getScoreFormula());
            vo.setScoreModelId(pmaScoreIndexVo.getScoreModelId());
            List<PamScoreParamVo> pamScoreParamVos = this.pmaFSchemeIndexScoreMapper.queryFSchemeScoreParams(schemeId, indexId, pmaScoreIndexVo.getScoreModelId(),applyType,balType,evlObjType);
            if(!CollectionUtils.isEmpty(pamScoreParamVos)){
                Map<String, String> paramMap = pamScoreParamVos.stream().collect(Collectors.toMap(PamScoreParamVo::getEnName, pamScoreParamVo -> {
                    if(StringUtils.isNotBlank(pamScoreParamVo.getParamValue())){
                        return pamScoreParamVo.getParamValue();
                    }else {
                        return "";
                    }
                }));
                Map<String, String> cnNameMap = pamScoreParamVos.stream().collect(Collectors.toMap(PamScoreParamVo::getEnName, PamScoreParamVo::getCnName));
                vo.setParamMap(paramMap);
                vo.setCnNameMap(cnNameMap);
            }
            vo.setScoreWeight(pmaScoreIndexVo.getScoreWeight());
            String totalWeight = this.pmaFSchemeIndexScoreMapper.selectTotalWeight(schemeId);
            vo.setTotalWeight(totalWeight);
        }
        vo.setSchemeId(schemeId);
        vo.setIndexId(indexId);
        return vo;
    }

    public String getTotalWeightBySchemeId(String schemeId){
        String totalWeight = this.pmaFSchemeIndexScoreMapper.selectTotalWeight(schemeId);
        return totalWeight;
    }
}
