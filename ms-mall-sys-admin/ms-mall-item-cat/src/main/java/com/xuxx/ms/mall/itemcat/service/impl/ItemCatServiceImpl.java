package com.xuxx.ms.mall.itemcat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xuxx.ms.mall.entity.PageResult;
import com.xuxx.ms.mall.itemcat.entity.TbItemCat;
import com.xuxx.ms.mall.itemcat.entity.TbItemCatExample;
import com.xuxx.ms.mall.itemcat.entity.TbItemCatExample.Criteria;
import com.xuxx.ms.mall.itemcat.mapper.TbItemCatMapper;
import com.xuxx.ms.mall.itemcat.service.ItemCatService;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @ClassName: ItemCatServiceImpl
 *
 * @author xuxx
 * @date 2019-05-13 17:18:51
 * @since JDK 1.8
 *
 */
@Slf4j
@Service
@Transactional
public class ItemCatServiceImpl implements ItemCatService {

	@Autowired
	private TbItemCatMapper itemCatMapper;

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	/**
	 * 查询全部
	 */
	@Override
	public List<TbItemCat> findAll() {
		return itemCatMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult<TbItemCat> findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		Page<TbItemCat> page = (Page<TbItemCat>) itemCatMapper.selectByExample(null);
		return new PageResult<TbItemCat>(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TbItemCat itemCat) {
		itemCatMapper.insert(itemCat);
	}

	/**
	 * 修改
	 */
	@Override
	public void update(TbItemCat itemCat) {
		itemCatMapper.updateByPrimaryKey(itemCat);
	}

	/**
	 * 根据ID获取实体
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public TbItemCat findOne(Long id) {
		return itemCatMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Long[] ids) {
		for (Long id : ids) {
			itemCatMapper.deleteByPrimaryKey(id);
		}
	}

	@Override
	public PageResult<TbItemCat> findPage(TbItemCat itemCat, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);

		TbItemCatExample example = new TbItemCatExample();
		Criteria criteria = example.createCriteria();

		if (itemCat != null) {
			if (itemCat.getName() != null && itemCat.getName().length() > 0) {
				criteria.andNameLike("%" + itemCat.getName() + "%");
			}
		}

		Page<TbItemCat> page = (Page<TbItemCat>) itemCatMapper.selectByExample(example);
		return new PageResult<TbItemCat>(page.getTotal(), page.getResult());
	}

	@Override
	public List<TbItemCat> findByParentId(Long parentId) {
		TbItemCatExample example = new TbItemCatExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);

		// 将模板ID放入缓存（以商品分类名称作为key）
		log.info("缓存商品分类");
		List<TbItemCat> itemCatList = findAll();
		for (TbItemCat itemCat : itemCatList) {
			redisTemplate.boundHashOps("itemCat").put(itemCat.getName(), itemCat.getTypeId());
		}

		return itemCatMapper.selectByExample(example);
	}
}
