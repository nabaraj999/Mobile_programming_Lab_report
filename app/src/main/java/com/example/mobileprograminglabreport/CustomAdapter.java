package com.example.mobileprograminglabreport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

    Context context;
    String[] names;
    int[] images;
    LayoutInflater inflater;

    public CustomAdapter(Context c, String[] n, int[] i) {
        context = c;
        names = n;
        images = i;
        inflater = LayoutInflater.from(context);
    }

    public int getCount() { return names.length; }
    public Object getItem(int i) { return names[i]; }
    public long getItemId(int i) { return i; }

    public View getView(int i, View view, ViewGroup parent) {
        if (view == null)
            view = inflater.inflate(R.layout.list_item, parent, false);

        ImageView img = view.findViewById(R.id.icon);
        TextView txt = view.findViewById(R.id.text);

        txt.setText(names[i]);
        img.setImageResource(images[i]);

        return view;
    }
}
