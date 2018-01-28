/*  Author: Dylan Oszust
*   Class: Create Character
*   11/30/17
*   
*   This class runs the character creation activity.  Users will use the GUI to input their character
*   attributes such as; Name, Gender, Race, Class, Alignment, and Ability Scores.  This class will 
*   then adjust the allowed skills according to the class, and will save the character to the
*   database as well as pass it to the profile where it will be saved as the myCharacter object of 
*   type PlayerCharacter
**/

package com.ucfknights.dylan_oszust.dungeonsanddragons;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import static android.graphics.Color.rgb;

public class CreateCharacterActivity extends AppCompatActivity {
    
//  Global variables for the charactwe that will be modified based on user input
    private String strCharacterName = null;
    private String strCharacterRace = null;
    private String strCharacterClass = null;
    private String strAlignment = null;
    private String strGender = null;
    private int intStrength = 0;
    private int intDexterity = 0;
    private int intConstitution = 0;
    private int intIntellect = 0;
    private int intWisdom = 0;
    private int intCharisma = 0;
    private int intLevel = 1;
    private int intArmor = 0;
    private int intInitiative = 0;
    private int intSpeed = 0;
    private int intInspiration = 0;
    private int intPerception = 0;
    private int intProficiency = 2;
    private int intStrengthMod = 0;
    private int intDexterityMod = 0;
    private int intConstitutionMod = 0;
    private int intIntellectMod = 0;
    private int intWisdomMod = 0;
    private int intCharismaMod = 0;
    private int intStrengthSave = 0;
    private int intDexteritySave = 0;
    private int intConstitutionSave = 0;
    private int intIntellectSave = 0;
    private int intWisdomSave = 0;
    private int intCharismaSave = 0;
    private static int intRemainingHP = 0;
    private int intTotalHP = 0;
    private static PlayerCharacter initialCharacter;
    
//  Global variables for view access such as buttons and inputs
    private Button btnMale;
    private Button btnFemale;
    private Button btnLawfulGood;
    private Button btnNeutralGood;
    private Button btnChaoticGood;
    private Button btnLawfulNeutral;
    private Button btnTrueNeutral;
    private Button btnChaoticNeutral;
    private Button btnLawfulEvil;
    private Button btnNeutralEvil;
    private Button btnChaoticEvil;
    private Button[] btnAlignmentArray = new Button[9];
    private EditText txtName;
    private EditText txtStrength;
    private EditText txtDexterity;
    private EditText txtConstitution;
    private EditText txtIntellect;
    private EditText txtWisdom;
    private EditText txtCharisma;
    private Spinner spnCharacterRace;
    private Spinner spnCharacterClass;


//  Creates the activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_character);
        accessViews();
    }

    //  Auto closes keyboard when not on edit text field
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (v instanceof EditText) {
                v.clearFocus();
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
            }
        }
        return super.dispatchTouchEvent(event);
    }

    public void accessViews(){
//      Access Male/Female Buttons
        btnMale = (Button) findViewById(R.id.btnMale);
        btnFemale = (Button) findViewById(R.id.btnFemale);
//      Access Alignment Buttons
        btnLawfulGood = (Button) findViewById(R.id.btnLawfulGood);
        btnNeutralGood = (Button) findViewById(R.id.btnNeutralGood);
        btnChaoticGood = (Button) findViewById(R.id.btnChaoticGood);
        btnLawfulNeutral = (Button) findViewById(R.id.btnLawfulNeutral);
        btnTrueNeutral = (Button) findViewById(R.id.btnTrueNeutral);
        btnChaoticNeutral = (Button) findViewById(R.id.btnChaoticNeutral);
        btnLawfulEvil = (Button) findViewById(R.id.btnLawfulEvil);
        btnNeutralEvil = (Button) findViewById(R.id.btnNeutralEvil);
        btnChaoticEvil = (Button) findViewById(R.id.btnChaoticEvil);
//      Assign Alignment Buttons To Array
        btnAlignmentArray[0] = btnLawfulGood;
        btnAlignmentArray[1] = btnNeutralGood;
        btnAlignmentArray[2] = btnChaoticGood;
        btnAlignmentArray[3] = btnLawfulNeutral;
        btnAlignmentArray[4] = btnTrueNeutral;
        btnAlignmentArray[5] = btnChaoticNeutral;
        btnAlignmentArray[6] = btnLawfulEvil;
        btnAlignmentArray[7] = btnNeutralEvil;
        btnAlignmentArray[8] = btnChaoticEvil;
//      Access Edit Text Fields
        txtName = (EditText) findViewById(R.id.characterName);
        txtStrength = (EditText) findViewById(R.id.scoreStrength);
        txtDexterity = (EditText) findViewById(R.id.scoreDexterity);
        txtConstitution = (EditText) findViewById(R.id.scoreConstitution);
        txtIntellect = (EditText) findViewById(R.id.scoreIntellect);
        txtWisdom = (EditText) findViewById(R.id.scoreWisdom);
        txtCharisma = (EditText) findViewById(R.id.scoreCharisma);
//      Access Spinners
        spnCharacterRace = (Spinner) findViewById(R.id.spinnerRace);
        spnCharacterClass = (Spinner) findViewById(R.id.spinnerClass);
    }
    
