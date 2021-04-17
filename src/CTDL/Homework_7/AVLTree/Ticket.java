package CTDL.Homework_7.AVLTree;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class Ticket implements Comparable {
    private Integer ticketID;
    private String place;

    public Ticket() {
    }

    public Ticket(Integer ticketID) {
        this.ticketID = ticketID;
    }

    public Ticket(Integer ticketID, String place) {
        this.ticketID = ticketID;
        this.place = place;
    }

    public Integer getTicketID() {
        return ticketID;
    }

    public void setTicketID(Integer ticketID) {
        this.ticketID = ticketID;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public int compareTo(Object o) {
        Ticket x = (Ticket) o;
        if (x.getTicketID().equals(this.ticketID)) return 0;
        else {
            if (x.getTicketID() < this.ticketID) return 1;
            else return -1;
        }
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketID=" + ticketID +
                ", place='" + place + '\'' +
                '}';
    }
}
