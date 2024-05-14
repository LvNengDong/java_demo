package _46.lesson;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author lnd
 * @Description
 * @Date 2024/5/13 21:04
 */
@Slf4j
public class App {
    public static void main(String[] args) {
        log.info("进程启动 threadName:{} time:{}", Thread.currentThread().getName(), System.currentTimeMillis());
        UserController userController = new UserController();
        userController.login("zs", "xxx");
    }
}