//  Sets strGender based on user selection
    public void selectGenderOnClick(View v) {
        
        if (v == btnMale) { // User Selected Male
            btnMale.setBackgroundColor(rgb(194, 0, 0)); //  Changes button to selected
            btnMale.setTextColor(rgb(0, 0, 0));
            deselectedState(btnFemale); // Changes Female to Deselected
            strGender = "male"; // Gender is Male
        } else {
            btnFemale.setBackgroundColor(rgb(194, 0, 0)); //Sets button to selected
            btnFemale.setTextColor(rgb(0, 0, 0));
            deselectedState(btnMale); // Changes Male to Deselected
            strGender = "female"; //  Gender is Female
        }
    }

    public void selectAlignmentOnClick(View v) {
        int id = v.getId();

//      Sets alignment based on user selection
        switch (id) {
            case R.id.btnLawfulGood:
                selectedState(btnLawfulGood);
                strAlignment = "Lawful Good";
                break;
            case R.id.btnNeutralGood:
                selectedState(btnNeutralGood);
                strAlignment = "Neutral Good";
                break;
            case R.id.btnChaoticGood:
                selectedState(btnChaoticGood);
                strAlignment = "Chaotic Good";
                break;
            case R.id.btnLawfulNeutral:
                selectedState(btnLawfulNeutral);
                strAlignment = "Lawful Neutral";
                break;
            case R.id.btnTrueNeutral:
                selectedState(btnTrueNeutral);
                strAlignment = "True Neutral";
                break;
            case R.id.btnChaoticNeutral:
                selectedState(btnChaoticNeutral);
                strAlignment = "Chaotic Neutral";
                break;
            case R.id.btnLawfulEvil:
                selectedState(btnLawfulEvil);
                strAlignment = "Lawful Evil";
                break;
            case R.id.btnNeutralEvil:
                selectedState(btnNeutralEvil);
                strAlignment = "Neutral Evil";
                break;
            case R.id.btnChaoticEvil:
                selectedState(btnChaoticEvil);
                strAlignment = "Chaotic Evil";
                break;
        }

    }

    //   Gets user input and saves created character to application and database
    public void saveCharacterOnClick(View v) {

        boolean boolAbilitiesCompleted = true; // Will trigger false if abilities aren't completed
        String strFiller = "CHOOSE FROM DROPDOWN"; // Default Spinner Selection
        String strNumOfSkills; // Number of skills allowed based on class
        DatabaseHelper DB = new DatabaseHelper(this); // Creates Database Object
        SQLiteDatabase characterDB = DB.getWritableDatabase(); // Gains access to database
        Intent intent = new Intent(this, SkillsActivity.class); //Creates intent to access next activity
        intent.putExtra("Uniqid", "From_CreateCharacter"); // Attatches uniqid to intent to notify SkillsActivity of calling activity

//      Retrieves user input
        strCharacterName = txtName.getText().toString();
        strCharacterRace = spnCharacterRace.getSelectedItem().toString();
        strCharacterClass = spnCharacterClass.getSelectedItem().toString();

//      Tests to make sure all abilities are filled
        try { // Will throw exception if string is empty
            intStrength = Integer.parseInt(txtStrength.getText().toString());
            intDexterity = Integer.parseInt(txtDexterity.getText().toString());
            intConstitution = Integer.parseInt(txtConstitution.getText().toString());
            intIntellect = Integer.parseInt(txtIntellect.getText().toString());
            intWisdom = Integer.parseInt(txtWisdom.getText().toString());
            intCharisma = Integer.parseInt(txtCharisma.getText().toString());
        } catch (Exception e) {
            boolAbilitiesCompleted = false; // Abilities not completed
        }

//      Set traits based on race
        raceBasedTraits();
//      Set traits based on class
        classBasedTraits();

//      Adjusts mods based on attribute value
        intStrengthMod = modifier(intStrength);
        intDexterityMod = modifier(intDexterity);
        intConstitutionMod = modifier(intConstitution);
        intIntellectMod = modifier(intIntellect);
        intWisdomMod = modifier(intWisdom);
        intCharismaMod = modifier(intCharisma);

        intArmor = intDexterityMod + 10;
        intPerception = intWisdomMod + 10;
        intInitiative = intDexterityMod;




//      Confirms attributes are filled out, then creates a playerCharacter obj, saves to database, and starts intent
        if (strCharacterName != null && strGender != null && strAlignment != null && boolAbilitiesCompleted
                && !strCharacterClass.equals(strFiller) && !strCharacterRace.equals(strFiller)) {
            initialCharacter = new PlayerCharacter(strCharacterName, strCharacterRace, strCharacterClass, strAlignment,
                    strGender, intStrength, intDexterity, intConstitution, intIntellect, intWisdom, intCharisma, intLevel,
                    intArmor, intInitiative, intSpeed, intInspiration, intPerception, intProficiency, intStrengthMod,
                    intDexterityMod, intConstitutionMod, intIntellectMod, intWisdomMod, intCharismaMod,
                    intStrengthSave, intDexteritySave, intConstitutionSave, intIntellectSave, intWisdomSave,
                    intCharismaSave, intRemainingHP, intTotalHP);

            ProfileActivity.transferInitialCharacter(initialCharacter); //  Transfer character object to Profile

//          Detects class and decides how many skills are allowed
            if (strCharacterClass.equals("Rogue")) { // Rogues get to choose four skills
                strNumOfSkills = "FOUR";
            } else if (strCharacterClass.equals("Bard")) { // Bards get to choose three skills
                strNumOfSkills = "THREE";
            } else { // All other classes can only choose two skills
                strNumOfSkills = "TWO";
            }

            DatabaseHelper.clearItemData(characterDB);
            DatabaseHelper.clearCharacterData(characterDB); // Clears database of prior characters for new campaign
            DatabaseHelper.insertCharacter(initialCharacter, characterDB); // Saves character to database

            startActivity(intent); // Starts the SkillsActivity

            Toast toast = Toast.makeText(this, "PLEASE SELECT " + strNumOfSkills + " SKILLS", Toast.LENGTH_LONG);
            toast.show(); // Creates toast message allowing user to know how many skills they may use
        } else { // Some fields are incomplete, lets user know they must complete form before continuing
            Toast toast = Toast.makeText(this, "Please Complete All Fields", Toast.LENGTH_LONG);
            toast.show();
        }
    }

