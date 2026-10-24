class Ticket {
    String visitorName;
    int age;
    String ticketType;
    double price;

    // Default constructor
    Ticket() {
        visitorName = "Guest";
        age = 0;
        ticketType = "Normal";
        price = 500;
    }

    // Constructor with 2 parameters
    Ticket(String name, int age) {
        this.visitorName = name;
        this.age = age;
        this.ticketType = "Normal";
        this.price = 500;
    }

    // Constructor with all parameters
    Ticket(String name, int age, String type, double price) {
        this.visitorName = name;
        this.age = age;
        this.ticketType = type;
        this.price = price;
    }

    void display() {
        System.out.println("Name: " + visitorName);
        System.out.println("Age: " + age);
        System.out.println("Ticket Type: " + ticketType);
        System.out.println("Price: " + price);
        System.out.println("----------------------");
    }
}

public class Main {
    public static void main(String[] args) {
        // Object creation
        Ticket t1 = new Ticket();
        Ticket t2 = new Ticket("Mukesh", 20);
        Ticket t3 = new Ticket("Rahul", 25, "VIP", 1000);

        t1.display();
        t2.display();
        t3.display();
    }
}