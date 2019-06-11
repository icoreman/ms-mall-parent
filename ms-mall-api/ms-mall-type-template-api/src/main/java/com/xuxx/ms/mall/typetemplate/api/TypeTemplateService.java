package com.xuxx.ms.mall.typetemplate.api;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.xuxx.ms.mall.entity.PageResult;
import com.xuxx.ms.mall.entity.Result;
import com.xuxx.ms.mall.typetemplate.api.factories.TypeTemplateServiceFallbackFactory;
import com.xuxx.ms.mall.typetemplate.entity.TbTypeTemplate;

/**
 * 
 * ClassName: TypeTemplateService
 *
 * @author xuxx date 2019-05-13 17:54:48
 * @since JDK 1.8
 *
 */
@FeignClient(value = "MS-MALL-TYPE-TEMPLATE-SERVICE", fallbackFactory = TypeTemplateServiceFallbackFactory.class)
public interface TypeTemplateService {

	/**
	 * 返回全部列表
	 */
	@GetMapping("/api/v1/typetemplates")
	public Result<List<TbTypeTemplate>> findAll();

	/**
	 * 增加
	 */
	@PostMapping("/api/v1/typetemplates")
	public Result<Boolean> add(TbTypeTemplate typeTemplate);

	/**
	 * 修改
	 */
	@PutMapping("/api/v1/typetemplates")
	public Result<Boolean> update(TbTypeTemplate typeTemplate);

	/**
	 * 根据ID获取实体
	 */
	@GetMapping("/api/v1/typetemplates/{id}")
	public Result<TbTypeTemplate> findOne(@PathVariable("id") Long id);

	/**
	 * 批量删除
	 */
	@DeleteMapping("/api/v1/typetemplates/{id}")
	public Result<Boolean> delete(@PathVariable("id") Long[] ids);

	/**
	 * 分页
	 * 
	 * @param pageNum  当前页 码
	 * @param pageSize 每页记录数
	 */
	@PostMapping("/api/v1/typetemplates/list")
	public Result<PageResult<TbTypeTemplate>> findPage(@RequestBody TbTypeTemplate typeTemplate,
			@RequestParam("page") int pageNum, @RequestParam("rows") int pageSize);

	/**
	 *
	 * Description: 获取所有模板选项，按照 select2 需要的格式，即{id:,text}
	 * 
	 * @return List<Map<String,String>>
	 */
	@GetMapping("/api/v1/typetemplates/options")
	public Result<List<Map<String, String>>> selectOptionList();

	/**
	 * Description: 获取模板对应的规格选项
	 * 
	 * @return List<Map<String,String>>
	 */
	@GetMapping("/api/v1/typetemplates/specification/{id}")
	public Result<List<Map>> findSpecList(@PathVariable("id") Long id);
}
