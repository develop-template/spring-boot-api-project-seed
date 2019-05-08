package cn.huacloud.tax.service.impl;

import cn.huacloud.tax.dao.PromotionTopicMapper;
import cn.huacloud.tax.model.PromotionTopic;
import cn.huacloud.tax.service.PromotionTopicService;
import cn.huacloud.tax.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * @author  ouzhx on 2019/02/15.
 */
@Service
@Transactional
public class PromotionTopicServiceImpl extends AbstractService<PromotionTopic> implements PromotionTopicService {
    @Resource
    private PromotionTopicMapper promotionTopicMapper;

}
