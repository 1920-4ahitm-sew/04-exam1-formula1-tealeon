package at.htl.formula1.entity;

import javax.persistence.*;

/**
 * Formula1 - Driver
 * <p>
 * The id's are  assigned by the database.
 */
@Entity
@Table(name="F1_DRIVER")
@NamedQueries(
        @NamedQuery(
                name="Driver.findDriverIdByName",
                query="select d from Driver d where d.name = :NAME"
        )
)
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    private Team team;

    //region Constructors
    public Driver() {
    }

    public Driver(String name, Team team) {
        this.name = name;
        this.team = team;
    }
    //endregion

    //region Getter and Setter
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
    //endregion


    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", team=" + team +
                '}';
    }
}
