package com.xuxx.ms.mall.specification.entity;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@ApiModel
@Accessors(chain = true)
public class TbSpecificationOption implements Serializable{
	private static final long serialVersionUID = -6654146905020839130L;
	
	@ApiModelProperty("id")
	private Long id;

	@ApiModelProperty("规格选项名称")
    private String optionName;

	@ApiModelProperty("规格id")
    private Long specId;

	@ApiModelProperty("排序")
    private Integer orders;
}