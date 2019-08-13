package C15_泛型.Covarian.Demo2;

import C15_泛型.Covarian.Demo1.Apple;
import C15_泛型.Covarian.Demo1.Fruit;
import C15_泛型.Covarian.Demo1.Orange;

public class Holder<T> {
    T value;
    public Holder(){

    }
    public Holder(T value){
        this.value = value;
    }
    public void set(T t){
        this.value = t;
    }
    public T get(){
        return value;
    }
    public boolean equals(Object o){
        return value.equals(o);
    }

    public static void main(String[] args) {
        Holder<Apple> apples = new Holder<Apple>();
//        Apple apple = apples.get();
        Apple apple = new Apple();
        apples.set(apple);

        Holder<? extends Fruit> fruits = apples;
        Fruit fruit = fruits.get();
        apple = (Apple) fruits.get();  //runtime unchecked exception
        try {
            Orange orange = (Orange) fruits.get(); //runtime unchecked exception
        } catch (Exception e) {
            System.out.println(e);
        }
        //fruits.set(fruit); error
        System.out.println(fruit.equals(apple)); //true
    }
    //编译器只关注传进来和要返回的类型
}
