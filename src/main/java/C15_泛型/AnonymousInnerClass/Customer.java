package C15_泛型.AnonymousInnerClass;

import C15_泛型.genericInterface.Generator;

public class Customer {
    private Customer(){

    }
    //生成多个Generator<Customer>对象
    public static Generator<Customer> generator(){
        return new Generator<Customer>() {
            @Override
            public Customer next() {
                return new Customer();
            }
        };
    }
    //只生成一个Generator<Customer>对象
    public static Generator<Customer> generator1 = new Generator<Customer>() {
        @Override
        public Customer next() {
            return new Customer();
        }
    };
}

