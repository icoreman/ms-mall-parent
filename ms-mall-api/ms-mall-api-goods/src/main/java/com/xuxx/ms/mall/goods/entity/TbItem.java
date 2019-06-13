package com.xuxx.ms.mall.goods.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@ApiModel
@Accessors(chain = true)
public class TbItem implements Serializable{
	private static final long serialVersionUID = -2574191309090783979L;

	private Long id;

    private String title;

    private String sellPoint;

    private BigDecimal price;

    private Integer stockCount;

    private Integer num;

    private String barcode;

    private String image;

    private Long categoryid;

    private String status;

    private Date createTime;

    private Date updateTime;

    private String itemSn;

    private BigDecimal costPirce;

    private BigDecimal marketPrice;

    private String isDefault;

    private Long goodsId;

    private String sellerId;

    private String cartThumbnail;

    private String category;

    private String brand;

    private String spec;

    private String seller;
    
    private Map<String,String> specMap;
}