package com.xuxx.ms.mall.specification.entity;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@ApiModel
@Accessors(chain = true)
public class TbSpecification implements Serializable{
	private static final long serialVersionUID = 1330619986702492458L;

	@ApiModelProperty("id")
	private Long id;

	@ApiModelProperty("规格名字")
    private String specName;
}