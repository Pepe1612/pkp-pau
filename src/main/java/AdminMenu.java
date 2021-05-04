import containers.TrainStationsContainer;
import containers.TrainsContainer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminMenu extends JFrame{
    private TrainsContainer trains;
    private TrainStationsContainer trainStations;

    private JPanel mainPanel;
    private JButton removeTrainButton;
    private JButton addTrainButton;
    private JButton addStationButton;
    private JButton removeStationButton;
    private JTextArea trainsList;
    private JTextArea stationsList;
    private JButton refreshTrainsButton;
    private JButton refreshStationsButton;

    public AdminMenu(TrainsContainer trains, TrainStationsContainer trainStations) {

        this.trains = trains;
        this.trainStations = trainStations;
        refreshTrains();
        refreshStations();

        //TRAINS

        refreshTrainsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshTrains();
            }
        });

        addTrainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NewTrainPanel(trains).setVisible(true);
            }
        });

        removeTrainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RemoveTrainPanel(trains).setVisible(true);
            }
        });

        //STATIONS

        refreshStationsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshStations();
            }
        });

        addStationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NewTrainStationPanel(trainStations).setVisible(true);
            }
        });

        removeStationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RemoveTrainStationPanel(trainStations).setVisible(true);
            }
        });
    }

    public void refreshTrains() {
        trainsList.setText(trains.toString());
    }

    public void refreshStations() {
        stationsList.setText(trainStations.toString());
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
