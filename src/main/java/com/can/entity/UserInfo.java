package com.can.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * <pre>
 *
 * </pre>
 *
 * @author canxin.li
 * @date 2020-10-16 16:17
 */
@Data
public class UserInfo {

    @TableId(value = "user_id" ,type = IdType.AUTO)
    private Integer userId;

    private String userName;

    private Integer userAge;

    private LocalDateTime birthday;
}
