package com.xuxx.ms.mall.manager.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
 * @date 2019-05-14 09:59:29
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
	 * @return List<TbSeller>
	 */
	@RequestMapping("/findAll")
	public List<TbSeller> findAll() {
		return sellerService.findAll().getData();
	}

	/**
	 * 增加
	 * 
	 * @param seller
	 * @return Result<Boolean>
	 */
	@RequestMapping("/add")
	public Result<Boolean> add(@RequestBody TbSeller seller) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		seller.setPassword(passwordEncoder.encode(seller.getPassword()));

		sellerService.add(seller);
		return Result.success(true);
	}

	/**
	 * 修改
	 * 
	 * @param seller
	 * @return Result<Boolean>
	 */
	@RequestMapping("/update")
	public Result<Boolean> update(@RequestBody TbSeller seller) {
		sellerService.update(seller);
		return Result.success(true);
	}

	/**
	 * 获取实体
	 * 
	 * @param id
	 * @return TbSeller
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
		sellerService.delete(ids);
		return Result.success(true);
	}

	/**
	 * 查询+分页
	 * 
	 * @param brand
	 * @param page
	 * @param rows
	 * @return PageResult<TbSeller>
	 */
	@RequestMapping("/search")
	public PageResult<TbSeller> search(@RequestBody TbSeller seller, int page, int rows) {
		return sellerService.findPage(seller, page, rows).getData();
	}

	@RequestMapping("/name")
	public Map<String, String> name() {
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		Map<String, String> map = new HashMap<String, String>();
		map.put("loginName", name);

		return map;
	}
}
