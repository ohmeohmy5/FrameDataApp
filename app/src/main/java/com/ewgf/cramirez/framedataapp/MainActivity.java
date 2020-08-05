package com.ewgf.cramirez.framedataapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Display;
import android.widget.ImageView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView moveListView;
    ListView titleListView;
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
        moveListView = (ListView) findViewById(R.id.moveListView);
        titleListView = (ListView) findViewById(R.id.titleListView);
        move_names = res.getStringArray(R.array.move_names);
        move_inputs = res.getStringArray(R.array.move_inputs);
        move_speeds = res.getStringArray(R.array.move_speeds);
        move_on_blocks = res.getStringArray(R.array.move_on_blocks);
        char_portrait = R.drawable.leona_portrait;

        ItemAdapter itemAdapter = new ItemAdapter(this, move_names, move_inputs, move_speeds, move_on_blocks);
        moveListView.setAdapter(itemAdapter);

        String[][] labels = arrayMaker();
        ItemAdapter labelItemAdapter = new ItemAdapter(this, labels[0], labels[1], labels[2], labels[3]);
        titleListView.setAdapter(labelItemAdapter);

        ImageView img = (ImageView) findViewById(R.id.charPortraitImageView);
        scaleImage(img, char_portrait);

    }

    private String[][] arrayMaker()
    {
        String[] a1 = new String[1];
        String[] a2 = new String[1];
        String[] a3 = new String[1];
        String[] a4 = new String[1];
        a1[0] = "Name";
        a2[0] = "Input";
        a3[0] = "Speed";
        a4[0] = "On Block";

        String[][] returnS = {a1, a2, a3, a4};
        return returnS;


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