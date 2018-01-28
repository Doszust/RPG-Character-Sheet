package com.ucfknights.dylan_oszust.dungeonsanddragons;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends MainActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    String characterName = "";
    String race = "";
    String characterClass = "";
    String alignment = "";
    String gender = "";
    int strength = 0;
    int dexterity = 0;
    int constitution = 0;
    int intellect = 0;
    int wisdom = 0;
    int charisma = 0;
    int level = 1;
    int armor = 0;
    int initiative = 0;
    int speed = 0;
    int inspiration = 0;
    int perception = 0;
    int proficiency = 2;
    int strengthMod = 0;
    int dexterityMod = 0;
    int constitutionMod = 0;
    int intellectMod = 0;
    int wisdomMod = 0;
    int charismaMod = 0;
    int strengthSave = 0;
    int dexteritySave = 0;
    int constitutionSave = 0;
    int intellectSave = 0;
    int wisdomSave = 0;
    int charismaSave = 0;
    static int remainingHP = 0;
    int totalHP = 0;
    TextView txtName;
    TextView txtRace;
    TextView txtClass;
    TextView txtAlignment;
    TextView txtArmor;
    TextView txtInit;
    TextView txtSpeed;
    TextView txtInsp;
    TextView txtPerc;
    TextView txtProf;
    TextView txtStr;
    TextView txtStrMod;
    TextView txtStrSave;
    TextView txtDex;
    TextView txtDexMod;
    TextView txtDexSave;
    TextView txtCon;
    TextView txtConMod;
    TextView txtConSave;
    TextView txtWis;
    TextView txtWisMod;
    TextView txtWisSave;
    TextView txtIntel;
    TextView txtIntelMod;
    TextView txtIntelSave;
    TextView txtChar;
    TextView txtCharMod;
    TextView txtCharSave;
    TextView txtLvl;
    TextView txtTotHP;
    TextView txtRemainHP;
    CheckBox saveStrength;
    CheckBox saveConstitution;
    CheckBox saveDexterity;
    CheckBox saveCharisma;
    CheckBox saveIntellect;
    CheckBox saveWisdom;
    Button btnArmor;
    Button btnInitiative;
    Button btnSpeed;
    Button btnInsperation;
    Button btnPerception;
    Button btnProficiency;
    String strAttribute = null;

    public static PlayerCharacter myCharacter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        super.setUpNav();
        retrieveCharacterInfo();
        accessViews();
        populateFields();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        return super.onNavigationItemSelected(item);
    }

    //  receives character created in character creator and
    public static void transferInitialCharacter(PlayerCharacter initialCharacter) {
        myCharacter = initialCharacter;
    }

    //    Gets character info from class
    public void retrieveCharacterInfo() {

        characterName = myCharacter.getCharacterName();
        race = myCharacter.getRace();
        characterClass = myCharacter.getCharacterClass();
        alignment = myCharacter.getAlignment();
        gender = myCharacter.getGender();
        strength = myCharacter.getStrength();
        dexterity = myCharacter.getDexterity();
        constitution = myCharacter.getConstitution();
        intellect = myCharacter.getIntellect();
        wisdom = myCharacter.getWisdom();
        charisma = myCharacter.getCharisma();
        level = myCharacter.getLevel();
        armor = myCharacter.getArmor();
        initiative = myCharacter.getInitiative();
        speed = myCharacter.getSpeed();
        inspiration = myCharacter.getInspiration();
        perception = myCharacter.getPerception();
        proficiency = myCharacter.getProficiency();
        strengthMod = myCharacter.getStrengthMod();
        dexterityMod = myCharacter.getDexterityMod();
        constitutionMod = myCharacter.getConstitutionMod();
        intellectMod = myCharacter.getIntellectMod();
        wisdomMod = myCharacter.getWisdomMod();
        charismaMod = myCharacter.getCharismaMod();
        strengthSave = myCharacter.getStrengthSave();
        dexteritySave = myCharacter.getDexteritySave();
        constitutionSave = myCharacter.getConstitutionSave();
        intellectSave = myCharacter.getIntellectSave();
        wisdomSave = myCharacter.getWisdomSave();
        charismaSave = myCharacter.getCharismaSave();
        remainingHP = myCharacter.getRemainingHP();
        totalHP = myCharacter.getTotalHP();
    }

    //  Gets views from activity content and saves them locally for modification
    private void accessViews() {
        txtName = (TextView) findViewById(R.id.txtCharacterName);
        txtRace = (TextView) findViewById(R.id.txtCharacterRace);
        txtClass = (TextView) findViewById(R.id.txtCharacterClass);
        txtAlignment = (TextView) findViewById(R.id.txtCharacterAlignment);
        txtArmor = (TextView) findViewById(R.id.txtArmor);
        txtInit = (TextView) findViewById(R.id.txtInitiative);
        txtSpeed = (TextView) findViewById(R.id.txtSpeed);
        txtInsp = (TextView) findViewById(R.id.txtInsperation);
        txtPerc = (TextView) findViewById(R.id.txtPerception);
        txtProf = (TextView) findViewById(R.id.txtProficiency);
        txtStr = (TextView) findViewById(R.id.txtStrInit);
        txtStrMod = (TextView) findViewById(R.id.txtStrMod);
        txtStrSave = (TextView) findViewById(R.id.txtStrSave);
        txtDex = (TextView) findViewById(R.id.txtDexInit);
        txtDexMod = (TextView) findViewById(R.id.txtDexMod);
        txtDexSave = (TextView) findViewById(R.id.txtDexSave);
        txtCon = (TextView) findViewById(R.id.txtConInit);
        txtConMod = (TextView) findViewById(R.id.txtConMod);
        txtConSave = (TextView) findViewById(R.id.txtConSave);
        txtWis = (TextView) findViewById(R.id.txtWisInit);
        txtWisMod = (TextView) findViewById(R.id.txtWisMod);
        txtWisSave = (TextView) findViewById(R.id.txtWisSave);
        txtIntel = (TextView) findViewById(R.id.txtIntelInit);
        txtIntelMod = (TextView) findViewById(R.id.txtIntelMod);
        txtIntelSave = (TextView) findViewById(R.id.txtIntelSave);
        txtChar = (TextView) findViewById(R.id.txtCharInit);
        txtCharMod = (TextView) findViewById(R.id.txtCharMod);
        txtCharSave = (TextView) findViewById(R.id.txtCharSave);
        txtLvl = (TextView) findViewById(R.id.txtLevel);
        txtRemainHP = (TextView) findViewById(R.id.txtRemainingHP);
        txtTotHP = (TextView) findViewById(R.id.txtTotalHP);
        saveStrength = (CheckBox) findViewById(R.id.chkStrSave);
        saveConstitution = (CheckBox) findViewById(R.id.chkConSave);
        saveDexterity = (CheckBox) findViewById(R.id.chkDexSave);
        saveCharisma = (CheckBox) findViewById(R.id.chkCharSave);
        saveWisdom = (CheckBox) findViewById(R.id.chkWisSave);
        saveIntellect = (CheckBox) findViewById(R.id.chkIntelSave);
        btnArmor = (Button) findViewById(R.id.btnArmor);
        btnInitiative = (Button) findViewById(R.id.btnInitiative);
        btnSpeed = (Button) findViewById(R.id.btnSpeed);
        btnInsperation = (Button) findViewById(R.id.btnInsperation);
        btnPerception = (Button) findViewById(R.id.btnPerception);
        btnProficiency = (Button) findViewById(R.id.btnProficiency);

    }

    //    Set the fields in the profile with character stats
    private void populateFields() {
        txtName.setText(characterName);
        txtRace.setText(race);
        txtClass.setText(characterClass);

        //Sets saves to default of modifier
        strengthSave = strengthMod;
        dexteritySave = dexterityMod;
        constitutionSave = constitutionMod;
        wisdomSave = wisdomMod;
        intellectSave = intellectMod;
        charismaSave = charismaMod;


//        Adjusts saves based on class
        switch (characterClass) {
            case "Barbarian":
            case "Fighter":
                saveStrength.setChecked(true);
                strengthSave = strengthMod + proficiency;
                saveConstitution.setChecked(true);
                constitutionSave = constitutionMod + proficiency;
                break;

            case "Cleric":
            case "Warlock":
                saveWisdom.setChecked(true);
                wisdomSave = wisdomMod + proficiency;
                saveCharisma.setChecked(true);
                charismaSave = charismaMod + proficiency;
                break;
            case "Druid":
            case "Wizard":
                saveIntellect.setChecked(true);
                intellectSave = intellectMod + proficiency;
                saveWisdom.setChecked(true);
                wisdomSave = wisdomMod + proficiency;
                break;
            case "Bard":
                saveDexterity.setChecked(true);
                dexteritySave = dexterityMod + proficiency;
                saveCharisma.setChecked(true);
                charismaSave = charismaMod + proficiency;
                break;
            case "Monk":
                saveStrength.setChecked(true);
                strengthSave = strengthMod + proficiency;
                saveDexterity.setChecked(true);
                dexteritySave = dexterityMod + proficiency;
                break;
            case "Paladin":
                saveStrength.setChecked(true);
                strengthSave = strengthMod + proficiency;
                saveCharisma.setChecked(true);
                charismaSave = charismaMod + proficiency;
                break;
            case "Ranger":
                saveDexterity.setChecked(true);
                dexteritySave = dexterityMod + proficiency;
                saveWisdom.setChecked(true);
                wisdomSave = wisdomMod + proficiency;
                break;
            case "Rogue":
                saveDexterity.setChecked(true);
                dexteritySave = dexterityMod + proficiency;
                saveIntellect.setChecked(true);
                intellectSave = intellectMod + proficiency;
                break;
            case "Sorcerer":
                saveCharisma.setChecked(true);
                charismaSave = charismaMod + proficiency;
                saveConstitution.setChecked(true);
                constitutionSave = constitutionMod + proficiency;
                break;
        }

//      Populates text fields with character info
        txtAlignment.setText(alignment);
        txtArmor.setText(String.valueOf(armor));
        txtInit.setText(String.valueOf(initiative));
        txtSpeed.setText(String.valueOf(speed));
        txtInsp.setText(String.valueOf(inspiration));
        txtPerc.setText(String.valueOf(perception));
        txtProf.setText("+" + String.valueOf(proficiency));
        txtStr.setText(String.valueOf(strength));
        txtStrMod.setText("Mod " + String.valueOf(strengthMod));
        txtStrSave.setText(String.valueOf(strengthSave));
        txtDex.setText(String.valueOf(dexterity));
        txtDexMod.setText("Mod " + String.valueOf(dexterityMod));
        txtDexSave.setText(String.valueOf(dexteritySave));
        txtCon.setText(String.valueOf(constitution));
        txtConMod.setText("Mod " + String.valueOf(constitutionMod));
        txtConSave.setText(String.valueOf(constitutionSave));
        txtWis.setText(String.valueOf(wisdom));
        txtWisMod.setText("Mod " + String.valueOf(wisdomMod));
        txtWisSave.setText(String.valueOf(wisdomSave));
        txtIntel.setText(String.valueOf(intellect));
        txtIntelMod.setText("Mod " + String.valueOf(intellectMod));
        txtIntelSave.setText(String.valueOf(intellectSave));
        txtChar.setText(String.valueOf(charisma));
        txtCharMod.setText("Mod " + String.valueOf(charismaMod));
        txtCharSave.setText(String.valueOf(charismaSave));
        txtLvl.setText(String.valueOf(level));
        txtRemainHP.setText(String.valueOf(remainingHP));
        txtTotHP.setText(String.valueOf(totalHP));

        if (remainingHP <= (totalHP / 3)) {
            txtRemainHP.setTextColor(Color.RED);
        }else if (remainingHP <= (totalHP / 3) * 2) {
            txtRemainHP.setTextColor(Color.YELLOW);
        }else{
            txtRemainHP.setTextColor(Color.GREEN);
        }


    }

    public void levelUpDialog(View v) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Enter Additional HP");

        final Toast emptyEntry = Toast.makeText(this, "No New Max HP Entered, Leveling Canceled!",
                Toast.LENGTH_LONG);

