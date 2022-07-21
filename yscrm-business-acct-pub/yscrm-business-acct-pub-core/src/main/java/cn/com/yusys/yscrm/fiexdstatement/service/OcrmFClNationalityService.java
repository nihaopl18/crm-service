package cn.com.yusys.yscrm.fiexdstatement.service;

import cn.com.yusys.yscrm.fiexdstatement.domain.OcrmFClNationality;
import cn.com.yusys.yscrm.fiexdstatement.repository.mapper.OcrmFClNationalityMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OcrmFClNationalityService extends CommonService {

    @Autowired
    private OcrmFClNationalityMapper ocrmFClNationalityMapper;

    @Override
    protected CommonMapper getMapper() {
        return ocrmFClNationalityMapper;
    }

    public List<Map<String, Object>> getList(QueryModel queryModel) {
        PageHelper.startPage(queryModel.getPage(), queryModel.getSize());
        List<Map<String, Object>> list = ocrmFClNationalityMapper.getList(queryModel);
        PageHelper.clearPage();
        return list;
    }

    public List<OcrmFClNationality> queryByAreaNo(String areaNo) {
        List<OcrmFClNationality> nationalityList = ocrmFClNationalityMapper.queryByAreaNo(areaNo);
        return nationalityList;
    }

    public List<Map<String, Object>> getNationality() {
        List<Map<String, Object>> nationalityList = ocrmFClNationalityMapper.getNationality();
        return nationalityList;
    }


    public int getCountByArea(String lastAreaNo) {

        return ocrmFClNationalityMapper.getCountByArea(lastAreaNo);
    }

    public List<Map<String, Object>> getAreaNoList() {
        List<Map<String, Object>> nationalityList = ocrmFClNationalityMapper.getAreaNoList();
        return nationalityList;
    }
}
