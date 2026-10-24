import java.util.Scanner;

abstract class Person {
    String name;
    int age;

    void getDetails(String name, int age) {
        this.name = name;
        this.age = age;
    }

    abstract void calculatePrice(int tickets);
}

class Booking extends Person {
    int tickets;
    double price;
    double total;

    void calculatePrice(int tickets) {
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

        System.out.print("Enter Tickets: ");
        int tickets = sc.nextInt();

        b.getDetails(name, age);
        b.calculatePrice(tickets);
        b.display();

        sc.close();
    }
}