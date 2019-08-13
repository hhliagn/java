package C15_泛型.Ereased.Demo1;

public class ClassTypeCapture<T> {
    private Class<T> kind;
    public ClassTypeCapture(Class<T> kind){
        this.kind = kind;
    }
    public boolean m(Object args){
        return kind.isInstance(args);
    }
}
