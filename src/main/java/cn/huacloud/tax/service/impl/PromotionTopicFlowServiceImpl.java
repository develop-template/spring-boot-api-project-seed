package cn.huacloud.tax.service.impl;

import cn.huacloud.tax.dao.PromotionTopicFlowMapper;
import cn.huacloud.tax.model.PromotionTopicFlow;
import cn.huacloud.tax.service.PromotionTopicFlowService;
import cn.huacloud.tax.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * @author  ouzhx on 2019/02/15.
 */
@Service
@Transactional
public class PromotionTopicFlowServiceImpl extends AbstractService<PromotionTopicFlow> implements PromotionTopicFlowService {
    @Resource
    private PromotionTopicFlowMapper promotionTopicFlowMapper;

}
