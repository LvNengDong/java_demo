package _26.dynamicProxy.static_proxy.byInterface;

import _26.dynamicProxy.dynamic_proxy.jdk.UserVo;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/14 14:30
 */
public interface IUserController {
    UserVo login(String telephone, String password);
    UserVo register(String telephone, String password);
}
