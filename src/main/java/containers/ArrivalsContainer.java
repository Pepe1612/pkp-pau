package containers;

import pack.Arrival;
import pack.Train;
import pack.TrainStation;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.TreeSet;

public class ArrivalsContainer implements IContainer<Arrival> {

    private final Set<Arrival> arrivals;
    private final TrainStation trainStation;
    private final int[] capacityArray = new int[1440];
    private int idCounter;

    public ArrivalsContainer(TrainStation trainStation) {
        this.arrivals = new TreeSet<>();
        this.trainStation = trainStation;
        this.idCounter = 1;
    }

    public boolean makeArrival(Train train, LocalDateTime arrivalTime, LocalDateTime departureTime) {
        Arrival newArrival = new Arrival(train, arrivalTime, departureTime, idCounter);
        idCounter++;
        return this.add(newArrival);
    }

    @Override
    public boolean add(Arrival arrival) {
        if(capacityController(arrival)) {
            arrivals.add(arrival);
            return true;
        } else return false;
    }

    /*
     * capacityController() returns TRUE if the arrival was successfully added
     * and returns FALSE when trainStation is full
     */
    private boolean capacityController(Arrival newArrival) {
        int[] duration = calculateDuration(newArrival);
        for (int i = duration[0]; i <= duration[1]; i++) {
            if (this.trainStation.getMaxCapacity() <= capacityArray[i]) {
                return false;
            }
        }
        for (int i = duration[0]; i <= duration[1]; i++) {
            capacityArray[i]++;
        }
        return true;
    }

    @Override
    public Arrival getById(int wantedId) {
        return arrivals.stream()
                .filter(o -> o.getId() == wantedId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Arrival removeById(int wantedId) {
        if (arrivals.stream().anyMatch(o -> o.getId() == wantedId)) {
            Arrival arrival = arrivals.stream().filter(o -> o.getId() == wantedId).findFirst().orElse(null);
            updateCapacityArray(arrival);
            arrivals.remove(arrival);
            return arrival;
        } else return null;
    }

    private void updateCapacityArray(Arrival deletedArrival) {
        int[] duration = calculateDuration(deletedArrival);
        for (int i = duration[0]; i <= duration[1]; i++) {
            capacityArray[i]--;
        }
    }

    @Override
    public boolean contains(Arrival arrival) {
        return arrivals.contains(arrival);
    }

    private int[] calculateDuration(Arrival newArrival) {
        LocalDateTime arrivalTime = newArrival.getArrivalTime();
        LocalDateTime departureTime = newArrival.getDepartureTime();
        int start = arrivalTime.getHour() * 60 + arrivalTime.getMinute();
        int stop = departureTime.getHour() * 60 + departureTime.getMinute();
        return new int[]{start,stop};
    }
}
