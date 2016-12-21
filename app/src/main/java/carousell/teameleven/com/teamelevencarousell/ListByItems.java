package carousell.teameleven.com.teamelevencarousell;

import android.app.ListActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
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
        String catId=intent.getStringExtra("cateId");

        new AsyncTask<Void,Void,List<Items>>()
        {
            @Override
            protected List<Items> doInBackground(Void...params)
            {
                return Items.listItems();
            }
            @Override
            protected void onPostExecute(List<Items> result)
            {
                for(int i=0;i<items.size();i++)
                {
                    //if(items.get(i).get("categoryId")==catId)
                    if(items.get(i).get("categoryId")=="1")
                    {
                        itemNames.add(items.get(i).get("itemName"));

                    }
                }
                ArrayAdapter<String> adapter=new ArrayAdapter<String>(ListByItems.this,android.R.layout.simple_list_item_1,itemNames);
                setListAdapter(adapter);
            }
        };



        Button button=(Button) findViewById(R.id.btnInsert);
        button.setOnClickListener(new View.OnClickListener()
        {
         public void onClick(View v)
         {
             Intent intent=new Intent(getApplicationContext(),InsertActivity.class);
             startActivity(intent);
         }
        });
    }
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id)
    {
        String itemName=(String) getListAdapter().getItem(position);

        Intent i=new Intent(this,ItemDetailActivity.class);
        i.putExtra("itemId",items.get(position).get("itemId"));
    }

}
