import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class SenateBus {

    public static Semaphore bus_arrival_sem = new Semaphore(1);
    public static Semaphore riders_count_sem = new Semaphore(1);
    public static Semaphore rider_sem = new Semaphore(50);
    public static Semaphore wait_for_bus_sem = new Semaphore(0);
    public static Semaphore ready_to_leave_sem = new Semaphore(0);
    public static Semaphore leave_sem = new Semaphore(0);
    public static int riders_count = 0;
    public static int temp_count = 0;

    public static void main(String[] args) {

        float rider_arrival_mean_time = 1f * 1000;
        float bus_arrival_mean_time = 1 * 60f * 500;

        // String userInput;
        // Scanner scanner = new Scanner(System.in);

        System.out.println("\n*******  Press any key to exit  *******\n");

        Thread rider_gen = new Thread(new CreateRiderThreads(rider_arrival_mean_time));
        rider_gen.start();

        Thread bus_gen = new Thread(new CreateBusThreads(bus_arrival_mean_time));
        bus_gen.start();

        // while (true) {
        //     userInput = scanner.nextLine();
        //     if (userInput != null) {
        //         System.exit(0);
        //     }
        // }
    }
}
