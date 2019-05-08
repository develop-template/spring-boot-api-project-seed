package cn.huacloud.tax.web;
import cn.huacloud.tax.core.Result;
import cn.huacloud.tax.core.ResultGenerator;
import cn.huacloud.tax.model.PromotionTopic;
import cn.huacloud.tax.service.PromotionTopicService;
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
@Api(tags="PromotionTopic管理")
@RestController
@RequestMapping("/promotion/topic")
public class PromotionTopicController {
    @Autowired
    private PromotionTopicService promotionTopicService;

    @ApiOperation("新增用户")
    @PostMapping("/add")
    public Result add(PromotionTopic promotionTopic) {
        promotionTopicService.save(promotionTopic);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        promotionTopicService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(PromotionTopic promotionTopic) {
        promotionTopicService.update(promotionTopic);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation("PromotionTopic详情")
    @GetMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        PromotionTopic promotionTopic = promotionTopicService.findById(id);
        return ResultGenerator.genSuccessResult(promotionTopic);
    }

    @ApiOperation("PromotionTopic列表")
    @GetMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<PromotionTopic> list = promotionTopicService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
