package appeng.util;

import java.text.NumberFormat;

public class RoundHelper {

    /**
     * Rounds to n decimal places and removes decimal places if there is a zero after the decimal point
     *
     * @param number Number to round
     * @param n      Decimal places
     * @return String with rounded number
     */
    public static String toRoundedFormattedForm(float number, int n) {
        double roundedNumber = Math.round(number * Math.pow(10, n)) / Math.pow(10, n);
        double precision = 1 / Math.pow(10, n);
        if (roundedNumber < precision) {
            NumberFormat f = NumberFormat.getInstance();
            f.setMaximumFractionDigits(n);
            return "<" + f.format(precision);
        }

        int intNumber = (int) roundedNumber;
        // checks if there is a zero after the decimal point (for example 50 == 50.0)
        if (intNumber == roundedNumber) {
            return NumberFormat.getInstance().format(intNumber);
        }
        NumberFormat f = NumberFormat.getInstance();
        f.setMaximumFractionDigits(n);
        return f.format(roundedNumber);
    }
}
