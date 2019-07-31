package C14_类型信息;

public class Demo5 {
}
class GenericIntegerTest{
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class<IntergerClass> intergerClassClass = IntergerClass.class;
        IntergerClass intergerClass = intergerClassClass.newInstance();

        Class<? super IntergerClass> superclass = intergerClassClass.getSuperclass();
//        Class<NumberClass> superClass = intergerClassClass.getSuperclass(); //报错,不能编译,只能识别 ? super IntergerClass
        Object object = superclass.newInstance(); //返回非精确类型
    }

}
class IntergerClass extends NumberClass{

}
class NumberClass{

}
