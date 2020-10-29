package com.cy.service;

import org.springframework.stereotype.Service;

@Service
public class mailServiceImpl implements mailService {
    @Override
    public boolean sendMail(String msg) {
        System.out.println("send->" + msg);
        return true;
    }
}
//下面的两种设计了解？(基于原生方式实现功能扩展)
//1.自己动手写子类重写父类方法，进行功能扩展
//class TimeMailServiceImpl extends  MailServiceImpl{ //CGLIB
//    @Override
//    public boolean sendMail(String msg) {
//        long t1=System.nanoTime();
//        boolean flag= super.sendMail(msg);
//        long t2=System.nanoTime();
//        System.out.println("send time:"+(t2-t1));
//        return flag;
//    }
//}

//2.自己写兄弟类对目标对象(兄弟类)进行功能扩展,这种方式又叫组合
//class TimeMailServiceImpl implements  MailService{//JDK
//
//    private MailService mailService;
//    public TimeMailServiceImpl(MailService mailService){
//        this.mailService=mailService;
//    }
//    @Override
//    public boolean sendMail(String msg) {
//        long t1=System.nanoTime();
//        boolean flag=mailService.sendMail(msg);
//        long t2=System.nanoTime();
//        System.out.println("send time:"+(t2-t1));
//        return flag;
//    }
//}