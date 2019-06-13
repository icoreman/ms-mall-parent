package com.xuxx.ms.mall.goods.vo;

import java.io.Serializable;
import java.util.List;

import com.xuxx.ms.mall.goods.entity.TbGoods;
import com.xuxx.ms.mall.goods.entity.TbGoodsDesc;
import com.xuxx.ms.mall.goods.entity.TbItem;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 商品组合实体类
 * 
 * @author xuxx
 *
 */

@Data
@ApiModel
@Accessors(chain = true)
public class GoodsVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "商品SPU基本信息")
	private TbGoods goods;
	
	@ApiModelProperty("商品SPU扩展信息")
	private TbGoodsDesc goodsDesc;

	@ApiModelProperty("SKU列表")
	private List<TbItem> itemList;
}
