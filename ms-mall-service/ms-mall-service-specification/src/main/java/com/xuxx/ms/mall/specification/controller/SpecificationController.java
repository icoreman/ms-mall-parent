package com.xuxx.ms.mall.specification.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xuxx.ms.mall.entity.PageResult;
import com.xuxx.ms.mall.entity.Result;
import com.xuxx.ms.mall.specification.entity.TbSpecification;
import com.xuxx.ms.mall.specification.service.SpecificationService;
import com.xuxx.ms.mall.specification.vo.SpecificationVO;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class SpecificationController {
	private final SpecificationService specificationService;

	/**
	 * 返回全部列表
	 * 
	 * @return
	 */
	@GetMapping("/api/v1/specifications")
	public Result<List<TbSpecification>> findAll() {
		List<TbSpecification> data = specificationService.findAll();
		return Result.success(data);
	}

	/**
	 * 增加
	 */
	@PostMapping("/api/v1/specifications")
	public Result<Boolean> add(SpecificationVO specification) {
		specificationService.add(specification);
		return Result.success(true);
	}

	/**
	 * 修改
	 */
	@PutMapping("/api/v1/specifications")
	public Result<Boolean> update(SpecificationVO specification) {
		specificationService.update(specification);
		return Result.success(true);
	}

	/**
	 * 根据ID获取实体
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/api/v1/specifications/{id}")
	public Result<SpecificationVO> findOne(Long id) {
		SpecificationVO specificationVO = specificationService.findOne(id);
		return Result.success(specificationVO);
	}

	/**
	 * 批量删除
	 * 
	 * @param ids
	 */
	@DeleteMapping("/api/v1/specifications/{id}")
	public Result<Boolean> delete(@PathVariable("id") Long[] ids) {
		specificationService.delete(ids);
		return Result.success(true);
	}

	/**
	 * 分页
	 * 
	 * @param pageNum  当前页 码
	 * @param pageSize 每页记录数
	 * @return
	 */
	@PostMapping("/api/v1/specifications/list")
	public Result<PageResult<TbSpecification>> findPage(@RequestBody TbSpecification specification,
			@RequestParam("page") int pageNum, @RequestParam("rows") int pageSize) {
		PageResult<TbSpecification> data = specificationService.findPage(specification, pageNum, pageSize);
		return Result.success(data);
	}

	/**
	 * 
	 * @Title: selectOptionList
	 * @Description: 获取所有规格，按照 select2 需要的格式，即{id:,text}
	 * @return List<Map>
	 */
	@GetMapping("/api/v1/specifications/options")
	public Result<List<Map<String, String>>> selectOptionList() {
		List<Map<String, String>> data = specificationService.selectOptionList();
		return Result.success(data);
	}

	@GetMapping("/api/v1/specifications/options/{id}")
	public Result<List<Map<String, String>>> listOptionBySpecificationId(@PathVariable("id") Long id) {
		List<Map<String, String>> data = specificationService.selectOptionList();
		return Result.success(data);
	}
}
