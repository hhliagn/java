package C15_泛型.Ereased.Demo3;

public class ClassFactory<T> {
    private T t;
    public ClassFactory(Class<T> clazz){
        try {
            t = clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ClassFactory<String> stringClassFactory = new ClassFactory<>(String.class);
    }
}
