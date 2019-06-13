package com.xuxx.ms.mall.manager.controller;

import java.util.List;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xuxx.ms.mall.constants.MQConstans;
import com.xuxx.ms.mall.entity.PageResult;
import com.xuxx.ms.mall.entity.Result;
import com.xuxx.ms.mall.goods.api.GoodsService;
import com.xuxx.ms.mall.goods.entity.TbGoods;
import com.xuxx.ms.mall.goods.vo.GoodsVO;

/**
 * controller
 * 
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

	@Autowired
	private GoodsService goodsService;

	@Autowired
	private AmqpTemplate amqpTemplate;

	/**
	 * 返回全部列表
	 * 
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TbGoods> findAll() {
		return goodsService.findAll().getData();
	}

	/**
	 * 修改
	 * 
	 * @param goods
	 * @return
	 */
	@RequestMapping("/update")
	public Result<Boolean> update(@RequestBody GoodsVO goods) {
		goodsService.update(goods);
		return Result.success(true);
	}

	/**
	 * 获取实体
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/findOne")
	public GoodsVO findOne(Long id) {
		return goodsService.findOne(id).getData();
	}

	/**
	 * 批量删除
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result<Boolean> delete(Long[] ids) {
		goodsService.delete(ids);
		
		// 从索引库中删除
		amqpTemplate.convertAndSend(MQConstans.MALL_QUEUE_SOLR_DELETE_ITEM, ids);

		// 删除每个服务器上的商品详细页
		amqpTemplate.convertAndSend(MQConstans.MALL_TOPIC_FREEMARKER_DELETE_ITEM_PAGE, ids);

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
	@RequestMapping("/search")
	public PageResult<TbGoods> search(@RequestBody TbGoods goods, int page, int rows) {
		return goodsService.findPage(goods, page, rows).getData();
	}

	@RequestMapping("/updateStatus")
	public Result<Boolean> updateStatus(Long[] ids, String status) {
		goodsService.updateStatus(ids, status);
		return Result.success(true);
	}

	@RequestMapping("/genHtml")
	public void genHtml(Long goodsId) {

	}
}
