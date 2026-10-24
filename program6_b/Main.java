import java.util.Scanner;

interface UserDetails {
    void getUser(String name, int age);
}

interface TicketDetails {
    void getTickets(int tickets);
    void display();
}

class Booking implements UserDetails, TicketDetails {
    String name;
    int age;
    int tickets;
    double price;
    double total;

    public void getUser(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void getTickets(int tickets) {
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
        System.out.println("Price per Ticket: ₹" + price);
        System.out.println("Total Amount: ₹" + total);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TicketDetails t;

        Booking b = new Booking();
        t = b;   

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        System.out.print("Enter Tickets: ");
        int tickets = sc.nextInt();

        b.getUser(name, age);   
        t.getTickets(tickets);  
        t.display();            

        sc.close();
    }
}