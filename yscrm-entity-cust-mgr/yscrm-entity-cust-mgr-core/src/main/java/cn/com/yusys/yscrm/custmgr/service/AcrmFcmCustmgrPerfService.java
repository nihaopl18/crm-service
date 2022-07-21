package cn.com.yusys.yscrm.custmgr.service;

import java.io.*;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import cn.com.yusys.yscrm.custmgr.domain.*;
import cn.com.yusys.yscrm.pcrm.common.remindInfo.utils.ExportExcelUtils2;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yscrm.custmgr.repository.mapper.AcrmFcmCustmgrPerfMapper;
import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.ObjBean;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @项目名称: yusp-crm-single-starter模块
 * @类名称: AcrmFcmCustmgrPerfService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: luhy1@yusys.com.cn
 * @创建时间: 2019-01-22 17:25:12
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class AcrmFcmCustmgrPerfService extends CommonService {

	@Autowired
    private AcrmFcmCustmgrPerfMapper acrmFcmCustmgrPerfMapper;
    
    @Autowired
    private CustMgrQueryService custMgrQueryService;
    
    @Autowired
   	private UaaClient uaaClient;

	public final static String MGR_ROLE_1 = "R002,R015,R018,R017,R021";
	public final static String MGR_ROLE_2 = "R003,R019,R016,R020";
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

    public final static String TRIUMPH_ANM = "K002,K009,K020,K025";
    public final static String TRIUMPH_DEPOSIT = "K001,K008,K021,K026";
    public final static String TRIUMPH_LOAN = "K012,K014";
    public final static String TRIUMPH_CHARGE = "K016,K017,K018,K019";
	public final static String TRIUMPH_CHARGE_T4 = "K016,K017,K018,K019,K001,K008,K021,K026";
    @Override
    protected CommonMapper<?> getMapper() {
        return acrmFcmCustmgrPerfMapper;
    }

	public  UserInfoDTO getUserInfoDTO() {
		ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo( HeaderUtil.getAccessToken());
		UserInfoDTO user = dto.getBody();
		return user;
	}
    /**
	 * 客户经理管理-业绩明细列表查询
	 * 
	 * @param queryModel
	 * @return
	 */
	public List<Map<String, Object>> queryerList(QueryModel queryModel) {
		ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
    	List<ObjBean> roleList = dto.getBody().getRoles();
    	boolean isCustMgr = false;
    	for(ObjBean obj : roleList) {
    		if("15".equals(obj.getCode())) {
    			isCustMgr = true;
    		}
    	}
    	//如果不是客户经理，加入业务条线过滤条件
    	if(!isCustMgr) {
    		//加入业务条线授权
    		queryModel.getCondition().put("busiTypeAuth", custMgrQueryService.queryUserBusiType());
    	}
		PageHelper.startPage(queryModel.getPage(), queryModel.getSize());
		List<Map<String, Object>> list = acrmFcmCustmgrPerfMapper.querylist(queryModel);
		PageHelper.clearPage();
		return list;
	}
	
	/**
	 * 客户经理视图-业绩明细列表查询
	 * 
	 * @param queryModel
	 * @return
	 */
	public List<Map<String, Object>> queryListByMgrId(QueryModel queryModel,String mgrId) {
		//如果客户经理编号不为空，则该功能用于客户经理视图中业绩明细查询
		if (mgrId != null && !"".equals(mgrId) && !"undefined".equals(mgrId)) {
			queryModel.getCondition().put("empId", mgrId);
		}
		PageHelper.startPage(queryModel.getPage(), queryModel.getSize());
		List<Map<String, Object>> list = acrmFcmCustmgrPerfMapper.querylist(queryModel);
		PageHelper.clearPage();
		return list;
	}

	public CrmTriumphVO triumphlist(QueryModel queryModel) {
		UserInfoDTO user = getUserInfoDTO();
		CrmTriumphVO crmTriumphVO = new CrmTriumphVO();
		//选择指标信息
		List<CrmFYyTriumphVO> crmFYyTriumphVOList = new ArrayList<>();
		//分配下辖信息
		List<CrmTriuVO> CrmTriuVOList = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		String role = getrole();
		//层级
		int triumphLevel = 0;
		//下辖层级
		int triumphLevelup =0;
		String triumphYear="";
		if(StringUtils.isEmpty((String)queryModel.getCondition().get("triumphYear"))){
			Calendar cal = Calendar.getInstance();
			triumphYear=String.valueOf(cal.get(Calendar.YEAR));
		}else{
			triumphYear=(String)queryModel.getCondition().get("triumphYear");
		}
		String loginCode="";
		if(StringUtils.isNoneEmpty(user.getOrg().getCode())){
			loginCode=user.getOrg().getCode();
		}else{
			loginCode=user.getOrg().getId();
		}
		int triumphLine=getmgrType();
		if (headOffice.contains(role)) {
			map.put("triumphLevel", triumphLevel);
			map.put("triumphYear", triumphYear);
			map.put("triumphLine", 0);
            map.put("loginCode", "500");
		} else if (headOfficeB.contains(role)) {
			triumphLevel = 1;
			map.put("triumphLevel", triumphLevel);
			map.put("triumphYear",triumphYear);
			map.put("triumphLine", triumphLine);
            map.put("loginCode", "500");
		} else if (branch.contains(role)) {
			triumphLevel = 2;
			map.put("loginCode", loginCode.substring(0,2));
			map.put("triumphLevel", triumphLevel);
			map.put("triumphYear",triumphYear);
			map.put("triumphLine", triumphLine);
		} else if (subbranch.contains(role)) {
			triumphLevel = 3;
			map.put("loginCode", loginCode);
			map.put("triumphLevel", triumphLevel);
			map.put("triumphYear",triumphYear);
			map.put("triumphLine", triumphLine);

		} else if (patrolLeader.contains(role)) {
			triumphLevel = 4;
			String mktTeamIds = "";
			//查询团队编号
			String mktTeamId = acrmFcmCustmgrPerfMapper.getmktTeamId(user.getLoginCode());
				map.put("loginCode", mktTeamId);
				map.put("triumphLevel", triumphLevel);
				map.put("triumphYear", triumphYear);
			map.put("triumphLine", triumphLine);

		} else if (customerManage.contains(role)) {
				triumphLevel = 5;
				map.put("loginCode", user.getLoginCode());
				map.put("triumphLevel", triumphLevel);
			    map.put("triumphYear", triumphYear);
			map.put("triumphLine", triumphLine);

		}
				crmFYyTriumphVOList = acrmFcmCustmgrPerfMapper.selectcrmFYyTriumphVO(map);

			crmTriumphVO.setCrmFYyTriumphVOList(crmFYyTriumphVOList);

		if(crmFYyTriumphVOList.size()>0){
			String triumphId="";
			if(StringUtils.isEmpty((String) queryModel.getCondition().get("triumphId"))){
					CrmFYyTriumphVO crmFYyTriumphVO=crmFYyTriumphVOList.get(0);
					triumphId=crmFYyTriumphVO.getTriumphId();
			}else{
				triumphId=(String) queryModel.getCondition().get("triumphId");
			}
			if(StringUtils.isEmpty((String)queryModel.getCondition().get("triumphLine"))){
				triumphLine=getmgrType();
			}else{
				triumphLine=Integer.parseInt(queryModel.getCondition().get("triumphLine").toString());
			}
		if (headOffice.contains(role)) {
			triumphLevelup = 1;
			map.put("triumphLevelup", triumphLevelup);
			//指标id
			map.put("triumphId", triumphId);
			map.put("triumphYear", triumphYear);
			map.put("triumphLine",triumphLine);
			CrmTriuVOList = acrmFcmCustmgrPerfMapper.crmTriuVOList(map);
		} else if (headOfficeB.contains(role)) {
			triumphLevelup = 2;
			map.put("triumphLevelup", triumphLevelup);
			map.put("triumphId",triumphId);
			map.put("triumphYear",triumphYear);
			map.put("triumphLine",triumphLine);
			CrmTriuVOList = acrmFcmCustmgrPerfMapper.crmTriuVOListb(map);
		} else if (branch.contains(role)) {
			map.put("loginCode", loginCode.substring(0,2));
			triumphLevelup = 3;
			map.put("triumphLevelup", triumphLevelup);
			map.put("triumphId", triumphId);
			map.put("triumphYear",triumphYear);
			map.put("triumphLine", triumphLine);
			//支行信息
			List<CrmTriuVO> CrmTriuList = acrmFcmCustmgrPerfMapper.crmTriuVOListb(map);
			//团队信息
			map.put("triumphLevelup", 4);
			List<CrmTriuVO> CrmTrList = acrmFcmCustmgrPerfMapper.crmTriuVOListt(map);
			CrmTriuList.addAll(CrmTrList);
			CrmTriuVOList = CrmTriuList;
		} else if (subbranch.contains(role)) {
			map.put("loginCode", loginCode);
			triumphLevelup = 5;
			map.put("triumphLevelup", triumphLevelup);
			map.put("triumphId", triumphId);
			map.put("triumphYear",triumphYear);
			map.put("triumphLine", triumphLine);
			if(triumphLine==1){
				map.put("code", "R002");
			}else{
				map.put("code", "R003");
			}
			CrmTriuVOList = acrmFcmCustmgrPerfMapper.crmTriuVOListC(map);
		} else if (patrolLeader.contains(role)) {
			String mktTeamIds = "";
			//查询团队编号
			String mktTeamId = acrmFcmCustmgrPerfMapper.getmktTeamId(user.getLoginCode());
				map.put("loginCode", mktTeamId);
				triumphLevelup = 5;
				map.put("triumphLevelup", triumphLevelup);
				map.put("triumphId", triumphId);
				map.put("triumphYear", triumphYear);
				map.put("triumphLine", triumphLine);
				CrmTriuVOList = acrmFcmCustmgrPerfMapper.crmTriuVOListtd(map);
		}
		}
			crmTriumphVO.setCrmTriuVOList(CrmTriuVOList);
		    return crmTriumphVO;
	}


	public  int getmgrType(){
		int mgrType = 0;
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();
		HttpServletRequest request = requestAttributes.getRequest();
		String selectRole = request.getHeader("selectRole");
		String mgrid = this.acrmFcmCustmgrPerfMapper.selectmgrId(selectRole);
		if (MGR_ROLE_1.contains(mgrid)) {
			mgrType = 1;
		} else if (MGR_ROLE_2.contains(mgrid)) {
			mgrType = 2;
		}else{
			mgrType = 0;
		}
		return mgrType;
	}
	public  String getrole() {
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();
		HttpServletRequest request = requestAttributes.getRequest();
		String selectRole = request.getHeader("selectRole");
		String role = this.acrmFcmCustmgrPerfMapper.selectmgrId(selectRole);
		return role;
	}

	public int inserttriumph(CrmTriumphVOVO crmTriumphVO) throws Exception {
		//分配信息
		List<CrmFYyTriumphVO> crmFYyTriumphVOList = crmTriumphVO.getCrmFYyTriumphVOList();
		//下发信息
		List<CrmFYyTriumphVO> crmTriuVOList = crmTriumphVO.getCrmFYyTriumphHVOList();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String date=df.format(new Date());// new Date()为获取当前系统时间
		UserInfoDTO user = getUserInfoDTO();
		if(crmFYyTriumphVOList.size()>0) {
			for (CrmFYyTriumphVO crmFYyTriumphVO : crmFYyTriumphVOList) {
				Map<String, Object> map = new HashMap<>();
				map.put("triumphId", crmFYyTriumphVO.getTriumphId());
				map.put("triumphName", crmFYyTriumphVO.getTriumphName());
				map.put("targetId", crmFYyTriumphVO.getTargetId());
				map.put("targetName", crmFYyTriumphVO.getTargetName());
				map.put("amount", crmFYyTriumphVO.getAmount());
				map.put("triumphLine", Integer.parseInt(crmFYyTriumphVO.getTriumphLine()));
				map.put("triumphYear", crmFYyTriumphVO.getTriumphYear());
				map.put("triumphLevel", Integer.parseInt(crmFYyTriumphVO.getTriumphLevel()));
				int count = acrmFcmCustmgrPerfMapper.getcheck(map);
				if (count == 0) {
					map.put("createDate", date);
					map.put("createUser", user.getUserName());
					map.put("seqno", UUID.randomUUID().toString().toLowerCase().replace("-", ""));
					acrmFcmCustmgrPerfMapper.inserttriumph(map);
				} else if (count == 1) {
					map.put("updateDate", date);
					map.put("updateUser", user.getUserName());
					acrmFcmCustmgrPerfMapper.updatetriumph(map);
					map.put("seqno", UUID.randomUUID().toString().toLowerCase().replace("-", ""));
					acrmFcmCustmgrPerfMapper.inserttriumphhictoric(map);
				}
			}}
			if (crmTriuVOList.size() > 0) {
				for (CrmFYyTriumphVO crmFYyTriumphVO : crmTriuVOList) {
					if("1".equals(crmFYyTriumphVO.getTriumphLevel())){
						if(crmFYyTriumphVO.getTargetName().contains("理财")){
							crmFYyTriumphVO.setTriumphLine("1");
						}else if(crmFYyTriumphVO.getTargetName().contains("个贷")){
							crmFYyTriumphVO.setTriumphLine("2");
						}
					}
					Map<String, Object> map = new HashMap<>();
					map.put("triumphId", crmFYyTriumphVO.getTriumphId());
					map.put("triumphName", crmFYyTriumphVO.getTriumphName());
					map.put("targetId", crmFYyTriumphVO.getTargetId());
					map.put("targetName", crmFYyTriumphVO.getTargetName());
					map.put("amount", crmFYyTriumphVO.getAmount());
					map.put("triumphLine", Integer.parseInt(crmFYyTriumphVO.getTriumphLine()));
					map.put("triumphYear", crmFYyTriumphVO.getTriumphYear());
					int triumphLevel=Integer.parseInt(crmFYyTriumphVO.getTriumphLevel());
					if(crmFYyTriumphVO.getTargetId().contains("G") && crmFYyTriumphVO.getTargetName().contains("团队") ){
						triumphLevel=4;
					}
					if(Integer.parseInt(crmFYyTriumphVO.getTriumphLevel())==4){
						triumphLevel=5;
					}
					map.put("triumphLevel", triumphLevel);
					int count = acrmFcmCustmgrPerfMapper.getcheck(map);
					if (count == 0) {
						map.put("createDate", date);
						map.put("createUser", user.getUserName());
						map.put("seqno", UUID.randomUUID().toString().toLowerCase().replace("-", ""));
						acrmFcmCustmgrPerfMapper.inserttriumph(map);
					} else if (count == 1) {
						map.put("updateDate", date);
						map.put("updateUser", user.getUserName());
						acrmFcmCustmgrPerfMapper.updatetriumph(map);
						map.put("seqno", UUID.randomUUID().toString().toLowerCase().replace("-", ""));
						acrmFcmCustmgrPerfMapper.inserttriumphhictoric(map);
					}
				}
			}
		return 0;
	}
	public static Workbook getWorkBook(MultipartFile file) {
		//获得文件名
		String fileName = file.getOriginalFilename();
		//创建Workbook工作薄对象，表示整个excel
		Workbook workbook = null;
		try {
			//获取excel文件的io流
			InputStream inpu =file.getInputStream();

			//  POIFSFileSystem is = new POIFSFileSystem(inpu);//构建POIFSFileSystem类对象，用输入流构建
			//根据文件后缀名不同(xls和xlsx)获得不同的Workbook实现类对象
			if(fileName.endsWith("xls")){
				//2003
				POIFSFileSystem is = new POIFSFileSystem(inpu);
				workbook = new HSSFWorkbook(is);
			}else if(fileName.endsWith("xlsx")){
				//2007 及2007以上
//            	workbook = new HSSFWorkbook(file.getInputStream());
				workbook = new XSSFWorkbook(inpu);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return workbook;
	}

	public List<Map<String, Object>> uploadlist(QueryModel queryModel) {
		UserInfoDTO user = getUserInfoDTO();
		Map<String,Object> map=new HashMap<>();
		map.put("loginCode",user.getLoginCode());
		PageHelper.startPage(queryModel.getPage(), queryModel.getSize());
		List<Map<String, Object>> list = acrmFcmCustmgrPerfMapper.uploadlist(map);
		PageHelper.clearPage();
		return list;
	}

	@Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public Map<String, Object> uploadtriumph(FileVO fileN,MultipartFile file) throws Exception {
		Map<String, Object> reMap = new HashMap<>();
		if(!file.getName().contains(".xlsx") || !file.getName().contains(".xls")){
			reMap.put("error","模板不正确，请核对后重新上传!");
			reMap.put("message", "error");
			return reMap;
		}
		int count = 0;
		int repeatNum = 0;
		int successNum = 0;
		UserInfoDTO user = getUserInfoDTO();
		String updateUser = user.getUserId();
		String createUser=user.getUserId();
		Date createDate=new Date();
		Date updateDate=createDate;
		Calendar cal = Calendar.getInstance();
		String triumphYear=String.valueOf(cal.get(Calendar.YEAR));
		try{
			//获得Workbook工作薄对象
			Workbook workbook = getWorkBook(file);
			//获得当前sheet工作表
			Sheet sheet = workbook.getSheetAt(0);
			// 获取所有行数
			int rows = sheet.getLastRowNum();
			Row row = null;
			Row roww = null;
            Row roww2 = null;
            Row rowws = null;
			Cell cell_a0 = null;
			Cell cell_a1 = null;
			Cell cell_a2 = null;
			Cell cell_a3 = null;
			Cell cell_a4 = null;
			Cell cell_a5 = null;
			Cell cell_a6 = null;
			Cell cell_a7 = null;
			Cell cell_a9 = null;
            Cell cell_a10 = null;
            Cell cell_a11 = null;
			//取出所有机构和客户经理信息
			List<organdmgrVO> mapList=acrmFcmCustmgrPerfMapper.selectorg();
            roww2= sheet.getRow(0);
            cell_a11=roww2.getCell(0);
            String cellValue11 = getCellValue(cell_a11);
            if(!cellValue11.contains("销售") || StringUtils.isEmpty(cellValue11)){
                reMap.put("error","模板不正确，请核对后重新上传!");
                reMap.put("message", "error");
                return reMap;
            }
            rowws = sheet.getRow(2);
            cell_a10=rowws.getCell(0);
            String cellValue10 = getCellValue(cell_a10);

            if(!cellValue10.contains("数据日期") || StringUtils.isEmpty(cellValue10)){
                reMap.put("error","模板不正确，请核对后重新上传!");
				reMap.put("message", "error");
				return reMap;
            }
            roww = sheet.getRow(3);
            cell_a9=roww.getCell(0);
            String cellValue9 = getCellValue(cell_a9);
			for (int i = 7; i <= rows; i++) {
				//获取第8行
				row = sheet.getRow(i);
                if(row.getCell(1)==null||"".equals(row.getCell(1).toString())){
					break;
				}else{
				cell_a0=row.getCell(0);
				cell_a1=row.getCell(1);
				cell_a2=row.getCell(2);
				cell_a3=row.getCell(3);
				cell_a4=row.getCell(4);
				cell_a5=row.getCell(9);
				cell_a6=row.getCell(14);
				cell_a7=row.getCell(22);
				String cellValue0 = getCellValue(cell_a0);
				String cellValue1 = getCellValue(cell_a1);
				String cellValue2 =getCellValue( cell_a2);
				String cellValue3 = getCellValue(cell_a3);
				String cellValue4 = getCellValue(cell_a4);
				String cellValue5 =getCellValue( cell_a5).replace(",","");
				String cellValue6 =getCellValue( cell_a6).replace(",","");
				String cellValue7 =getCellValue( cell_a7).replace(",","");
				Boolean istrue=true;
					for(int j=0;j<mapList.size();j++){  //通过循环输出列表中的内容
					if(mapList.get(j).getLoginCode().contains(cellValue2) && mapList.get(j).getOrgName().contains(cellValue0) && mapList.get(j).getUserName().contains(cellValue1)){
						istrue=true;
						break;
					}else{
						istrue=false;
					}
				}
				if(!istrue){
					reMap.put("error",cellValue2+"与"+cellValue0+"与"+cellValue1+"不匹配，请核对后重新输入");
					reMap.put("message", "error");
					return reMap;
				}else{
					NumberFormat nf = NumberFormat.getInstance();
					nf.setRoundingMode(RoundingMode.HALF_UP);//设置四舍五入
					nf.setMaximumFractionDigits(2);//设置最大保留几位小数
					CrmFYyTriumphPpopExcel crmFYyTriumphPpopExcel=new CrmFYyTriumphPpopExcel();
					crmFYyTriumphPpopExcel.setSeqno(UUID.randomUUID().toString().toLowerCase().replace("-", ""));
					crmFYyTriumphPpopExcel.setBranch(cellValue0);
					crmFYyTriumphPpopExcel.setBranchCode(acrmFcmCustmgrPerfMapper.selectorgId(cellValue0));
					crmFYyTriumphPpopExcel.setCustomerId(cellValue2);
					crmFYyTriumphPpopExcel.setCustomerName(cellValue1);
					crmFYyTriumphPpopExcel.setCustomerPost(cellValue4);
					crmFYyTriumphPpopExcel.setCustomerRank(cellValue3);
					crmFYyTriumphPpopExcel.setMiddleIncomeRevenue(cellValue7);
					crmFYyTriumphPpopExcel.setNetIncomeDeposits(cellValue5);
					if(Integer.parseInt(cellValue9)>9){
						crmFYyTriumphPpopExcel.setPpopMonth(triumphYear+"-"+cellValue9);
					}else{
						crmFYyTriumphPpopExcel.setPpopMonth(triumphYear+"-0"+cellValue9);
					}
					crmFYyTriumphPpopExcel.setSimulatedNetIncome(cellValue6);
					crmFYyTriumphPpopExcel.setCreateUser(user.getUserCode());
					crmFYyTriumphPpopExcel.setCreateDate(new Date());
					crmFYyTriumphPpopExcel.setBusNo(fileN.getBusNo());
					int countSum=acrmFcmCustmgrPerfMapper.selectfileCheck(crmFYyTriumphPpopExcel.getPpopMonth());
					if(countSum>0){
						acrmFcmCustmgrPerfMapper.deletefile(crmFYyTriumphPpopExcel.getPpopMonth());
					}
					acrmFcmCustmgrPerfMapper.insertexcel(crmFYyTriumphPpopExcel);
				}
			}
			}
		}catch(Exception e) {
			e.printStackTrace();
			throw new Exception("1");
		}
		reMap.put("message", "succese");
		return reMap;
	}

	public List<CrmFYyTriumphAumDetailed> queryaumdetailedlist(QueryModel queryModel) throws Exception {
		UserInfoDTO user = getUserInfoDTO();
		Map<String, Object> map = new HashMap<>();
		List<CrmFYyTriumphAumDetailed> listS=new ArrayList<>();
		map.put("_orgCode", user.getOrg().getCode());
		map.put("_userCode", user.getLoginCode());
		if(StringUtils.isNotEmpty((String)queryModel.getCondition().get("orgIdAuth"))){
            map.put("orgIdAuth", queryModel.getCondition().get("orgIdAuth"));
        }else{
            map.put("orgIdAuth", user.getOrg().getCode());
        }
        map.put("dataDate",getyear(new Date()).substring(0,4));
		String value=(String)queryModel.getCondition().get("mgrId");
		if(StringUtils.isNotEmpty(value)){
            map.put("mgrId", value);
			PageHelper.startPage(queryModel.getPage(), queryModel.getSize());
			listS=acrmFcmCustmgrPerfMapper.selectAum(map);
		}else{
			PageHelper.startPage(queryModel.getPage(), queryModel.getSize());
			listS=acrmFcmCustmgrPerfMapper.selectAumz(map);
		}
		PageHelper.clearPage();
		return listS;
	}

	public static String getyear(Date date) throws Exception {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(sdf.parse(sdf.format(date)));
		calendar.add(Calendar.DATE,-1);
		return sdf.format(calendar.getTime());
	}
	public static String getyearMoth(Date date) throws Exception {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(sdf.parse(sdf.format(date)));
		calendar.add(Calendar.DATE,-4);
		return sdf.format(calendar.getTime());
	}

	public static String getCellValue(Cell cell) {
		String cellValue = "";
		// 以下是判断数据的类型
		switch (cell.getCellTypeEnum()) {
			case NUMERIC: // 数字
				if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell)) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					cellValue = sdf.format(org.apache.poi.ss.usermodel.DateUtil.getJavaDate(cell.getNumericCellValue())).toString();
				} else {
					DataFormatter dataFormatter = new DataFormatter();
					cellValue = dataFormatter.formatCellValue(cell);
				}
				break;
			case STRING: // 字符串
				cellValue = cell.getStringCellValue();
				break;
			case BOOLEAN: // Boolean
				cellValue = cell.getBooleanCellValue() + "";
				break;
			case FORMULA: // 公式
				cellValue = cell.getCellFormula() + "";
				break;
			case BLANK: // 空值
				cellValue = "";
				break;
			case ERROR: // 故障
				cellValue = "非法字符";
				break;
			default:
				cellValue = "未知类型";
				break;
		}
		return cellValue;
	}
	public CrmTriumphlookVO Querylist(QueryModel queryModel) throws Exception {
		UserInfoDTO user = getUserInfoDTO();
		CrmTriumphlookVO crmTriumphlookVO = new CrmTriumphlookVO();
		//业绩查看
		 List<CrmFYyTriumphLookUp> crmFYyTriumphLookUpList = new ArrayList<>();
		//ppop信息
		List<CrmFYyTriumphLookPpop> CrmTriuLookPpopList = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		String role = getrole();
		//层级
		int triumphLevel = 0;
		//下辖层级
		int triumphLevelup =0;
		String triumphYear="";
		if(StringUtils.isEmpty((String)queryModel.getCondition().get("triumphYear"))){
			triumphYear=getyear(new Date()).substring(0,4);
		}else{
			triumphYear=(String)queryModel.getCondition().get("triumphYear");
		}
		String loginCode="";
		if(StringUtils.isNoneEmpty(user.getOrg().getCode())){
			loginCode=user.getOrg().getCode();
		}else{
			loginCode=user.getOrg().getId();
		}
		int triumphLine=getmgrType();
		if (headOffice.contains(role)) {
			map.put("triumphLevel", triumphLevel);
			map.put("triumphYear", triumphYear);
			map.put("triumphLine", 0);
            map.put("loginCode", "500");
		} else if (headOfficeB.contains(role)) {
			triumphLevel = 0;
			map.put("triumphLevel", triumphLevel);
			map.put("triumphYear",triumphYear);
			map.put("triumphLine",triumphLine);
            map.put("loginCode", "500");
		} else if (branch.contains(role)) {
			triumphLevel = 2;
			map.put("loginCode", loginCode.substring(0,2));
			map.put("triumphLevel", triumphLevel);
			map.put("triumphYear",triumphYear);
			map.put("triumphLine",triumphLine);
		} else if (subbranch.contains(role)) {
			triumphLevel = 3;
			map.put("loginCode", loginCode);
			map.put("triumphLevel", triumphLevel);
			map.put("triumphYear",triumphYear);
			map.put("triumphLine",triumphLine);
		} else if (patrolLeader.contains(role)) {
			triumphLevel = 4;
			String mktTeamIds = "";
			//查询团队编号
			String mktTeamId = acrmFcmCustmgrPerfMapper.getmktTeamId(user.getLoginCode());

			map.put("loginCode", mktTeamId);
			map.put("triumphLevel", triumphLevel);
			map.put("triumphYear", triumphYear);
			map.put("triumphLine",triumphLine);
		} else if (customerManage.contains(role)) {
			triumphLevel = 5;
			map.put("loginCode", user.getLoginCode());
			map.put("triumphLevel", triumphLevel);
			map.put("triumphYear", triumphYear);
			map.put("triumphLine",triumphLine);
		}
		    //其余指标
            crmFYyTriumphLookUpList = acrmFcmCustmgrPerfMapper.selectcrmFYyTriumphLookUpListlist(map);
		 //手续费存款指标
		map.put("dataDate",getyearMoth(new Date()).substring(0,4));
		List<CrmFYyTriumphLookUp>  crmFYyTriumplist = acrmFcmCustmgrPerfMapper.selectcrmFYyTriumphListlist(map);
		crmFYyTriumphLookUpList.addAll(crmFYyTriumplist);

		CrmTriuLookPpopList = acrmFcmCustmgrPerfMapper.selectcrmCrmTriuLookPpopList(map);
		crmTriumphlookVO.setCrmFYyTriumphLookUpList(crmFYyTriumphLookUpList);
		crmTriumphlookVO.setCrmTriuLookPpopList(CrmTriuLookPpopList);
		return crmTriumphlookVO;
	}

	public List<CrmFYyTriumphDepositDetailed> querydepositdetailedlist(QueryModel queryModel) throws Exception {
		UserInfoDTO user = getUserInfoDTO();
		Map<String, Object> map = new HashMap<>();
        map.put("_orgCode", user.getOrg().getCode());
        map.put("_userCode", user.getLoginCode());
		List<CrmFYyTriumphDepositDetailed> listS=new ArrayList<>();
        if(StringUtils.isNotEmpty((String)queryModel.getCondition().get("orgIdAuth"))){
            map.put("orgIdAuth", queryModel.getCondition().get("orgIdAuth"));
        }else{
            map.put("orgIdAuth", user.getOrg().getCode());
        }
		map.put("dataDate",getyearMoth(new Date()).substring(0,4));
        String value=(String)queryModel.getCondition().get("targetId");
		String role = getrole();
		if(StringUtils.isEmpty(value) && customerManage.contains(role)){
			value=user.getLoginCode();
		}

        if(StringUtils.isNotEmpty(value)){
            map.put("targetId", value);
			PageHelper.startPage(queryModel.getPage(), queryModel.getSize());
			listS=acrmFcmCustmgrPerfMapper.selectdeposit(map);
		}else{
			PageHelper.startPage(queryModel.getPage(), queryModel.getSize());
			listS=acrmFcmCustmgrPerfMapper.selectdepositL(map);
		}
		PageHelper.clearPage();
		return listS;
	}

	public List<CrmFYyTriumphLoanDetailed> queryloandetailedlist(QueryModel queryModel) throws Exception {
		UserInfoDTO user = getUserInfoDTO();
		Map<String, Object> map = new HashMap<>();
		List<CrmFYyTriumphLoanDetailed> listS=new ArrayList<>();
        map.put("_orgCode", user.getOrg().getCode());
        map.put("_userCode", user.getLoginCode());
        if(StringUtils.isNotEmpty((String)queryModel.getCondition().get("orgIdAuth"))){
            map.put("orgIdAuth", queryModel.getCondition().get("orgIdAuth"));
        }else{
            map.put("orgIdAuth", user.getOrg().getCode());
        }
		//产品类型（01：按揭贷款 02：车位贷款）
		String loanType=(String)queryModel.getCondition().get("loanType");
		if(StringUtils.isEmpty(loanType)){
			loanType="00";
		}
		map.put("loanType", loanType);
		map.put("dataDate",getyear(new Date()).substring(0,4));
        String value=(String)queryModel.getCondition().get("targetId");
		String role = getrole();
        if(StringUtils.isEmpty(value) && customerManage.contains(role)){
            value=user.getLoginCode();
        }
        if(StringUtils.isNotEmpty(value)){
            map.put("targetId", value);
			PageHelper.startPage(queryModel.getPage(), queryModel.getSize());
			listS=acrmFcmCustmgrPerfMapper.selectloan(map);
		}else{
			PageHelper.startPage(queryModel.getPage(), queryModel.getSize());
			listS=acrmFcmCustmgrPerfMapper.selectselectloanL(map);
		}
		PageHelper.clearPage();
		return listS;
	}

	public List<CrmFYyTriumphCharge> querychargedetailedlist(QueryModel queryModel) throws Exception {
		UserInfoDTO user = getUserInfoDTO();
		Map<String, Object> map = new HashMap<>();
		List<CrmFYyTriumphCharge> listS=new ArrayList<>();
        map.put("_orgCode", user.getOrg().getCode());
        map.put("_userCode", user.getLoginCode());
        if(StringUtils.isNotEmpty((String)queryModel.getCondition().get("orgIdAuth"))){
            map.put("orgIdAuth", queryModel.getCondition().get("orgIdAuth"));
        }else{
            map.put("orgIdAuth", user.getOrg().getCode());
        }
		//产品类型(01：利率、汇率挂钩手续费收入 02：人民币基金手续费收入 03：ODII手续费收入 04：境内结构性产品手续费收入)'
		String chargeType=(String)queryModel.getCondition().get("chargeType");
		if(StringUtils.isEmpty(chargeType)){
			chargeType="01";
		}
		map.put("chargeType", chargeType);
		map.put("dataDate",getyearMoth(new Date()).substring(0,4));
        String value=(String)queryModel.getCondition().get("targetId");
		String role = getrole();
        if(StringUtils.isEmpty(value) && customerManage.contains(role)){
            value=user.getLoginCode();
        }
        if(StringUtils.isNotEmpty(value)){
            map.put("targetId", value);
			PageHelper.startPage(queryModel.getPage(), queryModel.getSize());
			listS=acrmFcmCustmgrPerfMapper.selectCharge(map);
		}else{
			PageHelper.startPage(queryModel.getPage(), queryModel.getSize());
			listS=acrmFcmCustmgrPerfMapper.selectChargeL(map);
		}
		PageHelper.clearPage();
		return listS;
	}

	public List<CrmFYyTriumphLookUp> Querydetalist(QueryModel queryModel) throws Exception {
		Map<String,Object> map=getMapvalue(queryModel);
		String value=(String) queryModel.getCondition().get("targetId");
		if(StringUtils.isNotEmpty(value)){
            map.put("triumphLevel",null);
        }
        List<CrmFYyTriumphLookUp> list= new ArrayList<>();
        if(TRIUMPH_CHARGE_T4.contains((String)map.get("triumphId"))){
			list = acrmFcmCustmgrPerfMapper.CrmFYyTriumphLookUpListt4(map);
		}else{
			list = acrmFcmCustmgrPerfMapper.CrmFYyTriumphLookUpList(map);
		}

		return list;
	}

	private Map<String, String>  getdataa(String newdate) throws Exception {
		Calendar from = Calendar.getInstance();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM");
		Date date=sdf.parse(newdate);
		from.setTime(date);
		Map<String, String> map = new HashMap<>();
		String str1 = from.get(Calendar.YEAR) + "-" + fillZero(from.get(Calendar.MONTH) + 1);
		map.put("Start", str1);
		from.add(Calendar.MONTH, +5);
		String str2 = from.get(Calendar.YEAR) + "-" + fillZero(from.get(Calendar.MONTH) + 1);
		map.put("end", str2);
		return map;
	}


	private Map<String, String> getdata(String newdate) throws Exception {
		Calendar from = Calendar.getInstance();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM");
		Date date=sdf.parse(newdate);
		from.setTime(date);
		Map<String, String> map = new HashMap<>();
		String str1 = from.get(Calendar.YEAR) + "-" + fillZero(from.get(Calendar.MONTH) + 1);
		map.put("end", str1);
		from.add(Calendar.MONTH, -5);
		String str2 = from.get(Calendar.YEAR) + "-" + fillZero(from.get(Calendar.MONTH) + 1);
		map.put("Start", str2);
		return map;
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

	public lookupVO Querydetappoplist(QueryModel queryModel) throws Exception {
		Map<String, Object> map = new HashMap<>();
		String role = getrole();
		UserInfoDTO user = getUserInfoDTO();
		//层级
		int triumphLevel = 0;
		String loginCode="";
		if(StringUtils.isNoneEmpty(user.getOrg().getCode())){
			loginCode=user.getOrg().getCode();
		}else{
			loginCode=user.getOrg().getId();
		}
		int triumphLine=getmgrType();
		if (headOffice.contains(role)) {
			map.put("triumphLevel", 3);
            map.put("triumphLevellevel", 0);
			map.put("triumphLine", 0);
		} else if (headOfficeB.contains(role)) {
			map.put("triumphLevel", 3);
            map.put("triumphLevellevel", 0);
			map.put("triumphLine",triumphLine);
		} else if (branch.contains(role)) {
			map.put("loginCode", loginCode.substring(0,2));
			map.put("triumphLevel", 4);
            map.put("triumphLevellevel", 2);
			map.put("triumphLine",triumphLine);
		} else if (subbranch.contains(role)) {
			map.put("loginCode", loginCode);
			map.put("triumphLevel", 5);
            map.put("triumphLevellevel", 3);
			map.put("triumphLine",triumphLine);
		} else if (patrolLeader.contains(role)) {
			//查询团队编号
			String mktTeamId = acrmFcmCustmgrPerfMapper.getmktTeamId(user.getLoginCode());
			map.put("loginCode", mktTeamId);
			map.put("triumphLevel", 5);
            map.put("triumphLevellevel", 4);
			map.put("triumphLine",triumphLine);
		}
		String newDate=getyear(new Date()).substring(0,7);
		String month=(String)queryModel.getCondition().get("month");
           if(StringUtils.isNotEmpty(month)){
			   map.put("month",month);
		   }else{
			   map.put("month",newDate);
		   }
        List<CrmFYyTriumphLookUp> list=new ArrayList<>();
		lookupVO lookupVO=new lookupVO();
            list = acrmFcmCustmgrPerfMapper.Querydetappoplistl(map);
		lookupVO.setCrmFYyTriumphVOList(list);
		analyseVO vo=acrmFcmCustmgrPerfMapper.selectppop(map);
		lookupVO.setNalyseVO(vo);
		return lookupVO;
	}

    public void exporttriumphlook(HttpServletResponse response, QueryModel queryModel) throws Exception {
        Map<String, Object> map = new HashMap<>();
        String selectRole = (String) queryModel.getCondition().get("selectRole");
        String role = this.acrmFcmCustmgrPerfMapper.selectmgrId(selectRole);
        UserInfoDTO user = getUserInfoDTO();
        //层级
        int triumphLevel = 0;
		int triumphLine=0;
		String loginCode="";
		if(StringUtils.isNoneEmpty(user.getOrg().getCode())){
			loginCode=user.getOrg().getCode();
		}else{
			loginCode=user.getOrg().getId();
		}
		if (MGR_ROLE_1.contains(role)) {
			triumphLine = 1;
		} else if (MGR_ROLE_2.contains(role)) {
			triumphLine = 2;
		}else{
            triumphLine = 0;
        }
        if (headOffice.contains(role)) {
            map.put("triumphLevel", triumphLevel);
            map.put("triumphLine", 0);
            map.put("loginCode", "500");
        } else if (headOfficeB.contains(role)) {
            triumphLevel = 0;
            map.put("triumphLevel", triumphLevel);
            map.put("triumphLine",triumphLine);
            map.put("loginCode", "500");
        } else if (branch.contains(role)) {
            triumphLevel = 2;
            map.put("loginCode", loginCode.substring(0,2));
            map.put("triumphLevel", triumphLevel);
            map.put("triumphLine",triumphLine);
        } else if (subbranch.contains(role)) {
            triumphLevel = 3;
            map.put("loginCode", loginCode);
            map.put("triumphLevel", triumphLevel);
            map.put("triumphLine",triumphLine);
        } else if (patrolLeader.contains(role)) {
            triumphLevel = 4;
            String mktTeamIds = "";
            //查询团队编号
            String mktTeamId = acrmFcmCustmgrPerfMapper.getmktTeamId(user.getLoginCode());
            map.put("loginCode", mktTeamId);
            map.put("triumphLevel", triumphLevel);
            map.put("triumphLine",triumphLine);
        } else if (customerManage.contains(role)) {
            triumphLevel = 5;
            map.put("loginCode", user.getLoginCode());
            map.put("triumphLevel", triumphLevel);
            map.put("triumphLine",triumphLine);
        }
		String newDate ="";
		String targetId=(String)queryModel.getCondition().get("targetId");
		String triumphId=(String)queryModel.getCondition().get("triumphId");
		map.put("triumphId",triumphId);
		if(TRIUMPH_CHARGE_T4.contains((String)map.get("triumphId"))){
			newDate=getyearMoth(new Date()).substring(0,7);
		}else{
			newDate=getyear(new Date()).substring(0,7);
		}
        String startDate=(String)queryModel.getCondition().get("startDate");
        String endDate=(String)queryModel.getCondition().get("endDate");
        if (StringUtils.isNotEmpty(newDate) && StringUtils.isEmpty(startDate) && StringUtils.isEmpty(endDate)) {
			map.put("startDate", getdata(newDate).get("Start"));
			map.put("endDate",getdata(newDate).get("end"));
        } else if (StringUtils.isEmpty(startDate) && StringUtils.isNotEmpty(endDate)) {
			map.put("startDate", getdata(endDate).get("Start"));
			map.put("endDate",getdata(endDate).get("end"));
        } else if (StringUtils.isNotEmpty(startDate) && StringUtils.isEmpty(endDate)) {
            map.put("startDate", getdataa(startDate).get("Start"));
			map.put("endDate",getdataa(startDate).get("end"));
        }else if(StringUtils.isNotEmpty(startDate) && StringUtils.isNotEmpty(endDate)){
			map.put("startDate", startDate);
			map.put("endDate",endDate);
		}
        if(map.get("loginCode")!=null && StringUtils.isNotEmpty(targetId)){
            map.put("targetId", targetId);
        }else if(map.get("loginCode")==null && StringUtils.isNotEmpty(targetId)){
            map.put("targetId", targetId);
        }else if(map.get("loginCode")!=null && StringUtils.isEmpty(targetId)){
            map.put("targetId", map.get("loginCode"));
        }
        map.put("_orgCode", user.getOrg().getCode());
        map.put("_userCode", user.getLoginCode());
        if(StringUtils.isNotEmpty((String)queryModel.getCondition().get("orgIdAuth"))){
            map.put("orgIdAuth", queryModel.getCondition().get("orgIdAuth"));
        }else{
            map.put("orgIdAuth", user.getOrg().getCode());
        }
        //1.创建一个workbook,对应一个excel文件
        HSSFWorkbook wb = new HSSFWorkbook();

        //2.在workbook中添加一个sheet,对应Excel中的sheet
        HSSFSheet sheet = wb.createSheet((String)queryModel.getCondition().get("triumphName")+"分析数据导出");

        //设置每一列的列宽
        sheet.setColumnWidth(0,290*15);
        sheet.setColumnWidth(1,256*15);
        sheet.setColumnWidth(2,290*15);
        sheet.setColumnWidth(3,290*15);
        sheet.setColumnWidth(4,256*15);
        sheet.setColumnWidth(5,256*15);
        sheet.setColumnWidth(6,256*15);
        sheet.setColumnWidth(7,256*15);
        sheet.setColumnWidth(8,256*15);
        sheet.setColumnWidth(9,256*15);
        sheet.setColumnWidth(10,256*15);
        sheet.setColumnWidth(11,256*15);

        //3.设置样式以及字体样式
        HSSFCellStyle titleStyle = ExcelUtils.createTitleCellStyle(wb);
        HSSFCellStyle headerStyle = ExcelUtils.createHeadCellStyle(wb);
        HSSFCellStyle contentStyle = ExcelUtils.createContentCellStyle(wb);

        //4.创建标题，合并标题单元格
        //行号
        int rowNum = 0;
		String startDateDate=(String) map.get("startDate");
		String endDateDate=(String) map.get("endDate");
		String[] row_second=null;
		List<String> month=getMonths(startDateDate,endDateDate);
		String[] toBeStored = month.toArray(new String[month.size()]);
		String year=startDateDate.substring(0,4);

        //创建第一行，索引从0开始(标题行)
        HSSFRow row0 = sheet.createRow(rowNum++);
        row0.setHeight((short) 800);// 设置行高
        String title =(String)queryModel.getCondition().get("triumphName")+"分析数据导出";
        HSSFCell c00 = row0.createCell(0);
        c00.setCellValue(title);
        c00.setCellStyle(titleStyle);
		int size=month.size();
        // 合并单元格，参数依次为起始行，结束行，起始列，结束列 （索引0开始）
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, size+5));//标题合并单元格操作，总列数为12

        //第二行
        HSSFRow row1 = sheet.createRow(rowNum++);
        row1.setHeight((short)500);
		String[] row_first =null;
		if(size==2){
			row_first = new String[]{"数据更新时间", newDate, "", "", "", "", "数据统计时间", ""};
		}else if(size==3){
			row_first = new String[]{"数据更新时间", newDate, "", "", "", "", "数据统计时间", "", ""};
		}else if(size==4){
			row_first = new String[]{"数据更新时间", newDate, "", "", "", "", "数据统计时间", "", "", ""};
		}else if(size==5){
			row_first = new String[]{"数据更新时间", newDate, "", "", "", "", "数据统计时间", "", "", "", ""};
		}else if(size==6){
			row_first = new String[]{"数据更新时间", newDate, "", "", "", "", "数据统计时间", "", "", "", "", ""};
		}
        for (int i = 0; i < row_first.length; i++) {
            HSSFCell tempCell = row1.createCell(i);
            tempCell.setCellValue(row_first[i]);
            tempCell.setCellStyle(headerStyle);
        }
		//合并单元格
		//时间
		sheet.addMergedRegion(new CellRangeAddress(1, 1, 1, 5));
		//数据统计时间
		int sizee=month.size();
		sheet.addMergedRegion(new CellRangeAddress(1, 1, 6, sizee+5));
		//第三行
		HSSFRow row2 = sheet.createRow(rowNum++);
		row2.setHeight((short)500);

		for(int j = 0; j < toBeStored.length; j++){
			map.put("month1",toBeStored[j]);
			if(month.size()==2){
				row_second = new String[]{"分行机构", "支行机构", "客户经理姓名", "客户经理编号", "客户姓名", "ECIF号", toBeStored[j].substring(0,4)+"年"+toBeStored[j].substring(5,7)+"月", toBeStored[j+1].substring(0,4)+"年"+toBeStored[j+1].substring(5,7)+"月"};
			    map.put("month2",toBeStored[j+1]);
			}
			if(month.size()==3){
				row_second = new String[]{"分行机构", "支行机构", "客户经理姓名", "客户经理编号", "客户姓名", "ECIF号", toBeStored[j].substring(0,4)+"年"+toBeStored[j].substring(5,7)+"月", toBeStored[j+1].substring(0,4)+"年"+toBeStored[j+1].substring(5,7)+"月", toBeStored[j+2].substring(0,4)+"年"+toBeStored[j+2].substring(5,7)+"月"};
                map.put("month2",toBeStored[j+1]);
				map.put("month3",toBeStored[j+2]);
			}
			if(month.size()==4){
				row_second = new String[]{"分行机构", "支行机构", "客户经理姓名", "客户经理编号", "客户姓名", "ECIF号", toBeStored[j].substring(0,4)+"年"+toBeStored[j].substring(5,7)+"月", toBeStored[j+1].substring(0,4)+"年"+toBeStored[j+1].substring(5,7)+"月", toBeStored[j+2].substring(0,4)+"年"+toBeStored[j+2].substring(5,7)+"月", toBeStored[j+3].substring(0,4)+"年"+toBeStored[j+3].substring(5,7)+"月"};
                map.put("month2",toBeStored[j+1]);
                map.put("month3",toBeStored[j+2]);
				map.put("month4",toBeStored[j+3]);
			}
			if(month.size()==5){
				row_second = new String[]{"分行机构", "支行机构", "客户经理姓名", "客户经理编号", "客户姓名", "ECIF号", toBeStored[j].substring(0,4)+"年"+toBeStored[j].substring(5,7)+"月", toBeStored[j+1].substring(0,4)+"年"+toBeStored[j+1].substring(5,7)+"月", toBeStored[j+2].substring(0,4)+"年"+toBeStored[j+2].substring(5,7)+"月", toBeStored[j+3].substring(0,4)+"年"+toBeStored[j+3].substring(5,7)+"月", toBeStored[j+4].substring(0,4)+"年"+toBeStored[j+4].substring(5,7)+"月"};
                map.put("month2",toBeStored[j+1]);
                map.put("month3",toBeStored[j+2]);
                map.put("month4",toBeStored[j+3]);
				map.put("month5",toBeStored[j+4]);
			}
			if(month.size()==6){
				row_second = new String[]{"分行机构", "支行机构", "客户经理姓名", "客户经理编号", "客户姓名", "ECIF号", toBeStored[j].substring(0,4)+"年"+toBeStored[j].substring(5,7)+"月", toBeStored[j+1].substring(0,4)+"年"+toBeStored[j+1].substring(5,7)+"月", toBeStored[j+2].substring(0,4)+"年"+toBeStored[j+2].substring(5,7)+"月", toBeStored[j+3].substring(0,4)+"年"+toBeStored[j+3].substring(5,7)+"月", toBeStored[j+4].substring(0,4)+"年"+toBeStored[j+4].substring(5,7)+"月", toBeStored[j+5].substring(0,4)+"年"+toBeStored[j+5].substring(5,7)+"月"};
                map.put("month2",toBeStored[j+1]);
                map.put("month3",toBeStored[j+2]);
                map.put("month4",toBeStored[j+3]);
                map.put("month5",toBeStored[j+4]);
				map.put("month6",toBeStored[j+5]);
			}
			break;
		}
		for (int i = 0; i < row_second.length; i++) {
			HSSFCell tempCell = row2.createCell(i);
			tempCell.setCellValue(row_second[i]);
			tempCell.setCellStyle(headerStyle);
		}
        //查询指标分析数据列表
        List<CrmFYyTriumphLookUpEXCEL> list=new ArrayList<>();
		if(TRIUMPH_CHARGE_T4.contains((String)map.get("triumphId"))){
			list = acrmFcmCustmgrPerfMapper.CrmFYyTriumphLookUpListlistExcelT4(map);
		}else{
			list = acrmFcmCustmgrPerfMapper.CrmFYyTriumphLookUpListlistExcel(map);
		}
        for(int i = 0;i<list.size();i++) {
			HSSFRow tempRow = sheet.createRow(rowNum++);
			tempRow.setHeight((short) 500);
			//循环单元格填入数据
			for (int j = 0; j < row_second.length; j++) {
				HSSFCell tempCell = tempRow.createCell(j);
				tempCell.setCellStyle(contentStyle);
				String cellValue = "";
				if (headOffice.contains(role) || headOfficeB.contains(role)) {
					if(j==6){
						cellValue=getmonth(list.get(i),j);
					}else if(j==7){
						cellValue=getmonth(list.get(i),j);
					}else if(j==8){
						cellValue=getmonth(list.get(i),j);
					}else if(j==9){
						cellValue=getmonth(list.get(i),j);
					}else if(j==10){
						cellValue=getmonth(list.get(i),j);
					}else if(j==11){
						cellValue=getmonth(list.get(i),j);
					}
				} else if (branch.contains(role)) {
					if (j == 0) {
						cellValue = list.get(i).getTargetName();
					}else if(j==6){
						cellValue=getmonth(list.get(i),j);
					}else if(j==7){
						cellValue=getmonth(list.get(i),j);
					}else if(j==8){
						cellValue=getmonth(list.get(i),j);
					}else if(j==9){
						cellValue=getmonth(list.get(i),j);
					}else if(j==10){
						cellValue=getmonth(list.get(i),j);
					}else if(j==11){
						cellValue=getmonth(list.get(i),j);
					}
                } else if (subbranch.contains(role)) {
					if (j == 1) {
						cellValue = list.get(i).getTargetName();
					}else if(j==6){
						cellValue=getmonth(list.get(i),j);
					}else if(j==7){
						cellValue=getmonth(list.get(i),j);
					}else if(j==8){
						cellValue=getmonth(list.get(i),j);
					}else if(j==9){
						cellValue=getmonth(list.get(i),j);
					}else if(j==10){
						cellValue=getmonth(list.get(i),j);
					}else if(j==11){
						cellValue=getmonth(list.get(i),j);
					}
                } else if (patrolLeader.contains(role)) {
					if(j==6){
						cellValue=getmonth(list.get(i),j);
					}else if(j==7){
						cellValue=getmonth(list.get(i),j);
					}else if(j==8){
						cellValue=getmonth(list.get(i),j);
					}else if(j==9){
						cellValue=getmonth(list.get(i),j);
					}else if(j==10){
						cellValue=getmonth(list.get(i),j);
					}else if(j==11){
						cellValue=getmonth(list.get(i),j);
					}
                } else if (customerManage.contains(role)) {
					if (j == 2) {
						cellValue = list.get(i).getTargetName();
					} else if (j == 3) {
						cellValue = list.get(i).getTargetId();
					} else if(j==6){
						cellValue=getmonth(list.get(i),j);
					}else if(j==7){
						cellValue=getmonth(list.get(i),j);
					}else if(j==8){
						cellValue=getmonth(list.get(i),j);
					}else if(j==9){
						cellValue=getmonth(list.get(i),j);
					}else if(j==10){
						cellValue=getmonth(list.get(i),j);
					}else if(j==11){
						cellValue=getmonth(list.get(i),j);
					}

                }
				tempCell.setCellValue(cellValue);
			}
        }

				//导出excel
				String fileName = (String) queryModel.getCondition().get("triumphName") + "分析数据导出.xls";
				try {
					fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
					response.setHeader("Content-disposition", "attachment;filename=\"" + fileName + "\"");
					OutputStream stream = response.getOutputStream();
					if (null != wb && null != stream) {
						wb.write(stream);
						wb.close();
						stream.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}


	}

	private String getmonth(CrmFYyTriumphLookUpEXCEL crmFYyTriumphLookUpEXCEL, int j) {
		String cellValue="";
		if(j==6){
			if(crmFYyTriumphLookUpEXCEL.getMonth1()==null){
				cellValue = "0";
			} else {
				cellValue = crmFYyTriumphLookUpEXCEL.getMonth1().toString();
			}
		}else if(j==7){
			if(crmFYyTriumphLookUpEXCEL.getMonth2()==null){
				cellValue = "0";
			} else {
				cellValue = crmFYyTriumphLookUpEXCEL.getMonth2().toString();
			}
		}else if(j==8){
			if(crmFYyTriumphLookUpEXCEL.getMonth3()==null){
				cellValue = "0";
			} else {
				cellValue = crmFYyTriumphLookUpEXCEL.getMonth3().toString();
			}
		}else if(j==9){
			if(crmFYyTriumphLookUpEXCEL.getMonth4()==null){
				cellValue = "0";
			} else {
				cellValue = crmFYyTriumphLookUpEXCEL.getMonth4().toString();
			}
		}else if(j==10){
			if(crmFYyTriumphLookUpEXCEL.getMonth5()==null){
				cellValue = "0";
			} else {
				cellValue = crmFYyTriumphLookUpEXCEL.getMonth5().toString();
			}
		}else if(j==11){
			if(crmFYyTriumphLookUpEXCEL.getMonth6()==null){
				cellValue = "0";
			} else {
				cellValue = crmFYyTriumphLookUpEXCEL.getMonth6().toString();
			}
		}
		return cellValue;
	}


	private List<String> getMonths(String startMonth,String endMonth) throws Exception {
		LinkedList<String> months = new LinkedList<>();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		Calendar minCalender = Calendar.getInstance();
		Calendar maxCalender = Calendar.getInstance();

		// 设置开始月份
		minCalender.setTime(sdf.parse(startMonth));
		minCalender.set(minCalender.get(Calendar.YEAR), minCalender.get(Calendar.MONTH), 1);

		maxCalender.setTime(sdf.parse(endMonth));
		// 设置日期,保证最后一个日期参数 大于 开始时间日历
		maxCalender.set(maxCalender.get(Calendar.YEAR), maxCalender.get(Calendar.MONTH), 2);

		while (minCalender.before(maxCalender)) {
			months.add(sdf.format(minCalender.getTime()));
			minCalender.add(Calendar.MONTH, 1);
		}
		return months;
	}



	public List exporttriump(HttpServletResponse response, QueryModel queryModel) throws Exception {
		UserInfoDTO user = getUserInfoDTO();
		//业绩查看
		List<CrmFYyTriumphLookUp> crmFYyTriumphLookUpList = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		String role = getrole();
		//层级
		int triumphLevel = 0;
		String triumphYear="";
		if(StringUtils.isEmpty((String)queryModel.getCondition().get("triumphYear"))){
			Calendar cal = Calendar.getInstance();
			triumphYear=String.valueOf(cal.get(Calendar.YEAR));
		}else{
			triumphYear=(String)queryModel.getCondition().get("triumphYear");
		}
		String loginCode="";
		if(StringUtils.isNoneEmpty(user.getOrg().getCode())){
			loginCode=user.getOrg().getCode();
		}else{
			loginCode=user.getOrg().getId();
		}
		int triumphLine=getmgrType();
		if (headOffice.contains(role)) {
			map.put("triumphLevel", triumphLevel);
			map.put("triumphYear", triumphYear);
			map.put("triumphLine", 0);
            map.put("loginCode", "500");
		} else if (headOfficeB.contains(role)) {
			triumphLevel = 0;
			map.put("triumphLevel", triumphLevel);
			map.put("triumphYear",triumphYear);
			map.put("triumphLine",triumphLine);
            map.put("loginCode", "500");
		} else if (branch.contains(role)) {
			triumphLevel = 2;
			map.put("loginCode", loginCode.substring(0,2));
			map.put("triumphLevel", triumphLevel);
			map.put("triumphYear",triumphYear);
			map.put("triumphLine",triumphLine);
		} else if (subbranch.contains(role)) {
			triumphLevel = 3;
			map.put("loginCode", loginCode);
			map.put("triumphLevel", triumphLevel);
			map.put("triumphYear",triumphYear);
			map.put("triumphLine",triumphLine);
		} else if (patrolLeader.contains(role)) {
			triumphLevel = 4;
			//查询团队编号
			String mktTeamId = acrmFcmCustmgrPerfMapper.getmktTeamId(user.getLoginCode());

			map.put("loginCode", mktTeamId);
			map.put("triumphLevel", triumphLevel);
			map.put("triumphYear", triumphYear);
			map.put("triumphLine",triumphLine);
		} else if (customerManage.contains(role)) {
			triumphLevel = 5;
			map.put("loginCode", user.getLoginCode());
			map.put("triumphLevel", triumphLevel);
			map.put("triumphYear", triumphYear);
			map.put("triumphLine",triumphLine);
		}
		String excelName = "业绩查看列表";
		crmFYyTriumphLookUpList = acrmFcmCustmgrPerfMapper.selectcrmFYyTriumphLookUpListlist(map);
		//手续费存款指标
		map.put("dataDate",getyearMoth(new Date()).substring(0,4));
		List<CrmFYyTriumphLookUp>  crmFYyTriumplist = acrmFcmCustmgrPerfMapper.selectcrmFYyTriumphListlist(map);
		crmFYyTriumphLookUpList.addAll(crmFYyTriumplist);
		ExportExcelUtils2.export(excelName, crmFYyTriumphLookUpList, CrmFYyTriumphLookUp.class, response);
		return null;
	}

	public List exportAumdetailed(HttpServletResponse response, QueryModel queryModel) throws Exception {
		UserInfoDTO user = getUserInfoDTO();
		Map<String, Object> map = new HashMap<>();
		List<CrmFYyTriumphAumDetailed> listS=new ArrayList<>();
		map.put("_orgCode", user.getOrg().getCode());
		map.put("_userCode", user.getLoginCode());
		if(StringUtils.isNotEmpty((String)queryModel.getCondition().get("orgIdAuth"))){
			map.put("orgIdAuth", queryModel.getCondition().get("orgIdAuth"));
		}else{
			map.put("orgIdAuth", user.getOrg().getCode());
		}
		map.put("dataDate",getyear(new Date()).substring(0,4));
		if(StringUtils.isNotEmpty((String)queryModel.getCondition().get("mgrId"))){
			listS=acrmFcmCustmgrPerfMapper.selectAum(map);
		}else{
			listS=acrmFcmCustmgrPerfMapper.selectAumz(map);
		}
		String excelName = "AUM余额详情列表";
		ExportExcelUtils2.export(excelName, listS, CrmFYyTriumphAumDetailed.class, response);
		return null;
	}

	public List exportdepositdetailed(HttpServletResponse response, QueryModel queryModel) throws Exception {
		UserInfoDTO user = getUserInfoDTO();
		Map<String, Object> map = new HashMap<>();
		map.put("_orgCode", user.getOrg().getCode());
		map.put("_userCode", user.getLoginCode());
		List<CrmFYyTriumphDepositDetailed> listS=new ArrayList<>();
		if(StringUtils.isNotEmpty((String)queryModel.getCondition().get("orgIdAuth"))){
			map.put("orgIdAuth", queryModel.getCondition().get("orgIdAuth"));
		}else{
			map.put("orgIdAuth", user.getOrg().getCode());
		}
		map.put("dataDate",getyearMoth(new Date()).substring(0,4));
		if(StringUtils.isNotEmpty((String)queryModel.getCondition().get("targetId"))){
			listS=acrmFcmCustmgrPerfMapper.selectdeposit(map);
		}else{
			listS=acrmFcmCustmgrPerfMapper.selectdepositL(map);
		}
		String excelName = "存款详情列表";
		ExportExcelUtils2.export(excelName, listS, CrmFYyTriumphDepositDetailed.class, response);
		return null;
	}

	public List exportloandetailed(HttpServletResponse response, QueryModel queryModel) throws Exception {
		UserInfoDTO user = getUserInfoDTO();
		Map<String, Object> map = new HashMap<>();
		List<CrmFYyTriumphLoanDetailed> listS=new ArrayList<>();
		map.put("_orgCode", user.getOrg().getCode());
		map.put("_userCode", user.getLoginCode());
		if(StringUtils.isNotEmpty((String)queryModel.getCondition().get("orgIdAuth"))){
			map.put("orgIdAuth", queryModel.getCondition().get("orgIdAuth"));
		}else{
			map.put("orgIdAuth", user.getOrg().getCode());
		}
		map.put("dataDate",getyear(new Date()).substring(0,4));
		//产品类型（01：按揭贷款 02：车位贷款）
		String loanType=(String)queryModel.getCondition().get("loanType");
		if(StringUtils.isEmpty(loanType)){
			loanType="";
		}
		map.put("loanType", loanType);
		if(StringUtils.isNotEmpty((String)queryModel.getCondition().get("targetId"))){
			listS=acrmFcmCustmgrPerfMapper.selectloan(map);
		}else{
			listS=acrmFcmCustmgrPerfMapper.selectselectloanL(map);
		}
		String excelName = "存款详情列表";
		ExportExcelUtils2.export(excelName, listS, CrmFYyTriumphLoanDetailed.class, response);
		return null;
	}

	public List exportchargedetailed(HttpServletResponse response, QueryModel queryModel) throws Exception {

		UserInfoDTO user = getUserInfoDTO();
		Map<String, Object> map = new HashMap<>();
		List<CrmFYyTriumphCharge> listS=new ArrayList<>();
		map.put("_orgCode", user.getOrg().getCode());
		map.put("_userCode", user.getLoginCode());
		if(StringUtils.isNotEmpty((String)queryModel.getCondition().get("orgIdAuth"))){
			map.put("orgIdAuth", queryModel.getCondition().get("orgIdAuth"));
		}else{
			map.put("orgIdAuth", user.getOrg().getCode());
		}
		map.put("dataDate",getyearMoth(new Date()).substring(0,4));
		//产品类型(01：利率、汇率挂钩手续费收入 02：人民币基金手续费收入 03：ODII手续费收入 04：境内结构性产品手续费收入)'
		String chargeType=(String)queryModel.getCondition().get("chargeType");
		if(StringUtils.isEmpty(chargeType)){
			chargeType="01";
		}
		map.put("chargeType", chargeType);
		if(StringUtils.isNotEmpty((String)queryModel.getCondition().get("targetId"))){
			listS=acrmFcmCustmgrPerfMapper.selectCharge(map);
		}else{
			listS=acrmFcmCustmgrPerfMapper.selectChargeL(map);
		}
		String excelName = "手续费详情列表";
		ExportExcelUtils2.export(excelName, listS, CrmFYyTriumphCharge.class, response);
		return null;
	}

	public List<CrmFYyTriumphLookUp> Querymonthdetalist(QueryModel queryModel) throws Exception {
		Map<String,Object> map=getMapvalue(queryModel);
		List<CrmFYyTriumphLookUp> list= new ArrayList<>();
			map.put("endDate",getyearMoth(new Date()).substring(0,7));
			list = acrmFcmCustmgrPerfMapper.Querymonthdetalist(map);
		return list;
	}

	private Map<String, Object> getMapvalue(QueryModel queryModel) throws Exception {
		Map<String, Object> map = new HashMap<>();
		String role = getrole();
		UserInfoDTO user = getUserInfoDTO();
		//层级
		int triumphLevel = 0;
		String loginCode="";
		if(StringUtils.isNoneEmpty(user.getOrg().getCode())){
			loginCode=user.getOrg().getCode();
		}else{
			loginCode=user.getOrg().getId();
		}
		int triumphLine=getmgrType();
		if (headOffice.contains(role)) {
			map.put("triumphLevel", triumphLevel);
			map.put("triumphLine", 0);
            map.put("loginCode", "500");
		} else if (headOfficeB.contains(role)) {
			triumphLevel = 0;
			map.put("triumphLevel", triumphLevel);
			map.put("triumphLine",triumphLine);
            map.put("loginCode", "500");
		} else if (branch.contains(role)) {
			triumphLevel = 2;
			map.put("loginCode", loginCode.substring(0,2));
			map.put("triumphLevel", triumphLevel);
			map.put("triumphLine",triumphLine);
		} else if (subbranch.contains(role)) {
			triumphLevel = 3;
			map.put("loginCode", loginCode);
			map.put("triumphLevel", triumphLevel);
			map.put("triumphLine",triumphLine);
		} else if (patrolLeader.contains(role)) {
			triumphLevel = 4;
			//查询团队编号
			String mktTeamId = acrmFcmCustmgrPerfMapper.getmktTeamId(user.getLoginCode());
			map.put("loginCode", mktTeamId);
			map.put("triumphLevel", triumphLevel);
			map.put("triumphLine",triumphLine);
		} else if (customerManage.contains(role)) {
			triumphLevel = 5;
			map.put("loginCode", user.getLoginCode());
			map.put("triumphLevel", triumphLevel);
			map.put("triumphLine",triumphLine);
		}

	//	String newDate = acrmFcmCustmgrPerfMapper.selectMaxDateD(map);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM");
		String newDate=sdf.format(new Date());
		String startDate=(String)queryModel.getCondition().get("startDate");
		String endDate=(String)queryModel.getCondition().get("endDate");
		if (StringUtils.isNotEmpty(newDate) && StringUtils.isEmpty(startDate) && StringUtils.isEmpty(endDate)) {
			map.put("startDate", getdata(newDate).get("Start"));
			map.put("endDate",getdata(newDate).get("end"));
		} else
		if (StringUtils.isEmpty(startDate) && StringUtils.isNotEmpty(endDate)) {
			map.put("startDate", getdata(endDate).get("Start"));
			map.put("endDate",getdata(endDate).get("end"));
		} else if (StringUtils.isNotEmpty(startDate) && StringUtils.isEmpty(endDate)) {
			map.put("startDate", getdataa(startDate).get("Start"));
			map.put("endDate",getdataa(startDate).get("end"));
		}else if(StringUtils.isNotEmpty(startDate) && StringUtils.isNotEmpty(endDate)){
			map.put("startDate", startDate);
			map.put("endDate",endDate);
		}
		String targetId=(String)queryModel.getCondition().get("targetId");
		String triumphId=(String)queryModel.getCondition().get("triumphId");
		if(map.get("loginCode")!=null && StringUtils.isNotEmpty(targetId)){
			map.put("targetId", targetId);
		}else if(map.get("loginCode")==null && StringUtils.isNotEmpty(targetId)){
			map.put("targetId", targetId);
		}else if(map.get("loginCode")!=null && StringUtils.isEmpty(targetId)){
			map.put("targetId", map.get("loginCode"));
		}
		map.put("triumphId", triumphId);
		return map;
	}
}