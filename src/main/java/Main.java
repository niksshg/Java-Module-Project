import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static ArrayList<Product> products = new ArrayList<>();

    public static void main(String[] args) {
        boolean correctCustomersNumberEntered = false;
        int customers = 0;
        Scanner s = new Scanner(System.in);
        System.out.println("На скольких человек необходимо разделить счёт?");
        do {
            try {
                customers = s.nextInt();
                correctCustomersNumberEntered = true;


            } catch (InputMismatchException e) {
                System.out.println ("Это некорректное значение гостей. Введите корректное количество гостей.");
                s.nextLine();
            }
        } while (!correctCustomersNumberEntered);

        while (customers <= 1) {
            System.out.println("Это некорректное значение для подсчёта.\nВведите корректное количество гостей. Если гостей меньше двух, то расчет не требуется");
            customers = s.nextInt();
        }

       outer:
        while (true) {
            System.out.println("Укажите наименование товара:");
            String product = s.next();
            System.out.println("Укажите стоимость товара в формате 'рубли.копейки' [10.45, 11.40]:");
            double price = 0;
            boolean correctPriceEntered = false;
            do {

                try {
                    price = s.nextDouble();
                    if (price <= 0) {
                        System.out.println("Некорректный ввод.Товар должен быть указан в корректном формате 'рубли.копейки' [10.45, 11.40]");
                        s.nextLine();
                    } else {
                        correctPriceEntered = true;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Товар должен быть указан в корректном формате 'рубли.копейки' [10.45, 11.40]");
                    s.nextLine();
                }
            } while (!correctPriceEntered);

            Product p = new Product(product, price);
            Calculator.addProduct(p);
            products.add(p);


            String enough;
            do {
                System.out.println("Добавить еще товаров в заказ (Да/Нет)?");
                enough = s.next();
                if (enough.equalsIgnoreCase("нет")) {
                    System.out.println("Добавленные товары:");
                    for (int i = 0; i < products.size(); i++) {
                        System.out.println(products.get(i).getLabel());
                    }
                    System.out.println("Каждый поситетль должен заплатить" + " " + Calculator.calculateBill(customers));
                    break outer;
                } else if (enough.equalsIgnoreCase("да")) {
                    break;
                } else {
                    System.out.println("Некорректный ввод");
                }

            } while (true);
        }
    }
}