//  sets traits based on race
    public void raceBasedTraits() {

        switch (strCharacterRace) {
            case "Human":
                intStrength = intStrength + 1;
                intDexterity = intDexterity + 1;
                intConstitution = intConstitution + 1;
                intIntellect = intIntellect + 1;
                intWisdom = intWisdom + 1;
                intCharisma = intCharisma + 1;
                intSpeed = 30;
                break;
            case "Dwarf":
                intConstitution = intConstitution + 2;
                intSpeed = 25;
                break;
            case "Hill Dwarf":
                intConstitution = intConstitution + 2;
                intWisdom = intWisdom + 1;
                intSpeed = 25;
                break;
            case "Mountain Dwarf":
                intStrength = intStrength + 2;
                intConstitution = intConstitution + 2;
                intSpeed = 25;
                break;
            case "Elf":
                intDexterity = intDexterity + 2;
                intSpeed = 30;
                break;
            case "High Elf":
                intDexterity = intDexterity + 2;
                intIntellect = intIntellect + 1;
                intSpeed = 30;
                break;
            case "Dark Elf":
                intDexterity = intDexterity + 2;
                intCharisma = intCharisma + 1;
                intSpeed = 30;
                break;
            case "Wood Elf":
                intDexterity = intDexterity + 2;
                intWisdom = intWisdom + 1;
                intSpeed = 35;
                break;
            case "Halfling":
                intDexterity = intDexterity + 2;
                intSpeed = 25;
                break;
            case "Lightfoot Halfling":
                intDexterity = intDexterity + 2;
                intCharisma = intCharisma + 1;
                intSpeed = 25;
                break;
            case "Stout Halfling":
                intDexterity = intDexterity + 2;
                intConstitution = intConstitution + 1;
                intSpeed = 25;
                break;
            case "Dragonborn":
                intStrength = intStrength + 2;
                intCharisma = intCharisma + 1;
                intSpeed = 30;
                break;
            case "Gnome":
                intIntellect = intIntellect + 2;
                intSpeed = 25;
                break;
            case "Forest Gnome":
                intDexterity = intDexterity + 1;
                intIntellect = intIntellect + 2;
                intSpeed = 25;
                break;
            case "Rock Gnome":
                intConstitution = intConstitution + 1;
                intIntellect = intIntellect + 2;
                intSpeed = 25;
                break;
            case "Half Elf":
                intCharisma = intCharisma + 2;
                intSpeed = 30;
                break;
            case "Half Orc":
                intStrength = intStrength + 2;
                intConstitution = intConstitution + 1;
                intSpeed = 30;
                break;
            case "Tiefling":
                intIntellect = intIntellect + 1;
                intCharisma = intCharisma + 2;
                intSpeed = 30;
                break;
        }
        return;
    }

