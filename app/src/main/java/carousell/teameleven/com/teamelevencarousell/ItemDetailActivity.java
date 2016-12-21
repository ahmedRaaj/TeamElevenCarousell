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

import carousell.teameleven.com.teamelevencarousell.data.Items;

public class ItemDetailActivity extends AppCompatActivity {

    final  static int []view = {R.id.detail_edittxt_name,R.id.edit_etxt_price,R.id.detail_edittxt_description};
    final static String[]key={"name","price","description"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);
        String item = getIntent().getExtras().getString("ItemId");
        new AsyncTask<String,Void,Items>() {

            @Override
            protected Items doInBackground(String... params) {

                return Items.getItem(params[0]);
            }

            @Override
            protected void onPostExecute(Items result) {
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
                Items c = new Items();
                for (int i=0; i<view.length; i++) {
                    EditText t = (EditText) findViewById(view[i]);
                    c.put(key[i], t.getText().toString());
                }
                new AsyncTask<Items, Void, Void>() {
                    @Override
                    protected Void doInBackground(Items... params) {
                        Items.updateItem(params[0]);
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

//        Button delete = (Button) findViewById(R.id.detail_btn_delete);
//        delete.setOnClickListener(new View.OnClickListener(){
//
//        });
    }
}
