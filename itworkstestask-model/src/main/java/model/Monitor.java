package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by comp on 24.08.2017.
 */
@Entity
@Table(name = "monitors")
public class Monitor extends BaseGood {
    @Column(name = "brand")
    private String brand;
    @Column(name = "size")
    private Integer size;

    public Monitor(Integer id, String name, Integer typeId, Integer quantity, String country, Integer cost, String brand, Integer size) {
        super(id, name, typeId, quantity, country, cost);
        this.brand = brand;
        this.size = size;
    }

    public Monitor() {
    }

    @Override
    public String toString() {
        return "Monitor{id=" +getId()+
                ", name='" + getName() + '\'' +
                ", typeId=" + getTypeId() +
                ", quantity=" + getQuantity() +
                ", country='" + getCountry() + '\'' +
                ", cost=" + getCost() +
                ", brand='" + brand + '\'' +
                ", size=" + size +
                '}';
    }
}
