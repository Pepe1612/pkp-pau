package containers;

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
        if(!trainStations.containsKey(trainStation.getId())) {
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
}