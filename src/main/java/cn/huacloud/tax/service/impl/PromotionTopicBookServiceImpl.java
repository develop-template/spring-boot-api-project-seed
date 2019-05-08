package cn.huacloud.tax.service.impl;

import cn.huacloud.tax.dao.PromotionTopicBookMapper;
import cn.huacloud.tax.model.PromotionTopicBook;
import cn.huacloud.tax.service.PromotionTopicBookService;
import cn.huacloud.tax.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * @author  ouzhx on 2019/02/15.
 */
@Service
@Transactional
public class PromotionTopicBookServiceImpl extends AbstractService<PromotionTopicBook> implements PromotionTopicBookService {
    @Resource
    private PromotionTopicBookMapper promotionTopicBookMapper;

}
