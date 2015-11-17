/*    WineFragment.java
                   to ....  show a Wine Item based on the Item Number selected
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

/**
 * Created by dpantaleo on 11/5/2015.    created to extend fragment and show wine item
 */
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

        mWineItem = WineListSingleton.get(getActivity()).getWineItem(itemNum ); // FIX THIS!!!
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_wine, container, false);
        mItemNumber = (TextView)v.findViewById(R.id.wine_id);                      // I"M NOST SURE wine_id is RIGHT!
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
            public void afterTextChanged(Editable s) {
            }
        }) ;

        mDescription = (EditText)v.findViewById(R.id.description);
        mDescription.setText(mWineItem.getDescription());

        mPackSize = (EditText)v.findViewById(R.id.pack_size);
        mPackSize.setText(mWineItem.getPackSize().toString());

        mCasePrice = (EditText)v.findViewById(R.id.case_price);
        mCasePrice.setText(mWineItem.getCasePrice().toString());

       mCurrentlyActive = (CheckBox)v.findViewById(R.id.currently_active_item);
        mCurrentlyActive.setChecked(mWineItem.isCurrentlyActive());
        mCurrentlyActive.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton  compoundButton, boolean isCurrentlyActive){
                mWineItem.setCurrentlyActive(isCurrentlyActive);   }
            });
        return v; }
}



