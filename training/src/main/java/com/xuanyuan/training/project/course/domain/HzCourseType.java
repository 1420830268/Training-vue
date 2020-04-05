package com.xuanyuan.training.project.course.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.xuanyuan.training.framework.aspectj.lang.annotation.Excel;
import com.xuanyuan.training.framework.web.domain.BaseEntity;

/**
 * 课程类型对象 hz_course_type
 * 
 * @author Lee
 * @date 2020-04-03
 */
public class HzCourseType extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long id;

    /** 类型名称 */
    @Excel(name = "类型名称")
    private String typeName;

    /** 类型描述 */
    @Excel(name = "类型描述")
    private String typeDescribe;

    /** 排序 */
    @Excel(name = "排序")
    private Long sort;

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
    public void setTypeName(String typeName) 
    {
        this.typeName = typeName;
    }

    public String getTypeName() 
    {
        return typeName;
    }
    public void setTypeDescribe(String typeDescribe) 
    {
        this.typeDescribe = typeDescribe;
    }

    public String getTypeDescribe() 
    {
        return typeDescribe;
    }
    public void setSort(Long sort) 
    {
        this.sort = sort;
    }

    public Long getSort() 
    {
        return sort;
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
            .append("typeName", getTypeName())
            .append("typeDescribe", getTypeDescribe())
            .append("sort", getSort())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("delFlag", getDelFlag())
            .toString();
    }
}
