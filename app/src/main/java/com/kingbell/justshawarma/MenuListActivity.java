package com.kingbell.justshawarma;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class MenuListActivity extends ActionBarActivity {

    ArrayList<MenuModel> menuModelList = new ArrayList<>();
    ArrayList<String> menuModelName= new ArrayList<>();

    String[] itemNameValues,itemDescriptionValues;
    int[] itemPriceValues;
    ListView ls;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_list);

        ls = (ListView) findViewById(R.id.menuListView);


        itemNameValues = getResources().getStringArray(R.array.itemNameArray);
        itemDescriptionValues = getResources().getStringArray(R.array.itemDescriptionArray);
        itemPriceValues = getResources().getIntArray(R.array.itemPriceArray);
        int[] itemImageResources = {R.drawable.js,R.drawable.wholemeat,R.drawable.malgoum,R.drawable.plate};

        for(int i=0;i<itemNameValues.length;i++)
        {
            menuModelList.add(new MenuModel(itemNameValues[i],itemDescriptionValues[i],itemPriceValues[i],itemImageResources[i]));
          //  menuModelName.add(itemNameValues[i]);
        }

        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,itemNameValues);
        ls.setAdapter(adapter);
        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(MenuListActivity.this,MenuDetailActivity.class);
                i.putParcelableArrayListExtra("MyMenu",menuModelList);
                i.putExtra("position", position);
                startActivity(i);
                finish();
            }

        });

    }

}
