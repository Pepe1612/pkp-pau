import containers.TrainStationsContainer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveTrainStationPanel extends JFrame{
    private JPanel mainPanel;
    private JButton button1;
    private JTextField idToRemove;

    public RemoveTrainStationPanel(TrainStationsContainer trainStationsContainer) {

        this.add(mainPanel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trainStationsContainer.removeById(getIdToRemove());
            }
        });
    }

    public int getIdToRemove() {
        return Integer.parseInt(idToRemove.getText());
    }
}
