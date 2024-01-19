package org.abc.product.controller.order;

import org.abc.product.model.order.Order;
import org.abc.product.service.order.impl2.OrderServiceImpl;
import org.abc.product.service.order.OrderService;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.PathParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.core.MediaType;

import java.util.List;
import java.util.Objects;

/**
 * <p>
 * Interacts between OrderView and OrderService for adding , viewing and cancelling orders.
 * </p>
 *
 * @author Maharaja S
 * @version 1.0
 */
@Path("/")
public class OrderController {

    private static OrderController orderController;
    private static final OrderService ORDER_SERVICE = OrderServiceImpl.getInstance();

    /**
     * <p>
     * Default constructor of OrderController class. Kept private to restrict from creating object outside this class.
     * </p>
     */
    private OrderController() {}

    /**
     * <p>
     * Creates a single object of OrderController class and returns it.
     * </p>
     *
     * @return the single instance of OrderController class.
     */
    public static OrderController getInstance() {
        return Objects.isNull(orderController) ? orderController = new OrderController() : orderController;
    }

    /**
     * <p>
     * Gets all the orders placed by the user.
     * </p>
     *
     * @param userId Refers the id of the user
     * @return  all the {@link Order} of the user.
     */
    @Path("/getOrders/{userId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public List<Order> getOrders(@PathParam("userId")final int userId) {
        return ORDER_SERVICE.getOrders(userId);
    }

    /**
     * <p>
     * Adds the order of the user.
     * </p>
     *
     * @param userId Refers the id of the user
     * @param order Refers the {@link Order} to be added.
     */
    @Path("/add/{userId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @POST
    public void addOrder(@PathParam("userId")final int userId, final Order order) {
        ORDER_SERVICE.addOrder(userId, order);
    }

    /**
     * <p>
     * Cancels the order placed by the user.
     * </p>
     *
     * @param order Refers the {@link Order} to be cancelled.
     */
    @Path("/cancel")
    @Consumes(MediaType.APPLICATION_JSON)
    @PATCH
    public void cancelOrder(final Order order) {
        ORDER_SERVICE.cancelOrder(order);
    }

    /**
     * <p>
     * Adds the address of the user.
     * </p>
     *
     * @param userId Refers the id of the user.
     * @param address Refers the address to be added.
     */
    @Path("/addAddress/{userId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @POST
    public void addAddress(@PathParam("userId")final int userId, @FormParam("address")final String address) {
        ORDER_SERVICE.addAddress(userId, address);
    }

    /**
     * <p>
     * Gets all the addresses of the user.
     * </p>
     *
     * @param userId Refers the id of the user.
     * @return the list of all the address.
     */
    @Path("/getAddresses/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public List<String> getAllAddresses(@PathParam("userId")final int userId) {
        return ORDER_SERVICE.getAllAddresses(userId);
    }
}




