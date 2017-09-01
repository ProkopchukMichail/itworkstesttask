package model;

import javax.persistence.*;

import static model.InputDevice.ALL;
import static model.InputDevice.DELETE;


/**
 * Created by comp on 24.08.2017.
 */
@SuppressWarnings("JpaQlInspection")
@NamedQueries({
        @NamedQuery(name = ALL, query = "SELECT i FROM InputDevice i ORDER BY i.id"),
        @NamedQuery(name = DELETE, query = "DELETE FROM InputDevice i WHERE i.id=:id")
})
@Entity
@Table(name = "inputDevices")
public class InputDevice extends BaseGood{
    public static final String ALL="InputDevice.ALL";
    public static final String DELETE="InputDevice.DELETE";
    @Column(name = "color")
    private String color;
    @Column(name = "illumination")
    private boolean illumination;

    public InputDevice(Integer id, String name, Integer typeId, Integer quantity, String country, Double cost, String color, boolean illumination) {
        super(id, name, typeId, quantity, country, cost);
        this.color = color;
        this.illumination = illumination;
    }

    public InputDevice() {
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
        return "InputDevice{id=" +getId()+
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
