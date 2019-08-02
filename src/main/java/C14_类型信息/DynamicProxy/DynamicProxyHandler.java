package C14_类型信息.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyHandler implements InvocationHandler {

    private Interface proxied;

    public DynamicProxyHandler(Interface proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy working");
        if (args != null){
            for (Object arg : args) {
                System.out.print(" " + arg);
            }
        }
        return method.invoke(proxied, args);
    }
}
