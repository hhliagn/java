package C15_泛型.complexModel;

import java.util.ArrayList;

//商店
public class Store extends ArrayList<Shelf> {
    private Store(int shelfNum,int productNum){
        for (int i = 0; i < shelfNum; i++) {
            add(new Shelf(productNum));
        }
    }
}
