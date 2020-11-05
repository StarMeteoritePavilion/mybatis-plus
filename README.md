# mybatis-plus
mybatis-plus


数据库相关的操作都开业用这个项目
新建一条分支进行测试


1. 更新条件不包含索引，会导致 mysql 锁全表
2. 注解了 @Transactional 的方法, 在进入了方法中，就会开启事务

注解了 @Transactional 的方法没有根据索引更新, 
这时候有另一条 sql 进行更新, 这条SQL 会等待 @Transactional 的执行完
而 @Transaction 的方法没结束时, 另一条 sql 进来了，
这时候会导致 2 边同时在等待，直到其中一边包 锁等待超时, 另一边才能执行 

Cause: com.mysql.cj.jdbc.exceptions.MySQLTransactionRollbackException: Lock wait timeout exceeded; try restarting transaction


行级锁并不是直接锁记录，而是锁索引，
如果一条SQL语句用到了主键索引，mysql会锁住主键索引
如果一条语句操作了非主键索引，mysql会先锁住非主键索引，再锁定主键索引
如果操作用到了主键索引会先在主键索引上加锁，然后在其他索引上加锁
对于没有用索引的操作会采用表级锁