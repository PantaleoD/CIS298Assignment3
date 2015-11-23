# Assignment 3 - Master Detail Wine List with Fragments

## Author  Dawn Pantaleo


## Description

Create a master detail application to view the contents of a beverage list.
The master part will display a list of all of the beverage items in the list.
The Detail part will display the details of a specific beverage item.
The User should be able to go up and down items in the list by swiping left or right on a detail page.
The App should look like the screen shots I have provided.
There is no need to save any information changed in the application to the CSV file.
   ??  Is there anything 'unique' you need to do to write to the updated data back to the CSV file and 
       Would that also be in a singleton? the same one or different one - at end of processing ???

The properties of the CSV file are as follows:
1. Item Number             String
2. Item Description        String
3. Item Pack Size          String
4. Case Price		   Double
5. Currently Active Item   Checkbox

Solution Requirements:

* Master layout - done
  Detail Layout - done
* Fragments for all of the layouts  - done
  Ability to click an item & start a new Activity to display details - done
  Updated information in detail view should be reflected in list view upon return - done
* Class to represent a Beverage Item - done
* ArrayList for the list of Beverage Items  - done
  Recycler view for Master layout (list)  - done
* ListView to display the master view     - done
* Read in CSV file and create ArrayList of Beverage Items from the data in the CSV file - done (singleton)
* Use View Pager to swipe left and right on detail page to go up and down in the list - done
* Should look like the screen shots provided - done as best as I can... I think you wanted the values more to the left than I did.. I'm sure there's a better way than mine also
* Remember Documentation, and README - done


![Application Master Portrait Layout](http://barnesbrothers.homeserver.com/cis298/assignmentImages/assignment3a.jpg "Application Master Portrait Layout")
![Application Master Landscape Layout](http://barnesbrothers.homeserver.com/cis298/assignmentImages/assignment3b.jpg "Application Master Landscape Layout")
![Application Detail Portrait Layout](http://barnesbrothers.homeserver.com/cis298/assignmentImages/assignment3c.jpg "Application Detail Portrait Layout")
![Application Detail Landscape Layout](http://barnesbrothers.homeserver.com/cis298/assignmentImages/assignment3d.jpg "Application Detail Landscape Layout")

### Notes
 program runs!  probably better on your phone but, as of Sun night, it even ran on my computer
 I did not change id as un-editable... so I have another field to test back button with. I did
 make the description read only. Mostly because I started there.


The book does not cover how to read in a CSV file, however, it should be fairly easy to find on the internet. If more help is needed, we can do something in class.

 if is was all that easy!! LOL

## Outside Resources Used

  stack overflow, you, our textbook and example from class

## Known Problems, Issues, And/Or Errors in the Program

  I 'think' I don't have issues with the run, just differences as described above...although I have so thought that before!!  :-)
  I do have 2 versions of the data file.. wine is your, wine2 is a shorter version