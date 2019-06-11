package com.xuxx.ms.mall.itemcat.entity;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@ApiModel
@Accessors(chain = true)
public class TbItemCat implements Serializable{
	private static final long serialVersionUID = -7858719266215164556L;
	
	@ApiModelProperty("分类id")
	private Long id;

	@ApiModelProperty("分类父id")
    private Long parentId;

	@ApiModelProperty("分类名称")
    private String name;

	@ApiModelProperty("类别id")
    private Long typeId;
}