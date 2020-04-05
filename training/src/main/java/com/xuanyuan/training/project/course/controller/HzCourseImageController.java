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
import com.xuanyuan.training.project.course.domain.HzCourseImage;
import com.xuanyuan.training.project.course.service.IHzCourseImageService;
import com.xuanyuan.training.framework.web.controller.BaseController;
import com.xuanyuan.training.framework.web.domain.AjaxResult;
import com.xuanyuan.training.common.utils.poi.ExcelUtil;
import com.xuanyuan.training.framework.web.page.TableDataInfo;

/**
 * 课程镜像Controller
 * 
 * @author Lee
 * @date 2020-04-05
 */
@RestController
@RequestMapping("/course/image")
public class HzCourseImageController extends BaseController
{
    @Autowired
    private IHzCourseImageService hzCourseImageService;

    /**
     * 查询课程镜像列表
     */
    @PreAuthorize("@ss.hasPermi('course:image:list')")
    @GetMapping("/list")
    public TableDataInfo list(HzCourseImage hzCourseImage)
    {
        startPage();
        List<HzCourseImage> list = hzCourseImageService.selectHzCourseImageList(hzCourseImage);
        return getDataTable(list);
    }

    /**
     * 导出课程镜像列表
     */
    @PreAuthorize("@ss.hasPermi('course:image:export')")
    @Log(title = "课程镜像", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(HzCourseImage hzCourseImage)
    {
        List<HzCourseImage> list = hzCourseImageService.selectHzCourseImageList(hzCourseImage);
        ExcelUtil<HzCourseImage> util = new ExcelUtil<HzCourseImage>(HzCourseImage.class);
        return util.exportExcel(list, "image");
    }

    /**
     * 获取课程镜像详细信息
     */
    @PreAuthorize("@ss.hasPermi('course:image:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(hzCourseImageService.selectHzCourseImageById(id));
    }

    /**
     * 新增课程镜像
     */
    @PreAuthorize("@ss.hasPermi('course:image:add')")
    @Log(title = "课程镜像", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HzCourseImage hzCourseImage)
    {
        return toAjax(hzCourseImageService.insertHzCourseImage(hzCourseImage));
    }

    /**
     * 修改课程镜像
     */
    @PreAuthorize("@ss.hasPermi('course:image:edit')")
    @Log(title = "课程镜像", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HzCourseImage hzCourseImage)
    {
        return toAjax(hzCourseImageService.updateHzCourseImage(hzCourseImage));
    }

    /**
     * 删除课程镜像
     */
    @PreAuthorize("@ss.hasPermi('course:image:remove')")
    @Log(title = "课程镜像", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(hzCourseImageService.deleteHzCourseImageByIds(ids));
    }
}
