package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by comp on 24.08.2017.
 */
@MappedSuperclass
public abstract class Identification implements Serializable {
    @Id
    private Integer id;

    public Identification(Integer id) {
        this.id = id;
    }

    public Identification() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @JsonIgnore
    public boolean isNew() {
        return id == null||id==0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || !getClass().equals(Hibernate.getClass(o))) {
            return false;
        }
        Identification that = (Identification) o;
        return getId() != null && getId().equals(that.getId());
    }
}
