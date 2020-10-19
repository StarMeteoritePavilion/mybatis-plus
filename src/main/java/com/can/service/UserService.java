package com.can.service;

/**
 * <pre>
 *
 * </pre>
 *
 * @author canxin.li
 * @date 2020-10-16 16:16
 */
public interface UserService {

    /**
     * 单个方法插入
     * @return
     */
    boolean insertUser01();

    /**
     * 跨一个方法后, 公有插入
     * @return
     */
    boolean insertUser02();

    /**
     * 跨一个方法后, 私有插入
     * @return
     */
    boolean insertUser03();

    /**
     * 跨服务插入, 自身方法抛异常
     * @return
     */
    boolean insertUser04();

    /**
     * 跨服务插入，调用服务抛异常
     * @return
     */
    boolean insertUser05();

    /**
     * 调用自身的私有方法，私用的方法调用另一个服务带事务的方法
     * @return
     */
    boolean insertUser06();
}
