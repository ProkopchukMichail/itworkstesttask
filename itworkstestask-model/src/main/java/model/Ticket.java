package model;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by comp on 29.08.2017.
 */
@SuppressWarnings("JpaQlInspection")
@NamedQueries({
        @NamedQuery(name = Ticket.ALL,query = "SELECT t FROM Ticket t ORDER BY t.id")
})
@Entity
@Table(name = "tickets")
public class Ticket extends Identification {
    public static final String ALL="Ticket.ALL";

    @Column(name = "dateAndTime")
    private LocalDateTime dateAndTime;
    @Column(name = "summ")
    private Double summ;

    public Ticket(Integer id, LocalDateTime dateAndTime, Double summ) {
        super(id);
        this.dateAndTime = dateAndTime;
        this.summ = summ;
    }

    public Ticket() {
    }

    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(LocalDateTime dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public Double getSumm() {
        return summ;
    }

    public void setSumm(Double summ) {
        this.summ = summ;
    }

    @Override
    public String toString() {
        return "Ticket{id=" +getId()+
                ", dateAndTime=" + dateAndTime +
                ", summ=" + summ +
                '}';
    }
}
