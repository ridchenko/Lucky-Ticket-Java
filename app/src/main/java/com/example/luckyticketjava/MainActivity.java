package com.example.luckyticketjava;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @SuppressLint("UseCompatLoadingForDrawables")
    public void onClick(View view) {
        EditText num = findViewById(R.id.editTextPersonName);
        String input = num.getText().toString();
        ImageView picture = findViewById(R.id.imageView);
        Drawable pictureGreen = getDrawable(getResources()
                .getIdentifier("@drawable/green_light", null, getPackageName()));
        Drawable pictureRed = getDrawable(getResources()
                .getIdentifier("@drawable/red_light", null, getPackageName()));

        if (input.length() == 6) {
            try {
                String[] str = Arrays.copyOfRange(input.split(""),
                        1,
                        input.split("").length);
                int[] result = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();
                if (result[0] + result[1] + result[2] == result[3] + result[4] + result[5]) {
                    picture.setImageDrawable(pictureGreen);
                } else {
                    picture.setImageDrawable(pictureRed);
                }
            } catch (NumberFormatException ex) {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Enter 6 digits",
                        Toast.LENGTH_SHORT);
                toast.show();
            }
        } else {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Enter 6 digits",
                    Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}