package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by comp on 24.08.2017.
 */
@Entity
@Table(name = "input_device")
public class Inputdevice extends BaseGood{
    @Column(name = "color")
    private String color;
    @Column(name = "illumination")
    private boolean illumination;

    public Inputdevice(Integer id, String name, Integer typeId, Integer quantity, String country, Integer cost, String color, boolean illumination) {
        super(id, name, typeId, quantity, country, cost);
        this.color = color;
        this.illumination = illumination;
    }

    public Inputdevice() {
    }

    @Override
    public String toString() {
        return "Inputdevice{id=" +getId()+
                ", name='" + getName() + '\'' +
                ", typeId=" + getTypeId() +
                ", quantity=" + getQuantity() +
                ", country='" + getCountry() + '\'' +
                ", cost=" + getCost() +
                ", color='" + color + '\'' +
                ", illumination=" + illumination +
                '}';
    }
}
