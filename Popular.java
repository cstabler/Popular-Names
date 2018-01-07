import java.util.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *  A class that reads and writes to arraylists two text files of the top 1000 boy/girl names
 * Allows a name to be inputed on the command line
 * Will print if name exists in the files
 *
 *@author Colleen Stabler
 *@date Wed Nov 29 2017
 */

public class Popular {

  public List<String> girls1 = new ArrayList<String>(); // global instance variables
  public List<String> boys1 = new ArrayList<String>();


  public boolean findGirl(String n) {

    for(int i=0; i < girls1.size(); i++) { // loops through the arraylist of girls names
      if (n.equals(girls1.get(i).split(" ")[0])) { // splits the name and number, sees if name is equal
        return true;
      }
    }
      return false;
  }

    public boolean findBoy(CharSequence n) {

      for (int k = 0; k < boys1.size(); k++) { // loops through the arraylist of boys names
        if (n.equals(boys1.get(k).split(" ")[0])) { // splits the name and number, sees if name is equal
          return true;
        }
      }
      return false;

    }

  public void girlsRank(String n) {
    int lineCount = 0; // initializes lineCount
    for(int i = 0; i<girls1.size(); i++) { // loops through array list of boys names
      lineCount++; // counts line (rank)
     if (n.equals(girls1.get(i).split(" ")[0])) { // if given name is equal to the split string name
        System.out.println(n + " is ranked " + lineCount + " in popularity among girls with "+ (girls1.get(i).split(" ")[1]) + " namings.");
        break;
      }
      }
    }



  public void boysRank(String n) {
    int lineCount = 0;
    for(int i = 0; i<boys1.size(); i++) { // loops through array list of boys names
      lineCount++; // counts line (rank)
      if (n.equals(boys1.get(i).split(" ")[0])){ // if given name is equal to the split string name
        System.out.println(n + " is ranked " + lineCount + " in popularity among boys with " + (boys1.get(i).split(" ")[1]) + " namings.");
        break;
      }
    }
  }



  public static void main(String args[]) throws IOException {

    File g = new File("girlnames.txt");// saving files
    File b = new File("boynames.txt");

    BufferedReader girls = new BufferedReader(new FileReader(g)); // reading the files
    BufferedReader boys = new BufferedReader(new FileReader(b));

    Popular p = new Popular(); // creating object

    String line; // instance variable

    try { // try reads all the file lines into boy or girl array while there is a next line
      while ((line = girls.readLine()) != null) {
        p.girls1.add(line);
      }
      girls.close();

      while((line = boys.readLine()) != null) {
        p.boys1.add(line);
      }
      boys.close();

    }
    catch (IOException e) {
      e.printStackTrace();
    }

    if (p.findBoy(args[0]) == false && p.findGirl(args[0]) == false) { // if the name does not exist in either array
      System.out.println(args[0] + " does not exist in either of the files."); // print this
    } else {

      if(p.findBoy(args[0]) == true) { // if the name exists in the boy array
        p.boysRank(args[0]); // call method
      } else {
        System.out.println(args[0] + " is not ranked in the top 1000 boy names."); // otherwise print this
      }
      if (p.findGirl(args[0]) == true) { // if the name exists in the girl array
        p.girlsRank(args[0]); //call method
      } else {
        System.out.println(args[0] + " is not ranked in the top 1000 girl names."); // otherwise print this 
      }
    }






  }
}
