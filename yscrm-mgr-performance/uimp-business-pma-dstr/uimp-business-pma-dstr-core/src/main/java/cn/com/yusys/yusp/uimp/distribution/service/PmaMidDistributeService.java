package cn.com.yusys.yusp.uimp.distribution.service;


import cn.com.yusys.yusp.uimp.base.service.UserInfoService;
import cn.com.yusys.yusp.uimp.distribution.model.PmaMidDistribute;
import cn.com.yusys.yusp.uimp.distribution.model.PmaMidInfo;
import cn.com.yusys.yusp.uimp.distribution.repository.mapper.PmaMidDistributeMapper;
import cn.com.yusys.yusp.uimp.distribution.repository.mapper.PmaMidInfoMapper;
import com.ecc.echain.util.UNIDProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class PmaMidDistributeService {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    PmaMidDistributeMapper pmaMidDistributeMapper;

    @Autowired
    PmaMidInfoMapper pmaMidInfoMapper;

    int deleteByPrimaryKey(String id){
        return pmaMidDistributeMapper.deleteByPrimaryKey(id);
    }

    int insert(PmaMidDistribute record){
        return pmaMidDistributeMapper.insert(record);
    }

    int insertSelective(PmaMidDistribute record){
        return pmaMidDistributeMapper.insertSelective(record);
    }

    PmaMidDistribute selectByPrimaryKey(String id){
        return pmaMidDistributeMapper.selectByPrimaryKey(id);
    }

    int updateByPrimaryKeySelective(PmaMidDistribute record){
        return pmaMidDistributeMapper.updateByPrimaryKeySelective(record);
    }

    int updateByPrimaryKey(PmaMidDistribute record){
        return pmaMidDistributeMapper.updateByPrimaryKey(record);
    }

    public List<PmaMidDistribute> selectList(PmaMidDistribute record){
        return pmaMidDistributeMapper.selectList(record);
    }

    @Transactional
    public void saveList(PmaMidInfo pmaMidInfo) {
        PmaMidDistribute select = new PmaMidDistribute();
        select.setMidInfoId(pmaMidInfo.getId());
        List<PmaMidDistribute> oldList = selectList(select);
        for(PmaMidDistribute pmaMidDistribute:oldList){
            deleteByPrimaryKey(pmaMidDistribute.getId());
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String curTime = sdf.format(new Date());
        String loginCode = userInfoService.getUserInfo().getLoginCode();
        String orgCode = userInfoService.getUserInfo().getOrg().getId();
        for(PmaMidDistribute pmaMidDistribute: pmaMidInfo.getPmaMidDistributeList()){
            UNIDProducer childUuid = new UNIDProducer();
            String childUuidStr= childUuid.getUNID();
            pmaMidDistribute.setId(childUuidStr);
            pmaMidDistribute.setCreator(loginCode);
            pmaMidDistribute.setCreateDate(curTime);
            pmaMidDistribute.setCreateOrg(orgCode);
            pmaMidDistributeMapper.insertSelective(pmaMidDistribute);
        }
        pmaMidInfo.setDstrSts("4");
        pmaMidInfoMapper.updateByPrimaryKeySelective(pmaMidInfo);
    }
}