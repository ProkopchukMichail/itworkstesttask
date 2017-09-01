package model;

import javax.persistence.*;

import static model.PeripheralDevice.ALL;
import static model.PeripheralDevice.DELETE;


/**
 * Created by comp on 24.08.2017.
 */
@SuppressWarnings("JpaQlInspection")
@NamedQueries({
        @NamedQuery(name = ALL, query = "SELECT c FROM PeripheralDevice c ORDER BY c.id"),
        @NamedQuery(name = DELETE, query = "DELETE FROM PeripheralDevice c WHERE c.id=:id")
})
@Entity
@Table(name = "peripheralDevices")
public class PeripheralDevice extends BaseGood {
    public static final String ALL="PeripheralDevice.ALL";
    public static final String DELETE="PeripheralDevice.DELETE";
    @Column(name = "brand")
    private String brand;
    @Column(name = "voltage")
    private Integer voltage;

    public PeripheralDevice(Integer id, String name, Integer typeId, Integer quantity, String country, Double cost, String brand, Integer voltage) {
        super(id, name, typeId, quantity, country, cost);
        this.brand = brand;
        this.voltage = voltage;
    }

    public PeripheralDevice() {
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
        return "PeripheralDevice{id=" +getId()+
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
