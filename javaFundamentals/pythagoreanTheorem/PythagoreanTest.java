public class PythagoreanTest{
    public static void main(final String[] args) {
        Pythagorean aPythagoreanCalculus = new Pythagorean();
        Double hypotenuse = aPythagoreanCalculus.calculateHypotenuse(3,4); // calculate the hipotenuse of a triangle with leg values 3 and 4
        System.out.println(hypotenuse); // Should return 5
    }
}