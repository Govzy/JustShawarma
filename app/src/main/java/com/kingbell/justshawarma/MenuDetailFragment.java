package com.kingbell.justshawarma;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class MenuDetailFragment extends Fragment {

    int count =0;
    String Checkthis;
    public MenuDetailFragment() {
        // Required empty public constructor
    }

    String tester;
    int priceTester;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu_detail, container, false);

        //Declaration
        ImageView imageView = (ImageView)view.findViewById(R.id.itemImage);
        TextView name = (TextView)view.findViewById(R.id.TitleText);
        TextView desc = (TextView)view.findViewById(R.id.DescritpionText);
        Button button = (Button) view.findViewById(R.id.addItemButton);



        //Get Bundle Object
        Bundle bundle = getArguments();

        //Populate the Views
        MenuModel menuModel = bundle.getParcelable("object");
        imageView.setImageResource(menuModel.itemImage);
        name.setText(menuModel.itemName);

         tester = menuModel.itemName;
         priceTester = menuModel.itemPrice;

        desc.setText(menuModel.itemDescription);
        final StringBuilder sp = new StringBuilder();


                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        SharedPreferences sharedPreferences = MenuDetailFragment.this.getActivity().getSharedPreferences("itemPreference", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("itemName", tester);
                        editor.putInt("itemPrice",priceTester);
                        editor.commit();
                    }
                });



        return view;


    }


}
