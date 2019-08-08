package Spec.Kits;

import Spec.Exception.BeanCopyException;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class BeanUtils {

    public BeanUtils(){

    }

    public  static <T> T copyProperties(Object from, Class<T> toClass) throws BeanCopyException{
        if (from == null){
            return null;
        }else {
            try {
                T to = toClass.getConstructor().newInstance();
                copyProperities(from,to);
                return to;
            }catch (Exception e){
                throw new BeanCopyException(e);
            }
        }
    }

    public static void copyProperities(Object fromObject, Object toObject) throws BeanCopyException{
        if (fromObject != null && toObject != null){
            Class<? extends Object> fromClass = fromObject.getClass();
            Class<? extends Object> toClass = toObject.getClass();
            boolean isStrict = fromClass == toClass;

            try {
                BeanInfo fromBean = Introspector.getBeanInfo(fromClass);
                BeanInfo toBean = Introspector.getBeanInfo(toClass);
                PropertyDescriptor[] fromPds = fromBean.getPropertyDescriptors();
                PropertyDescriptor[] toPds = toBean.getPropertyDescriptors();
                PropertyDescriptor[] temp = toPds;
                int var1 = toPds.length;
                for(int var2 = 0;var2 < var1; ++var2){
                    PropertyDescriptor toPd = temp[var2];
                    PropertyDescriptor fromPd = getPropertyDescriptor(fromPds,toPd,isStrict);
                    if (fromPd != null && fromPd.getDisplayName().equals(toPd.getDisplayName())){
                        Method readMethod = fromPd.getReadMethod();
                        Method writeMethod = writeMethod(toClass,toPd);
                        if (readMethod != null && writeMethod != null){
                            Object param = readMethod.invoke(fromPd, (Object[]) null);
                            if (param != null){
                                writeMethod.invoke(toPd,param);
                            }
                        }
                    }
                }

            }catch (Exception e){
                throw new BeanCopyException(e);
            }
        }
    }

    public static <T> List<T> copyListProperties(Collection<? extends Object> fromList, Class<T> toClass) throws BeanCopyException{
        if (fromList == null){
            return null;
        }else {
            List<T> result = new ArrayList<T>(fromList.size());
            Iterator<?> iterator = fromList.iterator();

            while (iterator.hasNext()){
                Object next = iterator.next();
                T to = copyProperties(next, toClass);
                result.add(to);
            }
            return result;
        }
    }

    private static Method writeMethod(Class<?> toClass, PropertyDescriptor toPd) {
        String firstByte = toPd.getDisplayName().substring(0,1).toUpperCase();
        String setMethodStr = "set" + firstByte + toPd.getDisplayName().substring(1);
        Method method = null;
        try {
            method = toClass.getMethod(setMethodStr, toPd.getPropertyType());
        }catch (NoSuchMethodException e){

        }
        return method;
    }

    private static PropertyDescriptor getPropertyDescriptor(PropertyDescriptor[] fromPds, PropertyDescriptor ref, boolean isStrict) {
        if (ref.getDisplayName().equals("class")){
            return null;
        }
        for(int var4 = 0; var4 < fromPds.length; var4 ++ ){
            PropertyDescriptor fromPd = fromPds[var4];
            if (isStrict){
                if (fromPd.equals(ref)){
                    return fromPd;
                }
            }else if (fromPd.getPropertyType().equals(ref.getPropertyEditorClass()) && fromPd.getName().equals(ref.getName())){
                return fromPd;
            }
        }
        return null;
    }
}
