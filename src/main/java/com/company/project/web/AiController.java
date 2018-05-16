package com.company.project.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author ouzhx on 2018/05/05.
 * 
 *         提供 腾讯ai 相关功能接口: http://ai.qq.com/doc/index.shtml
 * 
 */
@Api(tags = "腾讯ai接口管理管理")
@RestController
@RequestMapping("/ai")
public class AiController {

  @ApiOperation("创建用户")
  @PostMapping("/add")
  public Result add(User user) {
    return ResultGenerator.genSuccessResult();
  }

  @ApiIgnore
  @PostMapping("/delete/{id}")
  public Result delete(@PathVariable Integer id) {
    return ResultGenerator.genSuccessResult();
  }

  @PostMapping("/update")
  public Result update(User user) {
    return ResultGenerator.genSuccessResult();
  }
}
