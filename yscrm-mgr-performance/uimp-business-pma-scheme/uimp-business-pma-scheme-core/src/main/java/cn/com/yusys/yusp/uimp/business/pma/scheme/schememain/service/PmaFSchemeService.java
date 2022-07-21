package cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.service;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.sequence.exception.SequenceConfigException;
import cn.com.yusys.yusp.sequence.handler.SequenceHandlerFactory;
import cn.com.yusys.yusp.sequence.service.SequenceTemplateService;
import cn.com.yusys.yusp.uaa.client.dto.ObjBean;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;
import cn.com.yusys.yusp.uimp.base.service.UserInfoService;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.domain.PmaFScheme;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.domain.PmaFSchemeEvlobjRel;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.domain.PmaFSchemeIndexRel;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.domain.PmaFSchemeIndexSplit;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.domain.PmaFSchemeMktRel;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.domain.PmaFSchemeOrgRel;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.domain.PmaFSchemeSperuleRel;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.domain.PmaFSchemeTeamRel;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.domain.vo.PmaSchemeObjParamVo;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.domain.vo.PmaSchemeObjRelVo;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.repository.mapper.PmaFSchemeAuthMapper;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.repository.mapper.PmaFSchemeEvlobjRelMapper;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.repository.mapper.PmaFSchemeIndexRelMapper;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.repository.mapper.PmaFSchemeIndexScoreMapper;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.repository.mapper.PmaFSchemeIndexSplitMapper;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.repository.mapper.PmaFSchemeMapper;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.repository.mapper.PmaFSchemeMktRelMapper;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.repository.mapper.PmaFSchemeOrgRelMapper;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.repository.mapper.PmaFSchemePostRelMapper;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.repository.mapper.PmaFSchemeSperuleRelMapper;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.repository.mapper.PmaFSchemeTeamRelMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.util.StringUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * @version 1.0.0
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFSchemeService
 * @类描述: #服务类
 * @功能描述:
 * @创建人: Administrator
 * @创建时间: 2020-02-19 15:01:33
 * @修改备注:
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @Copyright (c) 宇信科技-版权所有
 */
@Service
public class PmaFSchemeService extends CommonService {
    private static String BASE_SEQ = "SCHEME_ID_SEQ";
    @Autowired
    private PmaFSchemeMapper pmaFSchemeMapper;

    @Autowired
    private PmaFSchemeOrgRelMapper pmaFSchemeOrgRelMapper;

    @Autowired
    private PmaFSchemePostRelMapper pmaFSchemePostRelMapper;

    @Autowired
    private PmaFSchemeSperuleRelMapper pmaFSchemeSperuleRelMapper;

    @Autowired
    private PmaFSchemeIndexRelMapper pmaFSchemeIndexRelMapper;

    @Autowired
    private PmaFSchemeIndexSplitMapper pmaFSchemeIndexSplitMapper;

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private SequenceTemplateService sequenceTemplateService;

    @Autowired
    private PmaFSchemeIndexRelService pmaFSchemeIndexRelService;

    @Autowired
    private PmaFSchemeAuthMapper pmaFSchemeAuthMapper;

    @Autowired
    private PmaFSchemeMktRelMapper pmaFSchemeMktRelMapper;

    @Autowired
    private PmaFSchemeTeamRelMapper pmaFSchemeTeamRelMapper;

    @Autowired
    private PmaFSchemeEvlobjRelMapper pmaFSchemeEvlobjRelMapper;

    @Autowired
    SequenceHandlerFactory sequenceHandlerFactory;

    @Autowired
    PmaFSchemeIndexScoreMapper pmaFSchemeIndexScoreMapper;

    private static final String TEAM_LEADER = "115";
    private static final String CUST_MGR = "15";

    @Override
    protected CommonMapper<?> getMapper() {
        return pmaFSchemeMapper;
    }

    @Transactional(readOnly = true)
    public List<Map<String, Object>> querylist(QueryModel model) {
//        String orgId = userInfoService.getGrantOrgCode();
        String orgId = userInfoService.getGrantOrgCode();
        model.getCondition().put("orgId", orgId);
        PageHelper.startPage(model.getPage(), model.getSize());
        List<Map<String, Object>> list = pmaFSchemeMapper.listByModel(model);
        PageHelper.clearPage();
        return list;
    }

