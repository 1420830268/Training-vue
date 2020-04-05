package com.xuanyuan.training.project.course.service;

import java.util.List;
import com.xuanyuan.training.project.course.domain.HzCourseType;

/**
 * 课程类型Service接口
 * 
 * @author Lee
 * @date 2020-04-03
 */
public interface IHzCourseTypeService 
{
    /**
     * 查询课程类型
     * 
     * @param id 课程类型ID
     * @return 课程类型
     */
    public HzCourseType selectHzCourseTypeById(Long id);

    /**
     * 查询课程类型列表
     * 
     * @param hzCourseType 课程类型
     * @return 课程类型集合
     */
    public List<HzCourseType> selectHzCourseTypeList(HzCourseType hzCourseType);

    /**
     * 新增课程类型
     * 
     * @param hzCourseType 课程类型
     * @return 结果
     */
    public int insertHzCourseType(HzCourseType hzCourseType);

    /**
     * 修改课程类型
     * 
     * @param hzCourseType 课程类型
     * @return 结果
     */
    public int updateHzCourseType(HzCourseType hzCourseType);

    /**
     * 批量删除课程类型
     * 
     * @param ids 需要删除的课程类型ID
     * @return 结果
     */
    public int deleteHzCourseTypeByIds(Long[] ids);

    /**
     * 删除课程类型信息
     * 
     * @param id 课程类型ID
     * @return 结果
     */
    public int deleteHzCourseTypeById(Long id);
}
