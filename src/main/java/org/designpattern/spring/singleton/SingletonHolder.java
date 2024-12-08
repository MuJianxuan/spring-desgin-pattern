package org.designpattern.spring.singleton;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/**
 * 单例类
 * @author create 2024/12/4 by rao
 */
@Slf4j
@SuppressWarnings("all")
public class SingletonHolder {

    public static final Map<Class<?>,Object> CLASS_OBJECT_MAP = new HashMap<>();

    /**
     * 单例
     * @param cls
     * @return
     * @param <T>
     */
    @SneakyThrows
    public static  <T> T singleton(Class<T> cls) {
        Object o = CLASS_OBJECT_MAP.get(cls);
        if (o != null){
            return (T) o;
        }
        synchronized(cls){
            Object o1 = CLASS_OBJECT_MAP.get(cls);
            if (o1 != null){
                return (T) o1;
            }
            Constructor<T> constructor = cls.getDeclaredConstructor();
            Assert.notNull(constructor, "does not exist");
            constructor.setAccessible(true);
            T instance = constructor.newInstance();
            CLASS_OBJECT_MAP.putIfAbsent(cls,instance);
            return instance;
        }
    }

    public static void main(String[] args) {
        if (SingletonHolder.singleton(Singleton.class).equals(SingletonHolder.singleton(Singleton.class))) {
            log.info("true");
        }
        for (int i = 0; i < 10; i++){
            new Thread(()->{
                Singleton singleton = SingletonHolder.singleton(Singleton.class);
                System.out.println(singleton);
            }).start();
        }


    }

    //@Data
    public static class Singleton {

        private String name;

        private Singleton() {
        }
    }

}
