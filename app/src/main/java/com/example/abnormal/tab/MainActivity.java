package com.example.abnormal.tab;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Spinner Asal;
    Spinner Tujuan;

    Button btn;
    int year_x,month_x,day_x;
    static final int DIALOG_ID = 0;

    private static Button button_sbm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Asal = (Spinner) findViewById(R.id.spinner);
        Tujuan = (Spinner) findViewById(R.id.spinner2);

        List<String> item = new ArrayList<String>();
        item.add("Semarang");
        item.add("Yogyakarta");


        // asal
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (MainActivity.this,android.R.layout.simple_spinner_dropdown_item, item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Asal.setAdapter(adapter);

        //tujuan
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>
                (MainActivity.this,android.R.layout.simple_spinner_dropdown_item, item);

        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Tujuan.setAdapter(adapter1);

        //Kalender
        final Calendar cal = Calendar.getInstance();
        year_x = cal.get(Calendar.YEAR);
        month_x = cal.get(Calendar.MONTH);
        day_x = cal.get(Calendar.DAY_OF_MONTH);
        showDialogOnButtonClick();

        OnClikButtonListener();//fungsi dari lihat connec to new activity

    }

    public void showDialogOnButtonClick(){
        btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showDialog(DIALOG_ID);
                    }
                }
        );
    }

    @Override
    protected Dialog onCreateDialog(int id ){
        if (id == DIALOG_ID)
            return new DatePickerDialog(this, dpickerListner, year_x,month_x,day_x);
        return  null;
    }
    private DatePickerDialog.OnDateSetListener dpickerListner
            = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            year_x = year;
            month_x = monthOfYear + 1;
            day_x = dayOfMonth;
            Toast.makeText(MainActivity.this, year_x + "/" + month_x + "/" + day_x, Toast.LENGTH_LONG).show();
        }
    };
            //Lihat 2nd Activity
    public void OnClikButtonListener() {
        button_sbm = (Button) findViewById(R.id.button2);
        button_sbm.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.example.nugroho.tab.Lihat");
                        startActivity(intent);
                    }
                }
        );

    }
}
