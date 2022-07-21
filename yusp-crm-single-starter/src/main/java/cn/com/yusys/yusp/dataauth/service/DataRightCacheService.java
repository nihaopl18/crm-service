package cn.com.yusys.yusp.dataauth.service;

import cn.com.yusys.yusp.dataauth.repository.mapper.DataRightCacheMapper;
import cn.com.yusys.yusp.uaa.client.dto.DataContrDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class DataRightCacheService {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DataRightCacheMapper dataRightCacheMapper;


    @Transactional(readOnly = true)
    @Cacheable(value = "v2-sessionInfo", key = "'dataContr_'+#accessToken")
    public List<DataContrDTO> getDataAuth(String loginCode, String sysId, String accessToken,String selectRole) {
        List<DataContrDTO> dataContr = new ArrayList<>();
        if (loginCode == null) {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("loginCode传入参数为null,无法查询用户数据权限信息");
            }
        } else {
            dataContr = dataRightCacheMapper.selectDataAuthList(loginCode, sysId,selectRole);
        }
        return dataContr;
    }


    /**
     * @描述: 根据用户获取对应的数据权限信息
     * @param loginUserCode
     * @param accessToken
     * @return
     */
    public DataContrDTO getDataContrl(String loginUserCode, String accessToken,String requestUri,String selectRole){

        DataContrDTO dataContrDTO = null;
        List<DataContrDTO> dataCtrlList = this.getDataAuth(loginUserCode,null,accessToken,selectRole);
        if(dataCtrlList==null||dataCtrlList.size()==0){
            LOGGER.info("用户[{}]没有被授权数据权限", loginUserCode);
        }else{
            List<DataContrDTO> matchDataCtrlList = dataCtrlList.stream()
                    .filter(data -> requestUri.equals(data.getContrUrl()))
                    .collect(Collectors.toList());

            if(matchDataCtrlList==null||matchDataCtrlList.size()==0){
                List<DataContrDTO> defaultDataCtrl = dataCtrlList.stream().filter(data -> "*".equals(data.getContrId()))
                        .collect(Collectors.toList());
                if (LOGGER.isDebugEnabled()) {
                    LOGGER.debug("用户[{}]访问的控制点{}使用默认模板,默认模板有[{}]条", loginUserCode, requestUri, matchDataCtrlList.size());
                }

                if (defaultDataCtrl != null && defaultDataCtrl.size() > 0) {
                    dataContrDTO = defaultDataCtrl.get(0);
                }
            }else{
                dataContrDTO = matchDataCtrlList.stream().min(Comparator.comparing(DataContrDTO::getPriority)).get();
            }
        }

        return dataContrDTO ;
    }


}
