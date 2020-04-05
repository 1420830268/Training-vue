package com.xuanyuan.training.project.docker.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.xuanyuan.training.framework.aspectj.lang.annotation.Excel;
import com.xuanyuan.training.framework.web.domain.BaseEntity;

/**
 * 系统镜像对象 hz_image
 * 
 * @author Lee
 * @date 2020-04-05
 */
public class HzImage extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long id;

    /** 镜像ID */
    @Excel(name = "镜像ID")
    private String imageId;

    /** 镜像名 */
    @Excel(name = "镜像名")
    private String imageName;

    /** 镜像仓库 */
    @Excel(name = "镜像仓库")
    private String repository;

    /** 标识版本 */
    @Excel(name = "标识版本")
    private String tag;

    /** 大小 */
    @Excel(name = "大小")
    private Double size;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setImageId(String imageId) 
    {
        this.imageId = imageId;
    }

    public String getImageId() 
    {
        return imageId;
    }
    public void setImageName(String imageName) 
    {
        this.imageName = imageName;
    }

    public String getImageName() 
    {
        return imageName;
    }
    public void setRepository(String repository) 
    {
        this.repository = repository;
    }

    public String getRepository() 
    {
        return repository;
    }
    public void setTag(String tag) 
    {
        this.tag = tag;
    }

    public String getTag() 
    {
        return tag;
    }
    public void setSize(Double size) 
    {
        this.size = size;
    }

    public Double getSize() 
    {
        return size;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("imageId", getImageId())
            .append("imageName", getImageName())
            .append("repository", getRepository())
            .append("tag", getTag())
            .append("size", getSize())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("delFlag", getDelFlag())
            .toString();
    }
}
