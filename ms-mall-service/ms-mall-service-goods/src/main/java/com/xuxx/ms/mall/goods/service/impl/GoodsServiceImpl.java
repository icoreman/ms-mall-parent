package com.xuxx.ms.mall.goods.service.impl;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xuxx.ms.mall.brand.api.BrandService;
import com.xuxx.ms.mall.brand.entity.TbBrand;
import com.xuxx.ms.mall.entity.PageResult;
import com.xuxx.ms.mall.goods.entity.TbGoods;
import com.xuxx.ms.mall.goods.entity.TbGoodsDesc;
import com.xuxx.ms.mall.goods.entity.TbGoodsExample;
import com.xuxx.ms.mall.goods.entity.TbGoodsExample.Criteria;
import com.xuxx.ms.mall.goods.entity.TbItem;
import com.xuxx.ms.mall.goods.entity.TbItemExample;
import com.xuxx.ms.mall.goods.mapper.TbGoodsDescMapper;
import com.xuxx.ms.mall.goods.mapper.TbGoodsMapper;
import com.xuxx.ms.mall.goods.mapper.TbItemMapper;
import com.xuxx.ms.mall.goods.service.GoodsService;
import com.xuxx.ms.mall.goods.vo.GoodsVO;
import com.xuxx.ms.mall.itemcat.api.ItemCatService;
import com.xuxx.ms.mall.itemcat.entity.TbItemCat;
import com.xuxx.ms.mall.seller.api.SellerService;
import com.xuxx.ms.mall.seller.entity.TbSeller;

/**
 * 
 *
 * @author xuxx
 * @date 2019-05-13 17:18:13
 * @since JDK 1.8
 *
 */

