package C14_类型信息;

import java.util.ArrayList;
import java.util.List;

public class Demo4 {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        FilledList<CountedInteger> countedIntegerFilledList = new FilledList<>(CountedInteger.class);
        System.out.println(countedIntegerFilledList.getList(15));
    }
}
class CountedInteger{
    private static long counter;
    private final long id = counter++;

    @Override
    public String toString() {
       return Long.toString(id);
    }
}
class FilledList<T>{
    private Class<T> type;
    public FilledList(Class<T> type){
        this.type = type;
    }
    public List<T> getList(int i) throws IllegalAccessException, InstantiationException {
        List<T> result = new ArrayList<>();
        for (int i1 = 0; i1 < i; i1++) {
            result.add(type.newInstance());
//            result.add((T) new CountedInteger()); 结果一样
        }
        return result;
    }
}
