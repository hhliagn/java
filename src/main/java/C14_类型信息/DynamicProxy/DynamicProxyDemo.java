package C14_类型信息.DynamicProxy;

import java.lang.reflect.Proxy;

public class DynamicProxyDemo {

    public static void consume(Interface interfaces){
        interfaces.doSomething();
        interfaces.somethingElse("test");
    }

    public static void main(String[] args) {
        RealObject realObject = new RealObject();
        consume(realObject);
        Interface proxy = (Interface) Proxy.newProxyInstance(
                Interface.class.getClassLoader(),
                new Class[]{Interface.class},
                new DynamicProxyHandler(realObject));
        consume(proxy);
    }

}
