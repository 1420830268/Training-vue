package com.xuanyuan.training.project.course.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.xuanyuan.training.framework.aspectj.lang.annotation.Excel;
import com.xuanyuan.training.framework.web.domain.BaseEntity;
import org.springframework.data.annotation.Transient;


/**
 * 课程实体类对象 hz_course
 * 
 * @author Lee
 * @date 2020-04-03
 */
public class HzCourse extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long id;

    /** 课程名称 */
    @Excel(name = "课程名称")
    private String courseName;

    /** 课程编号 */
    @Excel(name = "课程编号")
    private String courseSn;

    /** 课程图片路径 */
    @Excel(name = "课程图片路径")
    private String courseLogo;

    /** 课程类型ID */
    @Excel(name = "课程类型ID")
    private Long courseTypeId;

    /** 课程简介 */
    @Excel(name = "课程简介")
    private String courseIntor;

    /** 学分 */
    @Excel(name = "学分")
    private Integer score;

    /** 序号 */
    @Excel(name = "序号")
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
    public void setCourseName(String courseName) 
    {
        this.courseName = courseName;
    }

    public String getCourseName() 
    {
        return courseName;
    }
    public void setCourseSn(String courseSn) 
    {
        this.courseSn = courseSn;
    }

    public String getCourseSn() 
    {
        return courseSn;
    }
    public void setCourseLogo(String courseLogo) 
    {
        this.courseLogo = courseLogo;
    }

    public String getCourseLogo()
    {
        return courseLogo;
    }
    public void setCourseTypeId(Long courseTypeId)
    {
        this.courseTypeId = courseTypeId;
    }

    public Long getCourseTypeId()
    {
        return courseTypeId;
    }
    public void setCourseIntor(String courseIntor) 
    {
        this.courseIntor = courseIntor;
    }

    public String getCourseIntor() 
    {
        return courseIntor;
    }
    public void setScore(Integer score) 
    {
        this.score = score;
    }

    public Integer getScore() 
    {
        return score;
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
            .append("courseName", getCourseName())
            .append("courseSn", getCourseSn())
            .append("courseLogo", getCourseLogo())
            .append("courseTypeId", getCourseTypeId())
            .append("courseIntor", getCourseIntor())
            .append("score", getScore())
            .append("sort", getSort())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("delFlag", getDelFlag())
            .toString();
    }


    private String typeName;//类型名

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
