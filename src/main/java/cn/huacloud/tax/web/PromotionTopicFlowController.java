package cn.huacloud.tax.web;
import cn.huacloud.tax.core.Result;
import cn.huacloud.tax.core.ResultGenerator;
import cn.huacloud.tax.model.PromotionTopicFlow;
import cn.huacloud.tax.service.PromotionTopicFlowService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
* @author  ouzhx on 2019/02/15.
*/
@Api(tags="PromotionTopicFlow管理")
@RestController
@RequestMapping("/promotion/topic/flow")
public class PromotionTopicFlowController {
    @Autowired
    private PromotionTopicFlowService promotionTopicFlowService;

    @ApiOperation("新增用户")
    @PostMapping("/add")
    public Result add(PromotionTopicFlow promotionTopicFlow) {
        promotionTopicFlowService.save(promotionTopicFlow);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        promotionTopicFlowService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(PromotionTopicFlow promotionTopicFlow) {
        promotionTopicFlowService.update(promotionTopicFlow);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation("PromotionTopicFlow详情")
    @GetMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        PromotionTopicFlow promotionTopicFlow = promotionTopicFlowService.findById(id);
        return ResultGenerator.genSuccessResult(promotionTopicFlow);
    }

    @ApiOperation("PromotionTopicFlow列表")
    @GetMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<PromotionTopicFlow> list = promotionTopicFlowService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
