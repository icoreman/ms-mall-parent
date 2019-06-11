package com.xuxx.ms.mall.seller.entity;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@ApiModel
@Accessors(chain = true)
public class TbSeller implements Serializable{
	private static final long serialVersionUID = -7072170346099175316L;

	@ApiModelProperty("商家id")
	private String sellerId;

	@ApiModelProperty("商家姓名")
    private String name;

	@ApiModelProperty("商家昵称")
    private String nickName;

	@ApiModelProperty("商家密码")
    private String password;

	@ApiModelProperty("商家邮件")
    private String email;

	@ApiModelProperty("商家手机")
    private String mobile;

	@ApiModelProperty("商家手机2")
    private String telephone;

	@ApiModelProperty("商家状态 审核 正常 禁用")
    private String status;

	@ApiModelProperty("商家详细地址")
    private String addressDetail;

	@ApiModelProperty("联系人姓名")
    private String linkmanName;

	@ApiModelProperty("联系人QQ")
    private String linkmanQq;

	@ApiModelProperty("联系人手机")
    private String linkmanMobile;

	@ApiModelProperty("联系人邮箱")
    private String linkmanEmail;

	@ApiModelProperty("营业执照")
    private String licenseNumber;

	@ApiModelProperty("纳税号码")
    private String taxNumber;

	@ApiModelProperty("组织机构号码")
    private String orgNumber;

	@ApiModelProperty(value="公司地址", example = "0")
    private Long address;

	@ApiModelProperty("logo")
    private String logoPic;

	@ApiModelProperty("简介")
    private String brief;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("法人")
    private String legalPerson;

    @ApiModelProperty("法人id")
    private String legalPersonCardId;

    @ApiModelProperty("银行人姓名")
    private String bankUser;

    @ApiModelProperty("银行名称")
    private String bankName;
}