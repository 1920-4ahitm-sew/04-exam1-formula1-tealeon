package at.htl.formula1.boundary;

import at.htl.formula1.entity.Driver;
import at.htl.formula1.entity.Race;
import at.htl.formula1.entity.Result;

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
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject getPointsSumOfDriver(
            @QueryParam("name") String name
    ) {
        TypedQuery<Driver> query1 = em
                .createNamedQuery("Driver.findDriverIdByName", Driver.class)
                .setParameter("NAME", name);
        Driver d = query1.getSingleResult();
        Long driverId = d.getId();
        TypedQuery<Result> query2 = em
                .createNamedQuery("Result.findDriverPointsById", Result.class)
                .setParameter("DRIVER", driverId);
        Result r = query2.getSingleResult();

        return null;
    }

    /**
     * @param id des Rennens
     * @return
     */
    @GET
    @Path("winner/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String findWinnerOfRace(@PathParam("id") long id) {
        TypedQuery<Race> query = em.createNamedQuery("Race.findRaceById", Race.class)
                .setParameter("ID", id);
        Race r = query.getSingleResult();
        Long raceId=r.getId();

        TypedQuery<String> query2 = em.createNamedQuery("Result.findWinnerById", String.class)
                .setParameter("RACE", raceId);
        String winner = query2.getSingleResult();
        return null;
    }


    // Ergänzen Sie Ihre eigenen Methoden ...

}
