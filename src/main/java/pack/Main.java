package pack;

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
        Commodity comm1 = new Commodity("Plecak", 3, 25,"Red");
        Commodity comm2 = new Commodity("Walizka", 15,22 ,"Black");
        Commodity comm3 = new Commodity("Torba", 11, 122);

        Train train1 = new Train("Hetman", 120);
        Train train2 = new Train("Matejko", 50);
        System.out.println(train1);
        train1.addCommodity(comm1);
        train1.addCommodity(comm2);
        train1.addCommodity(comm3);
        train1.getCommodity();

        System.out.println(train1.getDelay());
        train1.setDelay(Delay.DELAYED);
        System.out.println(train1.getDelay());

        TrainStation station1 = new TrainStation("Krakow", 1);

        LocalDateTime time1 = LocalDateTime.of(2021,3,26,14,33);
        LocalDateTime time2 = LocalDateTime.of(2021,3,27,17,17);
        LocalDateTime time3 = LocalDateTime.of(2021,3,28,9,29);

        Arrival arrival1 = new Arrival(train1, time1);
        Arrival arrival2 = new Arrival(train2, time2);
        Arrival arrival3 = new Arrival(train1, time3);

        station1.addArrival(arrival1);
        station1.addArrival(arrival2);
        station1.addArrival(arrival3);

        train1.setDelay(Delay.ONTIME);
        station1.getArrivals();
    }
}