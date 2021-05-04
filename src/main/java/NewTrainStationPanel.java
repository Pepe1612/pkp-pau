import containers.TrainStationsContainer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewTrainStationPanel extends JFrame{
    private JButton addTrainStation;
    private JTextField townName;
    private JTextField maxCapacity;
    private JPanel mainPanel;

    public NewTrainStationPanel(TrainStationsContainer trainStationsContainer) {

        this.add(mainPanel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        addTrainStation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trainStationsContainer.makeTrainStation(getTownName(), getTMaxCapacity());
            }
        });
    }

    public String getTownName() {
        return townName.getText();
    }

    public int getTMaxCapacity() {
        return Integer.parseInt(maxCapacity.getText());
    }
}
