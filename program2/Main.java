class Booking {
    private String visitorName;
    private int tickets;

    static int totalBookings = 0;

    // Method overloading
    public void bookTicket(String name) {
        visitorName = name;
        tickets = 1;
        totalBookings++;
    }

    public void bookTicket(String name, int numTickets) {
        visitorName = name;
        tickets = numTickets;
        totalBookings++;
    }

    public void display() {
        System.out.println("Visitor: " + visitorName);
        System.out.println("Tickets: " + tickets);
        System.out.println("----------------------");
    }

    public static void showTotalBookings() {
        System.out.println("Total Bookings: " + totalBookings);
    }
}

public class Main {
    public static void main(String[] args) {
        Booking b1 = new Booking();
        Booking b2 = new Booking();

        b1.bookTicket("Mukesh");
        b2.bookTicket("Rahul", 3);

        b1.display();
        b2.display();

        Booking.showTotalBookings();
    }
}