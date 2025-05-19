package _24.lesson;

import java.lang.reflect.Method;

/**
 * @Author lnd
 * @Description
 * @Date 2024/9/2 14:55
 */
public class Demo24_3 {
    public static class C {
        public void f() {
        }
    }

    public static void main(String[] args) throws Exception {
        // 普通方法调用
        long start = System.currentTimeMillis();
        C c = new C();
        for (int i = 0; i < 10000000; ++i) {
            c.f();
        }
        System.out.println(System.currentTimeMillis() - start); // 4

        // 使用反射执行方法
        start = System.currentTimeMillis();
        Class<?> clazz = C.class;
        Object obj = clazz.newInstance();
        for (int i = 0; i < 10000000; ++i) {
            Method method = clazz.getMethod("f");
            method.invoke(obj);
        }
        System.out.println(System.currentTimeMillis() - start); // 155
    }
}
