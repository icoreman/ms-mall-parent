package com.xuxx.ms.mall.goods.entity;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@ApiModel
@Accessors(chain = true)
public class TbGoodsDesc implements Serializable {
	private static final long serialVersionUID = 1211167536972891021L;

	private Long goodsId;

	private String introduction;

	private String specificationItems;

	private String customAttributeItems;

	private String itemImages;

	private String packageList;

	private String saleService;
}