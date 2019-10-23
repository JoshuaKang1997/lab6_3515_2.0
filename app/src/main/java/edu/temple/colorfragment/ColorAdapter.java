package edu.temple.colorfragment;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import static java.security.AccessController.getContext;

public class ColorAdapter extends BaseAdapter {

    Context context;
    String[] colors;

    public ColorAdapter(Context context, String colors[]) {
        this.context = context;
        this.colors = colors;
    }


    @Override
    public int getCount() {
        return colors.length;
    }

    @Override
    public Object getItem(int i) {
        return colors[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        TextView textView;

        if(view != null && view instanceof TextView){
            textView = (TextView) view;
        } else{
            textView = new TextView(context);
        }
        String colorValue = colors[i];
        textView.setText(colorValue);

        String[] newcolorValue = {"White", "Blue","Green", "Magenta","Cyan","Black",
                "Lime", "Yellow","Purple","Red"};
        textView.setBackgroundColor(Color.parseColor(newcolorValue[i]));

        return textView;
    }
}

