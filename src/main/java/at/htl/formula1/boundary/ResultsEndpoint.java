package at.htl.formula1.boundary;

import at.htl.formula1.entity.Driver;

import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("driver")
public class ResultsEndpoint {

    @PersistenceContext
    EntityManager em;

    /**
     * @param name als QueryParam einzulesen
     * @return JsonObject
     */
    @GET
    @Path("points")
    public JsonObject getPointsSumOfDriver(
            @QueryParam("name") String name
    ) {
        TypedQuery<Driver> query = em
                .createNamedQuery("Driver.findDriverPointsByName", Driver.class)
                .setParameter("NAME", name);
        Driver d = query.getSingleResult();
        return (JsonObject) d;
    }

    /**
     * @param id des Rennens
     * @return
     */
    public Response findWinnerOfRace(long id) {
        return null;
    }


    // Ergänzen Sie Ihre eigenen Methoden ...

}
