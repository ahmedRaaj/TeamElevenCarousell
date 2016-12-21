package carousell.teameleven.com.teamelevencarousell;

import android.app.ListActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;
import java.util.List;
import carousell.teameleven.com.teamelevencarousell.data.User;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new AsyncTask<Void, Void, List<User>>() {
            @Override
            protected List<User> doInBackground(Void... params) {
                return User.listUser();
            }

            @Override
            protected void onPostExecute(List<User> result) {
                SimpleAdapter adapter = new SimpleAdapter(MainActivity.this,
                        result, android.R.layout.simple_list_item_1,
                        new String[]{"Username"},
                        new int[]{android.R.id.text1});
                setListAdapter(adapter);
            }
        }.execute();
    }

    public void onItemClick(AdapterView<?> av, View v, int position, long id) {
        User s = (User) av.getAdapter().getItem(position);
        String uname = s.get("username");
        Intent intent = new Intent (this, categorylistactivity.class);
        intent.putExtra("username", uname);
        startActivity(intent);
        }
}
