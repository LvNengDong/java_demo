package _46.lesson;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author lnd
 * @Description
 * @Date 2024/5/13 20:56
 */
@Slf4j
public class UserController {
    private UserService userService = new UserService();

    public long login(String username, String password) {
        // 所有的日志都带有traceId
        log.info(Context.getTraceId() + " login username=" + username);
        //...省略校验逻辑...
        return userService.login(username, password); //通过Context传递traceId
    }
}
