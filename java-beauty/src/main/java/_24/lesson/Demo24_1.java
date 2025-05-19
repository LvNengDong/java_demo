package _24.lesson;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Author lnd
 * @Description
 * @Date 2024/9/2 11:55
 */
public class Demo24_1 {
    public static class Person {
        private int age;

        private Person() {
        }

        private void print() {
            System.out.println("age: " + this.age);
        }
    }

    public static void main(String[] args) throws Exception {

        Class<?> clazz = Class.forName("_24.lesson.Demo24_1$Person");

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        Person pobj = (Person) constructor.newInstance();

        Field field = clazz.getDeclaredField("age");
        field.setAccessible(true);
        field.set(pobj, 10);

        Method method = clazz.getDeclaredMethod("print");
        method.setAccessible(true);
        method.invoke(pobj);
    }
}
