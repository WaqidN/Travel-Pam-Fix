package com.example.abnormal.tab;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Lihat extends Activity implements AdapterView.OnItemClickListener {

    private ListView listView;
    private ArrayAdapter<String> arrayAdapter;
    private String[] programmingLang={ "Bintang Wijaya","Cipaganti","Joglosemar","Sumber Alam","Trans Jaya","Tri Kusuma"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat);

        listView=(ListView) findViewById(R.id.listViewProgramming);
        arrayAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,programmingLang);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.list, menu);
        return true;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String message="Terpilih : "+((TextView)view).getText();
        Intent intent=new Intent(getApplicationContext(),Item.class);
        intent.putExtra("message", message);
        startActivity(intent);
    }
}
