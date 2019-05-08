package cn.huacloud.tax.service.impl;

import cn.huacloud.tax.dao.PromotionMapper;
import cn.huacloud.tax.model.Promotion;
import cn.huacloud.tax.service.PromotionService;
import cn.huacloud.tax.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * @author  ouzhx on 2019/02/15.
 */
@Service
@Transactional
public class PromotionServiceImpl extends AbstractService<Promotion> implements PromotionService {
    @Resource
    private PromotionMapper promotionMapper;

}
