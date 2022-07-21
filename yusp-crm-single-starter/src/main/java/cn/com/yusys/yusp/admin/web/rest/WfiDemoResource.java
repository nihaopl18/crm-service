package cn.com.yusys.yusp.admin.web.rest;

import cn.com.yusys.yusp.admin.domain.WfiDemo;
import cn.com.yusys.yusp.admin.domain.WfiExceptionDemo;
import cn.com.yusys.yusp.admin.service.WfiDemoService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/joindemo")
public class WfiDemoResource {
    
    @Autowired
    private WfiDemoService echainJoinDemoService;
    
    /**
     * 
     * @方法名称:addWfiDemo
     * @方法描述:保存信息
     * @参数与返回说明:
     * @算法描述:
     */
    @PostMapping("/addWfiDemo")
    public ResultDto<Boolean> addWfiDemo(@RequestBody WfiDemo record) {
        Boolean result= echainJoinDemoService.addWfiDemo(record);
        return new ResultDto<Boolean>(result);
    }
    
    /**
     * 
     * @方法名称:queryAllWfiDemo
     * @方法描述:查询流程示例列表
     * @参数与返回说明:
     * @算法描述:
     */
    @GetMapping("/queryAllWfiDemo")
    public ResultDto<List<WfiDemo>> queryAllWfiDemo(QueryModel model){
    	List<WfiDemo> list=echainJoinDemoService.selectAllWfiDemo(model);
    	return new ResultDto<List<WfiDemo>>(list);
    }
    
    /**
     * 
     * @方法名称:updateWfiDemo
     * @方法描述:修改信息
     * @参数与返回说明:
     * @算法描述:
     */
    @PostMapping("/updateWfiDemo")
    public ResultDto<Boolean> updateWfiDemo(@RequestBody WfiDemo record) {
        Boolean result= echainJoinDemoService.updateWfiDemo(record);
        return new ResultDto<Boolean>(result);
    }  
    
    /**
     * 
     * @方法名称:queryAllWfiExceptionDemo
     * @方法描述:查询异常事务列表
     * @参数与返回说明:
     * @算法描述:
     */
    @GetMapping("/queryAllWfiExceptionDemo")
    public ResultDto<List<WfiExceptionDemo>> queryAllWfiExceptionDemo(QueryModel model){
        List<WfiExceptionDemo> list=echainJoinDemoService.selectAllExceptionDemo(model);
        return new ResultDto<List<WfiExceptionDemo>>(list);
    }
    
    /**
     * 
     * @方法名称:deleteWfiExceptionDemo
     * @方法描述:删除异常事务
     * @参数与返回说明:
     * @算法描述:
     */
    @PostMapping("/deleteWfiExceptionDemo")
    public ResultDto<Map<String, Object>> deleteWfiExceptionDemo(String logicSeq){
        Boolean result=echainJoinDemoService.deleteWfiExceptionDemo(logicSeq);
        Map<String, Object> map = new HashMap<String, Object>();
        if (result) {
            map.put("message", "处理成功");
            map.put("flag", "success");
        } else {
            map.put("message", "处理失败");
            map.put("flag", "error");
        }
        return new ResultDto<Map<String, Object>>(map);
    }
    @PostMapping("/getUserByOrg")
    public ResultDto<List<Map<String, String>>> getUserByOrg(@RequestBody QueryModel model){
        List<Map<String, String>> list=(List<Map<String, String>>) model.getCondition().get("data");
        List<Map<String, String>> listmap=echainJoinDemoService.getUserByOrg(list);
        return new ResultDto<List<Map<String, String>>>(listmap);
    }
    
}
