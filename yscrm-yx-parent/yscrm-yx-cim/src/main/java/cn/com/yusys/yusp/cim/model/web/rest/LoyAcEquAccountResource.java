package cn.com.yusys.yusp.cim.model.web.rest;

import cn.com.yusys.yusp.cim.model.domain.LoyAcEquAccount;
import cn.com.yusys.yusp.cim.model.service.LoyAcEquAccountService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @version 1.0.0
 * @项目名称: yscimc-cust-group模块
 * @类名称: LoyAcEquAccountResource
 * @类描述: #资源类
 * @功能描述:
 * @创建人: hyx
 * @创建时间: 2019-05-27 18:17:31
 * @修改备注:
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/loyacequaccount")
public class LoyAcEquAccountResource extends CommonResource<LoyAcEquAccount, String> {
    @Autowired
    private LoyAcEquAccountService loyAcEquAccountService;

    @Override
    protected CommonService getCommonService() {
        return loyAcEquAccountService;
    }

    /**
     * 查询权益账户
     */
    @GetMapping("/list")
    public ResultDto<List<Map<String, Object>>> list(QueryModel model) {
        return new ResultDto<>(loyAcEquAccountService.getListByModel(model));
    }

    /**
     * 权益账户新增
     *
     * @param add
     * @return
     */
    @PostMapping("/add")
    public ResultDto<Integer> add(@RequestBody LoyAcEquAccount loyAcEquAccount) {
        return new ResultDto<>(loyAcEquAccountService.add(loyAcEquAccount));
    }

    /**
     * 权益账户修改
     *
     * @param upd
     * @return
     */
    @PostMapping("/upd")
    public ResultDto<Integer> upd(@RequestBody LoyAcEquAccount loyAcEquAccount) {
        return new ResultDto<>(loyAcEquAccountService.upd(loyAcEquAccount));
    }

    /**
     * 权益账户删除
     *
     * @param del
     * @return
     */
    @PostMapping("/del")
    public ResultDto<Integer> del(@RequestBody QueryModel model) {
        ResultDto<Integer> resultDto = null;
        int num = loyAcEquAccountService.del(model);
        if (num > 0) {
            resultDto = new ResultDto<>(num);
            resultDto.setCode(0);
            resultDto.setMessage("删除成功");
            return resultDto;
        }
        resultDto = new ResultDto<>(0);
        resultDto.setCode(-1);
        resultDto.setMessage("删除失败");
        return resultDto;
    }

    /**
     * 金融机构
     *
     * @param getFinanceOrg
     * @return
     */
    @GetMapping("/financeorg")
    public ResultDto<List<Map<String, Object>>> getFinanceOrg(@RequestBody QueryModel model) {
        return new ResultDto<>(loyAcEquAccountService.getFinanceOrg(model));
    }

    /**
     * 金融所辖机构
     *
     * @param getFinanceOrg
     * @return
     */
    @GetMapping("/orgtree")
    public ResultDto<List<Map<String, Object>>> getOrgTreeByInstu(QueryModel model) {
        return new ResultDto<>(loyAcEquAccountService.getOrgTreeByInstu(model));
    }

    /**
     * 权益账户上架
     *
     * @param upd
     * @return
     */
    @PostMapping("/upload")
    public ResultDto<Integer> upload(@RequestBody Map<String, String> map) {
        return new ResultDto<>(loyAcEquAccountService.upload(map));
    }

    /**
     * 权益账户下架
     *
     * @param upd
     * @return
     */
    @PostMapping("/download")
    public ResultDto<Integer> download(@RequestBody Map<String, String> map) {
        return new ResultDto<>(loyAcEquAccountService.download(map));
    }
}
