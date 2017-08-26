package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by comp on 24.08.2017.
 */
@Entity
@Table(name = "storage_devices")
public class Storagedevice extends BaseGood {
    @Column(name = "brand")
    private String brand;
    @Column(name = "capacity")
    private Integer capacity;

    public Storagedevice(Integer id, String name, Integer typeId, Integer quantity, String country, Integer cost, String brand, Integer capacity) {
        super(id, name, typeId, quantity, country, cost);
        this.brand = brand;
        this.capacity = capacity;
    }

    public Storagedevice() {
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
