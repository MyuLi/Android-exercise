package com.example.mainactivity;

import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btn1 = findViewById(R.id.bnt1);
        final TextView tv1 = findViewById(R.id.tv1);
        final TextView tv2 = findViewById(R.id.tv2);
        final ImageView imageView = findViewById(R.id.imageView);
        final RadioGroup radioGroup = findViewById(R.id.radioGroup);

        tv2.setText(null);
        Log.d("MainActivity","app loaded");

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radioButton1:
                    {
                        imageView.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.timg));
                        break;
                    }
                    case R.id.radioButton2:
                    {
                        imageView.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.panda));
                        break;
                     }
                }
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            private int counter=0;
            public void onClick(View v) {
                counter++;
                tv1.setTextColor(Color.parseColor("#566270"));
                int size = (int) tv1.getTextSize() + 5;
                tv1.setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
                Log.d("MainActivity","button clicked");
                tv1.setText("meow");
                if(counter == 0){
                    tv2.setText("猫开始叫了");
                }
                else {
                    btn1.setText("louder");
                    tv2.setText("更大声了");
                }
            }
        });
    }
}
