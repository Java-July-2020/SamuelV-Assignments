
public class FizzBuzzTest{
    public static void main(final String[] args) {
        
        // Test 1
        FizzBuzz aFizzBuzzTest_1 = new FizzBuzz();
        String output_1 = aFizzBuzzTest_1.fizzBuzz(15);
        System.out.println(output_1); // Should return "FizzBuzz"

        // Test 2
        FizzBuzz aFizzBuzzTest_2 = new FizzBuzz();
        String output_2 = aFizzBuzzTest_2.fizzBuzz(9);
        System.out.println(output_2); // Should return "Fizz"

        // Test 3
        FizzBuzz aFizzBuzzTest_3 = new FizzBuzz();
        String output_3 = aFizzBuzzTest_3.fizzBuzz(25);
        System.out.println(output_3); // Should return "Buzz"

        // Test 4
        FizzBuzz aFizzBuzzTest_4 = new FizzBuzz();
        String output_4 = aFizzBuzzTest_4.fizzBuzz(17);
        System.out.println(output_4); // Should return "17"
    }
}