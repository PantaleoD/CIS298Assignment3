// CLASS WineItem for each wine item with the following values:
//              Item# (int/Textview), Description(String, EditText), Pack Size (String, TextView),
//              Case Price (decimalformat, EditText, if Currently Active(boolean, checkbox)


package edu.kvcc.cis298.cis298assignment3;

import java.text.DecimalFormat;
import java.util.UUID;

/**
 * Created by dpantaleo on 11/5/2015.
 * description of each wine Item which includes   Item #, Description, Pack Sz, Case Price & if currently active
 *      all of which is input from a .csv data file called wines
 */
public class WineItem {
    private String mItemNumber;
    private String mDescription;
    private String mPackSize;
    private double mCasePrice;
    private boolean mCurrentlyActive;

    public WineItem() {              // EMPTY CONSTRUCTOR
            }
                                    // PARAMETERIZED CONSTRUCTOR FOR INPUT FROM DATA FILE
    public WineItem(String itemNumber, String description, String packSize,
                    double casePrice, boolean currentlyActive) {
        mItemNumber = itemNumber;
        mDescription = description;
        mPackSize = packSize;
        mCasePrice = casePrice;
        mCurrentlyActive = currentlyActive;
     }
    // getters and setters: - rt click - generate - getters & setters
   //                                                  GETTERS and SETTERS
    public String getItemNumber() {                // Item#
        return mItemNumber;
    }

    public void setItemNumber(String itemNumber) {
        mItemNumber = itemNumber;
    }

    public String getDescription() {            // Description
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getPackSize() {               // Pack Size
        return mPackSize;
    }

    public void setPackSize(String packSize) {
        mPackSize = packSize;
    }

    public Double getCasePrice() {
        return mCasePrice;
    }

    public void setCasePrice(double casePrice) {
        mCasePrice = casePrice;
    }

    public boolean isCurrentlyActive() {        // If Currently Active
        return mCurrentlyActive;
    }

    public void setCurrentlyActive(boolean currentlyActive) {
        mCurrentlyActive = currentlyActive;
    }
}
