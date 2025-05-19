import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author lnd
 * @Description
 * @Date 2024/8/28 22:12
 */
public class DemoInvokerHandler implements InvocationHandler {

    private Object target; // 真正的业务对象，也就是RealSubject对象

    public DemoInvokerHandler(Object target) { // 构造方法
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("...在执行业务方法之前的预处理...");
        Object result = method.invoke(target, args);
        System.out.println("...在执行业务方法之后的后置处理...");
        return result;
    }

    public Object getProxy() {
        // 创建代理对象
        return Proxy.newProxyInstance(
                Thread.currentThread().getContextClassLoader(),
                target.getClass().getInterfaces(),
                this
        );
    }
}
