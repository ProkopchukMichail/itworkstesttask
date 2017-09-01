package model;


import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Created by comp on 24.08.2017.
 */
@MappedSuperclass
public abstract class BaseGood extends Identification {
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "typeId", nullable = false)
    private Integer typeId;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "country")
    private String country;
    @Column(name = "cost")
    private Double cost;

    public BaseGood(Integer id, String name, Integer typeId, Integer quantity, String country, Double cost) {
        super(id);
        this.name = name;
        this.typeId = typeId;
        this.quantity = quantity;
        this.country = country;
        this.cost = cost;
    }

    public BaseGood() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }
}
