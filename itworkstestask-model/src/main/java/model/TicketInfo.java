package model;

import javax.persistence.*;

/**
 * Created by comp on 29.08.2017.
 */
@SuppressWarnings("JpaQlInspection")
@NamedQueries({
        @NamedQuery(name = TicketInfo.ALL,query = "SELECT t FROM TicketInfo t WHERE t.ticketId=:ticketId ORDER BY t.id")
})
@Entity
@Table(name = "ticketsinfo")
public class TicketInfo extends Identification{
    public static final String ALL="TicketInfo.ALL";

    @Column(name = "ticketId")
    private Integer ticketId;
    @Column(name = "typeId")
    private Integer typeId;
    @Column(name = "goodId")
    private Integer goodId;
    @Column(name = "name")
    private String name;
    @Column(name = "cost")
    private Double cost;

    public TicketInfo(Integer id, Integer ticketId, Integer typeId, Integer goodId, String name, Double cost) {
        super(id);
        this.ticketId = ticketId;
        this.typeId = typeId;
        this.goodId = goodId;
        this.name = name;
        this.cost = cost;
    }

    public TicketInfo() {
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "TicketInfo{id=" +getId()+
                ", ticketId=" + ticketId +
                ", typeId=" + typeId +
                ", goodId=" + goodId +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                '}';
    }
}
