package com.xuxx.ms.mall.seller.service;
import java.util.List;

import com.xuxx.ms.mall.entity.PageResult;
import com.xuxx.ms.mall.seller.entity.TbSeller;

/**
 * 
 * @ClassName: SellerService
 *
 * @author xuxx
 * @date 2019-05-13 17:55:03
 * @since  JDK 1.8
 *
 */
public interface SellerService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<TbSeller> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public PageResult<TbSeller> findPage(int pageNum,int pageSize);
	
	
	/**
	 * 增加
	*/
	public void add(TbSeller seller);
	
	
	/**
	 * 修改
	 */
	public void update(TbSeller seller);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public TbSeller findOne(String id);
	
	
	/**
	 * 批量删除
	 * @param ids
	 */
	public void delete(String [] ids);

	/**
	 * 分页
	 * @param pageNum 当前页 码
	 * @param pageSize 每页记录数
	 * @return
	 */
	public PageResult<TbSeller> findPage(TbSeller seller, int pageNum,int pageSize);


	/** 
	 * @Title: updateStatus 
	 * @Description: 修改审核状态
	 * @param sellerId
 	 * @param status 
	 * @return void 
	 */
	public void updateStatus(String sellerId, String status);
}
