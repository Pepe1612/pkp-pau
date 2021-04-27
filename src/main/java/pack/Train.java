package pack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Train implements Comparable<Train>{

    private String name;
    private int numberOfSeats;
    private List<Commodity> commodities;
    private Delay delay;

    public Train(String name, int numberOfSeats) {
        this.name = name;
        this.numberOfSeats = numberOfSeats;
        this.commodities = new ArrayList<>(1);
        delay = Delay.ONTIME;
    }

    public void addCommodity(Commodity comm) {
        commodities.add(comm);
    }

    public void getCommodity() {
        for(int i = 0; i<commodities.size(); i++) {
            System.out.println((i+1) + "." + commodities.get(i));
        }
    }

    public void getSortedAscendingCommodity() {
        commodities.sort(new Comparator<Commodity>() {
            @Override
            public int compare(Commodity o1, Commodity o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        this.getCommodity();
    }

    public void getSortedDescendingCommodity() {
        commodities.sort(new Comparator<Commodity>() {
            @Override
            public int compare(Commodity o1, Commodity o2) {
                return -1 * o1.getName().compareTo(o2.getName());
            }
        });
        this.getCommodity();
    }

    public Commodity getOldestCommodity() {
        Commodity oldest = Collections.max(commodities, new Comparator<Commodity>() {
            @Override
            public int compare(Commodity o1, Commodity o2) {
                return Integer.compare(o1.getAge(), o2.getAge());
            }
        });
        return oldest;
    }

    public void changeCommodity(int numberOfCommodity, int newAmount) {
        this.commodities.get(numberOfCommodity-1).setAmount(newAmount);
        this.delay = Delay.DELAYED;
    }

    public void deleteCommodity() {
        this.commodities.removeAll(commodities);
        this.delay = Delay.DELAYED;
    }

    public boolean findCommodities(String name) {
        for (Commodity commodity : commodities) {
            if (name.equals(commodity.getName())) return true;
        }
        return false;
    }

    public int numberOfCommodities(String name) {
        int counter = 0;
        for (Commodity commodity : commodities) {
            if (commodity.getName().equals(name)) counter++;
        }
        return counter;
    }

    public void setDelay(Delay delay) {
        this.delay = delay;
    }

    public Delay getDelay() {
        return delay;
    }

    @Override
    public int compareTo(Train o) {
        return Integer.compare(this.numberOfSeats, o.numberOfSeats);
    }

    @Override
    public String toString() {
        return "Name:" + this.name;
    }
}

enum Delay {
    DELAYED {
        @Override
        public String toString() {
            return "Delayed";
        }
    },
    ONTIME {
        @Override
        public String toString() {
            return "On time";
        }
    }
}