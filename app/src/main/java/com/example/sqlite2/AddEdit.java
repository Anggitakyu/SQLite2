package com.example.sqlite2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sqlite2.MainActivity;
import com.example.sqlite2.R;
import com.example.sqlite2.helper.DbHelper;

public class AddEdit extends AppCompatActivity {

    EditText Id, Name, Address;
    Button btnSubmit, btnCancel;
    DbHelper SQLite = new DbHelper(this);
    String id, name, address;

    public void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_add_edit);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Id = (EditText) findViewById(R.id.txt_id);
        Name = (EditText) findViewById(R.id.txt_nama);
        Address = (EditText) findViewById(R.id.txt_alamat);
        btnSubmit = (Button) findViewById(R.id.btn_submit);
        btnCancel = (Button) findViewById(R.id.btn_cancel);

        id = getIntent().getStringExtra(MainActivity.TAG_ID);
        name = getIntent().getStringExtra(MainActivity.TAG_NAME);
        address = getIntent().getStringExtra(MainActivity.TAG_ADDRESS);

        if(id==null || id==""){
            setTitle("Add Data");
        }else {
            setTitle("Edit Data");
            Id.setText(id);
            Name.setText(name);
            Address.setText(address);
        }

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(Id.getText().toString().equals("")){
                        save();
                    }else {
                        edit();
                    }
                }catch (Exception e){
                    Log.e("Submit", e.toString());

                }
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                blank();
                finish();
            }
        });

    }

    @Override
    public void onBackPressed(){
        finish();
    }

    public void blank(){
        Name.requestFocus();
        Name.setText("");
        Id.setText("");
        Address.setText("");
    }

    private void save(){
        SQLite.insert(Name.getText().toString().trim(), Address.getText().toString().trim());
        blank();
        finish();
    }

    private void edit(){
        SQLite.update(Integer.parseInt(Id.getText().toString().trim()) , Name.getText().toString().trim(), Address.getText().toString().trim());
        blank();
        finish();

    }
}