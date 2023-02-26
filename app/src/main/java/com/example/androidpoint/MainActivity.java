package com.example.androidpoint;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

import com.example.androidpoint.Adapter.PagerAdapter;
import com.example.androidpoint.Fragment.BasicFragment;
import com.example.androidpoint.Fragment.HomeFragment;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    TabLayout tabLayout;
    TabItem learn_tab,advance_tab,basic_tab;

    ViewPager viewPager;

    PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setTitle("Welcome To Android Point");

// Define ID's==========================================================================================
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationView);
        toolbar = findViewById(R.id.toolbar);

        viewPager=findViewById(R.id.viewPager);
        tabLayout=findViewById(R.id.tabLayout);
        basic_tab=findViewById(R.id.basic_tab);
        advance_tab=findViewById(R.id.advance_tab);
        learn_tab=findViewById(R.id.learn_tab);

//Step 1 Set Toolbar===============================================================================================

        setSupportActionBar(toolbar);

        //Set Drawer Toggle

        ActionBarDrawerToggle toggle= new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.openDrawer,R.string.closeDrawer);

        drawerLayout.addDrawerListener(toggle);

        toggle.syncState();


        pagerAdapter=new PagerAdapter(getSupportFragmentManager(),FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

      //default Fragment
      //  loadFragment(new HomeFragment());

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id= item.getItemId();

                if (id==R.id.home){
                    loadFragment(new BasicFragment());

                }
                else if (id==R.id.setting)
                {

                }
                else {

                }

                drawerLayout.closeDrawer(GravityCompat.START);

                return true;
            }
        });

    }



    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.isDrawerOpen(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }

    private void loadFragment(Fragment fragment) {

        FragmentManager fm= getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.add(R.id.viewPager,fragment).commit();

    }
}