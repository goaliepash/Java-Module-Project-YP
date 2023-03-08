import java.util.Locale;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
    private static final String EXIT_COMMAND = "Завершить";

    private static int personsNumber;

    public static void main(String[] args) {
        inputNumberOfPersons();
        inputProducts();
        System.out.println(Calculator.getNamesOfProducts());
        printAmountPerPerson();
    }

    private static void inputNumberOfPersons() {
        do {
            System.out.print("Количество человек: ");
            if (!isIntegerInputCorrect()) {
                continue;
            }
            personsNumber = scanner.nextInt();
        } while (!isPersonNumberInputCorrect(personsNumber));
    }

    private static void inputProducts() {
        while (true) {
            System.out.print("Наименование товара (если хотите выйти, введите команду \"Завершить\"): ");
            scanner.nextLine();
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase(EXIT_COMMAND)) {
                break;
            }
            System.out.print("Цена товара: ");
            if (!isDoubleInputCorrect()) {
                continue;
            }
            double price = scanner.nextDouble();
            if (!isPriceInputCorrect(price)) {
                continue;
            }
            Product product = new Product(name, price);
            Calculator.addProduct(product);
        }
    }

    private static void printAmountPerPerson() {
        String convertAmount = Converter.getConvertAmount(Calculator.getAmountPerPerson(personsNumber));
        System.out.printf("Счёт за одного человека: %s\n", convertAmount);
    }

    private static boolean isPersonNumberInputCorrect(int personsNumber) {
        if (personsNumber <= 1) {
            System.out.println("Количество человек должно быть больше 1!");
            return false;
        }
        return true;
    }

    private static boolean isPriceInputCorrect(double price) {
        if (price <= 0.0) {
            System.out.println("Цена товара не может быть отрицательной или равняться нулю.");
            return false;
        }
        return true;
    }

    private static boolean isIntegerInputCorrect() {
        if (!scanner.hasNextInt()) {
            System.out.println("Необходимо ввести целое число!");
            scanner.next();
            return false;
        }
        return true;
    }

    private static boolean isDoubleInputCorrect() {
        if (!scanner.hasNextDouble()) {
            System.out.println("Необходимо ввести дробное число!");
            scanner.next();
            return false;
        }
        return true;
    }
}