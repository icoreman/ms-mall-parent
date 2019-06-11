package com.xuxx.ms.mall.itemcat.api.fallback;

import java.util.List;

import org.springframework.stereotype.Component;

import com.xuxx.ms.mall.constants.CodeMsgConstants;
import com.xuxx.ms.mall.entity.PageResult;
import com.xuxx.ms.mall.entity.Result;
import com.xuxx.ms.mall.itemcat.api.ItemCatService;
import com.xuxx.ms.mall.itemcat.entity.TbItemCat;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ItemCatServiceFallback implements ItemCatService {
	@Setter
	private Throwable cause;
	
	@Override
	public Result<List<TbItemCat>> findAll() {
		log.error("调用 ItemCatService 失败", cause);
		return Result.error(CodeMsgConstants.SERVER_ERROR);
	}

	@Override
	public Result<Boolean> add(TbItemCat itemCat) {
		log.error("调用 ItemCatService 失败", cause);
		return Result.error(CodeMsgConstants.SERVER_ERROR);
	}

	@Override
	public Result<Boolean> update(TbItemCat itemCat) {
		log.error("调用 ItemCatService 失败", cause);
		return Result.error(CodeMsgConstants.SERVER_ERROR);
	}

	@Override
	public Result<TbItemCat> findOne(Long id) {
		
		log.error("调用 ItemCatService 失败", cause);
		return Result.error(CodeMsgConstants.SERVER_ERROR);
	}

	@Override
	public Result<Boolean> delete(Long[] ids) {
		log.error("调用 ItemCatService 失败", cause);
		return Result.error(CodeMsgConstants.SERVER_ERROR);
	}

	@Override
	public Result<PageResult<TbItemCat>> findPage(TbItemCat itemCat, int page, int rows) {
		log.error("调用 ItemCatService 失败", cause);
		return Result.error(CodeMsgConstants.SERVER_ERROR);
	}

	@Override
	public Result<List<TbItemCat>> findByParentId(Long parentId) {
		log.error("调用 ItemCatService 失败", cause);
		return Result.error(CodeMsgConstants.SERVER_ERROR);
	}

}
