import java.util.Random;

public class CreateBusThreads implements Runnable {

    private float mean_interval;
    private int bus_count = 1;
    private static Random random = new Random(0);

    public CreateBusThreads(float mean_interval) {
        this.mean_interval = mean_interval;
    }

    @Override
    public void run() {

        while (!Thread.currentThread().isInterrupted()) {
            Thread newBus = new Thread(new Bus(bus_count));
            newBus.start();
            this.bus_count++;
            try {
                Thread.sleep(getExponentiallyDistributedRiderInterArrivalTime());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public long getExponentiallyDistributedRiderInterArrivalTime() {
        float lambda = 1 / mean_interval;
        return Math.round(Math.log(1 - random.nextFloat()) / (-lambda));
    }
    
}
