package com.fnfh.toolbardemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);

        toolbar.setNavigationIcon(R.mipmap.ic_launcher);//设置导航栏图标

        toolbar.setLogo(R.mipmap.ic_search);//设置app logo

        toolbar.setTitle("设置主标题");//设置主标题

        toolbar.setSubtitle("设置子标题");//

        toolbar.inflateMenu(R.menu.base_toolbar_menu);/*设置右上角的填充菜单*/

        /*设置条目点击监听*/

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int menuItemId=item.getItemId();
                if (menuItemId == R.id.action_search) {
                    Toast.makeText(MainActivity.this , R.string.menu_search , Toast.LENGTH_SHORT).show();

                } else if (menuItemId == R.id.action_notification) {
                    Toast.makeText(MainActivity.this , R.string.menu_notifications , Toast.LENGTH_SHORT).show();

                } else if (menuItemId == R.id.action_item1) {
                    Toast.makeText(MainActivity.this , R.string.item_01 , Toast.LENGTH_SHORT).show();

                } else if (menuItemId == R.id.action_item2) {
                    Toast.makeText(MainActivity.this , R.string.item_02 , Toast.LENGTH_SHORT).show();

                }

                return false;
            }
        });

    }
}
