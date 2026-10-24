
import java.util.Scanner;

class InvalidBookingException extends Exception {
    InvalidBookingException(String message) {
        super(message);
    }
}

class Booking {
    private String name;
    private int age;
    private int tickets;
    private double price;
    private double total;

    public void bookTicket(String name, int age, int tickets)
            throws InvalidBookingException {

        if (age < 0) {
            throw new InvalidBookingException(
                "Age cannot be negative."
            );
        }

        if (tickets <= 0) {
            throw new InvalidBookingException(
                "Number of tickets must be at least 1."
            );
        }

        this.name = name;
        this.age = age;
        this.tickets = tickets;

        if (age < 12) {
            price = 200;
        } else if (age < 60) {
            price = 500;
        } else {
            price = 300;
        }

        total = price * tickets;
    }

    public void display() {
        System.out.println("\n--- Booking Details ---");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Tickets: " + tickets);
        System.out.println("Price per Ticket: Rs." + price);
        System.out.println("Total Amount: Rs." + total);
        System.out.println("Booking Successful!");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter Visitor Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Age: ");
            int age = sc.nextInt();

            System.out.print("Enter Number of Tickets: ");
            int tickets = sc.nextInt();

            Booking b = new Booking();
            b.bookTicket(name, age, tickets);
            b.display();

        } catch (InvalidBookingException e) {
            System.out.println("Booking Failed: " + e.getMessage());

        } catch (java.util.InputMismatchException e) {
            System.out.println("Please enter valid numeric input.");

        } finally {
            sc.close();
        }
    }
}
