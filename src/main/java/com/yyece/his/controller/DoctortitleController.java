package com.yyece.his.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yyece.his.entity.Doctortitle;
import com.yyece.his.service.DoctortitleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Doctortitle)表控制层
 *
 * @author makejava
 * @since 2020-03-10 11:35:39
 */
@RestController
@RequestMapping("doctortitle")
public class DoctortitleController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private DoctortitleService doctortitleService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param doctortitle 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Doctortitle> page, Doctortitle doctortitle) {
        return success(this.doctortitleService.page(page, new QueryWrapper<>(doctortitle)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.doctortitleService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param doctortitle 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody Doctortitle doctortitle) {
        return success(this.doctortitleService.save(doctortitle));
    }

    /**
     * 修改数据
     *
     * @param doctortitle 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Doctortitle doctortitle) {
        return success(this.doctortitleService.updateById(doctortitle));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.doctortitleService.removeByIds(idList));
    }
}