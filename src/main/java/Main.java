import containers.TrainStationsContainer;
import containers.TrainsContainer;

import javax.swing.*;
import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {

        final TrainsContainer trainsContainer = new TrainsContainer();
        final TrainStationsContainer trainStationsContainer = new TrainStationsContainer();

        trainsContainer.makeTrain("Hetman", 100);
        trainsContainer.makeTrain("Lubomirski", 200);
        trainsContainer.makeTrain("Slazak", 150);

        trainStationsContainer.makeTrainStation("Krakow", 5);
        trainStationsContainer.makeTrainStation("Rzeszow", 3);
        trainStationsContainer.makeTrainStation("Warszawa", 10);

        JFrame adminFrame = new JFrame("Admin Panel");
        adminFrame.setContentPane(new AdminMenu(trainsContainer, trainStationsContainer).getMainPanel());
        adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adminFrame.pack();
        adminFrame.setVisible(true);

        LocalDateTime time1 = LocalDateTime.of(2021,3,26,14,33);
        LocalDateTime time2 = LocalDateTime.of(2021,3,27,17,17);
        LocalDateTime time3 = LocalDateTime.of(2021,3,28,9,29);

    }
}