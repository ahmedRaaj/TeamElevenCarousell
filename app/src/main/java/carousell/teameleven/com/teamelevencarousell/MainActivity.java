package carousell.teameleven.com.teamelevencarousell;

import android.app.ListActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

import carousell.teameleven.com.teamelevencarousell.data.User;

public class MainActivity extends ListActivity {

    TextView t = (TextView) findViewById(R.id.userTextView);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new AsyncTask<Void, Void, List<String>>() {
            @Override
            protected List<String> doInBackground(Void... params) {
                return User.listUser();
            }
            @Override
            protected void onPostExecute(List<String> result) {
                ArrayAdapter<String> adapter =
                        new ArrayAdapter<String>(getApplicationContext(),
                                R.layout.activity_main, R.id.userListView, result);
                ListView lv = (ListView) findViewById(R.id.userListView);
                setListAdapter(adapter);
 //               lv.setOnItemClickListener(MainActivity.this);
            }
        }.execute();

//        @Override
//        protected void onListItemClick(ListView l, View v, int position, long id) {

//            String usr = (String) getListAdapter().getItem(position);
//            HashMap<String, Object> usr = (HashMap<String, Object>) getListAdapter().getItem(position);
//            String name = (String) usr.get("username");
//            Intent intent = new Intent (this, categorylistactivity.class);
//            intent.putExtra("username", usr);
//            startActivity(intent);
//        }

//    }
