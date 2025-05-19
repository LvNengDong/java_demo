package _26.dynamicProxy.static_proxy;

import _26.dynamicProxy.demo01.UserVo;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/14 14:30
 */
public interface IUserController {
    UserVo login(String telephone, String password);
    UserVo register(String telephone, String password);
}
