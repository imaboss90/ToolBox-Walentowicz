package com.example.toolbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.IDNA;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;

import java.text.DecimalFormat;

public class FinalActivity extends AppCompatActivity {

    DecimalFormat df = new DecimalFormat("$#,##0.00");

    public static final String MY_NAME = "name";
    public static final String MY_EMAIL = "noun";
    public static final String MY_R1= "r1";
    public static final String MY_R2 = "r2";
    double price = InfoActivity.returnP();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        if (MY_R1.equalsIgnoreCase("delivery check")){

            Intent intent = getIntent();
            String myName = intent.getStringExtra(MY_NAME);
            String myEmail = intent.getStringExtra(MY_EMAIL);

            String strToDisplay = "Thank you " + myName + "! Your order confirmation will be sent to "
                    + myEmail + ". A notification will be sent when delivery has begun.";

            TextView str = (TextView) findViewById(R.id.nameConfirm);
            str.setText(strToDisplay);

            Switch s1 = (Switch) findViewById(R.id.switch1);
            final ImageView image = (ImageView)findViewById(R.id.img);
            Boolean switchState = s1.isChecked();

            final TextView p = (TextView)findViewById(R.id.price);
            p.setText("Total price: " + df.format(price));

            s1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    image.setImageResource(R.drawable.hape);
                    price+= 1.0;
                    p.setText("Total price: " + df.format(price));
                }
            });
        }

        else{
            Intent intent = getIntent();
            String myName = intent.getStringExtra(MY_NAME);
            String myEmail = intent.getStringExtra(MY_EMAIL);

            String strToDisplay = "Thank you " + myName + "! Your order confirmation will be sent to "
                    + myEmail + ". A notification will be sent when pick-up is ready.";

            Switch s1 = (Switch) findViewById(R.id.switch1);
            final ImageView image = (ImageView)findViewById(R.id.img);
            Boolean switchState = s1.isChecked();

            TextView str = (TextView) findViewById(R.id.nameConfirm);
            str.setText(strToDisplay);

            final TextView p = (TextView)findViewById(R.id.price);
            p.setText("Total price: " + df.format(price));

            s1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    image.setImageResource(R.drawable.hape);
                    price+= 1.0;
                    p.setText("Total price: " + df.format(price));
                }
            });
        }


    }
}
