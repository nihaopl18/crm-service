package cn.com.yusys.climp.score.repository.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface ScoreAdjustMapper {

    Map<String, String> getCustGrade(@Param("custNo") String custNo);

    Map<String, String> getMgrInfo(@Param("custNo")String custNo);

    Map<String, String> chechImportCode(@Param("importCode")String importCode);

    Map<String, String> getCustName(@Param("customerNo")String customerNo, @Param("sysCode")String sysCode);

    String getAttrId(@Param("code")String code);
}
