package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by comp on 24.08.2017.
 */
@Entity
@Table(name = "peripherals")
public class Peripheria extends BaseGood {
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
