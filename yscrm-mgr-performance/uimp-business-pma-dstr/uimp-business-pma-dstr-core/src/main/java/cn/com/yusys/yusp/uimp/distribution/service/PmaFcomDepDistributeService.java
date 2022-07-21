package cn.com.yusys.yusp.uimp.distribution.service;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.distribution.domain.PmaFcomDepDistributeInfo;
import cn.com.yusys.yusp.uimp.distribution.repository.mapper.PmaFcomDepDistributeMapper;
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
 * @create:2022-05-10
 */
@Service
public class PmaFcomDepDistributeService extends CommonService {

    protected final Log logger = LogFactory.getLog(PmaFcomDepDistributeService.class);

    @Autowired
    private PmaFcomDepDistributeMapper pmaFcomDepDistributeMapper;

    @Transactional(readOnly = true)
    public List<Map<String, Object>> queryList(QueryModel model) {
        PageHelper.startPage(model.getPage(), model.getSize());

        List<Map<String, Object>> list = pmaFcomDepDistributeMapper.queryList(model);

        logger.info("查询存款业绩分配区间集合[{model}]成功:"+model.toString());
        PageHelper.clearPage();
        return list;
    }

    @Override
    protected CommonMapper getMapper() {
        return pmaFcomDepDistributeMapper;
    }

    @Transactional(readOnly = true)
    public ResultDto<PmaFcomDepDistributeInfo> savePmaDistribute(PmaFcomDepDistributeInfo distributeInfo) {
        ResultDto<PmaFcomDepDistributeInfo> result = new ResultDto<>();
        pmaFcomDepDistributeMapper.insertSelective(distributeInfo);
        result.setMessage("新增存款业绩分配比例成功");
        result.setData(distributeInfo);
        result.setCode(0);
        return result;
    }

    @Transactional(readOnly = true)
    public void delDistributeById(String distributeId) {
        pmaFcomDepDistributeMapper.delDistribute(distributeId);
    }
}
