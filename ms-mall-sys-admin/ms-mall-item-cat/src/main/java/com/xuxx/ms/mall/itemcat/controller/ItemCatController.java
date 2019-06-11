package com.xuxx.ms.mall.itemcat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xuxx.ms.mall.entity.PageResult;
import com.xuxx.ms.mall.entity.Result;
import com.xuxx.ms.mall.itemcat.entity.TbItemCat;
import com.xuxx.ms.mall.itemcat.service.ItemCatService;

/**
 *
 *
 * @author xuxx
 * @date 2019-05-14 17:34:15
 * @since JDK 1.8
 *
 */
@RestController
public class ItemCatController {

	@Autowired
	private ItemCatService itemCatService;

	/**
	 * 返回全部列表
	 * 
	 * @return
	 */
	@GetMapping("/api/v1/itemcats")
	public Result<List<TbItemCat>> findAll() {
		List<TbItemCat> data = itemCatService.findAll();

		return Result.success(data);
	}

	/**
	 * 增加
	 * 
	 * @param itemCat
	 * @return Result<Boolean>
	 */
	@PostMapping("/api/v1/itemcats")
	public Result<Boolean> add(@RequestBody TbItemCat itemCat) {
		itemCatService.add(itemCat);
		return Result.success(true);
	}

	/**
	 * 修改
	 * 
	 * @param itemCat
	 * @return Result<Boolean>
	 */
	@PutMapping("/api/v1/itemcats")
	public Result<Boolean> update(@RequestBody TbItemCat itemCat) {

		itemCatService.update(itemCat);
		return Result.success(true);
	}

	/**
	 * 获取实体
	 * 
	 * @param id
	 * @return Result<TbItemCat>
	 */
	@GetMapping("/api/v1/itemcats/{id}")
	public Result<TbItemCat> findOne(@PathVariable("id") Long id) {
		TbItemCat data = itemCatService.findOne(id);
		return Result.success(data);
	}

	/**
	 * 批量删除
	 * 
	 * @param ids
	 * @return Result<Boolean>
	 */
	@DeleteMapping("/api/v1/itemcats/{id}")
	public Result<Boolean> delete(@PathVariable("id") Long[] ids) {
		itemCatService.delete(ids);
		return Result.success(true);
	}

	/**
	 * 查询+分页
	 * 
	 * @param brand
	 * @param page
	 * @param rows
	 * @return Result<PageResult<TbItemCat>>
	 */
	@PostMapping("/api/v1/itemcats/list")
	public Result<PageResult<TbItemCat>> search(@RequestBody TbItemCat itemCat, @RequestParam("page") int page,
			@RequestParam("rows") int rows) {
		PageResult<TbItemCat> data = itemCatService.findPage(itemCat, page, rows);

		return Result.success(data);
	}

	/**
	 * 根据上级ID查询商品分类列表
	 * 
	 * @param parentId
	 * @return Result
	 */
	@GetMapping("/api/v1/itemcats/parentId/{parentId}")
	public Result<List<TbItemCat>> findByParentId(@PathVariable("parentId") Long parentId) {
		List<TbItemCat> data = itemCatService.findByParentId(parentId);

		return Result.success(data);
	}
}