package model;


import javax.persistence.*;
import static model.Component.*;

/**
 * Created by comp on 24.08.2017.
 */
@SuppressWarnings("JpaQlInspection")
@NamedQueries({
        @NamedQuery(name = ALL, query = "SELECT c FROM Component c ORDER BY c.id"),
        @NamedQuery(name = DELETE, query = "DELETE FROM Component c WHERE c.id=:id")
})
@Entity
@Table(name = "components")
public class Component extends BaseGood{
    public static final String ALL="Component.ALL";
    public static final String DELETE="Component.DELETE";
    @Column(name = "brand")
    private String brand;
    @Column(name = "weight")
    private Integer weight;

    public Component(Integer id, String name, Integer typeId, Integer quantity, String country, Double cost, String brand, Integer weight) {
        super(id, name, typeId, quantity, country, cost);
        this.brand = brand;
        this.weight = weight;
    }

    public Component() {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Component{id=" +getId()+
                ", name='" + getName() + '\'' +
                ", typeId=" + getTypeId() +
                ", quantity=" + getQuantity() +
                ", country='" + getCountry() + '\'' +
                ", cost=" + getCost() +
                ", brand='" + brand + '\'' +
                ", weight=" + weight +
                '}';
    }

}
