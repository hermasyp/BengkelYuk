package bengkelyuk.bengkelapp.id.bengkelyuk.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import bengkelyuk.bengkelapp.id.bengkelyuk.Models.Motor.Motor;

/**
 * Created by herma on 19-Sep-17.
 */

public class SpinnerAdapter extends ArrayAdapter<Motor> {

    private Context context;
    private List<Motor> myObjs;

    public SpinnerAdapter(Context context, int textViewResourceId,
                          List<Motor> myObjs) {
        super(context, textViewResourceId, myObjs);
        this.context = context;
        this.myObjs = myObjs;
    }

    public int getCount(){
        return myObjs.size();
    }

    public Motor getItem(int position){
        return myObjs.get(position);
    }

    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView label = new TextView(context);
        label.setText(myObjs.get(position).getNamaMerk()+" - "+myObjs.get(position).getNamaTipe());
        return label;
    }

    @Override
    public View getDropDownView(int position, View convertView,
                                ViewGroup parent) {
        TextView label = new TextView(context);
        label.setText(myObjs.get(position).getNamaMerk()+" - "+myObjs.get(position).getNamaTipe().trim());
        return label;
    }
}

