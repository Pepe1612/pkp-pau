package pack;

import java.time.LocalDateTime;

public class Arrival {

    private Train train;
    private LocalDateTime time;

    public Arrival(Train train, LocalDateTime time) {
        this.train = train;
        this.time = time;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public Delay getDelay() {
        return this.train.getDelay();
    }

    @Override
    public String toString() {
        return this.train + "  Date:" + this.time;
    }
}
