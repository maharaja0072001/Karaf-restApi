package org.abc.product.model.product;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.abc.product.ProductCategory;

import java.util.Objects;

/**
 * <p>
 * Represents the model for laptop.
 * </p>
 *
 * @author Maharaja S
 * @version 1.0
 */
public class Laptop extends Product {

    private final String model;

    public String getModel() {
            return model;
    }

    @JsonCreator
    public Laptop(@JsonProperty("brandName")final String brandName,
                  @JsonProperty("model")final String model,
                  @JsonProperty("price")final float price,
                  @JsonProperty("quantity")final int quantity) {
        super(ProductCategory.LAPTOP, price, brandName, quantity);

        this.model = model;
    }

    @Override
    public String toString() {
        return String.format("%s : %s - Rs : %.2f", super.getBrandName(), model, super.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBrandName(), model);
    }
}

