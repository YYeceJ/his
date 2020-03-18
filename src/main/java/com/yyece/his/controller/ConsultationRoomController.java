package com.yyece.his.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yyece.his.entity.ConsultationRoom;
import com.yyece.his.entity.Result;
import com.yyece.his.entity.ResultCode;
import com.yyece.his.service.ConsultationRoomService;
import org.apache.ibatis.annotations.Options;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 诊室(ConsultationRoom)表控制层
 *
 * @author makejava
 * @since 2020-03-17 12:41:47
 */
@RestController
@RequestMapping("consultationRoom")
public class ConsultationRoomController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private ConsultationRoomService consultationRoomService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param consultationRoom 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<ConsultationRoom> page, ConsultationRoom consultationRoom) {
        return success(this.consultationRoomService.page(page, new QueryWrapper<>(consultationRoom)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.consultationRoomService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param consultationRoom 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody ConsultationRoom consultationRoom) {
        return success(this.consultationRoomService.save(consultationRoom));
    }

    /**
     * 修改数据
     *
     * @param consultationRoom 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody ConsultationRoom consultationRoom) {
        return success(this.consultationRoomService.updateById(consultationRoom));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.consultationRoomService.removeByIds(idList));
    }


    @PostMapping("/save")
    public Result saveDoctor(@RequestBody Map<String, Object> map) {
        boolean result = consultationRoomService.saveRoom(map);
        if (result) {
            return new Result(ResultCode.SUCCESS);
        } else {
            return new Result(ResultCode.FAIL);
        }
    }

    @PostMapping("/modify")
    public Result modify(@RequestBody Map<String, Object> map) {
        boolean result = consultationRoomService.modify(map);
        if (result) {
            return new Result(ResultCode.SUCCESS);
        } else {
            return new Result(ResultCode.FAIL);
        }
    }

    @PostMapping("/delete")
    public Result deleteByDoctorId(@RequestBody Map<String, Object> map) {
        boolean result = consultationRoomService.deleteByRoomId(map);
        if (result) {
            return new Result(ResultCode.SUCCESS);
        } else {
            return new Result(ResultCode.FAIL);
        }
    }
}