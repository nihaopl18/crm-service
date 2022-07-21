package cn.com.yusys.yscimc.operation.domain.vo;

/**
 * 内容类型的组件返回的数据需要实现的统一接口
 *      营销动作、素材、分享、报名、分裂
 * @author zhangyt12
 * @date 2021/12/16 16:24
 */
public interface ContentInfoVo {

    default String getName() {
        return null;
    }
}
