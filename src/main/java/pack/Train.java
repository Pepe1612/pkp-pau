package pack;

import containers.PassengersContainer;

import java.util.Objects;

public class Train {

    private String name;
    private PassengersContainer passengers;
    private Delay delay;
    private int id;

    public Train(String name, int numberOfSeats, int id) {
        this.name = name;
        this.passengers = new PassengersContainer(this, numberOfSeats);
        this.delay = Delay.ONTIME;
        this.id = id;
    }

    @Override
    public String toString() {
        return "pack.Train{" + "\n" +
                ", name='" + name +
                ", delay=" + delay +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Train train = (Train) o;
        return Objects.equals(name, train.name) && delay == train.delay;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }

    public PassengersContainer getPassengers() {
        return passengers;
    }

    public Delay getDelay() {
        return delay;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassengers(PassengersContainer passengers) {
        this.passengers = passengers;
    }

    public void setDelay(Delay delay) {
        this.delay = delay;
    }

    public void setId(int id) {
        this.id = id;
    }
}

enum Delay {
    DELAYED {
        @Override
        public String toString() {
            return "Delayed";
        }
    },
    ONTIME {
        @Override
        public String toString() {
            return "On time";
        }
    }
}