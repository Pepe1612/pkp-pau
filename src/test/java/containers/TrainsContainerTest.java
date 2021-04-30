package containers;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import pack.Train;

public class TrainsContainerTest {

    @Test
    public void addTrainTest() {
        TrainsContainer trainsContainer = new TrainsContainer();
        trainsContainer.makeTrain("Hetman", 32);
        Assertions.assertEquals(
                trainsContainer.getById(1),
                new Train("Hetman", 32, 1)
        );
    }

    @Test
    public void addTrainReturnFalseTest() {
        TrainsContainer trainsContainer = new TrainsContainer();
        trainsContainer.makeTrain("Hetman", 32);
        Assertions.assertFalse(trainsContainer.makeTrain("Hetman", 32));
    }

    @Test
    public void addTrainCorrectIdTest() {
        TrainsContainer trainsContainer = new TrainsContainer();
        trainsContainer.makeTrain("Hetman", 32);
        trainsContainer.makeTrain("Lubomirski", 64);
        Assertions.assertEquals(
                trainsContainer.getById(2),
                new Train("Lubomirski", 64, 2)
        );
    }

    @Test
    public void removeTrainReturnCorrectValueTest() {
        TrainsContainer trainsContainer = new TrainsContainer();
        trainsContainer.makeTrain("Hetman", 32);
        Assertions.assertEquals(trainsContainer.removeById(1), new Train("Hetman", 32, 1));
    }

    @Test
    public void containsCaseOneTest() {
        TrainsContainer trainsContainer = new TrainsContainer();
        trainsContainer.makeTrain("Hetman", 32);
        trainsContainer.removeById(1);
        Assertions.assertFalse(trainsContainer.contains(new Train("Hetman", 32, 1)));
    }

    @Test
    public void containsCaseTwoTest() {
        TrainsContainer trainsContainer = new TrainsContainer();
        trainsContainer.makeTrain("Lubomirski", 64);
        trainsContainer.makeTrain("Hetman", 32);
        trainsContainer.removeById(1);
        Assertions.assertTrue(trainsContainer.contains(new Train("Hetman", 32, 2)));
    }
}
