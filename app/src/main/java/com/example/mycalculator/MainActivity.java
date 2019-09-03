package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Double num,ans;
    char operator;

    private TextView textView1;
    private TextView textView2;

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
                num = Double.parseDouble(textView1.getText().toString());
                textView1.setText("");
                textView2.setText(num + "+");
                operator = '+';
            }
        });

        btnsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num = Double.parseDouble(textView1.getText().toString());
                textView1.setText("");
                textView2.setText(num + "-");
                operator = '-';
            }
        });

        btnmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num = Double.parseDouble(textView1.getText().toString());
                textView1.setText("");
                textView2.setText(num + "*");
                operator = '*';
            }
        });

        btndivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num = Double.parseDouble(textView1.getText().toString());
                textView1.setText("");
                textView2.setText(num + "/");
                operator = '/';
            }
        });

        btnequal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arithmaticCalculation();
            }
        });

        btnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset();
            }
        });

        btnbackspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backspace();
            }
        });

        btnpercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                percentage();
            }
        });

        btndot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Buttontext = ((Button)view).getText().toString();

                textView1.setText(textView1.getText() + Buttontext);
            }
        });
    }


    @Override
    public void onClick(View view) {
        String Buttontext = ((Button)view).getText().toString();

        textView1.setText(textView1.getText() + Buttontext);
    }

    private void arithmaticCalculation(){

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
                div();
                break;
        }

    }

    private void add(){
        ans = num + Double.parseDouble(textView1.getText().toString());

        textView2.setText(textView2.getText() + textView1.getText().toString());
        textView1.setText(Double.toString(ans));
    }

    private void sub(){
        ans = num - Double.parseDouble(textView1.getText().toString());

        textView2.setText(textView2.getText() + textView1.getText().toString());
        textView1.setText(Double.toString(ans));
    }

    private void mul(){
        ans = num * Double.parseDouble(textView1.getText().toString());

        textView2.setText(textView2.getText() + textView1.getText().toString());
        textView1.setText(Double.toString(ans));
    }

    private void div(){
        ans = num / Double.parseDouble(textView1.getText().toString());

        textView2.setText(textView2.getText() + textView1.getText().toString());
        textView1.setText(Double.toString(ans));
    }

    private void reset(){
        textView1.setText("");
        textView2.setText("");
    }

    private void percentage(){
        if (textView1.equals("")){

        }
        else{
            num = Double.parseDouble(textView1.getText().toString());
            ans = num/100;

            textView1.setText(Double.toString(ans));
            textView2.setText("");
        }
    }

    private void backspace(){
        String text = textView1.getText().toString();
        int textlength = text.length();


        if (textlength == 2){
            String subtext = text.substring(0,1);
            textView1.setText(subtext);
        }
        else if (textlength == 1){
            textView1.setText("");
        }
        else if (textlength == 0){
            message();
        }
        else{
            String subtext = text.substring(0,textlength-1);
            textView1.setText(subtext);
        }
    }

    //alert message
    public void message(){
        Toast.makeText(this, "TextField is empty!" ,Toast.LENGTH_SHORT).show();
    }

}
