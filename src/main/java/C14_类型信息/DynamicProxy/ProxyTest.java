package C14_类型信息.DynamicProxy;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Collection;

public class ProxyTest {

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Class proxyClass = Proxy.getProxyClass(Collection.class.getClassLoader(), Collection.class);
        System.out.println(proxyClass);
        System.out.println(getConstructors(proxyClass));
        System.out.println(getMethods(proxyClass));
        System.out.println("======================");
        createProxyInstance();
    }

    private static String getMethods(Class proxyClass) {
        System.out.println("constructor list");
        Method[] methods = proxyClass.getMethods();
        return getExecutableList(methods);
    }

    private static String getConstructors(Class proxyClass) {
        System.out.println("method list");
        Constructor[] constructors = proxyClass.getConstructors();
        return getExecutableList(constructors);
    }

    private static String getExecutableList(Executable[] executables) {
        System.out.println("translate method to string");
        StringBuilder sb = new StringBuilder();
        for (Executable executable : executables) {
            sb.append(executable.getName()).append("(");
            Class<?>[] parameterTypes = executable.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                sb.append(parameterType.getName()).append(",");
            }
            if (parameterTypes != null && parameterTypes.length != 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append(")\n");
        }
        return sb.toString();
    }

    public static void createProxyInstance() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> proxyClass = Proxy.getProxyClass(Collection.class.getClassLoader(), Collection.class);
        Constructor<?> constructor = proxyClass.getConstructor(InvocationHandler.class);
        Collection proxy = (Collection) constructor.newInstance(new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return null;
            }
        });

        //方法2 使用proxynewInstance创建对象
        Collection proxy2 = (Collection) Proxy.newProxyInstance(
                Collection.class.getClassLoader(),
                new Class[]{Collection.class},
                new InvocationHandler() {
                    ArrayList target = new ArrayList<String>();
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("before method invoke " + method.getName());
                        return method.invoke(target, args);
                    }
                });

        proxy2.add("aaa");
        proxy2.add("bbb");
        System.out.println(proxy2.size());
        System.out.println(proxy2);
        System.out.println(proxy2.getClass().getName());
    }

}
