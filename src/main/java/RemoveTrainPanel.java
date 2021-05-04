import containers.TrainsContainer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveTrainPanel extends JFrame {
    private JPanel panel1;
    private JTextField idToRemove;
    private JButton removeTrainButton;

    public RemoveTrainPanel(TrainsContainer trainsContainer) {
        this.add(panel1);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        removeTrainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trainsContainer.removeById(getIdToRemove());
            }
        });
    }

    public int getIdToRemove() {
        return Integer.parseInt(idToRemove.getText());
    }
}