    @Transactional(readOnly = true)
    public List<Map<String, Object>> querySpecialList(QueryModel model) {
        String orgId = userInfoService.getGrantOrgCode();
        model.getCondition().put("orgId", orgId);
        PageHelper.startPage(model.getPage(), model.getSize());
        List<Map<String, Object>> list = pmaFSchemeMapper.querySpecialList(model);
        PageHelper.clearPage();
        return list;
    }

    @Transactional(readOnly = true)
    public List<Map<String, Object>> querySchemeInfo(QueryModel model) {
        List<Map<String, Object>> list = null;
        if ("1".equals(model.getCondition().get("type"))) {    // APP-我的考核成绩
            // 客户经理及其他角色都查询考核对象是自己的考核方案
            list = pmaFSchemeMapper.querySchemeInfo(model.getCondition().get("type") + "", userInfoService.getUserInfo().getLoginCode());
        } else if ("2".equals(model.getCondition().get("type"))) {    // APP-机构考核成绩
            if (!"RC001".equals(userInfoService.getUserInfo().getRoles().get(0).getCode())) {    // 其他角色，查询考核对象是授权机构的考核方案
                list = pmaFSchemeMapper.querySchemeInfo(model.getCondition().get("type") + "", userInfoService.getGrantOrgCode());
            } else {    // 客户经理-不查询数据
                return null;
            }
        }
        return list;
    }

    public List<Map<String, Object>> querylistCount(QueryModel model) {
        //if ("RC001".equals(userInfoService.getUserInfo().getRoles().get(0).getCode())) {    // 客户经理角色，查询考核对象是当前登录人数据
        //    model.getCondition().put("isManager", userInfoService.getUserInfo().getLoginCode());
        //}
        PageHelper.startPage(model.getPage(), model.getSize());
        List<Map<String, Object>> list = pmaFSchemeMapper.listByModel(model);
        PageHelper.clearPage();
        return list;
    }

    @Transactional(readOnly = true)
    public String queryNames(String schemeId) {
        String result = "";
        List<String> resultList = new ArrayList<String>();
        try {
            if (!StringUtil.isEmpty(schemeId)) {
                String[] ids = schemeId.split(",");
                resultList = this.pmaFSchemeMapper.queryNames(ids);
                if (resultList.size() > 0) {
                    for (String s : resultList) {
                        result += s + ",";
                    }
                    result = result.substring(0, result.length() - 1);
                }
            }
        } catch (Exception e) {
            result = "-1";
            e.printStackTrace();
        }
        return result;
    }

    @Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
    public ResultDto<PmaFScheme> addInfo(PmaFScheme pmaFScheme) throws SequenceConfigException {
        UserInfoDTO user = getUser();
        pmaFScheme.setCreator(user.getLoginCode());
        //SequenceHandler sequenceHandler = sequenceHandlerFactory.getSequenceHandler("oracle");
        //String currentSequnce = sequenceHandler.getCurrentSequnce(BASE_SEQ);
        //pmaFScheme.setSchemeId("S"+currentSequnce);
        pmaFScheme.setSchemeId(sequenceTemplateService.getSequenceTemplate(BASE_SEQ,new HashMap<>()));
        pmaFScheme.setOrgId(userInfoService.getOrgCode());
        //初始化启用状态为停用
        pmaFScheme.setStatFlag("1");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        pmaFScheme.setCreateDate(dateFormat.format(new Date()));
        ResultDto<PmaFScheme> result = new ResultDto<PmaFScheme>();
        this.pmaFSchemeMapper.insertSelective(pmaFScheme);
        result.setData(pmaFScheme);
        result.setMessage("新增方案成功");
        result.setCode(0);
        return result;
    }

    private UserInfoDTO getUser() {
        UserInfoDTO user = userInfoService.getUserInfo();
        return user;
    }

