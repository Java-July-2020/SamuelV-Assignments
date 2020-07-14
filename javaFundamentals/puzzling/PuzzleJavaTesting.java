import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class PuzzleJavaTesting {
    public static void main(String[] args) {
    
        PuzzleJava puzzle = new PuzzleJava();

        // Method 1
        System.out.println("\nMethod 1");
        System.out.println("The numbers in the array greater that 10 are: " + puzzle.methodOne());

        // Method 2
        System.out.println("\nMethod 2");
        System.out.println("The names in the array with lenghth greater than 5 are: " + puzzle.methodTwo());
        
        // Method 3
        System.out.println("\nMethod 3");
        puzzle.methodThree();
       
        // Method 4
        System.out.println("\nMethod 4");
        System.out.println("The array with 10 random numbers between 55 and 100 is: " + puzzle.methodFour());
       
        // Method 5
        System.out.println("\nMethod 5");
        System.out.println("The array with 10 random numbers between 55 and 100 sortered is: " + puzzle.methodFive());

        // Method 6
        System.out.println("\nMethod 6");
        System.out.println("The random generated string is: " + puzzle.methodSix());

        // Method 7
        System.out.println("\nMethod 7");
        System.out.println("The array with 10 random generated strings is: " + Arrays.toString(puzzle.methodSeven()));
        

    }
}