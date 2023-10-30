public class Rider implements Runnable {

    private int rider_num;

    public Rider(int rider_num) {
        this.rider_num = rider_num;
    }

    @Override
    public void run() {
        try {
            System.out.println("Rider " + this.rider_num + " Arrived");
            SenateBus.rider_sem.acquire();

            SenateBus.riders_count_sem.acquire();
            System.out.println("Rider " + this.rider_num + " Waiting");
            SenateBus.riders_count++;
            SenateBus.riders_count_sem.release();

            SenateBus.wait_for_bus_sem.acquire();

            this.gettingonboard();
            SenateBus.rider_sem.release();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void gettingonboard() {
        try {
            SenateBus.riders_count_sem.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        SenateBus.riders_count--;
        System.out.println("Rider " + this.rider_num + " Boarding");
        SenateBus.riders_count_sem.release();

        if (SenateBus.riders_count == 0) {
            SenateBus.ready_to_leave_sem.release();
        }

    }

}
