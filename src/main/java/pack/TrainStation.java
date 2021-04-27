package pack;

import java.util.ArrayList;
import java.util.List;

public class TrainStation {

    private String name;
    private List<Arrival> arrivals;
    private int maxCapacity;
    private int[] hours = new int[24];

    public TrainStation(String name, int maxCapacity) {
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.arrivals = new ArrayList<>(1);
    }

    public void addArrival(Arrival arrival) {
        if(hours[arrival.getTime().getHour()] < this.maxCapacity) {
            arrivals.add(arrival);
            hours[arrival.getTime().getHour()]++;
        } else
            System.err.println("Station " + this.name + " is full!");
    }

    public void getArrivals() {
        for(int i = 0; i< arrivals.size(); i++) {
            if(this.arrivals.get(i).getDelay() == Delay.ONTIME)
                System.out.println("TRAIN" + (i+1) + "." + arrivals.get(i));
            else
                System.out.println("TRAIN" + (i+1) + "." + arrivals.get(i) + "  DELAYED");
        }
    }

    public String getName() {
        return name;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }
}
