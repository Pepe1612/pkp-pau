package containers;

import pack.Train;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TrainsContainer implements IContainer<Train> {
    private final Map<Integer, Train> trains;
    private int idCounter;

    public TrainsContainer() {
        trains = new HashMap<>();
        idCounter = 1;
    }

    public boolean makeTrain(String name, int numberOfSeats) {
        Train newTrain = new Train(name, numberOfSeats, idCounter);
        return this.add(newTrain);
    }

    @Override
    public boolean add(Train train) {
        if(!trains.containsValue(train)) {
            train.setId(idCounter);
            trains.put(idCounter, train);
            idCounter++;
            return true;
        }
        else return false;
    }

    @Override
    public Train getById(int wantedId) {
        return trains.get(wantedId);
    }

    @Override
    public Train removeById(int wantedId) {
        return trains.remove(wantedId);
    }

    @Override
    public boolean contains(Train object) {
        return trains.containsKey(object.getId());
    }

    @Override
    public String toString() {
        StringBuilder tmp = new StringBuilder();
        for(Map.Entry<Integer, Train> entry : trains.entrySet()) {
            tmp.append("ID: ").append(entry.getKey()).append(", Name: ").append(entry.getValue().getName()).append("\n");
        }
        return tmp.toString();
    }
}