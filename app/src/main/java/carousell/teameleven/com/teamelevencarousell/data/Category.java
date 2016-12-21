package carousell.teameleven.com.teamelevencarousell.data;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import carousell.teameleven.com.teamelevencarousell.json.JSONParser;

/**
 * Created by LMP on 21/12/2016.
 */

public class Category extends java.util.HashMap<String,String> {

    final static String host = "http://192.168.20.172:8090/Customer/Service.svc";

    public Category(String id, String name) {
        put("catId", id);
        put("catName", name);
    }

    public Category(){}

    public static List<String> listCategory() {
        List<String> list = new ArrayList<String>();
        try {
            JSONArray a = JSONParser.getJSONArrayFromUrl(host+"/Category");
            for (int i=0; i<a.length(); i++) {
                String c = a.getString(i);
                list.add(c);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public static Category getCategory(String id) {
        Category cat = null;
        try {
            JSONObject c = JSONParser.getJSONFromUrl(host+"/Category/"+id);
            cat = new Category(Integer.toString(c.getInt("catId")),
                    c.getString("catName"));
        } catch (Exception e) {
        }
        return cat;
    }
}
