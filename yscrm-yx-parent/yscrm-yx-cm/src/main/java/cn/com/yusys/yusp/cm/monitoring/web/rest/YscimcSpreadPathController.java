package cn.com.yusys.yusp.cm.monitoring.web.rest;

import cn.com.yusys.yusp.cm.monitoring.service.YscimcSpreadPathService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 传播关系表
 *
 * @author houyx3
 * @date 2022-04-16 14:15:48
 */
@Api("传播关系表接口")
@RestController
@RequestMapping("/api/yscimcspreadpath")
public class YscimcSpreadPathController {
    @Autowired
    private YscimcSpreadPathService yscimcSpreadPathService;


}