    @Deprecated
    @Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
    public ResultDto<String> addObj(Map<String, Object> map) {
        ResultDto<String> result = new ResultDto<String>();
        String schemeId = map.get("schemeId").toString();// 考核方案id
        String evlObjType = map.get("evlObjType").toString();// 考核对象类型
//        String postId = map.get("postId").toString();// 岗位编码
//        String postName = map.get("postName").toString();// 岗位名称
        String objId = map.get("objId").toString();// 特殊规则人员列表
        String orgId = map.get("orgId").toString();// 所选机构
        String specialValue = map.get("specialValue").toString();// 特殊规则(仅选中生效,失效)
        if (orgId.toString().length() > 0) {
            String orgIdStr[] = orgId.toString().split(",");
            pmaFSchemeMapper.delorg(schemeId);
            for (int i = 0; i < orgIdStr.length; i++) {
                PmaFSchemeOrgRel pmaFSchemeOrgRel = new PmaFSchemeOrgRel();
                pmaFSchemeOrgRel.setOrgId(orgIdStr[i]);
                pmaFSchemeOrgRel.setSchemeId(schemeId);
                pmaFSchemeOrgRelMapper.insertSelective(pmaFSchemeOrgRel);
            }
        }
//        if (postId.toString().length() > 0) {
//            String postIdStr[] = postId.toString().split(",");
//            String postNameStr[] = postName.toString().split(",");
//            pmaFSchemeMapper.delpost(schemeId);
//            for (int i = 0; i < postIdStr.length; i++) {
//            	PmaFSchemePostRel pmaFSchemePostRel = new PmaFSchemePostRel();
//            	pmaFSchemePostRel.setPostId(postIdStr[i]);
//            	pmaFSchemePostRel.setPostName(postNameStr[i]);
//            	pmaFSchemePostRel.setSchemeId(schemeId);
//            	pmaFSchemePostRelMapper.insertSelective(pmaFSchemePostRel);
//			}
//        }
        pmaFSchemeMapper.delsperule(schemeId);
        if (objId.toString().length() > 0) {
            String objIdStr[] = objId.toString().split(",");
            for (int i = 0; i < objIdStr.length; i++) {
                PmaFSchemeSperuleRel pmaFSchemeSperuleRel = new PmaFSchemeSperuleRel();
                pmaFSchemeSperuleRel.setEvlObjId(objIdStr[i]);
                pmaFSchemeSperuleRel.setEvlObjType(evlObjType);
                pmaFSchemeSperuleRel.setSchemeId(schemeId);
                pmaFSchemeSperuleRelMapper.insertSelective(pmaFSchemeSperuleRel);
            }

        }
        pmaFSchemeMapper.delobj(schemeId);
        if (evlObjType != "" && "01".equals(evlObjType)) {// 考核对象为员工
            if ("0".equals(specialValue)) {
                pmaFSchemeMapper.delpost(schemeId);
                pmaFSchemeMapper.insertObj(schemeId);
            } else {
                pmaFSchemeMapper.insertObjNew(schemeId);
            }
        } else {
            pmaFSchemeMapper.insertOrgObjNew(schemeId, evlObjType);
        }
        pmaFSchemeMapper.updateSchemeInfo(schemeId, specialValue);
        result.setMessage("新增成功");
        result.setCode(0);
        return result;
    }

    @Transactional(rollbackFor = Exception.class)
    public void saveObj(PmaSchemeObjRelVo vo) {
        String evlObjType = vo.getEvlObjType();
        String schemeId = vo.getSchemeId();
		List<PmaSchemeObjParamVo> objList = vo.getObjList();
        saveEvlObjRel(evlObjType, schemeId, objList);
        if ("01".equals(evlObjType)) {
			//客户经理
            saveMktRel(schemeId, objList);
        }else if("02".equals(evlObjType)){
        	//机构
            saveOrgRel(schemeId, objList);
        }else {
        	//团队
            saveTeamRel(schemeId, objList);
        }
    }

    /**
     * 考核方案和对象关联关系保存
     * @param evlObjType
     * @param schemeId
     * @param objList
     */
    private void saveEvlObjRel(String evlObjType, String schemeId, List<PmaSchemeObjParamVo> objList) {
        pmaFSchemeMapper.delobj(schemeId);
        List<PmaFSchemeEvlobjRel> evlobjRelList = new ArrayList<>();
        objList.forEach(obj ->{
            PmaFSchemeEvlobjRel evlobjRel = new PmaFSchemeEvlobjRel();
            evlobjRel.setId(UUID.randomUUID().toString().replace("-",""));
            evlobjRel.setSchemeId(schemeId);
            evlobjRel.setEvlObjType(evlObjType);
            evlobjRel.setEvlObjId(obj.getParamId());
            evlobjRelList.add(evlobjRel);
        });
        pmaFSchemeEvlobjRelMapper.batchInsert(evlobjRelList);
    }

