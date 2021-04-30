package containers;

import pack.Passenger;
import pack.Train;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.TreeSet;

public class PassengersContainer implements IContainer<Passenger>{

    private final Set<Passenger> passengers;
    private final Train train;
    private final int numberOfSeats;
    private int idCounter;

    public PassengersContainer(Train train, int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
        this.train = train;
        passengers = new TreeSet<>();
        idCounter = 1;
    }

    // ticketType=0 - NORMAL
    // ticketType=1 - REDUCED
    public boolean makePassenger(int ticketType,
                                 String firstname,
                                 String surname,
                                 String email,
                                 int phoneNumber
                                 ) {

        Passenger newPassenger = new Passenger(
                ticketType,
                firstname,
                surname,
                email,
                phoneNumber,
                this.idCounter,
                this.train.getId(),
                this.idCounter
        );
        idCounter++;
        return this.add(newPassenger);
    }

    @Override
    public boolean add(Passenger passenger) {
        if(this.passengers.size() < numberOfSeats) {
            return passengers.add(passenger);
        }
        else return false;
    }

    @Override
    public Passenger getById(int wantedId) {
        return passengers.stream()
                .filter(o -> o.getId() == wantedId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Passenger removeById(int wantedId) {
        if(passengers.stream().anyMatch(o -> o.getId() == wantedId)) {
            Passenger passenger = passengers.stream().filter(o -> o.getId() == wantedId).findFirst().orElse(null);
            passengers.remove(passenger);
            return passenger;
        }
        else return null;
    }

    @Override
    public boolean contains(Passenger passenger) {
        return passengers.contains(passenger);
    }
}
