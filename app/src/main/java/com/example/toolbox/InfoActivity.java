package com.example.toolbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {

    public static final String MY_Q = "name";
    public static final String MY_F = "noun";
    public static final String MY_R = "r1";
    public static final String MY_RR = "r2";
    public static double total = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.page2);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

    }

    public void itemClick(View v){
        CheckBox checkBoxT = (CheckBox)findViewById(R.id.checkBoxT);
        CheckBox checkBoxP = (CheckBox)findViewById(R.id.checkBoxP);
        CheckBox checkBoxB = (CheckBox)findViewById(R.id.checkBoxB);
        CheckBox checkBoxF = (CheckBox)findViewById(R.id.checkBoxF);
        CheckBox checkBoxPO = (CheckBox)findViewById(R.id.checkBoxPO);
        CheckBox checkBoxV = (CheckBox)findViewById(R.id.checkBoxV);
        CheckBox checkBoxFR = (CheckBox)findViewById(R.id.checkBoxFR);

        if(checkBoxT.isChecked()){
            total += Double.parseDouble(getString(R.string.tendies));
        }

        if(checkBoxP.isChecked()){
            total += Double.parseDouble(getString(R.string.parm));
        }

        if(checkBoxB.isChecked()){
            total += Double.parseDouble(getString(R.string.burger));
        }

        if(checkBoxF.isChecked()){
            total += Double.parseDouble(getString(R.string.filet));
        }

        if(checkBoxPO.isChecked()){
            total += Double.parseDouble(getString(R.string.potato));
        }

        if(checkBoxV.isChecked()){
            total += Double.parseDouble(getString(R.string.veggies));
        }

        if(checkBoxFR.isChecked()){
            total += Double.parseDouble(getString(R.string.fries));
        }

    }

    public static double returnP(){
        return total;
    }

    public void go(View v){

        Intent intent1 = getIntent();
        String myQ = intent1.getStringExtra(MY_Q);
        String myF = intent1.getStringExtra(MY_F);
        String myR1 = intent1.getStringExtra(MY_R);
        String myR2 = intent1.getStringExtra(MY_RR);

        Intent intent = new Intent(this, FinalActivity.class);

        intent.putExtra(FinalActivity.MY_NAME, myQ);
        intent.putExtra(FinalActivity.MY_EMAIL, myF);
        intent.putExtra(FinalActivity.MY_R1, myR1);
        intent.putExtra(FinalActivity.MY_R2, myR2);

        startActivity(intent);

    }
}
