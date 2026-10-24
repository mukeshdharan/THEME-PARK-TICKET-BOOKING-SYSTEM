import java.util.Scanner;

class Person {
    protected String name;
    protected int age;

    void getDetails(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void display() {
        System.out.println("Person Details");
    }
}

class Booking extends Person {
    private int tickets;
    private double price;
    private double total;

    static int bookingCount = 0;

    void bookTicket(int tickets) {
        this.tickets = tickets;
        calculatePrice();
        bookingCount++;
    }

    void bookTicket() {
        this.tickets = 1;
        calculatePrice();
        bookingCount++;
    }

    private void calculatePrice() {
        if (age < 12) {
            price = 200;
        } else if (age < 60) {
            price = 500;
        } else {
            price = 300;
        }
        total = price * tickets;
    }

    @Override
    void display() {
        System.out.println("\n--- Booking Details ---");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Tickets: " + tickets);
        System.out.println("Price per Ticket: ₹" + price);
        System.out.println("Total Amount: ₹" + total);
    }

    static void showBookings() {
        System.out.println("Total Bookings: " + bookingCount);
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

        b.getDetails(name, age);

        if (tickets == 1) {
            b.bookTicket();
        } else {
            b.bookTicket(tickets);
        }

        b.display(); 
        Booking.showBookings();

        sc.close();
    }
}