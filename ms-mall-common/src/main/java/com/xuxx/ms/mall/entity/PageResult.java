package com.xuxx.ms.mall.entity;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 分页结果类
 * 
 * @author Administrator
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResult<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	private long total;// 总记录数
	private List<T> rows;// 当前页记录
}