//       Set up the input
        final EditText input = new EditText(this);
//      Specify the type of input expected;
        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        builder.setView(input);

//      Set up the buttons
        AlertDialog.Builder ok = builder.setPositiveButton("OK", new AlertDialog.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                int newHealth = 0;
                boolean empty = false;

                try {
                    newHealth = Integer.parseInt(input.getText().toString()) + totalHP;
                } catch (Exception e) {
                    emptyEntry.show();
                    empty = true;
                }
                if (!empty) {
                        levelUpCharacter(newHealth);
                }
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

    //  Launch Character SkillsActivity Activity
    public void viewSkillsClickHandler(View v) {
        Intent intent = new Intent(this, SkillsActivity.class);
        intent.putExtra("Uniqid", "From_Profile");
        startActivity(intent);
    }

    public void increaseHP(View v){
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Enter New Remaining HP");

        final Toast emptyEntry = Toast.makeText(this, "No HP Entered, HP Modification Canceled!",
                Toast.LENGTH_LONG);

//       Set up the input
        final EditText input = new EditText(this);
//      Specify the type of input expected;
        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        builder.setView(input);

//      Set up the buttons
        AlertDialog.Builder ok = builder.setPositiveButton("OK", new AlertDialog.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                int newHealth = 0;
                boolean empty = false;

                try {
                    newHealth = Integer.parseInt(input.getText().toString());
                } catch (Exception e) {
                    emptyEntry.show();
                    empty = true;
                }
                if (!empty) {
                    if(newHealth > totalHP){
                        newHealth = totalHP;
                    }
                    remainingHP = newHealth;
                    myCharacter.setRemainingHP(remainingHP);
                    DatabaseHelper.updateCharacter(MainActivity.characterDB, myCharacter);
                    populateFields();

                }
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


    //  Updates character info upon leveling
    public void levelUpCharacter(int newMaxHP) {

        level++;
        totalHP = newMaxHP;
        myCharacter.setTotalHP(totalHP);
        myCharacter.setLevel(level);

        switch (level) {
            case 1:
            case 2:
            case 3:
            case 4:
                proficiency = 2;
                break;
            case 5:
            case 6:
            case 7:
            case 8:
                proficiency = 3;
                break;
            case 9:
            case 10:
            case 11:
            case 12:
                proficiency = 4;
                break;
            case 13:
            case 14:
            case 15:
            case 16:
                proficiency = 5;
                break;
            case 17:
            case 18:
            case 19:
            case 20:
                proficiency = 6;
                break;
        }
        myCharacter.setProficiency(proficiency);
        DatabaseHelper.updateCharacter(MainActivity.characterDB, myCharacter);
        populateFields();
    }

    public void btnAttributeClickHandler(View v) {
        int id = v.getId();


        switch (id) {
            case R.id.btnArmor:
//                manageArmor();
                strAttribute = "Armor";
                break;
            case R.id.btnInitiative:
//                manageInitiative();
                strAttribute = "Initiative";
                break;
            case R.id.btnSpeed:
//                manageSpeed();
                strAttribute = "Speed";
                break;
            case R.id.btnInsperation:
//                manageInsperation();
                strAttribute = "Insperation";
                break;
            case R.id.btnPerception:
//                managePerception();
                strAttribute = "Perception";
                break;
            case R.id.btnProficiency:
//                manageProficiency();
                strAttribute = "Proficiency";
                break;
        }

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Enter New " + strAttribute + " Value");

        final Toast emptyEntry = Toast.makeText(this, "No New " + strAttribute + " Value Entered," +
                        strAttribute + " Canceled!",
                Toast.LENGTH_LONG);

//       Set up the input
        final EditText input = new EditText(this);
//      Specify the type of input expected;
        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        builder.setView(input);

//      Set up the buttons
        AlertDialog.Builder ok = builder.setPositiveButton("OK", new AlertDialog.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                int newValue = 0;
                boolean empty = false;

                try {
                    newValue = Integer.parseInt(input.getText().toString());
                } catch (Exception e) {
                    emptyEntry.show();
                }

                switch (strAttribute) {
                    case "Armor":
                        myCharacter.setArmor(newValue);
                        armor = newValue;
                        break;
                    case "Initiative":
                        myCharacter.setInitiative(newValue );
                        initiative = newValue;
                        break;
                    case "Speed":
                        myCharacter.setSpeed(newValue);
                        speed = newValue;
                        break;
                    case "Insperation":
                        myCharacter.setInspiration(newValue);
                        inspiration = newValue;
                        break;
                    case "Perception":
                        myCharacter.setPerception(newValue);
                        perception = newValue;
                        break;
                    case "Proficiency":
                        myCharacter.setProficiency(newValue);
                        proficiency = newValue;
                        break;
                }
                DatabaseHelper.updateCharacter(MainActivity.characterDB, myCharacter);
                populateFields();

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

}
