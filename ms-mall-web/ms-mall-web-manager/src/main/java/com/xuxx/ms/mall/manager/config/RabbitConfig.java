package com.xuxx.ms.mall.manager.config;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.xuxx.ms.mall.constants.MQConstans;


@Configuration
public class RabbitConfig {
	@Bean
	public Queue mallQueueSolrAddItem() {
		return new Queue(MQConstans.MALL_QUEUE_SOLR_ADD_ITEM, true);
	}
	
	@Bean
	public Queue mallQueueSolrDeleteItem() {
		return new Queue(MQConstans.MALL_QUEUE_SOLR_DELETE_ITEM, true);
	}
	
	public TopicExchange topicExchange() {
        return new TopicExchange(MQConstans.MALL_EXCHANGE_ITEM_TOPIC);
    }
	
	@Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange(MQConstans.MALL_EXCHANGE_ITEM_FANOUT);
    }
}
