
package com.example.worldexplorer;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

// Adapter used to display country flags and their names
public class FlagAdapter extends BaseAdapter {

    // Store the application context, flag images, and country names
    Context context;
    int[] images;
    String[] names;

    // Initialize the adapter with the required data
    public FlagAdapter(Context context, int[] images, String[] names) {
        this.context = context;
        this.images = images;
        this.names = names;
    }

    // Return the total number of flags
    @Override
    public int getCount() {
        return images.length;
    }

    // Return the item at the specified position
    @Override
    public Object getItem(int position) {
        return null;
    }

    // Return the ID of the selected item
    @Override
    public long getItemId(int position) {
        return 0;
    }

    // Create and display each flag item in the GridView
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Create a vertical layout for the flag and its name
        LinearLayout layout = new LinearLayout(context);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(10, 10, 10, 10);

        // Create an ImageView and display the flag image
        ImageView img = new ImageView(context);
        img.setImageResource(images[position]);
        img.setLayoutParams(new ViewGroup.LayoutParams(300, 300));
        img.setScaleType(ImageView.ScaleType.CENTER_CROP);

        // Create a TextView to display the country name
        TextView txt = new TextView(context);
        txt.setText(names[position]);
        txt.setTextSize(18);
        txt.setPadding(0, 10, 0, 0);

        // Add the image and country name to the layout
        layout.addView(img);
        layout.addView(txt);

        // Return the completed item view
        return layout;
    }
}
