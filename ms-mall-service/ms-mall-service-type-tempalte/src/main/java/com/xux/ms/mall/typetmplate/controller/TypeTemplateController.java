package com.xux.ms.mall.typetmplate.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xux.ms.mall.typetmplate.service.TypeTemplateService;
import com.xuxx.ms.mall.constants.CodeMsgConstants;
import com.xuxx.ms.mall.entity.PageResult;
import com.xuxx.ms.mall.entity.Result;
import com.xuxx.ms.mall.typetemplate.entity.TbTypeTemplate;

/**
 * 
 * @ClassName: TypeTemplateController
 *
 * @author xuxx
 * @date 2019-05-13 21:08:41
 * @since JDK 1.8
 *
 */
@RestController
public class TypeTemplateController {

	@Autowired
	private TypeTemplateService typeTemplateService;

	/**
	 * 返回全部列表
	 * 
	 * @return
	 */
	@GetMapping("/api/v1/typetemplates")
	public Result<List<TbTypeTemplate>> findAll() {
		return Result.success(typeTemplateService.findAll());
	}

	/**
	 * 增加
	 * 
	 * @param typeTemplate
	 * @return
	 */
	@PostMapping("/api/v1/typetemplates")
	public Result<Boolean> add(TbTypeTemplate typeTemplate) {
		typeTemplateService.add(typeTemplate);

		return Result.success(true);
	}

	/**
	 * 修改
	 * 
	 * @param typeTemplate
	 * @return
	 */
	@PutMapping("/api/v1/typetemplates")
	public Result<Boolean> update(TbTypeTemplate typeTemplate) {
		typeTemplateService.update(typeTemplate);
		return Result.success(true);
	}

	/**
	 * 获取实体
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/api/v1/typetemplates/{id}")
	public Result<TbTypeTemplate> findOne(@PathVariable("id") Long id) {
		TbTypeTemplate typeTemplate = typeTemplateService.findOne(id);
		if (typeTemplate == null || typeTemplate.getId() != id) {
			return Result.error(CodeMsgConstants.ID_ILLEGAL);
		}

		return Result.success(typeTemplate);
	}

	/**
	 * 批量删除
	 * 
	 * @param ids
	 * @return
	 */
	@DeleteMapping("/api/v1/typetemplates/{id}")
	public Result<Boolean> delete(@PathVariable("id") Long[] ids) {
		typeTemplateService.delete(ids);

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
	@PostMapping("/api/v1/typetemplates/list")
	public Result<PageResult<TbTypeTemplate>> search(@RequestBody TbTypeTemplate typeTemplate,
			@RequestParam("page") int page, @RequestParam("rows") int rows) {
		PageResult<TbTypeTemplate> data = typeTemplateService.findPage(typeTemplate, page, rows);

		return Result.success(data);
	}

	/**
	 * 
	 * @Title: selectOptionList
	 * @Description: 获取所有类型模板，按照 select2 需要的格式，即{id:,text}
	 * @return List<Map>
	 */
	@GetMapping("/api/v1/typetemplates/options")
	public Result<List<Map<String, String>>> selectOptionList() {
		List<Map<String, String>> data = typeTemplateService.selectOptionList();

		return Result.success(data);
	}

	/**
	 * @Title: findSpecList
	 * @Description: 获取模板对应的规格选项
	 * @param id
	 * @return List<Map<String,String>>
	 */
	@GetMapping("/api/v1/typetemplates/specification/{id}")
	public Result<List<Map>> findSpecList(@PathVariable("id") Long id) {
		List<Map> data = typeTemplateService.findSpecList(id);
		return Result.success(data);
	}
}