    /**
     * 考核方案和团队关联关系保存
     * @param schemeId
     * @param objList
     */
    private void saveTeamRel(String schemeId, List<PmaSchemeObjParamVo> objList) {
        pmaFSchemeTeamRelMapper.deleteBySchemeId(schemeId);
        List<PmaFSchemeTeamRel> teamRelList = new ArrayList<>();
        objList.forEach(obj -> {
            PmaFSchemeTeamRel pmaFSchemeTeamRel = new PmaFSchemeTeamRel();
            pmaFSchemeTeamRel.setId(UUID.randomUUID().toString().replace("-",""));
            pmaFSchemeTeamRel.setSchemeId(schemeId);
            pmaFSchemeTeamRel.setMktTeamId(obj.getParamId());
            pmaFSchemeTeamRel.setMktTeamName(obj.getParamName());
            teamRelList.add(pmaFSchemeTeamRel);
        });
        pmaFSchemeTeamRelMapper.batchInsert(teamRelList);
    }

    /**
     * 考核方案和机构关联关系保存
     * @param schemeId
     * @param objList
     */
    private void saveOrgRel(String schemeId, List<PmaSchemeObjParamVo> objList) {
        pmaFSchemeMapper.delorg(schemeId);
        List<PmaFSchemeOrgRel> orgRelList = new ArrayList<>();
        objList.forEach(obj ->{
            PmaFSchemeOrgRel pmaFSchemeOrgRel = new PmaFSchemeOrgRel();
            pmaFSchemeOrgRel.setId(UUID.randomUUID().toString().replace("-",""));
            pmaFSchemeOrgRel.setSchemeId(schemeId);
            pmaFSchemeOrgRel.setOrgId(obj.getParamId());
            pmaFSchemeOrgRel.setOrgName(obj.getParamName());
            orgRelList.add(pmaFSchemeOrgRel);
        });
        pmaFSchemeOrgRelMapper.batchInsert(orgRelList);
    }

    /**
     * 考核方案和客户经理关联关系保存
     * @param schemeId
     * @param objList
     */
    private void saveMktRel(String schemeId, List<PmaSchemeObjParamVo> objList) {
        pmaFSchemeMktRelMapper.deleteBySchemeId(schemeId);
        List<PmaFSchemeMktRel> mktList = new ArrayList<>();
        objList.forEach(obj ->{
            PmaFSchemeMktRel pmaFSchemeMktRel = new PmaFSchemeMktRel();
            pmaFSchemeMktRel.setId(UUID.randomUUID().toString().replace("-",""));
            pmaFSchemeMktRel.setSchemeId(schemeId);
            pmaFSchemeMktRel.setMktId(obj.getParamId());
            pmaFSchemeMktRel.setMktName(obj.getParamName());
            mktList.add(pmaFSchemeMktRel);
        });
        pmaFSchemeMktRelMapper.batchInsert(mktList);
    }


    @Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
    public ResultDto<String> addIndex(Map<String, Object> map) {
        ResultDto<String> result = new ResultDto<String>();
        UserInfoDTO user = getUser();
        String schemeId = map.get("schemeId").toString();
        String indexType = map.get("indexType").toString();
        String indexId = map.get("indexId").toString();
        String balTypeId = map.get("balTypeId").toString();
        String evlObjType = map.get("evlObjType").toString();
        String applyTypeId = map.get("applyTypeId").toString();


        String co = pmaFSchemeMapper.queryIndexCount(map);
        if (co.equals("0")) {
            PmaFSchemeIndexRel pmaFSchemeIndexRel = new PmaFSchemeIndexRel();
            pmaFSchemeIndexRel.setApplyTypeId(applyTypeId);
            pmaFSchemeIndexRel.setBalTypeId(balTypeId);
            pmaFSchemeIndexRel.setEvlObjType(evlObjType);
            pmaFSchemeIndexRel.setIndexId(indexId);
            pmaFSchemeIndexRel.setIndexType(indexType);
            pmaFSchemeIndexRel.setSchemeId(schemeId);
            pmaFSchemeIndexRel.setCreator(user.getLoginCode());
            pmaFSchemeIndexRelMapper.insertSelective(pmaFSchemeIndexRel);
            result.setMessage("新增成功");
            result.setCode(0);
            return result;
        } else {
            result.setMessage("新增指标失败");
            result.setCode(1);
            return result;
        }
    }

