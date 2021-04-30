package containers;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import pack.TrainStation;

public class TrainStationsContainerTest {

    @Test
    public void addTrainStationTest() {
        TrainStationsContainer trainStationsContainer = new TrainStationsContainer();
        trainStationsContainer.makeTrainStation("Kraków", 10);
        Assertions.assertEquals(trainStationsContainer.getById(1), new TrainStation("Kraków", 10, 1));
    }

    @Test
    public void addTrainStationCorrectIdTest() {
        TrainStationsContainer trainStationsContainer = new TrainStationsContainer();
        trainStationsContainer.makeTrainStation("Kraków", 10);
        trainStationsContainer.makeTrainStation("Rzeszów", 5);
        Assertions.assertEquals(trainStationsContainer.getById(2), new TrainStation("Rzeszów", 5, 2));
    }

    @Test
    public void removeTrainStationReturnCorrectValueTest() {
        TrainStationsContainer trainStationsContainer = new TrainStationsContainer();
        trainStationsContainer.makeTrainStation("Rzeszów", 5);
        trainStationsContainer.makeTrainStation("Kraków", 10);
        Assertions.assertEquals(trainStationsContainer.removeById(2), new TrainStation("Kraków", 10, 2));
    }

    @Test
    public void containsCaseOneTest() {
        TrainStationsContainer trainStationsContainer = new TrainStationsContainer();
        trainStationsContainer.makeTrainStation("Rzeszów", 5);
        trainStationsContainer.makeTrainStation("Kraków", 10);
        trainStationsContainer.makeTrainStation("Przeworsk", 3);
        Assertions.assertTrue(trainStationsContainer.contains(new TrainStation("Przeworsk", 3, 3)));
    }
}
