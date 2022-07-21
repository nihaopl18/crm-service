package cn.com.yusys.yscrm.cust.group.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;
import cn.com.yusys.yucrm.custgroup.util.UtilTools;
import cn.com.yusys.yscrm.cust.group.domain.OcrmFciCgMember;
import cn.com.yusys.yscrm.cust.group.repository.mapper.OcrmFciCgMemberMapper;
/**
 * @项目名称: yscrm-entity-cust-group-core模块
 * @类名称: OcrmFciCgMemberService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-01-18 10:34:31
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class OcrmFciCgMemberService extends CommonService {
	@Autowired
	private OcrmFciCgMemberMapper ocrmFciCgMemberMapper;
	@Autowired
	private UaaClient uaaClient;
	private static final String GROUP_ID = "groupId";

	@Override
	protected CommonMapper<?> getMapper() {
		return ocrmFciCgMemberMapper;
	}

	public int delMemberByGroupId(String groupid) {
		return ocrmFciCgMemberMapper.delMemberByGroupId(groupid);
		// TODO 自动生成的方法存根

	}

	public int checkBe(OcrmFciCgMember c) {
		// TODO 自动生成的方法存根
		int num = ocrmFciCgMemberMapper.checkBe(c);
		return num;
	}

	public int joinGroup(OcrmFciCgMember c) {
		// TODO 自动生成的方法存根
		return insertSelective(getMapper(), c);
	}

	public void outGroup(OcrmFciCgMember c) {
		// TODO 自动生成的方法存根
		ocrmFciCgMemberMapper.outGroup(c);
	}

	public List<Map<Object, String>> getMemberList(QueryModel model) {
		// TODO 自动生成的方法存根
		Map<String, String> sqlMap = ocrmFciCgMemberMapper.getSqlByGroupId((String) model.getCondition().get("custGroupId"));
		List<Map<Object, String>> list;
		if (sqlMap == null || sqlMap.get("sql") == null || sqlMap.get("sql").equals("")) {
			PageHelper.startPage(model.getPage(), model.getSize());
			list = ocrmFciCgMemberMapper.getMemberList(model);
			PageHelper.clearPage();
		} else {
			HashMap<String, String> sqlMap1 = new HashMap<>();
			sqlMap1.put("custId", (String) model.getCondition().get("custId"));
			sqlMap1.put("custName", (String) model.getCondition().get("custName"));
			sqlMap1.put("sql", sqlMap.get("sql"));
			PageHelper.startPage(model.getPage(), model.getSize());
			list = ocrmFciCgMemberMapper.getMemberList1(sqlMap1);
			PageHelper.clearPage();
		}
		return list;
	}

	public List<Map<Object, String>> getNoMemberList(QueryModel model) {
		// TODO 自动生成的方法存根
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<Object, String>> list = ocrmFciCgMemberMapper.getNoMemberList(model);
		PageHelper.clearPage();
		return list;
	}

	public List<Map<String, String>> getMemberDeposit(QueryModel model) {
		// TODO 自动生成的方法存根
		String custGroupId = (String) model.getCondition().get(GROUP_ID);
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String, String>> list = ocrmFciCgMemberMapper.getMemberDeposit(custGroupId);
		PageHelper.clearPage();
		return list;
	}

	public List<Map<String, String>> getMemberLoan(QueryModel model) {
		// TODO 自动生成的方法存根
		String custGroupId = (String) model.getCondition().get(GROUP_ID);
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String, String>> list = ocrmFciCgMemberMapper.getMemberLoan(custGroupId);
		PageHelper.clearPage();
		return list;
	}

	public List<Map<String, String>> getMemberPro(QueryModel model) {
		// TODO 自动生成的方法存根
		String custGroupId = (String) model.getCondition().get(GROUP_ID);
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String, String>> list = ocrmFciCgMemberMapper.getMemberPro(custGroupId);
		PageHelper.clearPage();
		return list;
	}

	public List<Map<String, String>> getMemberContribution(QueryModel model) {
		// TODO 自动生成的方法存根
		String sql = (String) model.getCondition().get("sql");
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String, String>> list = ocrmFciCgMemberMapper.getMemberContribution(model);
		PageHelper.clearPage();
		return list;
	}

	public List<Map<String, String>> getMemberContribution1(QueryModel model) {
		// TODO 自动生成的方法存根
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String, String>> list = ocrmFciCgMemberMapper.getMemberContribution1(model);
		PageHelper.clearPage();
		return list;
	}

	public List<Map<String, String>> getFitProduct(QueryModel model) {
		// TODO 自动生成的方法存根
		String custGroupId = (String) model.getCondition().get(GROUP_ID);
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String, String>> list = ocrmFciCgMemberMapper.getFitProduct(custGroupId);
		PageHelper.clearPage();
		return list;
	}

	public List<Map<String, String>> getAutoMemberList(QueryModel model) {
		// TODO 自动生成的方法存根
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String, String>> list = ocrmFciCgMemberMapper.getAutoMemberList(model);
		PageHelper.clearPage();
		return list;
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
//            	workbook = new HSSFWorkbook(file.getInputStream());
				workbook = new XSSFWorkbook(inpu);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return workbook;
	}

	public UserInfoDTO getUser() {
		ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		return dto.getBody();
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

	@Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
	public Map<String, Object> dataImportPer(String custGroupId, MultipartFile file) throws Exception {
		Map<String, Object> reMap = new HashMap<>();
/*// TODO 自动生成的方法存根
		int count = 0;
		int repeatNum = 0;
		int successNum = 0;
		Map<String, Object> reMap = new HashMap<>();
		UserInfoDTO user = getUser();
    	String updateUser = user.getUserId();
    	String createUser=user.getUserId();
    	Date createDate=new Date();
    	Date updateDate=createDate;
		try{
	        //获得Workbook工作薄对象
	        Workbook workbook = getWorkBook(file);
	        //创建返回对象，把每行中的值作为一个数组，所有行作为一个集合返回
	        if(workbook != null){
	            for(int sheetNum = 1;sheetNum < workbook.getNumberOfSheets();sheetNum++){
	                //获得当前sheet工作表
	                Sheet sheet = workbook.getSheetAt(sheetNum);
	                String sheetname=workbook.getSheetName(sheetNum);
	                if(sheet == null){
	                    continue;
	                }
	                //获得当前sheet的开始行
	                int firstRowNum  = sheet.getFirstRowNum();
	                String headStr = "";
	                Row headrow = sheet.getRow(firstRowNum);
	               //获得表头行的开始列
	                int headfirstCellNum = headrow.getFirstCellNum();
	                //获得表头行的列数
	                int headlastCellNum = headrow.getPhysicalNumberOfCells();
	                String[] headcells = new String[headrow.getPhysicalNumberOfCells()];
	                for(int k = headfirstCellNum; k < headlastCellNum;k++){
	                    Cell cell = headrow.getCell(k);
	                    headcells[k]=cell.toString();
	                }
	                for (int x = 0; x < headcells.length; x++) {
	                	headStr+= ","+headcells[x].toString();
	                }
	                headStr=headStr.substring(1);
	                boolean topName = headStr.equals("序号,客户编号,客户姓名");
	                if(!topName) {
	                	reMap.put("message", "表格格式不对，请下载模板填写");
	                	return reMap;
	                }
                	int lastRowNum = sheet.getLastRowNum();
                    //循环除了第一行的所有行
                    for(int rowNum = firstRowNum+1;rowNum <= lastRowNum;rowNum++){
	                    	count ++;
	                        Row row = sheet.getRow(rowNum);
	                        if(row == null){
	                            continue;
	                        }
	                        //获得当前行的开始列
	                        int firstCellNum = row.getFirstCellNum();
	                        //获得当前行的列数
	                        String[] cells = new String[row.getPhysicalNumberOfCells()];
	                        //循环当前行
	                        String custId = "";
	                        String custName = "";
	                        for(int cellNum = firstCellNum; cellNum < headlastCellNum;cellNum++){
	                        	Cell cell = null;
	                        	try {
	                        		cell = row.getCell(cellNum);
	                        		cells[cellNum] = getCellValue(cell);
								} catch (Exception e) {
									// TODO: handle exception
									switch (cellNum) {
		    						case 1:custId = getCellValue(cell);//获取表格中客户名称
		    							break;
		    						case 2:custName = getCellValue(cell);//获取表格中客户名称
	    							break;
		    						default:
		    							break;
		    						}
									continue;
								}
	                        	switch (cellNum) {
	    						case 1:custId = getCellValue(cell);//获取表格中客户名称
	    							break;
	    						case 2:custName = getCellValue(cell);//获取表格中客户名称
								break;
	    						default:
	    							break;
	    						}
		    				};
							OcrmFciCgMember c = new OcrmFciCgMember();
				  			c.setCustGroupId(custGroupId);
				  			c.setCustId(custId);
				  			c.setId(UUID.randomUUID().toString().replaceAll("-", ""));
			  				UtilTools.addUtl(c);
				  			c.setCorpOrgCode("001");
				  			c.setCreateDate(createDate);
				  			c.setCreateUser(createUser);
				  			c.setUpdateDate(updateDate);
				  			c.setUpdateUser(updateUser);
	                        if(checkBe(c) == 0) {
	                        	successNum+=joinGroup(c);
	                        }else {
								repeatNum ++;
							}
	                    }
					}
	            }
	        }catch(Exception e) {
				e.printStackTrace();
				throw new Exception("1");
			}
			reMap.put("message", "succese");
			reMap.put("count", count);
			reMap.put("repeatNum", repeatNum);
			reMap.put("successNum", successNum);
			return reMap;
	}*/
		return reMap;
	}
}