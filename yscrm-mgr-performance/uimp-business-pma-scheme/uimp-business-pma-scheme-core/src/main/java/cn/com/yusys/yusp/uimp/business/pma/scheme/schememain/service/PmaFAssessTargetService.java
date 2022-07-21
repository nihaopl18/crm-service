package cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.service;

import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.domain.vo.PmaFAssessTargetVo;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/** 目标下发服务
 * @author houyx3
 * @email houyx3@yusys.com.cn
 * @date 2022/5/19 16:48
 */

public interface PmaFAssessTargetService {

    /**
     * 导出下发方案
     * @param id 方案id
     * @param years 年份
     * @param objIds 对象编号
     * @param indexIds 指标编号
     * @param response 响应
     */
    void export(String id, String years,String objIds,String indexIds, HttpServletResponse response);

    /**
     * 导入
     * @param file 文件
     */
    void importExcel(MultipartFile file);

    /**
     * 查询方案下的考核经理
     * @param model 查询条件
     * @return 考核客户经理集合
     */
    List<Map<String, Object>> getMgrBySchemeId(QueryModel model);

    /**
     * 查询方案下发的信息
     * @param model 查询条件
     * @return 下发方案信息
     */
    List<PmaFAssessTargetVo> getList(QueryModel model);

    /**
     * 通过机构获取考核目标关联的团队
     * @param model 查询条件
     */
    List<Map<String, Object>> getTemeBySchemeId(QueryModel model);
}
