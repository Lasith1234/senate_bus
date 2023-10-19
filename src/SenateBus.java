import java.util.concurrent.Semaphore;

public class SenateBus {

    public static Semaphore bus_arrival_sem= new Semaphore(1);
    public static Semaphore riders_count_sem = new Semaphore(1);
    public static Semaphore rider_sem = new Semaphore(50);
    public static Semaphore wait_for_bus_sem = new Semaphore(0);
    public static Semaphore ready_to_leave_sem = new Semaphore(0);
    public static int riders_count = 0;

    public static void main(String[] args) {

        int rider_num = 0;
        int bus_num = 0; 

        try {
            while (true) {
                Thread riderThread = new Thread(new Rider(rider_num));
                riderThread.start();
                rider_num++;
                Thread.sleep(30000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            while (true) {
                Thread busThread = new Thread(new Bus(bus_num));
                busThread.start();
                bus_num++;
                Thread.sleep(30000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
