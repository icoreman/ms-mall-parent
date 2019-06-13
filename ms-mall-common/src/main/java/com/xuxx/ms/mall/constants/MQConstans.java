package com.xuxx.ms.mall.constants;

/**
 * 
 * 消息队列的常量
 * 
 * @Author: xuxx
 * @Date: Jun 13, 2019 10:24:04 AM
 *
 */
public interface MQConstans {
	/**
	 * 队列，上架商品，添加 solr 中索引
	 */
	String MALL_QUEUE_SOLR_ADD_ITEM = "mall_queue_solr_add_item";

	/**
	 * 队列，下架商品，删除 solr 中索引
	 */
	String MALL_QUEUE_SOLR_DELETE_ITEM = "mall_queue_solr_delete_item";

	/**
	 * 主题，商品审核通过，生成商品详细页
	 */
	String MALL_TOPIC_FREEMARKER_CREATE_ITEM_PAGE = "mall_topic_freemarker_create_item_page";

	/**
	 * 主题，商品删除，删除商品详情页
	 */
	String MALL_TOPIC_FREEMARKER_DELETE_ITEM_PAGE = "mall_topic_freemarker_delete_item_page";

	/**
	 * item topic exchange
	 */
	String MALL_EXCHANGE_ITEM_TOPIC = "mall_exchange_item_topic";
	
	
	/**
	 * item fanout exchange
	 */
	String MALL_EXCHANGE_ITEM_FANOUT = "mall_exchange_item_fanout";
}
