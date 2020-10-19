package com.can.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.can.entity.UserInfo;
import org.apache.ibatis.annotations.Param;

/**
 * <pre>
 *
 * </pre>
 *
 * @author canxin.li
 * @date 2020-10-16 16:17
 */
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    UserInfo selectUserById(@Param("userId") Integer userId);

    int insertUser(@Param("entity") UserInfo userInfo);
}
