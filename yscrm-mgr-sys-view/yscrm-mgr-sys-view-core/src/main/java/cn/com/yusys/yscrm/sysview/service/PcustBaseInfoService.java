package cn.com.yusys.yscrm.sysview.service;

import cn.com.yusys.yscrm.custpub.domain.AcrmCustCount;
import cn.com.yusys.yscrm.sysview.domain.CiUserAssetsDTO;
import cn.com.yusys.yscrm.sysview.domain.CrmFCiUserAssets;
import cn.com.yusys.yscrm.sysview.domain.CrmFCiUserAssetsVO;
import cn.com.yusys.yscrm.sysview.domain.CrmFCiUserInformation;
import cn.com.yusys.yscrm.sysview.repository.mapper.PcustBaseInfoMapper;
import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;
import cn.com.yusys.yusp.util.UtilTools;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author: sxm
 * @time: 2021/8/12 15:33
 */
@Service
public class PcustBaseInfoService {

    @Autowired
    private PcustBaseInfoMapper pcustBaseInfoMapper;
    private static final String CUSTID =  "custId";
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Autowired
    private UaaClient uaaClient;
    @Transactional(readOnly = true)
    public Map<String, Object> getBaseInfo(QueryModel model) {
        Map<String, Object> map = new HashMap<>();
        ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
        UserInfoDTO user = dto.getBody();
        AcrmCustCount acrmCustCount=new AcrmCustCount();
        acrmCustCount.setId(UtilTools.getUUID());
        acrmCustCount.setCustId(String.valueOf(model.getCondition().get(CUSTID)));
        Date date = new Date();
        String dateTime = sdf.format(date);
        acrmCustCount.setDataDate(dateTime);
        acrmCustCount.setOrgId(user.getOrg().getCode());
        acrmCustCount.setSamId(user.getLoginCode());
        acrmCustCount.setCustName(pcustBaseInfoMapper.getcustIdName(String.valueOf(model.getCondition().get(CUSTID))));
        pcustBaseInfoMapper.insertCount(acrmCustCount);
        map.put("baseInfo", pcustBaseInfoMapper.getBaseInfo(model));
        map.put("certInfo", pcustBaseInfoMapper.getCertInfo(model));
        map.put("eduInfo", pcustBaseInfoMapper.getEduInfo(model));
        map.put("occInfo", pcustBaseInfoMapper.getOccInfo(model));
        map.put("houseInfo", pcustBaseInfoMapper.getHouseInfo(model));
        map.put("belongInfo", pcustBaseInfoMapper.getBelongInfo(model));
        map.put("famInfo", pcustBaseInfoMapper.getFamInfo(model));
        return map;
    }

    public int checkUpNameId(String seqno) {
        Map<String,Object> map=new HashMap<>();
        map.put("seqno",seqno);
        return pcustBaseInfoMapper.checkUpNameId(map);
    }

