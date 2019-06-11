package com.xuxx.ms.mall.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xuxx.ms.mall.entity.PageResult;
import com.xuxx.ms.mall.entity.Result;
import com.xuxx.ms.mall.seller.api.SellerService;
import com.xuxx.ms.mall.seller.entity.TbSeller;

/**
 * 
 * @ClassName: SellerController
 *
 * @author xuxx
 * @date 2019-05-14 14:44:48
 * @since JDK 1.8
 *
 */
@RestController
@RequestMapping("/seller")
public class SellerController {

	@Autowired
	private SellerService sellerService;

	/**
	 * 返回全部列表
	 * 
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TbSeller> findAll() {
		return sellerService.findAll().getData();
	}

	/**
	 * 增加
	 * 
	 * @param seller
	 * @return
	 */
	@RequestMapping("/add")
	public Result<Boolean> add(@RequestBody TbSeller seller) {
		return	sellerService.add(seller);
	}

	/**
	 * 修改
	 * 
	 * @param seller
	 * @return
	 */
	@RequestMapping("/update")
	public Result<Boolean> update(@RequestBody TbSeller seller) {
		return	sellerService.update(seller);
	}

	/**
	 * 获取实体
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/findOne")
	public TbSeller findOne(String id) {
		return sellerService.findOne(id).getData();
	}

	/**
	 * 批量删除
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result<Boolean> delete(String[] ids) {
		return	sellerService.delete(ids);
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
	public PageResult<TbSeller> search(@RequestBody TbSeller seller, int page, int rows) {
		return sellerService.findPage(seller, page, rows).getData();
	}

	@RequestMapping("/updateStatus")
	public Result<Boolean> updateStatus(String sellerId, String status) {
		return	sellerService.updateStatus(sellerId, status);
	}

}
