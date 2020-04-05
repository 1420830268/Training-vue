package com.xuanyuan.training.project.course.service.impl;

import java.util.List;
import com.xuanyuan.training.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xuanyuan.training.project.course.mapper.HzCourseTypeMapper;
import com.xuanyuan.training.project.course.domain.HzCourseType;
import com.xuanyuan.training.project.course.service.IHzCourseTypeService;

/**
 * 课程类型Service业务层处理
 * 
 * @author Lee
 * @date 2020-04-03
 */
@Service
public class HzCourseTypeServiceImpl implements IHzCourseTypeService 
{
    @Autowired
    private HzCourseTypeMapper hzCourseTypeMapper;

    /**
     * 查询课程类型
     * 
     * @param id 课程类型ID
     * @return 课程类型
     */
    @Override
    public HzCourseType selectHzCourseTypeById(Long id)
    {
        return hzCourseTypeMapper.selectHzCourseTypeById(id);
    }

    /**
     * 查询课程类型列表
     * 
     * @param hzCourseType 课程类型
     * @return 课程类型
     */
    @Override
    public List<HzCourseType> selectHzCourseTypeList(HzCourseType hzCourseType)
    {
        return hzCourseTypeMapper.selectHzCourseTypeList(hzCourseType);
    }

    /**
     * 新增课程类型
     * 
     * @param hzCourseType 课程类型
     * @return 结果
     */
    @Override
    public int insertHzCourseType(HzCourseType hzCourseType)
    {
        hzCourseType.setCreateTime(DateUtils.getNowDate());
        return hzCourseTypeMapper.insertHzCourseType(hzCourseType);
    }

    /**
     * 修改课程类型
     * 
     * @param hzCourseType 课程类型
     * @return 结果
     */
    @Override
    public int updateHzCourseType(HzCourseType hzCourseType)
    {
        hzCourseType.setUpdateTime(DateUtils.getNowDate());
        return hzCourseTypeMapper.updateHzCourseType(hzCourseType);
    }

    /**
     * 批量删除课程类型
     * 
     * @param ids 需要删除的课程类型ID
     * @return 结果
     */
    @Override
    public int deleteHzCourseTypeByIds(Long[] ids)
    {
        return hzCourseTypeMapper.deleteHzCourseTypeByIds(ids);
    }

    /**
     * 删除课程类型信息
     * 
     * @param id 课程类型ID
     * @return 结果
     */
    @Override
    public int deleteHzCourseTypeById(Long id)
    {
        return hzCourseTypeMapper.deleteHzCourseTypeById(id);
    }
}
