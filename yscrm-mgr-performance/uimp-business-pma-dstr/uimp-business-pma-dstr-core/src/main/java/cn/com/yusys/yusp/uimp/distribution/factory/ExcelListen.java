package cn.com.yusys.yusp.uimp.distribution.factory;

import cn.com.yusys.yusp.uimp.distribution.domain.PmaFComDepAcctInfo;
import cn.com.yusys.yusp.uimp.distribution.repository.mapper.PmaFComDepAcctInfoMapper;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author:Mr.raop
 * @create:2022-06-06
 */
@Service
public class ExcelListen extends AnalysisEventListener<DepAcctInfoExcelVo> {

    //这里不能用spring注入，需要用set注入，因为EasyExcel导入不支持spring注入
    PmaFComDepAcctInfoMapper mapper;

    public ExcelListen(PmaFComDepAcctInfoMapper mapper){
        this.mapper = mapper;
    }

    private final List<PmaFComDepAcctInfo> list = new ArrayList<>();
    private static final int BATCH_COUNT = 200;

    // 读取表头内容
    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        System.out.println("表头：" + headMap);
    }


    /**
     * 1.一行一行读取 excel 内容
     * 2.一行一行写数据速度太慢，也不利于校验 -> 用一个峰值去控制它，当它达到峰值再写数据库
     * 3.达到峰值后的数据怎么处理 -> 用重写的doAfterAllAnalysed方法去写数据库，此方法也读取完数据了的
     * 4.list用final修饰，用完后清空，便于下次赋值
     * @param depAcctInfoExcelVo
     * @param analysisContext
     */
    @Override
    public void invoke(DepAcctInfoExcelVo depAcctInfoExcelVo, AnalysisContext analysisContext) {
        System.out.println("***"+depAcctInfoExcelVo+"***");
        PmaFComDepAcctInfo entity = new PmaFComDepAcctInfo();
        BeanUtils.copyProperties(depAcctInfoExcelVo, entity);
        entity.setId(UUID.randomUUID().toString().replace("-", ""));

        list.add(entity);

        // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
        if (list.size() >= BATCH_COUNT) {
            //监听器中不能使用spring注入，所以报错，在网上找到其中一种解决办法使用set 形式 注入mapper
            saveData(list);
            // 存储完成清理 list
            list.clear();
        }

    }

    /**
     * 读取完成之后（读取所有数据完成之后）干什么
     * @param analysisContext
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        //保存数据，确保最后的遗留数据也能保存到数据库或者进行其他操作
        saveData(list);
        list.clear();
    }

    @Transactional(rollbackFor = Exception.class)
    public void saveData(List<PmaFComDepAcctInfo> list){

        List<PmaFComDepAcctInfo> reslist = new ArrayList<>();
        //去重
        for(PmaFComDepAcctInfo templist : list){
            boolean b = reslist.stream().anyMatch(vo -> templist.getCustNumber().equals(vo.getCustNumber())
                    &&templist.getCustName().equals(vo.getCustName())
                    &&templist.getAcctNo().equals(vo.getAcctNo())
                    &&templist.getSubAcctNo().equals(vo.getSubAcctNo())
                    &&templist.getAccountType().equals(vo.getAccountType())
                    &&templist.getOrgId().equals(vo.getOrgId())
                    &&templist.getOrgName().equals(vo.getOrgName())
                    &&templist.getOpenDate().equals(vo.getOpenDate())
                    &&templist.getBalance().equals(vo.getBalance())
            );
            if(b){//如果为true则跳过，如果为false则插入
                continue;
            }
            reslist.add(templist);
        }
        mapper.upsert(reslist);
    }
}
