package models;

import com.avaje.ebean.annotation.CreatedTimestamp;
import com.avaje.ebean.annotation.UpdatedTimestamp;
import play.db.ebean.Model;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * User: adamsmith
 * Date: 6/10/13
 */
@MappedSuperclass
public abstract class AbstractEntity extends Model implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @CreatedTimestamp
    private Date created;

    @UpdatedTimestamp
    @Version
    private Date modified;

    public AbstractEntity() {
        this.id = UUID.randomUUID().toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (!(obj instanceof AbstractEntity)) {
            return false;
        }

        AbstractEntity other = (AbstractEntity) obj;
        return getId().equals(other.getId());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public Date getModified() {
        return modified;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "AbstractEntity{" +
                "id='" + id + '\'' +
                ", created=" + created +
                ", modified=" + modified +
                '}';
    }
}
