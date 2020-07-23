package com.ewgf.cramirez.framedataapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Display;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView myListView;
    String[] move_names;
    String[] move_inputs;
    String[] move_speeds;
    String[] move_on_blocks;
    int char_portrait;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.move_select);

        Resources res = getResources();
        myListView = (ListView) findViewById(R.id.myListView);
        move_names = res.getStringArray(R.array.move_names);
        move_inputs = res.getStringArray(R.array.move_inputs);
        move_speeds = res.getStringArray(R.array.move_speeds);
        move_on_blocks = res.getStringArray(R.array.move_on_blocks);
        char_portrait = R.drawable.leona_portrait;

        ItemAdapter itemAdapter = new ItemAdapter(this, move_names, move_inputs, move_speeds, move_on_blocks);
        myListView.setAdapter(itemAdapter);

        ImageView img = (ImageView) findViewById(R.id.charPortraitImageView);
        scaleImage(img, char_portrait);

    }

    private void scaleImage(ImageView img, int pic)
    {
        Display screen = getWindowManager().getDefaultDisplay();
        BitmapFactory.Options options = new BitmapFactory.Options();

        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), pic, options);

        int imageWidth = options.outWidth;
        int screenWidth = screen.getWidth();

        if (imageWidth > screenWidth)
        {
            int ratio = Math.round((float) imageWidth / (float) screenWidth);
            options.inSampleSize = ratio;
        }

        options.inJustDecodeBounds = false;
        Bitmap scaledImage = BitmapFactory.decodeResource(getResources(), pic, options);
        img.setImageBitmap(scaledImage);
    }
}