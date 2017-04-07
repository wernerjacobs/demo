package be.fgov.mobilit.os.business.person.boundary;


import org.junit.Test;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.assertNotNull;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

;

public class ConcertBoundaryIT {

    public static final int NUMBER_OF_CONCERTS = 3;


    @Test
    public void getConcertsAndVerifySizeAndContainsMuse() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080").path("demo/resources/concerts");

        assertNotNull(target);
        Response response = target.request(MediaType.APPLICATION_JSON).get();
        JsonArray concerts = response.readEntity(JsonArray.class);
        List<JsonObject> concertList = concerts.getValuesAs(JsonObject.class);
        Optional<String> Muse = concertList.stream().map(i -> i.getString("artist")).filter(name -> name.equalsIgnoreCase("Muse")).findAny();
        assertTrue(Muse.isPresent());
        assertThat(Muse.get(), is("Muse"));
        assertEquals(concertList.size(), NUMBER_OF_CONCERTS);
    }


}