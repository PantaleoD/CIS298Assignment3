// WineListSingleton.java   this is the Singleton to create the data for the WineItem's -
//                  one time only (private constructor called from this class)
package edu.kvcc.cis298.cis298assignment3;
import android.content.Context;
import android.util.Log;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
        /**              * Created by dpantaleo on 11/6/2015.            */
public class WineListSingleton {
    private static WineListSingleton sWineListSingleton;
    private List<WineItem> mWineItems;      // list/array is plural
    private Context mContext;

    public static WineListSingleton get(Context context){
        if (sWineListSingleton == null){
            sWineListSingleton = new WineListSingleton(context);
        }
        return sWineListSingleton;
    }

    private WineListSingleton(Context context){
        mWineItems = new ArrayList<>();
        mContext = context;
                // read file and make objects....
                // file is stored in project in:  App/Src/Main/res (create folder called 'raw' and paste into this folder
        Scanner scanner;
        scanner = null;

        try {
            scanner = new Scanner(mContext.getResources().openRawResource(R.raw.wine2));
            while (scanner.hasNextLine()) {
                String inputRecord = scanner.nextLine();
                String inputFields[] = inputRecord.split(",");

                String inputWineNumber = inputFields[0];
                String inputDescription = inputFields[1];
                String inputPackSize = inputFields[2];
                String inputCasePrice = inputFields[3];     // chg to a # later!!!!!!
                String inputCurrentlyActive = inputFields[4];

                Double isCasePriceDouble = Double.parseDouble(inputCasePrice);

                boolean isCurrentlyActive;
                if (inputCurrentlyActive.equals("True")) {
                    isCurrentlyActive = true;
                } else {
                    isCurrentlyActive = false;
                }
                mWineItems.add(new WineItem(inputWineNumber, inputDescription, inputPackSize, isCasePriceDouble, isCurrentlyActive));
            }
        }
        catch (Exception e) {
            Log.e("Error Reading File", e.toString());
        }
          finally {
                scanner.close();
            }
    }

    public List<WineItem> getWineItems(){
        return mWineItems;
        }

    public WineItem getWineItem(String itemNumber){            // check if wineNum here is ok!!!
        for (WineItem wineItem : mWineItems){
            if(wineItem.getItemNumber().equals(itemNumber)){
                return wineItem;
            }
        }
        return  null;
     }
   }

