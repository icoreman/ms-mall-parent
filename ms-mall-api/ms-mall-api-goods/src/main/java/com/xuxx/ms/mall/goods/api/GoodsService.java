package com.xuxx.ms.mall.goods.api;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.xuxx.ms.mall.entity.PageResult;
import com.xuxx.ms.mall.entity.Result;
import com.xuxx.ms.mall.goods.api.factories.GoodsServiceFallbackFactory;
import com.xuxx.ms.mall.goods.entity.TbGoods;
import com.xuxx.ms.mall.goods.entity.TbItem;
import com.xuxx.ms.mall.goods.vo.GoodsVO;

/**
 * 
 *
 * @author xuxx
 * @date 2019-05-13 17:11:51
 * @since JDK 1.8
 *
 */
@FeignClient(value = "MS-MALL-GOODS-SERVICE", fallbackFactory = GoodsServiceFallbackFactory.class)
public interface GoodsService {

	/**
	 * 返回全部列表
	 * 
	 * @return
	 */
	@GetMapping("/api/v1/goods")
	public Result<List<TbGoods>> findAll();

	/**
	 * 增加
	 */
	@PostMapping("/api/v1/goods")
	public Result<Boolean> add(GoodsVO goods);

	/**
	 * 修改
	 */
	@PutMapping("/api/v1/goods")
	public Result<Boolean> update(GoodsVO goods);

	/**
	 * 根据ID获取实体
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/api/v1/goods/{id}")
	public Result<GoodsVO> findOne(@PathVariable("id") Long id);

	/**
	 * 批量删除
	 * 
	 * @param ids
	 */
	@DeleteMapping("/api/v1/goods/{id}")
	public Result<Boolean> delete(@PathVariable("id") Long[] ids);

	/**
	 * 分页
	 * 
	 * @param pageNum  当前页 码
	 * @param pageSize 每页记录数
	 * @return
	 */
	@PostMapping("/api/v1/goods/list")
	public Result<PageResult<TbGoods>> findPage(@RequestBody TbGoods goods, @RequestParam("page") int pageNum,
			@RequestParam("rows") int pageSize);

	/**
	 * @Title: updateStatus
	 * @Description: 批量修改状态
	 * @param ids
	 * @param status
	 */
	@PutMapping("/api/v1/goods/{status}/{ids}")
	public Result<Boolean> updateStatus(@PathVariable("ids") Long[] ids, @PathVariable("status") String status);

	/**
	 * @Title: updateMarketableStatus
	 * @Description: 修改上架状态，1为上架，0为下架
	 * @param ids
	 * @param status
	 */
	@PutMapping("/api/v1/goods/market/{status}/{ids}")
	public Result<Boolean> updateMarketableStatus(@PathVariable("ids") Long[] ids, @PathVariable("status") String status);

	/**
	 * 
	 * @Title: findItemListByGoodsIdListAndStatus
	 * @Description: 通过 spu 的 goodsId 和 status 找到 sku 的商品集合
	 * @param goodsIds
	 * @param status
	 * @return List<TbItem>
	 */
	@GetMapping("/api/v1/goods/items/{status}/{goodsIds}")
	public Result<List<TbItem>> findItemListByGoodsIdListAndStatus(@PathVariable("goodsIds") Long[] goodsIds,
			@PathVariable("status") String status);
}
