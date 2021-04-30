package containers;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import pack.Arrival;
import pack.Train;
import pack.TrainStation;

import java.time.LocalDateTime;

public class ArrivalsContainerTest {

    @Test
    public void addArrivalTest() {
        Train train = new Train("Hetman", 100, 1);
        LocalDateTime arrivalTime = LocalDateTime.of(2021, 5, 26, 14, 33);
        LocalDateTime departureTime = LocalDateTime.of(2021, 5, 26, 14, 50);

        TrainStation trainStation = new TrainStation("Kraków", 10, 1);
        ArrivalsContainer arrivalsContainer = trainStation.getArrivals();

        arrivalsContainer.makeArrival(train, arrivalTime, departureTime);
        Assertions.assertEquals(arrivalsContainer.getById(1), new Arrival(train, arrivalTime, departureTime, 1));
    }

    @Test
    public void addArrivalCorrectIdTest() {
        Train train = new Train("Hetman", 100, 1);
        LocalDateTime arrivalTime1 = LocalDateTime.of(2021, 5, 26, 14, 33);
        LocalDateTime departureTime1 = LocalDateTime.of(2021, 5, 26, 14, 50);
        LocalDateTime arrivalTime2 = LocalDateTime.of(2021, 5, 26, 17, 1);
        LocalDateTime departureTime2 = LocalDateTime.of(2021, 5, 26, 17, 21);

        TrainStation trainStation = new TrainStation("Kraków", 10, 1);
        ArrivalsContainer arrivalsContainer = trainStation.getArrivals();

        arrivalsContainer.makeArrival(train, arrivalTime1, departureTime1);
        arrivalsContainer.makeArrival(train, arrivalTime2, departureTime2);

        Assertions.assertEquals(arrivalsContainer.getById(2), new Arrival(train, arrivalTime2, departureTime2, 2));
    }

    @Test
    public void removeArrivalReturnCorrectValueTest() {
        Train train = new Train("Hetman", 100, 1);
        LocalDateTime arrivalTime1 = LocalDateTime.of(2021, 5, 26, 14, 33);
        LocalDateTime departureTime1 = LocalDateTime.of(2021, 5, 26, 14, 50);
        LocalDateTime arrivalTime2 = LocalDateTime.of(2021, 5, 26, 17, 1);
        LocalDateTime departureTime2 = LocalDateTime.of(2021, 5, 26, 17, 21);

        TrainStation trainStation = new TrainStation("Kraków", 10, 1);
        ArrivalsContainer arrivalsContainer = trainStation.getArrivals();

        arrivalsContainer.makeArrival(train, arrivalTime1, departureTime1);
        arrivalsContainer.makeArrival(train, arrivalTime2, departureTime2);

        Assertions.assertEquals(arrivalsContainer.removeById(2), new Arrival(train, arrivalTime2, departureTime2, 2));
    }

    @Test
    public void containsTest() {
        Train train = new Train("Hetman", 100, 1);
        LocalDateTime arrivalTime = LocalDateTime.of(2021, 5, 26, 14, 33);
        LocalDateTime departureTime = LocalDateTime.of(2021, 5, 26, 14, 50);

        TrainStation trainStation = new TrainStation("Kraków", 10, 1);
        ArrivalsContainer arrivalsContainer = trainStation.getArrivals();

        arrivalsContainer.makeArrival(train, arrivalTime, departureTime);
        Assertions.assertTrue(arrivalsContainer.contains(new Arrival(train, arrivalTime, departureTime, 1)));
    }

    @Test
    public void maxCapacityCaseOneTest() {
        Train train = new Train("Hetman", 100, 1);
        LocalDateTime arrivalTime = LocalDateTime.of(2021, 5, 26, 14, 33);
        LocalDateTime departureTime = LocalDateTime.of(2021, 5, 26, 14, 50);

        TrainStation trainStation = new TrainStation("Kraków", 1, 1);
        ArrivalsContainer arrivalsContainer = trainStation.getArrivals();
        Assertions.assertTrue(arrivalsContainer.makeArrival(train, arrivalTime, departureTime));
    }

