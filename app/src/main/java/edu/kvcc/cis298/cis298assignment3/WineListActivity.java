// WineListActivity - purpose...needed to show list o fall items.... ok...not sure why!

package edu.kvcc.cis298.cis298assignment3;

import android.support.v4.app.Fragment;

                    /**          * Created by dpantaleo on 11/6/2015.        */
public class WineListActivity extends OneFragmentActivity{
   protected Fragment createFragment() {
            return new WineListFragment();
   }
}
