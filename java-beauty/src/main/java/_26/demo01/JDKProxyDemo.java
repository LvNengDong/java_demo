package _26.demo01;

import java.lang.reflect.Proxy;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/14 14:29
 */
public class JDKProxyDemo {
    public static void main(String[] args) {
        IUserController userController = new UserController();
        CtrlProxyHandler handler = new CtrlProxyHandler(userController);
        IUserController userControllerProxy = (IUserController) Proxy.newProxyInstance(handler.getClass().getClassLoader(), UserController.class.getInterfaces(), handler);
        userControllerProxy.login("1231231", "*******");
    }
}
