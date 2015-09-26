package com.kingbell.justshawarma;

import android.database.Cursor;
import android.graphics.Typeface;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;


public class AboutUsActivity extends ActionBarActivity {

    ImageSwitcher imageSwitcher;
    TextView aboutUs, descriptionAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        //All View Declaration Goes here

        imageSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcher1);
        //imageSwitcher.setImageResource(R.drawable.aboutus2);
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            public View makeView() {
                ImageView myView = new ImageView(getApplicationContext());
                return myView;
            }
        });
        imageSwitcher.postDelayed(new Runnable() {
            int i = 0;

            public void run() {
                imageSwitcher.setImageResource(i++ % 2 == 0 ? R.drawable.aboutus2 : R.drawable.aboutus3);
                imageSwitcher.postDelayed(this, 4000);
            }
        }, 1000);
        Animation in = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);
        imageSwitcher.setInAnimation(in);
        imageSwitcher.setOutAnimation(out);

        aboutUs = (TextView) findViewById(R.id.aboutUsText);
        //descriptionAbout = (TextView) findViewById(R.id.descriptionAboutText);

        //All font operation goes here
        Typeface shojumar = Typeface.createFromAsset(getAssets(), "shojumar.ttf");
        Typeface arvo = Typeface.createFromAsset(getAssets(), "arvo.ttf");
        aboutUs.setTypeface(shojumar);
        //descriptionAbout.setTypeface(arvo);


        WebView view = (WebView) findViewById(R.id.textContent);
        String text;
        text = "<html><body bgcolor=\"#ffcc32\"><p align=\"justify\">";
        text += "<font face=\"arvo\">";
        text += "Bringing Shawarmas to Bangalore like never before !! , Shawarmas Loaded with Chicken , Fries and Malgoum Shawarmas loaded with Cheese - JUST SHAWARMA";
        text += "</p></body></html>";
        view.loadData(text, "text/html", "utf-8");





    }

}

