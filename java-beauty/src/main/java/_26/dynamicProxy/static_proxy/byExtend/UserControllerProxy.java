package _26.dynamicProxy.static_proxy.byExtend;

import _26.dynamicProxy.dynamic_proxy.jdk.UserVo;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author lnd
 * @Description
 * @Date 2025/5/19 11:32
 */
@Slf4j
public class UserControllerProxy extends UserController {
    @Override
    public UserVo login(String telephone, String password) {
        long startTime = System.currentTimeMillis();
        UserVo userVo = super.login(telephone, password);
        long costTime = System.currentTimeMillis() - startTime;
        log.info("UserController#login cost time:" + costTime);
        return userVo;
    }

    @Override
    public UserVo register(String telephone, String password) {
        long startTime = System.currentTimeMillis();
        UserVo userVo = super.register(telephone, password);
        long costTime = System.currentTimeMillis() - startTime;
        log.info("UserController#register cost time:" + costTime);
        return userVo;
    }
}
