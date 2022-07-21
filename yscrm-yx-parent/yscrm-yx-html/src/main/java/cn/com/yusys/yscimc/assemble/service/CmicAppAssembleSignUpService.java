package cn.com.yusys.yscimc.assemble.service;


import cn.com.yusys.climp.utils.UserInfoService;
import cn.com.yusys.yscimc.assemble.domain.CmicAppAssembleSignUpEntity;
import cn.com.yusys.yscimc.assemble.repository.mapper.CmicAppAsseSignImgMapper;
import cn.com.yusys.yscimc.assemble.repository.mapper.CmicAppAssembleSignUpMapper;
import cn.com.yusys.yscimc.assemble.vo.CmicAppAssembleSignUpVo;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @version 1.0.0
 * @项目名称: yscimc-app-mobile模块
 * @类名称: CmicAppAssembleSignUpService
 * @类描述: #服务类
 * @功能描述: 客户报名信息服务类
 * @创建人: houyx3
 * @创建时间: 2021-12-30
 * @修改备注:
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service("cmicAppAssembleSignUpService")
public class CmicAppAssembleSignUpService extends CommonService {

    private CmicAppAssembleSignUpMapper mapper;

    @Autowired
    public CmicAppAssembleSignUpService(CmicAppAssembleSignUpMapper mapper) {
        this.mapper = mapper;
    }


    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private CmicAppAsseSignImgMapper cmicAppAsseSignImgMapper;

    @Override
    protected CommonMapper getMapper() {
        return this.mapper;
    }


    @Transactional(rollbackFor = Exception.class)
    public int save(CmicAppAssembleSignUpVo vo) {
        String userId = userInfoService.getUserInfo().getUserId();
        CmicAppAssembleSignUpEntity entity = new CmicAppAssembleSignUpEntity();
        BeanUtils.copyProperties(vo,entity);
        /**
         * 将页面内容保存到文件管理器中，并返回路径
         */
//        FileManagementClient fileManagementClient = clientFactory.getFileManagementClient();
//        File file = new File("act.text");
//        FileOutputStream outputStream = null;
//        try {
//            outputStream = new FileOutputStream(file);
//            outputStream.write(entity.getActHtmlContent().getBytes());
//            outputStream.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (null != outputStream) {
//                try {
//                    outputStream.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }

        CmicAppAssembleSignUpEntity cmicAppAssembleSignUpEntity = mapper.selectByPrimaryKey(entity.getId());
        Date date = new Date();
        //String s = fileManagementClient.uploadFile(file);
        entity.setActHtml("/activity?tempId="+vo.getId());
        entity.setLastChgUsr(userId);
        entity.setLastChgDt(date);
        /**
         * 查询当前记录是否存在，不存在为新增，存在则删除以前文件再修改
         */
        if (null == cmicAppAssembleSignUpEntity) {
            entity.setCreatorId(userId);
            entity.setCreateDate(date);
        } else {
            entity.setCreatorId(cmicAppAssembleSignUpEntity.getCreatorId());
            entity.setCreateDate(cmicAppAssembleSignUpEntity.getCreateDate());
            //fileManagementClient.deleteFile(cmicAppAssembleSignUpEntity.getActHtml());
            mapper.deleteByPrimaryKey(entity.getId());
            cmicAppAsseSignImgMapper.deleteByIds(entity.getId());
        }

        vo.getList().forEach(images -> cmicAppAsseSignImgMapper.insertSelective(images));

        return  mapper.insertSelective(entity);
    }

    /**
     * 获取报名基础属性
     * @param id nodeId
     * @return
     */
    public CmicAppAssembleSignUpEntity getSignInfoById(String id){
        return mapper.selectByPrimaryKey(id);
    }


    public List<CmicAppAssembleSignUpEntity> getInfoByIds(List ids){
        return mapper.getInfoByIds(ids);
    }

    /**
     * 获取报名基全部信息，包括图片
     * @param id nodeId
     * @return
     */
    public CmicAppAssembleSignUpVo getInfoById(String id) {
        CmicAppAssembleSignUpVo vo = new CmicAppAssembleSignUpVo();
        BeanUtils.copyProperties(mapper.selectByPrimaryKey(id),vo);
        if (!StringUtils.isBlank(vo.getId())){
            vo.setList(cmicAppAsseSignImgMapper.selectListById(vo.getId()));
        }
        return vo;
    }
}
