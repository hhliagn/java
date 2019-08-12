package C15_泛型.EreaseAndBorder;

public class SomethingResolver<T> {
    T obj;

    public SomethingResolver(T t) {
        this.obj = t;
    }

    public void doSomething() {
        //obj.f();  编译出错，不能识别obj具有方法f()
    }
}
