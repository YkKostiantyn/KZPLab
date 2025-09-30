package lab4;

/**
 * Class for calculating the expression y = cos(x) /(x + 2 * ctg(x)).
 */
public class ExpressionCalculator {

    /**
     * Calculates the value of the expression y = cos(x) /(x + 2 * ctg(x)).
     *
     * @param x function argument
     * @return value of the function
     * @throws ArithmeticException if division by zero occurs
     */
    public static double calculate(double x) throws ArithmeticException {
        double cot;
        double denominator;

        // Checking for possible zero division in ctg(x)
        if (Math.sin(x) == 0) {
            throw new ArithmeticException("Error: ctg(x) not be in sin(x)=0");
        }

        cot = Math.cos(x) / Math.sin(x);
        denominator = x + 2 * cot;

        if (denominator == 0) {
            throw new ArithmeticException("Error: the denominator is zero");
        }

        return Math.cos(x) / denominator;
    }
}
