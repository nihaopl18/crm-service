package cn.com.yusys.yusp.uimp.base.service;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.base.domain.AdminBaseDbUser;
import cn.com.yusys.yusp.uimp.base.repository.mapper.AdminBaseDbUserMapper;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @项目名称: uimp-app-base-core模块
 * @类名称: AdminBaseDbUserService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2020-01-21 11:12:11
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Service
public class AdminBaseDbUserService extends CommonService {
	
	private Logger logger = LoggerFactory.getLogger(AdminBaseDbUserService.class);
	
	@Autowired
	private UserInfoService userInfoService;
	
    @Autowired
    private AdminBaseDbUserMapper adminBaseDbUserMapper;
    
    @Autowired
	private JdbcTemplate jdbcTemplate;
    
    private String[] grantArray = new String[] {"connect","resource","select_catalog_role","create any view","create synonym","unlimited tablespace","create any synonym","create public synonym","read,write on directory DIR_SYBASE"};

    @Override
    protected CommonMapper<?> getMapper() {
        return adminBaseDbUserMapper;
    }
    
    @Transactional(readOnly = true)
    public List<Map<String, Object>> querylist(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String, Object>> list = this.adminBaseDbUserMapper.querylist(model);
		PageHelper.clearPage();
		return list;
	}
    
    /**
	 * @方法名称: saveorupdate
	 * @方法描述: 新增或保存数据库用户信息
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
    @Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
    public ResultDto<Object> saveorupdate(AdminBaseDbUser adminBaseDbUser) throws Exception {
    	ResultDto<Object> resultDto = new ResultDto<>();
    	try {
    		String userCode = userInfoService.getUserInfo().getLoginCode();
			if (adminBaseDbUser.getId() != null) { //修改
				adminBaseDbUser.setLastUpdateDt(new Date());
				adminBaseDbUser.setLastUpdateUser(userCode);
				logger.info("修改用户...");
				String alterUserSQL = "alter user " + adminBaseDbUser.getName() + " identified by " + adminBaseDbUser.getPassword();
				this.jdbcTemplate.execute(alterUserSQL);
				logger.info("执行SQL===>{}",alterUserSQL);
				logger.info("修改用户完毕...");
				logger.info("用户授权...");
				for(String grant:grantArray) {
					String grantSQL = "grant " + grant + " to "+adminBaseDbUser.getName()+" ";
					logger.info("执行SQL===>{}",grantSQL);
					this.jdbcTemplate.execute(grantSQL);
				}
				logger.info("用户授权完毕...");
				this.adminBaseDbUserMapper.updateByPrimaryKeySelective(adminBaseDbUser);
				resultDto.setCode(0);
				resultDto.setMessage("保存数据库用户信息成功");
			} else { //新增
				logger.info("创建用户...");
				String createUserSQL = "create user "+adminBaseDbUser.getName()+" identified by "+adminBaseDbUser.getPassword()+
						" default tablespace TBS_DATA temporary tablespace TBS_TEMP profile DEFAULT";
				logger.info("执行SQL===>{}",createUserSQL);
				this.jdbcTemplate.execute(createUserSQL);
				logger.info("创建用户完毕...");
				logger.info("用户授权...");
				for(String grant:grantArray) {
					String grantSQL = "grant " + grant + " to "+adminBaseDbUser.getName()+" ";
					logger.info("执行SQL===>{}",grantSQL);
					this.jdbcTemplate.execute(grantSQL);
				}
				logger.info("用户授权完毕...");
				adminBaseDbUser.setCreateDt(new Date());
				adminBaseDbUser.setCreateUser(userCode);
				adminBaseDbUser.setTablespace("TBS_DATA");
				adminBaseDbUser.setTempTablespace("TBS_TEMP");
				adminBaseDbUser.setPassword(adminBaseDbUser.getPassword());
				this.adminBaseDbUserMapper.insertSelective(adminBaseDbUser);
				resultDto.setCode(0);
			    resultDto.setMessage("新增数据库用户信息成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
			resultDto.setCode(500);
		    resultDto.setMessage(e.getMessage());
		}
		return resultDto;
    }
    
    
    /**
	 * @方法名称: remove
	 * @方法描述: 删除数据库用户信息
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
    @Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
    public ResultDto<Object> remove(String id) throws Exception {
    	ResultDto<Object> resultDto = new ResultDto<>();
    	try {
    		AdminBaseDbUser adminBaseDbUser = this.selectByPrimaryKey(id);
    		logger.info("删除用户{}",adminBaseDbUser.getName());
			String deleteUserSQL = "drop user "+adminBaseDbUser.getName() + " cascade";
			logger.info("执行SQL===>{}",deleteUserSQL);
			this.jdbcTemplate.execute(deleteUserSQL);
			logger.info("删除用户{}完毕");
    		this.adminBaseDbUserMapper.deleteByPrimaryKey(id);
    		resultDto.setCode(0);
		    resultDto.setMessage("删除数据库用户信息成功");
		} catch (Exception e) {
			resultDto.setCode(500);
		    resultDto.setMessage(e.getMessage());
		}
		return resultDto;
    }

}
