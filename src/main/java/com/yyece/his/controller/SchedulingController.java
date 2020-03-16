package com.yyece.his.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yyece.his.entity.Result;
import com.yyece.his.entity.ResultCode;
import com.yyece.his.entity.Scheduling;
import com.yyece.his.service.SchedulingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Scheduling)表控制层
 *
 * @author makejava
 * @since 2020-03-15 02:53:28
 */
@RestController
@RequestMapping("scheduling")
public class SchedulingController extends BaseController {
    /**
     * 服务对象
     */
    @Resource
    private SchedulingService schedulingService;

    private static final Logger log = LoggerFactory.getLogger(SchedulingController.class);

//    /**
//     * 分页查询所有数据
//     *
//     * @param page       分页对象
//     * @param scheduling 查询实体
//     * @return 所有数据
//     */
//    @GetMapping
//    public Result selectAll(Page<Scheduling> page, Scheduling scheduling) {
//        log.info("---------" + scheduling);
//        QueryWrapper<Scheduling> queryWrapper = new QueryWrapper<>();
//        queryWrapper.orderByAsc("schedulingid");
//        queryWrapper.eq("departmentid", scheduling.getDepartmentid());
//        queryWrapper.eq("roomid", scheduling.getRoomid());
//        queryWrapper.eq("date", scheduling.getDate());
//        List<Scheduling> schedulings = this.schedulingService.list(queryWrapper);
//        return new Result(ResultCode.SUCCESS, schedulings);
//    }

    @GetMapping
    public Result querySchedulingByParam(Scheduling scheduling){
        JSONObject jsonObject = new JSONObject();
        log.info("===========scheduling=========="+jsonObject.toJSONString(scheduling));
        List<Scheduling> schedulings = schedulingService.querySchedulingByParam(scheduling);
        return new Result(ResultCode.SUCCESS,schedulings);
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

    @PostMapping("/save")
    public Result saveScheduling(@RequestBody Map<String, Object> map) {
        boolean result = schedulingService.saveScheduling(map);
        if (result) {
            return new Result(ResultCode.SUCCESS);
        } else {
            return new Result(ResultCode.FAIL);
        }
    }

    @PostMapping("/modify")
    public Result modifyScheduling(@RequestBody Map<String, Object> map) {
        log.info("=================="+map);
        boolean result = schedulingService.modifyScheduling(map);
        if (result) {
            return new Result(ResultCode.SUCCESS);
        } else {
            return new Result(ResultCode.FAIL);
        }
    }

    @PostMapping("/delete")
    public Result deleteBySchedulingId(@RequestBody Map<String, Object> map) {
        boolean result = schedulingService.deleteBySchedulingId(map);
        if (result) {
            return new Result(ResultCode.SUCCESS);
        } else {
            return new Result(ResultCode.FAIL);
        }
    }
}