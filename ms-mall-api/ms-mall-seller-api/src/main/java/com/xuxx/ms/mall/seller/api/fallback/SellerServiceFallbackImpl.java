package com.xuxx.ms.mall.seller.api.fallback;

import java.util.List;

import org.springframework.stereotype.Component;

import com.xuxx.ms.mall.constants.CodeMsgConstants;
import com.xuxx.ms.mall.entity.PageResult;
import com.xuxx.ms.mall.entity.Result;
import com.xuxx.ms.mall.seller.api.SellerService;
import com.xuxx.ms.mall.seller.entity.TbSeller;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @Author: xuxx
 * @Date: Jun 9, 2019 9:49:01 PM
 *
 */

@Slf4j
@Component
public class SellerServiceFallbackImpl implements SellerService {
	@Setter
	private Throwable cause;

	@Override
	public Result<List<TbSeller>> findAll() {
		log.error("调用 SellerService 失败", cause);
		return Result.error(CodeMsgConstants.SERVER_ERROR);
	}

	@Override
	public Result<Boolean> add(TbSeller seller) {
		log.error("调用 SellerService 失败", cause);
		return Result.error(CodeMsgConstants.SERVER_ERROR);
	}

	@Override
	public Result<Boolean> update(TbSeller seller) {
		log.error("调用 SellerService 失败", cause);
		return Result.error(CodeMsgConstants.SERVER_ERROR);
	}

	@Override
	public Result<TbSeller> findOne(String id) {
		log.error("调用 SellerService 失败", cause);
		return Result.error(CodeMsgConstants.SERVER_ERROR);
	}

	@Override
	public Result<Boolean> delete(String[] ids) {
		log.error("调用 SellerService 失败", cause);
		return Result.error(CodeMsgConstants.SERVER_ERROR);
	}

	@Override
	public Result<PageResult<TbSeller>> findPage(TbSeller seller, int pageNum, int pageSize) {
		log.error("调用 SellerService 失败", cause);
		return Result.error(CodeMsgConstants.SERVER_ERROR);
	}

	@Override
	public Result<Boolean> updateStatus(String sellerId, String status) {
		log.error("调用 SellerService 失败", cause);
		return Result.error(CodeMsgConstants.SERVER_ERROR);
	}

}
