package com.xuxx.ms.mall.typetemplate.api.fallback;

import com.xuxx.ms.mall.constants.CodeMsgConstants;
import com.xuxx.ms.mall.entity.PageResult;
import com.xuxx.ms.mall.entity.Result;
import com.xuxx.ms.mall.typetemplate.api.TypeTemplateService;
import com.xuxx.ms.mall.typetemplate.entity.TbTypeTemplate;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 *
 * @author : xuxx
 *
 */

@Slf4j
@Component
public class TypeTemplateServiceFallbackImpl implements TypeTemplateService {
	@Setter
	private Throwable cause;

    @Override
    public Result<List<TbTypeTemplate>> findAll() {
        log.error("调用 SpecificationService 失败", cause);
		return Result.error(CodeMsgConstants.SERVER_ERROR);
    }

    @Override
    public Result<Boolean> add(TbTypeTemplate typeTemplate) {
        log.error("调用 SpecificationService 失败", cause);
		return Result.error(CodeMsgConstants.SERVER_ERROR);
    }

    @Override
    public Result<Boolean> update(TbTypeTemplate typeTemplate) {
        log.error("调用 SpecificationService 失败", cause);
		return Result.error(CodeMsgConstants.SERVER_ERROR);
    }

    @Override
    public Result<TbTypeTemplate> findOne(Long id) {
        log.error("调用 SpecificationService 失败", cause);
		return Result.error(CodeMsgConstants.SERVER_ERROR);
    }

    @Override
    public Result<Boolean> delete(Long[] ids) {
        log.error("调用 SpecificationService 失败", cause);
		return Result.error(CodeMsgConstants.SERVER_ERROR);
    }

    @Override
    public Result<PageResult<TbTypeTemplate>> findPage(TbTypeTemplate typeTemplate, int pageNum, int pageSize) {
        log.error("调用 SpecificationService 失败", cause);
		return Result.error(CodeMsgConstants.SERVER_ERROR);
    }

    @Override
    public Result<List<Map<String, String>>> selectOptionList() {
        log.error("调用 SpecificationService 失败", cause);
		return Result.error(CodeMsgConstants.SERVER_ERROR);
    }

    @Override
    public Result<List<Map>> findSpecList(Long id) {
        log.error("调用 SpecificationService 失败", cause);
		return Result.error(CodeMsgConstants.SERVER_ERROR);
    }
}
