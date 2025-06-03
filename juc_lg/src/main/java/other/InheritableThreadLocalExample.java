package other;

/**
 * @Author lnd
 * @Description
 *  InheritableThreadLocal 类是 ThreadLocal 的子类，用于实现从父线程到子线程的值继承。当创建一个子线程时，子线程会接收父线程中所有 InheritableThreadLocal 变量的初始值。通常情况下，子线程的值与父线程的值相同，但也可以通过重写 childValue 方法，将子线程的值设置为父线程值的任意函数。
 *
 *  InheritableThreadLocal 适用于需要将某些线程级别的属性（如用户 ID、事务 ID 等）自动传递给新创建的子线程的场景。
 * @Date 2025/6/3 20:58
 */
public class InheritableThreadLocalExample {
    // 创建一个 InheritableThreadLocal 实例
    private static final InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();

    public static void main(String[] args) {
        // 在父线程中设置 InheritableThreadLocal 的值
        inheritableThreadLocal.set("Value from parent thread");

        // 打印父线程中的值
        System.out.println("Parent thread value: " + inheritableThreadLocal.get());

        // 创建子线程
        Thread childThread = new Thread(() -> {
            // 打印子线程中继承的值
            System.out.println("Child thread value: " + inheritableThreadLocal.get());

            // 在子线程中修改值
            inheritableThreadLocal.set("Value from child thread");

            // 再次打印子线程中的值
            System.out.println("Modified child thread value: " + inheritableThreadLocal.get());
        });

        // 启动子线程
        childThread.start();

        try {
            // 等待子线程执行完毕
            childThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 再次打印父线程中的值，验证父线程的值不受子线程影响
        System.out.println("Parent thread value after child thread execution: " + inheritableThreadLocal.get());
    }
}
