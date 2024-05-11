package _26.demo01;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/14 14:30
 */
public interface IUserController {
    UserVo login(String telephone, String password);
    UserVo register(String telephone, String password);
}
