public class Bus implements Runnable{

    private int bus_num;

    public Bus(int bus_num){
        this.bus_num=bus_num;
    }

    @Override
    public void run() {
        try {
            System.out.println("Bus "+this.bus_num+" Arrived!");
            SenateBus.bus_arrival_sem.acquire();
            SenateBus.temp_count = SenateBus.riders_count;
            
            if(SenateBus.riders_count>0){
                System.out.println("Tests1");
                for(int rcount = 0; rcount<= SenateBus.riders_count;rcount++){
                    SenateBus.wait_for_bus_sem.release();
                }
                
            }
            if(SenateBus.riders_count>0){
                SenateBus.ready_to_leave_sem.acquire();
            }

            System.out.println("Tests2");
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
