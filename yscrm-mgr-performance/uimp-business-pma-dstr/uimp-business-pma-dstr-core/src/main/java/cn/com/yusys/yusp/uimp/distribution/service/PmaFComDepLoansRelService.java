package cn.com.yusys.yusp.uimp.distribution.service;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.uimp.distribution.repository.mapper.PmaFComDepLoansPeriodMapper;
import cn.com.yusys.yusp.uimp.distribution.repository.mapper.PmaFComDepLoansRelMapper;
import com.github.pagehelper.PageHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author:Mr.raop
 * @create:2022-05-16
 */
@Service
public class PmaFComDepLoansRelService extends CommonService {

    protected final Log logger = LogFactory.getLog(PmaFComDepPeriodService.class);

    @Autowired
    private PmaFComDepLoansRelMapper relMapper;

    @Transactional(readOnly = true)
    public List<Map<String, Object>> queryList(QueryModel model) {
        PageHelper.startPage(model.getPage(), model.getSize());

        List<Map<String, Object>> list = relMapper.queryList(model);

        logger.info("查询贷款业绩分配集合[{model}]成功:"+model.toString());
        PageHelper.clearPage();
        return list;
    }

    @Override
    protected CommonMapper getMapper() {
        return relMapper;
    }

    @Transactional(readOnly = true)
    public void delDistributeById(String distributeId) {
        relMapper.delDistribute(distributeId);
    }


}