    @Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
    public ResultDto<PmaFScheme> editInfo(PmaFScheme pmaFScheme) {
        UserInfoDTO user = this.getUser();
        ResultDto<PmaFScheme> result = new ResultDto<PmaFScheme>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        pmaFScheme.setUpdaterId(user.getLoginCode());
        pmaFScheme.setUpdateDate(dateFormat.format(new Date()));
        //启用状态恢复为停用
//        pmaFScheme.setStatFlag("1");
        this.pmaFSchemeMapper.updateByPrimaryKeySelective(pmaFScheme);
        result.setData(pmaFScheme);
        result.setMessage("修改方案成功");
        result.setCode(0);
        return result;
    }

    @Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
    public ResultDto<String> delScheme(String schemeId) {
        ResultDto<String> result = new ResultDto<String>();
        pmaFSchemeMapper.delinfoBySchemeIds(schemeId.split(","));
        pmaFSchemeMapper.delobjBySchemeIds(schemeId.split(","));
        pmaFSchemeMapper.delorgBySchemeIds(schemeId.split(","));
        pmaFSchemeMapper.delTeamBySchemeIds(schemeId.split(","));
        pmaFSchemeMapper.delMktBySchemeIds(schemeId.split(","));
        //pmaFSchemeMapper.delpostBySchemeIds(schemeId.split(","));
        //pmaFSchemeMapper.delsperuleBySchemeIds(schemeId.split(","));
        pmaFSchemeMapper.delindexBySchemeIds(schemeId.split(","));
        pmaFSchemeMapper.delsplitBySchemeIds(schemeId.split(","));
        //pmaFSchemeAuthMapper.deleteBySchemeIds(schemeId.split(","));
        result.setMessage("删除成功");
        result.setCode(0);
        return result;
    }

    @Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
    public ResultDto<String> schemePub(Map<String, Object> map) {
        ResultDto<String> result = new ResultDto<String>();
        String schemeId = map.get("schemeId").toString();
        String statFlag = map.get("statFlag").toString();
        String checkScene = map.get("checkScene").toString();
        //如果要启用方案，则验证一下方案是否关联了对象，指标，评分模型等信息,0代表启用状态
        if("0".equals(statFlag)){
            int objNum = pmaFSchemeEvlobjRelMapper.countBySchemeId(schemeId);
            if(objNum<1){
                result.setMessage("方案没有指定考核对象，无法启用");
                result.setCode(500);
                return result;
            }
            int indexNum = pmaFSchemeIndexRelMapper.countBySchemeId(schemeId);
            if(indexNum<1){
                result.setMessage("方案没有指定考核指标，无法启用");
                result.setCode(500);
                return result;
            }
            // 01代表考核场景为评分
            if("01".equals(checkScene)){
                //考核场景为评分时，验证是否有评分模型
                List<PmaFSchemeIndexRel> pmaFSchemeIndexRels = pmaFSchemeIndexRelMapper.selectDrawSchemeIndex(schemeId);
                for (PmaFSchemeIndexRel pmaFSchemeIndexRel: pmaFSchemeIndexRels)  {
                    int scoreNum = pmaFSchemeIndexScoreMapper.countByIndexId(schemeId, pmaFSchemeIndexRel.getIndexId(), pmaFSchemeIndexRel.getApplyTypeId(), pmaFSchemeIndexRel.getBalTypeId(),pmaFSchemeIndexRel.getEvlObjType());
                    if(scoreNum<1){
                        result.setMessage("指标【"+pmaFSchemeIndexRel.getIndexId()+"】没有指定配置评分模型，无法启用!");
                        result.setCode(500);
                        return result;
                    }
                }
                String s = pmaFSchemeIndexScoreMapper.selectTotalWeight(schemeId);
                if(Float.parseFloat(s)!=100F){
                    result.setMessage("方案指标评分权重之和不等于100%，无法启用!");
                    result.setCode(500);
                    return result;
                }
            }
        }
        UserInfoDTO user = this.getUser();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        pmaFSchemeMapper.schemePub(schemeId, statFlag,user.getLoginCode(),dateFormat.format(new Date()));
        result.setMessage("处理成功");
        result.setCode(0);
        return result;
    }

    @Transactional(readOnly = true)
    public List<Map<String, Object>> queryHomePageIndex(QueryModel model) {
        String orgId = userInfoService.getOrgCode();
        model.getCondition().put("orgId", orgId);
        List<Map<String, Object>> list = pmaFSchemeMapper.queryHomePageIndex(model);
        return list;
    }

