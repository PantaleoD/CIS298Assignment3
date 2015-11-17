// WineActivity.java        to extend OneFragmentActivity to show detail of a wine..replaced by WinePagerActivity.java
/*
package edu.kvcc.cis298.cis298assignment3;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class WineActivity extends OneFragmentActivity {
  public  static final String EXTRA_ID =
          "edu.kvcc.cis298.cis298assignment3.wine_id";
    public static Intent newIntent(Context packageContext, String itemNum ) {  // itemNum is intent variable
        Intent intent = new Intent(packageContext, WineActivity.class);
        intent.putExtra(EXTRA_ID, itemNum );
        return intent;
    }

    protected Fragment createFragment(){
         String itemNum  = getIntent().getStringExtra(EXTRA_ID);

   //            return WineFragment.newInstance(itemNum);    // I think uncomment when make chg to WineFragment?
         return  WineFragment.newInstance(itemNum) ;                         // and comment this out
    }
}

   */