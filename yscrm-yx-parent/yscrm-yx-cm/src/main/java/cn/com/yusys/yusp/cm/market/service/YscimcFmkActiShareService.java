package cn.com.yusys.yusp.cm.market.service;

import cn.com.yusys.yusp.cm.market.domain.YscimcFMkActiShare;
import cn.com.yusys.yusp.cm.market.domain.YscimcFMkActiShareImg;
import cn.com.yusys.yusp.cm.market.repository.mapper.YscimcFMkActiShareImgMapper;
import cn.com.yusys.yusp.cm.market.repository.mapper.YscimcFmkActiShareMapper;
import cn.com.yusys.yusp.cm.market.vo.YscimcFMkActiShareVo;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @version 1.0.0
 * @项目名称: yscimc-cust-group模块
 * @类名称: YscimcFmkActiShareService
 * @类描述: #服务类
 * @功能描述:
 * @创建人: hyx
 * @创建时间: 2019-06-12 09:35:03
 * @修改备注:
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class YscimcFmkActiShareService extends CommonService {

    @Autowired
    private YscimcFmkActiShareMapper yscimcFmkActiShareMapper;

    @Autowired
    private YscimcFMkActiShareImgMapper imgMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return yscimcFmkActiShareMapper;
    }

    Lock lock = new ReentrantLock();

    @Transactional(rollbackFor = Exception.class)
    public Integer save(YscimcFMkActiShareVo vo) {

        YscimcFMkActiShare entity = new YscimcFMkActiShare();
        BeanUtils.copyProperties(vo, entity);
        boolean ifAdd;
        lock.lock();
        try {
            String id = yscimcFmkActiShareMapper.hasId(entity.getNodeId());
            ifAdd = StringUtils.isBlank(id);
            if (ifAdd) {
                entity.setId(UUID.randomUUID().toString().replace("-", ""));
            } else {
                imgMapper.deleteByShareId(entity.getId());
            }

            List<YscimcFMkActiShareImg> images = vo.getImages();

            if (null != images && images.size() > 0) {
                images.forEach(img -> {

                    img.setShareId(entity.getId());
                    imgMapper.insertSelective(img);
                });
            }
            entity.setActHtml("/share?tempId=" + entity.getNodeId());
            if (ifAdd) {
                return yscimcFmkActiShareMapper.insertSelective(entity);
            } else {
                return this.yscimcFmkActiShareMapper.updateByPrimaryKeySelective(entity);
            }
        } finally {
            lock.unlock();
        }
    }

    public YscimcFMkActiShareVo getInfoByAssemble(String nodeId) {
        YscimcFMkActiShare fission = yscimcFmkActiShareMapper.getListById(nodeId);
        if (null == fission) {
            return null;
        }
        YscimcFMkActiShareVo vo = new YscimcFMkActiShareVo();
        BeanUtils.copyProperties(fission, vo);
        vo.setImages(imgMapper.getListByShareId(fission.getId()));
        return vo;
    }


    public List<YscimcFMkActiShare> getInfoByIds(List<String> shareIds) {
        return yscimcFmkActiShareMapper.getInfoByIds(shareIds);
    }
}
