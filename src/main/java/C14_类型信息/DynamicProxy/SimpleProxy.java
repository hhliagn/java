package C14_类型信息.DynamicProxy;

public class SimpleProxy implements Interface {

    private Interface proxied;
    public SimpleProxy(Interface proxied){
        this.proxied = proxied;
    }
    @Override
    public void doSomething() {
        System.out.println("proxy do something");
        proxied.doSomething();
    }

    @Override
    public void somethingElse(String args) {
        System.out.println("proxy something else " + args);
        proxied.somethingElse(args);
    }
}
