package ibm.gse.eda.api;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import io.vertx.reactivex.ext.web.Router;

@ApplicationScoped
public class OrderRoute {

    public void init(@Observes Router router) {
        router.get("/my-route").handler(rc -> rc.response().end("Hello from my route"));
    }
}