package com.ewgf.cramirez.framedataapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ItemAdapter extends BaseAdapter {
    LayoutInflater mInflater;
    String[] move_names;
    String[] move_inputs;
    String[] move_speeds;
    String[] move_on_blocks;

    public ItemAdapter(Context c, String[] n, String[] i, String[] s, String[] b) {
        move_names = n;
        move_inputs = i;
        move_speeds = s;
        move_on_blocks = b;
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return move_names.length;
    }

    @Override
    public Object getItem(int position) {
        return move_names[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = mInflater.inflate(R.layout.move_select_detail, null);
        TextView nameTextView = (TextView) v.findViewById(R.id.moveName);
        TextView inputTextView = (TextView) v.findViewById(R.id.moveInput);
        TextView speedTextView = (TextView) v.findViewById(R.id.moveSpeed);
        TextView onBlockTextView = (TextView) v.findViewById(R.id.moveOnBlock);

        String name = move_names[position];
        String input = move_inputs[position];
        String speed = move_speeds[position];
        String onBlock = move_on_blocks[position];

        nameTextView.setText(name);
        inputTextView.setText(input);
        speedTextView.setText(speed);
        onBlockTextView.setText((onBlock));

        return v;
    }
}
