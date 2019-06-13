package com.xuxx.ms.mall.goods.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@ApiModel
@Accessors(chain = true)
public class TbGoods implements Serializable{
	private static final long serialVersionUID = 2206164457135261518L;

	private Long id;

    private String sellerId;

    private String goodsName;

    private Long defaultItemId;

    private String auditStatus;

    private String isMarketable;

    private Long brandId;

    private String caption;

    private Long category1Id;

    private Long category2Id;

    private Long category3Id;

    private String smallPic;

    private BigDecimal price;

    private Long typeTemplateId;

    private String isEnableSpec;

    private String isDelete;
}