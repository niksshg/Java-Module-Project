public class Calculator {

    static double bill;

    public static void addProduct(Product p) {
        bill += p.getPrice();
        System.out.println(bill);
    }

    public static String calculateBill(int numberOfCustomers) {
        return correctCurrency(Math.floor(bill / numberOfCustomers));
    }

    public static String correctCurrency (double value) {
        int twoDigits = (int) value % 100;
        int lastValue = (int) value % 10;
        String correctFormat = value + " ";

        if (String.valueOf(Math.abs((long)twoDigits)).charAt(0) == '1' && twoDigits >= 10 && twoDigits < 20) {
            correctFormat += "рублей";
        } else {
                switch (lastValue) {
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 0:
                        correctFormat += "рублей";
                        break;
                    case 1:
                        correctFormat += "рубль";
                        break;
                    case 2:
                    case 3:
                    case 4:
                        correctFormat += "рубля";
                        break;
                }
            }
            return correctFormat;
    }

}
