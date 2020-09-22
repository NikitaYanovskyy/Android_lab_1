package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {
    private EditText inputt;
    private TextView outputt;
    private Button submitt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize views
        InitView();

        //onClick events
        submitt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                int[] naturalNumbers = new int[20];

                if(inputt.getText().toString().startsWith("0") || inputt.getText().toString().length() > 6){
                    //Toast creation
                    Context context = getApplicationContext();
                    CharSequence text = "Некоректне число";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast_unvalid = Toast.makeText(context, text, duration);
                    toast_unvalid.show();
                }else{
                    int inputToNumber = Integer.parseInt(inputt.getText().toString());
                    int arrayCounter = 0;

                    if(inputToNumber <= 0){
                        //Toast creation
                        Context context = getApplicationContext();
                        CharSequence text = "Число має бути більше або рівне 0";
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast_less_then_zero = Toast.makeText(context, text, duration);
                        toast_less_then_zero.show();
                    }else{
                        for (int i = 1; i < inputToNumber; i++){
                            if(inputToNumber % i == 0){
                                naturalNumbers[arrayCounter] = i;
                                arrayCounter++;
                            }
                        }

                        String outputString = "";
                        int whileCounter = 0;
                        while (naturalNumbers[whileCounter] != 0){
                            outputString += Integer.toString(naturalNumbers[whileCounter]) + "  ";
                            whileCounter++;
                        }

                        outputt.setText(outputString);
                    }
                }
            }
        });
    }

    private void InitView(){
        inputt = (EditText)findViewById(R.id.inputt);
        outputt = (TextView)findViewById(R.id.outputt);
        submitt = (Button)findViewById(R.id.submitt);
    }
}