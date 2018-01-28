package com.ucfknights.dylan_oszust.dungeonsanddragons;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by dyans on 11/22/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    //  INITIALIZE VARIABLES
    public static final String DB_NAME = "PlayerTools.SQLite";
    public static final int DB_VERSION = 1;

    //  ITEMS TABLE VALUES
    public static String ITEMS_TABLE = "ItemsTable";
    public static String ITEM_ID = "Item_ID";
    public static String ITEM_NAME = "Item_Name";
    public static String ITEM_AMOUNT = "Item_Amount";

    //  CHARACTER TABLE HEADERS
    public static String CHARACTER_TABLE = "CharacterTable";
    public static String CHARACTER_ID = "Character_ID";
    public static String CHARACTER_NAME = "Character_Name";
    public static String RACE = "RACE";
    public static String CLASS = "CLASS";
    public static String ALIGNMENT = "ALIGNMENT";
    public static String GENDER = "GENDER";
    public static String STRENGTH = "STRENGTH";
    public static String DEXTERITY = "DEXTERITY";
    public static String CONSTITUTION = "CONSTITUTION";
    public static String INTELLECT = "INTELLECT";
    public static String WISDOM = "WISDOM";
    public static String CHARISMA = "CHARISMA";
    public static String LEVEL = "LEVEL";
    public static String ARMOR = "ARMOR";
    public static String INITIATIVE = "INITIATIVE";
    public static String SPEED = "SPEED";
    public static String INSPIRATION = "INSPIRATION";
    public static String PERCEPTION = "PERCEPTION";
    public static String PROFICIENCY = "PROFICIENCY";
    public static String STRENGTH_MOD = "STRENGTH_MOD";
    public static String DEXTERITY_MOD = "DEXTERITY_MOD";
    public static String CONSTITUTION_MOD = "CONSTITUTION_MOD";
    public static String INTELLECT_MOD = "INTELLECT_MOD";
    public static String WISDOM_MOD = "WISDOM_MOD";
    public static String CHARISMA_MOD = "CHARISMA_MOD";
    public static String STRENGTH_SAVE = "STRENGTH_SAVE";
    public static String DEXTERITY_SAVE = "DEXTERITY_SAVE";
    public static String CONSTITUTION_SAVE = "CONSTITUTION_SAVE";
    public static String INTELLECT_SAVE = "INTELLECT_SAVE";
    public static String WISDOM_SAVE = "WISDOM_SAVE";
    public static String CHARISMA_SAVE = "CHARISMA_SAVE";
    public static String REMAINING_HP = "REMAINING_HP";
    public static String TOTAL_HP = "TOTAL_HP";
    public static String ATHLETICS = "ATHLETICS";
    public static String STRENGTH_INTIMIDATION = "STRENGTH_INTIMIDATION";
    public static String ACROBATICS = "ACROBATICS";
    public static String STEALTH = "STEALTH";
    public static String SLEIGHT_OF_HAND = "SLEIGHT_OF_HAND";
    public static String ARCANA = "ARCANA";
    public static String HISTORY = "HISTORY";
    public static String NATURE = "NATURE";
    public static String RELIGION = "RELIGION";
    public static String INVESTIGATION = "INVESTIGATION";
    public static String INSIGHT = "INSIGHT";
    public static String MEDICINE = "MEDICINE";
    public static String PERCEPTION_CHECKED = "PERCEPTION_CHECKED";
    public static String SURVIVAL = "SURVIVAL";
    public static String ANIMAL_HANDLING = "ANIMAL_HANDLING";
    public static String DECEPTION = "DECEPTION";
    public static String CHARISMA_INTIMIDATION = "CHAR_INTIMIDATION";
    public static String PERFORMANCE = "PERFORMANCE";
    public static String PERSUASION = "PERSUASION";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase database) {

//          Statement to create character table
        String sqlCharacterStatement = "create table " + CHARACTER_TABLE
                + " (" + CHARACTER_ID + " integer primary key not null,"
                + CHARACTER_NAME + " string,"
                + RACE + " string,"
                + CLASS + " string,"
                + ALIGNMENT + " string,"
                + GENDER + " string,"
                + STRENGTH + " int,"
                + DEXTERITY + " int,"
                + CONSTITUTION + " int,"
                + INTELLECT + " int,"
                + WISDOM + " int,"
                + CHARISMA + " int,"
                + LEVEL + " int,"
                + ARMOR + " int,"
                + INITIATIVE + " int,"
                + SPEED + " int,"
                + INSPIRATION + " int,"
                + PERCEPTION + " int,"
                + PROFICIENCY + " int,"
                + STRENGTH_MOD + " int,"
                + DEXTERITY_MOD + " int,"
                + CONSTITUTION_MOD + " int,"
                + INTELLECT_MOD + " int,"
                + WISDOM_MOD + " int,"
                + CHARISMA_MOD + " int,"
                + STRENGTH_SAVE + " int,"
                + DEXTERITY_SAVE + " int,"
                + CONSTITUTION_SAVE + " int,"
                + INTELLECT_SAVE + " int,"
                + WISDOM_SAVE + " int,"
                + CHARISMA_SAVE + " int,"
                + REMAINING_HP + " int,"
                + TOTAL_HP + " int,"
                + ATHLETICS + " int,"
                + STRENGTH_INTIMIDATION + " int,"
                + ACROBATICS + " int,"
                + STEALTH + " int,"
                + SLEIGHT_OF_HAND + " int,"
                + ARCANA + " int,"
                + HISTORY + " int,"
                + NATURE + " int,"
                + RELIGION + " int,"
                + INVESTIGATION + " int,"
                + INSIGHT + " int,"
                + MEDICINE + " int,"
                + PERCEPTION_CHECKED + " int,"
                + SURVIVAL + " int,"
                + ANIMAL_HANDLING + " int,"
                + DECEPTION + " int,"
                + CHARISMA_INTIMIDATION + " int,"
                + PERFORMANCE + " int,"
                + PERSUASION + " int"
                + ");";

//      statement to create Items_Table
        String sqlItemStatement = "create table " + ITEMS_TABLE
                + " (" + ITEM_ID + " integer primary key not null,"
                + ITEM_NAME + " string,"
                + ITEM_AMOUNT + " int"
                + ");";

        database.execSQL(sqlCharacterStatement);
        database.execSQL(sqlItemStatement);

    }

    //    Inserts character into table
    public static void insertCharacter(PlayerCharacter insertCharacter, SQLiteDatabase DB) {

        //gathers character information
        int CHARACTER_ID = 1;
        String CHARACTER_NAME = insertCharacter.getCharacterName();
        String RACE = insertCharacter.getRace();
        String CLASS = insertCharacter.getCharacterClass();
        String ALIGNMENT = insertCharacter.getAlignment();
        String GENDER = insertCharacter.getGender();
        int STRENGTH = insertCharacter.getStrength();
        int DEXTERITY = insertCharacter.getDexterity();
        int CONSTITUTION = insertCharacter.getConstitution();
        int INTELLECT = insertCharacter.getIntellect();
        int WISDOM = insertCharacter.getWisdom();
        int CHARISMA = insertCharacter.getCharisma();
        int LEVEL = insertCharacter.getLevel();
        int ARMOR = insertCharacter.getArmor();
        int INITIATIVE = insertCharacter.getInitiative();
        int SPEED = insertCharacter.getSpeed();
        int INSPIRATION = insertCharacter.getInspiration();
        int PERCEPTION = insertCharacter.getPerception();
        int PROFICIENCY = insertCharacter.getProficiency();
        int STRENGTH_MOD = insertCharacter.getStrengthMod();
        int DEXTERITY_MOD = insertCharacter.getDexterityMod();
        int CONSTITUTION_MOD = insertCharacter.getConstitutionMod();
        int INTELLECT_MOD = insertCharacter.getIntellectMod();
        int WISDOM_MOD = insertCharacter.getWisdomMod();
        int CHARISMA_MOD = insertCharacter.getCharismaMod();
        int STRENGTH_SAVE = insertCharacter.getStrengthSave();
        int DEXTERITY_SAVE = insertCharacter.getDexteritySave();
        int CONSTITUTION_SAVE = insertCharacter.getConstitutionSave();
        int INTELLECT_SAVE = insertCharacter.getIntellectSave();
        int WISDOM_SAVE = insertCharacter.getWisdomSave();
        int CHARISMA_SAVE = insertCharacter.getCharismaSave();
        int REMAINING_HP = insertCharacter.getRemainingHP();
        int TOTAL_HP = insertCharacter.getTotalHP();
        int ATHLETICS = insertCharacter.isAthletics() ? 1 : 0;
        int STRENGTH_INTIMIDATION = insertCharacter.isStrIntimidation() ? 1 : 0;
        int ACROBATICS = insertCharacter.isAcrobatics() ? 1 : 0;
        int STEALTH = insertCharacter.isStealth() ? 1 : 0;
        int SLEIGHT_OF_HAND = insertCharacter.isSleightOfHand() ? 1 : 0;
        int ARCANA = insertCharacter.isArcana() ? 1 : 0;
        int HISTORY = insertCharacter.isHistory() ? 1 : 0;
        int NATURE = insertCharacter.isNature() ? 1 : 0;
        int RELIGION = insertCharacter.isReligion() ? 1 : 0;
        int INVESTIGATION = insertCharacter.isInvestigation() ? 1 : 0;
        int INSIGHT = insertCharacter.isInsight() ? 1 : 0;
        int MEDICINE = insertCharacter.isMedicine() ? 1 : 0;
        int PERCEPTION_CHECKED = insertCharacter.isPerceptionChecked() ? 1 : 0;
        int SURVIVAL = insertCharacter.isSurvival() ? 1 : 0;
        int ANIMAL_HANDLING = insertCharacter.isAnimalHandling() ? 1 : 0;
        int DECEPTION = insertCharacter.isDeception() ? 1 : 0;
        int CHARISMA_INTIMIDATION = insertCharacter.isCharIntimidation() ? 1 : 0;
        int PERFORMANCE = insertCharacter.isPerformance() ? 1 : 0;
        int PERSUASION = insertCharacter.isPersuasion() ? 1 : 0;

//        Creates statement to insert
        String sqlStatement = "INSERT INTO " + CHARACTER_TABLE
                + " VALUES ( " + CHARACTER_ID + ", '"
                + CHARACTER_NAME + "', '"
                + RACE + "', '"
                + CLASS + "', '"
                + ALIGNMENT + "', '"
                + GENDER + "', "
                + STRENGTH + ", "
                + DEXTERITY + ", "
                + CONSTITUTION + ", "
                + INTELLECT + ", "
                + WISDOM + ", "
                + CHARISMA + ", "
                + LEVEL + ", "
                + ARMOR + ", "
                + INITIATIVE + ", "
                + SPEED + ", "
                + INSPIRATION + ", "
                + PERCEPTION + ", "
                + PROFICIENCY + ", "
                + STRENGTH_MOD + ", "
                + DEXTERITY_MOD + ", "
                + CONSTITUTION_MOD + ", "
                + INTELLECT_MOD + ", "
                + WISDOM_MOD + ", "
                + CHARISMA_MOD + ", "
                + STRENGTH_SAVE + ", "
                + DEXTERITY_SAVE + ", "
                + CONSTITUTION_SAVE + ", "
                + INTELLECT_SAVE + ", "
                + WISDOM_SAVE + ", "
                + CHARISMA_SAVE + ", "
                + REMAINING_HP + ", "
                + TOTAL_HP + ", "
                + ATHLETICS + ", "
                + STRENGTH_INTIMIDATION + ", "
                + ACROBATICS + ", "
                + STEALTH + ", "
                + SLEIGHT_OF_HAND + ", "
                + ARCANA + ", "
                + HISTORY + ", "
                + NATURE + ", "
                + RELIGION + ", "
                + INVESTIGATION + ", "
                + INSIGHT + ", "
                + MEDICINE + ", "
                + PERCEPTION_CHECKED + ", "
                + SURVIVAL + ", "
                + ANIMAL_HANDLING + ", "
                + DECEPTION + ", "
                + CHARISMA_INTIMIDATION + ", "
                + PERFORMANCE + ", "
                + PERSUASION
                + ");";

        DB.execSQL(sqlStatement);

    }

    //    Clears the table
    public static void clearCharacterData(SQLiteDatabase DB) {
        DB.delete(CHARACTER_TABLE, null, null);
    }

    public static void clearItemData(SQLiteDatabase DB) {
        DB.delete(ITEMS_TABLE, null, null);
    }

    //    Retrieves data from table
    public static PlayerCharacter retrieveCharacter(SQLiteDatabase DB) {
        Cursor characterCursor;

        characterCursor = DB.query(CHARACTER_TABLE, new String[]{CHARACTER_ID, CHARACTER_NAME, RACE,
                        CLASS, ALIGNMENT, GENDER, STRENGTH, DEXTERITY, CONSTITUTION, INTELLECT,
                        WISDOM, CHARISMA, LEVEL, ARMOR, INITIATIVE, SPEED, INSPIRATION, PERCEPTION,
                        PROFICIENCY, STRENGTH_MOD, DEXTERITY_MOD, CONSTITUTION_MOD, INTELLECT_MOD,
                        WISDOM_MOD, CHARISMA_MOD, STRENGTH_SAVE, DEXTERITY_SAVE, CONSTITUTION_SAVE,
                        INTELLECT_SAVE, WISDOM_SAVE, CHARISMA_SAVE, REMAINING_HP, TOTAL_HP, ATHLETICS,
                        STRENGTH_INTIMIDATION, ACROBATICS, STEALTH, SLEIGHT_OF_HAND, ARCANA, HISTORY,
                        NATURE, RELIGION, INVESTIGATION, INSIGHT, MEDICINE, PERCEPTION_CHECKED,
                        SURVIVAL, ANIMAL_HANDLING, DECEPTION, CHARISMA_INTIMIDATION, PERFORMANCE,
                        PERSUASION},
                null, null, null, null, null);
        characterCursor.moveToFirst();
        PlayerCharacter tempCharacter = null;


        if (!characterCursor.isAfterLast()) {

            String NAME = characterCursor.getString(1);
            String RACE = characterCursor.getString(2);
            String CHARACTER_CLASS = characterCursor.getString(3);
            String ALIGNMENT = characterCursor.getString(4);
            String GENDER = characterCursor.getString(5);
            int STRENGTH = Integer.parseInt(characterCursor.getString(6));
            int DEXTERITY = characterCursor.getInt(7);
            int CONSTITUTION = characterCursor.getInt(8);
            int INTELLECT = characterCursor.getInt(9);
            int WISDOM = characterCursor.getInt(10);
            int CHARISMA = characterCursor.getInt(11);
            int LEVEL = characterCursor.getInt(12);
            int ARMOR = characterCursor.getInt(13);
            int INITIATIVE = characterCursor.getInt(14);
            int SPEED = characterCursor.getInt(15);
            int INSPIRATION = characterCursor.getInt(16);
            int PERCEPTION = characterCursor.getInt(17);
            int PROFICIENCY = characterCursor.getInt(18);
            int STRENGTH_MOD = characterCursor.getInt(19);
            int DEXTERITY_MOD = characterCursor.getInt(20);
            int CONSTITUTION_MOD = characterCursor.getInt(21);
            int INTELLECT_MOD = characterCursor.getInt(22);
            int WISDOM_MOD = characterCursor.getInt(23);
            int CHARISMA_MOD = characterCursor.getInt(24);
            int STRENGTH_SAVE = characterCursor.getInt(25);
            int DEXTERITY_SAVE = characterCursor.getInt(26);
            int CONSTITUTION_SAVE = characterCursor.getInt(27);
            int INTELLECT_SAVE = characterCursor.getInt(28);
            int WISDOM_SAVE = characterCursor.getInt(29);
            int CHARISMA_SAVE = characterCursor.getInt(30);
            int REMAINING_HP = characterCursor.getInt(31);
            int TOTAL_HP = characterCursor.getInt(32);

            //      Using b = (i != 0) to translate int to boolean
            boolean ATHLETICS = (characterCursor.getInt(33) != 0);
            boolean STRENGTH_INTIMIDATION = (characterCursor.getInt(34) != 0);
            boolean ACROBATICS = (characterCursor.getInt(35) != 0);
            boolean STEALTH = (characterCursor.getInt(36) != 0);
            boolean SLEIGHT_OF_HAND = (characterCursor.getInt(37) != 0);
            boolean ARCANA = (characterCursor.getInt(38) != 0);
            boolean HISTORY = (characterCursor.getInt(39) != 0);
            boolean NATURE = (characterCursor.getInt(40) != 0);
            boolean RELIGION = (characterCursor.getInt(41) != 0);
            boolean INVESTIGATION = (characterCursor.getInt(42) != 0);
            boolean INSIGHT = (characterCursor.getInt(43) != 0);
            boolean MEDICINE = (characterCursor.getInt(44) != 0);
            boolean PERCEPTION_CHECKED = (characterCursor.getInt(45) != 0);
            boolean SURVIVAL = (characterCursor.getInt(46) != 0);
            boolean ANIMAL_HANDLING = (characterCursor.getInt(47) != 0);
            boolean DECEPTION = (characterCursor.getInt(48) != 0);
            boolean CHARISMA_INTIMIDATION = (characterCursor.getInt(49) != 0);
            boolean PERFORMANCE = (characterCursor.getInt(50) != 0);
            boolean PERSUASION = (characterCursor.getInt(51) != 0);

            //      Creates temp character to return to calling method
            tempCharacter = new PlayerCharacter(NAME, RACE, CHARACTER_CLASS, ALIGNMENT,
                    GENDER, STRENGTH, DEXTERITY, CONSTITUTION, INTELLECT, WISDOM, CHARISMA, LEVEL,
                    ARMOR, INITIATIVE, SPEED, INSPIRATION, PERCEPTION, PROFICIENCY, STRENGTH_MOD,
                    DEXTERITY_MOD, CONSTITUTION_MOD, INTELLECT_MOD, WISDOM_MOD, CHARISMA_MOD,
                    STRENGTH_SAVE, DEXTERITY_SAVE, CONSTITUTION_SAVE, INTELLECT_SAVE, WISDOM_SAVE,
                    CHARISMA_SAVE, REMAINING_HP, TOTAL_HP, ATHLETICS, STRENGTH_INTIMIDATION,
                    ACROBATICS, STEALTH, SLEIGHT_OF_HAND, ARCANA, HISTORY, NATURE, RELIGION,
                    INVESTIGATION, INSIGHT, MEDICINE, PERCEPTION_CHECKED, SURVIVAL, ANIMAL_HANDLING,
                    DECEPTION, CHARISMA_INTIMIDATION, PERFORMANCE, PERSUASION);

        }
        characterCursor.close();

//      Returns character to calling method
        return tempCharacter;
    }

    //  Replaces character in database with updated character
    public static void updateCharacter(SQLiteDatabase DB, PlayerCharacter myCharacter) {

//      Clears current data
        clearCharacterData(DB);

//      Inserts new data
        insertCharacter(myCharacter, DB);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


}
