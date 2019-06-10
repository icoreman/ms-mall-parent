package com.xuxx.ms.mall.specification.api.fallback;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.xuxx.ms.mall.constants.CodeMsgConstants;
import com.xuxx.ms.mall.entity.PageResult;
import com.xuxx.ms.mall.entity.Result;
import com.xuxx.ms.mall.specification.api.SpecificationService;
import com.xuxx.ms.mall.specification.entity.TbSpecification;

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
public class SpecificationServiceFallbackImpl implements SpecificationService {
	@Setter
	private Throwable cause;

	@Override
	public Result<List<TbSpecification>> findAll() {
		log.error("调用 SpecificationService 失败", cause);
		return Result.error(CodeMsgConstants.SERVER_ERROR);
	}

	@Override
	public Result<Boolean> add(com.xuxx.ms.mall.specification.vo.SpecificationVO specification) {
		log.error("调用 SpecificationService 失败", cause);
		return Result.error(CodeMsgConstants.SERVER_ERROR);
	}

	@Override
	public Result<Boolean> update(com.xuxx.ms.mall.specification.vo.SpecificationVO specification) {
		log.error("调用 SpecificationService 失败", cause);
		return Result.error(CodeMsgConstants.SERVER_ERROR);
	}

	@Override
	public Result<com.xuxx.ms.mall.specification.vo.SpecificationVO> findOne(Long id) {
		log.error("调用 SpecificationService 失败", cause);
		return Result.error(CodeMsgConstants.SERVER_ERROR);
	}

	@Override
	public Result<Boolean> delete(Long[] ids) {
		log.error("调用 SpecificationService 失败", cause);
		return Result.error(CodeMsgConstants.SERVER_ERROR);
	}

	@Override
	public Result<PageResult<TbSpecification>> findPage(TbSpecification specification, int pageNum, int pageSize) {
		log.error("调用 SpecificationService 失败", cause);
		return Result.error(CodeMsgConstants.SERVER_ERROR);
	}

	@Override
	public Result<List<Map<String, String>>> selectOptionList() {
		log.error("调用 SpecificationService 失败", cause);
		return Result.error(CodeMsgConstants.SERVER_ERROR);
	}
}
