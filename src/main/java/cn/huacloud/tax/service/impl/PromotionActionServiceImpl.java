package cn.huacloud.tax.service.impl;

import cn.huacloud.tax.dao.PromotionActionMapper;
import cn.huacloud.tax.model.PromotionAction;
import cn.huacloud.tax.service.PromotionActionService;
import cn.huacloud.tax.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * @author  ouzhx on 2019/02/15.
 */
@Service
@Transactional
public class PromotionActionServiceImpl extends AbstractService<PromotionAction> implements PromotionActionService {
    @Resource
    private PromotionActionMapper promotionActionMapper;

}
