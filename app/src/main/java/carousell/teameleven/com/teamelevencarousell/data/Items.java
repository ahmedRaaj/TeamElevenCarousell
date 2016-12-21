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

    public Items(String id, String name,String description,Double price,String catId) {
        put("itemId", id);
        put("itemName", name);
        put("itemDesc",description);
        put("itemPrice",Double.toString(price));
        put("categoryId",catId);
    }

    public Items(){}

    public static List<Items> listItems() {
        List<Items> list = new ArrayList<Items>();
        try {
            JSONArray a = JSONParser.getJSONArrayFromUrl(host+"/Category");
            for (int i=0; i<a.length(); i++) {
                JSONObject b=a.getJSONObject(i);
                list.add((new Items("101","xyz","abc",9.0,"1")));
                //list.add(new Items(b.getString("itemId"),b.getString("name"),b.getString("description"),b.getDouble("price"),b.getString("catId")));

            }
        } catch (Exception e) {
        }
        return list;
    }

    public static Items getItem(String id){
        Items item = null;
        try {
            JSONObject c = JSONParser.getJSONFromUrl(host+"/Items/"+id);
            item = new Items(c.getString("id"),
                    c.getString("name"),
                    c.getString("description"),
                    c.getDouble("price"),
                    c.getString("categoryID"));
        } catch (Exception e) {
        }
        return item;
    }

    public static void updateItem(Items item){

            JSONObject jitem = new JSONObject();
            try {
                jitem.put("id", item.get("id"));
                jitem.put("name", item.get("name"));
                jitem.put("description", item.get("description"));
                jitem.put("price", Double.parseDouble(item.get("price")));
            } catch (Exception e) {
            }
            String result = JSONParser.postStream(host+"/Update", jitem.toString());

    }

    }

