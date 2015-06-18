package com.example.yhjonathankwok.jun17cw;

import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    private int count;
    private TextView counter;
    public static final String fileName = "countFile";
    private SharedPreferences setting;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        count = 0;
        counter=(TextView)findViewById(R.id.counter);
        setting = getSharedPreferences(fileName, 0);
        count = setting.getInt("Count", 0);
        counter.setText("" + count);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void saveCount(View view) {
        SharedPreferences.Editor editor = setting.edit();
        editor.putInt("Count", count);

        // Commit edit
        editor.commit();

        //insert(count);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void advance(View view){
        count++;
        counter.setText("" + count);
    }
}
