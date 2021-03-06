// OneFragmentActivity - abstract class to be reused to show all fragments

package edu.kvcc.cis298.cis298assignment3;

import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

/**
 * Created by dpantaleo on 11/6/2015.
*/
public abstract class OneFragmentActivity extends FragmentActivity {
    protected abstract Fragment createFragment();


public void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_fragment);

    FragmentManager frgmgr = getSupportFragmentManager();

    Fragment fragment = frgmgr.findFragmentById(R.id.fragment_container);

    if (fragment == null) {

        fragment = createFragment();

    frgmgr.beginTransaction()
        .add(R.id.fragment_container, fragment)
        .commit();
        }
    }
}
