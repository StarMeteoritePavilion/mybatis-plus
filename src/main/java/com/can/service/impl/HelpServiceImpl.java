package com.can.service.impl;

import com.can.entity.UserInfo;
import com.can.mapper.UserInfoMapper;
import com.can.service.HelpService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * <pre>
 *
 * </pre>
 *
 * @author canxin.li
 * @date 2020-10-19 16:02
 */
@Service
public class HelpServiceImpl implements HelpService {

    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public boolean insertUser(UserInfo userInfo) {
        int insert = userInfoMapper.insert(userInfo);
        return insert == 1;
    }

    @Override
    public boolean insertUserException(UserInfo userInfo) {
        if (1 == userInfoMapper.insert(userInfo)) {
            throw new RuntimeException("插入成功, 回滚");
        }
        return Boolean.FALSE;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean insertUserTransaction(UserInfo userInfo) {
        if (1 == userInfoMapper.insert(userInfo)) {
            throw new RuntimeException("插入成功, 回滚");
        }
        return Boolean.FALSE;
    }
}
