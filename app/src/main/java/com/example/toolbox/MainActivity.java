package com.example.toolbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void order(View v){
        EditText myName = (EditText) findViewById(R.id.nameEdit);
        EditText myEmail = (EditText) findViewById(R.id.emailEdit);

        String myNameStr = myName.getText().toString();
        String myEmailStr = myEmail.getText().toString();

        Intent intent = new Intent(this, InfoActivity.class);

        //intent.putExtra(InfoActivity.MY_NAME, myNameStr);
        //intent.putExtra(InfoActivity.MY_NOUN, myNounStr);

        startActivity(intent);


    }

}
