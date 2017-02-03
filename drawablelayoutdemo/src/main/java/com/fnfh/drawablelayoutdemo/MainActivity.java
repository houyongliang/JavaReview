package com.fnfh.drawablelayoutdemo;

import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        final FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = new ContentFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title","首页");
        fragment.setArguments(bundle);
        fm.beginTransaction().replace(R.id.fl_content,fragment).commit();
        final NavigationView navigationView = (NavigationView) findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                Toast.makeText(MainActivity.this, menuItem.getTitle(), 0).show();
                Fragment fragment = new ContentFragment();
                Bundle bundle = new Bundle();
                bundle.putString("title", menuItem.getTitle().toString());
                fragment.setArguments(bundle);
                fm.beginTransaction().replace(R.id.fl_content,fragment).commit();
                drawerLayout.closeDrawer(Gravity.LEFT);
                return false;
            }
        });

    }
}
