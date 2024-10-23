package controllers;

import lombok.extern.slf4j.Slf4j;
import play.mvc.*;

@Slf4j
public class HomeController extends Controller {

    public Result index() {
        log.debug("Rendering index page");
        return ok(views.html.index.render());
    }
    
    public Result explore() {
        return ok(views.html.explore.render());
    }
    
    public Result tutorial() {
        return ok(views.html.tutorial.render());
    }

}
