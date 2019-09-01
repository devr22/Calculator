package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textView1;
    private TextView textView2;
    private TextView textView3;

    private Button[] buttons = new Button[10];

    private Button btnadd;
    private Button btnsub;
    private Button btnmul;
    private Button btndivide;
    private Button btnpercent;
    private Button btndot;
    private Button btnbackspace;
    private Button btnreset;
    private Button btnequal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //connecting with the frontend

        textView1 = findViewById(R.id.textview_1);
        textView2 = findViewById(R.id.textview_2);
        textView3 = findViewById(R.id.textview_3);

        btnreset = findViewById(R.id.btnreset);
        btnbackspace = findViewById(R.id.btnbackspace);
        btnequal = findViewById(R.id.btnequal);
        btndot = findViewById(R.id.btndot);
        btnpercent = findViewById(R.id.btnpercent);
        btndivide = findViewById(R.id.btndivide);
        btnmul = findViewById(R.id.btnmul);
        btnsub = findViewById(R.id.btnsub);
        btnadd = findViewById(R.id.btnadd);

        for(int i = 0; i<=9; i++){
            String buttonId = "btn"+i;
            int resId = getResources().getIdentifier(buttonId,"id",getPackageName());
            buttons[i] = findViewById(resId);

            buttons[i].setOnClickListener(this);
        }

    }

    @Override
    public void onClick(View view) {

        String text = (String) textView2.getText();
        String buttonText = ((Button)view).getText().toString();


        if(text == "0"){
            textView2.setText(buttonText);
        }
        else{
            textView2.setText(text + buttonText);
        }

    }
}
