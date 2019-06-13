package com.xuxx.ms.mall.itemcat.service;

import java.util.List;

import com.xuxx.ms.mall.entity.PageResult;
import com.xuxx.ms.mall.itemcat.entity.TbItemCat;

/**
 *
 * @author xuxx
 * @date 2019-05-13 17:11:58
 * @since JDK 1.8
 *
 */
public interface ItemCatService {

	/**
	 * 返回全部列表
	 * 
	 * @return
	 */
	public List<TbItemCat> findAll();

	/**
	 * 返回分页列表
	 * 
	 * @return
	 */
	public PageResult<TbItemCat> findPage(int pageNum, int pageSize);

	/**
	 * 增加
	 */
	public void add(TbItemCat itemCat);

	/**
	 * 修改
	 */
	public void update(TbItemCat itemCat);

	/**
	 * 根据ID获取实体
	 * 
	 * @param id
	 * @return
	 */
	public TbItemCat findOne(Long id);

	/**
	 * 批量删除
	 * 
	 * @param ids
	 */
	public void delete(Long[] ids);

	/**
	 * 分页
	 * 
	 * @param pageNum  当前页 码
	 * @param pageSize 每页记录数
	 * @return
	 */
	public PageResult<TbItemCat> findPage(TbItemCat itemCat, int pageNum, int pageSize);

	/**
	 * 根据上级ID查询商品分类列表
	 * 
	 * @param parentId
	 * @return
	 */
	public List<TbItemCat> findByParentId(Long parentId);
}
