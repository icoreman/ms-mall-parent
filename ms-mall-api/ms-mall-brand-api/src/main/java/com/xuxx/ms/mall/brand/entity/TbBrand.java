package com.xuxx.ms.mall.brand.entity;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ApiModel
public class TbBrand implements Serializable{
	private static final long serialVersionUID = 5679546559834241865L;
	
	@ApiModelProperty("id")
	private Long id;

	@ApiModelProperty("品牌名称")
    private String name;

	@ApiModelProperty("首字母简写")
    private String firstChar;
}