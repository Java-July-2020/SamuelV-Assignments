public class CalculatorTest {
    public static void main(String[] args){
        Calculator calc = new Calculator();

        // I) Example 1
        System.out.println("\nI) Calculating the following operation: 10.5 + 5.2 x 10 =");
        calc.performOperation(10.5);
        calc.performOperation("+");
        calc.performOperation(5.2);
        calc.performOperation("*");
        calc.performOperation(10.0);
        calc.performOperation("=");
        calc.getResults(); // Should return 62.5

        // I) Example 2
        System.out.println("\nII) Calculating the following operation: 5.0 x 5.0 x 5.0 =");
        calc.performOperation(5.0);
        calc.performOperation("*");
        calc.performOperation(5.0);
        calc.performOperation("*");
        calc.performOperation(5.0);
        calc.performOperation("=");
        calc.getResults(); // Should return 125

        // I) Example 3
        System.out.println("\nIII) Calculating the following operation: 5.0 + 5.0 / 5.0 x 3.0 - 10.0 + 15.0 =");
        calc.performOperation(5.0);
        calc.performOperation("+");
        calc.performOperation(5.0);
        calc.performOperation("/");
        calc.performOperation(5.0);
        calc.performOperation("*");
        calc.performOperation(3.0);
        calc.performOperation("-");
        calc.performOperation(10.0);
        calc.performOperation("+");
        calc.performOperation(15.0);
        calc.performOperation("=");
        calc.getResults(); // Should return 10.3333

        // I) Example 4
        System.out.println("\nIV) Calculating the following operation: 100.0 / 5.0 + 5.0 x 7.0 + 5.0 - 30.0 =");
        calc.performOperation(100.0);
        calc.performOperation("/");
        calc.performOperation(5.0);
        calc.performOperation("+");
        calc.performOperation(5.0);
        calc.performOperation("*");
        calc.performOperation(7.0);
        calc.performOperation("+");
        calc.performOperation(5.0);
        calc.performOperation("-");
        calc.performOperation(30.0);
        calc.performOperation("=");
        calc.getResults(); // Should return 10.3333
    }
    
}