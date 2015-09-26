package com.kingbell.justshawarma;
import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract.Contacts;


import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;


public class InviteActivity extends ActionBarActivity {

    String namecsv="";
    String phonecsv="";

    String namearray[];
    String phonearray[];

    ListView ls;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invite);

        ls = (ListView) findViewById(R.id.listView);

        String orderBy = Contacts.DISPLAY_NAME + " ASC";
        Cursor phones = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,null,null, orderBy);
        while (phones.moveToNext()){
            //Read Contact Name
            String name=phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            //Read Phone Number
            String phoneNumber = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            if(name!=null)
            {
                namecsv += name + ",";
                phonecsv += phoneNumber + ",";
            }
        }
        phones.close();

        namearray = namecsv.split(",");
        phonearray = phonecsv.split(",");

        //Create Array Adapter and Pass ArrayOfValues to it.
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1,android.R.id.text1,namearray);
        ls.setAdapter(adapter);
        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String msg = phonearray[position];
                String message = "Try out the Just Shawarma App its great and Cool!!!";
                Intent sms=new Intent();
                sms.setAction(android.content.Intent.ACTION_VIEW);
                sms.setData(Uri.parse("smsto:" + msg));
                sms.putExtra("sms_body", message);
                startActivity(sms);

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_invite, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
