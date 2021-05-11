package com.streamliners.constraintlayout2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.streamliners.constraintlayout2.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Initialize binding
        bind = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());

        //Setting title for activity
        setTitle("ColorMyViews");

        //setup event handler
        setupEventHandlers();
    }

    /**
     * Background color change on click event
     *
     * @param view To get which view is click
     */
    private void makeColored(View view) {
        // setting color to view by checking their id
        if (view.getId() == bind.boxOneText.getId()) {
            view.setBackgroundColor(Color.DKGRAY);
        } else if (view.getId() == bind.boxTwoText.getId()) {
            view.setBackgroundColor(Color.GRAY);
        } else if (view.getId() == bind.boxThreeText.getId()) {
            view.setBackgroundColor(Color.BLUE);
        } else if (view.getId() == bind.boxFourText.getId()) {
            view.setBackgroundColor(Color.MAGENTA);
        } else if (view.getId() == bind.boxFiveText.getId()) {
            view.setBackgroundColor(Color.BLUE);
        } else if (view.getId() == bind.redButton.getId()) {
            bind.boxThreeText.setBackgroundColor(getResources().getColor(R.color.my_red));
        } else if (view.getId() == bind.yellowButton.getId()) {
            bind.boxFourText.setBackgroundColor(getResources().getColor(R.color.my_yellow));
        } else if (view.getId() == bind.greenButton.getId()) {
            bind.boxFiveText.setBackgroundColor(getResources().getColor(R.color.my_green));
        } else {
            view.setBackgroundColor(Color.LTGRAY);
        }
    }
    /**
     *  to setup event handlers for the views
     */
    private void setupEventHandlers() {
        // list of all the clickable views
        List<View> clickableViews = new ArrayList<>(
                Arrays.asList(bind.boxOneText, bind.boxTwoText, bind.boxThreeText,
                        bind.boxFourText, bind.boxFiveText,bind.constraintLayout,
                        bind.redButton, bind.yellowButton, bind.greenButton)
        );

        // set the on click listeners to all the views using loop
        for (View item :
                clickableViews) {
            item.setOnClickListener(v -> makeColored(item));
        }
    }
}