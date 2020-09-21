package com.example.application.mytask2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ListAdapter extends ArrayAdapter <String> {
    Context context;
    String Lname[] ;
    String Ldescription[];
    String Lfull_name[];

    public ListAdapter(@NonNull Context c, String cname[] , String cdescription[] , String cfullname[]) {
        super(c, R.layout.myrow, R.id.textline1, cname);
        this.context = c;
        this.Lname = cname ;
        this.Ldescription = cdescription;
        this.Lfull_name = cfullname;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.myrow , parent ,false);
        TextView name = row.findViewById(R.id.textline1);
        TextView descreptopn = row.findViewById(R.id.textline2);
        TextView fullname = row.findViewById(R.id.textline3);
        name.setText(Lname[position]);
        descreptopn.setText(Ldescription[position]);
        fullname.setText(Lfull_name[position]);

        return row;

    }
}
