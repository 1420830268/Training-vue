package com.xuanyuan.training.project.course.service;

import java.util.List;
import com.xuanyuan.training.project.course.domain.HzCourse;

/**
 * 课程实体类Service接口
 * 
 * @author Lee
 * @date 2020-04-03
 */
public interface IHzCourseService 
{
    /**
     * 查询课程实体类
     * 
     * @param id 课程实体类ID
     * @return 课程实体类
     */
    public HzCourse selectHzCourseById(Long id);

    /**
     * 查询课程实体类列表
     * 
     * @param hzCourse 课程实体类
     * @return 课程实体类集合
     */
    public List<HzCourse> selectHzCourseList(HzCourse hzCourse);

    /**
     * 新增课程实体类
     * 
     * @param hzCourse 课程实体类
     * @return 结果
     */
    public int insertHzCourse(HzCourse hzCourse);

    /**
     * 修改课程实体类
     * 
     * @param hzCourse 课程实体类
     * @return 结果
     */
    public int updateHzCourse(HzCourse hzCourse);

    /**
     * 批量删除课程实体类
     * 
     * @param ids 需要删除的课程实体类ID
     * @return 结果
     */
    public int deleteHzCourseByIds(Long[] ids);

    /**
     * 删除课程实体类信息
     * 
     * @param id 课程实体类ID
     * @return 结果
     */
    public int deleteHzCourseById(Long id);
}
