package cn.com.yusys.yusp.uimp.distribution.service;


import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.uimp.base.service.UserInfoService;
import cn.com.yusys.yusp.uimp.distribution.model.PmaMidDistribute;
import cn.com.yusys.yusp.uimp.distribution.model.PmaMidInfo;
import cn.com.yusys.yusp.uimp.distribution.repository.mapper.PmaMidDistributeMapper;
import cn.com.yusys.yusp.uimp.distribution.repository.mapper.PmaMidInfoMapper;
import com.ecc.echain.util.UNIDProducer;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class PmaMidInfoService {

    @Autowired
    PmaMidInfoMapper pmaMidInfoMapper;

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    PmaMidDistributeMapper pmaMidDistributeMapper;



    public int deleteByPrimaryKey(String id){
        return pmaMidInfoMapper.deleteByPrimaryKey(id);
    }

    public int insert(PmaMidInfo record){
        return pmaMidInfoMapper.insert(record);
    }

    public int insertSelective(PmaMidInfo record){
        return pmaMidInfoMapper.insertSelective(record);
    }

    public PmaMidInfo selectByPrimaryKey(String id){
        return pmaMidInfoMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(PmaMidInfo record){
        return pmaMidInfoMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(PmaMidInfo record){
        return pmaMidInfoMapper.updateByPrimaryKey(record);
    }

    public List<PmaMidInfo> selectList(QueryModel queryModel){
        PageHelper.startPage(queryModel.getPage(),queryModel.getSize());
        queryModel.getCondition().put("orgCode", userInfoService.getUserInfo().getOrg().getCode());
        List<PmaMidInfo> list = pmaMidInfoMapper.selectList(queryModel);
        PageHelper.clearPage();
        return list;
    }

    public Long selectCount(QueryModel queryModel){
        queryModel.getCondition().put("orgCode", userInfoService.getUserInfo().getOrg().getCode());
        return pmaMidInfoMapper.selectCount(queryModel);
    }

    public List<Map<String, Object>> queryMidHis(QueryModel model) {
        PageHelper.startPage(model.getPage(), model.getSize());

        List<Map<String, Object>> list = pmaMidInfoMapper.queryMidHis(model);

        PageHelper.clearPage();
        return list;
    }


    public Long oneToManyQueryCount(QueryModel queryModel) {
        return pmaMidInfoMapper.oneToManyQueryCount(queryModel);
    }

    public List<Map<String, Object>> oneToManyQueryList(QueryModel queryModel) {
        PageHelper.startPage(queryModel.getPage(),queryModel.getSize());
        List<Map<String, Object>> list = pmaMidInfoMapper.oneToManyQueryList(queryModel);
        PageHelper.clearPage();
        return list;
    }

    @Transactional(rollbackFor = Exception.class)
    public void savePressList(List<UploadNode> pressList) {
        for(UploadNode node : pressList){
            String ID = node.value.get("ID");
            if(StringUtils.isBlank(ID)){
                continue;
            }
            PmaMidDistribute selectPmaMidDistribute = new PmaMidDistribute();
            selectPmaMidDistribute.setMidInfoId(ID);
            List<PmaMidDistribute> pmaMidDistributeList = pmaMidDistributeMapper.selectList(selectPmaMidDistribute);
            for(PmaMidDistribute pmaMidDistribute : pmaMidDistributeList){
                pmaMidDistributeMapper.deleteByPrimaryKey(pmaMidDistribute.getId());
            }
            for(UploadNode childNode: node.children){
                UNIDProducer childUuid = new UNIDProducer();
                String childUuidStr= childUuid.getUNID();
                PmaMidDistribute midDistributeInfo = new PmaMidDistribute();
                midDistributeInfo.setId(childUuidStr);
                midDistributeInfo.setMidInfoId(ID);
                midDistributeInfo.setAllotType("2");
                midDistributeInfo.setManagerId(childNode.value.get("客户经理编号"));
                midDistributeInfo.setManagerName(childNode.value.get("客户经理名称"));
                midDistributeInfo.setDistrRate(childNode.value.get("业绩分配比例(%)"));
                pmaMidDistributeMapper.insertSelective(midDistributeInfo);
            }
            PmaMidInfo update = new PmaMidInfo();
            update.setId(ID);
            update.setDstrSts("2");
            pmaMidInfoMapper.updateByPrimaryKeySelective(update);
        }

    }

    public List<Map<String, Object>> selectItem(String lookupCode){
        return pmaMidInfoMapper.selectItem(lookupCode);
    }

    public Map<String, Object> selectManager(String loginCode){
        return pmaMidInfoMapper.selectManager(loginCode);
    }
    /**
     * 根据登录代码查询用户信息
     *
     * @param loginCode 登录代码
     * @return 用户信息
     * @author weixy6
     * @date 2022/6/14
     */
    public Map<String, Object> selectUser(String loginCode) {
        return pmaMidInfoMapper.selectUser(loginCode);
    }
}