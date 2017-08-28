package model;

import javax.persistence.*;

import static model.Inputdevice.ALL;
import static model.Inputdevice.DELETE;


/**
 * Created by comp on 24.08.2017.
 */
@SuppressWarnings("JpaQlInspection")
@NamedQueries({
        @NamedQuery(name = ALL, query = "SELECT i FROM Inputdevice i ORDER BY i.id"),
        @NamedQuery(name = DELETE, query = "DELETE FROM Inputdevice i WHERE i.id=:id")
})
@Entity
@Table(name = "input_devices")
public class Inputdevice extends BaseGood{
    public static final String ALL="Inputdevice.ALL";
    public static final String DELETE="Inputdevice.DELETE";
    @Column(name = "color")
    private String color;
    @Column(name = "illumination")
    private boolean illumination;

    public Inputdevice(Integer id, String name, Integer typeId, Integer quantity, String country, Double cost, String color, boolean illumination) {
        super(id, name, typeId, quantity, country, cost);
        this.color = color;
        this.illumination = illumination;
    }

    public Inputdevice() {
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isIllumination() {
        return illumination;
    }

    public void setIllumination(boolean illumination) {
        this.illumination = illumination;
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
