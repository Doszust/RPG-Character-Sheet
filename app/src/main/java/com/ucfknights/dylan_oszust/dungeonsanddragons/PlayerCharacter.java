package com.ucfknights.dylan_oszust.dungeonsanddragons;

/**
 * Created by dyans on 11/6/2017.
 *
 * This is the character class that saves all of the aspects of the players character from creation
 * The app only works with one character at a time and will erase a character if a new campaign
 * is started and a new character is created.
 */

public class PlayerCharacter {

    String characterName;
    String race;
    String characterClass;
    String alignment;
    String gender;
    int strength;
    int dexterity;
    int constitution;
    int intellect;
    int wisdom;
    int charisma;
    int level;
    int armor;
    int initiative;
    int speed;
    int inspiration;
    int perception;
    int proficiency;
    int strengthMod;
    int dexterityMod;
    int constitutionMod;
    int intellectMod;
    int wisdomMod;
    int charismaMod;
    int strengthSave;
    int dexteritySave;
    int constitutionSave;
    int intellectSave;
    int wisdomSave;
    int charismaSave;
    int remainingHP;
    int totalHP;
    boolean athletics;
    boolean strIntimidation;
    boolean acrobatics;
    boolean stealth;
    boolean sleightOfHand;
    boolean arcana;
    boolean history;
    boolean nature;
    boolean religion;
    boolean investigation;
    boolean insight;
    boolean medicine;
    boolean perceptionChecked;
    boolean survival;
    boolean animalHandling;
    boolean deception;
    boolean charIntimidation;
    boolean performance;
    boolean persuasion;

    //Constructor called from character creator
    public PlayerCharacter(String characterName, String race, String characterClass,
                           String alignment, String gender, int strength, int dexterity,
                           int constitution, int intellect, int wisdom, int charisma, int level,
                           int armor, int initiative, int speed, int inspiration, int perception,
                           int proficiency, int strengthMod, int dexterityMod, int constitutionMod,
                           int intellectMod, int wisdomMod, int charismaMod, int strengthSave,
                           int dexteritySave, int constitutionSave, int intellectSave,
                           int wisdomSave, int charismaSave, int remainingHP, int totalHP) {

        this.characterName = characterName;
        this.race = race;
        this.characterClass = characterClass;
        this.alignment = alignment;
        this.gender = gender;
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intellect = intellect;
        this.wisdom = wisdom;
        this.charisma = charisma;
        this.level = level;
        this.armor = armor;
        this.initiative = initiative;
        this.speed = speed;
        this.inspiration = inspiration;
        this.perception = perception;
        this.proficiency = proficiency;
        this.strengthMod = strengthMod;
        this.dexterityMod = dexterityMod;
        this.constitutionMod = constitutionMod;
        this.intellectMod = intellectMod;
        this.wisdomMod = wisdomMod;
        this.charismaMod = charismaMod;
        this.strengthSave = strengthSave;
        this.dexteritySave = dexteritySave;
        this.constitutionSave = constitutionSave;
        this.intellectSave = intellectSave;
        this.wisdomSave = wisdomSave;
        this.charismaSave = charismaSave;
        this.remainingHP = remainingHP;
        this.totalHP = totalHP;
        athletics = false;
        strIntimidation = false;
        acrobatics = false;
        stealth = false;
        sleightOfHand = false;
        arcana = false;
        history = false;
        nature = false;
        religion = false;
        investigation = false;
        insight = false;
        medicine = false;
        perceptionChecked = false;
        survival = false;
        animalHandling = false;
        deception = false;
        charIntimidation = false;
        performance = false;
        persuasion = false;


    }

