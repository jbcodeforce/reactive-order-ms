package ibm.gse.eda.api;

import io.quarkus.vertx.web.Route;
import io.vertx.core.http.HttpMethod;
import io.vertx.ext.web.RoutingContext;


public class OrderResource {

    @Route(path = "/orders",methods= HttpMethod.GET)
    public void hello(RoutingContext rc) {
        rc.response().end("hello from reactive route");
    }
}