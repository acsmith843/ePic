package models;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created with IntelliJ IDEA.
 * User: adamsmith
 * Date: 6/11/13
 */
@Entity
@Table(name = "THUMB")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Thumbnail extends AbstractEntity {

    private String url;
}
