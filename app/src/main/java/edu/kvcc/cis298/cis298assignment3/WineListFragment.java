// WineListFragment.java       this displays multiple wine items using the Recycler View...to get that...
//  1st thing:                           File - Project Structure - clk app - Dependency tab - + button -
//                                       Library dependency - select the recycler-v7(recyclerview-v7.#.#.#)


package edu.kvcc.cis298.cis298assignment3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.List;

/**      * Created by dpantaleo on 11/6/2015.        */

public class WineListFragment extends Fragment {            // inherits from Fragment in support library imported
    private RecyclerView mWineRecyclerView;

    String PriceString;                     // **********************
    private WineItemAdapter mAdapter;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_wine_list, container, false);  // fragments inflate in onCreateView

        mWineRecyclerView = (RecyclerView) view
                .findViewById(R.id.wine_recycler_view);           // allows for paging up/down in list view without losing values

        mWineRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();                                               // calls method to acquire data from Singleton (data area)
        return view;
    }

    public void onResume(){                                  // with resume...update data again
        super.onResume();
        updateUI();
    }
//                                                               using the activity...acquires the item to display
    private void  updateUI() {
        WineListSingleton wineListSingleton = WineListSingleton.get(getActivity());
        List<WineItem> wineItems = wineListSingleton.getWineItems();

        if (mAdapter == null) {
            mAdapter = new WineItemAdapter(wineItems);
            mWineRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.notifyDataSetChanged();
        }
    }

    private class WineHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView mItemNNumberTextView;
        private TextView mDescriptionTextView;
        private TextView mCasePriceTextView;

        private WineItem mWineItem;

        public WineHolder(View itemView) {                          // to show the data as needed
            super(itemView);
            itemView.setOnClickListener(this);

            mItemNNumberTextView = (TextView)
                    itemView.findViewById(R.id.list_item_number);
            mDescriptionTextView = (TextView)
                    itemView.findViewById(R.id.list_item_description);
            mCasePriceTextView  = (TextView)
                    itemView.findViewById(R.id.list_item_case_price);
        }

        public void bindWine(WineItem wineItem){                     // sets view to see data
            mWineItem = wineItem;
            mItemNNumberTextView.setText(mWineItem.getItemNumber());
            mDescriptionTextView.setText(mWineItem.getDescription());

            String casepricestring = mWineItem.getCasePrice().toString();
     //        mCasePriceTextView.setText( mWineItem.getCasePrice());
                 mCasePriceTextView.setText(casepricestring);
        }

        @Override
        public void onClick(View v){
            Intent intent = WinePagerActivity.newIntent(getActivity(), mWineItem.getItemNumber());
            startActivity(intent);
        }
    }

    private class WineItemAdapter extends RecyclerView.Adapter<WineHolder> {
         private List<WineItem> mWineItems;

         public WineItemAdapter(List<WineItem> wineItems){
             mWineItems = wineItems;
        }
        @Override
        public WineHolder onCreateViewHolder(ViewGroup parent, int ViewType){
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater
                    .inflate(R.layout.wine_list, parent, false);  // &&&&&&&&& CHECK IF wine_list is correct!!!!
            return new WineHolder(view);
        }

        @Override
        public void onBindViewHolder(WineHolder holder, int position){
            WineItem wineItem = mWineItems.get(position);
            holder.bindWine(wineItem);
        }
        @Override
        public  int getItemCount() {
             return mWineItems.size();
        }
    }
}
