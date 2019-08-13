package C15_泛型.genericMethod;

import java.util.Collection;
import java.util.List;

public class Demo {
    public static <T> Collection<T> getList(Collection<T> a){
        return (List<T>) a;
    }
}
