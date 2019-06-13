package com.xuxx.ms.mall.seller.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xuxx.ms.mall.entity.PageResult;
import com.xuxx.ms.mall.entity.Result;
import com.xuxx.ms.mall.typetemplate.api.TypeTemplateService;
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
@RequestMapping("/typeTemplate")
public class TypeTemplateController {

	@Autowired
	private TypeTemplateService typeTemplateService;

	/**
	 * 返回全部列表
	 * 
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TbTypeTemplate> findAll() {
		return typeTemplateService.findAll().getData();
	}

	/**
	 * 增加
	 * 
	 * @param typeTemplate
	 * @return Result<Boolean>
	 */
	@RequestMapping("/add")
	public Result<Boolean> add(@RequestBody TbTypeTemplate typeTemplate) {
		typeTemplateService.add(typeTemplate);
		return Result.success(true);
	}

	/**
	 * 修改
	 * 
	 * @param typeTemplate
	 * @return Result<Boolean>
	 */
	@RequestMapping("/update")
	public Result<Boolean> update(@RequestBody TbTypeTemplate typeTemplate) {
		typeTemplateService.update(typeTemplate);
		return Result.success(true);
	}

	/**
	 * 获取实体
	 * 
	 * @param id
	 * @return TbTypeTemplate
	 */
	@RequestMapping("/findOne")
	public TbTypeTemplate findOne(Long id) {
		return typeTemplateService.findOne(id).getData();
	}

	/**
	 * 批量删除
	 * 
	 * @param ids
	 * @return Result<Boolean>
	 */
	@RequestMapping("/delete")
	public Result<Boolean> delete(Long[] ids) {
		typeTemplateService.delete(ids);
		return Result.success(true);
	}

	/**
	 * 查询+分页
	 * 
	 * @param brand
	 * @param page
	 * @param rows
	 * @return PageResult<TbTypeTemplate>
	 */
	@RequestMapping("/search")
	public PageResult<TbTypeTemplate> search(@RequestBody TbTypeTemplate typeTemplate, int page, int rows) {
		return typeTemplateService.findPage(typeTemplate, page, rows).getData();
	}

	/**
	 * 
	 * @Title: selectOptionList
	 * @Description: 获取所有类型模板，按照 select2 需要的格式，即{id:,text}
	 * @return List<Map<String, String>>
	 */
	@RequestMapping("/selectOptionList")
	public List<Map<String, String>> selectOptionList() {
		return typeTemplateService.selectOptionList().getData();
	}

	/**
	 * @Title: findSpecList
	 * @Description: 获取模板对应的规格选项
	 * @param id
	 * @return List<Map<String,String>>
	 */
	@RequestMapping("/findSpecList")
	public List<Map<String, String>> findSpecList(Long id) {
		return typeTemplateService.findSpecList(id).getData();
	}
}
