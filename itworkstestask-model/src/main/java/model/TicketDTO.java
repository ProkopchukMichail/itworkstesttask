package model;

/**
 * Created by comp on 29.08.2017.
 */
public class TicketDTO extends Identification {
    private String name;
    private Integer typeId;
    private Integer goodId;
    private Double cost;

    public TicketDTO(Integer id, String name, Integer typeId, Integer goodId, Double cost) {
        super(id);
        this.name = name;
        this.typeId = typeId;
        this.goodId = goodId;
        this.cost = cost;
    }

    public TicketDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }


    @Override
    public String toString() {
        return "TicketDTO{id=" +getId()+
                ", name='" + name + '\'' +
                ", typeId=" + typeId +
                ", goodId=" + goodId +
                ", cost=" + cost +
                '}';
    }
}
