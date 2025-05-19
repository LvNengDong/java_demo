package _24.lesson;

public class Demo24_2 {

    public static class C {
        public void f() {
        }
    }

    public static void main(String[] args) throws Exception {
        // 使用new创建对象
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; ++i) {
            C c = new C();
        }
        System.out.println(System.currentTimeMillis() - start); // 3

        // 使用反射创建对象
        start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; ++i) {
            Class<?> clazz = C.class;
            Object obj = clazz.newInstance();
        }
        System.out.println(System.currentTimeMillis() - start); // 40
    }
}