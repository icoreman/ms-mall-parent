package com.xuxx.ms.mall.brand.api.fallback;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.xuxx.ms.mall.brand.api.BrandService;
import com.xuxx.ms.mall.brand.entity.TbBrand;
import com.xuxx.ms.mall.constants.CodeMsgConstants;
import com.xuxx.ms.mall.entity.PageResult;
import com.xuxx.ms.mall.entity.Result;

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
public class BrandServiceFallbackImpl implements BrandService {
	@Setter
	private Throwable cause;

	@Override
	public Result<List<TbBrand>> findAll() {
		log.error("调用 BrandService 失败", cause);
		return Result.error(CodeMsgConstants.SERVER_ERROR);
	}

	@Override
	public Result<Boolean> add(TbBrand brand) {
		log.error("调用 BrandService 失败", cause);
		return Result.error(CodeMsgConstants.SERVER_ERROR);
	}

	@Override
	public Result<TbBrand> findOne(Long id) {
		log.error("调用 BrandService 失败", cause);
		return Result.error(CodeMsgConstants.SERVER_ERROR);
	}

	@Override
	public Result<Boolean> update(TbBrand brand) {
		log.error("调用 BrandService 失败", cause);
		return Result.error(CodeMsgConstants.SERVER_ERROR);
	}

	@Override
	public Result<Boolean> delete(Long[] ids) {
		log.error("调用 BrandService 失败", cause);
		return Result.error(CodeMsgConstants.SERVER_ERROR);
	}

	@Override
	public Result<PageResult<TbBrand>> findPage(TbBrand brand, int pageNum, int pageSize) {
		log.error("调用 BrandService 失败", cause);
		return Result.error(CodeMsgConstants.SERVER_ERROR);
	}

	@Override
	public Result<List<Map<String, String>>> selectOptionList() {
		log.error("调用 BrandService 失败", cause);
		return Result.error(CodeMsgConstants.SERVER_ERROR);
	}
}
