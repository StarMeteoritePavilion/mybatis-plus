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

    /**
     * 长时间更新
     * @param userId
     * @return
     */
    Boolean updateSlowNoIndex(Integer userId);

    /**
     * 短时间更新
     * @param userId
     * @return
     */
    Boolean updateQuickNoIndex(Integer userId);
}
