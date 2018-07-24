package com.example.duongtainhan555.alertdialogpart2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lvName;
    private Button btnAdd;
    private EditText edItem;
    ArrayList<String> arrayName;
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Anh xa
        lvName = findViewById(R.id.lvName);
        arrayName = new ArrayList<>();
        //Anh xa (advanced)
        btnAdd = findViewById(R.id.btnAdd);
        edItem = findViewById(R.id.edItem);
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
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edItem.getText().toString().equals(""))
                {
                    Toast.makeText(MainActivity.this,"NO DATA IN EDIT TEXT",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    arrayName.add(edItem.getText().toString());
                    adapter.notifyDataSetChanged();
                    edItem.setText("");
                }
            }
        });
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
