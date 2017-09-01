package model;

/**
 * Created by comp on 29.08.2017.
 */
public class TicketDTO extends Identification {
    private Integer typeId;
    private Integer amount;

    public TicketDTO(Integer id, Integer typeId, Integer amount) {
        super(id);
        this.typeId = typeId;
        this.amount = amount;
    }

    public TicketDTO() {
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "TicketDTO{id=" +getId()+
                ", typeId=" + typeId +
                ", amount=" + amount +
                '}';
    }
}
