package com.can.service.impl;

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

    @Resource
    private HelpServiceImpl helpServiceImpl;

    /****************************** insert01 start ******************************************/
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean insertUser01() {

        if (1 == userMapper.insert(getUserInfo())) {
            throw new RuntimeException("插入成功, 回滚");
        }
        return Boolean.FALSE;
    }
    /****************************** insert01 end ******************************************/



    /****************************** insert02 start ******************************************/
    @Override
    public boolean insertUser02() {
        return insertUser02Next();
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean insertUser02Next() {
        if (1 == userMapper.insert(getUserInfo())) {
            throw new RuntimeException("插入成功, 回滚");
        }
        return Boolean.FALSE;
    }

    /****************************** insert02 end ******************************************/




    /****************************** insert03 start ******************************************/

    @Override
    public boolean insertUser03() {
        return insertUser03Next();
    }

    @Transactional(rollbackFor = Exception.class)
    boolean insertUser03Next() {
        if (1 == userMapper.insert(getUserInfo())) {
            throw new RuntimeException("插入成功, 回滚");
        }
        return Boolean.FALSE;
    }

    /****************************** insert03 end ******************************************/


    /****************************** insert04 start ******************************************/

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean insertUser04() {
        boolean result = helpServiceImpl.insertUser(getUserInfo());
        if (result) {
            throw new RuntimeException("插入成功, 回滚");
        }
        return Boolean.FALSE;
    }

    /****************************** insert04 end ******************************************/

    /****************************** insert05 start ******************************************/

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean insertUser05() {
        return helpServiceImpl.insertUserException(getUserInfo());
    }

    /****************************** insert05 end ******************************************/

    /****************************** insert06 start ******************************************/

    @Override
    public boolean insertUser06() {
        return insertUser06Next();
    }

    private boolean insertUser06Next() {
        return helpServiceImpl.insertUserTransaction(getUserInfo());
    }
    /****************************** insert06 end ******************************************/


    private UserInfo getUserInfo() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("用户名");
        userInfo.setUserAge(123);
        userInfo.setBirthday(LocalDateTime.now());
        return userInfo;
    }
}
