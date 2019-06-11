package com.xuxx.ms.mall.specification.api;

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
import com.xuxx.ms.mall.specification.api.factories.SpecificationServiceFallbackFactory;
import com.xuxx.ms.mall.specification.entity.TbSpecification;
import com.xuxx.ms.mall.specification.entity.TbSpecificationOption;
import com.xuxx.ms.mall.specification.vo.SpecificationVO;

/**
 * 
 * @ClassName: SpecificationService
 *
 * @author xuxx
 * @date 2019-05-13 17:54:55
 * @since JDK 1.8
 *
 */
@FeignClient(value = "MS-MALL-SPECIFICATION-SERVICE", fallbackFactory = SpecificationServiceFallbackFactory.class)
public interface SpecificationService {

	/**
	 * 返回全部列表
	 * 
	 * @return
	 */
	@GetMapping("/api/v1/specifications")
	public Result<List<TbSpecification>> findAll();

	/**
	 * 增加
	 */
	@PostMapping("/api/v1/specifications")
	public Result<Boolean> add(SpecificationVO specification);

	/**
	 * 修改
	 */
	@PutMapping("/api/v1/specifications")
	public Result<Boolean> update(SpecificationVO specification);

	/**
	 * 根据ID获取实体
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/api/v1/specifications/{id}")
	public Result<SpecificationVO> findOne(@PathVariable("id") Long id);

	/**
	 * 批量删除
	 * 
	 * @param ids
	 */
	@DeleteMapping("/api/v1/specifications/{id}")
	public Result<Boolean> delete(@PathVariable("id") Long[] ids);

	/**
	 * 分页
	 * 
	 * @param pageNum  当前页 码
	 * @param pageSize 每页记录数
	 * @return
	 */
	@PostMapping("/api/v1/specifications/list")
	public Result<PageResult<TbSpecification>> findPage(@RequestBody TbSpecification specification,
			@RequestParam("page") int pageNum, @RequestParam("rows") int pageSize);

	/**
	 * 
	 * @Title: selectOptionList
	 * @Description: 获取所有规格，按照 select2 需要的格式，即{id:,text}
	 * @return List<Map>
	 */
	@GetMapping("/api/v1/specifications/options")
	public Result<List<Map<String, String>>> selectOptionList();

	@GetMapping("/api/v1/specifications/options/{id}")
	public Result<List<TbSpecificationOption>> listOptionBySpecificationId(@PathVariable("id") Long id);

}
