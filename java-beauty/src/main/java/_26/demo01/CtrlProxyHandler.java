package _26.demo01;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/14 14:23
 */
@Slf4j
public class CtrlProxyHandler implements InvocationHandler {

    private Object origBean;

    public CtrlProxyHandler(Object origBean) {
        this.origBean = origBean;
    }


    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object res = method.invoke(origBean, args);
        long costTime = System.currentTimeMillis() - startTime;
        log.info("{}#{} + cost time: {}", origBean.getClass().getSimpleName(), method.getName(), costTime);
        return res;
    }
}
