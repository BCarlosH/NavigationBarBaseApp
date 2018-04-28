package com.example.carlos.navigationbarbaseapp.activities;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.carlos.navigationbarbaseapp.R;
import com.example.carlos.navigationbarbaseapp.item1.Item1Fragment;
import com.example.carlos.navigationbarbaseapp.item1.Item1Fragment_;
import com.example.carlos.navigationbarbaseapp.item2.Item2Fragment;
import com.example.carlos.navigationbarbaseapp.item2.Item2Fragment_;
import com.example.carlos.navigationbarbaseapp.item3.Item3Fragment;
import com.example.carlos.navigationbarbaseapp.item3.Item3Fragment_;


import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewById(R.id.navigation_bar)
    protected BottomNavigationView mNavigationBar;

    @AfterViews
    public void initActivity() {

        setItemFragment(Item1Fragment_.builder().build());
        setNavigationBarListener();

    }


    private void setNavigationBarListener() {
        if (mNavigationBar != null) {
            mNavigationBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.main_container);

                    switch (item.getItemId()) {
                        case R.id.action_item1:
                            if (!(currentFragment instanceof Item1Fragment)) {
                                selectedFragment = Item1Fragment_.builder().build();
                            }
                            break;
                        case R.id.action_item2:
                            if (!(currentFragment instanceof Item2Fragment)) {
                                selectedFragment = Item2Fragment_.builder().build();
                            }
                            break;
                        case R.id.action_item3:
                            if (!(currentFragment instanceof Item3Fragment)) {
                                selectedFragment = Item3Fragment_.builder().build();
                            }
                            break;
                    }

                    setItemFragment(selectedFragment);
                    return true;
                }
            });
        }

    }


    protected void setItemFragment(Fragment selectedFragment) {
        if (selectedFragment != null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.main_container, selectedFragment);
            transaction.commit();
        }
    }


}
