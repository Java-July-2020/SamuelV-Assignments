import java.util.ArrayList;
import java.util.Arrays;

public class BasicJavaTesting {
    public static void main(String[] args) {
    
    BasicJava basics = new BasicJava();

    // Algorithm 1 - Print 1-255
    System.out.println("\nAlgorithm 1 - Print 1-255");
    basics.printAllNumbersUntil255();
    
    // Algorithm 2 - Print odd numbers between 1-255
    System.out.println("\nAlgorithm 2 - Print odd numbers between 1-255");
    basics.printOddNumbersUntil255();
    
    // Algorithm 3 - Print Sum
    System.out.println("\nAlgorithm 3 - Print Sum");
    basics.printSum();
    
    // Assignmet 4 - Iterating through an array
    System.out.println("\nAlgorithm 4 - Iterating through an array");
    Object[] anArray = new Object[]{1,true,null,"hello"};
    basics.iteratingThroughAnArray(anArray);

    // Assignmet 5 - Find Max
    System.out.println("\nAlgorithm 5 - Find Max");
    int[] anArrayOfNumbers = {1,8,-1,5,0,-4};
    basics.findMax(anArrayOfNumbers);

    // Assignmet 6 - Get Average
    System.out.println("\nAlgorithm 6 - Get Average");
    basics.getAverage(anArrayOfNumbers);

    // Assignmet 7 - Array with Odd Numbers
    System.out.println("\nAlgorithm 7 - Array with Odd Numbers");
    ArrayList<Integer> y = basics.arrayWithOddNumbers();
    System.out.println(y);

    // Assignmet 8 - Greater Than Y
    System.out.println("\nAlgorithm 8 - Greater Than Y");
    int numberOfValuesGreaterThanY = basics.greaterThanY(new int[]{1,2,3,4,5,6},3);
    System.out.println(numberOfValuesGreaterThanY);

    // Assignmet 9 - Square the Values
    System.out.println("\nAlgorithm 9 - Square the Values");
    int[] x1 = {1,5,10,-2};
    basics.squareTheValues(x1);
    System.out.println(Arrays.toString(x1));

    // Assignmet 10 - Eliminate Negative Values
    System.out.println("\nAlgorithm 10 - Eliminate Negative Values");
    int[] x2 = {1,5,10,-2};
    basics.eliminateNegativeValues(x2);
    System.out.println(Arrays.toString(x2));

    // Assignmet 11 - Max, Min, and Average
    System.out.println("\nAlgorithm 11 - Max, Min, and Average");
    int[] x3 = {1,5,10,-2};
    double[] result = basics.maxMinAndAverage(x3);
    System.out.println(Arrays.toString(result));

    // Assignmet 12 - Shifting the Values in the Array
    System.out.println("\nAlgorithm 12 - Shifting the Values in the Array");
    int[] x4 = {1,5,10,7,-2};
    basics.eliminateNegativeValues(x4);
    System.out.println(Arrays.toString(x4));

    }
}