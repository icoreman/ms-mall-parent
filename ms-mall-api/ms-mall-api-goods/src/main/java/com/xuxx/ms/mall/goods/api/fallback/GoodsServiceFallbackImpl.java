package com.xuxx.ms.mall.goods.api.fallback;

import java.util.List;

import org.springframework.stereotype.Component;

import com.xuxx.ms.mall.constants.CodeMsgConstants;
import com.xuxx.ms.mall.entity.PageResult;
import com.xuxx.ms.mall.entity.Result;
import com.xuxx.ms.mall.goods.api.GoodsService;
import com.xuxx.ms.mall.goods.entity.TbGoods;
import com.xuxx.ms.mall.goods.entity.TbItem;
import com.xuxx.ms.mall.goods.vo.GoodsVO;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @Author: xuxx
 * @Date: Jun 12, 2019 3:20:26 PM 
 *
 */
@Slf4j
@Component
public class GoodsServiceFallbackImpl implements GoodsService{
	@Setter
	private Throwable cause;
	
	@Override
	public Result<List<TbGoods>> findAll() {
		log.error("调用 GoodsService 失败", cause);
		return Result.error(CodeMsgConstants.SERVER_ERROR);
	}

	@Override
	public Result<Boolean> add(GoodsVO goods) {
		log.error("调用 GoodsService 失败", cause);
		return Result.error(CodeMsgConstants.SERVER_ERROR);
	}

	@Override
	public Result<Boolean> update(GoodsVO goods) {
		log.error("调用 GoodsService 失败", cause);
		return Result.error(CodeMsgConstants.SERVER_ERROR);
	}

	@Override
	public Result<GoodsVO> findOne(Long id) {
		log.error("调用 GoodsService 失败", cause);
		return Result.error(CodeMsgConstants.SERVER_ERROR);
	}

	@Override
	public Result<Boolean> delete(Long[] ids) {
		log.error("调用 GoodsService 失败", cause);
		return Result.error(CodeMsgConstants.SERVER_ERROR);
	}

	@Override
	public Result<PageResult<TbGoods>> findPage(TbGoods goods, int pageNum, int pageSize) {
		log.error("调用 GoodsService 失败", cause);
		return Result.error(CodeMsgConstants.SERVER_ERROR);
	}

	@Override
	public Result<Boolean> updateStatus(Long[] ids, String status) {
		log.error("调用 GoodsService 失败", cause);
		return Result.error(CodeMsgConstants.SERVER_ERROR);
	}

	@Override
	public Result<Boolean> updateMarketableStatus(Long[] ids, String status) {
		log.error("调用 GoodsService 失败", cause);
		return Result.error(CodeMsgConstants.SERVER_ERROR);
	}

	@Override
	public Result<List<TbItem>> findItemListByGoodsIdListAndStatus(Long[] goodsIds, String status) {
		log.error("调用 GoodsService 失败", cause);
		return Result.error(CodeMsgConstants.SERVER_ERROR);
	}
}