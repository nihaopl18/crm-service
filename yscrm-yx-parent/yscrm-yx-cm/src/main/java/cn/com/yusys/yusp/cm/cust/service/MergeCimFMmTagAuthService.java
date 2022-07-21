package cn.com.yusys.yusp.cm.cust.service;

import cn.com.yusys.yusp.cm.cust.domain.CimFMmTagAuthInfo;
import cn.com.yusys.yusp.cm.cust.repository.mapper.MergeCimFMmTagAuthMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.security.SecurityUtils;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;


/**
 * @version 1.0.0
 * @项目名称: yusp-app-cim
 * @类名称: CimFMmTagAuthService
 * @类描述:
 * @功能描述: 标签授权管理
 * @创建人: yangxiao2@yusys.com.cn
 * @创建时间: 2018年10月26日
 * @修改备注:
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class MergeCimFMmTagAuthService extends CommonService {
    @Autowired
    private MergeCimFMmTagAuthMapper mapper;


    @Override
    protected CommonMapper<?> getMapper() {
        // TODO Auto-generated method stub
        return this.mapper;
    }

    /*
     * 查询授权列表
     */
    @Transactional(readOnly = true)
    public List<CimFMmTagAuthInfo> getList(QueryModel model) {
        PageHelper.startPage(model.getPage(), model.getSize());
        List<CimFMmTagAuthInfo> list = mapper.getList(model);
        PageHelper.clearPage();
        return list;
    }

    /*
     * 更新授权信息
     */
    public int updateAuthList(CimFMmTagAuthInfo au) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        // 设置授权对象ID
        au.setAuthObj(mapper.getUpdateAuthName(au).get("obj").toString());
        // 设置授权对象名称
        au.setAuthName(mapper.getUpdateAuthName(au).get("name").toString());
        // 设置授权人
        au.setAuthUser(SecurityUtils.getCurrentUserLogin());
        // 设置最近更新日期
        au.setAuthDate(new java.sql.Date(System.currentTimeMillis()));
        // 设置授权生效日期、失效日期格式
        au.setAvailableDate(new Date(df.parse(df.format(au.getAvailableDate())).getTime()));
        au.setDisableDate(new Date(df.parse(df.format(au.getDisableDate())).getTime()));
        int num = Integer.parseInt(mapper.getSameAuth(au).get("num").toString());
        if (num == 0 || num == 1) {
            return mapper.updateAuthList(au);
        } else {
            return 1;
        }
    }

    /*
     * 删除标签内容
     */
    public ResultDto<Integer> deleteAuthList(@RequestBody CimFMmTagAuthInfo au) {
        ResultDto<Integer> resultDto = new ResultDto<Integer>();
        if (au.getIds().length == 0) {
            resultDto.setCode(-2);
            resultDto.setMessage("删除失败");
            return resultDto;
        } else {
            long[] array = au.getIds();
            for (int i = 0; i < array.length; i++) {
                au.setId(array[i]);
                mapper.deleteAuthList(au);
            }
            resultDto.setCode(0);
            resultDto.setMessage("删除成功");
            return resultDto;
        }
    }

    /*
     * 新增标签
     */
    public ResultDto<Integer> insertAuthList(CimFMmTagAuthInfo au) throws ParseException {
        String[] authNames = au.getAuthNames().split(",");
        // 设置日期格式
        int num1 = 0;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < authNames.length; i++) {
            // 设置授权对象名称
            au.setAuthName(authNames[i]);
            // 设置授权对象ID
            au.setAuthObj(mapper.getAuthObj(au).get("obj").toString());
            // 设置授权对象名称
            au.setAuthName(mapper.getAuthObj(au).get("name").toString());
            // 设置授权人
            au.setAuthUser(SecurityUtils.getCurrentUserLogin());
            // 设置最近更新日期
            au.setAuthDate(new java.sql.Date(System.currentTimeMillis()));
            // 设置授权对象编号
            au.setId(Long.parseLong(mapper.getSeq()));
            // 设置授权生效日期、失效日期格式
            au.setAvailableDate(new Date(df.parse(df.format(au.getAvailableDate())).getTime()));
            au.setDisableDate(new Date(df.parse(df.format(au.getDisableDate())).getTime()));
            // 判断数据重复性
            int num = Integer.parseInt(mapper.getSameAuth(au).get("num").toString());
            if (num == 0) {
                num1 = this.insertSelective(getMapper(), au);

            }
        }
        ResultDto<Integer> resultDto = new ResultDto<Integer>(num1);
        if (num1 != 0) {
            resultDto.setCode(0);
            resultDto.setMessage("新增成功");
        } else {
            resultDto.setCode(-1);
            resultDto.setMessage("新增失败");
        }
        return resultDto;
    }

    /*
     * 查询角色表
     */
    public List<Map<String, Object>> getRoleList() {
        return mapper.getUserList();
    }

    /*
     * 查询人员表
     */
    public List<Map<String, Object>> getUserList() {
        return mapper.getUserList();
    }

    /*
     * 查询组织机构表
     */
    public List<Map<String, Object>> getOrgList() {
        return mapper.getOrgList();
    }

    /*
     * 查询金融机构表
     */
    public List<Map<String, Object>> getInstuList() {
        return mapper.getInstuList();
    }

    /*
     * 删除标签的授权信息
     */
    public int delTagNo(String tagNo) {
        return mapper.delTagNo(tagNo);
    }
}