    @Transactional(readOnly = true)
    public List<Map<String, Object>> queryHomePageIndexNew(QueryModel model) {
        List<PmaFScheme> pmaFSchemeList = pmaFSchemeMapper.selectDrawSchemeInfo(model.getCondition().get("schemeId").toString());
        PmaFScheme pmaFScheme = pmaFSchemeList.get(0);
        if (pmaFScheme.getEvlObjType().equals("01")) {
            model.getCondition().put("evlObjId", userInfoService.getUserInfo().getLoginCode());
        } else {
            model.getCondition().put("evlObjId", userInfoService.getGrantOrgCode());
        }
        if (model.getCondition().containsKey("indexIdStr") && !"".equals(model.getCondition().get("indexIdStr"))) {
            String indexIdStr = model.getCondition().get("indexIdStr") + "";
            model.getCondition().put("indexIdStr", indexIdStr.split(","));
        }
        PageHelper.startPage(model.getPage(), model.getSize());
        List<Map<String, Object>> list = pmaFSchemeMapper.queryHomePageIndexNew(model);
        PageHelper.clearPage();
        return list;
    }

    @Transactional(readOnly = true)
    public List<Map<String, Object>> queryHomePageIndexRate(QueryModel model) {
        List<PmaFScheme> pmaFSchemeList = pmaFSchemeMapper.selectDrawSchemeInfo(model.getCondition().get("schemeId").toString());
        PmaFScheme pmaFScheme = pmaFSchemeList.get(0);
        if (pmaFScheme.getEvlObjType().equals("01")) {
            model.getCondition().put("evlObjId", userInfoService.getUserInfo().getLoginCode());
        } else {
            model.getCondition().put("evlObjId", userInfoService.getGrantOrgCode());
        }
        if (model.getCondition().containsKey("indexIdStr") && !"".equals(model.getCondition().get("indexIdStr"))) {
            String indexIdStr = model.getCondition().get("indexIdStr") + "";
            model.getCondition().put("indexIdStr", indexIdStr.split(","));
        }
        String indexIdStrNew = "";
        List<Map<String, Object>> list1 = pmaFSchemeMapper.queryHomePageIndexNew(model);
        for (int i = 0; i < list1.size(); i++) {
            Map<String, Object> map = list1.get(i);
            if (i == 3) {
                break;
            } else {
                indexIdStrNew = indexIdStrNew + map.get("indexIdStr").toString() + ",";
            }
        }
        model.getCondition().put("indexIdStr", indexIdStrNew.split(","));
        PageHelper.startPage(model.getPage(), model.getSize());
        List<Map<String, Object>> list = pmaFSchemeMapper.queryHomePageIndexRate(model);
        PageHelper.clearPage();
        return list;
    }

    @Transactional(readOnly = true)
    public Map<String, Object> queryHomePageIndexDate(QueryModel model) {
        List<PmaFScheme> pmaFSchemeList = pmaFSchemeMapper.selectDrawSchemeInfo(model.getCondition().get("schemeId").toString());
        PmaFScheme pmaFScheme = pmaFSchemeList.get(0);
        if (pmaFScheme.getEvlObjType().equals("01")) {
            model.getCondition().put("evlObjId", userInfoService.getUserInfo().getLoginCode());
        } else {
            model.getCondition().put("evlObjId", userInfoService.getGrantOrgCode());
        }
        if (model.getCondition().containsKey("indexIdStr") && !"".equals(model.getCondition().get("indexIdStr"))) {
            String indexIdStr = model.getCondition().get("indexIdStr") + "";
            model.getCondition().put("indexIdStr", indexIdStr.split(","));
        }
        List<Map<String, Object>> list = pmaFSchemeMapper.queryHomePageIndexDate(model);
        List<Map<String, Object>> list1 = pmaFSchemeMapper.queryHomePageIndexName(model);
        String indexIdStrNew = "";
        String indexNameStrNew = "";
        Map<String, Object> map = new HashMap<String, Object>();
        List<String> listData = new ArrayList<>();
        List<Map<String, String>> listDataNew = new ArrayList<>();
        Map<String, String> dataMap = new HashMap<>();
        for (int i = 0; i < list1.size(); i++) {
            Map<String, Object> map1 = list1.get(i);
            if (i == 3) {
                break;
            } else {
                indexIdStrNew = map1.get("indexIdStr").toString();
                model.getCondition().put("indexIdStr", indexIdStrNew.split(","));
                listData = new ArrayList<>();
                for (int j = 0; j < list.size(); j++) {
                    listDataNew = new ArrayList<>();
                    dataMap = new HashMap<>();
                    model.getCondition().put("etlDate", list.get(j).get("sjDate"));
                    indexNameStrNew = map1.get("indexName").toString();
                    indexNameStrNew = indexNameStrNew + list.get(j).get("etlDate");
                    List<Map<String, Object>> list3 = pmaFSchemeMapper.queryHomePageIndexRate(model);
                    if (list3.size() == 0) {
                        listData.add("0");
                        dataMap.put("indexValue", "0");
                        dataMap.put("impValue", "0");
                        listDataNew.add(dataMap);
                        map.put(indexNameStrNew, listDataNew);
                    } else {
                        listData.add(list3.get(0).get("planPer").toString());
                        dataMap.put("indexValue", list3.get(0).get("indexValue").toString());
                        dataMap.put("impValue", list3.get(0).get("impValue").toString());
                        listDataNew.add(dataMap);
                        map.put(indexNameStrNew, listDataNew);
                    }
                }
                map.put(indexIdStrNew, listData);
            }
        }
        PageHelper.startPage(model.getPage(), model.getSize());
        PageHelper.clearPage();
        map.put("date", list);
        map.put("index", list1);
        return map;
    }

