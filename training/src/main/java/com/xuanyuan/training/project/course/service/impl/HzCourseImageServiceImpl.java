package com.xuanyuan.training.project.course.service.impl;

import java.util.List;
import com.xuanyuan.training.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xuanyuan.training.project.course.mapper.HzCourseImageMapper;
import com.xuanyuan.training.project.course.domain.HzCourseImage;
import com.xuanyuan.training.project.course.service.IHzCourseImageService;

/**
 * 课程镜像Service业务层处理
 * 
 * @author Lee
 * @date 2020-04-05
 */
@Service
public class HzCourseImageServiceImpl implements IHzCourseImageService 
{
    @Autowired
    private HzCourseImageMapper hzCourseImageMapper;

    /**
     * 查询课程镜像
     * 
     * @param id 课程镜像ID
     * @return 课程镜像
     */
    @Override
    public HzCourseImage selectHzCourseImageById(Long id)
    {
        return hzCourseImageMapper.selectHzCourseImageById(id);
    }

    /**
     * 查询课程镜像列表
     * 
     * @param hzCourseImage 课程镜像
     * @return 课程镜像
     */
    @Override
    public List<HzCourseImage> selectHzCourseImageList(HzCourseImage hzCourseImage)
    {
        return hzCourseImageMapper.selectHzCourseImageList(hzCourseImage);
    }

    /**
     * 新增课程镜像
     * 
     * @param hzCourseImage 课程镜像
     * @return 结果
     */
    @Override
    public int insertHzCourseImage(HzCourseImage hzCourseImage)
    {
        hzCourseImage.setCreateTime(DateUtils.getNowDate());
        return hzCourseImageMapper.insertHzCourseImage(hzCourseImage);
    }

    /**
     * 修改课程镜像
     * 
     * @param hzCourseImage 课程镜像
     * @return 结果
     */
    @Override
    public int updateHzCourseImage(HzCourseImage hzCourseImage)
    {
        hzCourseImage.setUpdateTime(DateUtils.getNowDate());
        return hzCourseImageMapper.updateHzCourseImage(hzCourseImage);
    }

    /**
     * 批量删除课程镜像
     * 
     * @param ids 需要删除的课程镜像ID
     * @return 结果
     */
    @Override
    public int deleteHzCourseImageByIds(Long[] ids)
    {
        return hzCourseImageMapper.deleteHzCourseImageByIds(ids);
    }

    /**
     * 删除课程镜像信息
     * 
     * @param id 课程镜像ID
     * @return 结果
     */
    @Override
    public int deleteHzCourseImageById(Long id)
    {
        return hzCourseImageMapper.deleteHzCourseImageById(id);
    }
}
