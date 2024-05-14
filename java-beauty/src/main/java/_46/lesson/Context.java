package _46.lesson;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author lnd
 * @Description
 * @Date 2024/5/13 20:57
 */
@Slf4j
public class Context {
    private static final ThreadLocal<String> threadLocalTraceId = new ThreadLocal<String>() {
        @Override
        protected String initialValue() {
            log.info("线程初始化 threadName:{} time:{}", Thread.currentThread().getName(), System.currentTimeMillis());
            return "[" + System.currentTimeMillis() + "]";
        }
    };

    public static void setTraceId(String traceId) {
        threadLocalTraceId.set(traceId);
    }

    public static String getTraceId() {
        return threadLocalTraceId.get();
    }

    public static void remove() {
        threadLocalTraceId.remove();
    }
}
