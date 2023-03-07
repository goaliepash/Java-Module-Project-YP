import java.util.Locale;

public class Calculator {

    private static double amount;
    private static String namesOfProducts = "";

    public static void addProduct(Product product) {
        amount += product.getPrice();
        namesOfProducts += "\n" + product.getName();
        System.out.printf(
                Locale.US,
                "Товар \"%s\" с ценой \"%.2f\" был успешно добавлен.\n",
                product.getName(),
                product.getPrice()
        );
    }

    public static String getNamesOfProducts() {
        return String.format("Добавленные товары:%s", namesOfProducts);
    }

    public static double getAmountPerPerson(int numberOfPerson) {
        return amount / numberOfPerson;
    }
}