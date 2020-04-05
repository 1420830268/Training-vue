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
import com.xuanyuan.training.project.course.domain.HzCourseType;
import com.xuanyuan.training.project.course.service.IHzCourseTypeService;
import com.xuanyuan.training.framework.web.controller.BaseController;
import com.xuanyuan.training.framework.web.domain.AjaxResult;
import com.xuanyuan.training.common.utils.poi.ExcelUtil;
import com.xuanyuan.training.framework.web.page.TableDataInfo;

/**
 * 课程类型Controller
 * 
 * @author Lee
 * @date 2020-04-03
 */
@RestController
@RequestMapping("/course/type")
public class HzCourseTypeController extends BaseController
{
    @Autowired
    private IHzCourseTypeService hzCourseTypeService;

    /**
     * 查询课程类型列表
     */
    @PreAuthorize("@ss.hasPermi('course:type:list')")
    @GetMapping("/list")
    public TableDataInfo list(HzCourseType hzCourseType)
    {
        startPage();
        List<HzCourseType> list = hzCourseTypeService.selectHzCourseTypeList(hzCourseType);
        return getDataTable(list);
    }

    /**
     * 导出课程类型列表
     */
    @PreAuthorize("@ss.hasPermi('course:type:export')")
    @Log(title = "课程类型", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(HzCourseType hzCourseType)
    {
        List<HzCourseType> list = hzCourseTypeService.selectHzCourseTypeList(hzCourseType);
        ExcelUtil<HzCourseType> util = new ExcelUtil<HzCourseType>(HzCourseType.class);
        return util.exportExcel(list, "type");
    }

    /**
     * 获取课程类型详细信息
     */
    @PreAuthorize("@ss.hasPermi('course:type:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(hzCourseTypeService.selectHzCourseTypeById(id));
    }

    /**
     * 获取课程类型详细信息
     */
    @PreAuthorize("@ss.hasPermi('course:type:query')")
    @GetMapping(value = "/getTypeList")
    public AjaxResult getTypeList(){
        AjaxResult ajax = AjaxResult.success();
        List<HzCourseType> list = hzCourseTypeService.selectHzCourseTypeList(new HzCourseType());
        ajax.put("typeList",list);
        return ajax;
    }

    /**
     * 新增课程类型
     */
    @PreAuthorize("@ss.hasPermi('course:type:add')")
    @Log(title = "课程类型", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HzCourseType hzCourseType)
    {
        return toAjax(hzCourseTypeService.insertHzCourseType(hzCourseType));
    }

    /**
     * 修改课程类型
     */
    @PreAuthorize("@ss.hasPermi('course:type:edit')")
    @Log(title = "课程类型", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HzCourseType hzCourseType)
    {
        return toAjax(hzCourseTypeService.updateHzCourseType(hzCourseType));
    }

    /**
     * 删除课程类型
     */
    @PreAuthorize("@ss.hasPermi('course:type:remove')")
    @Log(title = "课程类型", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(hzCourseTypeService.deleteHzCourseTypeByIds(ids));
    }
}
