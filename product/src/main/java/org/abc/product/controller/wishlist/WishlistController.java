package org.abc.product.controller.wishlist;

import org.abc.product.ProductCategory;
import org.abc.product.model.wishlist.Wishlist;
import org.abc.product.service.wishlist.impl2.WishlistServiceImpl;
import org.abc.product.service.wishlist.WishlistService;

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
        return Objects.isNull(wishlistController) ? wishlistController = new WishlistController() : wishlistController;
    }

    /**
     * <p>
     * Adds the product to the wishlist of the specified user.
     * </p>
     * @param productId Refers the id of the product to be added
     * @param userId Refers the user id.
     * @param productCategory Refers the product category.
     * @return the if product added to the wishlist.
     */
    @Path("/add/{userId}/{category}/{productId}")
    @Produces(MediaType.APPLICATION_JSON)
    @POST
    public boolean addItem(@PathParam("productId")final int productId, @PathParam("userId")final int userId,
                           @PathParam("category") final ProductCategory productCategory) {
        return WISHLIST_SERVICE.addItem(productId, userId, productCategory);
    }

    /**
     * <p>
     * Removes the product from the wishlist of the specified user.
     * </p>
     *
     * @param productId Refers the id of the product to be removed.
     * @param userId Refers the user id.
     */
    @Path("/remove/{userId}/{productId}")
    @DELETE
    public void removeItem(@PathParam("productId")final int productId, @PathParam("userId")final int userId) {
        WISHLIST_SERVICE.removeItem(productId, userId);
    }

    /**
     * <p>
     * Gets the wishlist of the specified user id and returns it.
     * </p>
     *
     * @param userId Refers the user id who owns the cart.
     * @return the {@link Wishlist} of the user.
     */
    @Path("/get/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Wishlist getWishlist(@PathParam("userId")final int userId) {
        return WISHLIST_SERVICE.getWishlist(userId);
    }
}
