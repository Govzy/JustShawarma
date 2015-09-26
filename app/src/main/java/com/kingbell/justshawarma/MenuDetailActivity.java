package com.kingbell.justshawarma;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

//import com.viewpagerindicator.TitlePageIndicator;

import java.util.ArrayList;


public class MenuDetailActivity extends ActionBarActivity {

    ViewPager viewPager;
    ArrayList<MenuModel> myMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_detail);
        myMenu = getIntent().getParcelableArrayListExtra("MyMenu");

        int position1 = getIntent().getIntExtra("position", 0);
        Log.d("clicked", myMenu.get(2).itemName + ", " + myMenu.get(position1).itemDescription + ", " +
                myMenu.get(position1).itemImage);


        viewPager = (ViewPager) findViewById(R.id.pager);
        FragmentManager fragManager = getSupportFragmentManager();
        viewPager.setAdapter(new MyAdapter(fragManager));
        viewPager.setPageTransformer(true,new ZoomOutPageTransformer());

//        TitlePageIndicator titlePageIndicator = (TitlePageIndicator) findViewById(R.id.titles);
//        titlePageIndicator.setViewPager(viewPager);
        viewPager.setCurrentItem(position1);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_menu_detail, menu);
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

    class MyAdapter extends FragmentStatePagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return myMenu.size();
        }

        @Override
        public Fragment getItem(int position) {
            MenuDetailFragment fragment = new MenuDetailFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("object", myMenu.get(position));
            fragment.setArguments(bundle);
            return fragment;
        }

        @Override
        public CharSequence getPageTitle(int position) {

            int x = position + 1;
            return  "Tab "+x;

        }
    }
}
