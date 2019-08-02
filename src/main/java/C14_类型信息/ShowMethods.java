package C14_类型信息;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ShowMethods {

    //获取一个类的所有方法的工具类
    public static void show(Class clazz){
        Method[] declaredMethods = clazz.getDeclaredMethods();
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        System.out.println("构造方法");
        for (Constructor declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor.toString());
        }
        System.out.println("普通方法");
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod.toString());
        }
    }

    //查询这个类是否有同名方法
    public static String contain(Class clazz, String methodName){
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            if (methodName.equals(declaredMethod.getName())){
                return declaredMethod.toString();
            }
        }
        return null;
    }

    public static void main(String[] args) {
//        show(String.class);
        String equals = contain(String.class, "equals");
        System.out.println(equals);
    }
}
