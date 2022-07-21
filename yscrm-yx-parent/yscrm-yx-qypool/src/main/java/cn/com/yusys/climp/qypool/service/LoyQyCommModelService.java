package cn.com.yusys.climp.qypool.service;

import cn.com.yusys.climp.qypool.domain.LoyQyCommModel;
import cn.com.yusys.climp.qypool.domain.LoyQyCommModelStorage;
import cn.com.yusys.climp.qypool.repository.mapper.LoyQyCommModelMapper;
import cn.com.yusys.climp.qypool.repository.mapper.LoyQyCommModelStorageMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.security.SecurityUtils;
import cn.com.yusys.yusp.commons.service.CommonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version 1.0.0
 * @项目名称: yusp-climp-qypool-core模块
 * @类名称: LoyQyCommModelService
 * @类描述: #服务类
 * @功能描述:
 * @创建人: chenlin
 * @创建时间: 2019-02-26 14:40:00
 * @修改备注:
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class LoyQyCommModelService extends CommonService {
    private Logger logger = LoggerFactory.getLogger(LoyQyCommModelService.class);

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private LoyQyCommModelMapper loyQyCommModelMapper;
    @Autowired
    private LoyQyCommModelStorageMapper loyQyCommModelStorageMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return loyQyCommModelMapper;
    }

    /**
     * @方法名称:getModel
     * @方法描述:根据商品编号查询商品规格
     * @参数与返回说明:
     * @算法描述:
     */
    public List<LoyQyCommModel> getModel(String commodityCode) {
        List<LoyQyCommModel> list = loyQyCommModelMapper.getModel(commodityCode);
        return list;
    }

    /**
     * @方法名称:getOrgCode
     * @方法描述:获取登录用户的机构号
     * @参数与返回说明:
     * @算法描述:
     */
    public String getOrgCode() {
        //ResponseEntity<UserInfoDTO> dto = clientService.getUserSessionInfo(HeaderUtil.getAccessToken());
        //String orgCode = dto.getBody().getOrg().getCode();
        //User user = userInfoService.getOrgCode();
        return userInfoService.getOrgCode();
    }

    /**
     * @方法名称:getDate2String
     * @方法描述:获取String时间
     * @参数与返回说明:
     * @算法描述:
     */
    public String getDate2String(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
        return df.format(date);
    }

    /**
     * 商品规格新增
     */
    @Override
    public int insert(Object record) {
        LoyQyCommModel model = (LoyQyCommModel) record;
        String loginCode = SecurityUtils.getCurrentUserLogin();
        // TODO 自动生成的方法存根
        model.setCreateDate(getDate2String(new Date()));
        model.setCreateOrg(getOrgCode());
        model.setCreateUser(loginCode);
        model.setUpdateDate(getDate2String(new Date()));
        model.setUpdateOrg(getOrgCode());
        model.setUpdateUser(loginCode);
        model.setDefaultModel("1");
        model.setModelSalNum(BigDecimal.ZERO);
        logger.info("商品规格新增数据：【新增规格参数：" + model.getModelParam() + "】 " + getDate2String(new Date()));
        loyQyCommModelMapper.updateCommodityStNum(model.getCommId(),"10",model.getModelStgNum());
        int result = super.insertSelective(model);
        LoyQyCommModelStorage loyQyCommModelStorage = new LoyQyCommModelStorage();
        loyQyCommModelStorage.setCommId(model.getCommId());
        loyQyCommModelStorage.setModelId(model.getId());
        loyQyCommModelStorage.setStorageMgType("10");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        try {
            now = df.parse(df.format(now));
        }catch (Exception e){
            logger.error("日期格式化错误");
        }
        loyQyCommModelStorage.setMgCount(model.getModelStgNum());
        loyQyCommModelStorage.setUpdateDate(now);
        loyQyCommModelStorage.setUpdateOrg(userInfoService.getOrgId());
        loyQyCommModelStorage.setUpdateUser(userInfoService.getLoginCode());
        loyQyCommModelStorage.setRemark("首次设置库存");
        this.insertSelective(loyQyCommModelStorageMapper,loyQyCommModelStorage);
        return result;
    }

    /**
     * 商品规格修改
     */
    @Override
    public int update(Object record) {
        LoyQyCommModel model = (LoyQyCommModel) record;
        String loginCode = SecurityUtils.getCurrentUserLogin();
//        // TODO 自动生成的方法存根
        model.setUpdateDate(getDate2String(new Date()));
        model.setUpdateOrg(getOrgCode());
        model.setUpdateUser(loginCode);
        logger.info("商品信息修改数据：【修改规格参数：" + model.getModelParam() + "】的相关数据； " + getDate2String(new Date()));
        return super.updateSelective(model);
    }

    /**
     * @方法名称:delModel
     * @方法描述:商品规格删除
     * @参数与返回说明:
     * @算法描述:
     */
    public int delModel(String[] modelIds) {
        int count = 0;
        String commodityCode = "";//商品编码
        boolean delDefaultMod = false;//是否删除了默认规格，是：true，否：false
        for (int i = 0; i < modelIds.length; i++) {
            if (modelIds[i] != null && modelIds[i] != "") {
                LoyQyCommModel model = loyQyCommModelMapper.selectByPrimaryKey(modelIds[i]);
                commodityCode = model.getCommId();
                model.setDeleteSts("1");
                count = count + super.updateSelective(model);
                //defaultModel字段值为1，表示是默认规格
                if ("1".equals(model.getDefaultModel())) {
                    delDefaultMod = true;
                }
            }
        }
        //如果删除的规格时默认规格，那么需要将商品信息表中的规格现金价值、规格积分价值两个字段清空
        if (delDefaultMod) {
            Map<String, Object> map = new HashMap<>();
            map.put("commodityCode", commodityCode);
            map.put("modelMvalue", "");
            map.put("modelLvalue", "");
            loyQyCommModelMapper.updateCommMLValue(map);
        }
//        loyQyCommModelMapper.updateCommodityStNum(commodityCode);
        logger.info("礼品批量删除  【主键：" + modelIds + "】 " + getDate2String(new Date()));
        return count;
    }

    /**
     * @方法名称:delGiftModel
     * @方法描述:礼品品规格删除
     * @参数与返回说明: modelIds-规格id列表 count-已删除规格数量
     * @算法描述: 礼品管理中对礼品规格删除，已售出的规格不可删除
     */
    public int delGiftModel(String[] modelIds) {
        int count = 0;
        for (int i = 0; i < modelIds.length; i++) {
            LoyQyCommModel model = loyQyCommModelMapper.selectByPrimaryKey(modelIds[i]);
            if (model.getModelSalNum().compareTo(BigDecimal.ZERO) == 0 ) {
                loyQyCommModelMapper.updateCommodityStNum(model.getCommId(),"20",model.getModelStgNum());
                model.setDeleteSts("1");
                count = count + super.updateSelective(model);
                LoyQyCommModelStorage loyQyCommModelStorage = new LoyQyCommModelStorage();
                loyQyCommModelStorage.setCommId(model.getCommId());
                loyQyCommModelStorage.setModelId(model.getId());
                loyQyCommModelStorage.setStorageMgType("20");
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date now = new Date();
                try {
                    now = df.parse(df.format(now));
                }catch (Exception e){
                    logger.error("日期格式化错误");
                }
                loyQyCommModelStorage.setMgCount(model.getModelStgNum());
                loyQyCommModelStorage.setUpdateDate(now);
                loyQyCommModelStorage.setUpdateOrg(userInfoService.getOrgId());
                loyQyCommModelStorage.setUpdateUser(userInfoService.getLoginCode());
                loyQyCommModelStorage.setRemark("删除规格");
                this.insertSelective(loyQyCommModelStorageMapper,loyQyCommModelStorage);
            } else {
                break;
            }
        }
        return count;
    }

    /**
     * @方法名称:defaultModel
     * @方法描述:默认规格
     * @参数与返回说明:
     * @算法描述:
     */
    public int defaultModel(String id) {
        LoyQyCommModel model = loyQyCommModelMapper.selectByPrimaryKey(id);
        model.setDefaultModel("1");
        Map<String, Object> map = new HashMap<>();
        map.put("commodityCode", model.getCommId());
        map.put("modelMvalue", model.getModelMvalue());
        map.put("modelLvalue", model.getModelLvalue());
        loyQyCommModelMapper.updateCommMLValue(map);
        return super.updateSelective(model);
    }

    /**
     * @方法名称:modelParamQuery
     * @方法描述:商品规格查询
     * @参数与返回说明:
     * @算法描述:
     */
    public List<Map<String, Object>> modelParamQuery(String commodityCode) {
        return loyQyCommModelMapper.modelParamQuery(commodityCode);
    }

    public Integer updateModel(LoyQyCommModelStorage loyQyCommModelStorage) throws Exception{
        int num = 0;
        num = loyQyCommModelMapper.updateCommodityStNum(loyQyCommModelStorage.getCommId(),loyQyCommModelStorage.getStorageMgType(),loyQyCommModelStorage.getMgCount());
        num = loyQyCommModelMapper.updateNum(loyQyCommModelStorage.getModelId(),loyQyCommModelStorage.getStorageMgType(),loyQyCommModelStorage.getMgCount());
        if (!"30".equals(loyQyCommModelStorage.getStorageMgType())){
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            loyQyCommModelStorage.setUpdateDate(df.parse(df.format(new Date())));
            loyQyCommModelStorage.setUpdateOrg(userInfoService.getOrgId());
            loyQyCommModelStorage.setUpdateUser(userInfoService.getLoginCode());
            num = this.insertSelective(loyQyCommModelStorageMapper,loyQyCommModelStorage);
        }
        return num;
    }
}
