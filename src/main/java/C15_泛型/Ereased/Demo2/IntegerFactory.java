package C15_泛型.Ereased.Demo2;

public class IntegerFactory implements Factory<Integer> {
    @Override
    public Integer create() {
        return new Integer(10);
    }
}
