
import java.util.Scanner;
import park.Booking;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Visitor Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        System.out.print("Enter Number of Tickets: ");
        int tickets = sc.nextInt();

        if (age < 0 || tickets <= 0) {
            System.out.println("Invalid booking details.");
        } else {
            Booking b = new Booking();
            b.bookTicket(name, age, tickets);
            b.display();
        }

        sc.close();
    }
}

