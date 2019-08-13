package C15_泛型.BorderOfGeneric.Demo1;

import java.awt.*;

public class Colors<T extends HasColor> {
    private T item;
    public Colors(){

    }
    public Color getColor(){
        return item.getColor(); //使用上界后可以调用item中的方法
    }
}
