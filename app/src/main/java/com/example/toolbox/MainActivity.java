package com.example.toolbox;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void order(View v){

        EditText myName = (EditText) findViewById(R.id.nameEdit);
        EditText myEmail = (EditText) findViewById(R.id.emailEdit);
        RadioButton r1 = (RadioButton) findViewById(R.id.deliveryCheck);
        RadioButton r2 = (RadioButton) findViewById(R.id.pickCheck);

        String myNameStr = myName.getText().toString();
        String myEmailStr = myEmail.getText().toString();
        String myR1 = r1.getText().toString();
        String myR2 = r2.getText().toString();

        if(!myNameStr.equalsIgnoreCase("") && !myEmailStr.equalsIgnoreCase("")){
            try{

                Intent intent = new Intent(this, InfoActivity.class);

                intent.putExtra(FinalActivity.MY_NAME, myNameStr);
                intent.putExtra(FinalActivity.MY_EMAIL, myEmailStr);
                intent.putExtra(FinalActivity.MY_R1, myR1);
                intent.putExtra(FinalActivity.MY_R2, myR2);

                startActivity(intent);
            }

            catch (Exception e){
                Toast.makeText(getApplicationContext(), "Please fill in the required fields", Toast.LENGTH_LONG).show();
            }
        }

    }

}
