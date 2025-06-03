package _26.dynamicProxy.static_proxy.byExtend;

import _26.dynamicProxy.dynamic_proxy.jdk.UserVo;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/14 14:30
 */
@Slf4j
public class UserController {

    //...省略其他属性和方法...

    public UserVo login(String telephone, String password) {
        // ... 省略login逻辑...
        log.info("telephone:{} password:{} 登录成功", telephone, password);
        UserVo userVo = new UserVo();
        //...返回UserVo数据...
        return userVo;
    }

    public UserVo register(String telephone, String password) {
        // ... 省略register逻辑...
        log.info("telephone:{} password:{} 注册成功", telephone, password);
        UserVo userVo = new UserVo();
        //...返回UserVo数据...
        return userVo;
    }

}
