package com.can.service;

import com.can.entity.UserInfo;

/**
 * <pre>
 *
 * </pre>
 *
 * @author canxin.li
 * @date 2020-10-19 16:02
 */
public interface HelpService {

    boolean insertUser(UserInfo userInfo);

    boolean insertUserException(UserInfo userInfo);

    boolean insertUserTransaction(UserInfo userInfo);
}
