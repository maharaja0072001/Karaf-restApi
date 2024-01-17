package org.abc.product.controller.inventory;

import org.abc.product.ProductCategory;
import org.abc.product.model.product.Product;
import org.abc.product.service.inventory.impl2.InventoryServiceImpl;
import org.abc.product.service.inventory.InventoryService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * <p>
 * Interacts between InventoryView and InventoryService for adding, removing and retrieving products from inventory.
 * </p>
 *
 * @author Maharaja S
 * @version 1.0
 */
@Path("/")
public class InventoryController {

    private static InventoryController inventoryController;
    private static final InventoryService INVENTORY = InventoryServiceImpl.getInstance();

    /**
     * <p>
     * Default constructor of InventoryController class. Kept private to restrict from creating object outside this class.
     * </p>
     */
    private InventoryController() {}

    /**
     * <p>
     * Creates a single object of InventoryController class and returns it.
     * </p>
     *
     * @return the single instance of InventoryController class.
     */
    public static InventoryController getInstance() {
        return inventoryController == null ? inventoryController = new InventoryController() : inventoryController;
    }

    /**
     * <p>
     * Adds the given products to the inventory.
     * </p>
     *
     * @param products the products to be added.
     */
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @POST
    public void addItemToInventory(final List<Product> products) {
        INVENTORY.addItem(products);
    }

    /**
     * <p>
     * Removes the given item from the inventory.
     * </p>
     *
     * @param item the item to be removed.
     */
    @Path("/remove")
    @Consumes(MediaType.APPLICATION_JSON)
    @DELETE
    public void removeItemFromInventory(final Product item) {
        INVENTORY.removeItem(item);
    }

    /**
     * <p>
     * Gets all the products from the inventory based on the category and returns it.
     * </p>
     *
     * @return all the {@link Product} from the inventory.
     */
    @Path("/get")
    @Consumes(MediaType.APPLICATION_JSON)
    @GET
    public List<Product> getItemsByCategory(final ProductCategory productCategory) {
        return INVENTORY.getItemsByCategory(productCategory);
    }
}
