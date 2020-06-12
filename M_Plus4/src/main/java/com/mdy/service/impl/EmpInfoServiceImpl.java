package com.mdy.service.impl;

import com.mdy.entity.EmpInfo;
import com.mdy.dao.EmpInfoMapper;
import com.mdy.service.IEmpInfoService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mdy
 * @since 2020-05-19
 */
@Service
public class EmpInfoServiceImpl extends ServiceImpl<EmpInfoMapper, EmpInfo> implements IEmpInfoService {

}
