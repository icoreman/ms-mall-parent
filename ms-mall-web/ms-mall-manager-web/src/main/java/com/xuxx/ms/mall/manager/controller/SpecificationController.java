package com.xuxx.ms.mall.manager.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xuxx.ms.mall.entity.PageResult;
import com.xuxx.ms.mall.entity.Result;
import com.xuxx.ms.mall.specification.api.SpecificationService;
import com.xuxx.ms.mall.specification.entity.TbSpecification;
import com.xuxx.ms.mall.specification.vo.SpecificationVO;

/**
 * 
 * @ClassName: SpecificationController
 *
 * @author xuxx
 * @date 2019-05-13 17:36:58
 * @since JDK 1.8
 *
 */

@RestController
@RequestMapping("/specification")
public class SpecificationController {

	@Autowired
	private SpecificationService specificationService;

	/**
	 * 返回全部列表
	 * 
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TbSpecification> findAll() {
		return specificationService.findAll().getData();
	}

	/**
	 * 增加
	 * 
	 * @param specification
	 * @return
	 */
	@RequestMapping("/add")
	public Result<Boolean> add(@RequestBody SpecificationVO specification) {
		 return	specificationService.add(specification);
			
	}

	/**
	 * 修改
	 * 
	 * @param specification
	 * @return
	 */
	@RequestMapping("/update")
	public Result<Boolean> update(@RequestBody SpecificationVO specification) {
		return	specificationService.update(specification);
	}

	/**
	 * 获取实体
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/findOne")
	public SpecificationVO findOne(Long id) {
		return specificationService.findOne(id).getData();
	}

	/**
	 * 批量删除
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result<Boolean> delete(Long[] ids) {
		return	specificationService.delete(ids);
	}

	/**
	 * 查询+分页
	 * 
	 * @param brand
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/search")
	public PageResult<TbSpecification> search(@RequestBody TbSpecification specification, int page, int rows) {
		return specificationService.findPage(specification, page, rows).getData();
	}

	@RequestMapping("/selectOptionList")
	public List<Map<String, String>> selectOptionList() {
		return specificationService.selectOptionList().getData();
	}
}
