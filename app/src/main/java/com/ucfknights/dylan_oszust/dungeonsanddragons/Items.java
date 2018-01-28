package com.ucfknights.dylan_oszust.dungeonsanddragons;

import android.util.Log;

/**
 * Created by dyans on 11/27/2017.
 */

public class Items {

    private long ID;
    private String itemName;
    private int itemAmount;

    public Items(String itemName, int itemAmount) {
        this.itemName = itemName;
        this.itemAmount = itemAmount;
    }

    public Items(long ID, String itemName, int itemAmount) {
        this.ID = ID;
        this.itemName = itemName;
        this.itemAmount = itemAmount;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemAmount() {
        return itemAmount;
    }

    public void setItemAmount(int itemAmount) {
        this.itemAmount = itemAmount;
    }

    public String toString() {
        String result;


        result = ("Item: " + itemName + "\nQty: " + itemAmount);
        String result2 = itemName + itemAmount;

        Log.d("formatted String", result);
        Log.d("formatted String", result);

        return result;
    }
}
