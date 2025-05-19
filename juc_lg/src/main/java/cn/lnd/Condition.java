package cn.lnd;

/**
 * @Author lnd
 * @Description
 * @Date 2024/6/12 16:30
 */
public enum Condition {
    GE("大于等于"),
    GT("大于")
    ;

    private Condition(String desc) {
        this.desc = desc;
    }

    private String desc;
}
