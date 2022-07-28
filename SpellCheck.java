
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class SpellCheck
   {
      private ArrayList<String> dictionary;
      
      public SpellCheck() {
        String[] tmp = null;
        try
        {
            tmp = readLines("dictionary.txt");
        }
        catch(IOException e)
        {
            // Print out the exception that occurred
            System.out.println("Unable to access "+e.getMessage());              
        }
        dictionary = new ArrayList<String>(Arrays.asList(tmp));
      }
  
  public static String[] readLines(String filename) throws IOException 
    {
        FileReader fileReader = new FileReader(filename);
         
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> lines = new ArrayList<String>();
        String line = null;
         
        while ((line = bufferedReader.readLine()) != null) 
        {
            lines.add(line);
        }
         
        bufferedReader.close();
         
        return lines.toArray(new String[lines.size()]);
    }
    
    /** This uses linear search to find a word 
        * in the dictionary ArrayList and also
        * prints out the number of words checked.
        * If not found, word is misspelled.
        * Include code to count and print out the number of words checked.
      */
      public boolean linearSpellCheck(String word)
      {
        int count = 0;

        for(int i = 0; i<dictionary.size(); i++){
          if(dictionary.get(i).equals(word)){
            count++;
            System.out.println("Number of words checked: "+count);
            return true;
          }else{
            count++;
          }
        }
        System.out.println("Number of words checked: "+count);
        return false;
        
      }
      /** This uses binary search to find a word 
        * in the dictionary ArrayList.
        * If not found, word is misspelled.
        * Include code to count and print out the number of words checked.
      */
  public boolean binarySpellCheck(String word) {
        int left = 0;
        int right = dictionary.size()-1;
        int count = 0;

        

        while(left <= right){
          int middle = (left+right)/2;
          int c = word.compareTo(dictionary.get(middle));
          if(c < 0){
            right = middle-1;
            count++;
          }
          else if(c > 0){
            left = middle+1;
            count++;
          }else{
            count++;
            System.out.println("Number of words checked: "+count);
            return true;
          }
        }
        System.out.println("Number of words checked: "+count);
        return false;
     }
      
   }