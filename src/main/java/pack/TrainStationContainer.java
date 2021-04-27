package pack;

import java.util.HashMap;
import java.util.Map;

public class TrainStationContainer {

    Map<String, TrainStation> map;

    public TrainStationContainer() {
        this.map = new HashMap<>();
    }

    public void addTrainStation(TrainStation newStation) {
        map.put(newStation.getName(), newStation);
    }

    public void removeTrainStation(String name) {
        map.remove(name);
    }

    public void printData() {
        for(String trainStation: map.keySet()) {
            System.out.println("STATION: " + map.get(trainStation).getName());
            System.out.println("MAX CAPACITY: " + map.get(trainStation).getMaxCapacity());
        }
    }
}
