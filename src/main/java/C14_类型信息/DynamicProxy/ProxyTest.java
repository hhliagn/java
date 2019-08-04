package C14_类型信息.DynamicProxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collection;

public class ProxyTest {

    public static void main(String[] args) {
        Class proxyClass = Proxy.getProxyClass(Collection.class.getClassLoader(), Collection.class);
        System.out.println(proxyClass);
        System.out.println(getConstructors(proxyClass));
        System.out.println(getMethods(proxyClass));
    }

    private static String getMethods(Class proxyClass) {
        Method[] methods = proxyClass.getMethods();
        return getExecutableList(methods);
    }

    private static String getConstructors(Class proxyClass) {
        Constructor[] constructors = proxyClass.getConstructors();
        return getExecutableList(constructors);
    }

    private static String getExecutableList(Executable[] executables) {
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
}
