package com.example.sembakobulanan;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Listrik extends AppCompatActivity {
    Button btnKembali;
    EditText editTextTanggal;
    DatePickerDialog datePickerDialog;
    SimpleDateFormat dateFormatter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listrik);
        btnKembali = findViewById(R.id.btnKembali);
        editTextTanggal = findViewById(R.id.editTextTanggal);
        dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
        Button btnBayar = findViewById(R.id.btnBayar);


        editTextTanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDateDialog();
            }
        });

        btnKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MenuBulanan.class);
                startActivity(intent);
            }
        });
        btnBayar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });
    }
    private void showDateDialog(){
        Calendar calendar = Calendar.getInstance();
        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            Calendar newDate= Calendar.getInstance();
            newDate.set(year, month, dayOfMonth);
            editTextTanggal.setText(dateFormatter.format(newDate.getTime()));
            }
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }
}