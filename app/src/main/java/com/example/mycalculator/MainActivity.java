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

        btnpercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                percentage();
            }
        });

      /*  btndot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dotOperation();
            }
        });*/

    }

    //On pressing number
    @Override
    public void onClick(View view) {

        String text = textView2.getText().toString();
        String buttontext = ((Button)view).getText().toString();

        textView2.setText(text+buttontext);
      /*  if(text.isEmpty()){
            textView2.setText(buttontext);
            textView1.setText(buttontext);
        }
        else{
            textView2.setText(text+buttontext);

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
        }*/

    }

    private void addition(){

        //String text1 = textView3.getText().toString();
        String text2 = textView2.getText().toString();
        String buttontext = btnadd.getText().toString();

       // textView3.setText(text1+text2);
        textView2.setText(buttontext);

    }

    private void subtraction(){

        String text1 = textView3.getText().toString();
        String text2 = textView2.getText().toString();
        String buttontext = btnsub.getText().toString();

        textView3.setText(text1+text2);
        textView2.setText(buttontext);

    }

    private void multiplication(){

        String text1 = textView3.getText().toString();
        String text2 = textView2.getText().toString();
        String buttontext = btnmul.getText().toString();

        textView3.setText(text1+text2);
        textView2.setText(buttontext);

    }

    private void division(){

        String text1 = textView3.getText().toString();
        String text2 = textView2.getText().toString();
        String buttontext = btndivide.getText().toString();

        textView3.setText(text1+text2);
        textView2.setText(buttontext);

    }

    private void add(){
        String text = textView2.getText().toString();
        int textlength = text.length();

        Float val1 = Float.parseFloat(textView3.getText().toString());
        Float val2 = Float.parseFloat(text.substring(1,textlength-1));

        Float sum = val1 + val2;

        textView2.setText("="+sum.toString());
        textView3.setText(textView3.getText()+text);
    }

    private void sub(){
        String text = textView2.getText().toString();
        int textlength = text.length();

        Float val1 = Float.parseFloat(textView3.getText().toString());
        Float val2 = Float.parseFloat(text.substring(1,textlength-1));

        Float difference = val1 - val2;

        textView2.setText("="+difference.toString());
        textView3.setText(textView3.getText()+text);
    }

    private void mul(){
        String text = textView2.getText().toString();
        int textlength = text.length();

        Float val1 = Float.parseFloat(textView1.getText().toString());
        Float val2 = Float.parseFloat(text.substring(1,textlength-1));

        Float product = val1 * val2;

        textView2.setText("="+product.toString());
        textView3.setText(textView3.getText()+text);
    }

    private void divide(){
        String text = textView2.getText().toString();
        int textlength = text.length();

        Float val1 = Float.parseFloat(textView1.getText().toString());
        Float val2 = Float.parseFloat(text.substring(1,textlength-1));

        Float div = val1 / val2;

        textView2.setText("="+div.toString());
        textView3.setText(textView3.getText()+text);
    }

    private void answer(){
        String text = textView2.getText().toString();
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

       /* textView3.setText(textView3.getText()+text);
        textView2.setText(textView1.getText().toString());
        textView1.setText("");*/
    }

    private void percentage(){
        String text = textView2.getText().toString();

        if (text.contains("+")||text.contains("-")||text.contains("*")||text.contains("/")||text.isEmpty()){

        }
        else{
            Float val = Float.parseFloat(text);
            Float percent = val/100;
            textView2.setText(percent.toString());
        }
    }

  /* private void dotOperation(){
        String text = textView2.getText().toString();
        String buttontext = btndot.getText().toString();

        if (text.isEmpty()){
            textView2.setText("0.");
        }
        else if (text.equals("+") || text.equals("-") || text.equals("*") || text.equals("/")){
            textView2.setText(text+"0.");
        }
    }*/

}
