package _26.demo02;

import _26.demo01.UserController;
import net.sf.cglib.proxy.Enhancer;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/14 15:13
 */
public class CGLIBProxyDemo {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserController.class);
        enhancer.setCallback(new ProxyFactory(new UserController()));
        UserController userControllerProxy = (UserController) enhancer.create();
        userControllerProxy.login("123213123", "======");
    }
}
