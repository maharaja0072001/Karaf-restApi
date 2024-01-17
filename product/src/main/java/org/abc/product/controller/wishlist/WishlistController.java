package org.abc.product.controller.wishlist;

import org.abc.authentication.model.User;
import org.abc.product.model.wishlist.Wishlist;
import org.abc.product.model.product.Product;
import org.abc.product.service.wishlist.impl2.WishlistServiceImpl;
import org.abc.product.service.wishlist.WishlistService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * <p>
 * Handles requests and responses from WishlistView clas and WishlistService class.
 * </p>
 *
 * @author Maharaja S
 * @version 1.0
 */
@Path("/")
public class WishlistController {

    private static WishlistController wishlistController;
    private static final WishlistService WISHLIST_SERVICE = WishlistServiceImpl.getInstance();

    /**
     * <p>
     * Default constructor of the WishlistController class. Kept private to restrict from creating object from outside of this class.
     * </p>
     */
    private WishlistController() {}

    /**
     * <p>
     * Creates a single object of WishlistController Class and returns it.
     * </p>
     *
     * @return returns the single instance of WishlistController Class.
     */
    public static WishlistController getInstance() {
        return wishlistController == null ? wishlistController = new WishlistController() : wishlistController;
    }

    /**
     * <p>
     * Adds the product to the wishlist of the specified user.
     * </p>
     *
     * @param product Refers the product to be added
     * @param user Refers the user
     * @return the wishlist of the user.
     */
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @POST
    public boolean addItem(final Product product, final User user) {
        return WISHLIST_SERVICE.addItem(product, user);
    }

    /**
     * <p>
     * Removes the product from the wishlist of the specified user.
     * </p>
     *
     * @param product Refers the product to be removed.
     * @param user Refers the user
     */
    @Path("/remove")
    @Consumes(MediaType.APPLICATION_JSON)
    @DELETE
    public void removeItem(final Product product, final User user) {
        WISHLIST_SERVICE.removeItem(product, user);
    }

    /**
     * <p>
     * Gets the wishlist of the specified user id and returns it.
     * </p>
     *
     * @param user Refers the user who owns the cart.
     * @return the wishlist of the user.
     */
    @Path("/get")
    @Consumes(MediaType.APPLICATION_JSON)
    @GET
    public Wishlist getWishlist(final User user) {
        return WISHLIST_SERVICE.getWishlist(user);
    }
}
