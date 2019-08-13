package C15_泛型.genericInterface.ex1;

import C15_泛型.genericInterface.Generator;

public class CoffeeGenerator implements Generator<Coffee> {
    @Override
    public Coffee next() {
        return new Coffee();
    }
}
