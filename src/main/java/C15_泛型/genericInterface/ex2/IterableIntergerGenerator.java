package C15_泛型.genericInterface.ex2;

import java.util.Iterator;

//给生成器实现迭代功能，这里使用继承
public class IterableIntergerGenerator extends IntergerGenerator implements Iterable<Integer>{

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Integer next() {
                return IterableIntergerGenerator.this.next();
            }
        } ;
    }
}
