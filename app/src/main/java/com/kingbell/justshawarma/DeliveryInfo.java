package com.kingbell.justshawarma;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class DeliveryInfo extends ActionBarActivity {
    TextView nameValidation, emailValidation, phoneValidation, addressValidation, areaValidation, zipValidation;
    EditText nameField, emailField, phoneField, addressField, areaField, zipField, cityField;

   // ArrayList<String> customerInfoList = new ArrayList<>();
    CustomerInfoModel customerInfoModel = new CustomerInfoModel();

    Button checkoutButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_info);

        // Edit Text Declaration
        nameField = (EditText) findViewById(R.id.editTextName);
        emailField = (EditText) findViewById(R.id.editEmail);
        phoneField = (EditText) findViewById(R.id.editPhone);
        addressField = (EditText) findViewById(R.id.editAddress1);
        areaField = (EditText) findViewById(R.id.editTextAddress2);
        cityField = (EditText) findViewById(R.id.editTextCity);
        zipField = (EditText) findViewById(R.id.editZipCode);

        //TextView(Validation) Declaration and set the Default visibility to False
        nameValidation = (TextView) findViewById(R.id.textViewNameValidation);
        nameValidation.setTextColor(getResources().getColor(R.color.errorColor));
        nameValidation.setVisibility(View.INVISIBLE);
        emailValidation = (TextView) findViewById(R.id.textViewEmailValidation);
        emailValidation.setTextColor(getResources().getColor(R.color.errorColor));
        emailValidation.setVisibility(View.INVISIBLE);
        phoneValidation = (TextView) findViewById(R.id.textViewPhoneValidation);
        phoneValidation.setTextColor(getResources().getColor(R.color.errorColor));
        phoneValidation.setVisibility(View.INVISIBLE);
        addressValidation = (TextView) findViewById(R.id.textViewAddressValidation);
        addressValidation.setTextColor(getResources().getColor(R.color.errorColor));
        addressValidation.setVisibility(View.INVISIBLE);
        areaValidation = (TextView) findViewById(R.id.textViewAreaValidation);
        areaValidation.setTextColor(getResources().getColor(R.color.errorColor));
        areaValidation.setVisibility(View.INVISIBLE);
        zipValidation = (TextView) findViewById(R.id.textViewZipValidation);
        zipValidation.setTextColor(getResources().getColor(R.color.errorColor));
        zipValidation.setVisibility(View.INVISIBLE);

        //DeliveryInfo Button Declaration
        checkoutButton = (Button) findViewById(R.id.checkOutButton);
        checkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Validating Each input field if it is empty if so then the visibility of textView is said to be Visible
                if(nameField.getText().toString().trim().equals("")) {
                    nameValidation.setVisibility(View.VISIBLE);
                }
                else{
                    nameValidation.setVisibility(View.INVISIBLE);
                }
                if(emailField.getText().toString().trim().equals("")){
                    emailValidation.setVisibility(View.VISIBLE);
                }
                else{
                    emailValidation.setVisibility(View.INVISIBLE);
                }
                if(phoneField.getText().toString().trim().equals("")){
                    phoneValidation.setVisibility(View.VISIBLE);
                }
                else{
                    phoneValidation.setVisibility(View.INVISIBLE);
                }
                if(addressField.getText().toString().trim().equals("")){
                    addressValidation.setVisibility(View.VISIBLE);
                }
                else{
                    addressValidation.setVisibility(View.INVISIBLE);
                    customerInfoModel.setCustomerAddress1(addressField.getText().toString());
                }
                if(areaField.getText().toString().trim().equals("")){
                    areaValidation.setVisibility(View.VISIBLE);
                }
                else{
                    areaValidation.setVisibility(View.INVISIBLE);
                    customerInfoModel.setCustomerAddress2(areaField.getText().toString());
                }

                if(zipField.getText().toString().trim().equals("")){
                    zipValidation.setVisibility(View.VISIBLE);
                }
                else{
                    zipValidation.setVisibility(View.INVISIBLE);
                    customerInfoModel.setCustomerZip(zipField.getText().toString());
                }

                customerInfoModel.setCustomerCity(cityField.getText().toString());
                //Move to next Screen
                Intent intent = new Intent(DeliveryInfo.this,ItemChooserActivity.class);
                intent.putExtra("Delivery","Delivery");
                intent.putExtra("Address1",customerInfoModel.getCustomerAddress1());
                intent.putExtra("Address2",customerInfoModel.getCustomerAddress2());
                intent.putExtra("Zip",customerInfoModel.getCustomerZip());
                intent.putExtra("City",customerInfoModel.getCustomerCity());
                startActivity(intent);

            }
        });
    }


}
