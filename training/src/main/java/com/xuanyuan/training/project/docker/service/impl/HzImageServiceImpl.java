package com.xuanyuan.training.project.docker.service.impl;

import java.util.List;
import com.xuanyuan.training.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xuanyuan.training.project.docker.mapper.HzImageMapper;
import com.xuanyuan.training.project.docker.domain.HzImage;
import com.xuanyuan.training.project.docker.service.IHzImageService;

/**
 * 系统镜像Service业务层处理
 * 
 * @author Lee
 * @date 2020-04-05
 */
@Service
public class HzImageServiceImpl implements IHzImageService 
{
    @Autowired
    private HzImageMapper hzImageMapper;

    /**
     * 查询系统镜像
     * 
     * @param id 系统镜像ID
     * @return 系统镜像
     */
    @Override
    public HzImage selectHzImageById(Long id)
    {
        return hzImageMapper.selectHzImageById(id);
    }

    /**
     * 查询系统镜像列表
     * 
     * @param hzImage 系统镜像
     * @return 系统镜像
     */
    @Override
    public List<HzImage> selectHzImageList(HzImage hzImage)
    {
        return hzImageMapper.selectHzImageList(hzImage);
    }

    /**
     * 新增系统镜像
     * 
     * @param hzImage 系统镜像
     * @return 结果
     */
    @Override
    public int insertHzImage(HzImage hzImage)
    {
        hzImage.setCreateTime(DateUtils.getNowDate());
        return hzImageMapper.insertHzImage(hzImage);
    }

    /**
     * 修改系统镜像
     * 
     * @param hzImage 系统镜像
     * @return 结果
     */
    @Override
    public int updateHzImage(HzImage hzImage)
    {
        hzImage.setUpdateTime(DateUtils.getNowDate());
        return hzImageMapper.updateHzImage(hzImage);
    }

    /**
     * 批量删除系统镜像
     * 
     * @param ids 需要删除的系统镜像ID
     * @return 结果
     */
    @Override
    public int deleteHzImageByIds(Long[] ids)
    {
        return hzImageMapper.deleteHzImageByIds(ids);
    }

    /**
     * 删除系统镜像信息
     * 
     * @param id 系统镜像ID
     * @return 结果
     */
    @Override
    public int deleteHzImageById(Long id)
    {
        return hzImageMapper.deleteHzImageById(id);
    }
}
