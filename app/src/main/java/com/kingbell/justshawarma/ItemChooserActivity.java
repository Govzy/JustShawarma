package com.kingbell.justshawarma;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;


public class ItemChooserActivity extends ActionBarActivity {

    TextView decideText, customerAddress,testText;
    CustomerInfoModel customerInfoModel = new CustomerInfoModel();
    LinearLayout ll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_chooser);

        //Fonts
        Typeface shojumar = Typeface.createFromAsset(getAssets(), "shojumar.ttf");
        Typeface arvo = Typeface.createFromAsset(getAssets(), "arvo.ttf");
        //Declare
        decideText = (TextView) findViewById(R.id.decideText);
        customerAddress = (TextView) findViewById(R.id.firstAddress);
        ll = (LinearLayout) findViewById(R.id.LinearAdder);

        testText = (TextView) findViewById(R.id.testText);
        if(getIntent().getStringExtra("Delivery").equals("Delivery"))
        {
            decideText.setTypeface(shojumar);
            decideText.setText("Deliver to:");
            customerAddress.setTypeface(arvo);
            customerAddress.setText(getIntent().getStringExtra("Address1")+","+"\n"+getIntent().getStringExtra("Address2")+", "+
                                    getIntent().getStringExtra("City")+" - "+getIntent().getStringExtra("Zip"));
        }


        Log.e("Main", "" + customerInfoModel.getCustomerName());


    }

    public void showMenu(View view) {
        Intent intent = new Intent(ItemChooserActivity.this,MenuListActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences = getSharedPreferences("itemPreference", Context.MODE_PRIVATE);
        String name = sharedPreferences.getString("itemName", "Value Empty");
        int price = sharedPreferences.getInt("itemPrice",0);
            if(!name.equals("Value Empty")){
            SharedPreferences.Editor editor = sharedPreferences.edit();
            TextView textView1 = new TextView(this);
            textView1.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                                      LinearLayout.LayoutParams.WRAP_CONTENT));
            textView1.setText(name + " " + price);
            ll.addView(textView1);
            editor.clear();
            editor.commit();
        }

    }

    public void LoadPref(View view) {


    }
}
