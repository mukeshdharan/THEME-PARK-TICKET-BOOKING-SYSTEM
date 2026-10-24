import java.util.Scanner;

class Booking {
    private String name;
    private int age;
    private int tickets;
    private double pricePerTicket;
    private double totalAmount;

    // Method overloading
    public void bookTicket(String name, int age) {
        this.name = name;
        this.age = age;
        this.tickets = 1;
        calculatePrice();
    }

    public void bookTicket(String name, int age, int tickets) {
        this.name = name;
        this.age = age;
        this.tickets = tickets;
        calculatePrice();
    }

    // Price calculation based on age
    private void calculatePrice() {
        if (age < 12) {
            pricePerTicket = 200;
        } else if (age < 60) {
            pricePerTicket = 500;
        } else {
            pricePerTicket = 300;
        }

        totalAmount = pricePerTicket * tickets;
    }

    public void display() {
        System.out.println("\n--- Booking Details ---");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Tickets: " + tickets);
        System.out.println("Price per Ticket: " + pricePerTicket);
        System.out.println("Total Amount: " + totalAmount);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Booking b = new Booking();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        System.out.print("Enter number of tickets: ");
        int tickets = sc.nextInt();

        // Method overloading usage
        if (tickets == 1) {
            b.bookTicket(name, age);
        } else {
            b.bookTicket(name, age, tickets);
        }

        b.display();

        sc.close();
    }
}