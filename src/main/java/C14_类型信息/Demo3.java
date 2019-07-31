package C14_类型信息;

public class Demo3 {
    //泛型的Class引用
    public static void main(String[] args) {
        Class intClass = int.class;
        Class<Integer> genericIntClass = int.class;
        intClass = double.class;
//        genericIntClass = double.class; 报错,泛型执行编译时检查

        //使用父类
//        Class<Number> GenericNumberClass = int.class; 报错,Interger class对象 不是 Number class对象的子类

        // 使用? 代表任何类的父类
        // 使用? 通配符比不指定泛型好,因为这是主动表示任何类型
        Class<?> intClass2 = int.class;
        intClass2 = double.class;

        //? extends 指定范围
        Class<? extends Number> intClass3 = int.class;
        intClass3 = double.class;
        intClass3 = Number.class;


    }
}
