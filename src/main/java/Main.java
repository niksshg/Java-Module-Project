import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner s = new Scanner(System.in);
    private static int customers;
    private static String product;
    private static double price;
    static Calculator c;
    static ArrayList<Product> products = new ArrayList<>();
    static String enough;

    public static void main(String[] args) {
        System.out.println("На скольких человек необходимо разделить счёт?");
        customers = s.nextInt();
        while (customers <= 1) {
            System.out.println("Это некорректное значение для подсчёта");
            System.out.println("Введите корректное количество гостей. Если гостей меньше двух, то расчет не требуется");
            customers = s.nextInt();
        }
        c = new Calculator(customers, 0);

        outer:
        while (true) {
            System.out.println("Укажите наименование товара:");
            product = s.next();
            System.out.println("Укажите стоимость товара в формате 'рубли.копейки' [10.45, 11.40]:");
            try {
                price = s.nextDouble();
            } catch (Exception e) {
                System.out.println("Товар должен быть указан в корректном формате 'рубли.копейки' [10.45, 11.40]");
                break;
            }
            Product p = new Product(product, price);
            c.addProduct(p);
            products.add(p);

            do {
                System.out.println("Добавить еще товаров в заказ (Да/Нет)?");
                enough = s.next();
                if (enough.equalsIgnoreCase("нет")) {
                    System.out.println("Добавленные товары:");
                    for (int i = 0; i < products.size(); i++) {
                        System.out.println(products.get(i).getLabel());
                    }
                    System.out.println("Каждый поситетль должен заплатить" + " " + c.calculateBill());
                    break outer;
                } else if (enough.equalsIgnoreCase("да")){
                    break;
                }
            } while (!enough.equalsIgnoreCase("нет") || !enough.equalsIgnoreCase("да"));
        }
    }
}

