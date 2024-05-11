package _26.demo01;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/14 14:30
 */
@Slf4j
public class UserController implements IUserController {

    //...省略其他属性和方法...

    @Override
    public UserVo login(String telephone, String password) {
        // ... 省略login逻辑...
        log.info("telephone:{} password:{} 登录成功", telephone, password);
        UserVo userVo = null;
        //...返回UserVo数据...
        return userVo;
    }

    @Override
    public UserVo register(String telephone, String password) {
        // ... 省略register逻辑...
        log.info("telephone:{} password:{} 注册成功", telephone, password);
        UserVo userVo = null;
        //...返回UserVo数据...
        return userVo;
    }

}
