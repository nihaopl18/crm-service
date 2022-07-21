package cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.web.rest;

import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.domain.PmaFSchemeIndexScore;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.domain.PmaScoreModelParams;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.domain.vo.PmaSchemeScoreReqVo;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.service.PmaFSchemeIndexScoreService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @description: 考核方案评分模型配置
 * @author: Zhan YongQiang
 * @date: 2022/4/2 15:51
 */
@RestController
@RequestMapping("/api/pmafschemescorerel")
public class PmaFSchemeIndexScoreResource extends CommonResource<PmaFSchemeIndexScore, String> {

    @Autowired
    private PmaFSchemeIndexScoreService pmaFSchemeIndexScoreService;

    @Override
    protected CommonService getCommonService() {
        return pmaFSchemeIndexScoreService;
    }


    @ApiOperation(value = "查询评分模型管理表数据", notes = "查询评分模型管理表数据")
    @GetMapping("/queryAllScoreInfo")
    public ResultDto<List<Map<String, Object>>> queryAllScoreInfo() throws Exception {
        List<Map<String, Object>> list = this.pmaFSchemeIndexScoreService.queryAllScoreInfo();
        return new ResultDto<>(list);
    }

    @ApiOperation(value = "查询评分模型使用的参数", notes = "查询评分模型使用的参数")
    @GetMapping("/queryParamsByModelId")
    public ResultDto<List<PmaScoreModelParams>> queryParamsByModelId(String modelId) throws Exception {
        List<PmaScoreModelParams> list = this.pmaFSchemeIndexScoreService.queryParamsByModelId(modelId);
        return new ResultDto<>(list);
    }

    @ApiOperation(value = "考核方案评分模型配置保存", notes = "考核方案评分模型配置保存")
    @PostMapping("/saveSchemeIndexScore")
    public ResultDto<Void> saveSchemeIndexScore(@RequestBody PmaSchemeScoreReqVo vo){
        this.pmaFSchemeIndexScoreService.saveSchemeIndexScore(vo);
        return new ResultDto<Void>();
    }


    @ApiOperation(value = "根据考核方案ID查询已配置的评分模型", notes = "根据考核方案ID查询已配置的评分模型")
    @GetMapping("/queryScoreModelBySchemeId")
    public ResultDto<PmaSchemeScoreReqVo> queryScoreModelBySchemeId(String schemeId,String indexId, String applyType, String balType, String evlObjType) throws Exception {

        PmaSchemeScoreReqVo vo= this.pmaFSchemeIndexScoreService.queryScoreBySchemeId(schemeId,indexId,applyType,balType,evlObjType);
        return new ResultDto<>(vo);
    }

    @ApiOperation(value = "根据考核方案ID查询已配置的评分模型的权重之和", notes = "根据考核方案ID查询已配置的评分模型的权重之和")
    @GetMapping("/queryTotalWeightBySchemeId")
    public ResultDto<String> queryTotalWeightBySchemeId(String schemeId) throws Exception {

        String totalWeight= this.pmaFSchemeIndexScoreService.getTotalWeightBySchemeId(schemeId);
        return new ResultDto<>(totalWeight);
    }

}
