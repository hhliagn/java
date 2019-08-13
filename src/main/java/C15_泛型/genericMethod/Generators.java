package C15_泛型.genericMethod;

import java.util.ArrayList;
import java.util.Collection;

public class Generators {
    public static <T> Collection<T> fill(Collection<T> ori){
        return new ArrayList<T>();
    }
}
