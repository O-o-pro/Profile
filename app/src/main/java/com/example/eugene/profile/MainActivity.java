package com.example.eugene.profile;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.MenuItem;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.Menu;


public class MainActivity extends AppCompatActivity {

    TextView userText;
    TextView userText1;
    TextView userText2;
    TextView userText3;
    TextView userText4;
    TextView userText5;
    TextView userText6;
    SharedPreferences sPref;

    final String SAVED_TEXT = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        userText = (TextView)findViewById(R.id.textView6);
        userText1 = (TextView)findViewById(R.id.textView8);
        userText2 = (TextView)findViewById(R.id.textView10);
        userText3 = (TextView)findViewById(R.id.textView13);
        userText4 = (TextView)findViewById(R.id.textView15);
        userText5 = (TextView)findViewById(R.id.textView17);
        userText6 = (TextView)findViewById(R.id.textView22);

        loadText(userText);
        loadText(userText1);
        loadText(userText2);
        loadText(userText3);
        loadText(userText4);
        loadText(userText5);
        loadText(userText6);

    }

    int counter = 0;
    private void loadText(TextView userText) {
        String prefName = "MyPref" + Integer.toString(counter);
        sPref = getSharedPreferences(prefName, MODE_PRIVATE);
        String savedText = sPref.getString(SAVED_TEXT, "0");
        userText.setText(savedText);

        counter += 1;


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch(id){
            case R.id.item1 :
                Intent intent = new Intent(this, Main2Activity.class);
                startActivity(intent);
                return true;

        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        setTitle("Profile");
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}

