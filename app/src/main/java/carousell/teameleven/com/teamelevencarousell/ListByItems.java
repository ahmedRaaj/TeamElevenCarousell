package carousell.teameleven.com.teamelevencarousell;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import carousell.teameleven.com.teamelevencarousell.data.Items;

public class ListByItems extends ListActivity {

    List<Items> items;
    List<String> itemNames;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent=getIntent();
        String catId=intent.getStringExtra("catId");
        items=Items.listItems();
        for(int i=0;i<items.size();i++)
        {
           //if(items.get(i).get("categoryId")==catId)
            if(items.get(i).get("categoryId")=="1")
           {
               itemNames.add(items.get(i).get("itemName"));

           }
        }
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,itemNames);
        setListAdapter(adapter);
    }
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id)
    {
//        String itemName=(String) getListAdapter().getItem(position);
//
//     Intent i=new Intent(this,ItemDetailActivity.class);
//     i.putExtra("itemId",)
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                startActivity(new Intent(this,InsertActivity.class ));
                return true;
            case R.id.item2:
                startActivity(new Intent(this,EditActivity.class ));
                return true;
            case R.id.item3:
                startActivity(new Intent(this,DeleteActivity.class ));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
