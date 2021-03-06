package carousell.teameleven.com.teamelevencarousell.data;

import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

import carousell.teameleven.com.teamelevencarousell.json.JSONParser;

/**
 * Created by LMP on 21/12/2016.
 */

public class User extends java.util.HashMap<String,String> {

    final static String host = "http://192.168.20.172:8090/Customer/Service.svc";

    public User(String id, String name, String type) {
        put("UserId", id);
        put("UserName", name);
        put("UserType", type);
    }

    public User(){}

    public static List<User> listUser() {
        List<User> list = new ArrayList<User>();
        try {
            JSONArray a = JSONParser.getJSONArrayFromUrl(host+"/User");
            for (int i=0; i<a.length(); i++) {
                JSONObject b = a.getJSONObject(i);
                list.add(new User(b.getString("UserId"), b.getString("UserName"),
                        b.getString("UserType")));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public static User getUser(int id) {
        User user = null;
        try {
            JSONObject c = JSONParser.getJSONFromUrl(host+"/Customer/"+id);
            user = new User(Integer.toString(c.getInt("UserId")),
                    c.getString("UserName"),
                    c.getString("UserType"));
        } catch (Exception e) {
        }
        return user;
    }
}