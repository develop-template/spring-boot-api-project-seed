package com.company.project.service.impl;

import com.company.project.dao.MsgMapper;
import com.company.project.model.Msg;
import com.company.project.service.MsgService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * @author  ouzhx on 2019/05/17.
 */
@Service
@Transactional
public class MsgServiceImpl extends AbstractService<Msg> implements MsgService {
    @Resource
    private MsgMapper msgMapper;

}
