package com.xuxx.ms.mall.seller.api;

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
import com.xuxx.ms.mall.seller.api.factories.SellerServiceFallbackFactory;
import com.xuxx.ms.mall.seller.entity.TbSeller;

/**
 * 
 * @author xuxx
 * @date 2019-05-13 17:55:03
 * @since JDK 1.8
 *
 */
@FeignClient(value = "MS-MALL-SELLER-SERVICE", fallbackFactory = SellerServiceFallbackFactory.class)
public interface SellerService {

	/**
	 * 返回全部列表
	 * 
	 * @return
	 */
	@GetMapping("/api/v1/sellers")
	public Result<List<TbSeller>> findAll();

	/**
	 * 增加
	 */
	@PostMapping("/api/v1/sellers")
	public Result<Boolean> add(TbSeller seller);

	/**
	 * 修改
	 */
	@PutMapping("/api/v1/sellers")
	public Result<Boolean> update(TbSeller seller);

	/**
	 * 根据ID获取实体
	 * 
	 * @param id
	 * @return Result<TbSeller>
	 */
	@GetMapping("/api/v1/sellers/{id}")
	public Result<TbSeller> findOne(@PathVariable("id") String id);

	/**
	 * 批量删除
	 * 
	 * @param ids
	 */
	@DeleteMapping("/api/v1/sellers/{id}")
	public Result<Boolean> delete(@PathVariable("id") String[] ids);

	/**
	 * 分页
	 * 
	 * @param pageNum  当前页 码
	 * @param pageSize 每页记录数
	 * @return
	 */
	@PostMapping("/api/v1/sellers/list")
	public Result<PageResult<TbSeller>> findPage(@RequestBody TbSeller seller, @RequestParam("page") int page,
			@RequestParam("rows") int rows);

	/**
	 * @Title: updateStatus
	 * @Description: 修改审核状态
	 * @param sellerId
	 * @param status
	 * @return Result<Boolean>
	 */
	@PutMapping("/api/v1/sellers/{sellerId}/{status}")
	public Result<Boolean> updateStatus(@PathVariable("sellerId") String sellerId,
			@PathVariable("status") String status);
}
