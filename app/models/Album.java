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
@Table(name = "ALBUM")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Album extends AbstractEntity {

    private String title;
    private String ownerId;

    @ManyToOne(fetch= FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Thumbnail> thumbs;

    private List<String> accessorFacebookIds;

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


    public List<Thumbnail> getThumbs() {
        return thumbs;
    }

    public void setThumbs(List<Thumbnail> thumbs) {
        this.thumbs = thumbs;
    }

    public List<String> getAccessorFacebookIds() {
        return accessorFacebookIds;
    }

    public void setAccessorFacebookIds(List<String> accessorIds) {
        this.accessorFacebookIds = accessorFacebookIds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Album album = (Album) o;

        if (accessorFacebookIds != null ? !accessorFacebookIds.equals(album.accessorFacebookIds) : album.accessorFacebookIds != null)
            return false;
        if (ownerId != null ? !ownerId.equals(album.ownerId) : album.ownerId != null) return false;
        if (thumbs != null ? !thumbs.equals(album.thumbs) : album.thumbs != null) return false;
        if (title != null ? !title.equals(album.title) : album.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (ownerId != null ? ownerId.hashCode() : 0);
        result = 31 * result + (thumbs != null ? thumbs.hashCode() : 0);
        result = 31 * result + (accessorFacebookIds != null ? accessorFacebookIds.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Album{" +
                "title='" + title + '\'' +
                ", ownerId='" + ownerId + '\'' +
                ", thumbs=" + thumbs +
                ", accessorFacebookIds=" + accessorFacebookIds +
                '}';
    }
}
