// WinePagerActivity... purpose:   view indiv. items.... by swiping to left or right once 1 is displayed
//      replaces WineActivity.java

package edu.kvcc.cis298.cis298assignment3;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.List;

/**     Created by dpantaleo on 11/14/2015  */


 public class WinePagerActivity extends FragmentActivity {

        private static final String EXTRA_ID =
                "edu.kvcc.cis298.cis298assignment3.wine_id";   // PRETTY SURE WINE ITEM IS CORRECT HERE !!!!

        private ViewPager mViewPager;
        private List<WineItem> mWineItems;

    public static Intent newIntent(Context packageContext, String wine_id ) {   // not sure wine_item_number is correct
        Intent intent = new Intent(packageContext, WinePagerActivity.class);

        intent.putExtra(EXTRA_ID, wine_id);
        return intent;
    }

    public void onCreate(Bundle savedInstanceState){                            // chged from protected to public
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wine_pager);

        String wine_id = (String) getIntent()
                .getStringExtra(EXTRA_ID);

        mViewPager = (ViewPager) findViewById(R.id.wine_pager_view);
         mWineItems = WineListSingleton.get(this).getWineItems();                  // this is method I don't have access to
        FragmentManager fragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                WineItem wineItem = mWineItems.get(position);
                return WineFragment.newInstance(wineItem.getItemNumber());
            }

            @Override
            public int getCount() {
                return mWineItems.size();
            }
        });

        for (int i = 0; i < mWineItems.size(); i++){
            if (mWineItems.get(i).getItemNumber().equals(wine_id));
            mViewPager.setCurrentItem(i);
            break;
        }
      }
    }



