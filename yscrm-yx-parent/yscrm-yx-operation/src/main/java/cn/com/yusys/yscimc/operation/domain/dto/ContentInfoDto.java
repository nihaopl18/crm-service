package cn.com.yusys.yscimc.operation.domain.dto;

import cn.com.yusys.yscimc.operation.domain.vo.ContentInfoVo;

import java.util.ArrayList;
import java.util.List;

/**
 * 内容类型的所有组件返回的信息保存到该类中
 *      营销动作、素材、分享、报名、分裂
 * @author zhangyt12
 * @date 2021/12/16 16:10
 */
public class ContentInfoDto {

    private final List<ContentInfoVo> contentInfoVoList = new ArrayList<>();

    public List<ContentInfoVo> getContentInfoVoList() {
        return this.contentInfoVoList;
    }

    public void addContentInfoVo(ContentInfoVo contentInfoVo) {
        this.contentInfoVoList.add(contentInfoVo);
    }

    public void addContentInfoVoList(List<ContentInfoVo> contentInfoVoList) {
        this.contentInfoVoList.addAll(contentInfoVoList);
    }
}
