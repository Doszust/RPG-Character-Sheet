package com.ucfknights.dylan_oszust.dungeonsanddragons;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import static com.ucfknights.dylan_oszust.dungeonsanddragons.DatabaseHelper.updateCharacter;
import static com.ucfknights.dylan_oszust.dungeonsanddragons.ProfileActivity.myCharacter;

public class SkillsActivity extends AppCompatActivity {

    //  Global variables
    CheckBox athletics;
    CheckBox strIntimidation;
    CheckBox acrobatics;
    CheckBox stealth;
    CheckBox sleightOfHand;
    CheckBox arcana;
    CheckBox history;
    CheckBox nature;
    CheckBox religion;
    CheckBox investigation;
    CheckBox insight;
    CheckBox medicine;
    CheckBox perception;
    CheckBox survival;
    CheckBox animalHandling;
    CheckBox deception;
    CheckBox charIntimidation;
    CheckBox performance;
    CheckBox persuasion;
    CheckBox[] checkArray = new CheckBox[19];
    TextView txtAthletics;
    TextView txtStrIntimidation;
    TextView txtAcrobatics;
    TextView txtStealth;
    TextView txtSleightOfHand;
    TextView txtArcana;
    TextView txtHistory;
    TextView txtNature;
    TextView txtReligion;
    TextView txtInvestigation;
    TextView txtInsight;
    TextView txtMedicine;
    TextView txtPerception;
    TextView txtSurvival;
    TextView txtAnimalHandling;
    TextView txtDeception;
    TextView txtCharIntimidation;
    TextView txtPerformance;
    TextView txtPersuasion;
    TextView[] textArray = new TextView[19];
    boolean athleticsChecked;
    boolean strIntimidationChecked;
    boolean acrobaticsChecked;
    boolean stealthChecked;
    boolean sleightOfHandChecked;
    boolean arcanaChecked;
    boolean historyChecked;
    boolean natureChecked;
    boolean religionChecked;
    boolean investigationChecked;
    boolean insightChecked;
    boolean medicineChecked;
    boolean perceptionChecked;
    boolean survivalChecked;
    boolean animalHandlingChecked;
    boolean deceptionChecked;
    boolean charIntimidationChecked;
    boolean performanceChecked;
    boolean persuasionChecked;
    boolean[] boolArray = new boolean[19];
    int proficiency;
    int strengthMod;
    int dexMod;
    int wisdomMod;
    int intellectMod;
    int charismaMod;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skills);
        getViews();
        getValues();
        setStates();


