package controllers;

import play.mvc.Controller;
import play.mvc.Result;

/**
 * Created with IntelliJ IDEA.
 * User: adamsmith
 * Date: 6/10/13
 */
public class StatusController extends Controller {

    public static Result heartbeat() {
        return ok("Up and Running :)");
    }

}
