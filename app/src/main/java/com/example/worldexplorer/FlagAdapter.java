package com.example.worldexplorer;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FlagAdapter extends BaseAdapter {

    Context context;
    int[] images;
    String[] names;

    public FlagAdapter(Context context, int[] images, String[] names) {
        this.context = context;
        this.images = images;
        this.names = names;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LinearLayout layout = new LinearLayout(context);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(10, 10, 10, 10);


        ImageView img = new ImageView(context);
        img.setImageResource(images[position]);
        img.setLayoutParams(new ViewGroup.LayoutParams(300, 300));
        img.setScaleType(ImageView.ScaleType.CENTER_CROP);

        TextView txt = new TextView(context);
        txt.setText(names[position]);
        txt.setTextSize(18);
        txt.setPadding(0, 10, 0, 0);

        layout.addView(img);
        layout.addView(txt);

        return layout;
    }
}
