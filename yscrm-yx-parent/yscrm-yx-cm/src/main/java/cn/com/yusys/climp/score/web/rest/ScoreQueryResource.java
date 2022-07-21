package cn.com.yusys.climp.score.web.rest;

import cn.com.yusys.climp.score.domain.ScoreExch;
import cn.com.yusys.climp.score.service.ScoreQueryService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/scorequery")
public class ScoreQueryResource extends CommonResource {
    private Logger logger = LoggerFactory.getLogger(ScoreQueryResource.class);

    @Autowired
    private ScoreQueryService scoreQueryService;

    @Override
    protected CommonService getCommonService() {
        return null;
    }
    /**
     * 积分汇总查询
     * @return
     */
    @GetMapping("/list")
    public ResultDto<List<Map<String,String>>> list(QueryModel model){
        ResultDto<List<Map<String,String>>> rs = null;
        try {
            List<Map<String,String>> list = scoreQueryService.getList(model);
            rs = new ResultDto<>(list);
        }catch (Exception e){
            rs = new ResultDto<>();
            rs.setCode(-1);
            rs.setMessage("查询失败");
            logger.error(e.getMessage());
            e.printStackTrace();
        }finally {
            return rs;
        }
    }
    /**
     * 积分明细查询
     * @return
     */
    @GetMapping("/detail")
    public ResultDto<List<Map<String,String>>> detail(QueryModel model){
        ResultDto<List<Map<String,String>>> rs = null;
        try {
            List<Map<String,String>> list = scoreQueryService.getDetail(model);
            rs = new ResultDto<>(list);
        }catch (Exception e){
            rs = new ResultDto<>();
            rs.setCode(-1);
            rs.setMessage("查询失败");
            logger.error(e.getMessage());
            e.printStackTrace();
        }finally {
            return rs;
        }
    }
}
