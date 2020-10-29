package com.cy.db.common.aspect;
import com.cy.db.common.annotation.RequiredCache;
import com.cy.db.common.annotation.RequiredClearCache;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
@Component
@Aspect
public class cacheAspect {
   private Map<String,Map<String,Object>>  cacheMap= new ConcurrentHashMap<>();
    @Pointcut("@annotation(com.cy.db.common.annotation.RequiredCache)")
    private void  cache(){ }
    @Around("cache()")
    public   Object  doCacheAround(ProceedingJoinPoint jo) throws Throwable {
        System.out.println("get data from  cache");
        Map<String, Object> cache=null;
        synchronized (cacheAspect.class) {
            String cacheName = getCacheName(RequiredCache.class, jo);
             cache = cacheMap.get(cacheName);
            if (cache == null) {
                cache = new ConcurrentHashMap<>();
                cacheMap.put(cacheName, cache);
            }
        }
        String key = getCacheKey(RequiredCache.class, jo);
        Object result = cache.get(key);
        if(result!=null) return result;
            result = jo.proceed();
        System.out.println("put data to cache");
               cache.put(key, result);
        return  result;
    }
    @Pointcut("@annotation(com.cy.db.common.annotation.RequiredClearCache)")
    private void  clear(){ }
    @AfterReturning("clear()")
    public  void doAfterReturning(JoinPoint jo) throws NoSuchMethodException {//menthod ok
        String cacheName=getCacheName(RequiredClearCache.class,jo);
        Map<String,Object>  cache= cacheMap.get(cacheName);
        cache.clear();
    }
      private  String  getCacheName(Class<? extends Annotation> a, JoinPoint jo) throws NoSuchMethodException {
//1.获取目标方法
          Method method = getTargetMethod(a, jo);
          Annotation annotation1= method.getAnnotation(a);
          String cacheName=null;
          if( annotation1 instanceof RequiredCache){
              RequiredCache  requiredCache=(RequiredCache) method.getAnnotation(a);
              cacheName=requiredCache.name();
          }else if(annotation1 instanceof RequiredClearCache){
              RequiredClearCache  requiredClearCache=(RequiredClearCache) method.getAnnotation(a);
              cacheName=requiredClearCache.name();
          }
          return cacheName;
      }
    private  String  getCacheKey(Class<? extends Annotation> a, JoinPoint jo) throws NoSuchMethodException {
        Method method = getTargetMethod(a, jo);
        Annotation annotation1= method.getAnnotation(a);
        String key=null;
        if( annotation1 instanceof RequiredCache){
            RequiredCache  requiredCache=(RequiredCache) method.getAnnotation(a);
            key=requiredCache.key();
        }
        return key;
    }
    private  Method getTargetMethod(Class<? extends Annotation> a, JoinPoint jo) throws NoSuchMethodException {
        //1.获取目标方法
        Class<?> clazz = jo.getTarget().getClass();
        MethodSignature ms = (MethodSignature)jo.getSignature();
        Method method = clazz.getMethod(ms.getName(), ms.getParameterTypes());
        return  method;
    }
}
