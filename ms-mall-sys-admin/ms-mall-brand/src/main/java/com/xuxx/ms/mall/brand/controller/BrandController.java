package com.xuxx.ms.mall.brand.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xuxx.ms.mall.brand.entity.TbBrand;
import com.xuxx.ms.mall.brand.service.BrandService;
import com.xuxx.ms.mall.entity.PageResult;
import com.xuxx.ms.mall.entity.Result;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class BrandController {
	private final BrandService brandService;

	@GetMapping("/api/v1/brands")
	public Result<List<TbBrand>> findAll() {
		List<TbBrand> data = brandService.findAll();
		return Result.success(data);
	}

	/**
	 * 增加
	 * 
	 * @param brand
	 */
	@PutMapping("/api/v1/brands")
	public Result<Boolean> add(TbBrand brand) {
		brandService.add(brand);

		return Result.success(true);
	}

	/**
	 * 根据ID查询实体
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/api/v1/brands/{id}")
	public Result<TbBrand> findOne(@PathVariable("id") Long id) {
		TbBrand tbBrand = brandService.findOne(id);

		return Result.success(tbBrand);
	}

	/**
	 * 修改
	 * 
	 * @param brand
	 */
	@PutMapping("/api/v1/brands/")
	public Result<Boolean> update(TbBrand brand) {
		brandService.update(brand);

		return Result.success(true);
	}

	/**
	 * 删除
	 * 
	 * @param ids
	 */
	@DeleteMapping("/api/v1/brands/{id}")
	public Result<Boolean> delete(@PathVariable("id") Long[] ids) {
		brandService.delete(ids);

		return Result.success(true);
	}

	/**
	 * 品牌分页
	 * 
	 * @param pageNum  当前页面
	 * @param pageSize 每页记录数
	 * @return
	 */
	
	@GetMapping("/api/v1/brands/list")
	public Result<PageResult<TbBrand>> findPage(TbBrand brand, int pageNum, int pageSize) {
		PageResult<TbBrand> pageResult = brandService.findPage(brand, pageNum, pageSize);

		return Result.success(pageResult);
	}

	/**
	 * @Title: selectOptionList
	 * @Description: 获取所有品牌，按照 select2 需要的格式，即{id:,text}
	 * @return List<Map<String,String>>
	 */
	@GetMapping("/api/v1/brands/options")
	public Result<List<Map<String, String>>> selectOptionList() {
		List<Map<String, String>> options = brandService.selectOptionList();
		
		return Result.success(options);
	}
}
