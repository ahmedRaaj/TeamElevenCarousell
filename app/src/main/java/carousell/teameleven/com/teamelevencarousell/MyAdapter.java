package carousell.teameleven.com.teamelevencarousell;

/**
 * Created by User on 12/21/2016.
 */

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends ArrayAdapter<String> {

    private List<String> items;
    int resource;

    public MyAdapter(Context context, int resource, List<String> items) {
        super(context, resource, items);
        this.resource = resource;
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(resource, null);
        final String cateId = items.get(position);
        if (cateId != null) {
            TextView e = (TextView) v.findViewById(R.id.textViewInRow);
            e.setText(cateId);
        }
        return v;
    }
}