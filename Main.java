import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Currency> currencies = Currency.init();

        System.out.println("Available currencies:");
        for (int i = 0; i < currencies.size(); i++) {
            System.out.println((i + 1) + ". " + currencies.get(i).getName());
        }

        System.out.print("Enter the number of the currency you want to convert from: ");
        int fromCurrencyIndex = scanner.nextInt() - 1;
        Currency fromCurrency = currencies.get(fromCurrencyIndex);

        System.out.print("Enter the number of the currency you want to convert to: ");
        int toCurrencyIndex = scanner.nextInt() - 1;
        Currency toCurrency = currencies.get(toCurrencyIndex);

        System.out.print("Enter the amount you want to convert: ");
        double amount = scanner.nextDouble();

        double exchangeValue = fromCurrency.getExchangeValues().get(toCurrency.getShortName());
        double convertedAmount = Currency.convert(amount, exchangeValue);

        System.out.println(amount + " " + fromCurrency.getName() + " is equal to " + convertedAmount + " " + toCurrency.getName());
    }
}