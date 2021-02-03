package com.macro.mall.portal.dao;

import com.macro.mall.model.CmsSubject;
import com.macro.mall.model.PmsBrand;
import com.macro.mall.model.PmsProduct;
import com.macro.mall.portal.domain.FlashPromotionProduct;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 首页内容管理自定义Dao
 * Created by macro on 2019/1/28.
 */
public interface HomeDao {

    /**
     * 获取推荐品牌
     */
    List<PmsBrand> getRecommendBrandList(@Param("offset") Integer offset,@Param("limit") Integer limit);

    /**
     * 获取秒杀商品
     */
    List<FlashPromotionProduct> getFlashProductList(@Param("flashPromotionId") Long flashPromotionId, @Param("sessionId") Long sessionId);

    /**
     * 获取新品推荐
     */
    List<PmsProduct> getNewProductList(@Param("offset") Integer offset,@Param("limit") Integer limit);
    /**
     * 获取新品推荐总数
     */
    @Select(" SELECT count(*)\n" +
            "        FROM\n" +
            "            sms_home_new_product hp\n" +
            "            LEFT JOIN pms_product p ON hp.product_id = p.id\n" +
            "        WHERE\n" +
            "            hp.recommend_status = 1\n" +
            "            AND p.publish_status = 1")
    Long getNewProductTotal();

    /**
     * 获取人气推荐
     */
    List<PmsProduct> getHotProductList(@Param("offset") Integer offset,@Param("limit") Integer limit);
    /**
     * 获取人气推荐总数
     */
    @Select(" SELECT count(*)\n" +
            "        FROM\n" +
            "            sms_home_recommend_product hp\n" +
            "            LEFT JOIN pms_product p ON hp.product_id = p.id\n" +
            "        WHERE\n" +
            "            hp.recommend_status = 1\n" +
            "            AND p.publish_status = 1")
    Long getHotProductTotal();

    /**
     * 获取推荐专题
     */
    List<CmsSubject> getRecommendSubjectList(@Param("offset") Integer offset, @Param("limit") Integer limit);
}
