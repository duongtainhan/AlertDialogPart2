package com.example.duongtainhan555.alertdialogpart2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

        lvName.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                XacNhanXoa(i);
                return false;
            }
        });
    }

    private void AddArrayName(){
        arrayName.add("Android");
        arrayName.add("IOS");
        arrayName.add("PHP");
        arrayName.add("ASP.NET");
        arrayName.add("UNITY 3D");
        arrayName.add("COCOS2DX");
        arrayName.add("NODE JS");
    }

    private void XacNhanXoa(final int pos)
    {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Notification !!!");
        alertDialog.setIcon(R.mipmap.ic_launcher);
        alertDialog.setMessage("Do you want to delete this subject?");
        alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                arrayName.remove(pos);
                adapter.notifyDataSetChanged();
            }
        });
        alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alertDialog.setNeutralButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alertDialog.show();
    }
}
