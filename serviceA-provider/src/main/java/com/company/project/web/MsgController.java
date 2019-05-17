package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.Msg;
import com.company.project.service.MsgService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
* @author  ouzhx on 2019/05/17.
*/
@Api(tags="Msg管理")
@RestController
@RequestMapping("/msg")
public class MsgController {
    @Autowired
    private MsgService msgService;

    @ApiOperation("新增用户")
    @PostMapping("/add")
    public Result add(Msg msg) {
        msgService.save(msg);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        msgService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(Msg msg) {
        msgService.update(msg);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation("Msg详情")
    @GetMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        Msg msg = msgService.findById(id);
        return ResultGenerator.genSuccessResult(msg);
    }

    @ApiOperation("Msg列表")
    @GetMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Msg> list = msgService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
