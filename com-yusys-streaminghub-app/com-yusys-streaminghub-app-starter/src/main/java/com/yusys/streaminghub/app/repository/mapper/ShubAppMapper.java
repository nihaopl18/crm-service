package com.yusys.streaminghub.app.repository.mapper;

import com.yusys.streaminghub.app.domain.ShubApp;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface ShubAppMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String appId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(ShubApp row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    ShubApp selectByPrimaryKey(String appId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<ShubApp> selectAll();

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(ShubApp row);
}