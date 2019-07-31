package C14_类型信息._6;

import java.util.*;

public class Demo6 {
    public static void main(String[] args) {
        ForNameCreater forNameCreater = new ForNameCreater();
        System.out.println(forNameCreater.arrayList(10));
    }
}
class Pet{
    @Override
    public String toString() {
        return "Pet";
    }
}
abstract class PetCreater{
    private Random rand = new Random(47);
    abstract List<Class<? extends Pet>> types();  //子类实现
    public Pet randomPet(){
        int n = rand.nextInt(types().size());
        try {
            return types().get(n).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) { //构造器为private抛出该异常
            e.printStackTrace();
        }
        return null;
    }
    public Pet[] createArray(int size){
        Pet[] result = new Pet[size];
        for (int i = 0; i < size; i++) {
            result[i] = randomPet();
        }
        return result;
    }
    public ArrayList<Pet> arrayList(int size){
        ArrayList<Pet> result = new ArrayList<>(size);
        Collections.addAll(result, createArray(size));
        return result;
    }
}

class ForNameCreater extends PetCreater{
    private static List<Class<? extends Pet>> types = new ArrayList<>();
    private static String[] nameList = {
        "C14_类型信息._6.Dog",
        "C14_类型信息._6.Cat"
    };
    @SuppressWarnings("unchecked")
    public static void load(){
        for (String s : nameList) {
            Class<? extends Pet> aClass = null;
            try {
                types.add((Class<? extends Pet>) Class.forName(s));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
    static{
        load();
    }

    @Override
    List<Class<? extends Pet>> types() {
        return types;
    }
}
class PetCount{
    static class PetCounter extends HashMap<String,Integer>{
        public void count(String type){
            Integer n = get(type);
            if (n == null){
                put(type,1);
            }else{
                put(type,n + 1);
            }
        }
    }
    public static void count(PetCreater creater){
        PetCounter petCounter = new PetCounter();
        for (Pet pet : creater.createArray(15)) {
            if (pet instanceof Dog){
                petCounter.count("dog");
            }
            if (pet instanceof Cat){
                petCounter.count("cat");
            }
        }
        System.out.println(petCounter);
    }

    public static void main(String[] args) {
        PetCount petCount = new PetCount();
        petCount.count(new ForNameCreater());
    }
}
class LiteralPetCreater extends PetCreater{

    private static final List<Class<? extends Pet>> allTypes
            = Collections.unmodifiableList(Arrays.asList(Dog.class,Cat.class));
    //返回一个只读副本集合,一旦修改会抛UnsupportedOperationException异常

    private static final List<Class<? extends Pet>> types
            = allTypes.subList(allTypes.indexOf(Dog.class),allTypes.size());

    @Override
    List<Class<? extends Pet>> types() {
        return types;
    }

    public static void main(String[] args) {
        System.out.println(types);
    }
}
class Pets{
    public static final PetCreater creater = new LiteralPetCreater();
    public static Pet randomPet(){
        return creater.randomPet();
    }
    public Pet[] createArray(int size){
       return creater.createArray(size);
    }
    public ArrayList<Pet> arrayList(int size){
        return creater.arrayList(size);
    }
}
class PetCount2{
    public static void main(String[] args) {
        PetCount.count(Pets.creater);
    }
}



