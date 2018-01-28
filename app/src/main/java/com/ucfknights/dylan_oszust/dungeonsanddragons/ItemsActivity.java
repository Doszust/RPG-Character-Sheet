/*  Author: Dylan Oszust
*   Class: Main Activity
*   11/30/17
*
*   This activity will allow the user to add items to a list that he/she will be able to access as
*   well as keep track of gold.  The activity will change its usage depending on where it was opened
*   from.  If it was opened from the battle activity via the use item button, clicking an item will
*   automatically launch the usage dialog, Otherwise clicking an item will display a menu that allows
*   the user to update the QTY, Use an item, or Delete an item.  This will also change the items in
*   the database based on user action.
**/

package com.ucfknights.dylan_oszust.dungeonsanddragons;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v7.widget.PopupMenu;
import android.text.InputType;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.ucfknights.dylan_oszust.dungeonsanddragons.DatabaseHelper.ITEMS_TABLE;
import static com.ucfknights.dylan_oszust.dungeonsanddragons.DatabaseHelper.ITEM_AMOUNT;
import static com.ucfknights.dylan_oszust.dungeonsanddragons.DatabaseHelper.ITEM_ID;
import static com.ucfknights.dylan_oszust.dungeonsanddragons.DatabaseHelper.ITEM_NAME;

public class ItemsActivity extends MainActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private int intMyPosition; // Position of item selected
    private int intItemAmount; // Amount of item
    private int intGoldAmount; // Amount of Gold
    private SQLiteDatabase itemsDB; // The database for items
    private ListView list; // Self Explanatory
    private ArrayAdapter<Items> adapter; // Adapter for the array
    private ArrayList<Items> allItems; // Array List
    private Activity mAct;
    private Items gold; // Creates an item of gold
    private String source; // Source of activity launch
    private TextView txtGoldAmount; // Shows amount of gold to player


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);
        super.setUpNav();

        DatabaseHelper DB = new DatabaseHelper(this); // new Database Helper
        itemsDB = DB.getWritableDatabase(); // Gain access to database
        allItems = new ArrayList<Items>(); // instantiate ArrayList
        mAct = ItemsActivity.this; // Set the activity

//      Set floating action button
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addItemName();
            }
        });

        readItemsFromDB(); // Gathers items from database
        setItemsToList(); // Sets items to the list view
        learnCallingActivity(); // Learns what activity called this one.

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        return super.onNavigationItemSelected(item);
    }

//  reads items from the database and updates them to the list.
    private void readItemsFromDB() {
        Cursor itemsCursor; // the cursor
        itemsCursor = itemsDB.query(ITEMS_TABLE,
                new String[]{ITEM_ID, ITEM_NAME, ITEM_AMOUNT},
                null, null, null, null, ITEM_ID); // Cursor accesses the Items Table and reads the ID, Name, and Amount
        Items tempItem; // saves a temporary item obj
        boolean boolGoldFound = false; // Will trigger true if gold has been saved into the database
        itemsCursor.moveToFirst(); // Moves cursor to first row

//      If the cursor is not at the end of the table
        if (!itemsCursor.isAfterLast()) {
            do {
                long id = itemsCursor.getLong(0); // Column one info (ITEM_ID)
                String name = itemsCursor.getString(1); // Column two info (ITEM_NAME)
                int amount = itemsCursor.getInt(2); // Column three info (ITEM_AMOUNT)

                tempItem = new Items(id, name, amount); // Saves a temporary item

//              Sorts the gold information from the rest of the items
                if (!name.equals("Gold(XY78FG82)")) { // If the row being read is not for gold
                    allItems.add(tempItem); // add the item to the array list
                } else { // If the row being read is for gold
                    gold = new Items(id, name, amount); // Create item for gold
                    boolGoldFound = true; // Gold was in the database
                }

                Log.d("Database", tempItem.toString());

            } while (itemsCursor.moveToNext()); // Iterates cursor through table
        }
        itemsCursor.close(); // Closes cursor when finished

//      If there wasn't a row for gold in the table, initialize gold.
        if (!boolGoldFound) {
            initializeGold();
        }
    }

