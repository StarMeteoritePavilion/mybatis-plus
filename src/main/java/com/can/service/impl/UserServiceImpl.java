package com.can.service.impl;

import com.can.entity.UserInfo;
import com.can.mapper.UserInfoMapper;
import com.can.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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

      /*  UserInfo userInfo1 = userMapper.selectById(2);
        log.info("{}", userInfo1); */

        UserInfo userInfo = new UserInfo();


        userInfo.setBirthday(LocalDateTime.now());
        userInfo.setUserAge(12);
        userInfo.setUserName("测试");
        int insert = userMapper.insert(userInfo);

        return insert == 1;
    }

    @Override
    public UserInfo selectUser(Integer userId) {
        log.info("userId:{}", userId);
        return userMapper.selectUserById(userId);
    }
}
