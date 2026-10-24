
import java.util.Scanner;

class BookingThread extends Thread {
    private String name;
    private int tickets;

    BookingThread(String name, int tickets) {
        this.name = name;
        this.tickets = tickets;
    }

    public void run() {
        System.out.println("\nThread class: Booking for " + name);

        for (int i = 1; i <= tickets; i++) {
            System.out.println("Ticket " + i + " booked for " + name);
        }

        System.out.println("Booking completed for " + name);
    }
}

class BookingRunnable implements Runnable {
    private String name;
    private int tickets;

    BookingRunnable(String name, int tickets) {
        this.name = name;
        this.tickets = tickets;
    }

    public void run() {
        System.out.println("\nRunnable interface: Booking for " + name);

        for (int i = 1; i <= tickets; i++) {
            System.out.println("Ticket " + i + " booked for " + name);
        }

        System.out.println("Booking completed for " + name);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first visitor name: ");
        String name1 = sc.nextLine();

        System.out.print("Enter first visitor ticket count: ");
        int tickets1 = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter second visitor name: ");
        String name2 = sc.nextLine();

        System.out.print("Enter second visitor ticket count: ");
        int tickets2 = sc.nextInt();

        if (tickets1 <= 0 || tickets2 <= 0) {
            System.out.println("Ticket count must be positive.");
            sc.close();
            return;
        }

        BookingThread t1 = new BookingThread(name1, tickets1);

        BookingRunnable task =
            new BookingRunnable(name2, tickets2);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Main thread interrupted.");
        }

        System.out.println("\nAll bookings processed.");
        sc.close();
    }
}

