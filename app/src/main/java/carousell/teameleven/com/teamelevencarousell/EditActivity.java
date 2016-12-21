package carousell.teameleven.com.teamelevencarousell;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import carousell.teameleven.com.teamelevencarousell.Item;

public class EditActivity extends AppCompatActivity {
     final  static int []view = {R.id.edit_etxt_name,R.id.edit_etxt_price,R.id.edit_etxt_description};
    final static String[]key={"Name","Price","Description"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        String item = getIntent().getExtras().getString("Id");
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
    }
}
