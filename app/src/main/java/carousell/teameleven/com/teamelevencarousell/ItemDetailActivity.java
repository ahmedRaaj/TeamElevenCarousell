package carousell.teameleven.com.teamelevencarousell;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ItemDetailActivity extends AppCompatActivity {

    final  static int []view = {R.id.edit_etxt_name,R.id.edit_etxt_price,R.id.edit_etxt_description};
    final static String[]key={"Name","Price","Description"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);
        String item = getIntent().getExtras().getString("ItemId");
        new AsyncTask<String,Void,Item>() {

            @Override
            protected Item doInBackground(String... params) {
                return Item.getItem(params[0]);
            }

            @Override
            protected void onPostExecute(Item result) {
                for (int i = 0; i < view.length; i++) {
                    EditText t = (EditText) findViewById(view[i]);
                    t.setText(result.get(key[i]));
                }
            }
        }.execute(item);
        Button modify = (Button) findViewById(R.id.detail_btn_modify);
        modify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Item c = new Item();
                for (int i=0; i<view.length; i++) {
                    EditText t = (EditText) findViewById(view[i]);
                    c.put(key[i], t.getText().toString());
                }
                new AsyncTask<Item, Void, Void>() {
                    @Override
                    protected Void doInBackground(Item... params) {
                        Item.updateItem(params[0]);
                        return null;
                    }
                    @Override
                    protected void onPostExecute(Void result) {
                        finish();
                    }
                }.execute(c);

                Intent i=new Intent(ItemDetailActivity.this,ListByItems.class);
                startActivity(i);
            }
        });
    }
}
