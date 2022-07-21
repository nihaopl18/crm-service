package cn.com.yusys.climp.qypool.service;

import cn.com.yusys.climp.qypool.domain.*;
import cn.com.yusys.climp.qypool.repository.mapper.*;
import cn.com.yusys.climp.qypool.utils.Md5Utils;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.commons.web.rest.exception.Message;
import cn.com.yusys.yusp.commons.web.rest.exception.YuspException;
import com.github.pagehelper.PageHelper;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @version 1.0.0
 * @项目名称: yusp-climp-qypool模块
 * @类名称: LoyQyVirtTicketService
 * @类描述: #服务类
 * @功能描述:
 * @创建人: hujun3
 * @创建时间: 2019-02-21 15:19:34
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 * -------------------------------------------------------------
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class LoyQyVirtTicketService extends CommonService {
    private Logger logger = LoggerFactory.getLogger(LoyQyVirtTicketService.class);
    private static final String STR_FORMAT = "00000000000000000";
    @Autowired
    private LoyQyVirtTicketMapper loyQyVirtTicketMapper;
    @Autowired
    private LoyQyVirtBatchMapper batchMapper;
    @Autowired
    private LoyQyVirtStockMapper stockMapper;
    @Autowired
    private LoyQyVirtStockTempMapper stockTempMapper;

    @Autowired
    private LoyQyVirtTicketKindMapper loyQyVirtTicketKindMapper;
    // @Autowired
    // private IClientService clientService;
    @Autowired
    private UserInfoService userInfoService;

    @Override
    protected CommonMapper<?> getMapper() {
        return loyQyVirtTicketMapper;
    }

    /**
     * @方法名称: addTicketInfo
     * @方法描述: 新增虚拟票券信息
     * @参数与返回说明:
     * @算法描述:
     */
    public void addTicketInfo(LoyQyVirtTicket pool) {
        // 获取登录信息
        // ResponseEntity<UserInfoDTO> dto =
        // clientService.getUserSessionInfo(HeaderUtil.getAccessToken());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date now = sdf.parse(sdf.format(new Date()));
            // pool.setCreateOrg(dto.getBody().getOrg().getCode());
            pool.setCreateOrg(userInfoService.getOrgCode());
            pool.setCreateDate(now);
            // pool.setCreateUser(dto.getBody().getLoginCode());
            // pool.setInstuId(dto.getBody().getInstu().getId());
            pool.setCreateUser(userInfoService.getLoginCode());
            pool.setInstuId(userInfoService.getUserInfo().getInstu().getId());
            pool.setTicketStatus("W");// A-生效；I-失效；W-待生效
            pool.setWfApprSts("000");
            pool.setUpdateDate(now);
            // pool.setUpdateOrg(dto.getBody().getOrg().getCode());
            // pool.setUpdateUser(dto.getBody().getLoginCode());
            pool.setUpdateOrg(userInfoService.getOrgCode());
            pool.setUpdateUser(userInfoService.getLoginCode());
            loyQyVirtTicketMapper.insertSelective(pool);
        } catch (ParseException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }

    }

    public List<LoyQyVirtTicket> queryInfoByIds(String ids) {
        List<LoyQyVirtTicket> reuslt = new ArrayList<LoyQyVirtTicket>();
        Map<String, Object> param = new HashMap<String, Object>();
        if (ids != null) {
            param.put("ticketNo", ids.split(","));
            reuslt = loyQyVirtTicketMapper.getTicketInfoByNos(param);
        }
        return reuslt;
    }

    /**
     * @方法名称: updateTicketInfo
     * @方法描述: 更新虚拟票券信息
     * @参数与返回说明:
     * @算法描述:
     */
    public void updateTicketInfo(LoyQyVirtTicket pool) {
        // 获取登录信息
        // ResponseEntity<UserInfoDTO> dto =
        // clientService.getUserSessionInfo(HeaderUtil.getAccessToken());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date now = sdf.parse(sdf.format(new Date()));
            pool.setWfApprSts("000");
            pool.setUpdateDate(now);
            // pool.setUpdateOrg(dto.getBody().getOrg().getCode());
            // pool.setUpdateUser(dto.getBody().getLoginCode());
            pool.setUpdateOrg(userInfoService.getOrgCode());
            pool.setUpdateUser(userInfoService.getLoginCode());
            loyQyVirtTicketMapper.updateByPrimaryKeySelective(pool);
        } catch (ParseException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }

    }

    /**
     * @方法名称: updateDataStsInfo
     * @方法描述: 更新虚拟票券数据状态信息
     * @参数与返回说明:
     * @算法描述:
     */
    public void updateDataStsInfo(String id, String sts) {
        // 获取登录信息
        // ResponseEntity<UserInfoDTO> dto =
        // clientService.getUserSessionInfo(HeaderUtil.getAccessToken());
        LoyQyVirtTicket pool = loyQyVirtTicketMapper.selectByPrimaryKey(id);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date now = sdf.parse(sdf.format(new Date()));
            pool.setTicketStatus(sts);
            pool.setUpdateDate(now);
            // pool.setUpdateOrg(dto.getBody().getOrg().getCode());
            // pool.setUpdateUser(dto.getBody().getLoginCode());
            pool.setUpdateOrg(userInfoService.getOrgCode());
            pool.setUpdateUser(userInfoService.getLoginCode());
            loyQyVirtTicketMapper.updateByPrimaryKeySelective(pool);
        } catch (ParseException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }

    }

    /**
     * @方法名称: updateTicketStsInfo
     * @方法描述: 更新虚拟票券审批状态信息
     * @参数与返回说明:
     * @算法描述:
     */
    public void updateTicketStsInfo(String id, String sts) {
        // 获取登录信息
        // ResponseEntity<UserInfoDTO> dto =
        // clientService.getUserSessionInfo(HeaderUtil.getAccessToken());
        LoyQyVirtTicket pool = loyQyVirtTicketMapper.selectByPrimaryKey(id);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date now = sdf.parse(sdf.format(new Date()));
            pool.setWfApprSts(sts);
            pool.setUpdateDate(now);
            // pool.setUpdateOrg(dto.getBody().getOrg().getCode());
            // pool.setUpdateUser(dto.getBody().getLoginCode());
            pool.setUpdateOrg(userInfoService.getOrgCode());
            pool.setUpdateUser(userInfoService.getLoginCode());
            loyQyVirtTicketMapper.updateByPrimaryKeySelective(pool);
        } catch (ParseException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }

    }

    /**
     * @方法名称: wfTicketProcess
     * @方法描述: 审批结果处理
     * @参数与返回说明:
     * @算法描述:
     */
    public void wfTicketProcess(String id) {
        // 获取登录信息
        // ResponseEntity<UserInfoDTO> dto =
        // clientService.getUserSessionInfo(HeaderUtil.getAccessToken());
        LoyQyVirtTicket pool = loyQyVirtTicketMapper.selectByPrimaryKey(id);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date now = sdf.parse(sdf.format(new Date()));
            pool.setWfApprSts("997");
            pool.setTicketStatus("A");
            pool.setUpdateDate(now);
            // pool.setUpdateOrg(dto.getBody().getOrg().getCode());
            // pool.setUpdateUser(dto.getBody().getLoginCode());
            pool.setUpdateOrg(userInfoService.getOrgCode());
            pool.setUpdateUser(userInfoService.getLoginCode());
            loyQyVirtTicketMapper.updateByPrimaryKeySelective(pool);
        } catch (ParseException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }

    }

    /**
     * @方法名称: haoAddOne
     * @方法描述: 生成虚拟票券的识别号
     * @参数与返回说明:
     * @算法描述:
     */
    public String haoAddOne(String liuShuiHao) {
        String sources = "0123456789"; // 加上一些字母，就可以生成pc站的验证码了
        Random rand = new Random();
        StringBuffer flag = new StringBuffer();
        for (int j = 0; j < 6; j++) {
            flag.append(sources.charAt(rand.nextInt(9)) + "");
        }
        // System.out.println(flag.toString());
        // DecimalFormat df = new DecimalFormat(STR_FORMAT);
        return liuShuiHao + flag.toString();
    }

    /**
     * @方法名称: pwdAddOne
     * @方法描述: 生成虚拟票券的识别密码
     * @参数与返回说明:
     * @算法描述:
     */
    public String pwdAddOne(int length) {
        String string = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";// 保存数字0-9 和 大小写字母
        char[] ch = new char[length]; // 声明一个字符数组对象ch 保存 验证码
        for (int i = 0; i < length; i++) {
            Random random = new Random();// 创建一个新的随机数生成器
            int index = random.nextInt(string.length());// 返回[0,string.length)范围的int值 作用：保存下标
            ch[i] = string.charAt(index);// charAt() : 返回指定索引处的 char 值 ==》保存到字符数组对象ch里面
        }
        // 将char数组类型转换为String类型保存到result
        // String result = new String(ch);//方法一：直接使用构造方法 String(char[] value) ：分配一个新的
        // String，使其表示字符数组参数中当前包含的字符序列。
        String result = String.valueOf(ch);// 方法二： String方法 valueOf(char c) ：返回 char 参数的字符串表示形式。
        return Md5Utils.MD5Encode(result, "utf8");
    }

    /**
     * @方法名称: wfBatchProcess
     * @方法描述: 审批结果处理
     * @参数与返回说明:
     * @算法描述:
     */
    @Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
    public void wfBatchProcess(String id) {
        // 获取登录信息
        // ResponseEntity<UserInfoDTO> dto =
        // clientService.getUserSessionInfo(HeaderUtil.getAccessToken());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date now = sdf.parse(sdf.format(new Date()));
            LoyQyVirtBatch pool = batchMapper.selectByPrimaryKey(id);
            List<LoyQyVirtTicket> list = loyQyVirtTicketMapper.getTicketInfoByNo(pool.getTicketNo());
            LoyQyVirtTicket ticket = new LoyQyVirtTicket();
            if (!list.isEmpty()) {
                ticket = list.get(0);
            }
            // 更新虚拟票券信息总数
            if (pool.getSourceType().equals("1")) {// 当票券来源为系统生成的时候-1
                Long total = ticket.getTotalNum() + pool.getTicketAllNum();
                ticket.setTotalNum(total);
                ticket.setUpdateDate(now);
                // ticket.setUpdateOrg(dto.getBody().getOrg().getCode());
                // ticket.setUpdateUser(dto.getBody().getLoginCode());
                ticket.setUpdateOrg(userInfoService.getOrgCode());
                ticket.setUpdateUser(userInfoService.getLoginCode());
                loyQyVirtTicketMapper.updateByPrimaryKeySelective(ticket);
                // 更新批次信息
                pool.setWfApprSts("997");
                pool.setUnShippedNum(pool.getTicketAllNum());
                pool.setUpdateDate(now);
                // pool.setUpdateOrg(dto.getBody().getOrg().getCode());
                // pool.setUpdateUser(dto.getBody().getLoginCode());
                pool.setUpdateOrg(userInfoService.getOrgCode());
                pool.setUpdateUser(userInfoService.getLoginCode());
                batchMapper.updateByPrimaryKeySelective(pool);
                // 循环生成对应的库存信息
                for (int i = 0; i < pool.getTicketAllNum(); i++) {
                    LoyQyVirtStock info = new LoyQyVirtStock();
                    info.setBatchNo(pool.getBatchNo());
                    info.setTicketNo(pool.getTicketNo());
                    info.setVirtNo(haoAddOne(pool.getBatchNo().toString()));
                    info.setVirtPwd(pwdAddOne(9));// 生成9位数的md5加密后的密码
                    info.setUsedSts("0");
                    // info.setCreateOrg(dto.getBody().getOrg().getCode());
                    // info.setCreateDate(now);
                    // info.setCreateUser(dto.getBody().getLoginCode());
                    // info.setUpdateDate(now);
                    // info.setUpdateOrg(dto.getBody().getOrg().getCode());
                    // info.setUpdateUser(dto.getBody().getLoginCode());
                    info.setCreateOrg(userInfoService.getOrgCode());
                    info.setCreateDate(now);
                    info.setCreateUser(userInfoService.getLoginCode());
                    info.setUpdateDate(now);
                    info.setUpdateOrg(userInfoService.getOrgCode());
                    info.setUpdateUser(userInfoService.getLoginCode());
                    stockMapper.insertSelective(info);
                }
            } else {// 当票券来源为批量导入的时候-2
                // 更新批次信息
                pool.setWfApprSts("997");
                pool.setUnShippedNum(pool.getTicketAllNum());
                pool.setUpdateDate(now);
                // pool.setUpdateOrg(dto.getBody().getOrg().getCode());
                // pool.setUpdateUser(dto.getBody().getLoginCode());
                pool.setUpdateOrg(userInfoService.getOrgCode());
                pool.setUpdateUser(userInfoService.getLoginCode());
                batchMapper.updateByPrimaryKeySelective(pool);
            }

        } catch (ParseException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }

    }

    /**
     * @方法名称: addBatchInfo
     * @方法描述: 新增虚拟票券批次信息
     * @参数与返回说明:
     * @算法描述:
     */
    public void addBatchInfo(LoyQyVirtBatch pool) {
        // 获取登录信息
        // ResponseEntity<UserInfoDTO> dto =
        // clientService.getUserSessionInfo(HeaderUtil.getAccessToken());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date now = sdf.parse(sdf.format(new Date()));
            // pool.setCreateOrg(dto.getBody().getOrg().getCode());
            pool.setCreateOrg(userInfoService.getOrgCode());
            pool.setCreateDate(now);
            // pool.setCreateUser(dto.getBody().getLoginCode());
            pool.setCreateUser(userInfoService.getLoginCode());
            pool.setWfApprSts("000");
            pool.setUpdateDate(now);
            // pool.setUpdateOrg(dto.getBody().getOrg().getCode());
            // pool.setUpdateUser(dto.getBody().getLoginCode());
            pool.setUpdateOrg(userInfoService.getOrgCode());
            pool.setUpdateUser(userInfoService.getLoginCode());
            batchMapper.insertSelective(pool);
        } catch (ParseException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }

    }

    /**
     * @方法名称: updateBatchInfo
     * @方法描述:更新虚拟票券批次信息
     * @参数与返回说明:
     * @算法描述:
     */
    public void updateBatchInfo(LoyQyVirtBatch pool) {
        // 获取登录信息
        // ResponseEntity<UserInfoDTO> dto =
        // clientService.getUserSessionInfo(HeaderUtil.getAccessToken());
        LoyQyVirtBatch data = batchMapper.selectByPrimaryKey(pool.getBatchId());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date now = sdf.parse(sdf.format(new Date()));
            data.setTicketAllNum(pool.getTicketAllNum());
            data.setValidEndDate(pool.getValidEndDate());
            data.setValidStartDate(pool.getValidStartDate());
            data.setWfApprSts("000");
            data.setUpdateDate(now);
            // data.setUpdateOrg(dto.getBody().getOrg().getCode());
            // data.setUpdateUser(dto.getBody().getLoginCode());
            data.setUpdateOrg(userInfoService.getOrgCode());
            data.setUpdateUser(userInfoService.getLoginCode());
            batchMapper.updateByPrimaryKeySelective(data);
        } catch (ParseException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }

    }

    /**
     * @方法名称: updateBatchStsInfo
     * @方法描述: 虚拟票券批次信息状态更新
     * @参数与返回说明:
     * @算法描述:
     */
    public void updateBatchStsInfo(String id, String sts) {
        // 获取登录信息
        // ResponseEntity<UserInfoDTO> dto =
        // clientService.getUserSessionInfo(HeaderUtil.getAccessToken());
        LoyQyVirtBatch data = batchMapper.selectByPrimaryKey(id);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date now = sdf.parse(sdf.format(new Date()));
            data.setWfApprSts(sts);
            data.setUpdateDate(now);
            // data.setUpdateOrg(dto.getBody().getOrg().getCode());
            // data.setUpdateUser(dto.getBody().getLoginCode());
            data.setUpdateOrg(userInfoService.getOrgCode());
            data.setUpdateUser(userInfoService.getLoginCode());
            batchMapper.updateByPrimaryKeySelective(data);
        } catch (ParseException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }

    }

    /**
     * @方法名称: deleteBatchInfo
     * @方法描述: 删除虚拟票券批次信息
     * @参数与返回说明:
     * @算法描述:
     */
    public void deleteBatchInfo(String ids) {
        String[] id = ids.split(",");
        for (int i = 0; i < id.length; i++) {
            batchMapper.deleteByIds(id[i]);
        }

    }

    /**
     * @方法名称: deleteTicketInfo
     * @方法描述: 删除虚拟票券信息
     * @参数与返回说明:
     * @算法描述:
     */
    public void deleteTicketInfo(String ids) {
        String[] id = ids.split(",");
        for (int i = 0; i < id.length; i++) {
            loyQyVirtTicketMapper.deleteByIds(id[i]);
        }

    }

    /**
     * @方法名称: findAllByParam
     * @方法描述: 分页查询
     * @参数与返回说明:
     * @算法描述:
     */
    @Transactional(readOnly = true)
    public List<Map<String, Object>> findAllByParam(QueryModel param) {
        // 设置分页查询参数(设置到线程变量中了)
        PageHelper.startPage(param.getPage(), param.getSize());
        List<Map<String, Object>> result = this.loyQyVirtTicketMapper.queryInfoByPage(param);
        PageHelper.clearPage();
        logger.info("虚拟票券信息分页查询");
        return result;
    }

    /**
     * @方法名称: findBatchByParam
     * @方法描述: 分页查询批次信息
     * @参数与返回说明:
     * @算法描述:
     */
    @Transactional(readOnly = true)
    public List<Map<String, Object>> findBatchByParam(QueryModel param) {
        // 设置分页查询参数(设置到线程变量中了)
        PageHelper.startPage(param.getPage(), param.getSize());
        List<Map<String, Object>> result = this.loyQyVirtTicketMapper.queryBatchByPage(param);
        PageHelper.clearPage();
        logger.info("虚拟票券批次信息分页查询");
        return result;
    }

    /**
     * @方法名称: findStockByParam
     * @方法描述: 分页查询库存信息
     * @参数与返回说明:
     * @算法描述:
     */
    @Transactional(readOnly = true)
    public List<Map<String, Object>> findStockByParam(QueryModel param) {
        // 设置分页查询参数(设置到线程变量中了)
        PageHelper.startPage(param.getPage(), param.getSize());
        List<Map<String, Object>> result = this.loyQyVirtTicketMapper.queryStockByPage(param);
        PageHelper.clearPage();
        logger.info("虚拟票券库存分页查询");
        return result;
    }

    /**
     * @方法名称: wfQueryTicketInfo
     * @方法描述: 审批页面查询虚拟票券信息
     * @参数与返回说明:
     * @算法描述:
     */
    @Transactional(readOnly = true)
    public List<Map<String, Object>> wfQueryTicketInfo(String id) {
        Map<String, String> param = new HashMap<String, String>();
        param.put("ticketId", id);
        List<Map<String, Object>> result = this.loyQyVirtTicketMapper.wfQueryTicketInfo(param);
        logger.info("审批页面查询虚拟票券信息");
        return result;
    }

    /**
     * @方法名称: wfQueryBatchInfo
     * @方法描述: 审批页面查询虚拟票券批次信息
     * @参数与返回说明:
     * @算法描述:
     */
    @Transactional(readOnly = true)
    public List<Map<String, Object>> wfQueryBatchInfo(String id) {
        Map<String, String> param = new HashMap<String, String>();
        param.put("batchId", id);
        List<Map<String, Object>> result = this.loyQyVirtTicketMapper.wfQueryBatchInfo(param);
        logger.info("审批页面查询虚拟票券批次信息");
        return result;
    }

    /**
     * @方法名称: updateStsById
     * @方法描述: 更新数据生效状态
     * @参数与返回说明:
     * @算法描述:
     */
    @Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
    public void updateStsById(String ids, String sts) {
        // ResponseEntity<UserInfoDTO> dto =
        // clientService.getUserSessionInfo(HeaderUtil.getAccessToken());
        String[] id = ids.split(",");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("id", id);
        param.put("status", sts);
        // param.put("updateUser", dto.getBody().getLoginCode());
        // param.put("updateOrg", dto.getBody().getOrg().getCode());
        param.put("updateUser", userInfoService.getLoginCode());
        param.put("updateOrg", userInfoService.getOrgCode());
        param.put("updateDate", sdf.format(new Date()));
        this.loyQyVirtTicketMapper.updateInfoStsById(param);
        logger.info("更新数据生效状态");
    }

    /**
     * @方法名称: updateStsByWfBiz
     * @方法描述: 更新数据审批状态
     * @参数与返回说明:
     * @算法描述:
     */
    @Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
    public void updateStsByWfBiz(String id, String sts) {
        Map<String, Object> param = new HashMap<String, Object>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // ResponseEntity<UserInfoDTO> dto =
        // clientService.getUserSessionInfo(HeaderUtil.getAccessToken());
        param.put("id", id);
        param.put("status", sts);
        // param.put("updateUser", dto.getBody().getLoginCode());
        // param.put("updateOrg", dto.getBody().getOrg().getCode());
        param.put("updateUser", userInfoService.getLoginCode());
        param.put("updateOrg", userInfoService.getOrgCode());
        param.put("updateDate", sdf.format(new Date()));
        this.loyQyVirtTicketMapper.changeBizWfStatus(param);
        logger.info("更新数据审批状态");
    }

    /**
     * @方法名称: dataImport
     * @方法描述:批量导入虚拟票圈处理逻辑
     * @参数与返回说明:
     * @算法描述:读取excel中的数据存放到临时表中，去重后再存入正式表中
     */
    @Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
    public String dataImport(String flag, String batchNo, String ticketNo, MultipartFile file) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date now = sdf.parse(sdf.format(new Date()));
        String AllNumInfo = "";
        LoyQyVirtTicket ticke = null;
        LoyQyVirtBatch batch = null;
        // 获取登录信息
        // ResponseEntity<UserInfoDTO> dto =
        // clientService.getUserSessionInfo(HeaderUtil.getAccessToken());
        try {
            List<LoyQyVirtTicket> tickets = loyQyVirtTicketMapper.getTicketInfoByNo(ticketNo);
            List<LoyQyVirtBatch> batchs = loyQyVirtTicketMapper.getBatchInfoByNo(batchNo);
            if (tickets.isEmpty() || batchs.isEmpty()) {
                throw new YuspException(new Message("2006", "没有查询到对应的票券信息和批次信息!", "error"));
            } else {
                ticke = tickets.get(0);
                batch = batchs.get(0);
            }
            // 获得Workbook工作薄对象
            Workbook workbook = getWorkBook(file);
            // 创建返回对象，把每行中的值作为一个数组，所有行作为一个集合返回

            if (workbook != null) {
                for (int sheetNum = 1; sheetNum < workbook.getNumberOfSheets(); sheetNum++) {
                    // 获得当前sheet工作表
                    Sheet sheet = workbook.getSheetAt(sheetNum);
                    String sheetname = workbook.getSheetName(sheetNum);
                    if (sheet == null) {
                        continue;
                    }
                    // 获得当前sheet的开始行
                    int firstRowNum = sheet.getFirstRowNum();
                    String headStr = "";
                    Row headrow = sheet.getRow(firstRowNum);
                    // 获得表头行的开始列
                    int headfirstCellNum = headrow.getFirstCellNum();
                    // 获得表头行的列数
                    int headlastCellNum = headrow.getPhysicalNumberOfCells();
                    String[] headcells = new String[headrow.getPhysicalNumberOfCells()];
                    for (int k = headfirstCellNum; k < headlastCellNum; k++) {
                        Cell cell = headrow.getCell(k);
                        headcells[k] = cell.toString();
                    }
                    for (int x = 0; x < headcells.length; x++) {
                        headStr += "," + headcells[x].toString();
                    }
                    headStr = headStr.substring(1);
                    boolean iii = headStr.equals("票券识别码,使用秘密");
                    if (!iii) {
                        // return "表格格式不对，请下载模板填写";
                        throw new YuspException(
                                new Message("2006", "EXCEL的第" + sheetNum + "页的表格格式不对，请下载模板填写!", "error"));
                    }
                    // 获得当前sheet的结束行
                    int lastRowNum = sheet.getLastRowNum();
                    int rowCount = sheet.getPhysicalNumberOfRows();
                    List<LoyQyVirtStockTemp> data = new ArrayList<LoyQyVirtStockTemp>();
                    // 判断表内字段是否为空
                    for (int rowNum = firstRowNum + 1; rowNum <= lastRowNum; rowNum++) {
                        // 获得当前行
                        String RowData = "";
                        Row row = sheet.getRow(rowNum);
                        if (row == null) {
                            continue;
                        }
                        // 获得当前行的开始列
                        int firstCellNum = row.getFirstCellNum();
                        // 获得当前行的列数
                        int lastCellNum = row.getPhysicalNumberOfCells();
                        // 循环当前行
                        LoyQyVirtStockTemp lbbl = new LoyQyVirtStockTemp();
                        lbbl.setBatchNo(batchNo);
                        for (int cellNum = firstCellNum; cellNum < lastCellNum; cellNum++) {
                            Cell cell = row.getCell(cellNum);
                            switch (cellNum) {
                                case 0:// 票券识别码
                                    lbbl.setVirtNo(getCellValue(cell));
                                    break;
                                case 1:// 使用秘密
                                    lbbl.setVirtPwd(getCellValue(cell));
                                    break;
                            }

                        }
                        if (lbbl.getVirtNo() == null || lbbl.getVirtPwd() == null) {
                            throw new YuspException(new Message("2006",
                                    "票券识别码和使用秘密字段不能为空，请检查EXCEL的第" + sheetNum + "页的第" + rowNum + "行!", "error"));
                        }
                        lbbl.setTicketNo(ticketNo);
                        lbbl.setUsedSts("0");
                        // lbbl.setCreateOrg(dto.getBody().getOrg().getCode());
                        lbbl.setCreateOrg(userInfoService.getOrgCode());
                        lbbl.setCreateDate(now);
                        // lbbl.setCreateUser(dto.getBody().getLoginCode());
                        lbbl.setCreateUser(userInfoService.getLoginCode());
                        lbbl.setUpdateDate(now);
                        // lbbl.setUpdateOrg(dto.getBody().getOrg().getCode());
                        // lbbl.setUpdateUser(dto.getBody().getLoginCode());
                        lbbl.setUpdateOrg(userInfoService.getOrgCode());
                        lbbl.setUpdateUser(userInfoService.getLoginCode());
                        data.add(lbbl);
                    }
                    for (int s = 0; s < data.size(); s++) {// 循环插入临时表数据数据
                        stockTempMapper.insertSelective(data.get(s));
                    }

                }
                List<Map<String, Object>> AllNum = loyQyVirtTicketMapper.getNum(batchNo);// 获取导入的总数
                AllNumInfo = AllNum.get(0).get("num").toString();
                loyQyVirtTicketMapper.insertList(batchNo);// 把临时表中的数据插入到正式表中
                loyQyVirtTicketMapper.deleteTempInfo(batchNo);// 删除临时表中的数据
                Long all = Long.parseLong(AllNumInfo) + ticke.getTotalNum();
                ticke.setTotalNum(all);
                ticke.setUpdateDate(now);
                // ticke.setUpdateOrg(dto.getBody().getOrg().getCode());
                // ticke.setUpdateUser(dto.getBody().getLoginCode());
                ticke.setUpdateOrg(userInfoService.getOrgCode());
                ticke.setUpdateUser(userInfoService.getLoginCode());
                loyQyVirtTicketMapper.updateByPrimaryKeySelective(ticke);// 更新票券信息中的总数
                batch.setUnShippedNum(Long.parseLong(AllNumInfo));
                batch.setUpdateDate(now);
                // batch.setUpdateOrg(dto.getBody().getOrg().getCode());
                // batch.setUpdateUser(dto.getBody().getLoginCode());
                batch.setUpdateOrg(userInfoService.getOrgCode());
                batch.setUpdateUser(userInfoService.getLoginCode());
                batchMapper.updateByPrimaryKeySelective(batch);// 更新批次信息中的未发货信息
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("fail:" + e);
        }
        return AllNumInfo;
    }

    public static Workbook getWorkBook(MultipartFile file) {
        // 获得文件名
        String fileName = file.getOriginalFilename();
        // 创建Workbook工作薄对象，表示整个excel
        Workbook workbook = null;
        try {
            // 获取excel文件的io流
            InputStream inpu = file.getInputStream();

            // POIFSFileSystem is = new POIFSFileSystem(inpu);//构建POIFSFileSystem类对象，用输入流构建
            // 根据文件后缀名不同(xls和xlsx)获得不同的Workbook实现类对象
            if (fileName.endsWith("xls")) {
                // 2003
                POIFSFileSystem is = new POIFSFileSystem(inpu);
                workbook = new HSSFWorkbook(is);
            } else if (fileName.endsWith("xlsx")) {
                // 2007 及2007以上
                // workbook = new HSSFWorkbook(file.getInputStream());
                workbook = new XSSFWorkbook(file.getInputStream());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return workbook;
    }

    public static String getCellValue(Cell cell) {
        String cellValue = "";
        if (cell == null) {
            return cellValue;
        }
        // 把数字当成String来读，避免出现1读成1.0的情况
        if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
            cell.setCellType(Cell.CELL_TYPE_STRING);
        }
        // 判断数据的类型
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_NUMERIC: // 数字
                cellValue = String.valueOf(cell.getNumericCellValue());
                break;
            case Cell.CELL_TYPE_STRING: // 字符串
                cellValue = String.valueOf(cell.getStringCellValue());
                break;
            case Cell.CELL_TYPE_BOOLEAN: // Boolean
                cellValue = String.valueOf(cell.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_FORMULA: // 公式
                cellValue = String.valueOf(cell.getCellFormula());
                break;
            case Cell.CELL_TYPE_BLANK: // 空值
                cellValue = "";
                break;
            case Cell.CELL_TYPE_ERROR: // 故障
                cellValue = "非法字符";
                break;
            default:
                cellValue = "未知类型";
                break;
        }
        return cellValue;
    }

    public List<Map<String, Object>> getListTree(QueryModel model) {
        return loyQyVirtTicketMapper.getListTree(model);
    }

    public int add(LoyQyVirtTicketKind record) {
        // 生成 主键ID
        String uuid = UUID.randomUUID().toString().toLowerCase().replace("-", "");
        Date date = new Date();
        record.setCreateDate(date);
        record.setUpdateDate(date);
        record.setKindId(uuid);
        return insertSelective(loyQyVirtTicketKindMapper, record);
    }

    public int upd(LoyQyVirtTicketKind record) {
        // TODO 自动生成的方法存根
        return updateSelective(loyQyVirtTicketKindMapper, record);
    }

    public ResultDto<Integer> del(String id) {
        ResultDto<Integer> resultDto = null;
        if (loyQyVirtTicketMapper.selectSubdirectory(id) == 0 && loyQyVirtTicketMapper.selectSubVirtStock(id) == 0) {
            int num = deleteByIds(loyQyVirtTicketKindMapper, id);
            resultDto = new ResultDto<>(num);
            resultDto.setCode(0);
            resultDto.setMessage("删除成功");
            return resultDto;
        }
        resultDto = new ResultDto<>(-1);
        resultDto.setCode(-1);
        resultDto.setMessage("该目录有子目录或有票券信息，不能删除");
        return resultDto;
    }
}