    @Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
    public ResultDto<String> addSplit(Map<String, Object> map) {
        Set<String> allBaseIndexOfEvlIndexSet = new HashSet<String>();//用于存储所有方案拆分出来的基础指标
        List<Map<String, Object>> list = pmaFSchemeMapper.querySchemeIndex(map.get("schemeId").toString());//根据方案查询方案中所有指标信息
        if (null != list && 0 < list.size()) {
            for (int i = 0; i < list.size(); i++) {
                allBaseIndexOfEvlIndexSet = pmaFSchemeIndexRelService.recursionQueryAllChildren(list.get(i).get("schemeIndexId").toString(), allBaseIndexOfEvlIndexSet);
            }
        }
        pmaFSchemeIndexSplitMapper.deleteIndex(map.get("schemeId").toString());
        if (null != allBaseIndexOfEvlIndexSet && 0 < allBaseIndexOfEvlIndexSet.size()) {
            Iterator<String> iterator = allBaseIndexOfEvlIndexSet.iterator();
            while (iterator.hasNext()) {
                String indexs = iterator.next();
                PmaFSchemeIndexSplit pmaFSchemeIndexSplit = new PmaFSchemeIndexSplit();
                String indexId = indexs.substring(0, 8);
                pmaFSchemeIndexSplit.setIndexId(indexId);
                String[] dim = indexs.substring(9, 17).split(",");
                pmaFSchemeIndexSplit.setEvlObjType(dim[0]);
                pmaFSchemeIndexSplit.setApplyTypeId(dim[1]);
                pmaFSchemeIndexSplit.setBalTypeId(dim[2]);
                pmaFSchemeIndexSplit.setIndexType("01");
                pmaFSchemeIndexSplit.setSchemeId(map.get("schemeId").toString());
                pmaFSchemeIndexSplitMapper.insertSelective(pmaFSchemeIndexSplit);
            }

        }
        ResultDto<String> result = new ResultDto<String>();
        result.setMessage("处理成功");
        result.setCode(0);
        return result;
    }

    /**
     * 引用
     */
    @Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
    public ResultDto<String> drawScheme(Map<String, Object> map) {
        String newSchemeId = sequenceTemplateService.getSequenceTemplate(BASE_SEQ, new HashMap<String, String>());
        this.drawSchemeInfo(map, newSchemeId);
//    	this.drawSchemeOrgRel(newSchemeId);
        this.drawSchemeIndex(map, newSchemeId);
        ResultDto<String> result = new ResultDto<String>();
        result.setMessage("引用成功");
        result.setCode(0);
        return result;
    }

