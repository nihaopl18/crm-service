package cn.com.yusys.yscrm.cust.group.service;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.MathContext;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import cn.com.yusys.yscrm.cust.group.domain.*;
import cn.com.yusys.yscrm.cust.group.web.rest.OcrmFciCgBaseResource;
import cn.com.yusys.yscrm.custflexEs.service.CmssFCiFqService;
import cn.com.yusys.yscrm.custpub.service.OcrmFciAdmitBelongService;
import cn.com.yusys.yscrm.pcrm.common.remindInfo.utils.ExportExcelUtils2;
import cn.com.yusys.yscrm.pcrm.common.remindInfo.utils.selectroleUtils;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.fill.FillConfig;
import com.alibaba.excel.write.metadata.fill.FillWrapper;
import com.alibaba.fastjson.JSON;
import oracle.sql.STRUCT;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;
import cn.com.yusys.yscrm.cust.group.repository.mapper.OcrmFciCgBaseMapper;
import cn.com.yusys.yucrm.custgroup.util.UtilTools;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

/**
 * @version 1.0.0
 * @项目名称: yscrm-entity-cust-group-core模块
 * @类名称: OcrmFciCgBaseService
 * @类描述: #服务类
 * @功能描述:
 * @创建人: hyx
 * @创建时间: 2019-01-18 10:34:12
 * @修改备注:
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class OcrmFciCgBaseService extends CommonService {
    @Autowired
    private OcrmFciCgBaseMapper ocrmFciCgBaseMapper;

    @Autowired
    private OcrmFciCgMemberService ocrmFciCgMemberService;

    @Autowired
    private OcrmFciAdmitBelongService ocrmFciAdmitBelongService;

    @Autowired
    private CmssFCiFqService cmssFCiFqService;

    @Autowired
    private UaaClient uaaClient;
    private final Logger log = LoggerFactory.getLogger(OcrmFciCgBaseResource.class);
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
    private static final String DATA_DATE = "dataDate";
    private static final String CUST_NUMBER = "custNumber";
    private static final String CG_DEPOSIT_BALANCE = "cgDepositBalance";
    private static final String CUST_ID = "custId";
    //总行
    @Value("${role.headOffice}")
    private String headOffice;
    //总行理财个贷主管
    @Value("${role.headOfficeB}")
    private String headOfficeB;
    //分行
    @Value("${role.branch}")
    private String branch;
    //支行
    @Value("${role.subbranch}")
    private String subbranch;
    //客户经理
    @Value("${role.customerManage}")
    private String  customerManage;
    //团队
    @Value("${role.patrolLeader}")
    private String patrolLeader;
    public OcrmFciCgBaseService() {
    }

    @Override
    protected CommonMapper<?> getMapper() {
        return ocrmFciCgBaseMapper;
    }

    public UserInfoDTO getUserInfoDTO() {
        ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
        UserInfoDTO user = dto.getBody();
        return user;
    }

    // 新增时检查名称是否重复  0为可以新增 非0为不可新增
    public int checkName(String name) {
        return ocrmFciCgBaseMapper.checkName(name);
    }

    // 修改时检查名称是否重复  0为可以修改 非0为不可修改
    public int checkUpName(String id, String name) {
        // TODO 自动生成的方法存根
        return ocrmFciCgBaseMapper.checkUpName(id, name);
    }

    // 客户群新增
    @Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
    public OcrmFciCgBase add(Map<String, String> map) {
        UserInfoDTO user = getUserInfoDTO();
        String userId = user.getUserId();
        Date date = new Date();
        OcrmFciCgBase c = new OcrmFciCgBase();
        c.setCustGroupId(ocrmFciCgBaseMapper.getSeq());
        c.setCorpOrgCode("001");
        c.setCreateUser(userId);
        c.setUpdateUser(userId);
        c.setCreateOrg(user.getOrg().getCode());
        c.setCreateDate(date);
        c.setUpdateDate(date);
        c.setCustGroupName(map.get("custGroupName"));
        c.setCustGroupType(map.get("custGroupType"));
        c.setCustOrigin(map.get("custOrigin"));
        c.setShareScope(map.get("shareScope"));
        c.setExpireDate(getExpireDate(30));
        c.setGroupMemberType(map.get("groupMemberType"));
        c.setRemark(map.get("remark"));
            return c; //新增成功返回当前对象
    }

    public Date getExpireDate(int num) {
        Date d = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currdate = format.format(d);
        System.out.println("现在的日期是：" + currdate);

        Calendar ca = Calendar.getInstance();
        ca.add(Calendar.DATE, num);// num为增加的天数，可以改变的
        d = ca.getTime();
        return d;
    }

    // 客户群修改
    public int updateFun(OcrmFciCgBase c) {
        UserInfoDTO user = getUserInfoDTO();
        c.setUpdateDate(new Date());
        c.setUpdateUser(user.getUserId());
        return ocrmFciCgBaseMapper.updateFun(c);
    }

    public List<Map<Object, String>> getListByModel(QueryModel model) {
        // TODO 自动生成的方法存根
        PageHelper.startPage(model.getPage(), model.getSize());
        List<Map<Object, String>> list = ocrmFciCgBaseMapper.getListByModel(model);
        PageHelper.clearPage();
        return list;
    }

    public Map<String, String> getGroupInfoByModel(QueryModel queryModel) {
        // TODO 自动生成的方法存根
        String groupId = (String) queryModel.getCondition().get("groupId");
        return ocrmFciCgBaseMapper.getGroupInfoByModel(groupId);
    }

    // 修改方法
    public OcrmFciCgBase updateAuto(OcrmFciCgBase c) {
        // TODO 自动生成的方法存根
        UserInfoDTO user = getUserInfoDTO();
        String userId = user.getUserId();
        Date date = new Date();
        String dt = simpleDateFormat.format(date);
        c.setUpdateDate(date);
        c.setUpdateUser(userId);
        if (ocrmFciCgBaseMapper.updateByPrimaryKeySelective(c) == 1) {
            ocrmFciCgBaseMapper.delecteMemberByGroupId(c.getCustGroupId());
            String sql = "insert into cg_join_cust (cust_id,id,cust_group_id,corp_org_code,create_user,update_user,update_date,create_date) select cust_id_base,cust_id_base || " + c.getCustGroupId() + ",\'" + c.getCustGroupId() + "\',001,\'" + userId + "\',\'" + userId + "\',to_date(\'" + dt + "\',\'yyyy-mm-dd\'),to_date(\'" + dt + "\',\'yyyy-mm-dd\') from (" + c.getSql() + ")";
            Map<String, String> map = new HashMap<>();
            map.put("sql", sql);
            ocrmFciCgBaseMapper.updateAuto(map);
            ocrmFciCgBaseMapper.updateAutoCust(map);
            ocrmFciCgBaseMapper.cgdelete(map);
            return c;
        }
        return null;
    }

    public Map<String, String> getOrgLevel(String orgId) {
        // TODO 自动生成的方法存根
        return ocrmFciCgBaseMapper.getOrgLevel(orgId);
    }

    public Map<String, String> getOneOrg(Map<String, String> map) {
        // TODO 自动生成的方法存根
        return ocrmFciCgBaseMapper.getOneOrg(map);
    }

    public List<CrmFCgPreparationVO> getcustomerList(CrmCustomerDTO crmCustomerDTO) {
        if (StringUtils.isNotEmpty(crmCustomerDTO.getTagNo())) {
            gettag(crmCustomerDTO);
        }
        if (StringUtils.isNotEmpty(crmCustomerDTO.getCustGrade())) {
            String[] cust = crmCustomerDTO.getCustGrade().split(",");
            String str = "";
                str = "in(";
                for (int i = 0; i < cust.length; i++) {
                    str += "'" + cust[i] + "',";
                }
                str = str.substring(0, str.length() - 1);
                str += ")";
            crmCustomerDTO.setCustGrade(str);
        }
        if(StringUtils.isNotEmpty(crmCustomerDTO.getAumBalanceStart()) && crmCustomerDTO.getAumBalanceStart()!="0"){
            BigDecimal a = new BigDecimal(crmCustomerDTO.getAumBalanceStart()).setScale(2,BigDecimal.ROUND_HALF_UP);
            crmCustomerDTO.setAumBalanceStart(String.valueOf(a.multiply(new BigDecimal(10000))));
        }
        if(StringUtils.isNotEmpty(crmCustomerDTO.getAumBalanceEnd()) && crmCustomerDTO.getAumBalanceEnd()!="0"){
            BigDecimal a = new BigDecimal(crmCustomerDTO.getAumBalanceEnd()).setScale(2,BigDecimal.ROUND_HALF_UP);
            crmCustomerDTO.setAumBalanceEnd(String.valueOf(a.multiply(new BigDecimal(10000))));
        }
        PageHelper.startPage(crmCustomerDTO.getPage(), crmCustomerDTO.getSize());
        log.info("TagNo:" + crmCustomerDTO.getTagNo());
        UserInfoDTO userInfoDTO = getUserInfoDTO();
        crmCustomerDTO.set_orgCode(userInfoDTO.getOrg().getCode());
        crmCustomerDTO.set_userCode(userInfoDTO.getLoginCode());
        Date newDate = new Date();
        String dataDate = simpleDateFormat.format(newDate);
        crmCustomerDTO.setDataDate(dataDate);
        crmCustomerDTO.setMgrType(ocrmFciAdmitBelongService.getmgrType());
        if("01".equals(crmCustomerDTO.getExpireNo())){
            crmCustomerDTO.setIsfixedDepositMature("Y");
        }else if("02".equals(crmCustomerDTO.getExpireNo())){
            crmCustomerDTO.setIsLoanMature("Y");
        }else if("03".equals(crmCustomerDTO.getExpireNo())){
            crmCustomerDTO.setIsFinMature("Y");
        }
        if(StringUtils.isEmpty(crmCustomerDTO.getMgrType())){
            crmCustomerDTO.setMgrType("1");
        }
        crmCustomerDTO.setLoanValue("Y");
        crmCustomerDTO.setLoanValueValue(getTure(crmCustomerDTO));
        PageHelper.startPage(crmCustomerDTO.getPage(), crmCustomerDTO.getSize());
        //查询基本信息
        List<CrmFCgPreparationVO> list = ocrmFciCgBaseMapper.getcustomerList(crmCustomerDTO);
       /* Set<CrmFCgPreparationVO> set=new TreeSet<CrmFCgPreparationVO>(new Comparator<CrmFCgPreparationVO>() {
            @Override
            public int compare(CrmFCgPreparationVO o1, CrmFCgPreparationVO o2) {
                return o1.getCustId().compareTo(o2.getCustId());
            }
        });
        set.addAll(list);
        List<CrmFCgPreparationVO> lists=new ArrayList<CrmFCgPreparationVO>(set);*/
        PageHelper.clearPage();
        return list;
    }

    private String getTure(CrmCustomerDTO crmCustomerDTO) {
        String value="";
        Map<String,Object> map=new HashMap<>();
        map.put("AumBalanceStart",crmCustomerDTO.getAumBalanceStart());
        map.put("AumBalanceEnd",crmCustomerDTO.getAumBalanceEnd());
        map.put("IsOnePaperCust",crmCustomerDTO.getIsOnePaperCust());
        map.put("IsAccreditedInvestor",crmCustomerDTO.getIsAccreditedInvestor());
        map.put("IsFinCust",crmCustomerDTO.getIsFinCust());
        map.put("IsParkingInstallment",crmCustomerDTO.getIsParkingInstallment());
        map.put("IsPerHouseLoan",crmCustomerDTO.getIsPerHouseLoan());
        map.put("IsLegalHouseLoan",crmCustomerDTO.getIsLegalHouseLoan());
        map.put("IsCreditCardCust",crmCustomerDTO.getIsCreditCardCust());
        map.put("IsfixedDepositMature",crmCustomerDTO.getIsfixedDepositMature());
        map.put("IsLoanMature",crmCustomerDTO.getIsLoanMature());
        map.put("IsFinMature",crmCustomerDTO.getIsFinMature());
        map.put("IsMktBlack",crmCustomerDTO.getIsMktBlack());
        for(Map.Entry<String, Object> entry : map.entrySet()){
            if(entry.getValue() != null && !"".equals(entry.getValue())){
                return value="01";
        }
    }
        return value="";
    }

    private void gettag(CrmCustomerDTO crmCustomerDTO) {
        ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
        UserInfoDTO user = dto.getBody();
        if (StringUtils.isNotEmpty(crmCustomerDTO.getTagName())) {
            String[] tagNoNo = crmCustomerDTO.getTagNo().split(",");
            for (int i = 0; i < tagNoNo.length; i++) {
                CrmFCgTagcountTag crmFCgTagcountTag = new CrmFCgTagcountTag();
                crmFCgTagcountTag.setCreateDate(new Date());
                crmFCgTagcountTag.setCreateUser(user.getUserName());
                crmFCgTagcountTag.setDataDate(new Date());
                crmFCgTagcountTag.setOrgId(user.getOrg().getCode());
                crmFCgTagcountTag.setSamId(user.getLoginCode());
                crmFCgTagcountTag.setSeqno(UtilTools.getUUID());
                crmFCgTagcountTag.setTagId(tagNoNo[i]);
                crmFCgTagcountTag.setTagName(ocrmFciCgBaseMapper.gettagName(tagNoNo[i]));
                ocrmFciCgBaseMapper.insertCountTage(crmFCgTagcountTag);
            }
        }
    }

    public int updateBase(CrmFCissCgBase crmFCissCgBase) {
        UserInfoDTO user = getUserInfoDTO();
        crmFCissCgBase.setUpdateDate(new Date());
        crmFCissCgBase.setUpdateUser(user.getUserName());
        String[] custGroupId = crmFCissCgBase.getCustGroupId().split(",");
        String str = "";
        if (custGroupId != null && custGroupId.length > 0) {
            str = "in(";
            for (int i = 0; i < custGroupId.length; i++) {
                str += "'" + custGroupId[i] + "',";
            }
            str = str.substring(0, str.length() - 1);
            str += ")";
        }
        crmFCissCgBase.setCustGroupId(str);
        return ocrmFciCgBaseMapper.updateBase(crmFCissCgBase);
    }

    public List<CrmFCissCgBaseVO> queryBaselist(CrmBaseDTO crmBaseDTO) {
        ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
        UserInfoDTO user = dto.getBody();

        Map<String, String> map = new HashMap<>();
     /*   if ("".equals(crmBaseDTO.getIsFocus())) {
            crmBaseDTO.setIsFocus("01");
        }*/
        if ("02".equals(crmBaseDTO.getIsFocus())) {
            crmBaseDTO.setIsFocus("");
        }
        UserInfoDTO userInfoDTO = getUserInfoDTO();
        crmBaseDTO.set_orgCode(userInfoDTO.getOrg().getCode());
        crmBaseDTO.set_userCode(userInfoDTO.getLoginCode());
        crmBaseDTO.setOrgIdAuth(user.getOrg().getCode());
        crmBaseDTO.setCreateUser(user.getUserName());
        //查询客户群基本信息
        List<CrmFCissCgBase> list = ocrmFciCgBaseMapper.queryBaselist(crmBaseDTO);
        //查询客户数量
        List<CrmBaseCountVo> listCount = ocrmFciCgBaseMapper.countCustomer(crmBaseDTO);
        List<CrmFCissCgBaseVO> Querylist = new ArrayList<>();
        if (listCount.size() == 0) {
            Querylist = getListCustomerlist(list);
        } else {
            Querylist = getListCustomer(list, listCount);
        }
          Set<CrmFCissCgBaseVO> set=new TreeSet<CrmFCissCgBaseVO>(new Comparator<CrmFCissCgBaseVO>() {
            @Override
            public int compare(CrmFCissCgBaseVO o1, CrmFCissCgBaseVO o2) {
                return o1.getCustGroupId().compareTo(o2.getCustGroupId());
            }
        });
        set.addAll(Querylist);
        List<CrmFCissCgBaseVO> lists=new ArrayList<CrmFCissCgBaseVO>(set);
        List<CrmFCissCgBaseVO> CrmFCissCgBa =null;
        CrmFCissCgBa = lists.stream().sorted(Comparator.comparing(CrmFCissCgBaseVO::getIsFocus).thenComparing(CrmFCissCgBaseVO::getCreateDate,Comparator.reverseOrder())).collect(Collectors.toList());
        return CrmFCissCgBa;
    }

    private List<CrmFCissCgBaseVO> getListCustomerlist(List<CrmFCissCgBase> list) {
        List<CrmFCissCgBaseVO> Querylist = new ArrayList<>();
        for (CrmFCissCgBase crmFCissCgBase : list) {
            Querylist.add(getListCustomer(crmFCissCgBase));
        }
        return Querylist;
    }
    private CrmFCissCgBaseVO getListCustomer(CrmFCissCgBase crmFCissCgBase) {
             CrmFCissCgBaseVO crmFCissCgBaseVO = new CrmFCissCgBaseVO();
             BeanUtils.copyProperties(crmFCissCgBase, crmFCissCgBaseVO);
             crmFCissCgBaseVO.setFloatCustomer(0);
             crmFCissCgBaseVO.setInitialCout(String.valueOf(0));
           return crmFCissCgBaseVO;
    }
    private List<CrmFCissCgBaseVO> getListCustomer(List<CrmFCissCgBase> list, List<CrmBaseCountVo> listCount) {
        List<CrmFCissCgBaseVO> Querylist = new ArrayList<>();
        for (CrmFCissCgBase crmFCissCgBase : list) {
            if (listCount.stream().filter(w -> String.valueOf(w.getCustGroupId()).equals(crmFCissCgBase.getCustGroupId())).findAny().isPresent()) {
                CrmFCissCgBaseVO crmFCissCgBaseVO = new CrmFCissCgBaseVO();
                BeanUtils.copyProperties(crmFCissCgBase, crmFCissCgBaseVO);
                for (CrmBaseCountVo crmBaseCountVo : listCount) {
                    if (crmBaseCountVo.getCustGroupId().equals(crmFCissCgBase.getCustGroupId())) {
                        crmFCissCgBaseVO.setFloatCustomer(crmBaseCountVo.getCount() - Integer.parseInt(crmFCissCgBase.getInitialCout()));
                        crmFCissCgBaseVO.setInitialCout(String.valueOf(crmBaseCountVo.getCount()));
                    }
                }
                Querylist.add(crmFCissCgBaseVO);
            } else {
                Querylist.add(getListCustomer(crmFCissCgBase));
            }
        }
        Set<CrmFCissCgBaseVO> set = new TreeSet<CrmFCissCgBaseVO>(new Comparator<CrmFCissCgBaseVO>() {
            @Override
            public int compare(CrmFCissCgBaseVO o1, CrmFCissCgBaseVO o2) {
                return o1.getCustGroupId().compareTo(o2.getCustGroupId());
            }
        });
        set.addAll(Querylist);
        List<CrmFCissCgBaseVO> lists = new ArrayList<CrmFCissCgBaseVO>(set);
        return lists;
    }

    public List<CrmFCgPreparationVO> queryBaseCustomerlist(CrmBasePreparDTO crmBasePreparDTO) {
        Map<String, String> mapMap = new HashMap<>();
        mapMap.putAll(getcustGroupId(crmBasePreparDTO.getCustGroupId()));
        mapMap.put("queryCriteria", crmBasePreparDTO.getQueryCriteria());
        mapMap.put("mgrType", ocrmFciAdmitBelongService.getmgrType());
        PageHelper.startPage(crmBasePreparDTO.getPage(), crmBasePreparDTO.getSize());
        //客户列表信息
        List<CrmFCgPreparationVO> listpre = ocrmFciCgBaseMapper.selectPreparation(mapMap);
        /*Set<CrmFCgPreparationVO> set=new TreeSet<CrmFCgPreparationVO>(new Comparator<CrmFCgPreparationVO>() {
            @Override
            public int compare(CrmFCgPreparationVO o1, CrmFCgPreparationVO o2) {
                return o1.getCustId().compareTo(o2.getCustId());
            }
        });
        set.addAll(listpre);
        List<CrmFCgPreparationVO> lists=new ArrayList<CrmFCgPreparationVO>(set);*/
        PageHelper.clearPage();
        return listpre;
    }

    private Map<String, String> getcustGroupId(String custGroupId) {
        Map<String, String> map=new HashMap<>();
        map.put("custGroupId", custGroupId);
        return map;
    }

    public int deleteBaseCustomer(CrmBaseCuDTO crmBaseCuDTO) {
        int count = 0;
        if (StringUtils.isNotEmpty(crmBaseCuDTO.getCustId())) {
            String[] custId = crmBaseCuDTO.getCustId().split(",");
            String str = "";
            if (custId != null && custId.length > 0) {
                str = "in(";
                for (int i = 0; i < custId.length; i++) {
                    str += "'" + custId[i] + "',";
                    count = i + 1;
                }
                str = str.substring(0, str.length() - 1);
                str += ")";
            }
            crmBaseCuDTO.setCustId(str);
        }
        int i = ocrmFciCgBaseMapper.deleteBaseCustomer(crmBaseCuDTO);
        String type = "02";
        insertchange(crmBaseCuDTO, count, type);
        return i;
    }

    private void insertchange(CrmBaseCuDTO crmBaseCuDTO, int count, String type) {
        ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
        UserInfoDTO user = dto.getBody();
        CrmFCgJournal crmFCgJournal = new CrmFCgJournal();
        crmFCgJournal.setSeqno(UtilTools.getUUID());
        crmFCgJournal.setSamId(user.getLoginCode());
        crmFCgJournal.setChangeCount(String.valueOf(count));
        crmFCgJournal.setChangeType(type);
        crmFCgJournal.setCreateDate(new Date());
        crmFCgJournal.setCreateUser(user.getUserName());
        crmFCgJournal.setCustGroupName(ocrmFciCgBaseMapper.selectGroupName(crmBaseCuDTO.getCustGroupId()));
        crmFCgJournal.setCustGroupNo(crmBaseCuDTO.getCustGroupId());
        if(crmBaseCuDTO.getCustId().contains("in")){
            crmBaseCuDTO.setCustId(crmBaseCuDTO.getCustId().replaceAll("[()]", "").replaceAll("in", "").replaceAll("\'", ""));
        }
        crmFCgJournal.setCustidCollect(crmBaseCuDTO.getCustId());
        crmFCgJournal.setOrgId(user.getOrg().getCode());
        ocrmFciCgBaseMapper.insertchange(crmFCgJournal);
    }

    public List<CrmFCgJournalVO> Selectjournal(CrmBasePreparDTO crmBasePreparDTO) {
        PageHelper.startPage(crmBasePreparDTO.getPage(), crmBasePreparDTO.getSize());
        Map<String, String> mapMap = new HashMap<>();
        mapMap.putAll(getcustGroupId(crmBasePreparDTO.getCustGroupId()));
        List<CrmFCgJournalVO> list = ocrmFciCgBaseMapper.Selectjournal(mapMap);
        PageHelper.clearPage();
        return list;
    }

    public Map<String, List<Map<String, Object>>> queryIndexStatuslist(CrmIndexStatusDTO crmIndexStatusDTO) throws Exception {
        String newDate = ocrmFciCgBaseMapper.selectMaxDate(crmIndexStatusDTO.getCustGroupId());
        Map<String, String> mapMap = new HashMap<>();
        if("undefined".equals(crmIndexStatusDTO.getStartDate())){
            crmIndexStatusDTO.setStartDate("");
        }
        if("undefined".equals(crmIndexStatusDTO.getEndDate())){
            crmIndexStatusDTO.setEndDate("");
        }
        if(StringUtils.isEmpty(crmIndexStatusDTO.getCustomerType())){
            crmIndexStatusDTO.setCustomerType("02");
        }
        crmIndexStatusDTO=getDateNew(newDate,crmIndexStatusDTO);
        mapMap.putAll(getcustGroupId(crmIndexStatusDTO.getCustGroupId()));
        mapMap.put("StartDate", crmIndexStatusDTO.getStartDate());
        mapMap.put("endDate", crmIndexStatusDTO.getEndDate());
        Map<String, String> mapMapMap = new HashMap<>();
        if (StringUtils.isNotEmpty(newDate)) {
            Date date = sdf.parse(newDate);
            mapMapMap.put("endDate", sdf.format(date).substring(0, 7));
        }
        mapMapMap.putAll(getcustGroupId(crmIndexStatusDTO.getCustGroupId()));
        //查询连续区间
        List<CrmFCissCgIndexStats> list = ocrmFciCgBaseMapper.queryIndexStatuslist(mapMap);
        //查询客户同比环比
        CrmFCissCgIndexStats crmFCissCgIndexStatsSt = ocrmFciCgBaseMapper.queryIndexStatuslistMap(mapMapMap);
        //查询时点
        CrmFCissCgIndexStats crmFCissCgIndexStats = ocrmFciCgBaseMapper.queryIndexStatuslistMap(mapMap);

        //查询标签统计数

        List<CrmFCgCustomerTag> crmFCgCustomerTagList = ocrmFciCgBaseMapper.querycrmFCgCustomerTagList(mapMap);

        Map<String, List<Map<String, Object>>> maplist = new HashMap<>();
        //整合数据
        if ("02".equals(crmIndexStatusDTO.getCustomerType())) {
            //同比环比数据整合
            if (crmFCissCgIndexStatsSt != null) {
                List<Map<String, Object>> list1 = new ArrayList<>();
                Map<String, Object> map1 = new HashMap<>();
                map1.put(DATA_DATE, crmFCissCgIndexStatsSt.getDataDate());
                map1.put(CUST_NUMBER, crmFCissCgIndexStatsSt.getCustNumber());
                map1.put("custNumberQqq", crmFCissCgIndexStatsSt.getCustNumberQoq());
                map1.put("custNumberYoy", crmFCissCgIndexStatsSt.getCustNumberYoy());
                map1.put("cgAumYearAvgBalance", crmFCissCgIndexStatsSt.getCgAumYearAvgBalance());
                map1.put("cgAumYearAvgBalanceQqq", crmFCissCgIndexStatsSt.getCgAumYearAvgBalanceQoq());
                map1.put("cgAumYearAvgBalanceYoy", crmFCissCgIndexStatsSt.getCgAumYearAvgBalanceYoy());
                map1.put(CG_DEPOSIT_BALANCE, crmFCissCgIndexStatsSt.getCgDepositBalance());
                map1.put("cgDepositBalanceQqq", crmFCissCgIndexStatsSt.getCgDepositBalanceQoq());
                map1.put("cgDepositBalanceYoy", crmFCissCgIndexStatsSt.getCgDepositBalanceYoy());
                map1.put("cgLoanBalance", crmFCissCgIndexStatsSt.getCgLoanBalance());
                map1.put("cgLoanBalanceQqq", crmFCissCgIndexStatsSt.getCgLoanBalanceQoq());
                map1.put("cgLoanBalanceYoy", crmFCissCgIndexStatsSt.getCgLoanBalanceYoy());
                list1.add(map1);
                maplist.put("proportion", list1);
            }  //客户等级
            if (crmFCissCgIndexStats != null) {
                Map<String, Object> map2 = new HashMap<>();
                List<Map<String, Object>> list2 = new ArrayList<>();
                map2.put(DATA_DATE, crmFCissCgIndexStats.getDataDate());
                map2.put("custGrade1Number", crmFCissCgIndexStats.getCustGrade1Number());
                map2.put("custGrade2Number", crmFCissCgIndexStats.getCustGrade2Number());
                map2.put("custGrade3Number", crmFCissCgIndexStats.getCustGrade3Number());
                map2.put("custGrade4Number", crmFCissCgIndexStats.getCustGrade4Number());
                map2.put("custGrade5Number", crmFCissCgIndexStats.getCustGrade5Number());
                map2.put("custGrade6Number", crmFCissCgIndexStats.getCustGrade6Number());
                list2.add(map2);
                maplist.put("custGrade", list2);
                //客群产品结构
                List<Map<String, Object>> list3 = new ArrayList<>();
                Map<String, Object> map3 = new HashMap<>();
                map3.put(DATA_DATE, crmFCissCgIndexStats.getDataDate());
                map3.put("cgTrustBalanceRmb", crmFCissCgIndexStats.getCgTrustBalanceRmb());
                map3.put("cgStrustFinBalanceRmb", crmFCissCgIndexStats.getCgStrustFinBalanceRmb());
                map3.put("cgQdiiBalanceRmb", crmFCissCgIndexStats.getCgQdiiBalanceRmb());
                map3.put("cgCollectPayBalance", crmFCissCgIndexStats.getCgCollectPayBalance());
                map3.put("cgRmbFundBalance", crmFCissCgIndexStats.getCgRmbFundBalance());
                map3.put("cgDemandDepositBalance", crmFCissCgIndexStats.getCgDemandDepositBalance());
                map3.put("cgTimeDepositBalance", crmFCissCgIndexStats.getCgTimeDepositBalance());
                map3.put("cgInsurranceBalanceRmb", crmFCissCgIndexStats.getCgInsurranceBalanceRmb());
                list3.add(map3);
                maplist.put("product", list3);
            }
            List<Map<String, Object>> list4 = new ArrayList<>();
            //客群AUM余额、中收金额、理财产品购买金额、综合价值、存款余额
            for (CrmFCissCgIndexStats crmFCissCgIndexStatsList : list) {
                Map<String, Object> map4 = new HashMap<>();
                map4.put(DATA_DATE,crmFCissCgIndexStatsList.getDataDate());
                if(StringUtils.isNotEmpty(crmFCissCgIndexStatsList.getCgAumBalance())){
                    BigDecimal a = new BigDecimal(crmFCissCgIndexStatsList.getCgAumBalance()).setScale(2,BigDecimal.ROUND_HALF_UP);
                    map4.put("cgAumBalance", String.valueOf(a.divide(new BigDecimal(10000))));
                }
                if(StringUtils.isNotEmpty(crmFCissCgIndexStatsList.getCgDepositBalance())){
                    BigDecimal a = new BigDecimal(crmFCissCgIndexStatsList.getCgDepositBalance()).setScale(2,BigDecimal.ROUND_HALF_UP);
                    map4.put(CG_DEPOSIT_BALANCE, String.valueOf(a.divide(new BigDecimal(10000))));
                }
                if(StringUtils.isNotEmpty(crmFCissCgIndexStatsList.getCgMidIncomeAmt())){
                    BigDecimal a = new BigDecimal(crmFCissCgIndexStatsList.getCgMidIncomeAmt()).setScale(2,BigDecimal.ROUND_HALF_UP);
                    map4.put("cgMidIncomeAmt", String.valueOf(a.divide(new BigDecimal(10000))));
                }
                if(StringUtils.isNotEmpty(crmFCissCgIndexStatsList.getCgBuyFinAmt())){
                    BigDecimal a = new BigDecimal(crmFCissCgIndexStatsList.getCgBuyFinAmt()).setScale(2,BigDecimal.ROUND_HALF_UP);
                    map4.put("cgBuyFinAmt", String.valueOf(a.divide(new BigDecimal(10000))));
                }
                list4.add(map4);
                maplist.put("avglist", list4);
            }
            //客户标签云
            List<Map<String, Object>> list5 = new ArrayList<>();
            for (CrmFCgCustomerTag crmFCgCustomerTag : crmFCgCustomerTagList) {
                Map<String, Object> map5 = new HashMap<>();
                map5.put(DATA_DATE, crmFCgCustomerTag.getDataDate());
                map5.put("tagNo", crmFCgCustomerTag.getTagNo());
                map5.put("tagName", crmFCgCustomerTag.getTagName());
                map5.put(CUST_NUMBER, crmFCgCustomerTag.getCustNumber());
                list5.add(map5);
                maplist.put("CustomerTaglist", list5);
            }
        } else if ("01".equals(crmIndexStatusDTO.getCustomerType())) {
            if (crmFCissCgIndexStatsSt != null) {
                //同比环比数据整合
                List<Map<String, Object>> list6 = new ArrayList<>();
                Map<String, Object> map1 = new HashMap<>();
                map1.put(DATA_DATE, crmFCissCgIndexStatsSt.getDataDate());
                map1.put(CUST_NUMBER, crmFCissCgIndexStatsSt.getCustNumber());
                map1.put("custNumberQqq", crmFCissCgIndexStatsSt.getCustNumberQoq());
                map1.put("custNumberYoy", crmFCissCgIndexStatsSt.getCustNumberYoy());
                map1.put("cgAumYearAvgBalance", crmFCissCgIndexStatsSt.getCgAvgAumYearAvgBalance());
                map1.put("cgAumYearAvgBalanceQqq", crmFCissCgIndexStatsSt.getCgAvgAumYearAvgBalanceQoq());
                map1.put("cgAumYearAvgBalanceYoy", crmFCissCgIndexStatsSt.getCgAvgAumYearAvgBalanceYoy());
                map1.put(CG_DEPOSIT_BALANCE, crmFCissCgIndexStatsSt.getCgAvgDepositBalance());
                map1.put("cgDepositBalanceQqq", crmFCissCgIndexStatsSt.getCgAvgDepositBalanceQoq());
                map1.put("cgDepositBalanceYoy", crmFCissCgIndexStatsSt.getCgAvgDepositBalanceYoy());
                map1.put("cgLoanBalance", crmFCissCgIndexStatsSt.getCgAvgLoanBalance());
                map1.put("cgLoanBalanceQqq", crmFCissCgIndexStatsSt.getCgAvgLoanBalanceQoq());
                map1.put("cgLoanBalanceYoy", crmFCissCgIndexStatsSt.getCgAvgLoanBalanceYoy());

                list6.add(map1);
                maplist.put("proportion", list6);
            }
            List<Map<String, Object>> list7 = new ArrayList<>();
            //客均AUM余额、中收金额、理财产品购买金额、综合价值、存款余额
            for (CrmFCissCgIndexStats crmFCissCgIndexStatsList : list) {
                Map<String, Object> map4 = new HashMap<>();
                map4.put(DATA_DATE, crmFCissCgIndexStatsList.getDataDate());
                if(StringUtils.isNotEmpty(crmFCissCgIndexStatsList.getCgAvgAumBalance())){
                    BigDecimal a = new BigDecimal(crmFCissCgIndexStatsList.getCgAvgAumBalance()).setScale(2,BigDecimal.ROUND_HALF_UP);
                    map4.put("cgAumBalance", String.valueOf(a.divide(new BigDecimal(10000))));
                }
                if(StringUtils.isNotEmpty(crmFCissCgIndexStatsList.getCgAvgDepositBalance())){
                    BigDecimal a = new BigDecimal(crmFCissCgIndexStatsList.getCgAvgDepositBalance()).setScale(2,BigDecimal.ROUND_HALF_UP);
                    map4.put(CG_DEPOSIT_BALANCE, String.valueOf(a.divide(new BigDecimal(10000))));
                }
                if(StringUtils.isNotEmpty(crmFCissCgIndexStatsList.getCgAvgMidIncomeAmt())){
                    BigDecimal a = new BigDecimal(crmFCissCgIndexStatsList.getCgAvgMidIncomeAmt()).setScale(2,BigDecimal.ROUND_HALF_UP);
                    map4.put("cgMidIncomeAmt", String.valueOf(a.divide(new BigDecimal(10000))));
                }
                if(StringUtils.isNotEmpty(crmFCissCgIndexStatsList.getCgAvgBuyFinAmt())){
                    BigDecimal a = new BigDecimal(crmFCissCgIndexStatsList.getCgAvgBuyFinAmt()).setScale(2,BigDecimal.ROUND_HALF_UP);
                    map4.put("cgBuyFinAmt", String.valueOf(a.divide(new BigDecimal(10000))));
                }
                if(StringUtils.isNotEmpty(crmFCissCgIndexStatsList.getCgAvgOverallValue())){
                    BigDecimal a = new BigDecimal(crmFCissCgIndexStatsList.getCgAvgOverallValue()).setScale(2,BigDecimal.ROUND_HALF_UP);
                    map4.put("cgAvgOverallValue", String.valueOf(a.divide(new BigDecimal(10000))));
                }
                list7.add(map4);
                maplist.put("avglist", list7);
            }
        }

        return maplist;
    }

    private CrmIndexStatusDTO getDateNew(String newDate, CrmIndexStatusDTO crmIndexStatusDTODTO) throws Exception {
        CrmIndexStatusDTO crmIndexStatusDTO=new CrmIndexStatusDTO();
        CrmBasedata crmBasedata=new CrmBasedata();
        if (StringUtils.isNotEmpty(newDate) && StringUtils.isEmpty(crmIndexStatusDTODTO.getStartDate()) && StringUtils.isEmpty(crmIndexStatusDTODTO.getEndDate())) {
            crmIndexStatusDTO.setStartDate(getdata(newDate,crmBasedata).getStartDate());
            crmIndexStatusDTO.setEndDate(getdata(newDate,crmBasedata).getEndDate());
        }else if (StringUtils.isEmpty(crmIndexStatusDTODTO.getStartDate()) && StringUtils.isNotEmpty(crmIndexStatusDTODTO.getEndDate())) {
            crmIndexStatusDTO.setStartDate(getdata(crmIndexStatusDTODTO.getEndDate(),crmBasedata).getStartDate());
            crmIndexStatusDTO.setEndDate(getdata(crmIndexStatusDTODTO.getEndDate(),crmBasedata).getEndDate());
        }else if (StringUtils.isNotEmpty(crmIndexStatusDTODTO.getStartDate()) && StringUtils.isEmpty(crmIndexStatusDTODTO.getEndDate())) {
            crmIndexStatusDTO.setStartDate(getdataa(crmIndexStatusDTODTO.getStartDate(),crmBasedata).getStartDate());
            crmIndexStatusDTO.setEndDate(getdataa(crmIndexStatusDTODTO.getStartDate(),crmBasedata).getEndDate());
        }else{
            crmIndexStatusDTO.setStartDate(crmIndexStatusDTODTO.getStartDate());
            crmIndexStatusDTO.setEndDate(crmIndexStatusDTODTO.getEndDate());
        }
        crmIndexStatusDTO.setCustGroupId(crmIndexStatusDTODTO.getCustGroupId());
        crmIndexStatusDTO.setCustomerType(crmIndexStatusDTODTO.getCustomerType());
        return crmIndexStatusDTO;
    }

    private CrmBasedata getdataa(String newdate,CrmBasedata crmBasedata) throws Exception {
        Calendar from = Calendar.getInstance();
        Date date = sdf.parse(newdate);
        from.setTime(date);
        String str1 = from.get(Calendar.YEAR) + "-" + fillZero(from.get(Calendar.MONTH) + 1);
        crmBasedata.setStartDate(str1);
        from.add(Calendar.MONTH, +11);//11个月前
        String str2 = from.get(Calendar.YEAR) + "-" + fillZero(from.get(Calendar.MONTH) + 1);
        crmBasedata.setEndDate(str2);
        return crmBasedata;
    }


    private CrmBasedata getdata(String newdate,CrmBasedata crmBasedata) throws Exception {
        Calendar from = Calendar.getInstance();
        Date date = sdf.parse(newdate);
        from.setTime(date);
        String str1 = from.get(Calendar.YEAR) + "-" + fillZero(from.get(Calendar.MONTH) + 1);
        crmBasedata.setEndDate(str1);
        from.add(Calendar.MONTH, -11);//11个月前
        String str2 = from.get(Calendar.YEAR) + "-" + fillZero(from.get(Calendar.MONTH) + 1);
        crmBasedata.setStartDate(str2);
        return crmBasedata;
    }


    /**
     * 格式化月份
     */
    public static String fillZero(int i) {
        String month = "";
        if (i < 10) {
            month = "0" + i;
        } else {
            month = String.valueOf(i);
        }
        return month;
    }

    public int checkUpNameId(String custGroupId) {
        return ocrmFciCgBaseMapper.checkUpNameId(custGroupId, "");
    }

    public int insertBase(CrmFCissCgBaseInfoDTO crmFCissCgBaseInfoDTO) {
        //客群基本信息
        CrmFCissCgBaseVO fCissCgBase = crmFCissCgBaseInfoDTO.getfCissCgBase();
        //客群客户信息
        List<CrmFCgPreparationVO> fCgPreparationList = crmFCissCgBaseInfoDTO.getfCgPreparationList();
        String custIds = "";
        int count = 0;
        if (fCgPreparationList.size() >= 1) {
            custIds = fCgPreparationList.stream().map(CrmFCgPreparationVO::getCustId).collect(Collectors.joining(","));
            count = fCgPreparationList.size();
        }
        //筛选条件
        CrmCustomerDTO crmCustomerDTO = crmFCissCgBaseInfoDTO.getCrmCustomerDTO();

        if(StringUtils.isNotEmpty(crmCustomerDTO.getAumBalanceStart()) && crmCustomerDTO.getAumBalanceStart()!="0"){
            BigDecimal a = new BigDecimal(crmCustomerDTO.getAumBalanceStart()).setScale(2,BigDecimal.ROUND_HALF_UP);
            crmCustomerDTO.setAumBalanceStart(String.valueOf(a.multiply(new BigDecimal(10000))));
        }
        if(StringUtils.isNotEmpty(crmCustomerDTO.getAumBalanceEnd()) && crmCustomerDTO.getAumBalanceEnd()!="0"){
            BigDecimal a = new BigDecimal(crmCustomerDTO.getAumBalanceEnd()).setScale(2,BigDecimal.ROUND_HALF_UP);
            crmCustomerDTO.setAumBalanceEnd(String.valueOf(a.multiply(new BigDecimal(10000))));
        }

        ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
        UserInfoDTO user = dto.getBody();
        CrmFCissCgBase crmFCissCgBase = new CrmFCissCgBase();
        Date date = new Date();
        crmFCissCgBase.setCustGroupId(ocrmFciCgBaseMapper.getSeq());
        if (StringUtils.isEmpty(fCissCgBase.getCustGroupType())) {
            fCissCgBase.setCustGroupType("02");
        }
        if (StringUtils.isEmpty(fCissCgBase.getIsFocus())) {
            fCissCgBase.setIsFocus("02");
        }
        if (StringUtils.isNoneEmpty(crmCustomerDTO.getCustGrade())) {
            String[] cust = crmCustomerDTO.getCustGrade().split(",");
            String str = "";
            if (cust != null && cust.length > 0) {
                str = "in(";
                for (int i = 0; i < cust.length; i++) {
                    str += "'" + cust[i] + "',";
                }
                str = str.substring(0, str.length() - 1);
                str += ")";
            }
            crmCustomerDTO.setCustGrade(str);
        }
        CrmBaseCuDTO crmBaseCuDTO = new CrmBaseCuDTO();
        int inital = 0;
        int intcount = 0;
        crmCustomerDTO.setOrgIdAuth(user.getOrg().getCode());
        crmCustomerDTO.set_orgCode(user.getOrg().getCode());
        crmCustomerDTO.set_userCode(user.getLoginCode());
        crmCustomerDTO.setMgrType(ocrmFciAdmitBelongService.getmgrType());
        String CustGroupName=ocrmFciCgBaseMapper.selectGroupName(fCissCgBase.getCustGroupId());
        if (fCgPreparationList == null || fCgPreparationList.size()==0) {
            //查询基本信息
            if("01".equals(crmCustomerDTO.getExpireNo())){
                crmCustomerDTO.setIsfixedDepositMature("Y");
            }else if("02".equals(crmCustomerDTO.getExpireNo())){
                crmCustomerDTO.setIsLoanMature("Y");
            }else if("03".equals(crmCustomerDTO.getExpireNo())){
                crmCustomerDTO.setIsFinMature("Y");
            }
            crmCustomerDTO.setLoanValue("Y");
            crmCustomerDTO.setLoanValueValue(getTure(crmCustomerDTO));
            List<CrmFCgPreparationVO> list = ocrmFciCgBaseMapper.getcustomerList(crmCustomerDTO);
            String custIdss = "";
            String custIdsss = "";
            if (list.size() >= 1) {
                custIdss = list.stream().map(CrmFCgPreparationVO::getCustId).collect(Collectors.joining(","));
                String CUSTID="CUSTID";
                 custIdsss=strToSqlGroupIn(CUSTID,custIdss);
                    if (StringUtils.isNotEmpty(fCissCgBase.getCustGroupName())) {
                        crmBaseCuDTO.setCustGroupId(crmFCissCgBase.getCustGroupId());
                    } else {
                        crmBaseCuDTO.setCustGroupId(fCissCgBase.getCustGroupId());
                    }
                    Map<String, String> map = new HashMap<>();
                    map.putAll(getcustGroupId(crmBaseCuDTO.getCustGroupId()));
                    map.put("custIdsss", custIdsss);
                    intcount = ocrmFciCgBaseMapper.selectCheck(map);
                    count = list.size();
                    ocrmFciCgBaseMapper.deleteCustomerCust(crmBaseCuDTO.getCustGroupId(), custIdsss);
            }
            inital = list.size();
            List<CrmFCgCustomer> listCrmFCgCustomer = new ArrayList<>();
            for (CrmFCgPreparationVO crmFCgPreparationVO : list) {
                CrmFCgCustomer crmFCgCustomer = new CrmFCgCustomer();
                crmFCgCustomer.setSeqno(UtilTools.getUUID());
                crmFCgCustomer.setCustid(crmFCgPreparationVO.getCustId());
                crmBaseCuDTO.setCustId(custIds);
                crmBaseCuDTO.setBelongBrch(crmFCgPreparationVO.getBelongBrch());
                crmBaseCuDTO.setSamId(user.getLoginCode());
                if (StringUtils.isNotEmpty(fCissCgBase.getCustGroupName())) {
                    crmFCgCustomer.setCustGroupId(crmFCissCgBase.getCustGroupId());
                    crmBaseCuDTO.setCustGroupName(fCissCgBase.getCustGroupName());
                } else {
                    crmFCgCustomer.setCustGroupId(fCissCgBase.getCustGroupId());
                    crmBaseCuDTO.setCustGroupName(CustGroupName);

                }
                crmFCgCustomer.setCustidName(crmFCgPreparationVO.getCustName());
                crmFCgCustomer.setCustidEngname(crmFCgPreparationVO.getCustEngName());
                crmFCgCustomer.setCreateDate(new Date());
                listCrmFCgCustomer.add(crmFCgCustomer);
            }
            ocrmFciCgBaseMapper.insertcustomerList(listCrmFCgCustomer);
        } else {
                String custIdss = "";
                String custIdsss = "";
                inital = fCgPreparationList.size();
                if (fCgPreparationList.size() >= 1) {
                    custIdss = fCgPreparationList.stream().map(CrmFCgPreparationVO::getCustId).collect(Collectors.joining(","));
                    String CUSTID="CUSTID";
                    custIdsss=strToSqlGroupIn(CUSTID,custIdss);
                        if (StringUtils.isNotEmpty(fCissCgBase.getCustGroupName())) {
                            crmBaseCuDTO.setCustGroupId(crmFCissCgBase.getCustGroupId());
                        } else {
                            crmBaseCuDTO.setCustGroupId(fCissCgBase.getCustGroupId());
                        }
                        Map<String, String> map = new HashMap<>();
                        map.putAll(getcustGroupId(crmBaseCuDTO.getCustGroupId()));
                        map.put("custIdsss", custIdsss);
                        intcount = ocrmFciCgBaseMapper.selectCheck(map);
                        count = fCgPreparationList.size();
                        ocrmFciCgBaseMapper.deleteCustomerCust(crmBaseCuDTO.getCustGroupId(), custIdsss);

                }
                for (CrmFCgPreparationVO crmFCgPreparationVO : fCgPreparationList) {
                    CrmFCgCustomer crmFCgCustomer = new CrmFCgCustomer();
                    crmFCgCustomer.setSeqno(UtilTools.getUUID());
                    crmFCgCustomer.setCustid(crmFCgPreparationVO.getCustId());
                    crmBaseCuDTO.setCustId(custIds);
                    crmBaseCuDTO.setBelongBrch(crmFCgPreparationVO.getBelongBrch());
                    crmBaseCuDTO.setSamId(user.getLoginCode());
                    if (StringUtils.isNotEmpty(fCissCgBase.getCustGroupName())) {
                        crmFCgCustomer.setCustGroupId(crmFCissCgBase.getCustGroupId());
                        crmBaseCuDTO.setCustGroupName(fCissCgBase.getCustGroupName());
                    } else {
                        crmFCgCustomer.setCustGroupId(fCissCgBase.getCustGroupId());
                        crmBaseCuDTO.setCustGroupName(CustGroupName);
                    }
                    crmFCgCustomer.setCustidName(crmFCgPreparationVO.getCustName());
                    crmFCgCustomer.setCustidEngname(crmFCgPreparationVO.getCustEngName());
                    crmFCgCustomer.setCreateDate(new Date());
                    ocrmFciCgBaseMapper.insertcustomer(crmFCgCustomer);
                }
        }
        if (StringUtils.isNotEmpty(fCissCgBase.getCustGroupName())) {
            crmFCissCgBase.setSeqno(UtilTools.getUUID());
            crmFCissCgBase.setCustGroupId(crmFCissCgBase.getCustGroupId());
            crmFCissCgBase.setCreateDate(date);
            crmFCissCgBase.setCreateUser(user.getUserName());
            crmFCissCgBase.setCustGroupDescribe(fCissCgBase.getCustGroupDescribe());
            crmFCissCgBase.setCustGroupLabel(fCissCgBase.getCustGroupLabel());
            crmFCissCgBase.setCustGroupName(fCissCgBase.getCustGroupName());
            crmFCissCgBase.setCustGroupRule(fCissCgBase.getCustGroupRule());
            crmFCissCgBase.setCustGroupType(fCissCgBase.getCustGroupType());
            crmFCissCgBase.setInitialCout(String.valueOf(inital));
            crmFCissCgBase.setIsFlag("01");
            crmFCissCgBase.setIsFocus(fCissCgBase.getIsFocus());
            crmFCissCgBase.setOrgId(user.getOrg().getCode());
            crmFCissCgBase.setSamId(user.getLoginCode());
            //保存客群信息
            ocrmFciCgBaseMapper.insertBase(crmFCissCgBase);
            //筛选条件
            CrmFCgCustomerPreparation crmFCgCustomerPreparation = new CrmFCgCustomerPreparation();
            crmFCgCustomerPreparation.setSeqno(UtilTools.getUUID());
            crmFCgCustomerPreparation.setAgegroup(crmCustomerDTO.getAgeGroup());
            if(StringUtils.isNotEmpty(crmCustomerDTO.getAumBalanceStart()) && crmCustomerDTO.getAumBalanceStart()!="0.00"){
                BigDecimal a = new BigDecimal(crmCustomerDTO.getAumBalanceStart()).setScale(2,BigDecimal.ROUND_HALF_UP);
                crmCustomerDTO.setAumBalanceStart(String.valueOf(a.divide(new BigDecimal(10000))));
            }
            if(StringUtils.isNotEmpty(crmCustomerDTO.getAumBalanceEnd()) && crmCustomerDTO.getAumBalanceEnd()!="0.00"){
                BigDecimal a = new BigDecimal(crmCustomerDTO.getAumBalanceEnd()).setScale(2,BigDecimal.ROUND_HALF_UP);
                crmCustomerDTO.setAumBalanceEnd(String.valueOf(a.divide(new BigDecimal(10000))));
            }
            crmFCgCustomerPreparation.setAumBalance(crmCustomerDTO.getAumBalanceStart() + "," + crmCustomerDTO.getAumBalanceEnd());
            crmFCgCustomerPreparation.setCountareacd(crmCustomerDTO.getCountAreaCd());
            crmFCgCustomerPreparation.setCreateDate(date);
            crmFCgCustomerPreparation.setCreateUser(user.getUserName());
            crmFCgCustomerPreparation.setCustgrade(crmCustomerDTO.getCustGrade());
            crmFCgCustomerPreparation.setCustGroupId(crmFCissCgBase.getCustGroupId());
            crmFCgCustomerPreparation.setExpireno(crmCustomerDTO.getExpireNo());
            if (StringUtils.isNotEmpty(crmCustomerDTO.getProdName())) {
                crmFCgCustomerPreparation.setProdname(crmCustomerDTO.getProdName());
            } else {
                crmFCgCustomerPreparation.setProdname(crmCustomerDTO.getProdId());
            }
            crmFCgCustomerPreparation.setTagname(crmCustomerDTO.getTagName());
            ocrmFciCgBaseMapper.insertcrmFCgCustomerPreparation(crmFCgCustomerPreparation);
        }
        if (StringUtils.isNotEmpty(crmBaseCuDTO.getCustGroupId()) && StringUtils.isNotEmpty(crmBaseCuDTO.getCustGroupName())) {
            String type = "01";
            insertchange(crmBaseCuDTO, count - intcount, type);
        }
        return 0;
    }

    public String strToSqlGroupIn(String CUSTID,String strIns) {
        int groupNum = 1;
        String groupInArr = new String();
        StringBuffer buffer = new StringBuffer();
        if (StringUtils.isNoneBlank(strIns)) {
            String[] array = strIns.split(",");
            //数组总长度
            int len = array.length;
            //分组数
            int groupCount = len / groupNum;
            for (int k = 0; k < groupCount; k++) {
                groupInArr = new String();
                for (int i = (k * groupNum); i < (k * groupNum + groupNum); i++) {
                    if (i > k * groupNum) {
                        groupInArr += ",";
                    }
                    groupInArr += array[i].trim();
                }
                if (k > 0) {
                    buffer.append(" or ");
                }
                buffer.append(String.format(" %s in(%s)", CUSTID, strToDbin(groupInArr)));
            }
            if (len % groupNum != 0) {
                //未整除
                groupInArr = new String();
                //处理最后一组数据
                for (int j = (groupCount * groupNum); j < len; j++) {
                    if (j > groupCount * groupNum) {
                        groupInArr += ",";
                    }
                    groupInArr += array[j].trim();
                }
                if (buffer.length() > 0) {
                    buffer.append(" or ");
                }
                buffer.append(String.format(" %s in(%s)", CUSTID, strToDbin(groupInArr)));
            }
        }
        return buffer.toString();
    }
    public String strToDbin(String str) {
        return String.format("'%s'", StringUtils.join(str.split(","), "','"));
    }

        public int deleteCustomer(CrmBaseCuDTO crmBaseCuDTO) {
        String[] custGroupId = crmBaseCuDTO.getCustGroupId().split(",");
        int count = 0;
        String str = "";
        if (custGroupId != null && custGroupId.length > 0) {
            str = "in(";
            for (int i = 0; i < custGroupId.length; i++) {
                str += "'" + custGroupId[i] + "',";
                count = i;
            }
            str = str.substring(0, str.length() - 1);
            str += ")";
        }
        crmBaseCuDTO.setCustGroupId(str);
        int i = ocrmFciCgBaseMapper.deleteCustomer(crmBaseCuDTO);
        UserInfoDTO user = getUserInfoDTO();
        CrmFCissCgBase crmFCissCgBase = new CrmFCissCgBase();
        crmFCissCgBase.setUpdateDate(new Date());
        crmFCissCgBase.setUpdateUser(user.getUserName());
        crmFCissCgBase.setIsFlag("02");
        crmFCissCgBase.setCustGroupId(crmBaseCuDTO.getCustGroupId());
        ocrmFciCgBaseMapper.updateBase(crmFCissCgBase);
		/*String type="02";
		insertchange(crmBaseCuDTO,count,type);*/
        return i;
    }

    public CrmFCissCgBaseVO querycustomet(String custGroupId) {
        Map<String, String> map = new HashMap<>();
        map.putAll(getcustGroupId(custGroupId));
        CrmFCissCgBase crmFCissCgBases = ocrmFciCgBaseMapper.queryGroupBaselist(map);
        //查询客户数量
        CrmBaseCountVo Count = ocrmFciCgBaseMapper.Customercount(map);
        //查询筛选条件规则
        CrmFCgCustomerPreparation CrmFCgCustomerPreparation = ocrmFciCgBaseMapper.selectocrmFciCgBaseMapper(map);
        if (CrmFCgCustomerPreparation != null) {
            if (StringUtils.isNotEmpty(CrmFCgCustomerPreparation.getCustgrade())) {
                CrmFCgCustomerPreparation.setCustgrade(CrmFCgCustomerPreparation.getCustgrade().replaceAll("[()]", "").replaceAll("in", "").replaceAll("\'", ""));
            }
        }

        ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
        UserInfoDTO user = dto.getBody();
        CrmFCissCgBaseVO crmFCissCgBaseVO = new CrmFCissCgBaseVO();
        crmFCissCgBaseVO.setCreateDate(crmFCissCgBases.getCreateDate());
        if (Count != null) {
            crmFCissCgBaseVO.setFloatCustomer(Count.getCount() - Integer.parseInt(crmFCissCgBases.getInitialCout()));
            crmFCissCgBaseVO.setInitialCout(String.valueOf(Count.getCount()));
            if(StringUtils.isEmpty(crmFCissCgBaseVO.getInitialCout())){
                crmFCissCgBaseVO.setInitialCout(String.valueOf(0));
            }
        } else {
            crmFCissCgBaseVO.setFloatCustomer(0);
            crmFCissCgBaseVO.setInitialCout(String.valueOf(0));
        }
        crmFCissCgBaseVO.setOrgId(user.getOrg().getCode());
        crmFCissCgBaseVO.setSamId(user.getLoginCode());
        crmFCissCgBaseVO.setIsFocus(crmFCissCgBases.getIsFocus());
        crmFCissCgBaseVO.setCustGroupId(crmFCissCgBases.getCustGroupId());
        crmFCissCgBaseVO.setCustGroupName(crmFCissCgBases.getCustGroupName());
        crmFCissCgBaseVO.setCustGroupDescribe(crmFCissCgBases.getCustGroupDescribe());
        crmFCissCgBaseVO.setCustGroupRule(crmFCissCgBases.getCustGroupRule());
        crmFCissCgBaseVO.setCustGroupType(crmFCissCgBases.getCustGroupType());
        crmFCissCgBaseVO.setCustGroupLabel(crmFCissCgBases.getCustGroupLabel());
        crmFCissCgBaseVO.setIsFlag(crmFCissCgBases.getIsFlag());
        crmFCissCgBaseVO.setCreateUser(crmFCissCgBases.getCreateUser());
        crmFCissCgBaseVO.setUpdateDate(crmFCissCgBases.getUpdateDate());
        crmFCissCgBaseVO.setUpdateUser(crmFCissCgBases.getUpdateUser());
        crmFCissCgBaseVO.setCrmFCgCustomerPreparation(CrmFCgCustomerPreparation);
        return crmFCissCgBaseVO;
    }

    public List<CrmFCgPreparationVO> queryjournallist(CrmBasePreparDTO crmBasePreparDTO) {
        if(crmBasePreparDTO.getCustId().contains("in")){
            crmBasePreparDTO.setCustId(crmBasePreparDTO.getCustId().replaceAll("[()]", "").replaceAll("in", "").replaceAll("\'", ""));
        }
        if (StringUtils.isNotEmpty(crmBasePreparDTO.getCustId())) {
            String[] custId = crmBasePreparDTO.getCustId().split(",");
            int count = 0;
            String str = "";
            if (custId != null && custId.length > 0) {
                str = "in(";
                for (int i = 0; i < custId.length; i++) {
                    str += "'" + custId[i] + "',";
                    count = i;
                }
                str = str.substring(0, str.length() - 1);
                str += ")";
            }
            crmBasePreparDTO.setCustId(str);
        }
        crmBasePreparDTO.setMgrType(ocrmFciAdmitBelongService.getmgrType());
        PageHelper.startPage(crmBasePreparDTO.getPage(), crmBasePreparDTO.getSize());
        List<CrmFCgPreparationVO> list = ocrmFciCgBaseMapper.queryjournallist(crmBasePreparDTO);
        PageHelper.clearPage();
        return list;

    }

    public List export(HttpServletResponse response, QueryModel model) throws Exception {
        ServletOutputStream out = response.getOutputStream();
        List<CrmFCgPreparationVO> list = new ArrayList<>();
        String str = "";
        if (StringUtils.isNotEmpty(model.getCondition().get(CUST_ID).toString())) {
            String[] custIds = model.getCondition().get(CUST_ID).toString().split(",");
            if (custIds != null && custIds.length > 0) {
                str = "in(";
                for (int i = 0; i < custIds.length; i++) {
                    str += "'" + custIds[i] + "',";
                }
                str = str.substring(0, str.length() - 1);
                str += ")";
            }
        }
        Map<String, String> mapMap = new HashMap<>();
        mapMap.putAll(getcustGroupId(model.getCondition().get("custGroupId").toString()));
        mapMap.put(CUST_ID, str);
        String selectRole = (String) model.getCondition().get("selectRole");
        mapMap.put("mgrType", ocrmFciAdmitBelongService.getmgType(selectRole));
        list = ocrmFciCgBaseMapper.selectPreparation(mapMap);
        //定义导出的excel名字
        String excelName = "客群客户列表";
        ExportExcelUtils2.export(excelName, list, CrmFCgPreparationVO.class, response);
        return null;
    }
    public int checkUpNameName(String custGroupId, String custGroupName) {
        ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
        UserInfoDTO user = dto.getBody();
        return ocrmFciCgBaseMapper.checkUpNameuserId(custGroupId,custGroupName,user.getUserName());
    }

    public List<CrmFCissCgBaseVO> querycust(String custId) {
        List<CrmFCissCgBaseVO> querycust = ocrmFciCgBaseMapper.querycust(custId);
        Set<CrmFCissCgBaseVO> set=new TreeSet<CrmFCissCgBaseVO>(new Comparator<CrmFCissCgBaseVO>() {
            @Override
            public int compare(CrmFCissCgBaseVO o1, CrmFCissCgBaseVO o2) {
                if (o1.getCustGroupId() == null && o2.getCustGroupId() == null){
                    return 0;
                }else if (o1.getCustGroupId() == null && o2.getCustGroupId() != null){
                    return 1;
                }else if (o1.getCustGroupId() != null && o2.getCustGroupId() == null){
                    return -1;
                }
                return o1.getCustGroupId().compareTo(o2.getCustGroupId());
            }
        });
        set.addAll(querycust);
        List<CrmFCissCgBaseVO> lists=new ArrayList<CrmFCissCgBaseVO>(set);
        return lists;
    }

    public int insertlinBase(CrmFCissCgInfoDTO crmFCissCgInfoDTO) {
        List<String> custIdList = crmFCissCgInfoDTO.getCustId();
        if(custIdList.size()==0){
            QueryModel model=new QueryModel();
            model.setPage(1);
            model.setPage(1000000);
            HashMap<String, String> obj = new HashMap<>();
            obj.put("seqno",crmFCissCgInfoDTO.getConditionNo());
            model.setCondition(JSON.toJSONString(obj));
            try {
                ResultDto<List<Map<String, Object>>> resultDto=cmssFCiFqService.getExportQuery(model);
                List<Map<String, Object>> dataList = resultDto.getData();
                for (int i = 0; i < dataList.size(); i++) {
                    Map<String, Object> map = dataList.get(i);
                    Iterator iterator = map.keySet().iterator();
                    while (iterator.hasNext()) {
                        String key = (String) iterator.next();
                        if("custNo".equals(key)){
                            custIdList.add((String) map.get(key));
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        CrmFCissCgBaseVO crmFCissCgBaseVO = crmFCissCgInfoDTO.getfCissCgBase();
         crmFCissCgBaseVO.setCustGroupType("01");
        if (StringUtils.isEmpty(crmFCissCgBaseVO.getIsFocus())) {
            crmFCissCgBaseVO.setIsFocus("02");
        }
        ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
        UserInfoDTO user = dto.getBody();
        CrmFCissCgBase crmFCissCgBase = new CrmFCissCgBase();
        Date date = new Date();
        crmFCissCgBase.setCustGroupId(ocrmFciCgBaseMapper.getSeq());

        String custIdss = custIdList.stream().map(String::valueOf).collect(Collectors.joining(","));
        String CUSTID="CUST_ID";
        String str=strToSqlGroupIn(CUSTID,custIdss);
        List<CrmFCissCgDTO> list=new ArrayList<>();
        list=ocrmFciCgBaseMapper.selectcustName(str);
          //客群客户关系表
        for (CrmFCissCgDTO crmFCissCgDTO : list) {
            CrmFCgCustomer crmFCgCustomer = new CrmFCgCustomer();
            crmFCgCustomer.setSeqno(UtilTools.getUUID());
            crmFCgCustomer.setCustid(crmFCissCgDTO.getCustId());
            if (StringUtils.isNotEmpty(crmFCissCgBaseVO.getCustGroupName())) {
                crmFCgCustomer.setCustGroupId(crmFCissCgBase.getCustGroupId());
            } else {
                crmFCgCustomer.setCustGroupId(crmFCissCgBaseVO.getCustGroupId());
            }
            crmFCgCustomer.setCustidName(crmFCissCgDTO.getCustidName());
            crmFCgCustomer.setCustidEngname(crmFCissCgDTO.getCustidEngname());
            crmFCgCustomer.setCreateDate(new Date());
            ocrmFciCgBaseMapper.insertcustomer(crmFCgCustomer);
        }
        //客群基本信息
        if (StringUtils.isNotEmpty(crmFCissCgBaseVO.getCustGroupName())) {
            crmFCissCgBase.setSeqno(UtilTools.getUUID());
            crmFCissCgBase.setCustGroupId(crmFCissCgBase.getCustGroupId());
            crmFCissCgBase.setCreateDate(date);
            crmFCissCgBase.setCreateUser(user.getUserName());
            crmFCissCgBase.setCustGroupDescribe(crmFCissCgBaseVO.getCustGroupDescribe());
            crmFCissCgBase.setCustGroupLabel(crmFCissCgBaseVO.getCustGroupLabel());
            crmFCissCgBase.setCustGroupName(crmFCissCgBaseVO.getCustGroupName());
            crmFCissCgBase.setCustGroupRule(crmFCissCgBaseVO.getCustGroupRule());
            crmFCissCgBase.setCustGroupType(crmFCissCgBaseVO.getCustGroupType());
            crmFCissCgBase.setInitialCout(String.valueOf(list.size()));
            crmFCissCgBase.setIsFlag("01");
            crmFCissCgBase.setIsFocus(crmFCissCgBaseVO.getIsFocus());
            crmFCissCgBase.setOrgId(user.getOrg().getCode());
            crmFCissCgBase.setSamId(user.getLoginCode());
            //保存客群信息
            ocrmFciCgBaseMapper.insertBase(crmFCissCgBase);
        }
        return 0;
    }

    public List<CrmFCgUserVO> wholecustomerList(CustomererDTO customererDTO) {
        // TODO 自动生成的方法存根
        PageHelper.startPage(customererDTO.getPage(), customererDTO.getSize());
        List<CrmFCgUserVO> list = ocrmFciCgBaseMapper.wholecustomerList(customererDTO);
        PageHelper.clearPage();
        return list;
    }

    public void IndexStatusExcel(HttpServletResponse response, CrmIndexStatusDTO crmIndexStatusDTO) throws Exception {
        Map<String, List<Map<String, Object>>> stringListMap = queryIndexStatuslist(crmIndexStatusDTO);
        String fileName ="";
        if("01".equals(crmIndexStatusDTO.getCustomerType())){
            fileName ="客均业绩分析"+simpleDateFormat.format(new Date()).toString();
       }else{
            fileName ="客群业绩分析"+simpleDateFormat.format(new Date()).toString();
        }
        OutputStream ouputStream = response.getOutputStream();
        try {
            response.reset();
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment; filename="+new String(fileName.getBytes(),"ISO-8859-1")+".xlsx");
            response.setHeader("Connection", "close");
            List<List<String>> data0 = new ArrayList<List<String>>();
            List<List<String>> data1 = new ArrayList<List<String>>();
            List<List<String>> data2 = new ArrayList<List<String>>();
            List<List<String>> data3 = new ArrayList<List<String>>();
            List<List<String>> data4 = new ArrayList<List<String>>();
            for (String s : stringListMap.keySet()) {
                for (Map<String, Object> map : stringListMap.get(s)) {
                    if ("proportion".equals(s)) {
                        List rowData = new ArrayList();
                        rowData.add(map.get(DATA_DATE));
                        rowData.add(map.get(CUST_NUMBER));
                        rowData.add(map.get("custNumberQqq"));
                        rowData.add(map.get("custNumberYoy"));
                        rowData.add(map.get("cgAumYearAvgBalance"));
                        rowData.add(map.get("cgAumYearAvgBalanceQqq"));
                        rowData.add(map.get("cgAumYearAvgBalanceYoy"));
                        rowData.add(map.get(CG_DEPOSIT_BALANCE));
                        rowData.add(map.get("cgDepositBalanceQqq"));
                        rowData.add(map.get("cgDepositBalanceYoy"));
                        rowData.add(map.get("cgLoanBalance"));
                        rowData.add(map.get("cgLoanBalanceQqq"));
                        rowData.add(map.get("cgLoanBalanceYoy"));
                        data0.add(rowData);
                    }else if("custGrade".equals(s)){
                        List rowData = new ArrayList();
                        rowData.add(map.get(DATA_DATE));
                        rowData.add(map.get("custGrade1Number"));
                        rowData.add(map.get("custGrade2Number"));
                        rowData.add(map.get("custGrade3Number"));
                        rowData.add(map.get("custGrade4Number"));
                        rowData.add(map.get("custGrade5Number"));
                        rowData.add(map.get("custGrade6Number"));
                        data1.add(rowData);
                    }else if("product".equals(s)){
                        List rowData = new ArrayList();
                        rowData.add(map.get(DATA_DATE));
                        rowData.add(map.get("cgTrustBalanceRmb"));
                        rowData.add(map.get("cgStrustFinBalanceRmb"));
                        rowData.add(map.get("cgQdiiBalanceRmb"));
                        rowData.add(map.get("cgCollectPayBalance"));
                        rowData.add(map.get("cgRmbFundBalance"));
                        rowData.add(map.get("cgDemandDepositBalance"));
                        rowData.add(map.get("cgTimeDepositBalance"));
                        rowData.add(map.get("cgInsurranceBalanceRmb"));
                        data2.add(rowData);
                    } else if("avglist".equals(s)){
                        List rowData = new ArrayList();
                        rowData.add(map.get(DATA_DATE));
                        rowData.add(map.get("cgAumBalance"));
                        rowData.add(map.get(CG_DEPOSIT_BALANCE));
                        rowData.add(map.get("cgMidIncomeAmt"));
                        rowData.add(map.get("cgBuyFinAmt"));
                        data3.add(rowData);
                    }else if("CustomerTaglist".equals(s)){
                        List rowData = new ArrayList();
                        rowData.add(map.get(DATA_DATE));
                        rowData.add(map.get("tagNo"));
                        rowData.add(map.get("tagName"));
                        rowData.add(map.get(CUST_NUMBER));
                        data4.add(rowData);
                    }
                }
            }
            String[] headers0 =null;
            String[] headers3 =null;
            String[] headers1=null;
            String[] headers2=null;
            String[] headers4 =null;
            ExportExcelUtils2 eeu = new ExportExcelUtils2();
            XSSFWorkbook workbook = new XSSFWorkbook();
            if("02".equals(crmIndexStatusDTO.getCustomerType())){
                headers0 = new String[]{"数据日期", "客户数", "客户数环比", "客户数同比", "客群AUM年日均", "客群AUM年日均环比", "客群AUM年日均同比", "客户存款余额", "客户存款余额环比", "客户存款余额同比", "客群贷款余额", "客群贷款余额环比", "客群贷款余额同比"};
                headers1 = new String[]{ "数据日期","一般客户", "有效客户","优惠客户","显卓客户","私行客户","显卓钻石客户"};
                headers2 = new String[]{ "数据日期","客群信托余额", "客群结构化理财余额","客群QDII余额","客群代收付余额","客群人民币基金余额","客群活期存款余额","客群定期存款余额","客群保险规模"};
                headers3 = new String[]{ "数据日期","客群AUM余额", "客群存款余额","客群中间业务收入金额","客群理财购买金额"};
                headers4 =new String[]{ "数据日期","标签编码", "标签名称","客户数"};
                eeu.exportExcel(workbook, 0, "客群统计", headers0, data0, ouputStream);
                eeu.exportExcel(workbook, 1, "客户等级", headers1, data1, ouputStream);
                eeu.exportExcel(workbook, 2, "客群产品结构", headers2, data2, ouputStream);
                eeu.exportExcel(workbook, 3, "客群趋势", headers3, data3, ouputStream);
                eeu.exportExcel(workbook, 4, "客户标签云", headers4, data4, ouputStream);
           }else{
                headers0 = new String[]{"数据日期", "客户数", "客户数环比", "客户数同比", "客均AUM年日均", "客均AUM年日均环比", "客均AUM年日均同比", "客户存款余额", "客户存款余额环比", "客户存款余额同比", "客均贷款余额", "客均贷款余额环比", "客均贷款余额同比"};
                headers3 = new String[]{ "数据日期","客均AUM余额", "客均存款余额","客均中间业务收入金额","客均理财购买金额"};
                eeu.exportExcel(workbook, 0, "客均统计", headers0, data0, ouputStream);
                eeu.exportExcel(workbook, 1, "客均趋势", headers3, data3, ouputStream);
            }
            workbook.write(ouputStream);
            ouputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(ouputStream !=null){
                ouputStream.close();
            }
        }
        }

    public List<Map<String, Object>> queryprodlist(ProdDTO prodDTO) {
        return ocrmFciCgBaseMapper.queryprodlist(prodDTO);
    }

    public Map<String, Object> querymgrlist() {
        Map<String,Object> map=new HashMap<>();
        String mgrType= selectroleUtils.getmgrType();
        String role=selectroleUtils.getRole();
        ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
        UserInfoDTO user = dto.getBody();
        Map<String,Object> mapp=new HashMap<>();
            List<String> list=new ArrayList<>();
            List<String> list1=new ArrayList<>();
            if(headOffice.contains(role)){
                return map;
            }else if(headOfficeB.contains(role)){
                return map;
            }else if(branch.contains(role) || subbranch.contains(role)){
               if(StringUtils.isEmpty(mgrType)){
                   list=ocrmFciCgBaseMapper.selectorg(user.getOrg().getCode());
                   map.put("orgList",list.toArray());
               }else{
                   mapp.put("code",user.getOrg().getCode());
                   mapp.put("mgrType",mgrType);
                   if(branch.contains(role)){
                       mapp.put("codecode",user.getOrg().getCode().substring(0,2));
                       list=ocrmFciCgBaseMapper.selectmgrId(mapp);
                       list1=ocrmFciCgBaseMapper.selectorgid(mapp);
                   }else{
                       mapp.put("codecode",user.getOrg().getCode().substring(0,4));
                       list=ocrmFciCgBaseMapper.selectmgrId(mapp);
                       list1=ocrmFciCgBaseMapper.selectorgid(mapp);
                   }
                   map.put("onemgrList",list.toArray());
                   map.put("twomgrList",list1.toArray());
                   map.put("mgrType",mgrType);
               }
            }else if(patrolLeader.contains(role)){
                    mapp.put("userId",user.getLoginCode());
                    list=ocrmFciCgBaseMapper.selectmgrIduser(mapp);
                    map.put("mgrList",list.toArray());
                    map.put("mgrType",mgrType);
                }else if(customerManage.contains(role)){
                map.put("mgrList",user.getLoginCode());
                map.put("mgrType",mgrType);
            }
            return  map;
        }


}
