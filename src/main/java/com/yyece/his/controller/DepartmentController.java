package com.yyece.his.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yyece.his.entity.Department;
import com.yyece.his.entity.Result;
import com.yyece.his.entity.ResultCode;
import com.yyece.his.service.DepartmentService;
import com.yyece.his.utils.IdWorker;
import org.apache.ibatis.annotations.Options;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 科室表(Department)表控制层
 *
 * @author makejava
 * @since 2020-03-10 11:35:12
 */
@RestController
@RequestMapping("department")
public class DepartmentController extends BaseController {

    private static final Logger log = LoggerFactory.getLogger(DepartmentController.class);
    /**
     * 服务对象
     */
    @Resource
    private DepartmentService departmentService;

    @Autowired
    private IdWorker idWorker;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param department 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Department> page, Department department) {
        QueryWrapper queryWrapper = new QueryWrapper<>(department);
        queryWrapper.eq("isdeleted",0);
        return success(this.departmentService.page(page, queryWrapper));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.departmentService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param department 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody Department department) {
        return success(this.departmentService.save(department));
    }

    /**
     * 修改数据
     *
     * @param department 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Department department) {
        return success(this.departmentService.updateById(department));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.departmentService.removeByIds(idList));
    }

    @PostMapping("/save")
    public Result saveDepartment(@RequestBody Map<String, Object> map) {
        boolean result = departmentService.saveDepartment(map);
        if (result) {
            return new Result(ResultCode.SUCCESS);
        } else {
            return new Result(ResultCode.FAIL);
        }
    }

    @PostMapping("/modify")
    public Result modifyDepartment(@RequestBody Map<String, Object> map) {
        boolean result = departmentService.modifyDepartment(map);
        if (result) {
            return new Result(ResultCode.SUCCESS);
        } else {
            return new Result(ResultCode.FAIL);
        }
    }

    @Options(useGeneratedKeys = false)
    @PostMapping("/delete")
    public Result deleteByDoctorId(@RequestBody Map<String, Object> map) {
        log.info("======map======"+map);
        boolean result = departmentService.deleteByDepartmentId(map);
        if (result) {
            return new Result(ResultCode.SUCCESS);
        } else {
            return new Result(ResultCode.FAIL);
        }
    }
}