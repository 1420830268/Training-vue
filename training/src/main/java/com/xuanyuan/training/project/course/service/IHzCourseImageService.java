package com.xuanyuan.training.project.course.service;

import java.util.List;
import com.xuanyuan.training.project.course.domain.HzCourseImage;

/**
 * 课程镜像Service接口
 * 
 * @author Lee
 * @date 2020-04-05
 */
public interface IHzCourseImageService 
{
    /**
     * 查询课程镜像
     * 
     * @param id 课程镜像ID
     * @return 课程镜像
     */
    public HzCourseImage selectHzCourseImageById(Long id);

    /**
     * 查询课程镜像列表
     * 
     * @param hzCourseImage 课程镜像
     * @return 课程镜像集合
     */
    public List<HzCourseImage> selectHzCourseImageList(HzCourseImage hzCourseImage);

    /**
     * 新增课程镜像
     * 
     * @param hzCourseImage 课程镜像
     * @return 结果
     */
    public int insertHzCourseImage(HzCourseImage hzCourseImage);

    /**
     * 修改课程镜像
     * 
     * @param hzCourseImage 课程镜像
     * @return 结果
     */
    public int updateHzCourseImage(HzCourseImage hzCourseImage);

    /**
     * 批量删除课程镜像
     * 
     * @param ids 需要删除的课程镜像ID
     * @return 结果
     */
    public int deleteHzCourseImageByIds(Long[] ids);

    /**
     * 删除课程镜像信息
     * 
     * @param id 课程镜像ID
     * @return 结果
     */
    public int deleteHzCourseImageById(Long id);
}
