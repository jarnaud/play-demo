package filters;

import model.User;
import play.libs.typedmap.TypedKey;
import play.mvc.Action;
import play.mvc.Http;
import play.mvc.Result;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

//@Slf4j
public class AdminAction extends Action.Simple {

//    @Inject
//    private SessionService sessionService;

    @Override
    public CompletionStage<Result> call(Http.Request req) {
        // Verify authentication.
        Optional<User> opt = getUser(req);
        if (opt.isEmpty()) {
//            log.info("User is not logged in.");
            return CompletableFuture.completedFuture(redirect("/login"));
        }
        User user = opt.get();
//        if (!sessionService.isAdminUser(user)) {
//            log.warn("User '{}' tried to access admin restricted page: {}", user.getName(), req.uri());
//            return CompletableFuture.completedFuture(notFound("Page not found"));
//        }
        return delegate.call(req.addAttr(AdminAction.Attrs.USER, user));
    }

    public Optional<User> getUser(Http.Request req) {
        // TODO
        return Optional.empty();
    }
//
//    public Optional<UUID> getUserId(Request request) {
//        Optional<User> user = getUser(request);
//        if (user.isEmpty()) {
//            return Optional.empty();
//        }
//        return Optional.of(user.get().getId());
//    }
//
//    /**
//     * Return the logged user, or empty if user is not logged or not existing in database.
//     *
//     * @param request the request.
//     * @return an optional user.
//     */
//    public Optional<User> getUser(Request request) {
//        Optional<String> email = getEmail(request);
//        if (email.isEmpty()) {
//            return Optional.empty();
//        }
//        return mainDbClient.getUserByEmail(email.get());
//    }

    /**
     * Attributes to pass to the controller.
     */
    static class Attrs {
        public static final TypedKey<User> USER = TypedKey.create("user");
    }
}