    /**
     * 复制方案信息
     */
    @Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
    public void drawSchemeInfo(Map<String, Object> map, String newSchemeId) {
        String schemeId = map.get("schemeId").toString();
        String menuId = map.get("menuId").toString();
        List<PmaFScheme> pmaFSchemeList = pmaFSchemeMapper.selectDrawSchemeInfo(schemeId);
        for (int i = 0; i < pmaFSchemeList.size(); i++) {
            PmaFScheme pmaFScheme = pmaFSchemeList.get(i);
            pmaFScheme.setMenuId(menuId);
            pmaFScheme.setCreator(userInfoService.getUserInfo().getLoginCode());
            pmaFScheme.setSchemeId(newSchemeId);
            pmaFScheme.setOrgId(userInfoService.getGrantOrgCode());
            pmaFScheme.setStatFlag("0");
            pmaFScheme.setIsExcel("1");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
            pmaFScheme.setCreateDate(dateFormat.format(new Date()));
            pmaFSchemeMapper.insertSelective(pmaFScheme);
        }

    }

    /**
     * 复制方案信息
     */
    @Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
    public void drawSchemeOrgRel(String newSchemeId) {
        PmaFSchemeOrgRel pmaFSchemeOrgRel = new PmaFSchemeOrgRel();
        pmaFSchemeOrgRel.setSchemeId(newSchemeId);
        pmaFSchemeOrgRel.setOrgId(userInfoService.getGrantOrgCode());
        pmaFSchemeOrgRelMapper.insertSelective(pmaFSchemeOrgRel);
    }

    /**
     * 复制方案信息
     */
    @Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
    public void drawSchemeIndex(Map<String, Object> map, String newSchemeId) {
        String schemeId = map.get("schemeId").toString();
        List<PmaFSchemeIndexRel> pmaFSchemeIndexRelList = pmaFSchemeIndexRelMapper.selectDrawSchemeIndex(schemeId);
        for (int i = 0; i < pmaFSchemeIndexRelList.size(); i++) {
            PmaFSchemeIndexRel pmaFSchemeIndexRel = pmaFSchemeIndexRelList.get(i);
            pmaFSchemeIndexRel.setSchemeId(newSchemeId);
            pmaFSchemeIndexRelMapper.insertSelective(pmaFSchemeIndexRel);
        }
    }


    public List<Map<String, Object>> querySchemeList(QueryModel model) {
        //查询
        String orgId = userInfoService.getGrantOrgCode();
        model.getCondition().put("orgId", orgId);
        PageHelper.startPage(model.getPage(), model.getSize());
        List<Map<String, Object>> list = pmaFSchemeMapper.querySchemeList(model);
        PageHelper.clearPage();
        return list;
    }

    public List<Map<String, Object>> queryManagerList(QueryModel model) {
        UserInfoDTO userInfo = userInfoService.getUserInfo();
        //查询出客户经理的roleId
        String roleId = pmaFSchemeMapper.selectMgrRoleId(CUST_MGR);
        //查询出客户经理
        List<String> userIdList = pmaFSchemeMapper.selectUserIdList(roleId);

        String code = userInfo.getOrg().getCode();
        //查询出该机构下所有用户
//		List<String> userList=pmaFSchemeMapper.selectAllUser(code);
        //查询出该机构下的客户经理
        if (userIdList != null && userIdList.size() > 0) {
            List<Map<String, Object>> list = pmaFSchemeMapper.selectMgrList(userIdList, code);
            return list;
        }
        return null;
    }

    public List<Map<String, Object>> queryManagerTeamList(QueryModel model) {
        UserInfoDTO userInfo = userInfoService.getUserInfo();
        List<ObjBean> roles = userInfo.getRoles();
        if (roles.size() == 1 && roles.get(0).getCode().equals(TEAM_LEADER)) {
            PageHelper.startPage(model.getPage(), model.getSize());
            List<Map<String, Object>> list = pmaFSchemeMapper.queryManagerTeamListByUserId(userInfo.getUserId());
            PageHelper.clearPage();
            return list;
        } else {
            String orgCode = userInfoService.getOrgCode();
            model.getCondition().put("orgCode", orgCode);
            PageHelper.startPage(model.getPage(), model.getSize());
            List<Map<String, Object>> list = pmaFSchemeMapper.queryManagerTeamList(orgCode);
            PageHelper.clearPage();
            return list;
        }
    }

    public List<Map<String,Object>> getObjList(String schemeId, String evlObjType) {

        if("01".equals(evlObjType)){
            //查询客户经理
            return pmaFSchemeMktRelMapper.selectBySchemeId(schemeId);
        }else{
            //查询团队
            return pmaFSchemeTeamRelMapper.selectBySchemeId(schemeId);
        }
    }
}
