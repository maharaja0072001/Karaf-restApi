package org.abc.product.model.product;

import org.abc.product.ProductCategory;
import org.abc.product.model.product.Product;

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

    public Laptop(final String brandName, final String model, final float price, final int quantity) {
        super(ProductCategory.LAPTOP, price, brandName, quantity);
        this.model = model;
    }

    public String toString() {
        return String.format("%s : %s - Rs : %.2f", super.getBrandName(), model, super.getPrice());
    }

    @Override
    public boolean equals(final Object object) {
        if (null == object || getClass() != object.getClass()) {
            return false;
        }

        return this.hashCode() == object.hashCode();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBrandName(), model);
    }
}

