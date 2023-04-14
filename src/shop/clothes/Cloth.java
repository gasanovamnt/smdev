package shop.clothes;

import java.lang.reflect.Array;
import java.util.List;

public abstract class Cloth {
    public String name;

    public List<String> color;
    public int price;
    Cloth(String name, List<String> color, int price){
        this.name = name;
        this.color = color;
        this.price = price;
    }
}
