
import java.util.Scanner;

class TicketBooking {
    private String name;
    private int tickets;
    private boolean bookingAvailable = false;

    synchronized void bookTicket(String name, int tickets) {
        this.name = name;
        this.tickets = tickets;
        bookingAvailable = true;

        System.out.println("\nBooking created for " + name);

        notifyAll();
    }

    synchronized void processBooking() {
        try {
            while (!bookingAvailable) {
                System.out.println("Waiting for a booking...");
                wait();
            }

            System.out.println("\n--- Processing Booking ---");
            System.out.println("Visitor: " + name);
            System.out.println("Tickets: " + tickets);
            System.out.println("Booking processed successfully!");

            bookingAvailable = false;

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Processing interrupted.");
        }
    }
}

class ProcessingThread extends Thread {
    private TicketBooking booking;

    ProcessingThread(TicketBooking booking) {
        this.booking = booking;
    }

    public void run() {
        booking.processBooking();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TicketBooking booking = new TicketBooking();
        ProcessingThread t = new ProcessingThread(booking);

        t.start();

        System.out.print("Enter Visitor Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Number of Tickets: ");
        int tickets = sc.nextInt();

        if (tickets <= 0) {
            System.out.println("Invalid ticket count.");
            t.interrupt();
            sc.close();
            return;
        }

        booking.bookTicket(name, tickets);

        try {
            t.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Main thread interrupted.");
        }

        sc.close();
    }
}
