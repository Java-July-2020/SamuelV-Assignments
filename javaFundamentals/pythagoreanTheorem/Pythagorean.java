// importing the Date class
import java.lang.Math;

public class Pythagorean {
    public double calculateHypotenuse(int legA, int legB) {
        double legC = Math.sqrt(Math.pow(legA,2)+Math.pow(legB,2));
        return legC;
    }
}