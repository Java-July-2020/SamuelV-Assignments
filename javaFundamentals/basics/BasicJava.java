import java.util.ArrayList;

public class BasicJava {

    // Algorithm 1 - Print 1-255
    // Write a method that prints all the numbers from 1 to 255.
    public void printAllNumbersUntil255(){
        for (int i = 1; i<256; i++){
            System.out.println(i);
        } 
    }

    // Algorithm 2 - Print odd numbers between 1-255
    // Write a method that prints all the odd numbers from 1 to 255.
    public void printOddNumbersUntil255(){
        for (int i = 1; i<256; i=i+2){
            System.out.println(i);
        } 
    }

    // Algorithm 3 - Print Sum
    // Write a method that prints the numbers from 0 to 255, but this time print the sum of the numbers that have been printed so far. For example, your output should be something like this:

    // New number: 0 Sum: 0
    // New number: 1 Sum: 1
    // New number: 2 Sum: 3
    // New number: 3 Sum: 6
    // ...
    // New number: 255 Sum: ___

    // Do NOT use an array to do this exercise.

    public void printSum(){
        int sum = 0;
        for (int i = 0; i<256; i++){
            sum = sum + i;
            System.out.println("New number: "+ i + " Sum: " + sum);
        } 
    }

    // Algorithm 4 - Iterating through an array
    // Given an array X, say [1,3,5,7,9,13], write a method that would iterate through each member of the array and print each value on the screen. Being able to loop through each member of the array is extremely important.

    public void iteratingThroughAnArray(Object[] array){
        for (Object member : array){
            System.out.println(member);
        } 
    }

    // Assignmet 5 - Find Max
    // Write a method (sets of instructions) that takes any array and prints the maximum value in the array. Your method should also work with a given array that has all negative numbers (e.g. [-3, -5, -7]), or even a mix of positive numbers, negative numbers and zero.
    public void findMax(int[] array){
        int max = array[0];
        for (int number : array){
            if (number > max){
                max = number;
            }
        }
        System.out.println("The max number in the array is " + max); 
    }

    // Assignmet 6 - Get Average
    // Write a method that takes an array, and prints the AVERAGE of the values in the array. For example for an array [2, 10, 3], your method should print an average of 5. Again, make sure you come up with a simple base case and write instructions to solve that base case first, then test your instructions for other complicated cases.
    public void getAverage(int[] array){
        double sum = 0;
        int n = array.length;
        for (int number : array){
                sum = sum + number;   
        }
        double avg = sum/n; 

        System.out.println("The average in the array is " + avg); 
    }
    
    // Assignmet 7 - Array with Odd Numbers
    // Write a method that creates an array 'y' that contains all the odd numbers between 1 to 255. When the method is done, 'y' should have the value of [1, 3, 5, 7, ... 255].
    public ArrayList<Integer> arrayWithOddNumbers(){
        ArrayList<Integer> output = new ArrayList<Integer>();
        for (int i = 1; i<256; i=i+2){
            output.add(i);
        } 
        return output;
    }

    // Assignmet 8 - Greater Than Y
    // Write a method that takes an array and returns the number of values in that array whose value is greater than a given value y. For example, if array = [1, 3, 5, 7] and y = 3, after your method is run it will print 2 (since there are two values in the array that are greater than 3)
    public int greaterThanY(int[] array, int y){
        int counter = 0;
        for (int number : array){
            if (number > y){
                counter++;
            }
        }
        return counter;
    }

    // Assignmet 9 - Greater Than Y
    // Write a method that takes an array and returns the number of values in that array whose value is greater than a given value y. For example, if array = [1, 3, 5, 7] and y = 3, after your method is run it will print 2 (since there are two values in the array that are greater than 3)
    public void squareTheValues(int[] x){
        for (int i = 0; i<x.length; i++){
            x[i] = x[i]*x[i];
            
        }
    }

    // Assignmet 10 - Eliminate Negative Values
    // Given any array x, say [1, 5, 10, -2], write a method that replaces any negative number with the value of 0. When the method is done, x should have no negative values, say [1, 5, 10, 0].
    public void eliminateNegativeValues(int[] x){
        for (int i = 0; i<x.length; i++){
            if(x[i]<0){
                x[i] = 0;
            }
            
        }
    }

    // Assignmet 11 - Max, Min and Average
    // Given any array x, say [1, 5, 10, -2], write a method that returns an array with the maximum number in the array, the minimum value in the array, and the average of the values in the array. The returned array should be three elements long and contain: [MAXNUM, MINNUM, AVG]
    public double[] maxMinAndAverage(int[] x){
        double max = x[0];
        double min = x[0];
        double sum = 0;
        int count = x.length;

        for (int number : x){
            if (number > max){
                max = number;
            }
            if (number < min){
                min = number;
            }
            sum = sum + number;
        }

        double avg = sum/count;
        double[] output ={max, min, avg};
        return output;
    }

    // Assignmet 12 - Shifting the Values in the Array
    // Given any array x, say [1, 5, 10, 7, -2], write a method that shifts each number by one to the front. For example, when the method is done, an x of [1, 5, 10, 7, -2] should become [5, 10, 7, -2, 0]. Notice that the last number is 0. The method does not need to wrap around the values shifted out of bounds.

    public void shiftingTheValuesInTheArray(int[] x){
        for (int i = 0; i<x.length-1; i++){
            x[i] = x[i+1];
        }
        x[x.length-1]=0;
    }

}
