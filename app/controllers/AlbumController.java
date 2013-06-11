package controllers;

import com.avaje.ebean.Ebean;
import models.Album;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import play.mvc.BodyParser;
import play.mvc.Result;

import java.io.IOException;

import static play.mvc.Controller.request;
import static play.mvc.Results.*;

/**
 * Created with IntelliJ IDEA.
 * User: adamsmith
 * Date: 6/11/13
 */
public class AlbumController {


    //Storing these methods in here for now

    public static Result findAlbum(String id) {

        Album album = Ebean.find(Album.class, id);

        if (album == null) {
            return notFound();
        }

        ObjectMapper mapper = new ObjectMapper();
        return ok(mapper.convertValue(album, JsonNode.class));
    }

    // For scalability purposes, these CRUD operations should probably go in a DAO layer or something

    @BodyParser.Of(BodyParser.Json.class)
    public static Result createAlbum() {

        Album album = null;

        //convert the request to json
        JsonNode json = request().body().asJson();

        ObjectMapper mapper = new ObjectMapper();
        try {
            //map the json onto our entity
            album = mapper.treeToValue(json, Album.class);
        } catch (IOException e) {
            return badRequest("Invalid JSON data");
        }

        // And Persist.
        album.save();

        //return jsonified form of populated user
        return ok(mapper.convertValue(album, JsonNode.class));
    }

    public static Result deleteAlbum(String id) {

        Album album = Ebean.find(Album.class, id);

        if (album == null) {
            return notFound();
        }

        album.delete();

        return ok("Successfully deleted album");
    }

}
