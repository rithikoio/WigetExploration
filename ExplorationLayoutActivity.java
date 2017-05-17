package com.example.android.wigetexploration;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextClock;

public class ExplorationLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exploration_layout);
        RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup);
        RadioButton rblondon = (RadioButton) findViewById(R.id.radioButtonLondon);
        RadioButton rbbeijing = (RadioButton) findViewById(R.id.radioButtonBeijing);
        RadioButton rbnewyork = (RadioButton) findViewById(R.id.radioButtonNewYork);
        final EditText edittext= (EditText) findViewById(R.id.editText);
        final Button button = (Button) findViewById(R.id.button);
        final TextClock tclock = (TextClock) findViewById(R.id.textClock);
        final EditText editText = (EditText) findViewById(R.id.editText);
        final Button b = (Button) findViewById(R.id.button);
        final TextClock tClock = (TextClock) findViewById(R.id.textClock);
        final CheckBox cbTransparency = (CheckBox) findViewById
                (R.id.checkBoxTransparency);
        final CheckBox cbTint = (CheckBox) findViewById(R.id.checkBoxTint);
        final CheckBox cbReSize = (CheckBox) findViewById
                (R.id.checkBoxresize);
        final ImageView imageView = (ImageView) findViewById(R.id.imageView);
        Switch switch1 = (Switch) findViewById(R.id.switch1);
        final WebView webView = (WebView) findViewById(R.id.webView);
        cbTransparency.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton buttonview,boolean isChecked){
                if(cbTransparency.isChecked()){
                    imageView.setAlpha(.1f);
                }
                else
                {
                    imageView.setAlpha(1f);
                }
            }
        });
        cbTint.setOnCheckedChangeListener(new CompoundButton.
                OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean
                    isChecked) {
                if (cbTint.isChecked()) {
                    // Checked so set some tint
                    imageView.setColorFilter(Color.argb(150, 255, 0, 0));
                } else {
                    imageView.setColorFilter(Color.argb(0,0,0,0));
                }
    }
        });
        cbReSize.setOnCheckedChangeListener
                (new CompoundButton.OnCheckedChangeListener() {
                    public void onCheckedChanged(CompoundButton buttonView,
                                                 boolean isChecked) {
                        if (cbReSize.isChecked()) {
                        // It's checked so make bigger
                            imageView.setScaleX(2);
                            imageView.setScaleY(2);
                        } else {
                            // It's not checked make regular size
                            imageView.setScaleX(1);
                            imageView.setScaleY(1);
                        }
                    }
                });
        rg.clearCheck();
        rg.setOnCheckedChangeListener(new RadioGroup.
                OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {



                RadioButton rb = (RadioButton) group.findViewById
                        (checkedId);
                switch (rb.getId()) {
                    case R.id.radioButtonLondon:
                        tClock.setTimeZone("Europe/London");
                        break;
                    case R.id.radioButtonBeijing:
                        tClock.setTimeZone("CST6CDT");
                        break;
                    case R.id.radioButtonNewYork:
                        tClock.setTimeZone("America/New_York");

                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // We only handle one button
                // So no switching required
                button.setText(editText.getText());
            }
        });
        webView.setWebViewClient(new WebViewClient()
        {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url)
            {
                view.loadUrl("http://www.youtube.com");

                return true;
            }
        });
        webView.loadUrl("http://www.youtube.com");
        webView.setVisibility(View.INVISIBLE);
        switch1.setOnCheckedChangeListener(new CompoundButton.
                OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                if(isChecked){
                    webView.setVisibility(View.VISIBLE);
                }else{
                    webView.setVisibility(View.INVISIBLE);
                }
            }
        });
    }
}

