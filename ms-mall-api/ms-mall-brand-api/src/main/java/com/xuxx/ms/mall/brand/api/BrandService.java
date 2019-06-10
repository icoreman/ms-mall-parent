package com.xuxx.ms.mall.brand.api;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.xuxx.ms.mall.brand.api.factories.BrandServiceFallbackFactory;
import com.xuxx.ms.mall.brand.entity.TbBrand;
import com.xuxx.ms.mall.entity.PageResult;
import com.xuxx.ms.mall.entity.Result;

/**
 * 
 * @Author: xuxx
 * @Date: Jun 10, 2019 1:51:22 PM
 *
 */
@FeignClient(value = "MS-MALL-BRAND", fallbackFactory = BrandServiceFallbackFactory.class)
public interface BrandService {
	@GetMapping("/api/v1/brands")
	public Result<List<TbBrand>> findAll();

	/**
	 * 增加
	 * 
	 * @param brand
	 */
	@PutMapping("/api/v1/brands")
	public Result<Boolean> add(TbBrand brand);

	/**
	 * 根据ID查询实体
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/api/v1/brands/{id}")
	public Result<TbBrand> findOne(@PathVariable("id") Long id);

	/**
	 * 修改
	 * 
	 * @param brand
	 */
	@PutMapping("/api/v1/brands")
	public Result<Boolean> update(TbBrand brand);

	/**
	 * 删除
	 * 
	 * @param ids
	 */
	@DeleteMapping("/api/v1/brands/{id}")
	public Result<Boolean> delete(@PathVariable("id") Long[] ids);

	/**
	 * 品牌分页，带查询条件
	 * 
	 * @param pageNum  当前页面
	 * @param pageSize 每页记录数
	 * @return
	 */
	@GetMapping("/api/v1/brands/list")
	public Result<PageResult<TbBrand>> findPage(TbBrand brand, int pageNum, int pageSize);

	/**
	 * @Title: selectOptionList
	 * @Description: 获取所有品牌，按照 select2 需要的格式，即{id:,text}
	 * @return List<Map<String,String>>
	 */
	@GetMapping("/api/v1/brands/options")
	public Result<List<Map<String, String>>> selectOptionList();
}
