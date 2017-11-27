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
import co.edu.konradlorenz.takeassistance.entities.Student;

/**
 * Created by jojstepersan on 10/3/17.
 */

public class StudentAdapter extends ArrayAdapter<Student> {

    public StudentAdapter(Context context, int resource, List<Student> objects) {
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

        Student currentItem=getItem(position);

        ImageView icon=(ImageView)currentView.findViewById(R.id.list_materia_image);
        TextView name=(TextView)currentView.findViewById(R.id.list_materia_name);
        TextView code=(TextView)currentView.findViewById(R.id.list_materia_id);

        switch ((int)currentItem.getCode()){
            case 506151084:
                icon.setImageResource(R.mipmap.ic_launcher_mario);
                break;

            case 506151030:
                icon.setImageResource(R.mipmap.ic_launcher_kevin);
                break;
            case 506151064:
                icon.setImageResource(R.mipmap.ic_launcherstivven);
                break;

            case 506151040:
                icon.setImageResource(R.mipmap.ic_launcherjuan);
                break;
            case 506151050:
                icon.setImageResource(R.mipmap.ic_launchervale);
                break;
            case 506151094:
                icon.setImageResource(R.mipmap.ic_launcherbrendi);
                break;

            case 506151004:
                icon.setImageResource(R.mipmap.ic_launcherdaniela);
                break;


        }

        //icon.setImageResource(R.mipmap.ic_launcher);

        if(name!=null && currentItem.getName()!=null)
            name.setText(currentItem.getName());
        if(code!=null && currentItem.getCode()!=0)
            code.setText(""+currentItem.getCode());

        return currentView;
    }
}
