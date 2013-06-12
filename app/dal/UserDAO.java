package dal;

import com.avaje.ebean.Ebean;
import models.User;

/**
 * Created with IntelliJ IDEA.
 * User: adamsmith
 * Date: 6/12/13
 */
public class UserDAO {

    public static User getUserByFacebookId(String facebookId) {

        return Ebean.find(User.class).where().eq("facebookId", facebookId).findUnique();

    }
}
