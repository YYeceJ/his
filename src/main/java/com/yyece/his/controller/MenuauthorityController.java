package com.yyece.his.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yyece.his.entity.Menuauthority;
import com.yyece.his.service.MenuauthorityService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Menuauthority)表控制层
 *
 * @author makejava
 * @since 2020-03-11 20:02:18
 */
@RestController
@RequestMapping("menuauthority")
public class MenuauthorityController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private MenuauthorityService menuauthorityService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param menuauthority 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Menuauthority> page, Menuauthority menuauthority) {
        return success(this.menuauthorityService.page(page, new QueryWrapper<>(menuauthority)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.menuauthorityService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param menuauthority 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody Menuauthority menuauthority) {
        return success(this.menuauthorityService.save(menuauthority));
    }

    /**
     * 修改数据
     *
     * @param menuauthority 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Menuauthority menuauthority) {
        return success(this.menuauthorityService.updateById(menuauthority));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.menuauthorityService.removeByIds(idList));
    }
}