//        Only allows checkboxes editable when needed
        Intent intent = this.getIntent();
        if (intent != null) {
            String strData = intent.getExtras().getString("Uniqid");
            if (strData.equals("From_Profile")) {
                makeUnclickable();
            } else {
                makeClickable();
            }
        }
    }

    //  Get views from skills content
    public void getViews() {


        athletics = (CheckBox) findViewById(R.id.chkAthletics);
        strIntimidation = (CheckBox) findViewById(R.id.chkStrengthIntimidation);
        acrobatics = (CheckBox) findViewById(R.id.chkAcrobatics);
        stealth = (CheckBox) findViewById(R.id.chkStealth);
        sleightOfHand = (CheckBox) findViewById(R.id.chkSleightOfHand);
        arcana = (CheckBox) findViewById(R.id.chkArcana);
        history = (CheckBox) findViewById(R.id.chkHistory);
        nature = (CheckBox) findViewById(R.id.chkNature);
        religion = (CheckBox) findViewById(R.id.chkReligion);
        investigation = (CheckBox) findViewById(R.id.chkInvestigation);
        insight = (CheckBox) findViewById(R.id.chkInsight);
        medicine = (CheckBox) findViewById(R.id.chkMedicine);
        perception = (CheckBox) findViewById(R.id.chkPerception);
        survival = (CheckBox) findViewById(R.id.chkSurvival);
        animalHandling = (CheckBox) findViewById(R.id.chkAnimalHandling);
        deception = (CheckBox) findViewById(R.id.chkDeception);
        charIntimidation = (CheckBox) findViewById(R.id.chkCharismaIntimidation);
        performance = (CheckBox) findViewById(R.id.chkPerformance);
        persuasion = (CheckBox) findViewById(R.id.chkPersuasion);
        txtAthletics = (TextView) findViewById(R.id.numAthletics);
        txtStrIntimidation = (TextView) findViewById(R.id.numStrengthIntimidation);
        txtAcrobatics = (TextView) findViewById(R.id.numAcrobatics);
        txtStealth = (TextView) findViewById(R.id.numStealth);
        txtSleightOfHand = (TextView) findViewById(R.id.numSleightOfHand);
        txtArcana = (TextView) findViewById(R.id.numArcana);
        txtHistory = (TextView) findViewById(R.id.numHistory);
        txtNature = (TextView) findViewById(R.id.numNature);
        txtReligion = (TextView) findViewById(R.id.numReligion);
        txtInvestigation = (TextView) findViewById(R.id.numInvestigation);
        txtInsight = (TextView) findViewById(R.id.numInsight);
        txtMedicine = (TextView) findViewById(R.id.numMedicine);
        txtPerception = (TextView) findViewById(R.id.numPerception);
        txtSurvival = (TextView) findViewById(R.id.numSurvival);
        txtAnimalHandling = (TextView) findViewById(R.id.numAnimalHandling);
        txtDeception = (TextView) findViewById(R.id.numDeception);
        txtCharIntimidation = (TextView) findViewById(R.id.numCharismaIntimidation);
        txtPerformance = (TextView) findViewById(R.id.numPerformance);
        txtPersuasion = (TextView) findViewById(R.id.numPersuasion);

        checkArray[0] = athletics;
        checkArray[1] = strIntimidation;
        checkArray[2] = acrobatics;
        checkArray[3] = stealth;
        checkArray[4] = sleightOfHand;
        checkArray[5] = arcana;
        checkArray[6] = history;
        checkArray[7] = nature;
        checkArray[8] = religion;
        checkArray[9] = investigation;
        checkArray[10] = insight;
        checkArray[11] = medicine;
        checkArray[12] = perception;
        checkArray[13] = survival;
        checkArray[14] = animalHandling;
        checkArray[15] = deception;
        checkArray[16] = charIntimidation;
        checkArray[17] = performance;
        checkArray[18] = persuasion;

        textArray[0] = txtAthletics;
        textArray[1] = txtStrIntimidation;
        textArray[2] = txtAcrobatics;
        textArray[3] = txtStealth;
        textArray[4] = txtSleightOfHand;
        textArray[5] = txtArcana;
        textArray[6] = txtHistory;
        textArray[7] = txtNature;
        textArray[8] = txtReligion;
        textArray[9] = txtInvestigation;
        textArray[10] = txtInsight;
        textArray[11] = txtMedicine;
        textArray[12] = txtPerception;
        textArray[13] = txtSurvival;
        textArray[14] = txtAnimalHandling;
        textArray[15] = txtDeception;
        textArray[16] = txtCharIntimidation;
        textArray[17] = txtPerformance;
        textArray[18] = txtPersuasion;


    }

    //   Set states of checkboxes and values
    public void setStates() {

//      Decide which check boxes will be checked
        athleticsChecked = myCharacter.isAthletics();
        strIntimidationChecked = myCharacter.isStrIntimidation();
        acrobaticsChecked = myCharacter.isAcrobatics();
        stealthChecked = myCharacter.isStealth();
        sleightOfHandChecked = myCharacter.isSleightOfHand();
        arcanaChecked = myCharacter.isArcana();
        historyChecked = myCharacter.isHistory();
        natureChecked = myCharacter.isNature();
        religionChecked = myCharacter.isReligion();
        investigationChecked = myCharacter.isInvestigation();
        insightChecked = myCharacter.isInsight();
        medicineChecked = myCharacter.isMedicine();
        perceptionChecked = myCharacter.isPerceptionChecked();
        survivalChecked = myCharacter.isSurvival();
        animalHandlingChecked = myCharacter.isAnimalHandling();
        deceptionChecked = myCharacter.isDeception();
        charIntimidationChecked = myCharacter.isCharIntimidation();
        performanceChecked = myCharacter.isPerformance();
        persuasionChecked = myCharacter.isPersuasion();

        for (int i = 0; i < textArray.length; i++) {
            textArray[i].setText("");
        }

        boolArray[0] = athleticsChecked;
        boolArray[1] = strIntimidationChecked;
        boolArray[2] = acrobaticsChecked;
        boolArray[3] = stealthChecked;
        boolArray[4] = sleightOfHandChecked;
        boolArray[5] = arcanaChecked;
        boolArray[6] = historyChecked;
        boolArray[7] = natureChecked;
        boolArray[8] = religionChecked;
        boolArray[9] = investigationChecked;
        boolArray[10] = insightChecked;
        boolArray[11] = medicineChecked;
        boolArray[12] = perceptionChecked;
        boolArray[13] = survivalChecked;
        boolArray[14] = animalHandlingChecked;
        boolArray[15] = deceptionChecked;
        boolArray[16] = charIntimidationChecked;
        boolArray[17] = performanceChecked;
        boolArray[18] = persuasionChecked;


//      Shows skill attribute if skill is selected and places a "+" in front if skill attribute is > 0
        if (athleticsChecked) {
            if (strengthMod + proficiency > 0) {
                txtAthletics.setText("+" + String.valueOf(strengthMod + proficiency));
            } else {
                txtAthletics.setText(String.valueOf(strengthMod + proficiency));
            }
            athletics.setChecked(athleticsChecked);
        }
        if (strIntimidationChecked) {
            if (strengthMod + proficiency > 0) {
                txtStrIntimidation.setText("+" + String.valueOf(strengthMod + proficiency));
            } else {
                txtStrIntimidation.setText(String.valueOf(strengthMod + proficiency));
            }
            strIntimidation.setChecked(strIntimidationChecked);
        }

        if (acrobaticsChecked) {
            if (dexMod + proficiency > 0) {
                txtAcrobatics.setText("+" + String.valueOf(dexMod + proficiency));
            } else {
                txtAcrobatics.setText(String.valueOf(dexMod + proficiency));
            }
            acrobatics.setChecked(acrobaticsChecked);
        }
        if (stealthChecked) {
            if (dexMod + proficiency > 0) {
                txtStealth.setText("+" + String.valueOf(dexMod + proficiency));
            } else {
                txtStealth.setText(String.valueOf(dexMod + proficiency));
            }
            stealth.setChecked(stealthChecked);
        }
        if (sleightOfHandChecked) {
            if (dexMod + proficiency > 0) {
                txtSleightOfHand.setText("+" + String.valueOf(dexMod + proficiency));
            } else {
                txtSleightOfHand.setText(String.valueOf(dexMod + proficiency));
            }
            sleightOfHand.setChecked(sleightOfHandChecked);
        }
        if (arcanaChecked) {
            if (intellectMod + proficiency > 0) {
                txtArcana.setText("+" + String.valueOf(intellectMod + proficiency));
            } else {
                txtArcana.setText(String.valueOf(intellectMod + proficiency));
            }
            arcana.setChecked(arcanaChecked);
        }
        if (historyChecked) {
            if (intellectMod + proficiency > 0) {
                txtHistory.setText("+" + String.valueOf(intellectMod + proficiency));
            } else {
                txtHistory.setText(String.valueOf(intellectMod + proficiency));
            }
            history.setChecked(historyChecked);
        }
        if (natureChecked) {
            if (intellectMod + proficiency > 0) {
                txtNature.setText("+" + String.valueOf(intellectMod + proficiency));
            } else {
                txtNature.setText(String.valueOf(intellectMod + proficiency));
            }
            nature.setChecked(natureChecked);
        }
        if (religionChecked) {
            if (intellectMod + proficiency > 0) {
                txtReligion.setText("+" + String.valueOf(intellectMod + proficiency));
            } else {
                txtReligion.setText(String.valueOf(intellectMod + proficiency));
            }
            religion.setChecked(religionChecked);
        }
        if (investigationChecked) {
            if (intellectMod + proficiency > 0) {
                txtInvestigation.setText("+" + String.valueOf(intellectMod + proficiency));
            } else {
                txtInvestigation.setText(String.valueOf(intellectMod + proficiency));
            }
            investigation.setChecked(investigationChecked);
        }
        if (insightChecked) {
            if (wisdomMod + proficiency > 0) {
                txtInsight.setText("+" + String.valueOf(wisdomMod + proficiency));
            } else {
                txtInsight.setText(String.valueOf(wisdomMod + proficiency));
            }
            insight.setChecked(insightChecked);
        }
        if (medicineChecked) {
            if (wisdomMod + proficiency > 0) {
                txtMedicine.setText("+" + String.valueOf(wisdomMod + proficiency));
            } else {
                txtMedicine.setText(String.valueOf(wisdomMod + proficiency));
            }
            medicine.setChecked(medicineChecked);
        }
        if (perceptionChecked) {
            if (wisdomMod + proficiency > 0) {
                txtPerception.setText("+" + String.valueOf(wisdomMod + proficiency));
            } else {
                txtPerception.setText(String.valueOf(wisdomMod + proficiency));
            }
            perception.setChecked(perceptionChecked);
        }
        if (survivalChecked) {
            if (wisdomMod + proficiency > 0) {
                txtSurvival.setText("+" + String.valueOf(wisdomMod + proficiency));
            } else {
                txtSurvival.setText(String.valueOf(wisdomMod + proficiency));
            }
            survival.setChecked(survivalChecked);
        }
        if (animalHandlingChecked) {
            if (wisdomMod + proficiency > 0) {
                txtAnimalHandling.setText("+" + String.valueOf(wisdomMod + proficiency));
            } else {
                txtAnimalHandling.setText(String.valueOf(wisdomMod + proficiency));
            }
            animalHandling.setChecked(animalHandlingChecked);
        }
        if (deceptionChecked) {
            if (charismaMod + proficiency > 0) {
                txtDeception.setText("+" + String.valueOf(charismaMod + proficiency));
            } else {
                txtDeception.setText(String.valueOf(charismaMod + proficiency));
            }
            deception.setChecked(deceptionChecked);
        }
        if (charIntimidationChecked) {
            if (charismaMod + proficiency > 0) {
                txtCharIntimidation.setText("+" + String.valueOf(charismaMod + proficiency));
            } else {
                txtCharIntimidation.setText(String.valueOf(charismaMod + proficiency));
            }
            charIntimidation.setChecked(charIntimidationChecked);
        }
        if (perceptionChecked) {
            if (charismaMod + proficiency > 0) {
                txtPerception.setText("+" + String.valueOf(charismaMod + proficiency));
            } else {
                txtPerception.setText(String.valueOf(charismaMod + proficiency));
            }
            perception.setChecked(perceptionChecked);
        }
        if (performanceChecked) {
            if (charismaMod + proficiency > 0) {
                txtPerformance.setText("+" + String.valueOf(charismaMod + proficiency));
            } else {
                txtPerformance.setText(String.valueOf(charismaMod + proficiency));
            }
            performance.setChecked(performanceChecked);
        }
        if (persuasionChecked) {
            if (charismaMod + proficiency > 0) {
                txtPersuasion.setText("+" + String.valueOf(charismaMod + proficiency));
            } else {
                txtPersuasion.setText(String.valueOf(charismaMod + proficiency));
            }
            persuasion.setChecked(persuasionChecked);
        }
    }

    //  Set skills from activity
    public void setSkills(View v) {

        int id = v.getId();
        boolean toast = false;
        String checkText = null;
        String myClass = myCharacter.getCharacterClass();

//      sets checked state based on user input
        switch (id) {
            case R.id.chkAthletics:
                if (myClass.matches("Barbarian|Bard|Fighter|Monk|Paladin|Ranger|Rogue")) {
                    athleticsChecked = athletics.isChecked();
                } else {
                    athletics.setChecked(false);
                    checkText = "Athletics";
                    toast = true;
                }
                break;
            case R.id.chkStrengthIntimidation:
                if (myClass.matches("Barbarian|Bard|Fighter|Paladin|Sorcerer|Rogue|Warlock")) {
                    strIntimidationChecked = strIntimidation.isChecked();
                } else {
                    strIntimidation.setChecked(false);
                    checkText = "Strength Intimidation";
                    toast = true;
                }
                break;
            case R.id.chkAcrobatics:
                if (myClass.matches("Bard|Fighter|Monk|Rogue")) {
                    acrobaticsChecked = acrobatics.isChecked();
                } else {
                    acrobatics.setChecked(false);
                    checkText = "Acrobatics";
                    toast = true;
                }
                break;
            case R.id.chkStealth:
                if (myClass.matches("Bard|Ranger|Monk|Rogue")) {
                    stealthChecked = stealth.isChecked();
                } else {
                    stealth.setChecked(false);
                    checkText = "Stealth";
                    toast = true;
                }
                break;
            case R.id.chkSleightOfHand:
                if (myClass.matches("Bard|Rogue")) {
                    sleightOfHandChecked = sleightOfHand.isChecked();
                } else {
                    sleightOfHand.setChecked(false);
                    checkText = "Sleight of Hand";
                    toast = true;
                }
                break;
            case R.id.chkArcana:
                if (myClass.matches("Bard|Druid|Sorcerer|Warlock|Wizard")) {
                    arcanaChecked = arcana.isChecked();
                } else {
                    arcana.setChecked(false);
                    checkText = "Arcana";
                    toast = true;
                }
                break;
            case R.id.chkHistory:
                if (myClass.matches("Bard|Cleric|Fighter|Monk|Warlock|Wizard")) {
                    historyChecked = history.isChecked();
                } else {
                    history.setChecked(false);
                    checkText = "History";
                    toast = true;
                }
                break;
            case R.id.chkNature:
                if (myClass.matches("Bard|Barbarian|Druid|Ranger|Warlock")) {
                    natureChecked = nature.isChecked();
                } else {
                    nature.setChecked(false);
                    checkText = "Nature";
                    toast = true;
                }
                break;
            case R.id.chkReligion:
                if (myClass.matches("Bard|Cleric|Druid|Monk|Paladin|Sorcerer|Warlock|Wizard")) {
                    religionChecked = religion.isChecked();
                } else {
                    religion.setChecked(false);
                    checkText = "Religion";
                    toast = true;
                }
                break;
            case R.id.chkInvestigation:
                if (myClass.matches("Bard|Ranger|Rogue|Warlock|Wizard")) {
                    investigationChecked = investigation.isChecked();
                } else {
                    investigation.setChecked(false);
                    checkText = "Investigation";
                    toast = true;
                }
                break;
            case R.id.chkInsight:
                if (myClass.matches("Bard|Cleric|Druid|Fighter|Monk|Paladin|Ranger|Sorcerer|Rogue|Wizard")) {
                    insightChecked = insight.isChecked();
                } else {
                    insight.setChecked(false);
                    checkText = "Insight";
                    toast = true;
                }
                break;
            case R.id.chkMedicine:
                if (myClass.matches("Bard|Cleric|Druid|Paladin|Wizard")) {
                    medicineChecked = medicine.isChecked();
                } else {
                    medicine.setChecked(false);
                    checkText = "Medicine";
                    toast = true;
                }
                break;
            case R.id.chkPerception:
                if (myClass.matches("Barbarian|Bard|Druid|Fighter|Ranger|Rogue")) {
                    perceptionChecked = perception.isChecked();
                } else {
                    perception.setChecked(false);
                    checkText = "Perception";
                    toast = true;
                }
                break;
            case R.id.chkSurvival:
                if (myClass.matches("Barbarian|Bard|Druid|Fighter|Ranger")) {
                    survivalChecked = survival.isChecked();
                } else {
                    survival.setChecked(false);
                    checkText = "Survival";
                    toast = true;
                }
                break;
            case R.id.chkAnimalHandling:
                if (myClass.matches("Barbarian|Bard|Druid|Fighter|Ranger")) {
                    animalHandlingChecked = animalHandling.isChecked();
                } else {
                    animalHandling.setChecked(false);
                    checkText = "Animal Handling";
                    toast = true;
                }
                break;
            case R.id.chkDeception:
                if (myClass.matches("Bard|Sorcerer|Warlock|Rogue")) {
                    deceptionChecked = deception.isChecked();
                } else {
                    deception.setChecked(false);
                    checkText = "Deception";
                    toast = true;
                }
                break;
            case R.id.chkCharismaIntimidation:
                if (myClass.matches("Barbarian|Bard|Fighter|Paladin|Sorcerer|Rogue|Warlock")) {
                    charIntimidationChecked = charIntimidation.isChecked();
                } else {
                    charIntimidation.setChecked(false);
                    checkText = "Charisma Intimidation";
                    toast = true;
                }
                break;
            case R.id.chkPerformance:
                if (myClass.matches("Bard|Rogue")) {
                    performanceChecked = performance.isChecked();
                } else {
                    performance.setChecked(false);
                    checkText = "Performance";
                    toast = true;
                }
                break;
            case R.id.chkPersuasion:
                if (myClass.matches("Bard|Cleric|Paladin|Sorcerer|Rogue")) {
                    persuasionChecked = persuasion.isChecked();
                } else {
                    persuasion.setChecked(false);
                    checkText = "Persuasion";
                    toast = true;
                }
                break;
        }

        if (toast) {
            Toast message = Toast.makeText(this, checkText + " is not available for " + myClass, Toast.LENGTH_LONG);
            message.show();
        }
        saveStates();
        setStates();
    }

    public void saveStates() {

        myCharacter.setAthletics(athleticsChecked);
        myCharacter.setStrIntimidation(strIntimidationChecked);
        myCharacter.setAcrobatics(acrobaticsChecked);
        myCharacter.setStealth(stealthChecked);
        myCharacter.setSleightOfHand(sleightOfHandChecked);
        myCharacter.setArcana(arcanaChecked);
        myCharacter.setHistory(historyChecked);
        myCharacter.setNature(natureChecked);
        myCharacter.setReligion(religionChecked);
        myCharacter.setInvestigation(investigationChecked);
        myCharacter.setInsight(insightChecked);
        myCharacter.setMedicine(medicineChecked);
        myCharacter.setPerceptionChecked(perceptionChecked);
        myCharacter.setSurvival(survivalChecked);
        myCharacter.setAnimalHandling(animalHandlingChecked);
        myCharacter.setDeception(deceptionChecked);
        myCharacter.setCharIntimidation(charIntimidationChecked);
        myCharacter.setPerformance(performanceChecked);
        myCharacter.setPersuasion(persuasionChecked);

        updateCharacter(MainActivity.characterDB, myCharacter);


    }

    public void getValues() {
        proficiency = myCharacter.getProficiency();
        strengthMod = myCharacter.getStrengthMod();
        dexMod = myCharacter.getDexterityMod();
        wisdomMod = myCharacter.getConstitutionMod();
        intellectMod = myCharacter.getIntellectMod();
        charismaMod = myCharacter.getCharismaMod();
    }

    public void btnProfileClickHandler(View v) {
        int counter = 0;
        int missing = 0;

        for (int i = 0; i < boolArray.length; i++) {
            if (boolArray[i]) {
                counter++;
            }
        }
        String myClass = myCharacter.getCharacterClass();
        if (myClass.equals("Rogue") && counter != 4) {
            if (counter > 4) {
                Toast toast = Toast.makeText(this, "PLEASE SELECT ONLY FOUR SKILLS", Toast.LENGTH_LONG);
                toast.show();
            } else if (counter < 4 && counter > 1) {
                missing = 4 - counter;
                Toast toast = Toast.makeText(this, "PLEASE SELECT " + missing
                        + " MORE SKILLS", Toast.LENGTH_LONG);
                toast.show();
            } else if (missing == 1) {
                Toast toast = Toast.makeText(this, "PLEASE SELECT " + missing
                        + " MORE SKILL", Toast.LENGTH_LONG);
                toast.show();
            }
        } else if (myClass.equals("Bard") && counter != 3) {
            if (counter > 3) {
                Toast toast = Toast.makeText(this, "PLEASE SELECT ONLY THREE SKILLS",
                        Toast.LENGTH_LONG);
                toast.show();
            } else if (counter == 1) {
                Toast toast = Toast.makeText(this, "PLEASE SELECT " + missing
                        + " MORE SKILL", Toast.LENGTH_LONG);
                toast.show();
            } else {
                Toast toast = Toast.makeText(this, "PLEASE SELECT " + missing
                        + " MORE SKILLS", Toast.LENGTH_LONG);
                toast.show();
            }
        } else if (!myClass.equals("Rogue") && !myClass.equals("Bard") && counter != 2) {
            if (counter > 2) {
                Toast toast = Toast.makeText(this, "PLEASE SELECT ONLY TWO SKILLS",
                        Toast.LENGTH_LONG);
                toast.show();
            } else if (counter == 1) {
                Toast toast = Toast.makeText(this, "PLEASE SELECT " + missing
                        + " MORE SKILL", Toast.LENGTH_LONG);
                toast.show();
            } else {
                Toast toast = Toast.makeText(this, "PLEASE SELECT " + missing
                        + " MORE SKILLS", Toast.LENGTH_LONG);
                toast.show();
            }
        } else {
            makeUnclickable();
            Intent intent = new Intent(this, ProfileActivity.class);
            startActivity(intent);
        }

    }

    public void makeUnclickable() {

        for (int i = 0; i < checkArray.length; i++) {
            checkArray[i].setClickable(false);
        }
    }

    public void makeClickable() {

        for (int i = 0; i < checkArray.length; i++) {
            checkArray[i].setClickable(true);
        }
    }

}
