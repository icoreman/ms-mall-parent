package com.xuxx.ms.mall.specification.service;
import java.util.List;
import java.util.Map;

import com.xuxx.ms.mall.entity.PageResult;
import com.xuxx.ms.mall.specification.entity.TbSpecification;
import com.xuxx.ms.mall.specification.vo.SpecificationVO;
/**
 * 
 * @ClassName: SpecificationService
 *
 * @author xuxx
 * @date 2019-05-13 17:54:55
 * @since  JDK 1.8
 *
 */
public interface SpecificationService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<TbSpecification> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public PageResult<TbSpecification> findPage(int pageNum,int pageSize);
	
	
	/**
	 * 增加
	*/
	public void add(SpecificationVO specification);
	
	
	/**
	 * 修改
	 */
	public void update(SpecificationVO specification);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public SpecificationVO findOne(Long id);
	
	
	/**
	 * 批量删除
	 * @param ids
	 */
	public void delete(Long [] ids);

	/**
	 * 分页
	 * @param pageNum 当前页 码
	 * @param pageSize 每页记录数
	 * @return
	 */
	public PageResult<TbSpecification> findPage(TbSpecification specification, int pageNum,int pageSize);
	
	
	/**
	 * 
	 * @Title: selectOptionList 
	 * @Description: 获取所有规格，按照 select2 需要的格式，即{id:,text}
	 * @param @return 
	 * @return List<Map>    
	 * @throws
	 */
	public List<Map<String,String>> selectOptionList();
	
}
