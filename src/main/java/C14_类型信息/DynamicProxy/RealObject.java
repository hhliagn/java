package C14_类型信息.DynamicProxy;

public class RealObject implements Interface{
    @Override
    public void doSomething() {
        System.out.println("real object do something");
    }

    @Override
    public void somethingElse(String args) {
        System.out.println("real object something else" + args);
    }
}
