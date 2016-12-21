package carousell.teameleven.com.teamelevencarousell;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by User on 12/21/2016.
 */

public class Category extends HashMap<String, String>{

    private static ArrayList<Category> arList = null;

    public static ArrayList<Category> getParts()
    {
        if (arList == null)
        {
            ArrayList<Category> a = new ArrayList<>();
            a.add(new Category("1", "Tablet"));
            a.add(new Category("2", "Laptop"));
            a.add(new Category("3", "Necklace"));
            a.add(new Category("4", "Sun Glass"));
        }

        return arList;
    }

    public Category(String id, String name) {
        put("id", id);
        put ("name", name);
    }
}
