package cn.com.yusys.yusp.uimp.base.service;

import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.base.repository.mapper.PmaSqlMapper;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Maps;
import gudusoft.gsqlparser.EDbVendor;
import gudusoft.gsqlparser.TGSqlParser;
import gudusoft.gsqlparser.nodes.TResultColumn;
import gudusoft.gsqlparser.nodes.TResultColumnList;
import gudusoft.gsqlparser.stmt.TSelectSqlStatement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PmaSqlService {
	
	@Autowired
	private PmaSqlMapper pmaSqlMapper;
	
	public ResultDto<Object> queryColumnList(String sqlStatement){
		ResultDto<Object> result = new ResultDto<Object>();
		TGSqlParser sqlparser = new TGSqlParser(EDbVendor.dbvoracle);
		sqlparser.sqltext = sqlStatement;
		int ret = sqlparser.parse();
		List<Map<String, String>> nodesList = new ArrayList<Map<String, String>>();
		if (ret == 0) {
			try {
				TSelectSqlStatement select = (TSelectSqlStatement) sqlparser.sqlstatements.get(0);
				TResultColumnList columnList = select.getResultColumnList();
				for (int i = 0; i < columnList.size(); i++) {
					TResultColumn col = columnList.getResultColumn(i);
					Map<String, String> columnNode = Maps.newHashMap();
					if (col.getAliasClause() != null) { // 别名列
						String column = col.getAliasClause().toString();
						if (column.indexOf(".") != -1) {
							column = column.substring(column.indexOf(".") + 1, column.length());
						}
						if(column.equals("*") || column.equals("1")) {
							result.setCode(-300);
							result.setMessage("请输入查询语句返回的具体参数名");
							return result;
						}
						columnNode.put("name", column);
						columnNode.put("ename", underlineToCamelhump(column));
						nodesList.add(columnNode);
					} else { // 正常列
						String column = col.getExpr().toString();
						if (column.indexOf(".") != -1) {
							column = column.substring(column.indexOf(".") + 1, column.length());
						}
						if(column.equals("*") || column.equals("1")) {
							result.setCode(-300);
							result.setMessage("请输入查询语句返回的具体参数名");
							return result;
						}
						columnNode.put("name", column);
						columnNode.put("ename", underlineToCamelhump(column));
						nodesList.add(columnNode);
					}
					result.setCode(0);
					result.setData(nodesList);
				}
			} catch (Exception e) {
				result.setCode(-400);
				result.setMessage("SQL不是查询语句");
			}
		} else {
			result.setCode(-500);
			result.setMessage("SQL语法有问题");
		}
		return result;
	}
	
	@Transactional(readOnly = true)
	public List<Map<String, Object>> queryList(QueryModel queryModel) throws Exception {
		PageHelper.startPage(queryModel.getPage(), queryModel.getSize());
		List<Map<String, Object>> list = pmaSqlMapper.queryList(queryModel);
		PageHelper.clearPage();
		return list;
	}
	
	/**
     * 将下划线风格替换为驼峰风格
     *
     * @param inputString
     * @return
     */
    private String underlineToCamelhump(String inputString) {
        StringBuilder sb = new StringBuilder();

        boolean nextUpperCase = false;
        for (int i = 0; i < inputString.length(); i++) {
            char c = inputString.charAt(i);
            if (c == '_') {
                if (sb.length() > 0) {
                    nextUpperCase = true;
                }
            } else {
                if (nextUpperCase) {
                    sb.append(Character.toUpperCase(c));
                    nextUpperCase = false;
                } else {
                    sb.append(Character.toLowerCase(c));
                }
            }
        }
        return sb.toString();
    }
}
