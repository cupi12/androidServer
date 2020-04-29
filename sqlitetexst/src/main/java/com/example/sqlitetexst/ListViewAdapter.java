package com.example.sqlitetexst;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;


//Model과 View를 매핑해주는역할
public class ListViewAdapter extends BaseAdapter {
    ArrayList<HashMap<String, String>> list;

    public ListViewAdapter(ArrayList<HashMap<String, String>> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        // "listview_item" Layout을 inflate하여 convertView 참조 획득.
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_item, parent, false);
        }
        TextView name = (TextView) convertView.findViewById(R.id.textView1);
        TextView email = (TextView) convertView.findViewById(R.id.textView2);

        name.setText(list.get(pos).get("name"));
        email.setText(list.get(pos).get("email"));
        return convertView;
    }
}
