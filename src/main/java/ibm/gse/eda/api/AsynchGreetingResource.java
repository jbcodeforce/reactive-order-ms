package ibm.gse.eda.api;

import javax.inject.Inject;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

import io.smallrye.mutiny.Uni;
import io.vertx.core.json.JsonObject;
import io.vertx.mutiny.core.Vertx;

@Path("/AsynchRS")
public class AsynchGreetingResource {
    
    @Inject
    Vertx vertx;
    
    Jsonb parser = JsonbBuilder.create();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/order/{id}")
    public Uni<Order> getOrderById(@PathParam String id){
        Order o = new Order();
        o.deliveryLocation="Paris/France";
        o.id=id;
        return Uni.createFrom().item(o);
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/json/{id}")
    public Uni<JsonObject> getJsonObject(@PathParam String id){

        JsonObject order = new JsonObject("{\"name\": \"hello you\", \"id\": \"" + id + "\"}");
        return Uni.createFrom().item( order);
    }


}