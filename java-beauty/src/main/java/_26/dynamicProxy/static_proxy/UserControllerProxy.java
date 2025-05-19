package _26.dynamicProxy.static_proxy;

import _26.dynamicProxy.demo01.UserVo;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author lnd
 * @Description
 * @Date 2025/5/19 10:57
 */
@Slf4j
public class UserControllerProxy implements IUserController{

    private UserController userController;

    public UserControllerProxy(UserController userController) {
        this.userController = userController;
    }

    @Override
    public UserVo login(String telephone, String password) {
        long startTime = System.currentTimeMillis();
        UserVo userVo = userController.login(telephone, password);
        long costTime = System.currentTimeMillis() - startTime;
        log.info("UserController#login cost time:" + costTime);
        return userVo;
    }

    @Override
    public UserVo register(String telephone, String password) {
        long startTime = System.currentTimeMillis();
        UserVo userVo = userController.register(telephone, password);
        long costTime = System.currentTimeMillis() - startTime;
        log.info("UserController#register cost time:" + costTime);
        return userVo;
    }
}
