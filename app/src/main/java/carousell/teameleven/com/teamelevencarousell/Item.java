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
            c.add(new Item("P1001", "Tablet", "iPad released 2007", 2000, 1));
            c.add(new Item("P1002", "Laptop", "Toshiba laptop brand new", 1130, 2));
            c.add(new Item("P1003", "Necklace","Swarovski necklace,comes with original box", 95, 3));
            c.add(new Item("P1003", "DKNY Sunglasses","DKNY sunnies,worn twice, comes with original box", 250, 3));
            parts = c;
        }
        return(parts);
    }

    public Item(String id, String name, String description, int price, int categoryid) {
        put("id", id);
        put ("name", name);
        put("description", description);
        put("cost", Integer.toString(price));
        put ("categoryID", Integer.toString(categoryid));
    }
}
