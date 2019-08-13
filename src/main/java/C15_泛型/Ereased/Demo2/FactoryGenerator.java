package C15_泛型.Ereased.Demo2;

public class FactoryGenerator<T> {
    private T t;
    public <F extends Factory<T>> FactoryGenerator(F factory){
        t = factory.create();
    }
}
