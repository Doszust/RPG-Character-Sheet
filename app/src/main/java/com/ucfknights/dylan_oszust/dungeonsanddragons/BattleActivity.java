package com.ucfknights.dylan_oszust.dungeonsanddragons;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.text.InputType;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.ucfknights.dylan_oszust.dungeonsanddragons.DatabaseHelper.updateCharacter;
import static com.ucfknights.dylan_oszust.dungeonsanddragons.ProfileActivity.myCharacter;

public class BattleActivity extends MainActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private int totalHealth;
    private int remainingHealth;
    TextView currentHP;
    TextView totalHP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);
        super.setUpNav();
        accessViews();
        getHealthStatus();
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

    public void accessViews() {
        currentHP = (TextView) findViewById(R.id.txtCurrentHealth);
        totalHP = (TextView) findViewById(R.id.txtTotalHealth);

    }

    public void getHealthStatus() {
        totalHealth = myCharacter.getTotalHP();
        remainingHealth = myCharacter.getRemainingHP();
        currentHP.setText(String.valueOf(remainingHealth));
        totalHP.setText(String.valueOf(totalHealth));

        if (remainingHealth <= (totalHealth / 3) * 2) {
            currentHP.setTextColor(Color.YELLOW);
        }
        if (remainingHealth <= totalHealth / 3) {
            currentHP.setTextColor(Color.RED);
        }
    }

    public void takeDamageOnClick(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("How much damage did you take?");
        final Toast emptyEntry = Toast.makeText(this, "No Damage Entered, Health Remains The Same!",
                Toast.LENGTH_LONG);


        final EditText input = new EditText(this);

        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        builder.setView(input);

        AlertDialog.Builder ok = builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                int m_damage;

                try {
                    m_damage = Integer.parseInt(input.getText().toString());
                } catch (Exception e) {
                    m_damage = 0;
                    emptyEntry.show();
                }

                int newHP = myCharacter.getRemainingHP() - m_damage;

                if (newHP <= 0) {
                    myCharacter.setRemainingHP(0);
                } else {
                    myCharacter.setRemainingHP(newHP);
                }

                updateCharacter(MainActivity.characterDB, myCharacter);

                Activity mAct = BattleActivity.this;
                mAct.recreate();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog alert = builder.create();
        alert.show();
    }

    public void increaseHealthOnClick(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("How much health did you gain?");


        final EditText input = new EditText(this);
        final Toast emptyEntry = Toast.makeText(this, "No HP Entered, Health Hasn't Increased!",
                Toast.LENGTH_LONG);

        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        builder.setView(input);

        AlertDialog.Builder ok = builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                int m_healing;
                int newHP;
                try {
                    m_healing = Integer.parseInt(input.getText().toString());

                } catch (Exception e) {
                    m_healing = 0;
                    emptyEntry.show();
                }
                newHP = myCharacter.getRemainingHP() + m_healing;

                if (newHP > totalHealth) {
                    myCharacter.setRemainingHP(totalHealth);
                } else {
                    myCharacter.setRemainingHP(newHP);
                }

                updateCharacter(MainActivity.characterDB, myCharacter);

                Activity mAct = BattleActivity.this;
                mAct.recreate();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog alert = builder.create();
        alert.show();
    }

    public void useItem(View v) {
        Intent intent = new Intent(this, ItemsActivity.class);
        intent.putExtra("Uniqid", "From_Battle");
        startActivity(intent);
    }


}
