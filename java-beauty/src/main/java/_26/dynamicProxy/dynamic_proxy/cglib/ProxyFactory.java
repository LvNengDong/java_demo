package _26.dynamicProxy.dynamic_proxy.cglib;

import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;


import java.lang.reflect.Method;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/14 14:53
 */
@Slf4j
public class ProxyFactory implements MethodInterceptor {

    private Object origBean;

    public ProxyFactory(Object origBean) {
        this.origBean = origBean;
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        long startTime = System.currentTimeMillis();
        //Object res = method.invoke(origBean, args); //Java反射
        Object res = methodProxy.invokeSuper(obj, args); //CGLIB反射
        long costTime = System.currentTimeMillis() - startTime;
        log.info("{}#{} + cost time: {}", origBean.getClass().getSimpleName(), method.getName(), costTime);
        return res;
    }
}
