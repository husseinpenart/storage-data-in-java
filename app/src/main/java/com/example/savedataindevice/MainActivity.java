package com.example.savedataindevice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);
        DisplaySaveText();


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enteredText = editText.getText().toString();
                DisplayAndSaveText(enteredText);
            }
        });
    }

    private void DisplaySaveText() {
//        read token or stored data
        SharedPreferences sharedPreferences = getSharedPreferences("Token" ,MODE_PRIVATE);
         String s1 =sharedPreferences.getString("name"," ");
         textView.setText(s1);
    }

    private void DisplayAndSaveText(String enteredText) {
        textView.setText(enteredText);
        SharedPreferences sharedPreferences = getSharedPreferences("Token", MODE_PRIVATE);
//        writing daata in share
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name", enteredText);
        editor.commit();

    }
}