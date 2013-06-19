package models;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: adamsmith
 * Date: 6/11/13
 */
@Entity
@Table(name = "ALBUMS")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Album extends AbstractEntity {

    private String title;
    private String ownerId;
    private String ownerName;
    private String coverImage;

    @ManyToOne(fetch= FetchType.LAZY, cascade = CascadeType.ALL)
    @OrderBy("created DESC")
    private List<Image> images;

    public static Finder<Long, Album> find = new Finder(Long.class, Album.class);

    public static List<Album> all() {
        return find.all();
    }

    // Getters / Setters

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Album album = (Album) o;

        if (ownerId != null ? !ownerId.equals(album.ownerId) : album.ownerId != null) return false;
        if (ownerName != null ? !ownerName.equals(album.ownerName) : album.ownerName != null) return false;
        if (images != null ? !images.equals(album.images) : album.images != null) return false;
        if (title != null ? !title.equals(album.title) : album.title != null) return false;
        if (coverImage != null ? !coverImage.equals(album.coverImage) : album.coverImage != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (ownerId != null ? ownerId.hashCode() : 0);
        result = 31 * result + (ownerName != null ? ownerName.hashCode() : 0);
        result = 31 * result + (images != null ? images.hashCode() : 0);
        result = 31 * result + (coverImage != null ? coverImage.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Album{" +
                "title='" + title + '\'' +
                ", ownerId='" + ownerId + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", images=" + images +
                ", coverImage=" + coverImage +
                '}';
    }
}