    public int insertCust(CrmFCiUserInformation crmFCiUserInformation) throws ParseException {
        ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
        UserInfoDTO user = dto.getBody();
        //房产信息
        List<CiUserAssetsDTO>list= crmFCiUserInformation.getList();
        Map<String,Object> map=new HashMap<>();
        Date date=sdf.parse(sdf.format(new Date()));
        map.put("seqno",crmFCiUserInformation.getSeqno());
        if("01".equals(crmFCiUserInformation.getStatus()) || "02".equals(crmFCiUserInformation.getStatus()) ){
            crmFCiUserInformation.setStatus(null);
        }
        if(list.size()>0){
            pcustBaseInfoMapper.checkdelete(map);
        for(CiUserAssetsDTO ciUserAssetsDTO:list){
            //资产信息
            CrmFCiUserAssets crmFCiUserAssets=new CrmFCiUserAssets();
            crmFCiUserAssets.setSeqno(crmFCiUserInformation.getSeqno());
            crmFCiUserAssets.setCarFlg(crmFCiUserInformation.getCarFlg());
            crmFCiUserAssets.setCreateUser(user.getUserName());
            crmFCiUserAssets.setIncomeSrc(crmFCiUserInformation.getIncomeSrc());
            crmFCiUserAssets.setCustId(crmFCiUserInformation.getCustId());
            crmFCiUserAssets.setHouseInfo(ciUserAssetsDTO.getHouseInfo());
            crmFCiUserAssets.setPurDt(ciUserAssetsDTO.getPurDt());
            crmFCiUserAssets.setPurPrc(ciUserAssetsDTO.getPurPrc());
            crmFCiUserAssets.setStatus(crmFCiUserInformation.getStatus());
                crmFCiUserAssets.setIsFlag("01");
                crmFCiUserAssets.setCreateDate(date);
                pcustBaseInfoMapper.insertassets(crmFCiUserAssets);
        }
        }
        //基础信息
        CrmFCiUserInformation userInformation=new CrmFCiUserInformation();
        userInformation.setSeqno(crmFCiUserInformation.getSeqno());
        userInformation.setWechat(crmFCiUserInformation.getWechat());
        userInformation.setComSch(crmFCiUserInformation.getComSch());
        userInformation.setCreateDate(date);
        userInformation.setCreateUser(user.getUserName());
        userInformation.setCustId(crmFCiUserInformation.getCustId());
        userInformation.setEndDate(crmFCiUserInformation.getEndDate());
        userInformation.setPhysicalState(crmFCiUserInformation.getPhysicalState());
        userInformation.setPoliticalOutlook(crmFCiUserInformation.getPoliticalOutlook());
        userInformation.setSchMajor(crmFCiUserInformation.getSchMajor());
        userInformation.setSeqno(crmFCiUserInformation.getSeqno());
        userInformation.setStatus(crmFCiUserInformation.getStatus());
        pcustBaseInfoMapper.insertinformation(userInformation);
        return 0;
    }

    public int updateCust(CrmFCiUserInformation crmFCiUserInformation) throws Exception {
        ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
        UserInfoDTO user = dto.getBody();
        Map<String,Object> map=new HashMap<>();
        map.put("seqno",crmFCiUserInformation.getSeqno());
        if("01".equals(crmFCiUserInformation.getStatus()) || "02".equals(crmFCiUserInformation.getStatus()) ){
            crmFCiUserInformation.setStatus(null);
        }
        CrmFCiUserInformation userInformation=new CrmFCiUserInformation();
        userInformation.setWechat(crmFCiUserInformation.getWechat());
        userInformation.setComSch(crmFCiUserInformation.getComSch());
        userInformation.setCustId(crmFCiUserInformation.getCustId());
        userInformation.setStatus(crmFCiUserInformation.getStatus());
        userInformation.setPhysicalState(crmFCiUserInformation.getPhysicalState());
        userInformation.setPoliticalOutlook(crmFCiUserInformation.getPoliticalOutlook());
        userInformation.setSchMajor(crmFCiUserInformation.getSchMajor());
        userInformation.setSeqno(crmFCiUserInformation.getSeqno());
        pcustBaseInfoMapper.updateformation(userInformation);
        Date date=sdf.parse(sdf.format(new Date()));
        //房产信息
        List<CiUserAssetsDTO>list= crmFCiUserInformation.getList();
        if(list.size()>0){
            pcustBaseInfoMapper.checkdelete(map);
            for(CiUserAssetsDTO ciUserAssetsDTO:list){
                //资产信息
                CrmFCiUserAssets crmFCiUserAssets=new CrmFCiUserAssets();
                crmFCiUserAssets.setSeqno(crmFCiUserInformation.getSeqno());
                crmFCiUserAssets.setCarFlg(crmFCiUserInformation.getCarFlg());
                crmFCiUserAssets.setIncomeSrc(crmFCiUserInformation.getIncomeSrc());
                crmFCiUserAssets.setCustId(crmFCiUserInformation.getCustId());
                crmFCiUserAssets.setHouseInfo(ciUserAssetsDTO.getHouseInfo());
                crmFCiUserAssets.setPurDt(ciUserAssetsDTO.getPurDt());
                crmFCiUserAssets.setPurPrc(ciUserAssetsDTO.getPurPrc());
               crmFCiUserAssets.setStatus(crmFCiUserInformation.getStatus());
                crmFCiUserAssets.setCreateUser(user.getUserName());
                    crmFCiUserAssets.setIsFlag("01");
                    crmFCiUserAssets.setCreateDate(date);
                    pcustBaseInfoMapper.insertassets(crmFCiUserAssets);

            }
        }

        return 0;
    }

