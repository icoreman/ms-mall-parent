package com.xuxx.ms.mall.goods.controller;

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
import com.xuxx.ms.mall.goods.entity.TbGoods;
import com.xuxx.ms.mall.goods.service.GoodsService;
import com.xuxx.ms.mall.goods.vo.GoodsVO;

/**
 * controller
 * 
 * @author Administrator
 *
 */
@RestController
public class GoodsController {

	@Autowired
	private GoodsService goodsService;

	/**
	 * 返回全部列表
	 *  
	 * @return Result<List<TbGoods>>
	 */
	@GetMapping("/api/v1/goods")
	public Result<List<TbGoods>> findAll() {
		List<TbGoods> data = goodsService.findAll();
		return Result.success(data);
	}

	/**
	 * 增加
	 */
	@PostMapping("/api/v1/goods")
	public Result<Boolean> add(@RequestBody GoodsVO goods) {
		goodsService.add(goods);
		return Result.success(true);
	}

	/**
	 * 修改
	 * 
	 * @param goods
	 * @return
	 */
	@PutMapping("/api/v1/goods")
	public Result<Boolean> update(@RequestBody GoodsVO goods) {
		goodsService.update(goods);
		return Result.success(true);
	}

	/**
	 * 获取实体
	 * 
	 * @param id
	 * @return TbGoods
	 */
	@GetMapping("/api/v1/goods/{id}")
	public Result<GoodsVO> findOne(@PathVariable("id") Long id) {
		GoodsVO data = goodsService.findOne(id);
		return Result.success(data);
	}

	/**
	 * 批量删除
	 * 
	 * @param ids
	 * @return TbGoods
	 */
	@DeleteMapping("/api/v1/goods/{id}")
	public Result<Boolean> delete(@PathVariable("id") Long[] ids) {
		goodsService.delete(ids);
		return Result.success(true);
	}

	/**
	 * 查询+分页
	 * 
	 * @param brand
	 * @param page
	 * @param rows
	 * @return Result<PageResult<TbGoods>>
	 */
	@PostMapping("/api/v1/goods/list")
	public Result<PageResult<TbGoods>> search(@RequestBody TbGoods goods, @RequestParam("page") int pageNum,
			@RequestParam("rows") int pageSize) {
		PageResult<TbGoods> data = goodsService.findPage(goods, pageNum, pageSize);
		return Result.success(data);
	}

	@PutMapping("/api/v1/goods/{status}/{ids}")
	public Result<Boolean> updateStatus(@PathVariable("ids") Long[] ids, @PathVariable("status") String status) {
		goodsService.updateStatus(ids, status);

		return Result.success(true);
	}
}
