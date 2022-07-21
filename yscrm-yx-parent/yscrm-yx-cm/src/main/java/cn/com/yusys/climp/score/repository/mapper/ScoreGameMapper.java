package cn.com.yusys.climp.score.repository.mapper;

import cn.com.yusys.climp.score.domain.ScoreGame;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import org.apache.ibatis.annotations.Param;

public interface ScoreGameMapper extends CommonMapper<ScoreGame> {
    void deleteByImportCode(@Param("importCode")String importCode);

    Integer insertExcel(@Param("importCode")String importCode, @Param("updateUser")String updateUser);

    void deleteExcel(@Param("importCode")String importCode);

    void insertAccount();

    void insertTmp(String importCode);

    void deleteTmp(String importCode);

    void deleteDateTmp(String importCode);
}
