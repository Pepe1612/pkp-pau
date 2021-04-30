package pack;

import java.util.Objects;

public class Passenger implements Comparable<Passenger> {

    private TicketType ticketType;
    private String firstname;
    private String surname;
    private String email;
    private int seatNumber;
    private int phoneNumber;
    private final int trainId;
    private final int id;

    public Passenger(
            int ticketType,
            String firstname,
            String surname,
            String email,
            int phoneNumber,
            int seatNumber,
            int trainId,
            int id) {

        this.firstname = firstname;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.seatNumber = seatNumber;
        this.trainId = trainId;
        this.id = id;

        if(ticketType == 0) this.ticketType = TicketType.NORMAL;
        if(ticketType == 1) this.ticketType = TicketType.REDUCED;
    }

    @Override
    public int compareTo(Passenger o) {
        return this.surname.compareTo(o.surname);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passenger passenger = (Passenger) o;
        return phoneNumber == passenger.phoneNumber && trainId == passenger.trainId && Objects.equals(firstname, passenger.firstname) && Objects.equals(surname, passenger.surname) && Objects.equals(email, passenger.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname);
    }

    @Override
    public String toString() {
        return "pack.Passenger{" +
                "firstname='" + firstname + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getFirstname() {
        return firstname;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public int getTrainId() {
        return trainId;
    }

    public int getId() {
        return id;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }
}

enum TicketType {
    NORMAL {
        @Override
        public String toString() {
            return "normal ticket";
        }
    },
    REDUCED {
        @Override
        public String toString() {
            return "reduced ticket";
        }
    }
}
