package com.example.test_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button _btnInsert, _btnDelete, _btnUpdate;
    EditText _txtID, _txtName, _txtAddress, _txtPhone, _txtEmail;
    SQLiteOpenHelper openHelper;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _btnInsert=(Button) findViewById(R.id.btninsert);
        _btnDelete=(Button) findViewById(R.id.btnDit);
        _btnUpdate=(Button) findViewById(R.id.btnUpdate);
        _txtID=(EditText) findViewById(R.id.txtid);
        _txtName=(EditText) findViewById(R.id.txtName);
        _txtAddress=(EditText) findViewById(R.id.txtAddress);
        _txtPhone=(EditText) findViewById(R.id.txtPhone);
        _txtEmail=(EditText) findViewById(R.id.txtEmail);
        openHelper=new DatabaseHelper(this);
        _btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String name =_txtName.getText().toString();
                String address=_txtAddress.getText().toString();
                String phone =_txtPhone.getText().toString();
                String email=_txtEmail.getText().toString();
                sqLiteDatabase=openHelper.getWritableDatabase();
                insertData(name, address, phone, email);
                Toast.makeText(getApplicationContext(),"INSERT SUCCESSFULLY",Toast.LENGTH_SHORT).show();
            }
        });

    }
    public void insertData (String name, String address, String phone, String email){
        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseHelper.COLS_2,name);
        contentValues.put(DatabaseHelper.COLS_3,address);
        contentValues.put(DatabaseHelper.COLS_4,phone);
        contentValues.put(DatabaseHelper.COLS_5,email);
        long id =sqLiteDatabase.insert(DatabaseHelper.TABLE_NAME,null,contentValues);
    }
}