    public PlayerCharacter(String characterName, String race, String characterClass,
                           String alignment, String gender, int strength, int dexterity,
                           int constitution, int intellect, int wisdom, int charisma, int level,
                           int armor, int initiative, int speed, int inspiration, int perception,
                           int proficiency, int strengthMod, int dexterityMod, int constitutionMod,
                           int intellectMod, int wisdomMod, int charismaMod, int strengthSave,
                           int dexteritySave, int constitutionSave, int intellectSave,
                           int wisdomSave, int charismaSave, int remainingHP, int totalHP,
                           boolean athletics, boolean strIntimidation, boolean acrobatics,
                           boolean stealth, boolean sleightOfHand, boolean arcana, boolean history,
                           boolean nature, boolean religion, boolean investigation, boolean insight,
                           boolean medicine, boolean perceptionChecked, boolean survival,
                           boolean animalHandling, boolean deception, boolean charIntimidation,
                           boolean performance, boolean persuasion) {
        this.characterName = characterName;
        this.race = race;
        this.characterClass = characterClass;
        this.alignment = alignment;
        this.gender = gender;
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intellect = intellect;
        this.wisdom = wisdom;
        this.charisma = charisma;
        this.level = level;
        this.armor = armor;
        this.initiative = initiative;
        this.speed = speed;
        this.inspiration = inspiration;
        this.perception = perception;
        this.proficiency = proficiency;
        this.strengthMod = strengthMod;
        this.dexterityMod = dexterityMod;
        this.constitutionMod = constitutionMod;
        this.intellectMod = intellectMod;
        this.wisdomMod = wisdomMod;
        this.charismaMod = charismaMod;
        this.strengthSave = strengthSave;
        this.dexteritySave = dexteritySave;
        this.constitutionSave = constitutionSave;
        this.intellectSave = intellectSave;
        this.wisdomSave = wisdomSave;
        this.charismaSave = charismaSave;
        this.remainingHP = remainingHP;
        this.totalHP = totalHP;
        this.athletics = athletics;
        this.strIntimidation = strIntimidation;
        this.acrobatics = acrobatics;
        this.stealth = stealth;
        this.sleightOfHand = sleightOfHand;
        this.arcana = arcana;
        this.history = history;
        this.nature = nature;
        this.religion = religion;
        this.investigation = investigation;
        this.insight = insight;
        this.medicine = medicine;
        this.perceptionChecked = perceptionChecked;
        this.survival = survival;
        this.animalHandling = animalHandling;
        this.deception = deception;
        this.charIntimidation = charIntimidation;
        this.performance = performance;
        this.persuasion = persuasion;
    }


    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }

    public String getAlignment() {
        return alignment;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getIntellect() {
        return intellect;
    }

    public void setIntellect(int intellect) {
        this.intellect = intellect;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getInspiration() {
        return inspiration;
    }

    public void setInspiration(int inspiration) {
        this.inspiration = inspiration;
    }

    public int getPerception() {
        return perception;
    }

    public void setPerception(int perception) {
        this.perception = perception;
    }

    public int getProficiency() {
        return proficiency;
    }

    public void setProficiency(int proficiency) {
        this.proficiency = proficiency;
    }

    public int getStrengthMod() {
        return strengthMod;
    }

    public void setStrengthMod(int strengthMod) {
        this.strengthMod = strengthMod;
    }

    public int getDexterityMod() {
        return dexterityMod;
    }

    public void setDexterityMod(int dexterityMod) {
        this.dexterityMod = dexterityMod;
    }

    public int getConstitutionMod() {
        return constitutionMod;
    }

    public void setConstitutionMod(int constitutionMod) {
        this.constitutionMod = constitutionMod;
    }

    public int getIntellectMod() {
        return intellectMod;
    }

    public void setIntellectMod(int intellectMod) {
        this.intellectMod = intellectMod;
    }

    public int getWisdomMod() {
        return wisdomMod;
    }

    public void setWisdomMod(int wisdomMod) {
        this.wisdomMod = wisdomMod;
    }

    public int getCharismaMod() {
        return charismaMod;
    }

    public void setCharismaMod(int charismaMod) {
        this.charismaMod = charismaMod;
    }

    public int getStrengthSave() {
        return strengthSave;
    }

    public void setStrengthSave(int strengthSave) {
        this.strengthSave = strengthSave;
    }

    public int getDexteritySave() {
        return dexteritySave;
    }

    public void setDexteritySave(int dexteritySave) {
        this.dexteritySave = dexteritySave;
    }

    public int getConstitutionSave() {
        return constitutionSave;
    }

    public void setConstitutionSave(int constitutionSave) {
        this.constitutionSave = constitutionSave;
    }

    public int getIntellectSave() {
        return intellectSave;
    }

    public void setIntellectSave(int intellectSave) {
        this.intellectSave = intellectSave;
    }

    public int getWisdomSave() {
        return wisdomSave;
    }

    public void setWisdomSave(int wisdomSave) {
        this.wisdomSave = wisdomSave;
    }

    public int getCharismaSave() {
        return charismaSave;
    }

    public void setCharismaSave(int charismaSave) {
        this.charismaSave = charismaSave;
    }

    public int getRemainingHP() {
        return remainingHP;
    }

    public void setRemainingHP(int remainingHP) {
        this.remainingHP = remainingHP;
    }

    public int getTotalHP() {
        return totalHP;
    }

    public void setTotalHP(int totalHP) {
        this.totalHP = totalHP;
    }

    public boolean isAthletics() {
        return athletics;
    }

    public void setAthletics(boolean athletics) {
        this.athletics = athletics;
    }

    public boolean isStrIntimidation() {
        return strIntimidation;
    }

    public void setStrIntimidation(boolean strIntimidation) {
        this.strIntimidation = strIntimidation;
    }

    public boolean isAcrobatics() {
        return acrobatics;
    }

    public void setAcrobatics(boolean acrobatics) {
        this.acrobatics = acrobatics;
    }

    public boolean isStealth() {
        return stealth;
    }

    public void setStealth(boolean stealth) {
        this.stealth = stealth;
    }

    public boolean isSleightOfHand() {
        return sleightOfHand;
    }

    public void setSleightOfHand(boolean sleightOfHand) {
        this.sleightOfHand = sleightOfHand;
    }

    public boolean isArcana() {
        return arcana;
    }

    public void setArcana(boolean arcana) {
        this.arcana = arcana;
    }

    public boolean isHistory() {
        return history;
    }

    public void setHistory(boolean history) {
        this.history = history;
    }

    public boolean isNature() {
        return nature;
    }

    public void setNature(boolean nature) {
        this.nature = nature;
    }

    public boolean isReligion() {
        return religion;
    }

    public void setReligion(boolean religion) {
        this.religion = religion;
    }

    public boolean isInvestigation() {
        return investigation;
    }

    public void setInvestigation(boolean investigation) {
        this.investigation = investigation;
    }

    public boolean isInsight() {
        return insight;
    }

    public void setInsight(boolean insight) {
        this.insight = insight;
    }

    public boolean isMedicine() {
        return medicine;
    }

    public void setMedicine(boolean medicine) {
        this.medicine = medicine;
    }

    public boolean isPerceptionChecked() {
        return perceptionChecked;
    }

    public void setPerceptionChecked(boolean perceptionChecked) {
        this.perceptionChecked = perceptionChecked;
    }

    public boolean isSurvival() {
        return survival;
    }

    public void setSurvival(boolean survival) {
        this.survival = survival;
    }

    public boolean isAnimalHandling() {
        return animalHandling;
    }

    public void setAnimalHandling(boolean animalHandling) {
        this.animalHandling = animalHandling;
    }

    public boolean isDeception() {
        return deception;
    }

    public void setDeception(boolean deception) {
        this.deception = deception;
    }

    public boolean isCharIntimidation() {
        return charIntimidation;
    }

    public void setCharIntimidation(boolean charIntimidation) {
        this.charIntimidation = charIntimidation;
    }

    public boolean isPerformance() {
        return performance;
    }

    public void setPerformance(boolean performance) {
        this.performance = performance;
    }

    public boolean isPersuasion() {
        return persuasion;
    }

    public void setPersuasion(boolean persuasion) {
        this.persuasion = persuasion;
    }
}
