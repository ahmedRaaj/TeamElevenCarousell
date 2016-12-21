package carousell.teameleven.com.teamelevencarousell;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import carousell.teameleven.com.teamelevencarousell.data.Items;

public class InsertActivity extends AppCompatActivity {

    final  static int []view = {R.id.edit_etxt_name,R.id.edit_etxt_price,R.id.edit_etxt_description};
    final static String[]key={"name","price","description"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        String item = getIntent().getExtras().getString("ItemId");

        Button save = (Button) findViewById(R.id.insert_btn_save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Items items = new Items();
                for (int i=0; i<view.length; i++) {
                    EditText t = (EditText) findViewById(view[i]);
                    items.put(key[i], t.getText().toString());
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

            }.execute(items);

                Intent i=new Intent(InsertActivity.this,ListByItems.class);
                startActivity(i);
            }
        });
    }
}
