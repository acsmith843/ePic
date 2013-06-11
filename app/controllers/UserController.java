package controllers;

import com.avaje.ebean.Ebean;
import models.User;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: adamsmith
 * Date: 6/10/13
 */
public class UserController extends Controller {


    //Storing these methods in here for now

    public static Result findUserById(String id) {

        User user = Ebean.find(User.class, id);

        if (user == null) {
            return notFound();
        }

        ObjectMapper mapper = new ObjectMapper();
        return ok(mapper.convertValue(user, JsonNode.class));
    }



    // For scalability purposes, these CRUD operations should probably go in a DAO layer or something

    @BodyParser.Of(BodyParser.Json.class)
    public static Result createUser() {

        User user = null;

        //convert the request to json
        JsonNode json = request().body().asJson();

        ObjectMapper mapper = new ObjectMapper();
        try {
            //map the json onto our entity
            user = mapper.treeToValue(json, User.class);
        } catch (IOException e) {
            return badRequest("Invalid JSON data");
        }

        // Blank out user's ID to prevent an update operation.  And Persist.
//        user.setId(null);
        user.save();

        //return jsonified form of populated user
        return ok(mapper.convertValue(user, JsonNode.class));
    }

    public static Result deleteUser(String id) {

        User user = Ebean.find(User.class, id);

        if (user == null) {
            return notFound();
        }

        user.delete();

        return ok("Successfully deleted user");
    }

}