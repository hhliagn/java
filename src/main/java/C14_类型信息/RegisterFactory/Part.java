package C14_类型信息.RegisterFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part {
    static List<Factory<? extends Part>> factories = new ArrayList<>();
    static {
        factories.add(new AFliter.Factory());
        factories.add(new BFliter.Factory());
    }
    private static Random rand = new Random(47);
    public static Part createRandom(){
        int n = rand.nextInt(factories.size());
        return factories.get(n).create();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            System.out.println(Part.createRandom());
        }
    }


}
class Fliter extends Part{

}
class AFliter extends Fliter{
    public static class Factory implements C14_类型信息.RegisterFactory.Factory<AFliter>{

        @Override
        public AFliter create() {
            return new AFliter();
        }
    }
}
class BFliter extends Fliter{
    public static class Factory implements C14_类型信息.RegisterFactory.Factory<BFliter>{

        @Override
        public BFliter create() {
            return new BFliter();
        }
    }
}
