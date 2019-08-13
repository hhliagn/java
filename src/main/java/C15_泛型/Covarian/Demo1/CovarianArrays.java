package C15_泛型.Covarian.Demo1;

public class CovarianArrays {
    public static void main(String[] args) {
        Fruit[] fruits = new Apple[10];
        fruits[0] = new Apple();
        fruits[1] = new PineApple();
        //runtime Apple[]
        try {
            fruits[0] = new Fruit();
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            fruits[1] = new Orange();
        } catch (Exception e) {
            System.out.println(e);
        }
//        java.lang.ArrayStoreException: C15_泛型.Covarian.Demo1.Fruit
//        java.lang.ArrayStoreException: C15_泛型.Covarian.Demo1.Orange
    }
}
