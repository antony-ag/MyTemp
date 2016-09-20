package com.example.weslley.mytemp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public double getEditValue(int id) {

        EditText e = (EditText) findViewById(id);
        return Double.parseDouble(e.getText().toString());

    }

    public void pegaTempo(View view){

        double tempo = getEditValue(R.id.tempo);
        Intent i = new Intent(this, Contador.class);
        i.putExtra("tempo", tempo);
        startActivity(i);

    }
}
