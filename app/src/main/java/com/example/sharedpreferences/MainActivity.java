package com.example.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView returnValue = findViewById(R.id.isSaved);
        Button buttonS = findViewById(R.id.sendbutton);

        final SharedPreferences recupId = MainActivity.this.getSharedPreferences("com.example.sharedpreferences", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = recupId.edit();

        buttonS.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText putId =  findViewById(R.id.enterText);
                String remember = putId.getText().toString();
                editor.putString("savetheId", remember);
                editor.apply();
                returnValue.setText(recupId.getString("savetheId", "Empty"));


            }
        });


    }
}