//  Displays all item information to user
    public void setItemsToList() {

        list = (ListView) findViewById(R.id.listView); // Instantiate list
        adapter = new ArrayAdapter<Items>(this, // Instantiate adapter
                R.layout.item_row,
                allItems);

        list.setAdapter(adapter); // Set the adapter to the list and display items to user

//      Creates an on click listener for each item
        list.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view,
                                            int position, long id) {

                        intMyPosition = position; // Position of item clicked
                        if (source == "BattleActivity") { // If item activity was called from battle activity
                            useItem(position); // Go straight to use item dialog
                        } else {
                            showMenu(view); // Show menu for item
                        }
                    }
                }
        );

        intGoldAmount = gold.getItemAmount(); // Get amount of gold
        txtGoldAmount = (TextView) findViewById(R.id.goldAmount); // Instantiate gold amount textview
        txtGoldAmount.setText(String.valueOf(intGoldAmount)); // Display amount of gold to user
    }


//  Learns which activity opened the item activity
    public void learnCallingActivity() {
        Intent intent = this.getIntent(); // Gets the intent of the class

        if (intent != null) {
            String strData = intent.getExtras().getString("Uniqid"); // Reviews the uniqid
            if (strData.equals("From_Battle")) { // Item activity was called from Battle Activity
                source = "BattleActivity";
            } else {
                source = "Menu"; // Item activity was called from the menu
            }
        }
    }

//  When adding an item, launches the dialog that the user will enter the item name into
    public void addItemName() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Enter New Item Name.");
        final Toast emptyEntry = Toast.makeText(this, "No Item Entered, Entry Canceled!", // Message that will show if user submits an empty field
                Toast.LENGTH_LONG);

//      Set up the input
        final EditText input = new EditText(this);
//      Specify the type of input expected;
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);

//      Set up the buttons
        AlertDialog.Builder ok = builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String m_item;

                m_item = input.getText().toString(); //  Gather user input
                if (m_item.equals("")) {
                    emptyEntry.show(); // User submitted empty field
                } else {
                    addItemAmount(m_item); // Pass the item name to addItemAmount
                }

            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) { // Cancels the dialog
                dialog.cancel();
            }
        });

        builder.show();
    }

//  When adding an item, launches the dialog that the user will enter the item amount into
    public void addItemAmount(final String itemName) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Enter Item Quantity.");

//      Set up the input
        final EditText input = new EditText(this);
//      Specify the type of input expected;
        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        builder.setView(input);

//      Set up the buttons
        AlertDialog.Builder ok = builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                int m_Int;

                try {
                    m_Int = Integer.parseInt(input.getText().toString()); // Gathers User Input
                } catch (Exception e) {
                    m_Int = 1; // If empty input, defaults to 1
                }
                intItemAmount = m_Int; // Set item amount to user input
                Items item = new Items(itemName, intItemAmount); // Create new item
                saveItem(item); //Save item to database

            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) { // Cancels the dialog
                dialog.cancel();
            }
        });

        builder.show();
    }

//  Shows the item menu when clicked
    public void showMenu(View view) {
        PopupMenu menu = new PopupMenu(this, view);
        menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) { // Gets user choice from menu
                int id = item.getItemId();
                switch (id) {
                    case R.id.menu_delete:
                        verifyDeleteRow(intMyPosition); // Starts delete dialog
                        break;
                    case R.id.menu_use:
                        useItem(intMyPosition); // Starts use item dialog
                        break;
                    case R.id.menu_update:
                        updateItem(intMyPosition); // Starts update item dialog
                        break;
                }
                return true;
            }
        });
        menu.inflate(R.menu.items_menu);
        menu.show();
    }

//  Saves the menu to the database and restarts the activity so it shows up on the list
    public void saveItem(Items item) {
        assert item != null;

        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.ITEM_NAME, item.getItemName()); // Puts the name into the content values
        cv.put(DatabaseHelper.ITEM_AMOUNT, item.getItemAmount()); // Puts the item amount into content values

        long idPassedBack = itemsDB.insert(ITEMS_TABLE, null, cv); // Gets the ID created from the database autoincrement
        item.setID(idPassedBack); // Sets item ID

        Log.d("Database", "After Inserting A Record" + item);
        allItems.add(item); // Adds item to the array

        mAct.recreate(); // Restarts activity so the item will appear

    }

//  User is deleting an item
    private void verifyDeleteRow(final int position) {
        //pop up dialog to confirm delete row
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("DELETE THIS ITEM?")
                .setMessage("Do you want to delete this item? \n"
                        + allItems.get(position))
                .setCancelable(false)
                .setNegativeButton("No",
                        new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        })
                .setPositiveButton("Yes",
                        new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Items toDelete = allItems.get(position); // Gets which item is being deleted
                                int count = itemsDB.delete(ITEMS_TABLE, ITEM_ID + "=" + toDelete.getID(), null); //Deletes item from database
                                Log.d("DATABASE", "Deleted: " + count + "record." + " " + toDelete);
                                allItems.remove(toDelete); // Removed item from array
                                Activity mAct = ItemsActivity.this;
                                mAct.recreate(); // Restarts activity so item is removed from screen
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }

