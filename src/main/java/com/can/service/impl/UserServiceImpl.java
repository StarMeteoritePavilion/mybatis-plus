package com.can.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.can.entity.UserInfo;
import com.can.mapper.UserInfoMapper;
import com.can.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * <pre>
 *
 * </pre>
 *
 * @author canxin.li
 * @date 2020-10-16 16:20
 */

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserInfoMapper userMapper;

    @Override
    public boolean insertUser() {

        UserInfo userInfo = new UserInfo();
        userInfo.setBirthday(LocalDateTime.now());
        userInfo.setUserAge(LocalDateTime.now().getSecond());
        userInfo.setUserName("测试");
        int insert = userMapper.insert(userInfo);
        return insert == 1;
    }

    @Override
    public UserInfo selectUser(Integer userId) {
        log.info("userId:{}", userId);
        return userMapper.selectUserById(userId);
    }

    @Override
    @Transactional
    public Boolean updateSlowNoIndex(Integer userId) {

        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("测试" + userId);
        int update = userMapper.update(userInfo, new UpdateWrapper<UserInfo>().lambda().eq(UserInfo::getUserAge, userId));
/*
        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            log.info("异常--->{}", e.getMessage(), e);
        }*/

        return update == 1;
    }

    @Override
    @Transactional
    public Boolean updateQuickNoIndex(Integer userId) {

        try {
            UserInfo userInfo = new UserInfo();
            userInfo.setUserName("测试" + userId);

            int update = userMapper.update(userInfo, new UpdateWrapper<UserInfo>().lambda().eq(UserInfo::getUserId, userId));
            return update == 1;
        } catch (Exception e) {
            log.info("{}", e.getMessage(), e);
        }
        return Boolean.FALSE;
    }
}
