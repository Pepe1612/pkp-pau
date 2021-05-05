package containers;

import pack.Train;
import pack.TrainStation;
import java.util.Map;
import java.util.TreeMap;

public class TrainStationsContainer implements IContainer<TrainStation> {

    private final Map<Integer, TrainStation> trainStations;
    private int idCounter;

    public TrainStationsContainer() {
        this.trainStations = new TreeMap<>();
        this.idCounter = 1;
    }

    public boolean makeTrainStation(String townName, int maxCapacity) {
        TrainStation newTrainStation = new TrainStation(townName, maxCapacity, idCounter);
        return this.add(newTrainStation);
    }

    @Override
    public boolean add(TrainStation trainStation) {
        if(!trainStations.containsValue(trainStation)) {
            trainStations.put(trainStation.getId(), trainStation);
            idCounter++;
            return true;
        }
        else return false;
    }

    @Override
    public TrainStation getById(int wantedId) {
        return trainStations.get(wantedId);
    }

    @Override
    public TrainStation removeById(int wantedId) {
        return trainStations.remove(wantedId);
    }

    @Override
    public boolean contains(TrainStation object) {
        return trainStations.containsValue(object);
    }

    public boolean contains(int key) {
        return trainStations.containsKey(key);
    }

    public int size() {
        return trainStations.size();
    }

    public int getIdCounter() {
        return idCounter;
    }

    public Map<Integer, TrainStation> getTrainStations() {
        return trainStations;
    }

    @Override
    public String toString() {
        StringBuilder tmp = new StringBuilder();
        for(Map.Entry<Integer, TrainStation> entry : trainStations.entrySet()) {
            tmp.append("ID: ").append(entry.getKey()).append(", Town name: ").append(entry.getValue().getTownName()).append("\n");
        }
        return tmp.toString();
    }
}