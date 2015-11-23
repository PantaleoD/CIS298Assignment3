// WineListSingleton.java   this is the Singleton to place the data file data into the
//                          WineItem's - List/ArrayList  - 1 time only (private constructor called from this class)

package edu.kvcc.cis298.cis298assignment3;
import android.content.Context;
import android.util.Log;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

                   /**              * Created by dpantaleo on 11/6/2015.            */
public class WineListSingleton {
    private static WineListSingleton sWineListSingleton;
    private List<WineItem> mWineItems;                      // list/array is plural
    private Context mContext;

    public static WineListSingleton get(Context context){      // gets itself (in this class) to create the list
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

        try {                             // read file - split and assign to fields, set to class/object
            scanner = new Scanner(mContext.getResources().openRawResource(R.raw.wine));
            while (scanner.hasNextLine()) {
                String inputRecord = scanner.nextLine();
                String inputFields[] = inputRecord.split(",");

                String inputWineNumber = inputFields[0];
                String inputDescription = inputFields[1];
                String inputPackSize = inputFields[2];
                String inputCasePrice = inputFields[3];     // chg to a # later!!!!!!
                String inputCurrentlyActive = inputFields[4];

                Double isCasePriceDouble = Double.parseDouble(inputCasePrice);  // cast input to double

                boolean isCurrentlyActive;                        // set boolean/Check box true/false  based on input string
                if (inputCurrentlyActive.equals("True")) {
                    isCurrentlyActive = true;
                } else {
                    isCurrentlyActive = false;
                }
                mWineItems.add(new WineItem(inputWineNumber, inputDescription, inputPackSize, isCasePriceDouble, isCurrentlyActive));
            }
        }
        catch (Exception e) {                                              // catch for any file issues
            Log.e("Error Reading File", e.toString());
        }
          finally {
                scanner.close();                                         // close file
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

