package cn.com.yusys.climp.score.service;

import cn.com.yusys.climp.cust.repository.mapper.LoyCmCustInfoMapper;
import cn.com.yusys.climp.qypool.domain.*;
import cn.com.yusys.climp.qypool.repository.mapper.LoyAcOrderListMapper;
import cn.com.yusys.climp.qypool.repository.mapper.LoyQyCommModelMapper;
import cn.com.yusys.climp.qypool.service.LoyAcOrderListService;
import cn.com.yusys.climp.qypool.service.LoyQyCommModelService;
import cn.com.yusys.climp.qypool.service.LoyQyCommodityInfoService;
import cn.com.yusys.climp.qypool.service.UserInfoService;
import cn.com.yusys.climp.score.domain.ExcelImport;
import cn.com.yusys.climp.score.domain.ScoreExch;
import cn.com.yusys.climp.score.domain.ScoreGame;
import cn.com.yusys.climp.score.repository.mapper.ExcelImportMapper;
import cn.com.yusys.climp.score.repository.mapper.ScoreAdjustMapper;
import cn.com.yusys.climp.score.repository.mapper.ScoreGameMapper;
import cn.com.yusys.climp.utils.file.ExeclParseUtil;
import cn.com.yusys.climp.utils.file.FileUtil;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @项目名称: yusp-climp-acct模块
 * @类名称: AccountTarService
 * @类描述: #服务类
 * @功能描述:
 * @创建人: Administrator
 * @创建时间: 2018-12-27 10:50:42
 * @修改备注:
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class ScoreAdjustService extends CommonService {
    private Logger logger = LoggerFactory.getLogger(ScoreAdjustService.class);
    private SimpleDateFormat s = new SimpleDateFormat("yyyyMMddHHmmSSS");
    private SimpleDateFormat s1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private SimpleDateFormat s2 = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    private LoyQyCommodityInfoService loyQyCommodityInfoService;
    @Autowired
    private LoyAcOrderListService loyAcOrderListService;
    @Autowired
    private LoySrScoreAccuteSumService loySrScoreAccuteSumService;
    @Autowired
    private LoyQyCommModelService loyQyCommModelService;
    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private LoyCmCustInfoMapper loyCmCustInfoMapper;
    @Autowired
    private ScoreAdjustMapper scoreAdjustMapper;
    @Autowired
    private LoyAcOrderListMapper loyAcOrderListMapper;
    @Autowired
    private LoyQyCommModelMapper loyQyCommModelMapper;
    @Autowired
    private ScoreGameMapper scoreGameMapper;
    @Autowired
    private ExcelImportMapper excelImportMapper;

    @Autowired
    RedissonClient redissonClient;

    @Override
    protected CommonMapper getMapper() {
        return null;
    }

    ResultDto<ScoreExch> rs = new ResultDto<>();

    /**
     * 积分兑换
     * @param scoreExch
     * @return
     */
    public ResultDto<ScoreExch> scoreExch(ScoreExch scoreExch) throws Exception{
        logger.info("开始兑换订单");
        if (scoreExch.getOnline()){
            Map<String,Object> map = new HashMap<>();
            map.put("CUST_ID",scoreExch.getNdsCustId());
            map.put("SYSTEM_ID",scoreExch.getSystemId());
            String ecif_cust_no = loyAcOrderListMapper.getEcifNo(map);
            if (ecif_cust_no == null || "".equals(ecif_cust_no)){
                rs.setCode(-1);
                rs.setMessage("1007@该NDS客户号未查询ECIF客户号");
                rs.setData(scoreExch);
                return rs;
            }
            scoreExch.setCustId(ecif_cust_no);
        }
        if (scoreExch.getCustId() == null || "".equals(scoreExch.getCustId())){
            logger.info("客户号为空");
            rs.setCode(-1);
            rs.setMessage("0027@客户号为空");
            rs.setData(scoreExch);
            return rs;
        }
        if (scoreExch.getOrderChannel() == null || "".equals(scoreExch.getOrderChannel()) || "40".equals(scoreExch.getOrderChannel())){
            logger.info("订单兑换渠道为空");
            rs.setCode(-1);
            rs.setMessage("0028@订单兑换渠道为空");
            rs.setData(scoreExch);
            return rs;
        }
        if (scoreExch.getChangeCount() == null || scoreExch.getChangeCount() == 0){
            logger.info("礼遇兑换数量为零");
            rs.setCode(-1);
            rs.setMessage("0024@礼遇兑换数量不能为零");
            rs.setData(scoreExch);
            return rs;
        }
        if (scoreExch.getCommodityCode() == null || "".equals(scoreExch.getCommodityCode())){
            logger.info("礼遇编号为空");
            rs.setCode(-1);
            rs.setMessage("0025@礼遇编号为空");
            rs.setData(scoreExch);
            return rs;
        }

        String date = scoreExch.getOderDt() == null ? "" : scoreExch.getOderDt();
        if ("".equals(date)){
            date = s1.format(new Date());
        }
        scoreExch.setOderDt(date);

        modelDeduct(scoreExch);//库存扣减
        if (rs.getCode() != 0){
            throw new Exception();
        }
        scoreDeduct(scoreExch);//积分扣减
        if (rs.getCode() != 0){
            throw new Exception();
        }
        addOrder(scoreExch);//保存订单
        if (rs.getCode() != 0){
            throw new Exception();
        }
        rs.setData(scoreExch);
        return rs;
    }

    /**
     * 商品库存扣减
     * @param scoreExch
     */
    private void modelDeduct(ScoreExch scoreExch) throws Exception{
        rs.setCode(-1);
        String custNo = scoreExch.getCustId();//客户号
        if ("".equals(custNo)){
            logger.info("客户号为空");
            rs.setMessage("0027@客户号为空");
            return;
        }
        String commodity_code = scoreExch.getCommodityCode();//商品编号
        if ("".equals(commodity_code)){
            logger.info("礼遇编号为空");
            rs.setMessage("0025@礼遇编号为空");
            return;
        }else {
            List<LoyQyCommodityInfo> loyQyCommodityInfos = loyQyCommodityInfoService.getCommodityById(commodity_code);//商品信息
            if (loyQyCommodityInfos == null || loyQyCommodityInfos.size() == 0){
                logger.info("商品不存在");
                rs.setMessage("0029@商品不存在");
                return;
            }else if (loyQyCommodityInfos.size() > 1){
                logger.info("商品不唯一");
                rs.setMessage("0040@商品不唯一");
                return;
            }else {
                LoyQyCommodityInfo loyQyCommodityInfo = loyQyCommodityInfos.get(0);
                String id = loyQyCommodityInfo.getId() == null ? "" : loyQyCommodityInfo.getId();//商品id
                if ("".equals(id)){
                    logger.info("商品Id为空");
                    rs.setMessage("0030@商品Id为空");
                    return;
                }
                scoreExch.setCommodityId(id);
                scoreExch.setCommodityDescTemp(loyQyCommodityInfo.getCommodityDescTemp());

                String up_down_state = loyQyCommodityInfo.getUpDownState() == null ? "" : loyQyCommodityInfo.getUpDownState();//商品状态
                if ("".equals(up_down_state) || "10".equals(up_down_state) || "30".equals(up_down_state)){
                    logger.info("商品状态不可兑换");
                    rs.setMessage("0031@商品状态不可兑换");
                    return;
                }

                String excg_channel = loyQyCommodityInfo.getExcgChannel() == null ? "" : loyQyCommodityInfo.getExcgChannel();//商品可兑换渠道
                if ("".equals(excg_channel)){
                    logger.info("商品可兑换渠道为空");
                    rs.setMessage("0032@商品可兑换渠道为空");
                    return;
                }else {
                    String order_channel = scoreExch.getOrderChannel();//兑换渠道
                    if ("".equals(order_channel) || "40".equals(order_channel)){
                        logger.info("订单兑换渠道为空");
                        rs.setMessage("0028@订单兑换渠道为空");
                        return;
                    }else if ("10".equals(order_channel) || "20".equals(order_channel) || "30".equals(order_channel)){
                        if (!excg_channel.contains(order_channel)){
                            logger.info("该系统无法兑换此商品");
                            rs.setMessage("0033@该系统无法兑换此商品");
                            return;
                        }
                    }else {
                        logger.info("订单渠道非法");
                        rs.setMessage("1044@订单渠道非法");
                        return;
                    }
                }

                String suit_obj_type = loyQyCommodityInfo.getSuitObjType();//商品适用客户评级类型
                String suit_cust_grade = loyQyCommodityInfo.getSuitCustType();//适用客户评级级别
                Map<String,String> cust_grade = scoreAdjustMapper.getCustGrade(custNo);
                if ("10".equals(suit_obj_type)) {
                    if (cust_grade.get("aumGrade") == null || "".equals(cust_grade.get("aumGrade"))){
                        logger.info("客户AUM评级为空");
                        rs.setMessage("0037@客户AUM评级为空");
                        return;
                    }else if (!suit_cust_grade.contains(cust_grade.get("aumGrade"))){
                        logger.info("客户AUM评级无法兑换此商品");
                        rs.setMessage("0037@客户AUM评级无法兑换此商品");
                        return;
                    }
                }else if ("20".equals(suit_obj_type)){
                    if (cust_grade.get("quartContrGrade") == null || "".equals(cust_grade.get("quartContrGrade"))){
                        logger.info("客户贡献度评级为空");
                        rs.setMessage("0038@客户贡献度评级为空");
                        return;
                    }else if (!suit_cust_grade.contains(cust_grade.get("quartContrGrade"))){
                        logger.info("客户贡献度评级无法兑换此商品");
                        rs.setMessage("0038@客户贡献度评级无法兑换此商品");
                        return;
                    }
                }

                RLock rLock_p = redissonClient.getLock(scoreExch.getCommodityId());
                try{
                    // 为key加一个过期时间
                    boolean flag_p = rLock_p.tryLock(500,1000, TimeUnit.SECONDS);
                    if (flag_p) {
                        logger.info(scoreExch.getCommodityId() + " 抢锁成功");
                        LoyQyCommModel loyQyCommModel = loyQyCommModelMapper.getStgNum(scoreExch.getCommodityId(),scoreExch.getModelId());
                        scoreExch.setModelId(loyQyCommModel.getId());
                        int number = scoreExch.getChangeCount();//兑换数量
                        scoreExch.setDeduScore(loyQyCommodityInfo.getCommodityLValue().multiply(new BigDecimal(number)));//兑换所需积分
                        scoreExch.setMoneyNum(loyQyCommodityInfo.getCommodityMValue().multiply(new BigDecimal(number)));//兑换现金价值
                        if ("0".equals(number)){
                            logger.info("礼遇兑换数量为零");
                            rs.setMessage("0024@礼遇兑换数量不能为零");
                            return;
                        }else if (loyQyCommModel == null || loyQyCommModel.getModelStgNum().compareTo(new BigDecimal(number)) == -1){
                            logger.info("礼遇数量不足");
                            rs.setMessage("0004@礼遇数量不足");
                            return;
                        }else if (loyQyCommodityInfo.getChangeTimes() != null && !"".equals(loyQyCommodityInfo.getChangeTimes())
                                && loyQyCommodityInfo.getChangeTimes().compareTo(new BigDecimal(number)) == -1){
                            logger.info("礼遇兑换数量大于最大单次可兑换数量");
                            rs.setMessage("0035@礼遇兑换数量大于最大单次可兑换数量");
                            return;
                        }
                        LoyQyCommModelStorage loyQyCommModelStorage = new LoyQyCommModelStorage();
                        loyQyCommModelStorage.setModelId(scoreExch.getModelId());
                        loyQyCommModelStorage.setCommId(scoreExch.getCommodityId());
                        loyQyCommModelStorage.setStorageMgType("30");
                        loyQyCommModelStorage.setMgCount(new BigDecimal(scoreExch.getChangeCount()));
                        loyQyCommModelService.updateModel(loyQyCommModelStorage);
                        rs.setCode(0);
                    }else {
                        // 加锁失败
                        logger.info(scoreExch.getCommodityId() + " 抢锁失败");
                    }
                }finally {
                    if (rLock_p != null && rLock_p.isHeldByCurrentThread()){
                        rLock_p.unlock();
                    }
                }
            }
        }
    }

    /**
     * 积分扣减
     * @param scoreExch
     * @throws Exception
     */
    private void scoreDeduct(ScoreExch scoreExch) throws Exception{
        String custNo = scoreExch.getCustId();//客户号
        rs.setCode(-1);
        if ("".equals(custNo)){
            logger.info("客户号为空");
            rs.setMessage("0027@客户号为空");
            return;
        }
        RLock rLock_c = redissonClient.getLock(scoreExch.getCustId());
        try{
            boolean flag_c = rLock_c.tryLock(500,1000, TimeUnit.SECONDS);
            if (flag_c) {
                logger.info(scoreExch.getCustId() + " 抢锁成功");
                Integer scoreNum = loyCmCustInfoMapper.getScoreNum(scoreExch.getCustId(),scoreExch.getDeduScore().toString());
                if (scoreNum == null){
                    logger.info("积分数量不足");
                    rs.setMessage("0002@积分数量不足");
                    return;
                }
                scoreExch.setScoreSum(new BigDecimal(scoreNum));
                String scdId = loySrScoreAccuteSumService.scoreDeduct(scoreExch);
                scoreExch.setScdId(scdId);
                rs.setCode(0);
            }else {
                // 加锁失败
                logger.info(scoreExch.getCustId() + " 抢锁失败");
            }
        }finally {
            if (rLock_c != null && rLock_c.isHeldByCurrentThread()){
                rLock_c.unlock();
            }
        }
    }

    /**
     * 积分兑换-订单保存
     * @param scoreExch
     */
    private void addOrder(ScoreExch scoreExch) throws Exception{
        rs.setCode(-1);
        if (scoreExch.getOrderChannel() == null || "".equals(scoreExch.getOrderChannel()) || "40".equals(scoreExch.getOrderChannel())){
            logger.info("订单兑换渠道为空");
            rs.setMessage("0028@订单兑换渠道为空");
            return;
        }else if ("10".equals(scoreExch.getOrderChannel())){
            scoreExch.setOrderCode("CRM" + s.format(new Date()));
        }
        if (scoreExch.getOrderCode() == null || "".equals(scoreExch.getOrderCode())){
            logger.info("订单编号为空");
            rs.setMessage("1026@订单编号为空");
            return;
        }else {
            List<String> list = loyAcOrderListMapper.getOrderId(scoreExch.getOrderCode());
            if (list != null && list.size() > 0){
                logger.info("订单已经存在");
                rs.setMessage("1026@订单已经存在");
                return;
            }
        }
        StringBuilder extendDesc = new StringBuilder();
        if (scoreExch.getExtendArr() != null && scoreExch.getExtendArr().size() > 0) {
            scoreExch.getExtendArr().forEach(loyAcOrderExAttr -> {
                loyAcOrderExAttr.setOrderNo(scoreExch.getOrderCode());
                extendDesc.append(loyAcOrderExAttr.getAttrRemark()).append(":").append(loyAcOrderExAttr.getAttrDesc()).append(";");
            });
        }
        Map<String,String> userInfo = scoreAdjustMapper.getMgrInfo(scoreExch.getCustId());

        loyAcOrderListService.addOrderAttr(scoreExch.getExtendArr());//保存订单属性
        LoySrExchSerial loySrExchSerial = new LoySrExchSerial();
        loySrExchSerial.setOrderNo(scoreExch.getOrderCode());
        loySrExchSerial.setOrderDt(s1.parse(scoreExch.getOderDt()));
        loySrExchSerial.setCustNo(scoreExch.getCustId());
        loySrExchSerial.setOrderChannel(scoreExch.getOrderChannel());
        loySrExchSerial.setSumScore(scoreExch.getDeduScore());
        loySrExchSerial.setSumCharge(scoreExch.getMoneyNum());
        loySrExchSerial.setExtendDesc(extendDesc.toString());
        loySrExchSerial.setScdId(scoreExch.getScdId());
        loySrExchSerial.setOperatorCode(userInfo.get("mgrId"));
        loySrExchSerial.setOperateOrg(userInfo.get("orgId"));
        if ("10".equals(scoreExch.getOrderChannel())){
            loySrExchSerial.setAppStatus("1");
        }
        loyAcOrderListService.addOrder(loySrExchSerial);

        rs.setCode(-1);
        Map<String,String> map = new HashMap<>();
        map.put("id",scoreExch.getCommodityId());
        map.put("custNo",scoreExch.getCustId());
        String rate = scoreExch.getChangeFeq();
        map.put("rate",rate);
        String times = loyAcOrderListMapper.getTimes(map);
        if (times != null && !"0".equals(times)){
            if ("10".equals(rate)){
                logger.info("此礼遇每年只能兑换一次");
                rs.setMessage("0036@此礼遇每年只能兑换一次");
                return;
            }else if ("20".equals(rate)){
                logger.info("此礼遇每半年只能兑换一次");
                rs.setMessage("0036@此礼遇每半年只能兑换一次");
                return;
            }else if ("30".equals(rate)){
                logger.info("此礼遇每季度只能兑换一次");
                rs.setMessage("0036@此礼遇每季度只能兑换一次");
                return;
            }else if ("40".equals(rate)){
                logger.info("此礼遇每月只能兑换一次");
                rs.setMessage("0036@此礼遇每月只能兑换一次");
                return;
            }
        }
        LoyAcOrderList loyAcOrderList = new LoyAcOrderList();
        loyAcOrderList.setOrderNo(scoreExch.getOrderCode());
        loyAcOrderList.setCommodityID(scoreExch.getCommodityId());
        loyAcOrderList.setModelId(scoreExch.getModelId());
        loyAcOrderList.setOrderDesc(getOrderDesc(scoreExch,userInfo));
        loyAcOrderList.setCommodityNumber(scoreExch.getChangeCount());
        loyAcOrderListService.addOrderInfo(loyAcOrderList);
        rs.setCode(0);
    }

    /**
     * 获取礼遇适用说明
     * @param scoreExch
     * @return
     */
    private String getOrderDesc(ScoreExch scoreExch,Map<String,String> userInfo) {
        String desc = scoreExch.getCommodityDescTemp();
        if (desc != null && !"".equals(desc)){
            desc.replace("@TPHONE",userInfo.get("userMobilephone") == null ? "" : userInfo.get("userMobilephone"))
                    .replace("@USER",userInfo.get("userName") == null ? "" : userInfo.get("userName"))
                    .replace("@ORG",userInfo.get("orgName") == null ? "" : userInfo.get("orgName"));
        }
        return desc;
    }

    /**
     * 是否可以兑换
     * @param scoreExch
     * @return
     */
    private boolean isChange(ScoreExch scoreExch) throws Exception{
        if (scoreExch.getOnline()){
            Map<String,Object> map = new HashMap<>();
            map.put("CUST_ID",scoreExch.getNdsCustId());
            map.put("SYSTEM_ID",scoreExch.getSystemId());
            String ecif_cust_no = loyAcOrderListMapper.getEcifNo(map);
            if (ecif_cust_no == null || "".equals(ecif_cust_no)){
                rs.setCode(1007);
                rs.setMessage("该NDS客户号未查询ECIF客户号");
                return false;
            }
            scoreExch.setCustId(ecif_cust_no);
        }
        rs.setCode(-1);
        Map<String,String> cust_grade = null;
        String custNo = scoreExch.getCustId();//客户号
        if ("".equals(custNo)){
            logger.info("客户号为空");
            rs.setMessage("0027@客户号为空");
            return false;
        }
        cust_grade = scoreAdjustMapper.getCustGrade(custNo);

        String commodity_code = scoreExch.getCommodityCode();//商品编号
        if ("".equals(commodity_code)){
            logger.info("礼遇编号为空");
            rs.setMessage("0025@礼遇编号为空");
            return false;
        }else {
            List<LoyQyCommodityInfo> loyQyCommodityInfos = loyQyCommodityInfoService.getCommodityById(commodity_code);//商品信息
            if (loyQyCommodityInfos == null || loyQyCommodityInfos.size() == 0){
                logger.info("商品不存在");
                rs.setMessage("0029@商品不存在");
                return false;
            }else if (loyQyCommodityInfos.size() > 1){
                logger.info("商品不唯一");
                rs.setMessage("0040@商品不唯一");
                return false;
            }else {
                LoyQyCommodityInfo loyQyCommodityInfo = loyQyCommodityInfos.get(0);
                String id = loyQyCommodityInfo.getId() == null ? "" : loyQyCommodityInfo.getId();//商品id
                if ("".equals(id)){
                    logger.info("商品Id为空");
                    rs.setMessage("0030@商品Id为空");
                    return false;
                }
                scoreExch.setCommodityId(id);
                scoreExch.setCommodityDescTemp(loyQyCommodityInfo.getCommodityDescTemp());

                String up_down_state = loyQyCommodityInfo.getUpDownState() == null ? "" : loyQyCommodityInfo.getUpDownState();//商品状态
                if ("".equals(up_down_state) || "10".equals(up_down_state) || "30".equals(up_down_state)){
                    logger.info("商品状态不可兑换");
                    rs.setMessage("0031@商品状态不可兑换");
                    return false;
                }

                String excg_channel = loyQyCommodityInfo.getExcgChannel() == null ? "" : loyQyCommodityInfo.getExcgChannel();//商品可兑换渠道
                if ("".equals(excg_channel)){
                    logger.info("商品可兑换渠道为空");
                    rs.setMessage("0032@商品可兑换渠道为空");
                    return false;
                }else {
                    String order_channel = scoreExch.getOrderChannel();//兑换渠道
                    if ("".equals(order_channel) || "40".equals(order_channel)){
                        logger.info("订单兑换渠道为空");
                        rs.setMessage("0028@订单兑换渠道为空");
                        return false;
                    }else if ("10".equals(order_channel) || "20".equals(order_channel) || "30".equals(order_channel)){
                        if (!excg_channel.contains(order_channel)){
                            logger.info("该系统无法兑换此商品");
                            rs.setMessage("0033@该系统无法兑换此商品");
                            return false;
                        }else if ("10".equals(order_channel)){
                            scoreExch.setOrderCode("CRM" + s.format(new Date()));
                        }
                    }else {
                        logger.info("订单渠道非法");
                        rs.setMessage("1044@订单渠道非法");
                        return false;
                    }
                }

                Map<String,String> map = new HashMap<>();
                String rate = loyQyCommodityInfo.getChangeFeq() == null ? "" : loyQyCommodityInfo.getChangeFeq();
                map.put("id",id);
                map.put("custNo",custNo);
                map.put("rate",rate);
                String times = loyAcOrderListMapper.getTimes(map);
                if (times != null && !"0".equals(times)){
                    if ("10".equals(rate)){
                        logger.info("此礼遇每年只能兑换一次");
                        rs.setMessage("0036@此礼遇每年只能兑换一次");
                        return false;
                    }else if ("20".equals(rate)){
                        logger.info("此礼遇每半年只能兑换一次");
                        rs.setMessage("0036@此礼遇每半年只能兑换一次");
                        return false;
                    }else if ("30".equals(rate)){
                        logger.info("此礼遇每季度只能兑换一次");
                        rs.setMessage("0036@此礼遇每季度只能兑换一次");
                        return false;
                    }else if ("40".equals(rate)){
                        logger.info("此礼遇每月只能兑换一次");
                        rs.setMessage("0036@此礼遇每月只能兑换一次");
                        return false;
                    }
                }

                String suit_obj_type = loyQyCommodityInfo.getSuitObjType();//商品适用客户评级类型
                String suit_cust_grade = loyQyCommodityInfo.getSuitCustType();//适用客户评级级别
                if ("10".equals(suit_obj_type)) {
                    if (cust_grade.get("aumGrade") == null || "".equals(cust_grade.get("aumGrade"))){
                        logger.info("客户AUM评级为空");
                        rs.setMessage("0037@客户AUM评级为空");
                        return false;
                    }else if (!suit_cust_grade.contains(cust_grade.get("aumGrade"))){
                        logger.info("客户AUM评级无法兑换此商品");
                        rs.setMessage("0037@客户AUM评级无法兑换此商品");
                        return false;
                    }
                }else if ("20".equals(suit_obj_type)){
                    if (cust_grade.get("quartContrGrade") == null || "".equals(cust_grade.get("quartContrGrade"))){
                        logger.info("客户贡献度评级为空");
                        rs.setMessage("0038@客户贡献度评级为空");
                        return false;
                    }else if (!suit_cust_grade.contains(cust_grade.get("quartContrGrade"))){
                        logger.info("客户贡献度评级无法兑换此商品");
                        rs.setMessage("0038@客户贡献度评级无法兑换此商品");
                        return false;
                    }
                }

                LoyQyCommModel loyQyCommModel = loyQyCommModelMapper.getStgNum(scoreExch.getCommodityId(),scoreExch.getModelId());
                int number = scoreExch.getChangeCount();//兑换数量
                if ("0".equals(number)){
                    logger.info("礼遇兑换数量为零");
                    rs.setMessage("0024@礼遇兑换数量不能为零");
                    return false;
                }else if (loyQyCommModel == null || loyQyCommModel.getModelStgNum().compareTo(new BigDecimal(number)) == -1){
                    logger.info("礼遇数量不足");
                    rs.setMessage("0004@礼遇数量不足");
                    return false;
                }else if (loyQyCommodityInfo.getChangeTimes() != null && !"".equals(loyQyCommodityInfo.getChangeTimes())
                && loyQyCommodityInfo.getChangeTimes().compareTo(new BigDecimal(number)) == -1){
                    logger.info("礼遇兑换数量大于最大单次可兑换数量");
                    rs.setMessage("0035@礼遇兑换数量大于最大单次可兑换数量");
                    return false;
                }

                scoreExch.setModelId(loyQyCommModel.getId());
                scoreExch.setDeduScore(loyQyCommodityInfo.getCommodityLValue().multiply(new BigDecimal(number)));//兑换所需积分
                Integer scoreNum = loyCmCustInfoMapper.getScoreNum(scoreExch.getCustId(),scoreExch.getDeduScore().toString());
                if (scoreNum == null){
                    logger.info("积分数量不足");
                    rs.setCode(-1);
                    rs.setMessage("0002@积分数量不足");
                    return false;
                }
                scoreExch.setMoneyNum(loyQyCommodityInfo.getCommodityMValue().multiply(new BigDecimal(number)));//兑换现金价值
                scoreExch.setScoreSum(new BigDecimal(scoreNum));
            }
        }

        String order_code = scoreExch.getOrderCode();//订单编号
        if ("".equals(order_code)){
            logger.info("订单编号为空");
            rs.setMessage("1026@订单编号为空");
            return false;
        }else {
            List<String> list = loyAcOrderListMapper.getOrderId(order_code);
            if (list != null && list.size() > 0){
                logger.info("订单已经存在");
                rs.setMessage("1026@订单已经存在");
                return false;
            }
        }
        String date = scoreExch.getOderDt() == null ? "" : scoreExch.getOderDt();
        if ("".equals(date)){
            date = s1.format(new Date());
        }
        scoreExch.setOderDt(date);
        rs.setCode(0);
        return true;
    }

    /* 名单制积分 */
    public Map<String, String> excelCheck(MultipartFile mfile) {
        String[] ary = { "YLM", "YBS", "YFP", "ECIF", "NDS", "YCC", "YSF",
                "ECS", "YTF", "YEB", "YIP", "YMF", "CGMP", "YRL" };
        List<String> aryList = Arrays.asList(ary);
        Map<String, String> err = new HashMap<>();
        boolean flag = true;
        try {
            InputStream stream = FileUtil.vaildataFile(mfile);
            ExeclParseUtil execlParseUtil = new ExeclParseUtil();
            List<ScoreGame> execlList = execlParseUtil.getEntity(stream, ScoreGame.class);
            Collections.sort(execlList);
            String err_sysCode = "";//源系统编号错误信息
            String err_sysCode0 = "";//源系统编号错误信息
            String err_customerNo = "";//源系统客户号错误信息
            String err_customerNo0 = "";//源系统客户号错误信息
            String err_customerName = "";//源系统客户名称错误信息
            String err_customerName0 = "";//源系统客户名称错误信息
            String err_donateScores = "";//赠送积分错误信息
            String err_donateScores0 = "";//赠送积分错误信息
            String err_disabledDt = "";//积分有效期错误信息
            String err_disabledDt0 = "";//积分有效期错误信息
            String err_gameDesc = "";
            String importCode = "";
            Map<String,Integer> checkSerial = new HashMap<>();
            Map<String,Integer> checkCustNo = new HashMap<>();
            for (int i = 0; i < execlList.size(); i++) {
                ScoreGame scoreGame = execlList.get(i);
                if (i == 0){
                    if ("1".equals(scoreGame.getSerialNum())){
                        if ("".equals(scoreGame.getImportCode())){
                            flag = false;
                            err.put("err_importCode0","序号为第一行批次号不能为空");
                        }else {
                            importCode = scoreGame.getImportCode();
                        }
                    }else {
                        flag = false;
                        err.put("err_importCode0","序号错误：可能发生的错误有：★未发现序号为“1”的行；★请确认序号从“1”开始！(注意：请确保序号列EXCEL格式为文本类型！);");
                    }
                }
                if ("".equals(scoreGame.getSerialNum())) {
                    flag = false;
                    err.put("err_serialNum","★存在序号为空！;");
                }else {
                    int num = checkSerial.get(scoreGame.getSerialNum()) == null ? 0 : checkSerial.get(scoreGame.getSerialNum());
                    checkSerial.put(scoreGame.getSerialNum(),num + 1);
                }
                String serialNum = scoreGame.getSerialNum();
                if ("".equals(scoreGame.getSysCode())){
                    flag = false;
                    if ("".equals(err_sysCode)){
                        err_sysCode = serialNum;
                    }else {
                        err_sysCode += "、" + serialNum;
                    }
                    err.put("err_sysCode","★存在源系统编号为空！;序号为"+err_sysCode);
                }else if (!aryList.contains(scoreGame.getSysCode())){
                    flag = false;
                    if ("".equals(err_sysCode0)){
                        err_sysCode0 = serialNum;
                    }else {
                        err_sysCode0 += "、" + serialNum;
                    }
                    err.put("err_sysCode0","★存在源系统编号不存在！;序号为"+err_sysCode0);
                }
                if ("".equals(scoreGame.getCustomerNo())){
                    flag = false;
                    if ("".equals(err_customerNo)){
                        err_customerNo = serialNum;
                    }else {
                        err_customerNo += "、" + serialNum;
                    }
                    err.put("err_customerNo","★存在源系统客户编号为空！;序号为"+err_customerNo);
                }else if (checkCustNo(scoreGame.getCustomerNo())){
                    flag = false;
                    if ("".equals(err_customerNo0)){
                        err_customerNo0 = serialNum;
                    }else {
                        err_customerNo0 += "、" + serialNum;
                    }
                    err.put("err_customerNo0","★存在源系统客户编号格式错误！;序号为"+err_customerNo0);
                }else {
                    int num = checkCustNo.get(scoreGame.getCustomerNo()) == null ? 0 : checkSerial.get(scoreGame.getCustomerNo());
                    checkCustNo.put(scoreGame.getCustomerNo(),num + 1);
                }
                if ("".equals(scoreGame.getCustomerName())){
                    flag = false;
                    if ("".equals(err_customerName)){
                        err_customerName = serialNum;
                    }else {
                        err_customerName += "、" + serialNum;
                    }
                    err.put("err_customerName","★存在源系统客户名称为空！;序号为"+err_customerName);
                }else {
                    Map<String,String> names = scoreAdjustMapper.getCustName(scoreGame.getCustomerNo(),scoreGame.getSysCode());
                    if (names == null){
                        flag = false;
                        if ("".equals(err_customerName0)){
                            err_customerName0 = serialNum;
                        }else {
                            err_customerName0 += "、" + serialNum;
                        }
                        err.put("err_customerName0","★存在源系统客户名称错误！;序号为"+err_customerName0);
                    }else {
                        String cn_name = names.get("custName") == null ? "" : names.get("custName");
                        String en_name = names.get("englishName") == null ? "" : names.get("englishName");
                        if ("".equals(cn_name)){
                            if ("".equals(en_name)){
                                flag = false;
                                if ("".equals(err_customerName0)){
                                    err_customerName0 = serialNum;
                                }else {
                                    err_customerName0 += "、" + serialNum;
                                }
                                err.put("err_customerName0","★存在源系统客户名称错误！;序号为"+err_customerName0);
                            }else if (!scoreGame.getCustomerName().equals(en_name)){
                                flag = false;
                                if ("".equals(err_customerName0)){
                                    err_customerName0 = serialNum;
                                }else {
                                    err_customerName0 += "、" + serialNum;
                                }
                                err.put("err_customerName0","★存在源系统客户名称错误！;序号为"+err_customerName0);
                            }
                        }else if (!scoreGame.getCustomerName().equals(cn_name)){
                            flag = false;
                            if ("".equals(err_customerName0)){
                                err_customerName0 = serialNum;
                            }else {
                                err_customerName0 += "、" + serialNum;
                            }
                            err.put("err_customerName0","★存在源系统客户名称错误！;序号为"+err_customerName0);
                        }
                    }
                }
                if ("".equals(scoreGame.getDonateScores()) || "0".equals(scoreGame.getDonateScores())){
                    flag = false;
                    if ("".equals(err_donateScores)){
                        err_donateScores = serialNum;
                    }else {
                        err_donateScores += "、" + serialNum;
                    }
                    err.put("err_donateScores","★存在赠送积分为空！;序号为"+err_donateScores);
                }else if (!Isnumber(scoreGame.getDonateScores())){
                    flag = false;
                    if ("".equals(err_donateScores0)){
                        err_donateScores0 = serialNum;
                    }else {
                        err_donateScores0 += "、" + serialNum;
                    }
                    err.put("err_donateScores0","★存在赠送积分格式错误！;序号为"+err_donateScores0);
                }
                if ("".equals(scoreGame.getDisabledDt())){
                    flag = false;
                    if ("".equals(err_disabledDt)){
                        err_disabledDt = serialNum;
                    }else {
                        err_disabledDt += "、" + serialNum;
                    }
                    err.put("err_disabledDt","★存在积分有效期为空！;序号为"+err_disabledDt);
                }else {
                    Date newDate = new Date();
                    Date disabledDt = s2.parse(scoreGame.getDisabledDt());
                    if (disabledDt.before(newDate)){
                        flag = false;
                        if ("".equals(err_disabledDt0)){
                            err_disabledDt0 = serialNum;
                        }else {
                            err_disabledDt0 += "、" + serialNum;
                        }
                        err.put("err_disabledDt0","★存在积分有效期小于当前日期！;序号为"+err_disabledDt0);
                    }
                }
                if (scoreGame.getGameDesc() == null || "".equals(scoreGame.getGameDesc().trim())){
                    flag = false;
                    if ("".equals(err_gameDesc)){
                        err_gameDesc = serialNum;
                    }else {
                        err_gameDesc += "、" + serialNum;
                    }
                    err.put("err_gameDesc","★存在活动描述为空！;");
                }
            }
            String err_serialNum = checkSerial.entrySet().stream().filter(serial -> serial.getValue() > 1).map(serial->serial.getKey()).collect(Collectors.joining());
            if (!"".equals(err_serialNum)){
                flag = false;
                err.put("err_serialNum0","★存在重复序号！;序号为"+err_serialNum);
            }
            String err_customerNo1 = checkCustNo.entrySet().stream().filter(cust -> cust.getValue() > 1).map(cust->cust.getKey()).collect(Collectors.joining());
            if (!"".equals(err_serialNum)){
                flag = false;
                err.put("err_customerNo1","★存在重复源系统客户编号！;源系统客户编号"+err_customerNo1);
            }
            if (!flag){
                String message = err.entrySet().stream().map(e->e.getValue()).collect(Collectors.joining());
                err.put("err_code","1");
                err.put("err_message","excel内容校验失败,请修改文件内容");
                err.put("message",message);
            }else {
                int flag0 = checkImportCode(importCode);
                if (flag0 == 3){
                    flag = false;
                    err.put("err_code","3");
                    err.put("err_message","当前批次【" + importCode + "】审批中，请确认撤回当前批次重新导入");
                }else if (2 == flag0){
                    flag = false;
                    err.put("err_code","2");
                    err.put("err_message","当前批次【" + importCode + "】审批通过，请修改当前批次号重新导入");
                }else {
                    scoreGameMapper.deleteByImportCode(importCode);
                    String finalImportCode = importCode;
                    execlList.forEach(scoreGame -> {
                        scoreGame.setImportCode(finalImportCode);
                        this.insertSelective(scoreGameMapper,scoreGame);
                    });
                    if (99 == flag0){
                        flag = false;
                        err.put("err_code","99");
                        err.put("err_message","当前批次【" + importCode + "】已导入，确认是否覆盖已导入数据");
                        err.put("importCode",importCode);
                    }else if (0 == flag0){
                        err.put("err_code","0");
                        err.put("err_message","导入成功");
                        err.put("importCode",importCode);
                    }
                }
            }
        } catch (Exception e) {
            flag = false;
            err.put("err_code","-1");
            err.put("err_message","系统错误");
        }finally {
            return err;
        }

    }

    /**
     * 校验正整数
     * @param donateScores
     * @return
     */
    private boolean Isnumber(String donateScores) {
        return Pattern.matches("^\\+?\\d*$",donateScores);
    }

    private boolean checkCustNo(String str) {
        if (str.indexOf("E") > 0 || str.indexOf(".") > 0){
            return true;
        }
        return false;
    }

    private int checkImportCode(String importCode) {
        Map<String,String> map = scoreAdjustMapper.chechImportCode(importCode);
        if (map != null){
            String appStatus = map.get("appStatus");
            if ("3".equals(appStatus)){
//                err.put("err_importCode1","当前批次【" + importCode + "】审批中，请确认撤回当前批次重新导入");
                return 3;
            }else if ("2".equals(appStatus)){
//                err.put("err_importCode2","当前批次【" + importCode + "】审批通过，请确认修改当前批次号重新导入");
                return 2;
            }else {
//                err.put("err_importCode3","当前批次【" + importCode + "】已导入，是否覆盖已导入数据");
                return 99;
            }
        }
        return 0;
    }

    public void excelExport(String importCode, String filePath,boolean isCover) throws Exception{
        scoreGameMapper.deleteExcel(importCode);
        String updateUser = userInfoService.getUserInfo().getLoginCode() +"/"+userInfoService.getUserInfo().getUserName();
        int num = scoreGameMapper.insertExcel(importCode,updateUser);
        scoreGameMapper.deleteDateTmp(importCode);
        if (!isCover){
            excelImportMapper.deleteData(importCode);
            ExcelImport excelImport = new ExcelImport();
            excelImport.setImportDate(s1.parse(s1.format(new Date())));
            excelImport.setImportNum(num);
            excelImport.setImportUser(userInfoService.getLoginCode());
            excelImport.setImportUsername(userInfoService.getUserInfo().getUserName());
            excelImport.setAppStatus("1");
            this.insertSelective(excelImportMapper,excelImport);
        }else {
            ExcelImport excelImport = new ExcelImport();
            excelImport.setImportDate(s1.parse(s1.format(new Date())));
            excelImport.setImportNum(num);
            excelImport.setImportCode(importCode);
            excelImportMapper.updateByImportCode(excelImport);
        }
    }
}