//  Sets traits based on class
    public void classBasedTraits() {
        
        int intHealthInitial = 0;
        switch (strCharacterClass) {
            case "Sorcerer":
            case "Wizard":
                intHealthInitial = 6; //  Sorcerer and Wizard's initial health is 6
                break;
            case "Bard":
            case "Cleric":
            case "Druid":
            case "Monk":
            case "Rogue":
            case "Warlock":
                intHealthInitial = 8; //  Bard, Cleric, Druid, Monk, Rogue, and Warlock's initial health is 8
                break;
            case "Fighter":
            case "Paladin":
            case "Ranger":
                intHealthInitial = 10; //  Fighter, Paladin, and Ranger's initial health is 10
                break;
            case "Barbarian":
                intHealthInitial = 12; //  Barbarian's initial health is 12
                break;
        }

        intTotalHP = intHealthInitial + intConstitutionMod; // Starting HP is initial health + constitution modifier
        intRemainingHP = intTotalHP; // Sets character at full health
    }

//  Sets modifiers based on ability scores
    public int modifier(int intAbilityScores){
        int intMod = 0;
        
        switch (intAbilityScores) {
            case 1:
                intMod = -5;
                break;
            case 2:
            case 3:
                intMod = -4;
                break;
            case 4:
            case 5:
                intMod = -3;
                break;
            case 6:
            case 7:
                intMod = -2;
                break;
            case 8:
            case 9:
                intMod = -1;
                break;
            case 10:
            case 11:
                intMod = 0;
                break;
            case 12:
            case 13:
                intMod = 1;
                break;
            case 14:
            case 15:
                intMod = 2;
                break;
            case 16:
            case 17:
                intMod = 3;
                break;
            case 18:
            case 19:
                intMod = 4;
                break;
            case 20:
            case 21:
                intMod = 5;
                break;
            case 22:
            case 23:
                intMod = 6;
                break;
            case 24:
            case 25:
                intMod = 7;
                break;
            case 26:
            case 27:
                intMod = 8;
                break;
            case 28:
            case 29:
                intMod = 9;
                break;
            case 30:
                intMod = 10;
                break;
        }
        return intMod;
    }

    //  Selected buttons will have a red background and black text
    public void selectedState(Button btn) {

        for(int i = 0; i< btnAlignmentArray.length; i++){ // find selected button from alignment array
            if (btnAlignmentArray[i] == btn){
                btnAlignmentArray[i].setBackgroundColor(rgb(194, 0, 0));
                btnAlignmentArray[i].setTextColor(rgb(0, 0, 0));
            }else{ // set all other buttons to deselected
                deselectedState(btnAlignmentArray[i]);
            }
        }
    }

    //  De-selected buttons will have a black background and red text
    public void deselectedState(Button btn) {
        btn.setBackgroundColor(rgb(0, 0, 0));
        btn.setTextColor(rgb(194, 0, 0));
    }

}
