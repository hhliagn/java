package C15_泛型.Ereased.Demo2;

public class Weight {

    public static class Factory implements C15_泛型.Ereased.Demo2.Factory<Weight>{

        @Override
        public Weight create() {
            return new Weight();
        }
    }
}
