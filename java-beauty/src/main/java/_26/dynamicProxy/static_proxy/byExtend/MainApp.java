package _26.dynamicProxy.static_proxy.byExtend;

import _26.dynamicProxy.static_proxy.byInterface.IUserController;

/**
 * @Author lnd
 * @Description
 * @Date 2025/5/19 11:05
 */
public class MainApp {
    public static void main(String[] args) {
        // 原来的代码
        //UserController userController = new UserController();
        // 代理之后的代码
        UserController userController = new UserControllerProxy();
        userController.login("18818888888", "123456");
        userController.register("18818888888", "123456");
    }
}
