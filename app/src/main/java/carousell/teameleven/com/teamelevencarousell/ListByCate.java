package carousell.teameleven.com.teamelevencarousell;

import android.app.ListActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.List;

import carousell.teameleven.com.teamelevencarousell.data.Category;

/**
 * Created by User on 12/21/2016.
 */

public class ListByCate extends ListActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new AsyncTask<String, Void, List<String>>() {
            @Override
            protected List<String> doInBackground(String... params) {
                return Category.listCategory();
            }
            @Override
            protected void onPostExecute(List<String> result) {
                //Careful and notice the difference >> wrong one >> MyAdapter adapter = new MyAdapter(ListByItems.this, R.layout.row, result);
                MyAdapter adapter = new MyAdapter(ListByCate.this, R.layout.row, result);
                setListAdapter(adapter);
            }
        }.execute();
    }

    @Override
    public void onListItemClick(ListView lv, View v, int position, long id){
        String aCate = (String) getListAdapter().getItem(position);
        Intent i = new Intent(this, ListByItems.class);
        i.putExtra("cateId", aCate);
        startActivity(i);
    }
}
