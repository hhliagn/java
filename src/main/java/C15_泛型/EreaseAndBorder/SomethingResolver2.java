package C15_泛型.EreaseAndBorder;

public class SomethingResolver2<T extends Something> {
    T obj;
    public SomethingResolver2(T t){
        this.obj = t;
    }

    public void doSomething(){
        obj.f(); //使用边界，可以编译，泛型擦除会擦除到第一个上界
    }
}
