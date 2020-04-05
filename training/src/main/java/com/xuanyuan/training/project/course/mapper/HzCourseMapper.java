package com.xuanyuan.training.project.course.mapper;

import java.util.List;
import com.xuanyuan.training.project.course.domain.HzCourse;

/**
 * 课程实体类Mapper接口
 * 
 * @author Lee
 * @date 2020-04-03
 */
public interface HzCourseMapper 
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
     * 删除课程实体类
     * 
     * @param id 课程实体类ID
     * @return 结果
     */
    public int deleteHzCourseById(Long id);

    /**
     * 批量删除课程实体类
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHzCourseByIds(Long[] ids);
}
