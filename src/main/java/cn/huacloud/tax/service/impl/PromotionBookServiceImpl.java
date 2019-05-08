package cn.huacloud.tax.service.impl;

import cn.huacloud.tax.dao.PromotionBookMapper;
import cn.huacloud.tax.model.PromotionBook;
import cn.huacloud.tax.service.PromotionBookService;
import cn.huacloud.tax.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * @author  ouzhx on 2019/02/15.
 */
@Service
@Transactional
public class PromotionBookServiceImpl extends AbstractService<PromotionBook> implements PromotionBookService {
    @Resource
    private PromotionBookMapper promotionBookMapper;

}
