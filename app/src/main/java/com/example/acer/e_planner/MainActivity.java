package com.example.acer.e_planner;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.acer.e_planner.fragment.Bookragment;
import com.example.acer.e_planner.fragment.HomeFragment;
import com.example.acer.e_planner.fragment.MeFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class MainActivity extends AppCompatActivity {

    BottomBar bottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bottomBar =(BottomBar)findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            Fragment fragment = null;


            public void onTabSelected(int tabId) {
                if (tabId == R.id.home){
                    fragment = new HomeFragment();
                } else if (tabId == R.id.booking){
                    fragment = new Bookragment();
                }else if (tabId == R.id.me){
                    fragment = new MeFragment();
                }
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content, fragment)
                        .commit();
            }
        });

        //=============================================================

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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
}
