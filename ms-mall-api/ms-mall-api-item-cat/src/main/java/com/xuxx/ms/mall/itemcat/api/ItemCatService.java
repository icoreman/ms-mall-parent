package com.xuxx.ms.mall.itemcat.api;
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
import com.xuxx.ms.mall.itemcat.api.fallback.ItemCatServiceFallback;
import com.xuxx.ms.mall.itemcat.entity.TbItemCat;

/**
 * 
 *
 * @author xuxx
 * @date 2019-05-13 17:11:58
 * @since  JDK 1.8
 *
 */
@FeignClient(value = "MS-MALL-ITEM-CAT-SERVICE", fallbackFactory = ItemCatServiceFallback.class)
public interface ItemCatService {

	/**
	 * 返回全部列表
	 * @return
	 */
	@GetMapping("/api/v1/itemcats")
	public Result<List<TbItemCat>> findAll();
	
	
	/**
	 * 增加
	*/
	@PostMapping("/api/v1/itemcats")
	public Result<Boolean> add(TbItemCat itemCat);
	
	
	/**
	 * 修改
	 */
	@PutMapping("/api/v1/itemcats")
	public Result<Boolean> update(TbItemCat itemCat);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return Result<TbItemCat>
	 */
	@GetMapping("/api/v1/itemcats/{id}")
	public Result<TbItemCat> findOne(@PathVariable("id")Long id);
	
	
	/**
	 * 批量删除
	 * @param ids
	 */
	@DeleteMapping("/api/v1/itemcats/{id}")
	public Result<Boolean> delete(@PathVariable("id") Long [] ids);

	/**
	 * 分页
	 * @param pageNum 当前页 码
	 * @param pageSize 每页记录数
	 * @return Result<PageResult<TbItemCat>>
	 */
	@PostMapping("/api/v1/itemcats/list")
	public Result<PageResult<TbItemCat>> findPage(@RequestBody TbItemCat itemCat,  @RequestParam("page") int page,
			@RequestParam("rows") int rows);
	
	/**
	 * 根据上级ID查询商品分类列表
	 * @param parentId
	 * @return Result<List<TbItemCat>>
	 */
	@GetMapping("/api/v1/itemcats/parentId/{parentId}")
	public Result<List<TbItemCat>> findByParentId(@PathVariable("parentId") Long parentId);
}
