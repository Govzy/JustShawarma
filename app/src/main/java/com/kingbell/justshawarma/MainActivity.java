package com.kingbell.justshawarma;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    TextView callText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Declarations
        callText = (TextView) findViewById(R.id.callText);
        callText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+917676561561"));
                startActivity(intent);

            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_Checkout) {
            Intent intent = new Intent(MainActivity.this,DeliveryInfo.class);
            startActivity(intent);
        }
        if (id == R.id.about_Us) {
            Intent intent = new Intent(MainActivity.this,AboutUsActivity.class);
            startActivity(intent);
        }
        if (id == R.id.inviteFriend) {
            Intent intent = new Intent(MainActivity.this,InviteActivity.class);
            startActivity(intent);
        }


        return super.onOptionsItemSelected(item);
    }

    public void doDelivery(View view) {
        Intent intent = new Intent(MainActivity.this,DeliveryInfo.class);
        startActivity(intent);
    }
}
