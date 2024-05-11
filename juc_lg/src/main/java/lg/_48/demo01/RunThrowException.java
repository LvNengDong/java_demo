package lg._48.demo01;

import java.io.IOException;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/10 00:09
 */
public class RunThrowException {

    /**
     * 普通方法内可以 throw 异常，并在方法签名上声明 throws
     * */
    public void normalMethod() throws Exception {
        throw new IOException();
    }

    Runnable runnable = new Runnable() {
        /**
         *  run方法上无法声明 throws 异常，且run方法内无法 throw 出 checked Exception，除非使用try catch进行处理
         */
        @Override
        public void run() {
            try {
                throw new IOException();
            } catch (IOException e) {
                try {
                    throw e;
                } catch (IOException ex) {
                    throw new RuntimeException(ex); // ok
                }
            }
        }
    };
}
