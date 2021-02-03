package com.macro.mall.mapper;

import com.macro.mall.model.PmsProduct;
import com.macro.mall.model.PmsProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface PmsProductMapper {
    long countByExample(PmsProductExample example);

    int deleteByExample(PmsProductExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PmsProduct record);

    int insertSelective(PmsProduct record);

    List<PmsProduct> selectByExampleWithBLOBs(PmsProductExample example);

    List<PmsProduct> selectByExample(PmsProductExample example);
    /**
     * 获取人气推荐总数
     */
    @Select(" SELECT count(*)\n" +
            "        FROM\n" +
            "            pms_product\n" +
            "        WHERE\n" +
            "            delete_status = 0\n" +
            "            AND publish_status = 1")
    Long getrRecProductTotal();

    PmsProduct selectByPrimaryKey(Long id);

    List<PmsProduct> selectByCategory(Long cid, @Param("offset") Integer offset,@Param("limit") Integer limit);

    @Select("SELECT p.*\n" +
            "        FROM\n" +
            "            pms_product p\n" +
            "        WHERE\n" +
            "            p.publish_status = 1\n" +
            "            AND p.delete_status = 0\n" +
            "        ORDER BY\n" +
            "            p.sort DESC\n" +
            "        LIMIT #{offset}, #{limit}")
    List<PmsProduct> selectAllGoods(@Param("offset") Integer offset,@Param("limit") Integer limit);

    int updateByExampleSelective(@Param("record") PmsProduct record, @Param("example") PmsProductExample example);

    int updateByExampleWithBLOBs(@Param("record") PmsProduct record, @Param("example") PmsProductExample example);

    int updateByExample(@Param("record") PmsProduct record, @Param("example") PmsProductExample example);

    int updateByPrimaryKeySelective(PmsProduct record);

    int updateByPrimaryKeyWithBLOBs(PmsProduct record);

    int updateByPrimaryKey(PmsProduct record);
}