@Service
@Transactional
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private TbGoodsMapper goodsMapper;

	@Autowired
	private TbGoodsDescMapper goodsDescMapper;

	@Autowired
	private TbItemMapper itemMapper;

	@Autowired
	private ItemCatService itemCatService;

	@Autowired
	private BrandService brandService;

	@Autowired
	private SellerService sellerService;

	/**
	 * 查询全部
	 */
	@Override
	public List<TbGoods> findAll() {
		return goodsMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult<TbGoods> findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		Page<TbGoods> page = (Page<TbGoods>) goodsMapper.selectByExample(null);
		return new PageResult<TbGoods>(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(GoodsVO goods) {
		goods.getGoods().setAuditStatus("0");// 状态：未审核
		goodsMapper.insert(goods.getGoods());// 插入商品基本信息

		goods.getGoodsDesc().setGoodsId(goods.getGoods().getId());// 将商品基本表的ID给商品详情表
		goodsDescMapper.insert(goods.getGoodsDesc());// 插入商品详情表数据

		saveItemList(goods);
	}

	/**
	 * 修改
	 */
	@Override
	public void update(GoodsVO goods) {
		// 更新基本表数据
		goodsMapper.updateByPrimaryKey(goods.getGoods());
		// 更新扩展表数据
		goodsDescMapper.updateByPrimaryKey(goods.getGoodsDesc());

		// 删除原有的SKU列表数据
		TbItemExample example = new TbItemExample();
		TbItemExample.Criteria criteria = example.createCriteria();
		criteria.andGoodsIdEqualTo(goods.getGoods().getId());
		itemMapper.deleteByExample(example);

		// 插入新的SKU列表数据
		saveItemList(goods);// 插入SKU商品数据
	}

	/**
	 * 根据ID获取实体
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public GoodsVO findOne(Long id) {
		GoodsVO goods = new GoodsVO();
		// 商品基本表
		TbGoods tbGoods = goodsMapper.selectByPrimaryKey(id);
		goods.setGoods(tbGoods);
		// 商品扩展表
		TbGoodsDesc goodsDesc = goodsDescMapper.selectByPrimaryKey(id);
		goods.setGoodsDesc(goodsDesc);

		// 读取SKU列表

		TbItemExample example = new TbItemExample();
		TbItemExample.Criteria criteria = example.createCriteria();
		criteria.andGoodsIdEqualTo(id);
		List<TbItem> itemList = itemMapper.selectByExample(example);
		goods.setItemList(itemList);

		return goods;
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Long[] ids) {
		for (Long id : ids) {
			TbGoods goods = goodsMapper.selectByPrimaryKey(id);
			goods.setIsDelete("1");// 表示逻辑删除
			goodsMapper.updateByPrimaryKey(goods);
		}
	}

	@Override
	public PageResult<TbGoods> findPage(TbGoods goods, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);

		TbGoodsExample example = new TbGoodsExample();
		Criteria criteria = example.createCriteria();

		if (goods != null) {
			if (goods.getSellerId() != null && goods.getSellerId().length() > 0) {
				criteria.andSellerIdEqualTo(goods.getSellerId());
			}
			if (goods.getGoodsName() != null && goods.getGoodsName().length() > 0) {
				criteria.andGoodsNameLike("%" + goods.getGoodsName() + "%");
			}
			if (goods.getAuditStatus() != null && goods.getAuditStatus().length() > 0) {
				criteria.andAuditStatusLike("%" + goods.getAuditStatus() + "%");
			}
			if (goods.getIsMarketable() != null && goods.getIsMarketable().length() > 0) {
				criteria.andIsMarketableLike("%" + goods.getIsMarketable() + "%");
			}
			if (goods.getCaption() != null && goods.getCaption().length() > 0) {
				criteria.andCaptionLike("%" + goods.getCaption() + "%");
			}
			if (goods.getSmallPic() != null && goods.getSmallPic().length() > 0) {
				criteria.andSmallPicLike("%" + goods.getSmallPic() + "%");
			}
			if (goods.getIsEnableSpec() != null && goods.getIsEnableSpec().length() > 0) {
				criteria.andIsEnableSpecLike("%" + goods.getIsEnableSpec() + "%");
			}
			if (goods.getIsDelete() != null && goods.getIsDelete().length() > 0) {
				criteria.andIsDeleteLike("%" + goods.getIsDelete() + "%");
			} else {
				criteria.andIsDeleteIsNull();
			}
		}

		Page<TbGoods> page = (Page<TbGoods>) goodsMapper.selectByExample(example);
		return new PageResult<TbGoods>(page.getTotal(), page.getResult());
	}

	/**
	 * 
	 * @Title: setItemValues
	 * @Description: 封装设置 TBItem 值
	 * @param item
	 * @param goods
	 */
	private void setItemValues(TbItem item, GoodsVO goods) {
		// 商品分类
		item.setCategoryid(goods.getGoods().getCategory3Id());// 三级分类ID
		item.setCreateTime(new Date());// 创建日期
		item.setUpdateTime(new Date());// 更新日期

		item.setGoodsId(goods.getGoods().getId());// 商品ID
		item.setSellerId(goods.getGoods().getSellerId());// 商家ID

		// 分类名称
		TbItemCat itemCat = itemCatService.findOne(goods.getGoods().getCategory3Id()).getData();
		item.setCategory(itemCat.getName());
		// 品牌名称
		TbBrand brand = brandService.findOne(goods.getGoods().getBrandId()).getData();
		item.setBrand(brand.getName());
		// 商家名称(店铺名称)
		TbSeller seller = sellerService.findOne(goods.getGoods().getSellerId()).getData();
		item.setSeller(seller.getNickName());

		// 图片
		List<Map> imageList = JSON.parseArray(goods.getGoodsDesc().getItemImages(), Map.class);
		if (imageList.size() > 0) {
			item.setImage((String) imageList.get(0).get("url"));
		}
	}

	// 插入sku列表数据
	private void saveItemList(GoodsVO goods) {
		if ("1".equals(goods.getGoods().getIsEnableSpec())) {
			for (TbItem item : goods.getItemList()) {
				// 构建标题 SPU名称+ 规格选项值
				String title = goods.getGoods().getGoodsName();// SPU名称
				Map<String, Object> map = JSON.parseObject(item.getSpec());
				for (String key : map.keySet()) {
					title += " " + map.get(key);
				}
				item.setTitle(title);

				setItemValues(item, goods);

				itemMapper.insert(item);
			}
		} else {// 没有启用规格
			TbItem item = new TbItem();
			item.setTitle(goods.getGoods().getGoodsName());// 标题
			item.setPrice(goods.getGoods().getPrice());// 价格
			item.setNum(99999);// 库存数量
			item.setStatus("1");// 状态
			item.setIsDefault("1");// 默认
			item.setSpec("{}");// 规格

			setItemValues(item, goods);

			itemMapper.insert(item);
		}
	}

	@Override
	public void updateStatus(Long[] ids, String status) {
		for (Long id : ids) {
			TbGoods goods = goodsMapper.selectByPrimaryKey(id);
			goods.setAuditStatus(status);

			goodsMapper.updateByPrimaryKey(goods);
		}
	}

	@Override
	public void updateMarketableStatus(Long[] ids, String status) {
		for (Long id : ids) {
			TbGoods goods = goodsMapper.selectByPrimaryKey(id);
			goods.setIsMarketable(status);

			goodsMapper.updateByPrimaryKey(goods);
		}
	}

	@Override
	public List<TbItem> findItemListByGoodsIdListAndStatus(Long[] goodsIds, String status) {

		TbItemExample example = new TbItemExample();
		TbItemExample.Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(status);// 状态
		criteria.andGoodsIdIn(Arrays.asList(goodsIds));// 指定条件：SPUID集合

		return itemMapper.selectByExample(example);
	}
}
