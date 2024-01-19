package org.abc.authentication.controller;

import org.abc.authentication.model.User;
import org.abc.authentication.service.UserService;
import org.abc.authentication.service.impl2.UserServiceImpl;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.DELETE;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import java.util.Objects;

/**
 * <p>
 * Interacts between UserView and UserService for creating new user and getting existing user for login.
 * </p>
 *
 * @author Maharaja S
 * @version 1.0
 */
@Path("/")
public class UserController {

    private static UserController userController;
    private static final UserService USER_SERVICE = UserServiceImpl.getInstance();

    /**
     * <p>
     * Default constructor of UserController class. Kept private to restrict from creating object outside this class.
     * </p>
     */
    private UserController() {}

    /**
     * <p>
     * Creates a single object of UserController class and returns it.
     * </p>
     *
     * @return the single instance of UserController class.
     */
    public static UserController getInstance() {
        return Objects.isNull(userController) ? userController = new UserController() : userController;
    }

    /**
     * <p>
     * Checks if the user already exists, if not then creates a new user.
     * </p>
     *
     * @return true if the user created or false if user already exists.
     * @param user Refers the {@link User}to be created.
     */

    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @POST
    public boolean createUser(final User user) {
        return USER_SERVICE.createUser(user);
    }

    /**
     * <p>
     * Gets the existing user by the given credentials.
     * </p>
     *
     * @param emailIdOrMobileNumber Refers the mobile number or email id of the user
     * @param password Refers the password of the user.
     * @return {@link User} if the credentials are correct and the user exists or null otherwise.
     */
    @Path("/getUser")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public User getUser(@FormParam("username")final String emailIdOrMobileNumber,
                        @FormParam("password")final String password) {
        return USER_SERVICE.getUser(emailIdOrMobileNumber, password);
    }

    /**
     * <p>
     * Updates the details of the user.
     * </p>
     *
     * @param user Refers the current {@link User}.
     */
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @PUT
    public void updateDetails(final User user) {
        USER_SERVICE.updateDetails(user);
    }

    /**
     * <p>
     * Gets the user by id.
     * </p>
     *
     * @param userId Refers the id of the user.
     * @return {@link User}.
     */
    @Path("/getById/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public User getUserById(@PathParam("userId")final int userId) {
        return USER_SERVICE.getUserById(userId);
    }
}
