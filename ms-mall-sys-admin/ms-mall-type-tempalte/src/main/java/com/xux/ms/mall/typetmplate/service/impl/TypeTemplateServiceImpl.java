package com.xux.ms.mall.typetmplate.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xux.ms.mall.typetmplate.mapper.TbTypeTemplateMapper;
import com.xux.ms.mall.typetmplate.service.TypeTemplateService;
import com.xuxx.ms.mall.constants.CodeMsgConstants;
import com.xuxx.ms.mall.entity.PageResult;
import com.xuxx.ms.mall.entity.Result;
import com.xuxx.ms.mall.specification.api.SpecificationService;
import com.xuxx.ms.mall.specification.entity.TbSpecificationOption;
import com.xuxx.ms.mall.typetemplate.entity.TbTypeTemplate;
import com.xuxx.ms.mall.typetemplate.entity.TbTypeTemplateExample;

import lombok.extern.slf4j.Slf4j;

/**
 * @author xuxx
 * @since JDK 1.8
 */

@Slf4j
@Service
@Transactional
public class TypeTemplateServiceImpl implements TypeTemplateService {
	@Autowired
    private TbTypeTemplateMapper typeTemplateMapper;

    @Autowired(required = false)
    private SpecificationService specificationService;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 查询全部
     */
    @Override
    public List<TbTypeTemplate> findAll() {
        return typeTemplateMapper.selectByExample(null);
    }

    /**
     * 按分页查询
     */
    @Override
    public PageResult<TbTypeTemplate> findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<TbTypeTemplate> page = (Page<TbTypeTemplate>) typeTemplateMapper.selectByExample(null);
        return new PageResult<TbTypeTemplate>(page.getTotal(), page.getResult());
    }

    /**
     * 增加
     */
    @Override
    public void add(TbTypeTemplate typeTemplate) {
        typeTemplateMapper.insert(typeTemplate);
    }

    /**
     * 修改
     */
    @Override
    public void update(TbTypeTemplate typeTemplate) {
        typeTemplateMapper.updateByPrimaryKey(typeTemplate);
    }

    /**
     * 根据ID获取实体
     *
     * @param id id
     * @return TbTypeTemplate
     */
    @Override
    public TbTypeTemplate findOne(Long id) {
        return typeTemplateMapper.selectByPrimaryKey(id);
    }

    /**
     * 批量删除
     */
    @Override
    public void delete(Long[] ids) {
        for (Long id : ids) {
            typeTemplateMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public PageResult<TbTypeTemplate> findPage(TbTypeTemplate typeTemplate, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        TbTypeTemplateExample example = new TbTypeTemplateExample();
        TbTypeTemplateExample.Criteria criteria = example.createCriteria();

        if (typeTemplate != null) {
            if (typeTemplate.getName() != null && typeTemplate.getName().length() > 0) {
                criteria.andNameLike("%" + typeTemplate.getName() + "%");
            }
            if (typeTemplate.getSpecIds() != null && typeTemplate.getSpecIds().length() > 0) {
                criteria.andSpecIdsLike("%" + typeTemplate.getSpecIds() + "%");
            }
            if (typeTemplate.getBrandIds() != null && typeTemplate.getBrandIds().length() > 0) {
                criteria.andBrandIdsLike("%" + typeTemplate.getBrandIds() + "%");
            }
            if (typeTemplate.getCustomAttributeItems() != null && typeTemplate.getCustomAttributeItems().length() > 0) {
                criteria.andCustomAttributeItemsLike("%" + typeTemplate.getCustomAttributeItems() + "%");
            }

        }

        Page<TbTypeTemplate> page = (Page<TbTypeTemplate>) typeTemplateMapper.selectByExample(example);

        // 缓存 品牌列表、规格列表到 redis
        // 因为 增删改之后，都要重新查询列表，所以直接写在这
        saveToRedis();
        return new PageResult<TbTypeTemplate>(page.getTotal(), page.getResult());
    }

    /**
     * 将品牌列表与规格列表放入缓存, 以模板 id 为key
     */
    private void saveToRedis() {
        log.info("缓存品牌列表和规格列表");
        List<TbTypeTemplate> templateList = findAll();
        for (TbTypeTemplate template : templateList) {
            // 得到品牌列表
            List<Map> brandList = JSON.parseArray(template.getBrandIds(), Map.class);
            redisTemplate.boundHashOps("brandList").put(String.valueOf(template.getId()), brandList);

            // 得到规格列表
            List<Map> specList = findSpecList(template.getId());
            redisTemplate.boundHashOps("specList").put(String.valueOf(template.getId()), specList);
        }
    }

    @Override
    public List<Map<String, String>> selectOptionList() {
        return typeTemplateMapper.selectOptionList();
    }

    @Override
    public List<Map> findSpecList(Long id) {
        // 查询模板
        TbTypeTemplate typeTemplate = typeTemplateMapper.selectByPrimaryKey(id);

        List<Map> list = JSON.parseArray(typeTemplate.getSpecIds(), Map.class);

        for (Map map : list) {
            // 查询规格选项列表
        	Result<List<TbSpecificationOption>> options = specificationService.listOptionBySpecificationId(new Long((Integer) map.get("id")));
        	if(options == null || options.getCode() != CodeMsgConstants.SUCCESS.getCode()) {
        		continue;
        	}
			map.put("options", options.getData());
        }

        return list;
    }
}
