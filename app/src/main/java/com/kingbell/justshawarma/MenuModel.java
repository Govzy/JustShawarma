package com.kingbell.justshawarma;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Android on 9/9/2015.
 */
public class MenuModel implements Parcelable {

    int itemImage;
    String itemName;
    String itemDescription;
    int itemPrice;

    public MenuModel(String itemNameValue, String itemDescriptionValue, int itemPriceValue, int itemImageResource) {
        this.itemName = itemNameValue;
        this.itemDescription=itemDescriptionValue;
        this.itemPrice=itemPriceValue;
        this.itemImage=itemImageResource;
    }


    protected MenuModel(Parcel in) {
        itemImage = in.readInt();
        itemName = in.readString();
        itemDescription = in.readString();
        itemPrice = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(itemImage);
        dest.writeString(itemName);
        dest.writeString(itemDescription);
        dest.writeInt(itemPrice);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<MenuModel> CREATOR = new Parcelable.Creator<MenuModel>() {
        @Override
        public MenuModel createFromParcel(Parcel in) {
            return new MenuModel(in);
        }

        @Override
        public MenuModel[] newArray(int size) {
            return new MenuModel[size];
        }
    };
}