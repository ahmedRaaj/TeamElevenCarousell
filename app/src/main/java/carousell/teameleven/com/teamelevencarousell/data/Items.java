package carousell.teameleven.com.teamelevencarousell.data;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import carousell.teameleven.com.teamelevencarousell.json.JSONParser;

/**
 * Created by DELL on 12/21/2016.
 */

public class Items extends java.util.HashMap<String,String>
{
    final static String host = "http://192.168.20.172:8090/Customer/Service.svc";

    public Items(String id, String name,String description,Double price) {
        put("itemId", id);
        put("itemName", name);
        put("itemDesc",description);
        put("itemPrice",Double.toString(price));
    }

    public Items(){}

    public static List<String> listItems() {
        List<String> list = new ArrayList<String>();
        try {
            JSONArray a = JSONParser.getJSONArrayFromUrl(host+"/Category");
            for (int i=0; i<a.length(); i++) {
                JSONObject b=a.getJSONObject(i);
                new Items(b.getString("itemId"),b.getString("name"),b.getString("description"),b.getDouble("price"));
                list.add(b.getString("name"));
            }
        } catch (Exception e) {
        }
        return list;
    }

    }

