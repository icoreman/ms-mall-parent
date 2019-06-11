package com.xuxx.ms.mall.manager.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xuxx.ms.mall.brand.api.BrandService;
import com.xuxx.ms.mall.brand.entity.TbBrand;
import com.xuxx.ms.mall.entity.PageResult;
import com.xuxx.ms.mall.entity.Result;

/**
 * 
 * @ClassName: BrandController
 *
 * @author xuxx
 * @date 2019-05-13 14:55:26
 * @since JDK 1.8
 *
 */
@RestController
@RequestMapping("/brand")
public class BrandController {

	@Autowired
	private BrandService brandService;

	@RequestMapping("/findAll")
	public List<TbBrand> findAll() {
		return brandService.findAll().getData();
	}

	@RequestMapping("/add")
	public Result<Boolean> add(@RequestBody TbBrand brand) {
		return brandService.add(brand);
	}

	@RequestMapping("/findOne")
	public TbBrand findOne(Long id) {
		return brandService.findOne(id).getData();
	}

	@RequestMapping("/update")
	public Result<Boolean> update(@RequestBody TbBrand brand) {

		return brandService.update(brand);
	}

	@RequestMapping("/delete")
	public Result<Boolean> delete(Long[] ids) {
		return brandService.delete(ids);
	}

	@RequestMapping("/search")
	public PageResult<TbBrand> search(@RequestBody TbBrand brand, int page, int rows) {
		return brandService.findPage(brand, page, rows).getData();
	}

	/**
	 * 
	 * @Title: selectOptionList
	 * @Description: 获取所有品牌，按照 select2 需要的格式，即{id:,text}
	 * @return List<Map>
	 */
	@RequestMapping("/selectOptionList")
	public List<Map<String, String>> selectOptionList() {
		return brandService.selectOptionList().getData();
	}
}
