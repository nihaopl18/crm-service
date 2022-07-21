package cn.com.yusys.climp.score.repository.mapper;

import cn.com.yusys.climp.score.domain.ExcelImport;
import cn.com.yusys.climp.score.domain.ScoreGame;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;

public interface ExcelImportMapper  extends CommonMapper<ExcelImport> {
    void updateByImportCode(ExcelImport excelImport);

    void updateStatus(ExcelImport excelImport);

    void deleteData(String importCode);
}
