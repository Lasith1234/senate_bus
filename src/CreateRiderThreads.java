import java.util.Random;

public class CreateRiderThreads implements Runnable {

    private float mean_interval;
    private int rider_count = 1;
    private static Random random = new Random(0);


    public CreateRiderThreads(float mean_interval) {
        this.mean_interval = mean_interval;
    }

    @Override
    public void run() {

        while (!Thread.currentThread().isInterrupted()) {
            Thread newRider = new Thread(new Rider(rider_count));
            newRider.start();
            this.rider_count++;
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


