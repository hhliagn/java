package C15_泛型.Ereased.Demo1;

public class Ereased<T> {
    private static final int SIZE = 100;
    @SuppressWarnings("unchecked")
    public Ereased(Object args){
        //if (args instanceof T){ } error
        //T var = new T(); error
        //T[] array = new T[SIZE]; error
        T[] array = (T[]) new Object[SIZE]; //unchecked warning
    }
}
