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

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addition();
            }
        });

        btnsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                subtraction();
            }
        });

        btnmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                multiplication();
            }
        });

        btndivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                division();
            }
        });

        btnequal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answer();
            }
        });

    }

    //On pressing number
    @Override
    public void onClick(View view) {

        String text = textView2.getText().toString();
        String buttontext = ((Button)view).getText().toString();


        if(text.isEmpty()){
            textView2.setText(buttontext);
            textView1.setText(buttontext);
        }
        else{
            textView2.setText(textView2.getText()+buttontext);

            char operator = text.charAt(0);

            switch (operator){
                case '+':
                    add();
                    break;
                case '-':
                    sub();
                    break;
                case '*':
                    mul();
                    break;
                case '/':
                    divide();
                    break;
            }
        }

    }

    private void addition(){

        String text1 = textView3.getText().toString();
        String text2 = textView2.getText().toString();
        String buttontext = btnadd.getText().toString();

        textView3.setText(textView3.getText()+text2);
        textView2.setText(buttontext);

    }

    private void subtraction(){

        String text1 = textView3.getText().toString();
        String text2 = textView2.getText().toString();
        String buttontext = btnsub.getText().toString();

        textView3.setText(textView3.getText()+text2);
        textView2.setText(buttontext);

    }

    private void multiplication(){

        String text1 = textView3.getText().toString();
        String text2 = textView2.getText().toString();
        String buttontext = btnmul.getText().toString();

        textView3.setText(textView3.getText()+text2);
        textView2.setText(buttontext);

    }

    private void division(){

        String text1 = textView3.getText().toString();
        String text2 = textView2.getText().toString();
        String buttontext = btndivide.getText().toString();

        textView3.setText(textView3.getText()+text2);
        textView2.setText(buttontext);

    }

    private void add(){
        String text = textView2.getText().toString();
        int textlength = text.length();

        Float val1 = Float.parseFloat(textView1.getText().toString());
        Float val2 = Float.parseFloat(text.substring(1,textlength-1));

        Float sum = val1 + val2;

        textView1.setText(sum.toString());
    }

    private void sub(){
        String text = textView2.getText().toString();
        int textlength = text.length();

        Float val1 = Float.parseFloat(textView1.getText().toString());
        Float val2 = Float.parseFloat(text.substring(1,textlength-1));

        Float difference = val1 - val2;

        textView1.setText(difference.toString());
    }

    private void mul(){
        String text = textView2.getText().toString();
        int textlength = text.length();

        Float val1 = Float.parseFloat(textView1.getText().toString());
        Float val2 = Float.parseFloat(text.substring(1,textlength-1));

        Float product = val1 * val2;

        textView1.setText(product.toString());
    }

    private void divide(){
        String text = textView2.getText().toString();
        int textlength = text.length();

        Float val1 = Float.parseFloat(textView1.getText().toString());
        Float val2 = Float.parseFloat(text.substring(1,textlength-1));

        Float div = val1 / val2;

        textView1.setText(div.toString());
    }

    private void answer(){
        String text = textView2.getText().toString();

        textView3.setText(textView3.getText()+text);
        textView2.setText(textView1.getText().toString());
        textView1.setText("");
    }

}
