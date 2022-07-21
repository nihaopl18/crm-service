package cn.com.yusys.yscrm.salesoppor.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class JdbcUtils {
	@Autowired
	Environment env;

	public List<Map<String, Object>> selectMsg(String sql, List valueList, List<String> fieldList) {
		String url = env.getProperty("spring.datasource.url");
		String user = env.getProperty("spring.datasource.username");
		String pwd = env.getProperty("spring.datasource.password");
		List<Map<String, Object>> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, pwd);
			ps = conn.prepareStatement(sql);
			for (int i = 1; i <= valueList.size(); i++) {
				ps.setObject(i, valueList.get(i - 1));
			}
			result = ps.executeQuery();
			while (result.next()) {
				Map<String, Object> map = new HashMap<>();
				for (int i = 0; i < fieldList.size(); i++) {
					map.put(fieldList.get(i), result.getObject(i + 1));
				}
				list.add(map);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (result != null) {
				try {
					result.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}

	public int createHis(String sql, List<Map<String, String>> list, String fileName,String msgType,String typeId) {
		String url = env.getProperty("spring.datasource.url");
		String user = env.getProperty("spring.datasource.username");
		String pwd = env.getProperty("spring.datasource.password");
		Connection conn = null;
		PreparedStatement ps = null;
		int count = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, pwd);
			ps = conn.prepareStatement(sql);
			for (Map<String, String> map : list) {
				conn.setAutoCommit(false);
				ps.setString(1, map.get("messageReceId"));
				ps.setString(2, map.get("messageInfo"));
				ps.setString(3, map.get("sendTime"));
				ps.setString(4, map.get("messageSendId"));
				ps.setString(5, map.get("messageReceNum"));
				ps.setString(6, fileName);
				ps.setString(7, msgType);
				ps.setString(8, typeId);
				count++;
				ps.addBatch();
				if (count % 1000 == 0) {
					ps.executeBatch();
				}
			}
			if (ps != null) {
				ps.executeBatch();
			}
			if (conn != null && count > 0) {
				conn.commit();
			}
		} catch (Exception e) {
			if (conn != null && count > 0) {
				try {
					conn.rollback();
					count = 0;
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		}
		return count;
	}

	public int updateMsg(String sql, Map<String, Object> map) {
		int num = 0;
		String url = env.getProperty("spring.datasource.url");
		String user = env.getProperty("spring.datasource.username");
		String pwd = env.getProperty("spring.datasource.password");
		Connection conn = null;
		PreparedStatement ps = null;
		int count = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, pwd);
			ps = conn.prepareStatement(sql);
			ps.setObject(1, map.get("sendTime"));
			num = ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return num;
	}

}
