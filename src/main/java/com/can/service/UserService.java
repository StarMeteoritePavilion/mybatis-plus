package com.can.service;

import com.can.entity.UserInfo;

/**
 * <pre>
 *
 * </pre>
 *
 * @author canxin.li
 * @date 2020-10-16 16:16
 */
public interface UserService {

    boolean insertUser();

    UserInfo selectUser(Integer userId);
}
