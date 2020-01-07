package com.example.sharedpreference1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    EditText editText;
    Button button1,button2;
    Switch switch1;
    public static final String SHARED_PREFERENCE = "sharedpreference";
    public static final String TEXT = "text";
    public static final String SWITCH1 = "switch1";
    private String text;
    private  boolean switchOnOff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textview);
        editText = findViewById(R.id.edittext);
        button1 = findViewById(R.id.apply);
        switch1 = findViewById(R.id.switch1);
        button2 = findViewById(R.id.save);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(editText.getText().toString());
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });
        loadData();
        updateView();
    }
    public void saveData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCE,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(TEXT,textView.getText().toString());
        editor.putBoolean(SWITCH1,switch1.isChecked());
        editor.apply();
        Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show();
    }
    public void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCE,MODE_PRIVATE);
        text = sharedPreferences.getString(TEXT," ");
        switchOnOff = sharedPreferences.getBoolean(SWITCH1,false);
    }
    public void updateView(){
        textView.setText(text);
        switch1.setChecked(switchOnOff);
    }
}
