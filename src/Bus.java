public class Bus implements Runnable{

    private int bus_num;

    public Bus(int bus_num){
        this.bus_num=bus_num;
    }

    @Override
    public void run() {
        try {
            System.out.println("Bus "+this.bus_num+" Arrived!");
            SenateBus.bus_arrival_sem.wait();

            if(SenateBus.riders_count>0){
                SenateBus.wait_for_bus_sem.release();
                SenateBus.ready_to_leave_sem.wait();
            }

            SenateBus.bus_arrival_sem.release();
            this.depart();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void depart(){
        System.out.println("Bus "+this.bus_num+" Departed!");
    }
    
}
