package cn.huacloud.tax.web;
import cn.huacloud.tax.core.Result;
import cn.huacloud.tax.core.ResultGenerator;
import cn.huacloud.tax.model.PromotionBook;
import cn.huacloud.tax.service.PromotionBookService;
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
@Api(tags="PromotionBook管理")
@RestController
@RequestMapping("/promotion/book")
public class PromotionBookController {
    @Autowired
    private PromotionBookService promotionBookService;

    @ApiOperation("新增用户")
    @PostMapping("/add")
    public Result add(PromotionBook promotionBook) {
        promotionBookService.save(promotionBook);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        promotionBookService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(PromotionBook promotionBook) {
        promotionBookService.update(promotionBook);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation("PromotionBook详情")
    @GetMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        PromotionBook promotionBook = promotionBookService.findById(id);
        return ResultGenerator.genSuccessResult(promotionBook);
    }

    @ApiOperation("PromotionBook列表")
    @GetMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<PromotionBook> list = promotionBookService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
