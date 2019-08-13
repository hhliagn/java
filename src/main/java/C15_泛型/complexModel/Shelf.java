package C15_泛型.complexModel;

import java.util.ArrayList;

//货架
public class Shelf extends ArrayList<Product> {
    public Shelf(int productNum){
        for (int i = 0; i < productNum; i++) {
            add(new Product());
        }
    }
}
