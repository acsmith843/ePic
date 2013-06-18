package models;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: adamsmith
 * Date: 6/10/13
 */
@Entity
@Table(name = "USERS")
@JsonIgnoreProperties(ignoreUnknown = true)
public class User extends AbstractEntity {

    private String name;
    private String eMail;
    private String facebookId;

    @ManyToMany(fetch= FetchType.LAZY, cascade= CascadeType.ALL)
    @OrderBy("created DESC")
    private List<Album> albums;

    public static Finder<Long, User> find = new Finder(Long.class, User.class);

    public static List<User> all() {
        return find.all();
    }

    // Getters / Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }


    public String getFacebookId() {
        return facebookId;
    }

    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
    }

    public List<Album> getAlbums() {

        if (albums == null) {
            albums = new ArrayList<Album>();
        }

        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        User user = (User) o;

        if (albums != null ? !albums.equals(user.albums) : user.albums != null) return false;
        if (eMail != null ? !eMail.equals(user.eMail) : user.eMail != null) return false;
        if (facebookId != null ? !facebookId.equals(user.facebookId) : user.facebookId != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (eMail != null ? eMail.hashCode() : 0);
        result = 31 * result + (facebookId != null ? facebookId.hashCode() : 0);
        result = 31 * result + (albums != null ? albums.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", eMail='" + eMail + '\'' +
                ", facebookId='" + facebookId + '\'' +
                ", albums=" + albums +
                '}';
    }

    //CRUD Operations

}
