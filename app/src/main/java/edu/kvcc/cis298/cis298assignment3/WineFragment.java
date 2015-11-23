/*    WineFragment.java
                   to ....  shows one Wine Item based on the Item Number selected
                   should be editable values - currently...all but name is editable...I left id as editable for
                   display purposes back in the list view although I know it shouldn't be
 */
package edu.kvcc.cis298.cis298assignment3;
import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

/**     Created by dpantaleo on 11/5/2015.    created to extend fragment and show wine item */
public class WineFragment extends Fragment {

    private  static final String Arg_WINE_ID = "wine_id";    // this is KEY for Bundle & used to retrieve from the Bundle
    private WineItem mWineItem;                 // instance variable

    private TextView mItemNumber;             // values on form... View only: Item#, PackSize
    private EditText mDescription;            //                   Editable: Description, CasePrice
    private EditText  mPackSize;
    private EditText mCasePrice;
    private CheckBox mCurrentlyActive;         //                  Checkbox for if Currently Active
 //  private Button mMoreInfoButton;            //                   Button: assumed needed for something!

   public static WineFragment newInstance(String itemNum)  {
      Bundle args = new Bundle();
      args.putString(Arg_WINE_ID, itemNum);         // itemNum is the KEY Value
      WineFragment fragment = new WineFragment();
      fragment.setArguments(args);
      return fragment;
  }

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        String itemNum = (String) getArguments().getString(Arg_WINE_ID);

        mWineItem = WineListSingleton.get(getActivity()).getWineItem(itemNum); // FIX THIS!!!
    }

    @Nullable
    @Override                            // for display of values in fragrment...1 field per line
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_wine, container, false);

        
        mItemNumber = (TextView)v.findViewById(R.id.wine_id);           // find by wine_id...to locate record in array
        mItemNumber.setText(mWineItem.getItemNumber());

        mItemNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mWineItem.setItemNumber(s.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {   }

        }) ;

        mDescription = (EditText)v.findViewById(R.id.description);         // description
        mDescription.setText(mWineItem.getDescription());

        mPackSize = (EditText)v.findViewById(R.id.pack_size);              // pack size
        mPackSize.setText(mWineItem.getPackSize().toString());

        mCasePrice = (EditText)v.findViewById(R.id.case_price);            // case price
        mCasePrice.setText(mWineItem.getCasePrice().toString());

        mCasePrice.addTextChangedListener(new TextWatcher() {                 // listener for price change
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {    }

        @Override                                                     // price is double...cast to string, test if value left for price & if so
        public void onTextChanged(CharSequence s, int start, int before, int count) {   // will return value, else returns zero
        String casepricestring = s.toString();
        if (count > 0) {
            mWineItem.setCasePrice(Double.parseDouble(casepricestring));
        }
        else
        {
            mWineItem.setCasePrice(0);
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {
    }
});


       mCurrentlyActive = (CheckBox)v.findViewById(R.id.currently_active_item);     // checkbox... display & check if checkbox is changed
       mCurrentlyActive.setChecked(mWineItem.isCurrentlyActive());

       mCurrentlyActive.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton compoundButton, boolean isCurrentlyActive) {
               mWineItem.setCurrentlyActive(isCurrentlyActive);
           }
       });
        return v; }                                                          // returns the view to the activity for display
}



