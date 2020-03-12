package com.yyece.his.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yyece.his.entity.Scheduling;
import com.yyece.his.service.SchedulingService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Scheduling)表控制层
 *
 * @author makejava
 * @since 2020-03-11 06:54:48
 */
@RestController
@RequestMapping("scheduling")
public class SchedulingController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private SchedulingService schedulingService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param scheduling 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Scheduling> page, Scheduling scheduling) {
        return success(this.schedulingService.page(page, new QueryWrapper<>(scheduling)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.schedulingService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param scheduling 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody Scheduling scheduling) {
        return success(this.schedulingService.save(scheduling));
    }

    /**
     * 修改数据
     *
     * @param scheduling 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Scheduling scheduling) {
        return success(this.schedulingService.updateById(scheduling));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.schedulingService.removeByIds(idList));
    }
}