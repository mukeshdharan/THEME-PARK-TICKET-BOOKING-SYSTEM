
import java.util.Scanner;

class ThemePark {
    private final Object ticketCounter = new Object();
    private final Object paymentCounter = new Object();

    void bookTicket(String name, int tickets) {
        synchronized (ticketCounter) {
            System.out.println(name + " acquired Ticket Counter.");
            System.out.println("Booking " + tickets + " ticket(s)...");

            synchronized (paymentCounter) {
                System.out.println(name + " acquired Payment Counter.");
                System.out.println("Payment completed.");
                System.out.println("Booking successful for " + name);
            }
        }
    }

    void verifyPayment(String name) {
        synchronized (ticketCounter) {
            System.out.println(name + " acquired Ticket Counter.");

            synchronized (paymentCounter) {
                System.out.println("Payment verified for " + name);
            }
        }
    }
}

class BookingThread extends Thread {
    private ThemePark park;
    private String name;
    private int tickets;

    BookingThread(ThemePark park, String name, int tickets) {
        this.park = park;
        this.name = name;
        this.tickets = tickets;
    }

    public void run() {
        park.bookTicket(name, tickets);
    }
}

class PaymentThread extends Thread {
    private ThemePark park;
    private String name;

    PaymentThread(ThemePark park, String name) {
        this.park = park;
        this.name = name;
    }

    public void run() {
        park.verifyPayment(name);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Visitor Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Number of Tickets: ");
        int tickets = sc.nextInt();

        if (tickets <= 0) {
            System.out.println("Invalid number of tickets.");
            sc.close();
            return;
        }

        ThemePark park = new ThemePark();

        BookingThread t1 = new BookingThread(park, name, tickets);
        PaymentThread t2 = new PaymentThread(park, name);

        System.out.println("Thread 1 state: " + t1.getState());
        System.out.println("Thread 2 state: " + t2.getState());

        t1.start();
        t2.start();

        System.out.println("Thread 1 state after start: " + t1.getState());

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread interrupted.");
        }

        System.out.println("Thread 1 final state: " + t1.getState());
        System.out.println("Thread 2 final state: " + t2.getState());
        System.out.println("All operations completed.");

        sc.close();
    }
}
