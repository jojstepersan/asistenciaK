package com.example.jojstepersan.test.Adapters;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jojstepersan.test.Entities.Record;
import com.example.jojstepersan.test.R;

import org.w3c.dom.Text;

import java.util.List;

import static com.example.jojstepersan.test.R.layout.activity_empty;


/**
 * Created by jojstepersan on 9/19/17.
 */

public class RecordAdapter extends ArrayAdapter<Record>{


    public RecordAdapter( Context context,  int resource) {
        super(context, resource);
    }

    public RecordAdapter(Context context,  int resource,  List<Record> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position,View convertView,ViewGroup parent) {
         View currentView=convertView;
        if (convertView==null)
            {
                LayoutInflater vi;
                vi=LayoutInflater.from(getContext());
                currentView=vi.inflate(R.layout.activity_empty,null);
            }
        Record curentItem=getItem(position);
        ImageView icon=(ImageView)currentView.findViewById(R.id.list_record_item_image);
        TextView id=(TextView)currentView.findViewById(R.id.list_record_item_id);
        TextView name=(TextView)currentView.findViewById(R.id.list_record_item_name);
        TextView equipo=(TextView) currentView.findViewById(R.id.list_record_item_equipo);

        return convertView;
    }
}
