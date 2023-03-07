import java.util.Locale;

public class Converter {

    public static String getConvertAmount(double amount) {
        if (amount >= 10 && amount <= 20) {
            return String.format(Locale.US, "%.2f рублей", amount);
        }
        int integerDivisionBy10Remainder = (int) amount % 10;
        switch (integerDivisionBy10Remainder) {
            case 1:
                return String.format(Locale.US, "%.2f рубль", amount);
            case 2:
            case 3:
            case 4:
                return String.format(Locale.US, "%.2f рубля", amount);
            default:
                return String.format(Locale.US, "%.2f рублей", amount);
        }
    }
}