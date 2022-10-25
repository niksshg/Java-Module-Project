public class Calculator {

    int numberOfCustomers;
    double bill;
    Product p;

    Calculator(int numberOfCustomers, double bill) {
        this.numberOfCustomers = numberOfCustomers;
        this.bill = bill;
    }

    public void addProduct(Product p) {
        this.bill += p.getPrice();
    }

    public String calculateBill() {
        return correctCurrency(Math.floor(bill / numberOfCustomers));
    }

    public String correctCurrency(double value) {
        int lastValue = (int) value % 10;
        String corretFormat = "";
        switch (lastValue) {
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 0:
                corretFormat = value + " " + "рублей";
                break;
            case 1:
                corretFormat = value + " " + "рубль";
                break;
            case 2:
            case 3:
            case 4:
                corretFormat = value + " " + "рубля";
                break;
        }
        return corretFormat;
    }

}
