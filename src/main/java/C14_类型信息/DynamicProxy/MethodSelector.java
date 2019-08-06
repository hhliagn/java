package C14_类型信息.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MethodSelector implements InvocationHandler {

    private Object proxied;
    public MethodSelector(Object proxied){
        this.proxied = proxied;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("interest")){
            System.out.println("proxy detect interest method");
        }
        return method.invoke(proxied,args);
    }
}

interface SomeMethods{
    void boring();
    void interest(String args);
}
class Implements implements SomeMethods{

    @Override
    public void boring() {
        System.out.println("boring excute");
    }

    @Override
    public void interest(String args) {
        System.out.println("interest excute " + args);
    }
}

class ProxyDemo{
    public static void main(String[] args) {

        SomeMethods proxyInstance = (SomeMethods) Proxy.newProxyInstance(
                SomeMethods.class.getClassLoader(),
                new Class[]{SomeMethods.class},
                new MethodSelector(new Implements())
        );

        proxyInstance.boring();
        proxyInstance.interest("biubiubiu");
    }
}
