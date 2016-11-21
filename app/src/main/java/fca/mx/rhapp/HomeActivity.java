package fca.mx.rhapp;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class HomeActivity extends AppCompatActivity {

    /**
     * Drawer layout
     */
    private DrawerLayout mDrawerLayout;

    /**
     * Action Bar toggle.
     */
    private ActionBarDrawerToggle mDrawerToggle;
    private NavigationView navigationView;
    private LinearLayout progress_layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_dehaze_black_24dp);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("");

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        assert navigationView != null;


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(final MenuItem item) {

                if (item.isChecked()) item.setChecked(false);
                else item.setChecked(true);
                int option = 0;
                switch (item.getItemId()) {
                    case R.id.settings_item_menu: //Settings
                        option = 2;
                        break;
                    case R.id.log_out_item_menu: //LOG OUT
                        option = 3;
                        Intent i = new Intent(HomeActivity.this,MainActivity.class);
                        startActivity(i);
                        finish();
                        break;
                }

                if (option == 2  || option == 3) {
                    mDrawerLayout.closeDrawers();
                    displayViewFromDrawer(option, item.getTitle().toString());
                } else if (option == 1) {
                    mDrawerLayout.closeDrawers();
                }
                return false;
            }
        });

        /*
        if (Preferences.getBoolean(getApplicationContext(), Preferences.SHAREDPREFERENCE_KEY.BEACON_ENABLE)) {
            //startService();
        }
        */

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.app_name, R.string.app_name) {
            public void onDrawerClosed(View view) {
                invalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                invalidateOptionsMenu();
            }
        };


        displayViewFromDrawer(1,null);

        TextView title = (TextView) findViewById(R.id.title);
        assert title != null;
        title.setVisibility(View.VISIBLE);
        title.setText("Profiles");
        setTitle("");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_community){

        }else if(id == android.R.id.home){

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    private void displayViewFromDrawer(int position, @Nullable String textTitle) {
        Fragment fragment = null;
        switch (position){
            case 1: //Activity record
                fragment = SettingsFragment.newInstance();
                break;

        }
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment,"fragment_container");
            ft.addToBackStack(null);
            ft.commit();
        }
    }
}
