package C15_泛型.Covarian.Demo1;

import java.util.ArrayList;
import java.util.List;

public class GenericsAndVariance {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        List<? extends Fruit> fruits = new ArrayList<Apple>();
        //fruits.add(new Apple()); //complie error : can not recongize apple by use ?
        //fruits.add(new Orange());
        //fruits.add(new Fruit());
        Fruit fruit = fruits.get(0); //can know the return type must Fruit

        //upcast
        List<Orange> oranges = (List<Orange>) fruits;
        try {
            oranges.add(new Orange());
            //oranges.add(new Object()); only can add Orange
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(oranges.get(0));
    }
}
