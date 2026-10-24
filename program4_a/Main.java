import java.util.Scanner;

class Person {
    String name;
    int age;

    void getPersonDetails(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class Booking extends Person {
    int tickets;
    double price;
    double total;

    void bookTickets(int tickets) {
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

    void display() {
        System.out.println("\n--- Booking Details ---");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Tickets: " + tickets);
        System.out.println("Price per Ticket: ₹" + price);
        System.out.println("Total Amount: ₹" + total);
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

        System.out.print("Enter Number of Tickets: ");
        int tickets = sc.nextInt();

        b.getPersonDetails(name, age);
        b.bookTickets(tickets);
        b.display();

        sc.close();
    }
}