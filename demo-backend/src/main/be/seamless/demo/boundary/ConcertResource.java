package be.seamless.demo.boundary;

import be.seamless.demo.control.ConcertService;
import be.seamless.demo.entity.Concert;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collector;


@Path("/concerts")
public class ConcertResource {

    public static final String ACCEPT_ENCODING="application/json;charset=utf-8";
    @Inject
    ConcertService concertService;

    @GET
    @Produces(ConcertResource.ACCEPT_ENCODING)
    public Response listAllConcerts() {

        return Response.ok( this.allAsJson(concertService.getAllConcerts() )).build();
    }

    private JsonArray allAsJson(List<Concert> concerts) {


        Collector<JsonObject, ?, JsonArrayBuilder> jsonCollector
                = Collector.of(Json::createArrayBuilder, JsonArrayBuilder::add,
                (left, right) -> {
                    left.add(right);
                    return left;
                });
        return concerts.stream().map(Concert::toJsonObject).
                collect(jsonCollector).build();

    }
}

