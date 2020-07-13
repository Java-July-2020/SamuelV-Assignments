public class StringManipulatorTesting {
    public static void main(final String[] args) {
    
    StringManipulator manipulator = new StringManipulator();

    // Test One - trimAndConcat(String, String) Method
    System.out.println("\nExcercise 1 - trimAndConcat(String,String) Method");
    String str = manipulator.trimAndConcat("     Hello    ", "    World    ");
    System.out.println(str); // Should return "HelloWorld"
    
    // Test Two - getIndexOrNull(String, char) Method
    System.out.println("\nExcercise 2 - getIndexOrNull(String, char) Method");
    char letter = 'o';
    Integer a = manipulator.getIndexOrNull("Coding", letter);
    Integer b = manipulator.getIndexOrNull("Hello World", letter);
    Integer c = manipulator.getIndexOrNull("Hi", letter);
    System.out.println(a); // Should return 1
    System.out.println(b); // Should return 4
    System.out.println(c); // Should return null
    
    // Test Three - getIndexOrNull(String, String) Method
    System.out.println("\nExcercise 3 - getIndexOrNull(String, String) Method");  
    String word = "Hello";
    String subString = "llo";
    String notSubString = "world";
    Integer d = manipulator.getIndexOrNull(word, subString);
    Integer e = manipulator.getIndexOrNull(word, notSubString);
    System.out.println(d); // should return 2
    System.out.println(e); // should return null

    // Test Four - concatSubstring(String, int, int, String) Method
    System.out.println("\nExcercise 4 - concatSubstring(String, int, int, String) Method");   
    String anotherWord = manipulator.concatSubstring("Hello", 1, 2, "world");
    System.out.println(anotherWord); // eworld

    }
}