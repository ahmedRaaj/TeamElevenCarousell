package carousell.teameleven.com.teamelevencarousell;

import java.util.ArrayList;
import java.util.HashMap;
/**
 * Created by Zoe Wee on 21/12/2016.
 */
public class Item extends HashMap<String, String> {

    private static ArrayList<Item> parts = null;

    public static ArrayList<Item> getParts() {
        if (parts == null) {
            ArrayList<Item> c = new ArrayList<Item>();
            c.add(new Item("1", "Appliances"));
            c.add(new Item("2", "Furniture"));
            c.add(new Item("3", "Fashion"));
            parts = c;
        }
        return (parts);
    }

    public Item(String id, String description, int cost) {
        put("id", id);
        put("description", description);
        put("cost", Integer.toString(cost));
    }
}
