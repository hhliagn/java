package C14_类型信息;

//instanceof 保持了类型的概念, 你是这个类吗, 你是这个类的派生类吗
// == 比较class 对象, 比较的是确定的类, 没有考虑继承
public class FamliyVsExactType {

}
class Base{

}
class Derived extends Base{
    static void test(Object x){
        Class<?> aClass = x.getClass();
        System.out.println("Testing x of type " + aClass);
        System.out.println("x instance of Base " + (x instanceof Base));
        System.out.println("x instance of Derived " + (x instanceof Derived));

        System.out.println("Base.isInstance(x)" + Base.class.isInstance(x));
        System.out.println("Derived.isInstance(x)" + Derived.class.isInstance(x));

        System.out.println("x.getClass() == Base.class" + (x.getClass() == Base.class));
        System.out.println("x.getClass() == Derived.class" + (x.getClass() == Derived.class));

        System.out.println("x.getClass().equals(Base.class)" + (x.getClass().equals(Base.class)));
        System.out.println("x.getClass().equals(Derived.class)" + (x.getClass().equals(Derived.class)));
    }

    public static void main(String[] args) {
        test(new Base());
        System.out.println();
        test(new Derived());
    }
}

