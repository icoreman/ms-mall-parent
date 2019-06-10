package com.xuxx.ms.mall.specification.vo;

import java.io.Serializable;
import java.util.List;

import com.xuxx.ms.mall.specification.entity.TbSpecification;
import com.xuxx.ms.mall.specification.entity.TbSpecificationOption;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @ClassName: SpecificationVO
 *
 * @author xuxx
 * @date 2019-05-13 17:23:25
 * @since JDK 1.8
 *
 */
@Data
@ApiModel
@Accessors(chain = true)
public class SpecificationVO implements Serializable {
	private static final long serialVersionUID = 697832553619765114L;
	
	@ApiModelProperty("规则")
	private TbSpecification specification;

	@ApiModelProperty("规则选项")
	private List<TbSpecificationOption> specificationOptionList;
}