    public int deleteCust(CiUserAssetsDTO ciUserAssetsDTO) {
        CrmFCiUserAssets crmFCiUserAssets=new CrmFCiUserAssets();
        crmFCiUserAssets.setHouseInfo(ciUserAssetsDTO.getHouseInfo());
        crmFCiUserAssets.setPurDt(ciUserAssetsDTO.getPurDt());
        crmFCiUserAssets.setPurPrc(ciUserAssetsDTO.getPurPrc());
        crmFCiUserAssets.setCustId(ciUserAssetsDTO.getCustId());
        crmFCiUserAssets.setIsFlag("02");
        crmFCiUserAssets.setSeqno(ciUserAssetsDTO.getSeqno());
        pcustBaseInfoMapper.updateassets(crmFCiUserAssets);
        return 0;
    }

    public CrmFCiUserAssetsVO queryCustlist(QueryModel queryModel) {
        String custId=String.valueOf(queryModel.getCondition().get(CUSTID));
        String seqno=String.valueOf(queryModel.getCondition().get("seqno"));
        String type=String.valueOf(queryModel.getCondition().get("type"));
        Map<String,Object> map=new HashMap<>();
        map.put("custId",custId);
        map.put("seqno",seqno);
        map.put("type",type);
        CrmFCiUserAssetsVO crmFCiUserAssetsVO=new CrmFCiUserAssetsVO();
         List<CiUserAssetsDTO> ciUserAssetsDTOlist=new ArrayList<>();
        //基本信息
        CrmFCiUserInformation crmFCiUserInformation=pcustBaseInfoMapper.selectuserInfo(map);
        //资产信息
        List<CrmFCiUserAssets> crmFCiUserAssetslist=pcustBaseInfoMapper.selectassets(map);
        if(crmFCiUserInformation!=null){
            crmFCiUserAssetsVO.setCrmFCiUserInformation(crmFCiUserInformation);
            crmFCiUserAssetsVO.setSeqno(crmFCiUserInformation.getSeqno());
            crmFCiUserAssetsVO.setInstanceid(crmFCiUserInformation.getInstanceid());
            crmFCiUserAssetsVO.setStatus(crmFCiUserInformation.getStatus());
        }
        if(crmFCiUserAssetslist.size()>0){
            for(CrmFCiUserAssets crmFCiUserAssets:crmFCiUserAssetslist){
                crmFCiUserAssetsVO.setCarFlg(crmFCiUserAssets.getCarFlg());
                crmFCiUserAssetsVO.setCustId(crmFCiUserAssets.getCustId());
                crmFCiUserAssetsVO.setHouseCount(crmFCiUserAssetslist.size());
                crmFCiUserAssetsVO.setIncomeSrc(crmFCiUserAssets.getIncomeSrc());
                crmFCiUserAssetsVO.setIncomeY(crmFCiUserAssets.getIncomeY());
                crmFCiUserAssetsVO.setInvCd(crmFCiUserAssets.getInvCd());
                crmFCiUserAssetsVO.setSalAcctBank(crmFCiUserAssets.getSalAcctBank());
                crmFCiUserAssetsVO.setUnvCyc(crmFCiUserAssets.getUnvCyc());
                crmFCiUserAssetsVO.setIncomeSrc(crmFCiUserAssets.getIncomeSrc());
                CiUserAssetsDTO ciUserAssetsDTO=new CiUserAssetsDTO();
                ciUserAssetsDTO.setCustId(crmFCiUserAssets.getCustId());
                ciUserAssetsDTO.setHouseInfo(crmFCiUserAssets.getHouseInfo());
                ciUserAssetsDTO.setPurDt(crmFCiUserAssets.getPurDt());
                ciUserAssetsDTO.setPurPrc(crmFCiUserAssets.getPurPrc());
                ciUserAssetsDTO.setSeqno(crmFCiUserAssets.getSeqno());
                ciUserAssetsDTOlist.add(ciUserAssetsDTO);
            }
        }
        crmFCiUserAssetsVO.setCiUserAssetsDTOlist(ciUserAssetsDTOlist);
        return crmFCiUserAssetsVO;
    }
}
