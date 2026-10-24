
package park;

public class Booking {
    private String name;
    private int age;
    private int tickets;
    private double price;
    private double total;

    public void bookTicket(String name, int age, int tickets) {
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
        System.out.println("\n--- Theme Park Booking ---");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Tickets: " + tickets);
        System.out.println("Price per Ticket: Rs." + price);
        System.out.println("Total Amount: Rs." + total);
    }
}

