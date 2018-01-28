/*  Author: Dylan Oszust
*   Class: Main Activity
*   11/30/17
*
*   This class will start the home screen and build the navigation drawer that the app will use
*   This is the parent activity of the other activities in the application so they may draw on the
*   navigation drawer rather than re-writing the navigation drawer code for each activity
**/

package com.ucfknights.dylan_oszust.dungeonsanddragons;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import static com.ucfknights.dylan_oszust.dungeonsanddragons.DatabaseHelper.retrieveCharacter;
import static com.ucfknights.dylan_oszust.dungeonsanddragons.ProfileActivity.myCharacter;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    //  database that will be accessed throughout the application
    public static SQLiteDatabase characterDB;

//  Creates Activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DatabaseHelper DB = new DatabaseHelper(this); // Creates Database Helper
        characterDB = DB.getWritableDatabase(); // Access Database
        setContentView(R.layout.activity_main);
        setUpNav();


    }

    //      Create a new character
    public void newCharacterOnClick(View v) {
        Intent intent = new Intent(this, CreateCharacterActivity.class);
        startActivity(intent);
    }

    //      continue campaign
    public void continueCampaignOnClick(View v) {

        myCharacter = retrieveCharacter(characterDB); //reads information from database

//      tests for database population
        boolean emptyDatabase = false;
        try {
            String CHARACTER_NAME = myCharacter.getCharacterName(); // if the database is populated there will be a character name
        } catch (Exception e) {
            emptyDatabase = true; // The database is empty
        }

//      If there is data start the profile activity, otherwise create a toast message stating there needs to be a character created first
        if (emptyDatabase != true) {
            Intent intent = new Intent(this, ProfileActivity.class);
            startActivity(intent);
        } else {
            Toast toast = Toast.makeText(this, "Please Create a Character First!", Toast.LENGTH_LONG);
            toast.show();
        }

    }

    //  Set up the drawer menu.
    protected void setUpNav() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    //  If the back button is pressed, do this
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    //  Reads what menu item was pressed and reacts accordingly
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id) {
            case R.id.nav_profile:  // This will take the user to the profile activity
                Intent intent = new Intent(this, ProfileActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_battle:  //  This will take the user to the battle activity
                intent = new Intent(this, BattleActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_items:  //  This will take the user to the Items Activity
                intent = new Intent(this, ItemsActivity.class);
                intent.putExtra("Uniqid", "From_Menu");
                startActivity(intent);
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
