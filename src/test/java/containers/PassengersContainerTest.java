package containers;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import pack.Passenger;
import pack.Train;

public class PassengersContainerTest {

    @Test
    public void addPassengerTest() {
        TrainsContainer trainsContainer = new TrainsContainer();
        trainsContainer.makeTrain("Ślązak", 100);
        trainsContainer.getById(1).getPassengers().makePassenger(
                1,
                "Jan",
                "Kowalski",
                "kowal1@gmail.com",
                123123123
        );
        Assertions.assertEquals(
                trainsContainer.getById(1).getPassengers().getById(1),
                new Passenger(
                        1,
                        "Jan",
                        "Kowalski",
                        "kowal1@gmail.com",
                        123123123,
                        1,
                        1,
                        1
                )
        );
    }

    @Test
    public void removePassengerReturnCorrectValueTest() {
        TrainsContainer trainsContainer = new TrainsContainer();
        trainsContainer.makeTrain("Ślązak", 100);
        trainsContainer.getById(1).getPassengers().makePassenger(
                1,
                "Jan",
                "Kowalski",
                "kowal1@gmail.com",
                123123123
        );
        Assertions.assertEquals(
                trainsContainer.getById(1).getPassengers().removeById(1),
                new Passenger(
                        1,
                        "Jan",
                        "Kowalski",
                        "kowal1@gmail.com",
                        123123123,
                        1,
                        1,
                        1
                )
        );
    }

    @Test
    public void containsTest() {
        TrainsContainer trainsContainer = new TrainsContainer();
        trainsContainer.makeTrain("Ślązak", 100);
        trainsContainer.getById(1).getPassengers().makePassenger(
                1,
                "Jan",
                "Nowak",
                "nowak@gmail.com",
                123456789
        );
        Assertions.assertTrue(
                trainsContainer.getById(1).getPassengers().contains(
                        new Passenger(
                                1,
                                "Jan",
                                "Nowak",
                                "nowak@gmail.com",
                                123456789,
                                1,
                                1,
                                1
                        )
                )
        );
    }

    @Test
    public void correctTrainIdTest() {
        TrainsContainer trainsContainer = new TrainsContainer();
        trainsContainer.makeTrain("Ślązak", 100);
        trainsContainer.makeTrain("Lubomirski", 200);
        trainsContainer.getById(2).getPassengers().makePassenger(
                0,
                "Jan",
                "Nowak",
                "nowak@gmail.com",
                123456789
        );
        Passenger passenger = trainsContainer.getById(2).getPassengers().getById(1);
        Assertions.assertEquals(passenger.getTrainId(), 2);
    }
}
