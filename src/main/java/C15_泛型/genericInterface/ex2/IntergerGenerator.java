package C15_泛型.genericInterface.ex2;

import C15_泛型.genericInterface.Generator;

public class IntergerGenerator implements Generator<Integer> {
    private int count = 0;
    @Override
    public Integer next() {
        return count++;
    }
}
