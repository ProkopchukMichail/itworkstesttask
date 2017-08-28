package model;

import javax.persistence.*;

import static model.Peripheria.ALL;
import static model.Peripheria.DELETE;


/**
 * Created by comp on 24.08.2017.
 */
@SuppressWarnings("JpaQlInspection")
@NamedQueries({
        @NamedQuery(name = ALL, query = "SELECT c FROM Peripheria c ORDER BY c.id"),
        @NamedQuery(name = DELETE, query = "DELETE FROM Peripheria c WHERE c.id=:id")
})
@Entity
@Table(name = "peripherals")
public class Peripheria extends BaseGood {
    public static final String ALL="Peripheria.ALL";
    public static final String DELETE="Peripheria.DELETE";
    @Column(name = "brand")
    private String brand;
    @Column(name = "voltage")
    private Integer voltage;

    public Peripheria(Integer id, String name, Integer typeId, Integer quantity, String country, Integer cost, String brand, Integer voltage) {
        super(id, name, typeId, quantity, country, cost);
        this.brand = brand;
        this.voltage = voltage;
    }

    public Peripheria() {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getVoltage() {
        return voltage;
    }

    public void setVoltage(Integer voltage) {
        this.voltage = voltage;
    }

    @Override
    public String toString() {
        return "Peripheria{id=" +getId()+
                ", name='" + getName() + '\'' +
                ", typeId=" + getTypeId() +
                ", quantity=" + getQuantity() +
                ", country='" + getCountry() + '\'' +
                ", cost=" + getCost() +
                ", brand='" + brand + '\'' +
                ", voltage=" + voltage +
                '}';
    }
}
