package junit_4_18_2;

public class Divider {
    public double divide(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("ゼロで除算はできません");
        }
        return a / b;
    }
}
