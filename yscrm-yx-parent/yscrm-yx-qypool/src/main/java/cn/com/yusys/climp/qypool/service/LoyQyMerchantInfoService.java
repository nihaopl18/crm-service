package cn.com.yusys.climp.qypool.service;

import cn.com.yusys.climp.qypool.domain.LoyQyMerchantAddress;
import cn.com.yusys.climp.qypool.domain.LoyQyMerchantContact;
import cn.com.yusys.climp.qypool.domain.LoyQyMerchantInfo;
import cn.com.yusys.climp.qypool.domain.LoyQyMerchantInfoTemp;
import cn.com.yusys.climp.qypool.repository.mapper.LoyQyMerchantAddressMapper;
import cn.com.yusys.climp.qypool.repository.mapper.LoyQyMerchantContactMapper;
import cn.com.yusys.climp.qypool.repository.mapper.LoyQyMerchantInfoMapper;
import cn.com.yusys.climp.qypool.repository.mapper.LoyQyMerchantInfoTempMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @version 1.0.0
 * @项目名称: yusp-climp-qypool-core模块
 * @类名称: LoyQyMerchantInfoService
 * @类描述: #服务类
 * @功能描述:
 * @创建人: hujun3
 * @创建时间: 2019-02-27 14:28:32
 * @修改备注:
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class LoyQyMerchantInfoService extends CommonService {
    private Logger logger = LoggerFactory.getLogger(LoyQyMerchantInfoService.class);
    @Autowired
    private LoyQyMerchantInfoMapper loyQyMerchantInfoMapper;
    @Autowired
    private LoyQyMerchantInfoTempMapper loyQyMerchantInfoTempMapper;
    @Autowired
    private LoyQyMerchantContactMapper loyQyMerchantContactMapper;
    @Autowired
    private LoyQyMerchantAddressMapper loyQyMerchantAddressMapper;
    //	@Autowired
//	private IClientService clientService;
    @Autowired
    private UserInfoService userInfoService;

    @Override
    protected CommonMapper<?> getMapper() {
        return loyQyMerchantInfoMapper;
    }

    /**
     * @方法名称: findAllByParam
     * @方法描述: 商户信息分页查询
     * @参数与返回说明:
     * @算法描述:
     */
    @Transactional(readOnly = true)
    public List<Map<String, Object>> findAllByParam(QueryModel param) {
        // 设置分页查询参数(设置到线程变量中了)
        PageHelper.startPage(param.getPage(), param.getSize());
        List<Map<String, Object>> result = this.loyQyMerchantInfoMapper.queryInfoByPage(param);
        PageHelper.clearPage();
        logger.info("商户信息分页查询");
        return result;
    }

    /**
     * @方法名称: getInfoByParam
     * @方法描述: 商户组件查询商户信息分页查询
     * @参数与返回说明:
     * @算法描述:
     */
    @Transactional(readOnly = true)
    public List<Map<String, Object>> getInfoByParam(QueryModel param) {
        // 设置分页查询参数(设置到线程变量中了)
        PageHelper.startPage(param.getPage(), param.getSize());
        List<Map<String, Object>> result = this.loyQyMerchantInfoMapper.getInfoByPage(param);
        PageHelper.clearPage();
        logger.info("组件查询商户信息分页查询");
        return result;
    }

    /**
     * @方法名称: getInfoById
     * @方法描述: 根主键查询商户信息
     * @参数与返回说明:
     * @算法描述:
     */
    @Transactional(readOnly = true)
    public List<Map<String, Object>> getInfoById(String id) {

        List<Map<String, Object>> result = this.loyQyMerchantInfoMapper.getInfoById(id);

        logger.info("根主键查询商户信息");
        return result;
    }

    /**
     * @方法名称: getContactByMerId
     * @方法描述: 根主键查询商户联系信息
     * @参数与返回说明:
     * @算法描述:
     */
    @Transactional(readOnly = true)
    public List<Map<String, Object>> getContactByMerId(QueryModel param) {
        PageHelper.startPage(param.getPage(), param.getSize());
        List<Map<String, Object>> result = this.loyQyMerchantInfoMapper.getContactByMerId(param);
        PageHelper.clearPage();
        logger.info("查询商户联系信息");
        return result;
    }

    /**
     * @方法名称: getAddressByMerId
     * @方法描述: 根主键查询商户地址信息
     * @参数与返回说明:
     * @算法描述:
     */
    @Transactional(readOnly = true)
    public List<Map<String, Object>> getAddressByMerId(QueryModel param) {
        PageHelper.startPage(param.getPage(), param.getSize());
        List<Map<String, Object>> result = this.loyQyMerchantInfoMapper.getAddressByMerId(param);
        PageHelper.clearPage();
        logger.info("查询商户地址信息");
        return result;
    }

    /**
     * @方法名称: editContactInfo
     * @方法描述: 维护商户联系信息
     * @参数与返回说明:
     * @算法描述:新增，修改
     */
    @Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
    public void editContactInfo(LoyQyMerchantContact pool) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date now = sdf.parse(sdf.format(new Date()));
            pool.setUpdateDate(now);
            pool.setUpdateUser(userInfoService.getLoginCode());
            if (pool.getIfFirst().equals("1")) {
                loyQyMerchantInfoMapper.updateContactIfFrist(pool);
            }
            if (pool.getContactId() == null || pool.getContactId().equals("")) {
                pool.setCreateDate(now);
                pool.setCreateUser(userInfoService.getLoginCode());
                loyQyMerchantContactMapper.insertSelective(pool);
            } else {
                loyQyMerchantContactMapper.updateByPrimaryKeySelective(pool);
            }

        } catch (ParseException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }

        logger.info("维护商户联系信息");
    }

    /**
     * @方法名称: getAddressByMerId
     * @方法描述: 根主键查询商户地址信息
     * @参数与返回说明:
     * @算法描述:新增、修改
     */
    @Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
    public void editAddressByMerId(LoyQyMerchantAddress pool) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date now = sdf.parse(sdf.format(new Date()));
            pool.setUpdateDate(now);
            pool.setUpdateUser(userInfoService.getLoginCode());
            if (pool.getIfFirst().equals("1")) {
                loyQyMerchantInfoMapper.updatAddressIfFirst(pool);
            }
            if (pool.getAddressId() == null || pool.getAddressId().equals("")) {
                pool.setCreateDate(now);
                pool.setCreateUser(userInfoService.getLoginCode());
                loyQyMerchantAddressMapper.insertSelective(pool);
            } else {
                loyQyMerchantAddressMapper.updateByPrimaryKeySelective(pool);
            }
        } catch (ParseException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }

        logger.info("维护商户地址信息");

    }

    /**
     * @方法名称: getInfoById
     * @方法描述: 根主键查询商户信息
     * @参数与返回说明:
     * @算法描述:
     */
    @Transactional(readOnly = true)
    public List<Map<String, Object>> getInfoByIds(String ids) {
        String[] id = ids.split(",");
        List<Map<String, Object>> result = this.loyQyMerchantInfoMapper.getInfoByIds(id);
        logger.info("根主键查询商户信息");
        return result;
    }

    /**
     * @方法名称: addMerchantInfo
     * @方法描述: 新增商户信息
     * @参数与返回说明:
     * @算法描述:
     */
    public String addMerchantInfo(LoyQyMerchantInfo pool) {
        // 获取登录信息
        //ResponseEntity<UserInfoDTO> dto = clientService.getUserSessionInfo(HeaderUtil.getAccessToken());
        String merchantId = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date now = sdf.parse(sdf.format(new Date()));
//			pool.setCreateOrg(dto.getBody().getOrg().getCode());
            pool.setCreateOrg(userInfoService.getOrgId());
            pool.setCreateDate(now);
//	    	pool.setCreateUser(dto.getBody().getLoginCode());
            pool.setCreateUser(userInfoService.getLoginCode());
            pool.setDataSts("I");//O-退出；I-准入；W-暂存
            pool.setWfApprSts("997");
            pool.setUpdateDate(now);
//	    	pool.setUpdateOrg(dto.getBody().getOrg().getCode());
//	    	pool.setUpdateUser(dto.getBody().getLoginCode());
            pool.setUpdateOrg(userInfoService.getOrgId());
            pool.setUpdateUser(userInfoService.getLoginCode());
            loyQyMerchantInfoMapper.insertSelective(pool);
            merchantId = pool.getMerchantId();
        } catch (ParseException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        return merchantId;

    }

    /**
     * @方法名称: updateMerchantInfo
     * @方法描述: 更新商户信息
     * @参数与返回说明:
     * @算法描述:
     */
    public void updateMerchantInfo(LoyQyMerchantInfo pool) {
        // 获取登录信息
        //ResponseEntity<UserInfoDTO> dto = clientService.getUserSessionInfo(HeaderUtil.getAccessToken());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date now = sdf.parse(sdf.format(new Date()));
            pool.setDataSts("W");//O-退出；I-准入；W-暂存
            pool.setWfApprSts("000");
            pool.setUpdateDate(now);
// 	    	pool.setUpdateOrg(dto.getBody().getOrg().getCode());
// 	    	pool.setUpdateUser(dto.getBody().getLoginCode());
            pool.setUpdateOrg(userInfoService.getOrgCode());
            pool.setUpdateUser(userInfoService.getLoginCode());
            loyQyMerchantInfoMapper.updateByPrimaryKeySelective(pool);
        } catch (ParseException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }

    }

    /**
     * @方法名称: updateDataStsInfo
     * @方法描述: 更新数据状态信息
     * @参数与返回说明:
     * @算法描述:
     */
    public void updateDataStsInfo(String ids, String sts) {
        // 获取登录信息
        //	ResponseEntity<UserInfoDTO> dto = clientService.getUserSessionInfo(HeaderUtil.getAccessToken());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date now = sdf.parse(sdf.format(new Date()));
            String[] id = ids.split(",");
            for (int i = 0; i < id.length; i++) {
                LoyQyMerchantInfo pool = loyQyMerchantInfoMapper.selectByPrimaryKey(id[i]);
                pool.setDataSts(sts);
                pool.setUpdateDate(now);
// 	 	     	pool.setUpdateOrg(dto.getBody().getOrg().getCode());
// 	 	     	pool.setUpdateUser(dto.getBody().getLoginCode());
                pool.setUpdateOrg(userInfoService.getOrgCode());
                pool.setUpdateUser(userInfoService.getLoginCode());
                loyQyMerchantInfoMapper.updateByPrimaryKeySelective(pool);
            }
        } catch (ParseException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }

    }

    /**
     * @方法名称: updateWfiStsInfo
     * @方法描述: 更新商户审批状态信息
     * @参数与返回说明:
     * @算法描述:
     */
    public void updateWfiStsInfo(String id, String sts) {
        // 获取登录信息
        // 	ResponseEntity<UserInfoDTO> dto = clientService.getUserSessionInfo(HeaderUtil.getAccessToken());
        LoyQyMerchantInfo pool = loyQyMerchantInfoMapper.selectByPrimaryKey(id);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date now = sdf.parse(sdf.format(new Date()));
            pool.setWfApprSts(sts);
            pool.setUpdateDate(now);
// 	     	pool.setUpdateOrg(dto.getBody().getOrg().getCode());
// 	     	pool.setUpdateUser(dto.getBody().getLoginCode());
            pool.setUpdateOrg(userInfoService.getOrgCode());
            pool.setUpdateUser(userInfoService.getLoginCode());
            loyQyMerchantInfoMapper.updateByPrimaryKeySelective(pool);
        } catch (ParseException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }

    }

    /**
     * @方法名称: wfMerchantProcess
     * @方法描述: 审批结果处理
     * @参数与返回说明:
     * @算法描述:
     */
    public void wfMerchantProcess(String id) {
        // 获取登录信息
        //ResponseEntity<UserInfoDTO> dto = clientService.getUserSessionInfo(HeaderUtil.getAccessToken());
        LoyQyMerchantInfo pool = loyQyMerchantInfoMapper.selectByPrimaryKey(id);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date now = sdf.parse(sdf.format(new Date()));
            pool.setWfApprSts("997");
            pool.setDataSts("I");
            pool.setUpdateDate(now);
//	  	      	pool.setUpdateOrg(dto.getBody().getOrg().getCode());
//	  	      	pool.setUpdateUser(dto.getBody().getLoginCode());
            pool.setUpdateOrg(userInfoService.getOrgCode());
            pool.setUpdateUser(userInfoService.getLoginCode());
            loyQyMerchantInfoMapper.updateByPrimaryKeySelective(pool);
        } catch (ParseException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }

    }

    /**
     * @方法名称: wfMerchantBatchProcess
     * @方法描述: 批量审批结果处理
     * @参数与返回说明:
     * @算法描述:
     */
    public void wfMerchantBatchProcess(String id, String dataSts, String wfSts) {
        // 获取登录信息
        //ResponseEntity<UserInfoDTO> dto = clientService.getUserSessionInfo(HeaderUtil.getAccessToken());
        LoyQyMerchantInfo pool = loyQyMerchantInfoMapper.selectByPrimaryKey(id);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date now = sdf.parse(sdf.format(new Date()));
            pool.setWfApprSts(wfSts);
            //pool.setBatchNo(id);
            pool.setDataSts(dataSts);
            pool.setUpdateDate(now);
//	  	      	pool.setUpdateOrg(dto.getBody().getOrg().getCode());
//	  	      	pool.setUpdateUser(dto.getBody().getLoginCode());
            pool.setUpdateOrg(userInfoService.getOrgCode());
            pool.setUpdateUser(userInfoService.getLoginCode());
            loyQyMerchantInfoMapper.updateByPrimaryKeySelective(pool);
        } catch (ParseException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }

    }

    /**
     * @方法名称: deleteMerchantInfo
     * @方法描述: 删除商户信息
     * @参数与返回说明:
     * @算法描述:删除商户信息的同时也要删除地址信息和联系信息
     */
    @Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
    public void deleteMerchantInfo(String ids) {
        String[] id = ids.split(",");
        for (int i = 0; i < id.length; i++) {
            loyQyMerchantInfoMapper.deleteByIds(id[i]);
            loyQyMerchantInfoMapper.deleteAddressInfo(id[i]);
            loyQyMerchantInfoMapper.deleteContactInfo(id[i]);
        }

    }

    /**
     * @方法名称: deleteContactInfo
     * @方法描述: 删除商户联系信息
     * @参数与返回说明:
     * @算法描述:
     */
    @Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
    public void deleteContactInfo(String ids) {
        String[] id = ids.split(",");
        for (int i = 0; i < id.length; i++) {
            loyQyMerchantContactMapper.deleteByIds(id[i]);
        }

    }

    /**
     * @方法名称: deleteAddressInfo
     * @方法描述: 删除商户地址信息
     * @参数与返回说明:
     * @算法描述:
     */
    @Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
    public void deleteAddressInfo(String ids) {
        String[] id = ids.split(",");
        for (int i = 0; i < id.length; i++) {
            loyQyMerchantAddressMapper.deleteByIds(id[i]);
        }

    }

    /**
     * @方法名称: dataImport
     * @方法描述:批量导入商户处理逻辑
     * @参数与返回说明:
     * @算法描述:读取excel中的数据存放到临时表中，去重后再存入正式表中
     */
    @Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
    public String dataImport(String flag, MultipartFile file) throws Exception {

        String batchNo = "B" + new Date().getTime();//批次号
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = sdf.parse(sdf.format(new Date()));
        String AllNumInfo = "";
        // 获取登录信息
        //ResponseEntity<UserInfoDTO> dto = clientService.getUserSessionInfo(HeaderUtil.getAccessToken());
        try {
            //获得Workbook工作薄对象
            Workbook workbook = getWorkBook(file);
            //创建返回对象，把每行中的值作为一个数组，所有行作为一个集合返回

            if (workbook != null) {
                for (int sheetNum = 1; sheetNum < workbook.getNumberOfSheets(); sheetNum++) {
                    //获得当前sheet工作表
                    Sheet sheet = workbook.getSheetAt(sheetNum);
                    String sheetname = workbook.getSheetName(sheetNum);
                    if (sheet == null) {
                        continue;
                    }
                    //获得当前sheet的开始行
                    int firstRowNum = sheet.getFirstRowNum();
                    String headStr = "";
                    Row headrow = sheet.getRow(firstRowNum);
                    //获得表头行的开始列
                    int headfirstCellNum = headrow.getFirstCellNum();
                    //获得表头行的列数
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
                    boolean iii = headStr.equals("商户名称,商户工商名称,商户门店名称,法人名称,证件类型,证件号,经营类目,联系信息,详细地址,商户介绍,经营内容介绍");
                    if (!iii) {
                        //return "表格格式不对，请下载模板填写";
                        throw new YuspException(new Message("2006", "EXCEL的第" + sheetNum + "页的表格格式不对，请下载模板填写!", "error"));
                    }
                    //获得当前sheet的结束行
                    int lastRowNum = sheet.getLastRowNum();
                    int rowCount = sheet.getPhysicalNumberOfRows();
                    List<LoyQyMerchantInfoTemp> data = new ArrayList<LoyQyMerchantInfoTemp>();
                    //判断表内字段是否为空 
                    for (int rowNum = firstRowNum + 1; rowNum <= lastRowNum; rowNum++) {
                        //获得当前行
                        String RowData = "";
                        Row row = sheet.getRow(rowNum);
                        if (row == null) {
                            continue;
                        }
                        //获得当前行的开始列
                        int firstCellNum = row.getFirstCellNum();
                        //获得当前行的列数
                        int lastCellNum = row.getPhysicalNumberOfCells();
//                        String[] cells = new String[row.getPhysicalNumberOfCells()];
                        //循环当前行
                        LoyQyMerchantInfoTemp lbbl = new LoyQyMerchantInfoTemp();
                        lbbl.setBatchNo(batchNo);
                        for (int cellNum = firstCellNum; cellNum < lastCellNum; cellNum++) {
                            Cell cell = row.getCell(cellNum);
//                            cells[cellNum] = getCellValue(cell);
                            switch (cellNum) {
                                case 0://商户名称
                                    lbbl.setMerchantName(getCellValue(cell));
                                    break;
                                case 1://商户工商名称
                                    lbbl.setMerIacName(getCellValue(cell));
                                    break;
                                case 2:
                                    ;//商户门店名称
                                    lbbl.setMerStroeName(getCellValue(cell));
                                    break;
                                case 3://法人名称
                                    lbbl.setLegalPersonNm(getCellValue(cell));
                                    break;
                                case 4://证件类型
                                    lbbl.setCertType(getCellValue(cell));
                                    break;
                                case 5://证件号
                                    lbbl.setCertNo(getCellValue(cell));
                                    break;
                                case 6://经营类目
                                    lbbl.setManageAtype(getCellValue(cell));
                                    break;
                                case 7://联系信息
                                    lbbl.setContactInfo(getCellValue(cell));
                                    break;
                                case 8://详细地址
                                    lbbl.setAddressInfo(getCellValue(cell));
                                    break;
                                case 9://商户介绍
                                    lbbl.setMerRemark(getCellValue(cell));
                                    break;
                                case 10://经营内容介绍
                                    lbbl.setManageContent(getCellValue(cell));
                                    break;
                            }

                        }
                        if (lbbl.getMerchantName() == null || lbbl.getCertNo() == null || lbbl.getCertType() == null) {
                            throw new YuspException(new Message("2006", "商户名称、证件类型，证件号字段不能为空，请检查EXCEL的第" + sheetNum + "页的第" + rowNum + "行!", "error"));
                        }

//                        lbbl.setCreateOrg(dto.getBody().getOrg().getCode());
                        lbbl.setCreateOrg(userInfoService.getOrgCode());
                        lbbl.setCreateDate(now);
//                        lbbl.setCreateUser(dto.getBody().getLoginCode());
                        lbbl.setCreateUser(userInfoService.getLoginCode());
                        lbbl.setDataSts("W");//A-生效；I-失效；W-待生效
                        lbbl.setWfApprSts("000");
                        lbbl.setUpdateDate(now);
//                        lbbl.setUpdateOrg(dto.getBody().getOrg().getCode());
//                        lbbl.setUpdateUser(dto.getBody().getLoginCode());
                        lbbl.setUpdateOrg(userInfoService.getOrgCode());
                        lbbl.setUpdateUser(userInfoService.getLoginCode());
                        data.add(lbbl);
                    }
                    for (int s = 0; s < data.size(); s++) {//循环插入临时表数据数据
                        loyQyMerchantInfoTempMapper.insertSelective(data.get(s));
                    }

                }
                List<Map<String, Object>> AllNum = loyQyMerchantInfoMapper.getNum(batchNo);//获取导入的总数
                AllNumInfo = AllNum.get(0).get("num").toString();
                loyQyMerchantInfoMapper.insertList(batchNo);//把临时表中的数据插入到正式表中
                loyQyMerchantInfoMapper.deleteTempInfo(batchNo);//删除临时表中的数据
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("fail:" + e);
        }
        return AllNumInfo;
    }

    public static Workbook getWorkBook(MultipartFile file) {
        //获得文件名
        String fileName = file.getOriginalFilename();
        //创建Workbook工作薄对象，表示整个excel
        Workbook workbook = null;
        try {
            //获取excel文件的io流
            InputStream inpu = file.getInputStream();

            //  POIFSFileSystem is = new POIFSFileSystem(inpu);//构建POIFSFileSystem类对象，用输入流构建
            //根据文件后缀名不同(xls和xlsx)获得不同的Workbook实现类对象
            if (fileName.endsWith("xls")) {
                //2003
                POIFSFileSystem is = new POIFSFileSystem(inpu);
                workbook = new HSSFWorkbook(is);
            } else if (fileName.endsWith("xlsx")) {
                //2007 及2007以上
//                	workbook = new HSSFWorkbook(file.getInputStream());
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
        //把数字当成String来读，避免出现1读成1.0的情况
        if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
            cell.setCellType(Cell.CELL_TYPE_STRING);
        }
        //判断数据的类型
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_NUMERIC: //数字
                cellValue = String.valueOf(cell.getNumericCellValue());
                break;
            case Cell.CELL_TYPE_STRING: //字符串
                cellValue = String.valueOf(cell.getStringCellValue());
                break;
            case Cell.CELL_TYPE_BOOLEAN: //Boolean
                cellValue = String.valueOf(cell.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_FORMULA: //公式
                cellValue = String.valueOf(cell.getCellFormula());
                break;
            case Cell.CELL_TYPE_BLANK: //空值
                cellValue = "";
                break;
            case Cell.CELL_TYPE_ERROR: //故障
                cellValue = "非法字符";
                break;
            default:
                cellValue = "未知类型";
                break;
        }
        return cellValue;
    }

    public List<Map<String, Object>> getAddressProvince() {
        // TODO 自动生成的方法存根
        return loyQyMerchantAddressMapper.getAddressProvince();
    }

    public List<Map<String, Object>> getAddressCity(QueryModel model) {
        // TODO 自动生成的方法存根
        return loyQyMerchantAddressMapper.getAddressCity(model);
    }

    public List<Map<String, Object>> getAddressArea(QueryModel model) {
        // TODO 自动生成的方法存根
        return loyQyMerchantAddressMapper.getAddressArea(model);
    }

}
