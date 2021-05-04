package pack;

import containers.ArrivalsContainer;

import java.util.Objects;

public class TrainStation implements Comparable<TrainStation>{

    private final ArrivalsContainer arrivalsContainer;
    private String townName;
    private int maxCapacity;
    private final int id;

    public TrainStation(String townName, int maxCapacity, int id) {
        arrivalsContainer = new ArrivalsContainer(this);
        this.townName = townName;
        this.maxCapacity = maxCapacity;
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrainStation that = (TrainStation) o;
        return Objects.equals(townName, that.townName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(townName);
    }

    @Override
    public int compareTo(TrainStation o) {
        return this.getTownName().compareTo(o.getTownName());
    }

    @Override
    public String toString() {
        return "ID:" + id + " - TownName:" + townName;
    }

    public String getTownName() {
        return townName;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public int getId() {
        return id;
    }

    public ArrivalsContainer getArrivals() {
        return arrivalsContainer;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }
}
