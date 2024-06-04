import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Paycheck {
    private String payPeriod;
    private double regularPay;
    private double overtimePay;
    private double bonus;
    private double grossPay;
    private double federalTax;
    private double stateTax;
    private double netPay;

    public Paycheck(String payPeriod, double regularPay, double overtimePay, double bonus,
                    double grossPay, double federalTax, double stateTax, double netPay) {
        this.payPeriod = payPeriod;
        this.regularPay = regularPay;
        this.overtimePay = overtimePay;
        this.bonus = bonus;
        this.grossPay = grossPay;
        this.federalTax = federalTax;
        this.stateTax = stateTax;
        this.netPay = netPay;
    }

    public void displayPaycheck() {
        System.out.println("Pay Period: " + payPeriod);
        System.out.printf("Regular Pay: $%.2f%n", regularPay);
        System.out.printf("Overtime Pay: $%.2f%n", overtimePay);
        System.out.printf("Bonus: $%.2f%n", bonus);
        System.out.printf("Gross Pay: $%.2f%n", grossPay);
        System.out.printf("Federal Tax: $%.2f%n", federalTax);
        System.out.printf("State Tax: $%.2f%n", stateTax);
        System.out.printf("Net Pay: $%.2f%n", netPay);
        System.out.println("-----------------------------");
    }
}

public class MoneyMoney {
    private static List<Paycheck> ledger = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter pay period (or 'q' to quit): ");
            String payPeriod = scanner.nextLine();

            if (payPeriod.equalsIgnoreCase("q")) {
                break;
            }

            System.out.print("Enter regular pay: $");
            double regularPay = scanner.nextDouble();

            System.out.print("Enter overtime pay: $");
            double overtimePay = scanner.nextDouble();

            System.out.print("Enter bonus: $");
            double bonus = scanner.nextDouble();

            System.out.print("Enter gross pay: $");
            double grossPay = scanner.nextDouble();

            System.out.print("Enter federal tax: $");
            double federalTax = scanner.nextDouble();

            System.out.print("Enter state tax: $");
            double stateTax = scanner.nextDouble();

            double netPay = grossPay - federalTax - stateTax;

            Paycheck paycheck = new Paycheck(payPeriod, regularPay, overtimePay, bonus,
                    grossPay, federalTax, stateTax, netPay);

            ledger.add(paycheck);

            scanner.nextLine(); // Consume the remaining newline character
        }

        System.out.println("\nPayroll Ledger:");
        for (Paycheck paycheck : ledger) {
            paycheck.displayPaycheck();
        }

        scanner.close();
    }
}