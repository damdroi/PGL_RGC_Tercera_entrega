package com.example.yo.pgl_rgc_tabs_fragments_try_03;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

public class PicturesAndTextsActivity extends AppCompatActivity {
    //public FloatingActionButton fabTOTAL = (FloatingActionButton) findViewById(R.id.fab);
    //public ImageButton imageButtonStonePublic = (ImageButton) findViewById(R.id.imageButtonStone);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pictures_and_texts);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button buttonRun = (Button) findViewById(R.id.buttonRun);
        buttonRun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageButton imageButtonStone = (ImageButton) findViewById(R.id.imageButtonStone);
                RadioButton radioButtonStone_a = (RadioButton) findViewById(R.id.radioButtonStone_a);
                RadioButton radioButtonStone_b = (RadioButton) findViewById(R.id.radioButtonStone_b);
                CheckBox checkBoxDisplayStones = (CheckBox) findViewById(R.id.checkBoxDisplayStones);
                TextView textViewDemo = (TextView) findViewById(R.id.textViewDemo);
                textViewDemo.setText("Initial Text");

                if (checkBoxDisplayStones.isChecked()) {
                    if (radioButtonStone_a.isChecked()) {
                        textViewDemo.setText("Stone A is marked");
                        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
                        fab.setImageResource(R.mipmap.ic_launcher_stones_letter_a);
                        //fabTOTAL.setImageResource(R.mipmap.ic_launcher_stones_letter_a);
                        imageButtonStone.setImageResource(R.mipmap.ic_launcher_stones_foreground);
                        //imageButtonStonePublic.setImageResource(R.mipmap.ic_launcher_stones_foreground);
                    }
                    if (radioButtonStone_b.isChecked()) {
                        textViewDemo.setText("Stone B is marked");
                        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
                        fab.setImageResource(R.mipmap.ic_launcher_stones_letter_b);
                        imageButtonStone.setImageResource(R.mipmap.ic_launcher_stones_background);
                    }
                    if (!radioButtonStone_a.isChecked() && !radioButtonStone_b.isChecked()) {
                        textViewDemo.setText("You have not selected Stone A or B!!");
                    }
                } else {
                    textViewDemo.setText("Show is disabled");
                }
            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                Intent intent = new Intent(getApplicationContext(), OkActivity.class);
                startActivity(intent);

            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


}
