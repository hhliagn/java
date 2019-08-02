package C14_类型信息.DynamicProxy;

public class SimpleProxyDemo {
    public static void consume(Interface interfacec){
        interfacec.doSomething();
        interfacec.somethingElse("test");
    }

    public static void main(String[] args) {
        consume(new RealObject());
        consume(new SimpleProxy(new RealObject()));
    }


}
