package com.xuxx.ms.mall.seller.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xuxx.ms.mall.constants.CodeMsgConstants;
import com.xuxx.ms.mall.entity.PageResult;
import com.xuxx.ms.mall.entity.Result;
import com.xuxx.ms.mall.goods.api.GoodsService;
import com.xuxx.ms.mall.goods.entity.TbGoods;
import com.xuxx.ms.mall.goods.vo.GoodsVO;

/**
 * controller
 * 
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

	@Autowired
	private GoodsService goodsService;

	/**
	 * 返回全部列表
	 * 
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TbGoods> findAll() {
		return goodsService.findAll().getData();
	}

	/**
	 * 增加
	 * 
	 * @param goods
	 * @return
	 */
	@RequestMapping("/add")
	public Result<Boolean> add(@RequestBody GoodsVO goods) {
		// 获取商家ID
		String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
		goods.getGoods().setSellerId(sellerId);// 设置商家ID

		goodsService.add(goods);
		return Result.success(true);
	}

	/**
	 * 修改
	 * 
	 * @param goods
	 * @return
	 */
	@RequestMapping("/update")
	public Result<Boolean> update(@RequestBody GoodsVO goods) {
		// 当前商家ID
		String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();

		// 首先判断商品是否是该商家的商品
		Result<GoodsVO> data = goodsService.findOne(goods.getGoods().getId());
		if (data != null && !data.getData().getGoods().getSellerId().equals(sellerId) || !goods.getGoods().getSellerId().equals(sellerId)) {
			return Result.error(CodeMsgConstants.REQUEST_ILLEGAL);
		}

		goodsService.update(goods);
		return Result.success(true);
	}

	/**
	 * 获取实体
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/findOne")
	public GoodsVO findOne(Long id) {
		return goodsService.findOne(id).getData();
	}

	/**
	 * 批量删除
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result<Boolean> delete(Long[] ids) {
		goodsService.delete(ids);
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
	public PageResult<TbGoods> search(@RequestBody TbGoods goods, int page, int rows) {
		// 获取商家ID
		String sellerId = SecurityContextHolder.getContext().getAuthentication().getName();
		goods.setSellerId(sellerId);

		return goodsService.findPage(goods, page, rows).getData();
	}

	@RequestMapping("/updateMarketableStatus")
	public Result<Boolean> updateMarketableStatus(Long[] ids, String status) {
		goodsService.updateMarketableStatus(ids, status);
		return Result.success(true);
	}

}
