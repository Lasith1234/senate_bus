import java.util.concurrent.Semaphore;

public class Bus234 implements Runnable {
    private boolean boarding;
    private int riders_count;
    private Semaphore rider_count_incre;
    private Semaphore bus_Semaphore;
    private int bus_num; 

    public Bus234(int bus_num, Semaphore bus_Semaphore){
        this.bus_Semaphore = bus_Semaphore;
        this.boarding = false;
        this.riders_count = 0;
        this.rider_count_incre= new Semaphore(0);
        this.bus_num = bus_num;
    }

    @Override
    public void run() {
        System.out.println("This is bus number "+ bus_num);
        System.out.println("\n");
    }

    public void depart(){
        System.out.println("Leave");
    }
}
