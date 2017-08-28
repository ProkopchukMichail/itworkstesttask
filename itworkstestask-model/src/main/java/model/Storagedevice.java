package model;

import javax.persistence.*;

import static model.Storagedevice.ALL;
import static model.Storagedevice.DELETE;


/**
 * Created by comp on 24.08.2017.
 */
@SuppressWarnings("JpaQlInspection")
@NamedQueries({
        @NamedQuery(name = ALL, query = "SELECT c FROM Storagedevice c ORDER BY c.id"),
        @NamedQuery(name = DELETE, query = "DELETE FROM Storagedevice c WHERE c.id=:id")
})
@Entity
@Table(name = "storage_devices")
public class Storagedevice extends BaseGood {
    public static final String ALL="Storagedevice.ALL";
    public static final String DELETE="Storagedevice.DELETE";
    @Column(name = "brand")
    private String brand;
    @Column(name = "capacity")
    private Integer capacity;

    public Storagedevice(Integer id, String name, Integer typeId, Integer quantity, String country, Double cost, String brand, Integer capacity) {
        super(id, name, typeId, quantity, country, cost);
        this.brand = brand;
        this.capacity = capacity;
    }

    public Storagedevice() {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Storagedevice{id=" +getId()+
                ", name='" + getName() + '\'' +
                ", typeId=" + getTypeId() +
                ", quantity=" + getQuantity() +
                ", country='" + getCountry() + '\'' +
                ", cost=" + getCost() +
                ", brand='" + brand + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
