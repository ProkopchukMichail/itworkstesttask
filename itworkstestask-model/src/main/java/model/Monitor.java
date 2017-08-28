package model;

import javax.persistence.*;

import static model.Monitor.ALL;
import static model.Monitor.DELETE;


/**
 * Created by comp on 24.08.2017.
 */
@SuppressWarnings("JpaQlInspection")
@NamedQueries({
        @NamedQuery(name = ALL, query = "SELECT c FROM Monitor c ORDER BY c.id"),
        @NamedQuery(name = DELETE, query = "DELETE FROM Monitor c WHERE c.id=:id")
})
@Entity
@Table(name = "monitors")
public class Monitor extends BaseGood {
    public static final String ALL="Monitor.ALL";
    public static final String DELETE="Monitor.DELETE";
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
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
