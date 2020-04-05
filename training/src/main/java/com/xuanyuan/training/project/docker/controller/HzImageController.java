package com.xuanyuan.training.project.docker.controller;

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
import com.xuanyuan.training.project.docker.domain.HzImage;
import com.xuanyuan.training.project.docker.service.IHzImageService;
import com.xuanyuan.training.framework.web.controller.BaseController;
import com.xuanyuan.training.framework.web.domain.AjaxResult;
import com.xuanyuan.training.common.utils.poi.ExcelUtil;
import com.xuanyuan.training.framework.web.page.TableDataInfo;

/**
 * 系统镜像Controller
 * 
 * @author Lee
 * @date 2020-04-05
 */
@RestController
@RequestMapping("/docker/image")
public class HzImageController extends BaseController
{
    @Autowired
    private IHzImageService hzImageService;

    /**
     * 查询系统镜像列表
     */
    @PreAuthorize("@ss.hasPermi('docker:image:list')")
    @GetMapping("/list")
    public TableDataInfo list(HzImage hzImage)
    {
        startPage();
        List<HzImage> list = hzImageService.selectHzImageList(hzImage);
        return getDataTable(list);
    }

    /**
     * 导出系统镜像列表
     */
    @PreAuthorize("@ss.hasPermi('docker:image:export')")
    @Log(title = "系统镜像", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(HzImage hzImage)
    {
        List<HzImage> list = hzImageService.selectHzImageList(hzImage);
        ExcelUtil<HzImage> util = new ExcelUtil<HzImage>(HzImage.class);
        return util.exportExcel(list, "image");
    }

    /**
     * 获取系统镜像详细信息
     */
    @PreAuthorize("@ss.hasPermi('docker:image:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(hzImageService.selectHzImageById(id));
    }

    /**
     * 新增系统镜像
     */
    @PreAuthorize("@ss.hasPermi('docker:image:add')")
    @Log(title = "系统镜像", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HzImage hzImage)
    {
        return toAjax(hzImageService.insertHzImage(hzImage));
    }

    /**
     * 修改系统镜像
     */
    @PreAuthorize("@ss.hasPermi('docker:image:edit')")
    @Log(title = "系统镜像", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HzImage hzImage)
    {
        return toAjax(hzImageService.updateHzImage(hzImage));
    }

    /**
     * 删除系统镜像
     */
    @PreAuthorize("@ss.hasPermi('docker:image:remove')")
    @Log(title = "系统镜像", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(hzImageService.deleteHzImageByIds(ids));
    }
}
