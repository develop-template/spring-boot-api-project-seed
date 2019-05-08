package cn.huacloud.tax.web;
import cn.huacloud.tax.core.Result;
import cn.huacloud.tax.core.ResultGenerator;
import cn.huacloud.tax.model.PromotionAction;
import cn.huacloud.tax.service.PromotionActionService;
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
@Api(tags="PromotionAction管理")
@RestController
@RequestMapping("/promotion/action")
public class PromotionActionController {
    @Autowired
    private PromotionActionService promotionActionService;

    @ApiOperation("新增用户")
    @PostMapping("/add")
    public Result add(PromotionAction promotionAction) {
        promotionActionService.save(promotionAction);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        promotionActionService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(PromotionAction promotionAction) {
        promotionActionService.update(promotionAction);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation("PromotionAction详情")
    @GetMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        PromotionAction promotionAction = promotionActionService.findById(id);
        return ResultGenerator.genSuccessResult(promotionAction);
    }

    @ApiOperation("PromotionAction列表")
    @GetMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<PromotionAction> list = promotionActionService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
