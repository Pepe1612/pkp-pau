import containers.TrainStationsContainer;
import containers.TrainsContainer;
import pack.Train;
import pack.TrainStation;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;

public class AdminMenu extends JFrame {
    private TrainsContainer trains;
    private TrainStationsContainer trainStations;

    private JPanel mainPanel;
    private JButton removeTrainButton;
    private JButton addTrainButton;
    private JButton addStationButton;
    private JButton removeStationButton;
    private JButton refreshButton;
    private JTable tableOfStations;
    private JTable tableOfTrains;
    private JButton sortTrainsButton;
    private JButton sortTrainStationsButton;

    private int selectedStationId = -1;
    private int selectedTrainId = -1;

    Object[][] trainTable;
    Object[][] stationTable;

    public AdminMenu(TrainsContainer trains, TrainStationsContainer trainStations) {

        this.trains = trains;
        this.trainStations = trainStations;
        refreshTrainTable();
        refreshTrainStationTable();

        //REFRESH

        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshTrainTable();
                refreshTrainStationTable();
                mainPanel.setVisible(false);
                mainPanel.setVisible(true);
            }
        });

        //TRAINS

        addTrainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NewTrainPanel(trains).setVisible(true);
            }
        });

        removeTrainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedTrainId == -1) {
                    JOptionPane.showMessageDialog(null, "Nie wybrano żadnego pociągu!", "Błąd", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    int confirm = JOptionPane.showConfirmDialog(null, "Czy na pewno chcesz usunąć pociąg?");
                    if (confirm == JOptionPane.YES_OPTION) {
                        trains.removeById(selectedTrainId);
                        refreshTrainTable();
                        refreshTrainStationTable();
                    }
                }
            }
        });

        sortTrainsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Set<Map.Entry<Integer, Train>> tmpSet = trains.getTrains().entrySet();
                List<Map.Entry<Integer, Train>> tmpArrayList = new ArrayList<>(tmpSet);
                tmpArrayList.sort(Comparator.comparingInt(o -> o.getValue().getNumberOfSeats()));
                refreshSortedTrainTable(tmpArrayList);
            }
        });

        //STATIONS

        addStationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NewTrainStationPanel(trainStations).setVisible(true);
            }
        });

        removeStationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedStationId == -1) {
                    JOptionPane.showMessageDialog(null, "Nie wybrano żadnej stacji!", "Błąd", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    int confirm = JOptionPane.showConfirmDialog(null, "Czy na pewno chcesz usunąć stacje?");
                    if (confirm == JOptionPane.YES_OPTION) {
                        trainStations.removeById(selectedStationId);
                        refreshTrainTable();
                        refreshTrainStationTable();
                    }
                }
            }
        });

        sortTrainStationsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Set<Map.Entry<Integer, TrainStation>> tmpSet = trainStations.getTrainStations().entrySet();
                List<Map.Entry<Integer, TrainStation>> tmpArrayList = new ArrayList<>(tmpSet);
                tmpArrayList.sort(Comparator.comparingInt(o -> o.getValue().getMaxCapacity()));
                refreshSortedTrainStationTable(tmpArrayList);
            }
        });

        //MAUSELISTENERS

        tableOfTrains.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    JTable target = (JTable) e.getSource();
                    if (target.getSelectedRow() != -1)
                        selectedTrainId = (int) trainTable[target.getSelectedRow()][0];
                }
            }
        });

        tableOfStations.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    JTable target = (JTable) e.getSource();
                    if (target.getSelectedRow() != -1)
                        selectedStationId = (int) stationTable[target.getSelectedRow()][0];
                }
            }
        });
    }

    private int k;

    public void refreshTrainTable() {
        k = 0;
        trainTable = new Object[trains.size()][3];
        for (int i = 1; i <= trains.getIdCounter(); i++) {
            if (trains.contains(i)) {
                trainTable[k][0] = trains.getById(i).getId();
                trainTable[k][1] = trains.getById(i).getName();
                trainTable[k][2] = trains.getById(i).getNumberOfSeats();
                k++;
            }
        }

        TableModel abstractTrainTable = new AbstractTableModel() {
            @Override
            public int getRowCount() {
                return trains.size();
            }

            @Override
            public int getColumnCount() {
                return 3;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                return trainTable[rowIndex][columnIndex];
            }
        };

        tableOfTrains.setModel(abstractTrainTable);

        tableOfTrains.getColumnModel().getColumn(0).setHeaderValue("ID");
        tableOfTrains.getColumnModel().getColumn(1).setHeaderValue("Nazwa_pociągu");
        tableOfTrains.getColumnModel().getColumn(2).setHeaderValue("Liczba_miejsc");
    }

    public void refreshSortedTrainTable(List<Map.Entry<Integer, Train>> arrayList) {
        k = 0;
        trainTable = new Object[arrayList.size()][3];
        for (int i = 0; i < arrayList.size(); i++) {
            trainTable[i][0] = arrayList.get(i).getValue().getId();
            trainTable[i][1] = arrayList.get(i).getValue().getName();
            trainTable[i][2] = arrayList.get(i).getValue().getNumberOfSeats();
        }

        TableModel abstractTrainTable = new AbstractTableModel() {
            @Override
            public int getRowCount() {
                return arrayList.size();
            }

            @Override
            public int getColumnCount() {
                return 3;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                return trainTable[rowIndex][columnIndex];
            }
        };

        tableOfTrains.setModel(abstractTrainTable);
    }

    public void refreshTrainStationTable() {
        k = 0;
        stationTable = new Object[trainStations.size()][3];
        for (int i = 1; i <= trainStations.getIdCounter(); i++) {
            if (trainStations.contains(i)) {
                stationTable[k][0] = trainStations.getById(i).getId();
                stationTable[k][1] = trainStations.getById(i).getTownName();
                stationTable[k][2] = trainStations.getById(i).getMaxCapacity();
                k++;
            }
        }

        TableModel abstractTrainStationTable = new AbstractTableModel() {
            @Override
            public int getRowCount() {
                return trainStations.size();
            }

            @Override
            public int getColumnCount() {
                return 3;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                return stationTable[rowIndex][columnIndex];
            }
        };

        tableOfStations.setModel(abstractTrainStationTable);

        tableOfStations.getColumnModel().getColumn(0).setHeaderValue("ID");
        tableOfStations.getColumnModel().getColumn(1).setHeaderValue("Nazwa_miasta");
        tableOfStations.getColumnModel().getColumn(2).setHeaderValue("Pojemność");

    }

    public void refreshSortedTrainStationTable(List<Map.Entry<Integer, TrainStation>> arrayList) {
        k = 0;
        stationTable = new Object[arrayList.size()][3];
        for (int i = 0; i < arrayList.size(); i++) {
            stationTable[i][0] = arrayList.get(i).getValue().getId();
            stationTable[i][1] = arrayList.get(i).getValue().getTownName();
            stationTable[i][2] = arrayList.get(i).getValue().getMaxCapacity();
        }

        TableModel abstractTrainTable = new AbstractTableModel() {
            @Override
            public int getRowCount() {
                return arrayList.size();
            }

            @Override
            public int getColumnCount() {
                return 3;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                return stationTable[rowIndex][columnIndex];
            }
        };

        tableOfStations.setModel(abstractTrainTable);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
