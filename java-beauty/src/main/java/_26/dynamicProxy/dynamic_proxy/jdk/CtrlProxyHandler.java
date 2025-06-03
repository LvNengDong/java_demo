package _26.dynamicProxy.dynamic_proxy.jdk;

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

    /**
     * invoke 方法用于处理代理实例上的方法调用，并返回调用结果。
     * 当代理实例的方法被调用时，该调用会被编码并分派到关联的 InvocationHandler 的 invoke 方法执行。
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object res = method.invoke(origBean, args);
        long costTime = System.currentTimeMillis() - startTime;
        log.info("{}#{} + cost time: {}", origBean.getClass().getSimpleName(), method.getName(), costTime);
        return res;
    }
}
