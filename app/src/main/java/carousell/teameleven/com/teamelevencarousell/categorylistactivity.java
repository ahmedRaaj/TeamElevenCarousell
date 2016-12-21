package carousell.teameleven.com.teamelevencarousell;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class categorylistactivity extends ListActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SimpleAdapter adap = new SimpleAdapter(this, Item.getParts(),
                R.layout.listitemsbycat,
                new String[]{"name"},
                new int[]{R.id.textView, R.id.textView2, R.id.textView3, R.id.textView4, R.id.textView5});
        setListAdapter(adap);
    }

    @Override
    protected void onListItemClick(ListView l, View v,
                                   int position, long id) {
        Item item = (Item) getListAdapter().getItem(position);
        Toast.makeText(this, item.get("description") + " selected", Toast.LENGTH_LONG).show();
    }
}