package com.xuanyuan.training.project.course.service.impl;

import java.util.List;
import com.xuanyuan.training.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xuanyuan.training.project.course.mapper.HzCourseMapper;
import com.xuanyuan.training.project.course.domain.HzCourse;
import com.xuanyuan.training.project.course.service.IHzCourseService;

/**
 * 课程实体类Service业务层处理
 * 
 * @author Lee
 * @date 2020-04-03
 */
@Service
public class HzCourseServiceImpl implements IHzCourseService 
{
    @Autowired
    private HzCourseMapper hzCourseMapper;

    /**
     * 查询课程实体类
     * 
     * @param id 课程实体类ID
     * @return 课程实体类
     */
    @Override
    public HzCourse selectHzCourseById(Long id)
    {
        return hzCourseMapper.selectHzCourseById(id);
    }

    /**
     * 查询课程实体类列表
     * 
     * @param hzCourse 课程实体类
     * @return 课程实体类
     */
    @Override
    public List<HzCourse> selectHzCourseList(HzCourse hzCourse)
    {
        return hzCourseMapper.selectHzCourseList(hzCourse);
    }

    /**
     * 新增课程实体类
     * 
     * @param hzCourse 课程实体类
     * @return 结果
     */
    @Override
    public int insertHzCourse(HzCourse hzCourse)
    {
        hzCourse.setCreateTime(DateUtils.getNowDate());
        return hzCourseMapper.insertHzCourse(hzCourse);
    }

    /**
     * 修改课程实体类
     * 
     * @param hzCourse 课程实体类
     * @return 结果
     */
    @Override
    public int updateHzCourse(HzCourse hzCourse)
    {
        hzCourse.setUpdateTime(DateUtils.getNowDate());
        return hzCourseMapper.updateHzCourse(hzCourse);
    }

    /**
     * 批量删除课程实体类
     * 
     * @param ids 需要删除的课程实体类ID
     * @return 结果
     */
    @Override
    public int deleteHzCourseByIds(Long[] ids)
    {
        return hzCourseMapper.deleteHzCourseByIds(ids);
    }

    /**
     * 删除课程实体类信息
     * 
     * @param id 课程实体类ID
     * @return 结果
     */
    @Override
    public int deleteHzCourseById(Long id)
    {
        return hzCourseMapper.deleteHzCourseById(id);
    }
}
