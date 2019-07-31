package C14_类型信息;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Demo2 {


}
class Initable{
    static final int staticFinal = 47;
    static final int staticFinal2 = ClassInitalization.rand.nextInt(1000);
    static{
        System.out.println("Initable init");
    }
}
class Initable2{
    static int staticNonFinal = 147;
    static{
        System.out.println("Initable2 init");
    }
}
class Initable3 {
    static int staticNonFinal = 258;
    static{
        System.out.println("Initable3 init");
    }
}
class ClassInitalization{
    static Random rand = new Random(47);

    public static void main(String[] args) throws ClassNotFoundException {
        Class<Initable> initableClass = Initable.class;
        System.out.println("after Initable init");

        System.out.println(Initable.staticFinal);
        System.out.println(Initable.staticFinal2);
        /*out:
        after Initable init  .class获取引用没有初始化
        47  static final 没有初始化
        Initable init
        258  staitc final 编译时不确定,需要初始化
        */
        System.out.println(Initable2.staticNonFinal);
        /*out:
        Initable2 init
        147  static not final 需要初始化
        */
        Class initable3 = Class.forName("Initable3");
        System.out.println("after Initable3 init");
        System.out.println(Initable3.staticNonFinal);

    }
}