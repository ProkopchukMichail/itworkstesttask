package model;

import javax.persistence.*;
import static model.Goodtype.*;
/**
 * Created by comp on 24.08.2017.
 */
@SuppressWarnings("JpaQlInspection")
@NamedQueries({
        @NamedQuery(name = ALL, query = "SELECT g FROM Goodtype g ORDER BY g.id")
})
@Entity
@Table(name = "goodstypes")
public class Goodtype extends Identification {
    public static final String ALL="Goodtype.getAll";
    @Column(name = "typeName")
    private String typeName;

    public Goodtype(Integer id, String typeName) {
        super(id);
        this.typeName = typeName;
    }

    public Goodtype() {
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "Goodtype{id='" +getId()+"', "+
                "typeName='" + typeName + '\'' +
                '}';
    }


    @Override
    public int hashCode() {
        return getTypeName() != null ? getTypeName().hashCode() : 0;
    }
}
