package com.xuxx.ms.mall.typetemplate.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@ApiModel
@Accessors(chain = true)
public class TbTypeTemplate implements Serializable{
    private static final long serialVersionUID = 991258594355256911L;

    @ApiModelProperty(value="id", example = "1")
    private Long id;

    @ApiModelProperty(value="模板名称", example = "电视")
    private String name;

    @ApiModelProperty(value = "规格，用 json 存储", example = "[{\"id\":33,\"text\":\"电视屏幕尺寸\"}]")
    private String specIds;

    @ApiModelProperty(value="品牌，用 json 存储，格式 id: text: ", example = "[{\"id\":1,\"text\":\"联想\"}]")
    private String brandIds;

    @ApiModelProperty(value="扩展属性", example = "[{\"text\":\"内存大小\"},{\"text\":\"颜色\"}]")
    private String customAttributeItems;
}