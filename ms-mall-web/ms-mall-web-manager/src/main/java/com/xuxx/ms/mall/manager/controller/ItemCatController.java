package com.xuxx.ms.mall.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xuxx.ms.mall.entity.PageResult;
import com.xuxx.ms.mall.entity.Result;
import com.xuxx.ms.mall.itemcat.api.ItemCatService;
import com.xuxx.ms.mall.itemcat.entity.TbItemCat;

/**
 * 
 * @ClassName: ItemCatController
 *
 * @author xuxx
 * @date 2019-05-14 17:34:15
 * @since JDK 1.8
 *
 */
@RestController
@RequestMapping("/itemCat")
public class ItemCatController {

	@Autowired
	private ItemCatService itemCatService;

	/**
	 * 返回全部列表
	 * 
	 * @return List<TbItemCat>
	 */
	@RequestMapping("/findAll")
	public List<TbItemCat> findAll() {
		return itemCatService.findAll().getData();
	}

	/**
	 * 增加
	 * 
	 * @param itemCat
	 * @return
	 */
	@RequestMapping("/add")
	public Result<Boolean> add(@RequestBody TbItemCat itemCat) {
		itemCatService.add(itemCat);

		return Result.success(true);
	}

	/**
	 * 修改
	 * 
	 * @param itemCat
	 * @return
	 */
	@RequestMapping("/update")
	public Result<Boolean> update(@RequestBody TbItemCat itemCat) {
		itemCatService.update(itemCat);
		return Result.success(true);
	}

	/**
	 * 获取实体
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/findOne")
	public TbItemCat findOne(Long id) {
		return itemCatService.findOne(id).getData();
	}

	/**
	 * 批量删除
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result<Boolean> delete(Long[] ids) {
		itemCatService.delete(ids);
		return Result.success(true);
	}

	/**
	 * 查询+分页
	 * 
	 * @param brand
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/search")
	public PageResult<TbItemCat> search(@RequestBody TbItemCat itemCat, int page, int rows) {
		return itemCatService.findPage(itemCat, page, rows).getData();
	}

	/**
	 * 根据上级ID查询商品分类列表
	 * 
	 * @param parentId
	 * @return
	 */
	@RequestMapping("/findByParentId")
	public List<TbItemCat> findByParentId(Long parentId) {
		return itemCatService.findByParentId(parentId).getData();
	}
}