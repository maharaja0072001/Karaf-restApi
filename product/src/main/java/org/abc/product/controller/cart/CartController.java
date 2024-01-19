package org.abc.product.controller.cart;

import org.abc.product.ProductCategory;
import org.abc.product.model.cart.Cart;
import org.abc.product.service.cart.CartService;
import org.abc.product.service.cart.impl2.CartServiceImpl;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.DELETE;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import java.util.Objects;

/**
 * <p>
 * Interacts between CartView and CartService for adding , removing from the cart of the user.
 * </p>
 *
 * @author Maharaja S
 * @version 1.0
 */
@Path("/")
public class CartController {

    private static CartController cartController;
    private static final CartService CART_SERVICE = CartServiceImpl.getInstance();

    /**
     * <p>
     * Default constructor of the CartController class. Kept private to restrict from creating object from outside of this class.
     * </p>
     */
    private CartController() {}

    /**
     * <p>
     * Creates a single object of CartController Class and returns it.
     * </p>
     *
     * @return returns the single instance of CartController Class.
     */
    public static CartController getInstance() {
        return Objects.isNull(cartController) ? cartController = new CartController() : cartController;
    }

    /**
     * <p>
     * Adds the product to the cart of the specified user.
     * </p>
     *
     * @param productId Refers the id of the product to be added
     * @param userId Refers the user id.
     * @param productCategory Refers the product category.
     * @return true if product added.
     */
    @Path("/add/{userId}/{category}/{productId}")
    @Produces(MediaType.APPLICATION_JSON)
    @POST
    public boolean addItem(@PathParam("productId")final int productId, @PathParam("userId")final int userId,
                           @PathParam("category") final ProductCategory productCategory) {
        return CART_SERVICE.addItem(productId, userId, productCategory);
    }

    /**
     * <p>
     * Removes the product from the cart of the specified user.
     * </p>
     *
     * @param productId Refers the id of the product to be removed.
     * @param userId Refers the user id.
     */
    @Path("/remove/{userId}/{productId}")
    @DELETE
    public void removeItem(@PathParam("productId")final int productId, @PathParam("userId")final int userId) {
        CART_SERVICE.removeItem(productId, userId);
    }

    /**
     * <p>
     * Gets the cart of the specified user id and returns it.
     * </p>
     *
     * @param userId Refers the user id.
     * @return the {@link Cart} of the user.
     */
    @Path("/get/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Cart getCart(@PathParam("userId")final int userId) {
        return CART_SERVICE.getCart(userId);
    }
}



