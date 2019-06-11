package com.xux.ms.mall.typetmplate.service;

import com.xuxx.ms.mall.entity.PageResult;
import com.xuxx.ms.mall.typetemplate.entity.TbTypeTemplate;

import java.util.List;
import java.util.Map;
/**
 * 
 * @author xuxx
 * @since  JDK 1.8
 *
 */
public interface TypeTemplateService {

	/**
	 * 返回全部列表
	 * @return List<TbTypeTemplate>
	 */
	public List<TbTypeTemplate> findAll();


	/**
	 * 返回分页列表
	 * @return PageResult<TbTypeTemplate>
	 */
	public PageResult<TbTypeTemplate> findPage(int pageNum, int pageSize);


	/**
	 * 增加
	*/
	public void add(TbTypeTemplate typeTemplate);
	
	
	/**
	 * 修改
	 */
	public void update(TbTypeTemplate typeTemplate);
	

	/**
	 * 根据ID获取实体
	 * @param id  id
	 * @return TbTypeTemplate
	 */
	public TbTypeTemplate findOne(Long id);
	
	
	/**
	 * 批量删除
	 * @param ids id 数组
	 */
	public void delete(Long[] ids);

	/**
	 * 分页
	 * @param pageNum 当前页 码
	 * @param pageSize 每页记录数
	 * @return PageResult<TbTypeTemplate>
	 */
	public PageResult<TbTypeTemplate> findPage(TbTypeTemplate typeTemplate, int pageNum, int pageSize);
	
	/**
	 * 
	 * <code>获取所有模板选项，按照 select2 需要的格式，即{id:,text} </code>
	 * @return List<Map<String,String>> 
	 */
	public List<Map<String,String>> selectOptionList();


	/** 
	 * 获取模板对应的规格选项
	 * @param id id
	 * @return List<Map<String,String>> 
	 */
	public List<Map> findSpecList(Long id);
}
