package com.xuanyuan.training.project.course.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.xuanyuan.training.framework.aspectj.lang.annotation.Log;
import com.xuanyuan.training.framework.aspectj.lang.enums.BusinessType;
import com.xuanyuan.training.project.course.domain.HzCourse;
import com.xuanyuan.training.project.course.service.IHzCourseService;
import com.xuanyuan.training.framework.web.controller.BaseController;
import com.xuanyuan.training.framework.web.domain.AjaxResult;
import com.xuanyuan.training.common.utils.poi.ExcelUtil;
import com.xuanyuan.training.framework.web.page.TableDataInfo;

/**
 * 课程实体类Controller
 * 
 * @author Lee
 * @date 2020-04-03
 */
@RestController
@RequestMapping("/course/course")
public class HzCourseController extends BaseController
{
    @Autowired
    private IHzCourseService hzCourseService;

    /**
     * 查询课程实体类列表
     */
    @PreAuthorize("@ss.hasPermi('course:course:list')")
    @GetMapping("/list")
    public TableDataInfo list(HzCourse hzCourse)
    {
        startPage();
        List<HzCourse> list = hzCourseService.selectHzCourseList(hzCourse);
        return getDataTable(list);
    }

    /**
     * 导出课程实体类列表
     */
    @PreAuthorize("@ss.hasPermi('course:course:export')")
    @Log(title = "课程实体类", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(HzCourse hzCourse)
    {
        List<HzCourse> list = hzCourseService.selectHzCourseList(hzCourse);
        ExcelUtil<HzCourse> util = new ExcelUtil<HzCourse>(HzCourse.class);
        return util.exportExcel(list, "course");
    }

    /**
     * 获取课程实体类详细信息
     */
    @PreAuthorize("@ss.hasPermi('course:course:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(hzCourseService.selectHzCourseById(id));
    }

    /**
     * 新增课程实体类
     */
    @PreAuthorize("@ss.hasPermi('course:course:add')")
    @Log(title = "课程实体类", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HzCourse hzCourse)
    {
        return toAjax(hzCourseService.insertHzCourse(hzCourse));
    }

    /**
     * 修改课程实体类
     */
    @PreAuthorize("@ss.hasPermi('course:course:edit')")
    @Log(title = "课程实体类", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HzCourse hzCourse)
    {
        return toAjax(hzCourseService.updateHzCourse(hzCourse));
    }

    /**
     * 删除课程实体类
     */
    @PreAuthorize("@ss.hasPermi('course:course:remove')")
    @Log(title = "课程实体类", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(hzCourseService.deleteHzCourseByIds(ids));
    }
}
