public class Calculatrice {
    public static Integer add(Integer a, Integer b) {
        return a + b;
    }

    public static Integer multi(Integer a, Integer b) {
        return a * b;
    }

    public static Integer div(Integer a, Integer b) {
        if (b == 0) {
            throw new IllegalArgumentException("Division by zero is not allowed");
        }
        return a / b;
    }
}
