package com.xuxx.ms.mall.seller.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xuxx.ms.mall.constants.CodeMsgConstants;
import com.xuxx.ms.mall.entity.PageResult;
import com.xuxx.ms.mall.entity.Result;
import com.xuxx.ms.mall.seller.entity.TbSeller;
import com.xuxx.ms.mall.seller.service.SellerService;

/**
 * 
 * @author xuxx
 * @date 2019-05-14 14:44:48
 * @since JDK 1.8
 *
 */
@RestController
public class SellerController {

	@Autowired
	private SellerService sellerService;

	/**
	 * 返回全部列表
	 * 
	 * @return
	 */
	@GetMapping("/api/v1/sellers")
	public Result<List<TbSeller>> findAll() {
		return Result.success(sellerService.findAll());
	}

	/**
	 * 增加
	 * 
	 * @param seller
	 * @return
	 */
	@PostMapping("/api/v1/sellers")
	public Result<Boolean> add(@RequestBody TbSeller seller) {
		sellerService.add(seller);

		return Result.success(true);
	}

	/**
	 * 修改
	 * 
	 * @param seller
	 * @return
	 */
	@PutMapping("/api/v1/sellers")
	public Result<Boolean> update(@RequestBody TbSeller seller) {
		if (StringUtils.isBlank(seller.getSellerId())) {
			return Result.error(CodeMsgConstants.ID_ILLEGAL);
		}
		sellerService.update(seller);

		return Result.success(true);
	}

	/**
	 * 获取实体
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/api/v1/sellers/{id}")
	public Result<TbSeller> findOne(@PathVariable("id") String id) {
		TbSeller data = sellerService.findOne(id);
		if (data == null || StringUtils.isBlank(data.getSellerId())) {
			return Result.error(CodeMsgConstants.ID_ILLEGAL);
		}
		return Result.success(data);
	}

	/**
	 * 批量删除
	 * 
	 * @param ids
	 * @return
	 */
	@DeleteMapping("/api/v1/sellers/{id}")
	public Result<Boolean> delete(@PathVariable("id") String[] ids) {
		sellerService.delete(ids);
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
	@PostMapping("/api/v1/sellers/list")
	public Result<PageResult<TbSeller>> search(@RequestBody TbSeller seller, @RequestParam("page") int page,
			@RequestParam("rows") int rows) {
		PageResult<TbSeller> data = sellerService.findPage(seller, page, rows);

		return Result.success(data);
	}

	@PutMapping("/api/v1/sellers/{sellerId}/{status}")
	public Result<Boolean> updateStatus(@PathVariable("sellerId") String sellerId, @PathVariable("status") String status) {
		sellerService.updateStatus(sellerId, status);
		return Result.success(true);
	}
}
