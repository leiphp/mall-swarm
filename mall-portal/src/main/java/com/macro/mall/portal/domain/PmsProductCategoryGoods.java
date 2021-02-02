package com.macro.mall.portal.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author: LeiXiaoTian
 * @Site: shop.100txy.com
 * @Date: 2021/2/2
 * @Time: 15:41
 * 分类商品
 */
@Getter
@Setter
public class PmsProductCategoryGoods{

    private Long id;

    private Long brandId;

    private Long productCategoryId;

    private Long feightTemplateId;

    private Long productAttributeCategoryId;

    private String name;

    private String pic;
}
