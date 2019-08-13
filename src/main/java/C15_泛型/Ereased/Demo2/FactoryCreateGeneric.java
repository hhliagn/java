package C15_泛型.Ereased.Demo2;

public class FactoryCreateGeneric {
    public static void main(String[] args) {
        new FactoryGenerator<>(new IntegerFactory());
        new FactoryGenerator<>(new Weight.Factory());
    }
}
