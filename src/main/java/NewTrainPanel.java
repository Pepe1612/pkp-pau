import containers.TrainsContainer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewTrainPanel extends JFrame{

    private JPanel panel1;
    private JButton addTrain;
    private JTextField trainName;
    private JTextField SeatsNumber;

    public NewTrainPanel(TrainsContainer trainsContainer) {
        this.add(panel1);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        addTrain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trainsContainer.makeTrain(getTrainName(), getSeatsNumer());
            }
        });
    }

    public String getTrainName() {
        return trainName.getText();
    }

    public int getSeatsNumer() {
        return Integer.parseInt(SeatsNumber.getText());
    }
}
