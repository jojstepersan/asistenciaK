package co.edu.konradlorenz.takeassistance.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
import co.edu.konradlorenz.takeassistance.R;
import co.edu.konradlorenz.takeassistance.entities.Class;

/**
 * Created by jojstepersan on 9/26/17.
 */

public class ClassAdapter extends ArrayAdapter<Class>{


    public ClassAdapter(Context context, int resource, List<Class> objects) {
        super(context, resource, objects);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent)
        {
        View currentView=convertView;
        if(currentView==null)
            {
            LayoutInflater vi=LayoutInflater.from(getContext());
            currentView=vi.inflate(R.layout.list_materia_record_item,null);
            }

        Class currentItem=getItem(position);

        ImageView icon=(ImageView)currentView.findViewById(R.id.list_materia_image);
        TextView name=(TextView)currentView.findViewById(R.id.list_materia_name);
        TextView id=(TextView)currentView.findViewById(R.id.list_materia_id);
        TextView group=(TextView)currentView.findViewById(R.id.list_materia_group);

        icon.setImageResource(R.mipmap.ic_launcher);

        if(name!=null && currentItem.getName()!=null)
            name.setText(currentItem.getName());
        if(id!=null && currentItem.getId()!=0)
            id.setText(""+currentItem.getId());
        if(group!=null && currentItem.getGroup()!=0)
            group.setText("Grupo "+currentItem.getGroup());
        return currentView;
        }
}
