package com.example.eugene.profile;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;


public class Main2Activity extends AppCompatActivity {


    EditText etText;
    EditText etText1;
    EditText etText2;
    EditText etText3;
    EditText etText4;
    EditText etText5;
    EditText etText6;




    Button btnSave, btnLoad;
    SharedPreferences sPref;
    SharedPreferences sPref2;


    final String SAVED_TEXT = "saved_text";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        etText = (EditText)findViewById(R.id.editText);
        etText1 = (EditText)findViewById(R.id.editText3);
        etText2 = (EditText)findViewById(R.id.editText4);
        etText3 = (EditText)findViewById(R.id.editText5);
        etText4 = (EditText)findViewById(R.id.editText6);
        etText5 = (EditText)findViewById(R.id.editText7);
        etText6 = (EditText)findViewById(R.id.editText9);

        btnSave = (Button)findViewById(R.id.item3);


        ActionBar ab = getSupportActionBar();
        LayoutInflater li = LayoutInflater.from(this);
       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setHomeButtonEnabled(true);
        View customView = li.inflate(R.layout.my_action_bar, null);
        ab.setCustomView(customView);
        ab.setDisplayShowCustomEnabled(true);
        ImageButton ibItem = (ImageButton) customView.findViewById(R.id.item1);
        ibItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);

                startActivity(intent);
            }
        });



    }

    int counter = 0;
    private void saveText(SharedPreferences sPref, EditText edit) {
        String prefName = "MyPref" + Integer.toString(counter);
        counter += 1;
        sPref = getSharedPreferences(prefName, MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(SAVED_TEXT, edit.getText().toString());
        ed.commit();

        Toast.makeText(Main2Activity.this, "Text saved", Toast.LENGTH_SHORT).show();


    }




    @Override
    protected void onDestroy() {
        super.onDestroy();
        //saveText();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        setTitle("Edit profile");
        getMenuInflater().inflate(R.menu.main2, menu);
        return true;
    }

   @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch(id){

            case R.id.item3 :
               saveText(sPref, etText);
               saveText(sPref, etText1);
                saveText(sPref, etText2);
                saveText(sPref, etText3);
                saveText(sPref, etText4);
                saveText(sPref, etText5);
                saveText(sPref, etText6);

                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                return true;

        }

        return super.onOptionsItemSelected(item);
    }


}
