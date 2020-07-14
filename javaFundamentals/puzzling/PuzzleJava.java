import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import javax.swing.JOptionPane;


public class PuzzleJava {

// Method 1
// Create an array with the following values: 3,5,1,2,7,9,8,13,25,32. Print the sum of all numbers in the array. Also have the function return an array that only includes numbers that are greater than 10 (e.g. when you pass the array above, it should return an array with the values of 13,25,32)
public ArrayList<Integer> methodOne(){
    int[] array = {3,5,1,2,7,9,8,13,25,32};
    int sum = 0;
    ArrayList<Integer> output = new ArrayList<Integer>();
    
    for (int number : array){
        sum = sum + number;
        if (number>10){
            output.add(number);
        }
    }
    System.out.println("The sum of the numbers in the array with values 3,5,1,2,7,9,8,13,25,32 is: "+sum);
    return output; 
}

// Method 2
// Create an array with the following values: Nancy, Jinichi, Fujibayashi, Momochi, Ishikawa. Shuffle the array and print the name of each person. Have the method also return an array with names that are longer than 5 characters.
public ArrayList<String> methodTwo(){
    
    String[] array = {"Nancy", "Jinichi", "Fujibayashi", "Momochi", "Ishikawa"};
    ArrayList<String> shuffledArray = new ArrayList<String>(Arrays.asList(array));
    ArrayList<String> output = new ArrayList<String>();

    Collections.shuffle(shuffledArray);
    
    for (String name : shuffledArray){
        System.out.println(name);
        if(name.length() > 5){
            output.add(name);
        }
    }
    return output; 
}

// Method 3
// Create an array that contains all 26 letters of the alphabet (this array must have 26 values). Shuffle the array and, after shuffling, display the last letter from the array. Have it also display the first letter of the array. If the first letter in the array is a vowel, have it display a message.

public void methodThree(){
    
    Character[] alphabet = new Character[26]; // new array
    for(Character ch = 'a'; ch <= 'z'; ++ch){ // fills alphabet array with the alphabet
        alphabet[ch-'a']=ch;
    }
    
    ArrayList<Character> shuffledAlphabet = new ArrayList<Character>(Arrays.asList(alphabet));
   
    Collections.shuffle(shuffledAlphabet);

    Character lastLetter = shuffledAlphabet.get(shuffledAlphabet.size()-1);
    Character firstLetter = shuffledAlphabet.get(0);

    System.out.println("The last letter of the shuffled alphabet is: "+ lastLetter);
    System.out.println("The first letter of the shuffled alphabet is: "+ firstLetter);

    if(firstLetter == 'a' || firstLetter == 'e' || firstLetter == 'i' || firstLetter == 'o' || firstLetter == 'u'){
        JOptionPane.showMessageDialog(null, "The first letter in the shuffled Array is a vowel!!!");
    }

  
}

// Method 4
// Generate and return an array with 10 random numbers between 55-100.

public ArrayList<Integer> methodFour(){

    ArrayList<Integer> output = new ArrayList<Integer>();
    Random r = new Random();
    int randomNumber;

    for (int i = 1; i<=10; i++){
        randomNumber = 55 + r.nextInt(46); // min + Random.nextInt((max-min +1))
        output.add(randomNumber);
    }

    return output; 
}

// Method 5
// Generate and return an array with 10 random numbers between 55-100 and have it be sorted (showing the smallest number in the beginning). Display all the numbers in the array. Next, display the minimum value in the array as well as the maximum value.

public ArrayList<Integer> methodFive(){

    ArrayList<Integer> output = new ArrayList<Integer>();
    Random r = new Random();
    int randomNumber;

    for (int i = 1; i<=10; i++){
        randomNumber = 55 + r.nextInt(46); // min + Random.nextInt((max-min +1))
        output.add(randomNumber);
    }

    Collections.sort(output);

    int min = Collections.min(output);
    int max = Collections.max(output);

    System.out.println("The Min and Max of the array are: " + min + " and " + max + ", respectivetly");

    return output; 
}

// Method 6
// Create a random string that is 5 characters long.

public String methodSix(){

    char[] generatedString = new char[5];
    Random r = new Random();
    int leftLimit = 97; // letter 'a'
    int rightLimit = 122; // letter 'z'
    char randomChar;
    
    for (int i = 0; i<generatedString.length; i++){
        randomChar = (char) (leftLimit + r.nextInt(rightLimit-leftLimit+1)); // min + Random.nextInt((max-min +1))
        generatedString[i] = randomChar;
    }
    
    String output = new String(generatedString); // converting array of chars to String

    return output; 
}

// Method 7
// Generate an array with 10 random strings that are each 5 characters long

public String[] methodSeven(){

    String[] generatedRandomStrings = new String[10];
    for (int i = 0; i<generatedRandomStrings.length; i++){
        generatedRandomStrings[i] = this.methodSix();
    }
    return generatedRandomStrings;
}

}
