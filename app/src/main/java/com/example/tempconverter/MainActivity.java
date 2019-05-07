package com.example.tempconverter;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity implements TextView.OnEditorActionListener {
    private EditText fahrenheitEditText;
    private TextView celsiusTextView;
    // define instance variables that should be saved
    private String fahrenheitDegree = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fahrenheitEditText = findViewById(R.id.fahrenheitEditText);
        celsiusTextView = findViewById(R.id.celsiusTextView);

        //set listener
        fahrenheitEditText.setOnEditorActionListener(this);

    }

    public void calculateCelsius(){
        fahrenheitDegree =fahrenheitEditText.getText().toString();
        float degree;

        if (fahrenheitDegree.equals("")){
            degree = 0;
        }
        else{
            degree =Float.parseFloat(fahrenheitDegree);

        }

        //calculates celsius
        float celsiusDegree = (degree - 32) * 5/9;

        celsiusTextView.setText(String.valueOf(celsiusDegree));
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_DONE ||
                actionId == EditorInfo.IME_ACTION_UNSPECIFIED) {
            calculateCelsius();
        }
        return false;
    }
}
