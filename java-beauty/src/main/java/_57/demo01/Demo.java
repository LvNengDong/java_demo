package _57.demo01;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/16 23:09
 */
public class Demo {
    //默认父类加载器为AppClassLoader
    public static class ClassLoaderA extends ClassLoader {
    }

    //通过构造函数指定父类加载器
    public static class ClassLoaderB extends ClassLoader {
        public ClassLoaderB(ClassLoader parent) {
            super(parent);
        }
    }

    public static void main(String[] args) {
        ClassLoaderB loader = new ClassLoaderB(new ClassLoaderA());
        System.out.println(loader);
        System.out.println(loader.getParent());
        System.out.println(loader.getParent().getParent());
        System.out.println(loader.getParent().getParent().getParent());
        System.out.println(loader.getParent().getParent().getParent().getParent());
    }
    /*
    * 执行结果：
        _57.demo01.Demo$ClassLoaderB@6ff3c5b5
        _57.demo01.Demo$ClassLoaderA@3764951d
        sun.misc.Launcher$AppClassLoader@18b4aac2
        sun.misc.Launcher$ExtClassLoader@4b1210ee
        null
    * */
}
