package model;

import javax.persistence.*;
import static model.GoodType.*;
/**
 * Created by comp on 24.08.2017.
 */
@SuppressWarnings("JpaQlInspection")
@NamedQueries({
        @NamedQuery(name = ALL, query = "SELECT g FROM GoodType g ORDER BY g.id")
})
@Entity
@Table(name = "goodTypes")
public class GoodType extends Identification {
    public static final String ALL="GoodType.getAll";
    @Column(name = "typeName")
    private String typeName;

    public GoodType(Integer id, String typeName) {
        super(id);
        this.typeName = typeName;
    }


    public GoodType() {
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "GoodType{id='" +getId()+"', "+
                "typeName='" + typeName + '\'' +
                '}';
    }


    @Override
    public int hashCode() {
        return getTypeName() != null ? getTypeName().hashCode() : 0;
    }
}
