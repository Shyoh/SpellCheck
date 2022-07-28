import java.util.*;

public class Main {
  public static void main(String[] args) {
    SpellCheck checker = new SpellCheck();

    System.out.println("Enter a word to spell check: ");
    Scanner scan = new Scanner(System.in);
    String word = scan.nextLine();
    
      System.out.println("Using linear Search:");
      if (checker.linearSpellCheck(word))
        System.out.println(word + " is spelled correctly!");
      else
        System.out.println(word + " is misspelled!");

      System.out.println("Using binary Search:");
      if (checker.binarySpellCheck(word))
        System.out.println(word + " is spelled correctly!");
      else
        System.out.println(word + " is misspelled!");
      
      scan.close();
  }

}