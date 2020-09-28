package com.example.demo.GC;

import sun.security.pkcs11.P11TlsKeyMaterialGenerator;

import java.util.HashMap;

public class JVM {
//   对象在GC之前会执行此方法

    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize()");
    }
}
  class GCTest01{
      public static void main(String[] args) {
          HashMap<String, Object> beanpool= new HashMap<>();
          JVM p = new JVM();
//          beanpool.put("1", p);
//          p=null;
          System.gc();
          System.out.println(2222);
      }
}