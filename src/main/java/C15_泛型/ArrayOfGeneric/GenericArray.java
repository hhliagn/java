package C15_泛型.ArrayOfGeneric;

public class GenericArray<T> {
    private Object[] array;
    public GenericArray(int size){
        array = new Object[size];
    }
    public void put(int index,T item){
        array[index] = item;
    }
    @SuppressWarnings("unchecked")
    public T get(int index){
        return (T) array[index];
    }
    @SuppressWarnings("unchecked")
    public T[] rep(){
        return (T[]) array;
    }

    public static void main(String[] args) {
        GenericArray<Integer> integerGenericArray = new GenericArray<>(10);
        for (int i = 0; i < 10; i++) {
            integerGenericArray.put(i,i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(integerGenericArray.get(i));
        }
        try {
            Integer[] rep = integerGenericArray.rep();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
