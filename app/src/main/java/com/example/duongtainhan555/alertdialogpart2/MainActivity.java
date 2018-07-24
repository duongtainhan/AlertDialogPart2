package com.example.duongtainhan555.alertdialogpart2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lvName;
    ArrayList<String> arrayName;
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Anh xa
        lvName = findViewById(R.id.lvName);
        arrayName = new ArrayList<>();
        AddArrayName();
        //
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayName);
        lvName.setAdapter(adapter);
    }

    private void AddArrayName(){
        arrayName.add("Android");
        arrayName.add("IOS");
        arrayName.add("PHP");
        arrayName.add("ASP.NET");
        arrayName.add("UNITY 3D");
        arrayName.add("COCOS2DX");
        arrayName.add("NODEJS");
    }
}
