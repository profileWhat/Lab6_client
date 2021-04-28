package collectionManagementModule;

import java.io.Serializable;

/**
 * Couple Id-Route class
 */
public class CoupleIdRoute implements Serializable {
    private final Long id;
    private final Route route;

    /**
     * Constructor for load id and route
     *
     * @param id    to load to couple
     * @param route to load to route
     */
    public CoupleIdRoute(Long id, Route route) {
        this.id = id;
        this.route = route;
    }

    /**
     * Method for get Id, useless in client, but that method use on server
     * @return Id
     */
    public Long getId() {
        return id;
    }

    /**
     * Method for get Route, useless in client, but that method use on server
     * @return Route
     */
    public Route getRoute() {
        return route;
    }
}