    @Test
    public void maxCapacityCaseTwoTest() {
        Train train = new Train("Hetman", 100, 1);
        LocalDateTime arrivalTime1 = LocalDateTime.of(2021, 5, 26, 14, 33);
        LocalDateTime departureTime1 = LocalDateTime.of(2021, 5, 26, 14, 50);
        LocalDateTime arrivalTime2 = LocalDateTime.of(2021, 5, 26, 17, 1);
        LocalDateTime departureTime2 = LocalDateTime.of(2021, 5, 26, 17, 21);

        TrainStation trainStation = new TrainStation("Kraków", 1, 1);
        ArrivalsContainer arrivalsContainer = trainStation.getArrivals();
        arrivalsContainer.makeArrival(train, arrivalTime1, departureTime1);

        Assertions.assertTrue(arrivalsContainer.makeArrival(train, arrivalTime2, departureTime2));
    }

    @Test
    public void maxCapacityCaseThreeTest() {
        Train train = new Train("Hetman", 100, 1);
        LocalDateTime arrivalTime1 = LocalDateTime.of(2021, 5, 26, 14, 33);
        LocalDateTime departureTime1 = LocalDateTime.of(2021, 5, 26, 14, 40);
        LocalDateTime arrivalTime2 = LocalDateTime.of(2021, 5, 26, 14, 40);
        LocalDateTime departureTime2 = LocalDateTime.of(2021, 5, 26, 15, 3);

        TrainStation trainStation = new TrainStation("Kraków", 1, 1);
        ArrivalsContainer arrivalsContainer = trainStation.getArrivals();
        arrivalsContainer.makeArrival(train, arrivalTime1, departureTime1);

        Assertions.assertFalse(arrivalsContainer.makeArrival(train, arrivalTime2, departureTime2));
    }

    @Test
    public void maxCapacityAfterRemoveCaseOneTest() {
        Train train = new Train("Hetman", 100, 1);
        LocalDateTime arrivalTime1 = LocalDateTime.of(2021, 5, 26, 14, 33);
        LocalDateTime departureTime1 = LocalDateTime.of(2021, 5, 26, 14, 40);
        LocalDateTime arrivalTime2 = LocalDateTime.of(2021, 5, 26, 14, 40);
        LocalDateTime departureTime2 = LocalDateTime.of(2021, 5, 26, 15, 3);

        TrainStation trainStation = new TrainStation("Kraków", 1, 1);
        ArrivalsContainer arrivalsContainer = trainStation.getArrivals();
        arrivalsContainer.makeArrival(train, arrivalTime1, departureTime1);
        arrivalsContainer.removeById(1);

        Assertions.assertTrue(arrivalsContainer.makeArrival(train, arrivalTime2, departureTime2));
    }

    @Test
    public void maxCapacityAfterRemoveCaseTwoTest() {
        Train train = new Train("Hetman", 100, 1);
        LocalDateTime arrivalTime1 = LocalDateTime.of(2021, 5, 26, 14, 33);
        LocalDateTime departureTime1 = LocalDateTime.of(2021, 5, 26, 14, 50);
        LocalDateTime arrivalTime2 = LocalDateTime.of(2021, 5, 26, 14, 40);
        LocalDateTime departureTime2 = LocalDateTime.of(2021, 5, 26, 15, 3);

        TrainStation trainStation = new TrainStation("Kraków", 1, 1);
        ArrivalsContainer arrivalsContainer = trainStation.getArrivals();
        arrivalsContainer.makeArrival(train, arrivalTime1, departureTime1);
        arrivalsContainer.removeById(1);

        Assertions.assertTrue(arrivalsContainer.makeArrival(train, arrivalTime2, departureTime2));
    }
}