//  User is using an item
    public void useItem(final int position) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this); // Prompts user to enter how many they are using
        builder.setTitle("Use How Many?");
        final Toast emptyEntry = Toast.makeText(this, "No Amount Entered, No Items Used!", // Shows if no amount has been entered.
                Toast.LENGTH_LONG);

//      Set up the input
        final EditText input = new EditText(this);
//      Specify the type of input expected;
        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        builder.setView(input);
        final Items item = allItems.get(position);

//      Set up the buttons
        AlertDialog.Builder ok = builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                int m_use;
                try {
                    m_use = Integer.parseInt(input.getText().toString()); // Gather User Input
                } catch (Exception e) { // User submitted empty field
                    m_use = 0;
                    emptyEntry.show();
                }

                int newItemAmount = item.getItemAmount() - m_use; // Sets item amount to the item amount less the item amonunt used

                if (newItemAmount <= 0) { //If there is no more of an item, delete the item
                    int count = itemsDB.delete(ITEMS_TABLE, ITEM_ID + "=" + item.getID(), null);
                    Log.d("DATABASE", "Deleted: " + count + "record." + " " + item);
                    allItems.remove(item);
                } else { // If there is still some left, update the new amount
                    item.setItemAmount(newItemAmount);
                    setNewQuantity(item);
                }
                Activity mAct = ItemsActivity.this;
                mAct.recreate(); // Restart the activity to display updated quantity

            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();

    }

//  User is adding to their item amount
    public void updateItem(final int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Add how many?");
        final Toast emptyEntry = Toast.makeText(this, "No Amount Entered, No Items Added!", // Displays if user entered an empty field
                Toast.LENGTH_LONG);

//      Set up the input
        final EditText input = new EditText(this);
//      Specify the type of input expected;
        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        builder.setView(input);
        final Items item = allItems.get(position);

//      Set up the buttons
        AlertDialog.Builder ok = builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                int m_add;
                try {
                    m_add = Integer.parseInt(input.getText().toString()); // Get user input
                } catch (Exception e) { //Empty Field
                    m_add = 0;
                    emptyEntry.show();
                }
                int newAmount = item.getItemAmount() + m_add; // Set new item amount to item amount plus amount added

                item.setItemAmount(newAmount); // set new item amount
                setNewQuantity(item); // New Quantity Method
                Activity mAct = ItemsActivity.this;
                mAct.recreate(); // Restart activity to display updated information

            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }

    public void addGold(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Add how many?");
        final Toast emptyEntry = Toast.makeText(this, "No Amount Entered, No Gold Added!",
                Toast.LENGTH_LONG);

//      Set up the input
        final EditText input = new EditText(this);
//      Specify the type of input expected;
        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        builder.setView(input);

//      Set up the buttons
        AlertDialog.Builder ok = builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                int m_add;
                try {
                    m_add = Integer.parseInt(input.getText().toString());
                } catch (Exception e) {
                    m_add = 0;
                    emptyEntry.show();
                }
                int newAmount = gold.getItemAmount() + m_add;

                gold.setItemAmount(newAmount);
                setNewQuantity(gold);
                Activity mAct = ItemsActivity.this;
                mAct.recreate();

            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }

    public void spendGold(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Spend how much?");
        final Toast emptyEntry = Toast.makeText(this, "No Amount Entered, No Gold Spent!",
                Toast.LENGTH_LONG);

//      Set up the input
        final EditText input = new EditText(this);
//      Specify the type of input expected;
        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        builder.setView(input);

//      Set up the buttons
        AlertDialog.Builder ok = builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                int m_spend;
                try {
                    m_spend = Integer.parseInt(input.getText().toString());
                } catch (Exception e) {
                    m_spend = 0;
                    emptyEntry.show();
                }
                int newAmount = gold.getItemAmount() - m_spend;

                gold.setItemAmount(newAmount);
                setNewQuantity(gold);
                Activity mAct = ItemsActivity.this;
                mAct.recreate();

            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }

    public void setNewQuantity(Items item) {
        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.ITEM_AMOUNT, item.getItemAmount());
        int count = itemsDB.update(ITEMS_TABLE, cv,
                ITEM_ID + "=" + item.getID(), null);
        Log.d("DATABASE", "updated: " + count + "record." + " " + item);
    }

    public void initializeGold() {
        gold = new Items("Gold(XY78FG82)", 0);
        saveItem(gold);
    }

}

