package cn.huacloud.tax.web;
import cn.huacloud.tax.core.Result;
import cn.huacloud.tax.core.ResultGenerator;
import cn.huacloud.tax.model.PromotionTopicBook;
import cn.huacloud.tax.service.PromotionTopicBookService;
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
@Api(tags="PromotionTopicBook管理")
@RestController
@RequestMapping("/promotion/topic/book")
public class PromotionTopicBookController {
    @Autowired
    private PromotionTopicBookService promotionTopicBookService;

    @ApiOperation("新增用户")
    @PostMapping("/add")
    public Result add(PromotionTopicBook promotionTopicBook) {
        promotionTopicBookService.save(promotionTopicBook);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        promotionTopicBookService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(PromotionTopicBook promotionTopicBook) {
        promotionTopicBookService.update(promotionTopicBook);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation("PromotionTopicBook详情")
    @GetMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        PromotionTopicBook promotionTopicBook = promotionTopicBookService.findById(id);
        return ResultGenerator.genSuccessResult(promotionTopicBook);
    }

    @ApiOperation("PromotionTopicBook列表")
    @GetMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<PromotionTopicBook> list = promotionTopicBookService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
