package com.example.demo.cach;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
//@scope("prototype")//prototype表示多列，作用域，此类与lazy无关，默认何时需要何时创建，并且不会存储到spring容器中
@Scope("prototype")
//@Scope("singleton")//注解用于指定对象作用域，默认为单列作用域（一个jvm内存中名字相同的bean只能有一个）
//@Lazy//描述的类的对象可以延迟创建，何时需要时何时创建（可以通过jvm参数：-xx：+TraceClassLoading查看类的加载）
@Component//交给springboot创建对象
public class objectPool {
    public objectPool(){
        System.out.println("我是连接池");
    }
    @PostConstruct
    public void init(){//容器生命周期初始化，在对象构建构建后执行
        System.out.println("init()");
    }
    @PreDestroy
    public void  destroy(){//容器生命周期销毁方法，此方法所在对象，假如存储到spring容器中，
        // 那这个对象在从spring容器移除之前会先执行这个生命周期销毁方法

        System.out.println("destroy()");
    }
}

