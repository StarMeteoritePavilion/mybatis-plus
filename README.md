# spring transactional

## 情景一, 调用方法, 直接插入, 见 insert01
```java
public class controller {
    
    @Resouce
    private Service service;
    
    public boolean test() {
        serice.method();
    }
}

public class Service {
    
    @Transactional
    public boolean method() {
        // 1. 数据库插入操作
        // 2. 抛出异常
    }
}
```
结论: 事务会起作用

## 情景二, 调用方法A, A 调用自身的共有方法 B, 见 insert02
```java
public class controller {

    @Resouce
    private Service service;
    
    public boolean test() {
      serice.methodA();
    }
}

public class Service {
    
    public boolean methodA() {
        methodB();
    }
    
    @Transactional
    public boolean methodB() {
      // 1. 数据库插入操作
      // 2. 抛出异常
    }
}
```
结论: 事务会不起作用

## 情景三, 调用方法A, A 调用自身的私有方法 B, 见 insert03
```java
public class controller {

    @Resouce
    private Service service;
    
    public boolean test() {
      serice.methodA();
    }
}

public class Service {
    
    public boolean methodA() {
        methodB();
    }
    
    @Transactional
    private boolean methodB() {
      // 1. 数据库插入操作
      // 2. 抛出异常
    }
}
```
结论: 事务会不起作用


## 情景四, 调用方法A, A 调用另一个类的方法B, B 执行成功, A 抛异常, 见 insert04
```java
public class controller {

    @Resouce
    private Service service;
    
    public boolean test() {
      serice.methodA();
    }
}

public class Service {
    
    private AnotherService anotherService;

    @Transactional
    public boolean methodA() {
        anotherService.methodB();
        // 抛异常
    }
}

public class AnotherService {
    
    public boolean methodB() {
        // 1. 数据库插入操作
    }
}
```
结论: 事务会起作用


## 情景五, 调用方法A, A 调用另一个类的方法B, B 抛出异常, 见 insert05
```java
public class controller {

    @Resouce
    private Service service;
    
    public boolean test() {
      serice.methodA();
    }
}

public class Service {
    
    private AnotherService anotherService;

    @Transactional
    public boolean methodA() {
        anotherService.methodB();
    }
}

public class AnotherService {
    
    public boolean methodB() {
        // 1. 数据库插入操作
        // 2. 抛出异常
    }
}
```
结论: 事务会起作用


## 情景六, 调用方法A, A 调用自身的私有方法B, B 调用另一个类的方法, 抛出异常, 见 insert06
```java
public class controller {

    @Resouce
    private Service service;
    
    public boolean test() {
      serice.methodA();
    }
}

public class Service {
    
    private AnotherService anotherService;
    
    public boolean methodA() {
        return methodB();
    }
    
    private boolean methodB() {
        return anotherService.methodC();
    }

}

public class AnotherService {
    
    @Transactional
    public boolean methodC() {
        // 1. 数据库插入操作
        // 2. 抛出异常
    }
}
```
结论: 事务会起作用